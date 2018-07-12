alter pluggable database sales_reporting close immediate;
ALTER PLUGGABLE DATABASE sales_reporting UNPLUG INTO 'sale_reporting_unplug.xml';
drop pluggable database sales_reporting;

alter pluggable database sales_reporting_pdb close immediate;
ALTER PLUGGABLE DATABASE sales_reporting_pdb UNPLUG INTO 'sale_reporting_pdb_unplug.xml';
drop pluggable database sales_reporting_pdb;
