

-- connect / as sysdba 
-- http://www.dba-oracle.com/t_pluggable_database.htm


set define on
set echo on
spool create_user 
alter session set container = sales_reporting_pdb;
grant connect to c##sa identified  by tutorial container=all;
grant create session to c##sa;
grant create table to c##sa;
grant create procedure to c##sa;
grant create type to c##sa;
grant create view to c##sa;
-- grant create directory to c##sa;
grant create sequence to c##sa;
alter user c##sa default tablespace sales_reporting;
alter user c##sa quota unlimited on sales_reporting;
-- 
grant execute on sys.utl_file to c##sa with grant option;
grant execute on sys.dbms_pipe to c##sa with grant option;
grant select on sys.v_$session to c##sa with grant option;
grant select on sys.v_$mystat to c##sa with grant option;
grant select on sys.v_$sesstat  to c##sa with grant option;
grant execute on sys.dbms_lock to c##sa with grant option;
--
grant execute on sys.utl_http to c##sa with grant option;
--
