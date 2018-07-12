set echo on
spool simple_schema
alter session set container = sales_reporting_pdb;

create table org (
    org_id numeric(10) primary key not null,
    org_cd varchar(16),
    org_nm varchar(32)
)
;

insert into org (org_id, org_cd, org_nm) values (1, 'One', 'One Name');
