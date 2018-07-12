

-- connect / as sysdba 
-- http://www.dba-oracle.com/t_pluggable_database.htm


set define on
set echo on
spool create_user 
alter session set container = sales_reporting_pdb;
grant connect to sa identified  by tutorial container=current;
grant create session to sa;
grant alter session to sa;
grant create table to sa;
grant create procedure to sa;
grant create type to sa;
grant create view to sa;
-- grant create directory to sa;
grant create sequence to sa;
alter user sa default tablespace sales_reporting;
alter user sa quota unlimited on sales_reporting;
-- 
grant execute on sys.utl_file to sa with grant option;
grant execute on sys.dbms_pipe to sa with grant option;
grant select on sys.v_$session to sa with grant option;
grant select on sys.v_$mystat to sa with grant option;
grant select on sys.v_$sesstat  to sa with grant option;
grant execute on sys.dbms_lock to sa with grant option;
--
grant execute on sys.utl_http to sa with grant option;
--
