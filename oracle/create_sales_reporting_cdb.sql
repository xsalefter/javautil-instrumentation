
-- connect / as sysdba 
-- http://www.dba-oracle.com/t_pluggable_database.htm
create pluggable database 
  sales_reporting
admin user 
   sr_admin identified by tutorial 
file_name_convert = ('/pdbseed/', '/sales_reporting/');

alter pluggable database sales_reporting open;

