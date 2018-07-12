set define on
set echo on
alter pluggable database sales_reporting open;
alter session set container = sales_reporting;
connect sr/tutorial
--
