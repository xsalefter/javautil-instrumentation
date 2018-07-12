alter pluggable database sales_reporting_pdb open;
alter session set container = sales_reporting_open;
grant connect to sa identified  by tutorial container=current;


