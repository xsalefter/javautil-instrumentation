package org.javautil.oracle;

import oracle.jdbc.OracleConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * References https://docs.oracle.com/cd/B28359_01/server.111/b28320/dynviews_3027.htm#REFRN30232
 * @author jjs
 * https://docs.oracle.com/cd/B28359_01/server.111/b28310/diag006.htm#ADMIN12484
 *
 */
@Component
public class OracleHelper {

	private final static Logger log = LoggerFactory.getLogger(OracleHelper.class);

	public static boolean isOracleConnection(Connection connection) {
		if (connection == null) {
			throw new IllegalArgumentException("connection is null");
		}
		try {
			return connection.isWrapperFor(OracleConnection.class);
		} catch (SQLException e) {
			log.error("Error when checking isOracleConnection: {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void commitNoWait(Connection connection) {
		final String commitBatchNoWaitText = "commit work write batch nowait";
		try {

			PreparedStatement ps = connection.prepareStatement(commitBatchNoWaitText);
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error("Cannot commit because: {}", e);
			throw new RuntimeException(e);
		}
	}

	public static boolean traceOff(OracleConnection connection) {
		boolean success = true;
		if (isOracleConnection(connection)) {
			try (final Statement stmt = connection.createStatement()) {
				stmt.execute("alter session set timed_statistics = false");
				stmt.execute("alter session set sql_trace = false");
			} catch (final SQLException e) {
				if (e.getErrorCode() == 1031) {
					success = false;
					log.warn("no alter session permission 1031" + e.getMessage());
				} else if (e.getErrorCode() == -1031) {
					success = false;
					log.warn("no alter session -1031 " + e.getMessage());
				} else {
					log.error("Error when trace-off: {}", e);
					throw new RuntimeException(e);
				}
			}
		} else {
			log.info("called with non-oracle connection, nothing done");
		}
		return success;
	}

	/**
	 * Turns on detailed oracle tracing.
	 * 	stmt.execute("alter session set timed_statistics = true");
	 *	stmt.execute("alter session set max_dump_file_size = unlimited");
	 *	stmt.execute("alter session set sql_trace = true");				
	 *  stmt.execute("alter session set events '10046 trace name context forever, level 12'");
     *  setTraceFileIdentifier(connection, fileId);
	 * @param connection
	 * @param fileId the name of the trace file to use
	 * @return
	 * @throws SQLException
	 */
	public static boolean traceOn(final Connection connection, final String fileId) throws SQLException {
		boolean success = true;
		if (isOracleConnection(connection)) {
			try (final Statement stmt = connection.createStatement()) {
				stmt.execute("alter session set timed_statistics = true");
				stmt.execute("alter session set max_dump_file_size = unlimited");
				stmt.execute("alter session set sql_trace = true");
				stmt.execute("alter session set events '10046 trace name context forever, level 12'");
				setTraceFileIdentifier(connection, fileId);
			} catch (final SQLException e) {
				if (e.getErrorCode() == 1031) {
					success = false;
					log.warn("no alter session permission 1031" + e.getMessage());
				} else if (e.getErrorCode() == -1031) {
					success = false;
					log.warn("no alter session -1031 " + e.getMessage());
				} else {
					log.error("Error when trace-on: {}", e);
					throw new RuntimeException(e);
				}
			}
		} else {
			success = false;
			log.info("called with non-oracle connection, nothing done");
		}
		return success;
	}

	public static SessionInfo getSessionInfo(OracleConnection connection) {
		SessionInfo sessionInfo = null;
		if (isOracleConnection(connection)) {
			final String text = "select s.sid, s.serial#, p.spid, p.pid from v$session s, v$process p "
					+ " where s.audsid=userenv('sessionid') and p.addr = s.paddr";

			try (final Statement stmt = connection.createStatement()) {
				final ResultSet rset = stmt.executeQuery(text);
				rset.next();

				int sid = rset.getInt("sid");
				int serial = rset.getInt("serial#");
				int spid = rset.getInt("spid");
				int pid = rset.getInt("pid");

				sessionInfo = new SessionInfo(sid, serial, spid, pid);
				log.debug("sid " + sid + " serial " + serial + " spid " + spid + " pid " + pid);

			} catch (final SQLException e) {
				log.error("Error when getSessionInfo() because: {}", e.getMessage());
			}
		} else {
			log.info("not oracle connection, nothing done");
		}
		return sessionInfo;

	}

	public static void setAction(final Connection connection, final String action) {
		if (isOracleConnection(connection)) {
			String text = "{call dbms_application_info.set_action(?)}";
			try (CallableStatement sqlAction = connection.prepareCall(text)) {
				sqlAction.setString(1, action);
				sqlAction.execute();
			} catch (final SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			log.info("not oracle connection, nothing done");
		}
	}

	/**
	 * Registering the application allows system administrators and performance tuning specialists 
	 * to track performance by module. System administrators can also use this information to track 
	 * resource use by module. When an application registers with the database, its name and actions 
	 * are recorded in the V$SESSION and V$SQLAREA views.
	 * 
	 * These can be viewed in V$SESSION 
	 * 
	 * 
	 * @param connection
	 * @param module
	 * @param action
	 */
	public static void setModule(final Connection connection, final String module, final String action) {
		if (isOracleConnection(connection)) {
			String text = module;
			if (text.length() > 48) {
				final int end = text.length() - 1;
				final int begin = end - 48;
				text = module.substring(begin, end);
				log.warn("module trimmed to: '" + text + "' from '" + module);
			}
			final String sqlString = "{call dbms_application_info.set_module(?,?)}";
			try (CallableStatement sqlModule = connection.prepareCall(sqlString)) {
				sqlModule.setString(1, text);
				sqlModule.setString(2, action);
				sqlModule.execute();
			} catch (final SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			log.info("not oracle connection, nothing done");
		}
	}
	
	public static Map<String,Object> getV$Session(Connection connection) throws SQLException {
		String sql  = 
				"select \n" + 
				"	s.SADDR,\n" + 
				"	s.SID,\n" + 
				"	s.SERIAL#,\n" + 
				"	s.AUDSID,\n" + 
				"	s.PADDR,\n" + 
				"	s.USER#,\n" + 
				"	s.USERNAME,\n" + 
				"	s.COMMAND,\n" + 
				"	s.OWNERID,\n" + 
				"	s.TADDR,\n" + 
				"	s.LOCKWAIT,\n" + 
				"	s.STATUS,\n" + 
				"	s.SERVER,\n" + 
				"	s.SCHEMA#,\n" + 
				"	s.SCHEMANAME,\n" + 
				"	s.OSUSER,\n" + 
				"	s.PROCESS,\n" + 
				"	s.MACHINE,\n" + 
				"	s.PORT,\n" + 
				"	s.TERMINAL,\n" + 
				"	s.PROGRAM,\n" + 
				"	s.TYPE,\n" + 
				"	s.SQL_ADDRESS,\n" + 
				"	s.SQL_HASH_VALUE,\n" + 
				"	s.SQL_ID,\n" + 
				"	s.SQL_CHILD_NUMBER,\n" + 
				"	s.SQL_EXEC_START,\n" + 
				"	s.SQL_EXEC_ID,\n" + 
				"	s.PREV_SQL_ADDR,\n" + 
				"	s.PREV_HASH_VALUE,\n" + 
				"	s.PREV_SQL_ID,\n" + 
				"	s.PREV_CHILD_NUMBER,\n" + 
				"	s.PREV_EXEC_START,\n" + 
				"	s.PREV_EXEC_ID,\n" + 
				"	s.PLSQL_ENTRY_OBJECT_ID,\n" + 
				"	s.PLSQL_ENTRY_SUBPROGRAM_ID,\n" + 
				"	s.PLSQL_OBJECT_ID,\n" + 
				"	s.PLSQL_SUBPROGRAM_ID,\n" + 
				"	s.MODULE,\n" + 
				"	s.MODULE_HASH,\n" + 
				"	s.ACTION,\n" + 
				"	s.ACTION_HASH,\n" + 
				"	s.CLIENT_INFO,\n" + 
				"	s.FIXED_TABLE_SEQUENCE,\n" + 
				"	s.ROW_WAIT_OBJ#,\n" + 
				"	s.ROW_WAIT_FILE#,\n" + 
				"	s.ROW_WAIT_BLOCK#,\n" + 
				"	s.ROW_WAIT_ROW#,\n" + 
				"	s.TOP_LEVEL_CALL#,\n" + 
				"	s.LOGON_TIME,\n" + 
				"	s.LAST_CALL_ET,\n" + 
				"	s.PDML_ENABLED,\n" + 
				"	s.FAILOVER_TYPE,\n" + 
				"	s.FAILOVER_METHOD,\n" + 
				"	s.FAILED_OVER,\n" + 
				"	s.RESOURCE_CONSUMER_GROUP,\n" + 
				"	s.PDML_STATUS,\n" + 
				"	s.PDDL_STATUS,\n" + 
				"	s.PQ_STATUS,\n" + 
				"	s.CURRENT_QUEUE_DURATION,\n" + 
				"	s.CLIENT_IDENTIFIER,\n" + 
				"	s.BLOCKING_SESSION_STATUS,\n" + 
				"	s.BLOCKING_INSTANCE,\n" + 
				"	s.BLOCKING_SESSION,\n" + 
				"	s.FINAL_BLOCKING_SESSION_STATUS,\n" + 
				"	s.FINAL_BLOCKING_INSTANCE,\n" + 
				"	s.FINAL_BLOCKING_SESSION,\n" + 
				"	s.SEQ#,\n" + 
				"	s.EVENT#,\n" + 
				"	s.EVENT,\n" + 
				"	s.P1TEXT,\n" + 
				"	s.P1,\n" + 
				"	s.P1RAW,\n" + 
				"	s.P2TEXT,\n" + 
				"	s.P2,\n" + 
				"	s.P2RAW,\n" + 
				"	s.P3TEXT,\n" + 
				"	s.P3,\n" + 
				"	s.P3RAW,\n" + 
				"	s.WAIT_CLASS_ID,\n" + 
				"	s.WAIT_CLASS#,\n" + 
				"	s.WAIT_CLASS,\n" + 
				"	s.WAIT_TIME,\n" + 
				"	s.SECONDS_IN_WAIT,\n" + 
				"	s.STATE,\n" + 
				"	s.WAIT_TIME_MICRO,\n" + 
				"	s.TIME_REMAINING_MICRO,\n" + 
				"	s.TIME_SINCE_LAST_WAIT_MICRO,\n" + 
				"	s.SERVICE_NAME,\n" + 
				"	s.SQL_TRACE,\n" + 
				"	s.SQL_TRACE_WAITS,\n" + 
				"	s.SQL_TRACE_BINDS,\n" + 
				"	s.SQL_TRACE_PLAN_STATS,\n" + 
				"	s.SESSION_EDITION_ID,\n" + 
				"	s.CREATOR_ADDR,\n" + 
				"	s.CREATOR_SERIAL#,\n" + 
				"	s.ECID,\n" + 
				"	s.SQL_TRANSLATION_PROFILE_ID,\n" + 
				"	s.PGA_TUNABLE_MEM,\n" + 
				"	s.SHARD_DDL_STATUS,\n" + 
				"	s.CON_ID,\n" + 
				"	s.EXTERNAL_NAME,\n" + 
				"	s.PLSQL_DEBUGGER_CONNECTED,\n" + 
				"	p.ADDR,\n" + 
				"	p.PID,\n" + 
				"	p.SOSID,\n" + 
				"	p.SPID,\n" + 
				"	p.STID,\n" + 
				"	p.EXECUTION_TYPE,\n" + 
				"	p.PNAME,\n" + 
				"	p.USERNAME p_username,\n" + 
				"	p.SERIAL# p_serial#,\n" + 
				"	p.TERMINAL p_terminal,\n" + 
				"	p.PROGRAM p_program,\n" + 
				"	p.TRACEID,\n" + 
				"	p.TRACEFILE,\n" + 
				"	p.BACKGROUND,\n" + 
				"	p.LATCHWAIT,\n" + 
				"	p.LATCHSPIN,\n" + 
				"	p.PGA_USED_MEM,\n" + 
				"	p.PGA_ALLOC_MEM,\n" + 
				"	p.PGA_FREEABLE_MEM,\n" + 
				"	p.PGA_MAX_MEM,\n" + 
				"	p.NUMA_DEFAULT,\n" + 
				"	p.NUMA_CURR,\n" + 
				"	p.CON_ID\n" + 
				"from    v$session s, \n" + 
				"	v$process p \n" + 
				"where   s.audsid=userenv('sessionid') and \n" + 
				"	p.addr = s.paddr";
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rset = ps.executeQuery();
		List<LinkedHashMap<String,Object>> rows = toListOfMaps(rset);
		if (rows.size() != 1) {
			throw new IllegalStateException("rows not 1 is " + rows.size());
		}
		return rows.get(0);
		
	}
	
	public String[] getColumnNames(ResultSetMetaData meta) throws SQLException {
		int columnCount = meta.getColumnCount();
		String[] columnNames = new String[columnCount];
		for (int i = 1 ; i <= columnCount; i++) {
			columnNames[i] = meta.getColumnName(i);
		}
		return columnNames;
	}
	
	public static LinkedHashMap<String,Object> getRowAsMap(ResultSet rset) throws SQLException {
        final  ResultSetMetaData metaData = rset.getMetaData();
        final LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                final String columnName = metaData.getColumnName(i);
                final Object columnValue = rset.getObject(i);
                row.put(columnName, columnValue);
        }
        return row;
}


	public static List<LinkedHashMap<String,Object>> toListOfMaps(ResultSet rset) throws SQLException {
		 List<LinkedHashMap<String,Object>> list = new ArrayList<LinkedHashMap<String,Object>>();
		 while (rset.next()) {
			 list.add(getRowAsMap(rset));
		 }
		 return list;
	}
	
	public static void setClientInfo(Connection connection, final String info) {
		if (isOracleConnection(connection)) {

			String text = info;
			if (text.length() > 32) {
				text = info.substring(0, 31);
			}

			final String sql = "{call dbms_application_info.set_client_info(:txt)}";
			try (CallableStatement sqlClientInfo = connection.prepareCall(sql)) {
				sqlClientInfo.setString(1, text);
				sqlClientInfo.executeUpdate();
			} catch (final SQLException sqe) {
				throw new RuntimeException(sqe);
			}
		} else {
			log.info("not oracle connection, nothing done");
		}
	}

	public static void setClientIdentifier(final Connection connection, final String info) {
		if (isOracleConnection(connection)) {

			String text = info;
			if (text.length() > 32) {
				text = info.substring(0, 31);
			}
			final String sql = "{call dbms_session.set_identifier(:txt)}";
			try (CallableStatement sqlClientInfo = connection.prepareCall(sql)) {
				sqlClientInfo.setString(1, text);
				sqlClientInfo.executeUpdate();
			} catch (final SQLException sqe) {
				throw new RuntimeException(sqe);
			}
		} else {
			log.info("not oracle connection, nothing done");
		}
	}

	// --

	public static void setTraceFileIdentifier(Connection connection, final String id) {
		if (isOracleConnection(connection)) {
			final String text = "alter session set tracefile_identifier = '" + id + "'";
			try (final PreparedStatement stmt = connection.prepareStatement(text)) {
				stmt.executeUpdate();
			} catch (final SQLException s) {
				log.error("Error when setTraceFileIdentifier with id: {}, because: {}", id, s.getMessage());
			}
		} else {
			log.info("not oracle connection, nothing done");
		}
	}
	
	public static String getTraceFileName(Connection connection) throws SQLException {
	   String query = "SELECT VALUE FROM V$DIAG_INFO WHERE NAME = 'Default Trace File'";
	   try (ResultSet rset = connection.createStatement().executeQuery(query)) {
		   rset.next();
		   return rset.getString(1);
	   }
	}
	
	public static String getTkprof(String fileName) throws IOException {
		return TkprofUtil.analyzeTrace(fileName);
	}
	
	
}
