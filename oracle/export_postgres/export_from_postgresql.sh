pg_dump --data-only -t integration_test.org --inserts sales_reporting_db > pop.sql
pg_dump --data-only -t integration_test.org_distrib --inserts sales_reporting_db >> pop.sql
pg_dump --data-only -t integration_test.org_mfr --inserts sales_reporting_db >> pop.sql


