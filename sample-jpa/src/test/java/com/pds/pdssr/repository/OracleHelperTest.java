package com.pds.pdssr.repository;

import org.junit.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.javautil.oracle.OracleHelper;

// TODO this doesn't work if it is in org.javautil.oracle package
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:oracle.properties")
public class OracleHelperTest {
	Logger logger = LoggerFactory.getLogger(getClass());

    
    @Autowired
	private DataSource dataSource;
    
    @Test
    public void checkCallsWork() throws SQLException, IOException {
    	final String clientId  = "test_client";
    	final String module = getClass().getName();
    	final String action = "checkCallsWork";
    	Assert.assertNotNull(dataSource);
    	Connection connection = dataSource.getConnection();
    	Assert.assertTrue(OracleHelper.isOracleConnection(connection));
    	logger.info("testing oracle connection");
    	OracleHelper.traceOn(connection,"OracleHelperTest");
    	OracleHelper.setClientIdentifier(connection, clientId);
    	OracleHelper.setModule(connection,module,action);
    	Map<String,Object> sessionInfo = OracleHelper.getV$Session(connection);
    	Assert.assertEquals(clientId, sessionInfo.get("CLIENT_IDENTIFIER"));
    	Assert.assertEquals(module, sessionInfo.get("MODULE"));
    	Assert.assertEquals(action,sessionInfo.get("ACTION"));
    	logger.info("trace_file " + sessionInfo.get("TRACE_FILE"));
    	logger.info("session: " + sessionInfo);
    	final String sessionTraceFileName = OracleHelper.getTraceFileName(connection);
    	Assert.assertNotNull(sessionTraceFileName);
    	logger.info("traceFileName: " + sessionTraceFileName);
    	OracleHelper.getTkprof(sessionTraceFileName);
    }
}
