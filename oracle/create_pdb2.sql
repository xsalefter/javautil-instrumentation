--#https://docs.oracle.com/en/database/oracle/oracle-database/12.2/admin/creating-and-removing-pdbs-with-sql-plus.html#GUID-05702CEB-A43C-452C-8081-4CA68DDA8007

set echo on

CREATE PLUGGABLE DATABASE sales_reporting_pdb ADMIN USER sr_admin IDENTIFIED BY tutorial
  STORAGE (MAXSIZE 2G)
  DEFAULT TABLESPACE sales_reporting
    DATAFILE '/common/oracle/oradata/dev12c/sales_reporting_pdb/sales_reporting.dbf' 
       SIZE 32M AUTOEXTEND ON
  FILE_NAME_CONVERT = ('/pdbseed/', '/sales_reporting/');

alter pluggable database sales_reporting_pdb open;

alter session set container = sales_reporting_pdb;

create tablespace sales_reporting
    DATAFILE '/common/oracle/oradata/dev12c/sales_reporting/sales_reporting.dbf' 
       SIZE 32M AUTOEXTEND ON;
--  PATH_PREFIX = '/common/oracle/oradata/dev12c/sales_reporting_pdb' 
