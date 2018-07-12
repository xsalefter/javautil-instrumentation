set echo on
spool sales_reporting_oracle
alter session set container = sales_reporting;

create table org (
    org_id numeric(10) primary key not null,
    org_cd varchar(16),
    org_nm varchar(32)
)
;
create table org_datafeed (
    org_id numeric(10) primary key not null references org(org_id)
)
;
create table org_mfr (
    org_id numeric(10) primary key not null references org(org_id),
    cds_mfr_id varchar(10) not null,
    unique(cds_mfr_id)
)
;
create table org_distrib(
    org_id numeric(10) primary key not null references org(org_id),
    distrib_id varchar(10) not null)
;
create table org_customer(
   org_id numeric(10) primary key not null references org(org_id)
)
;
create table distributor_customer (
    distributor_customer_id numeric(10) not null primary key,
    org_distrib_id     integer not null references org_distrib(org_id),
    ship_to_cust_id    varchar(10),
    unique (org_distrib_id,ship_to_cust_id)
)
;
create table product (
    product_id      numeric(10) primary key,
    mfr_id          integer not null references org_mfr,
    product_descr   varchar(60) not null,
    mfr_product_id  varchar(8),
    case_gtin       char(14) not null,
    box_gtin        char(14),
    unit_gtin       char(14),
    units_per_box   numeric(9) not null,
    units_per_case  numeric(9) not null
)
;
create table etl_file (
    etl_file_id         numeric(10) primary key not null,
    rpt_org_id          integer not null references org_datafeed,
    datafeed_org_id     integer not null
)
;
create table etl_customer (
    etl_customer_id     numeric(10) primary key not null,
    ship_to_cust_id     varchar(10) not null,
    etl_file_id         integer  not null references etl_file,
    line_number         integer not null,
    class_of_trade      varchar(4),
    cust_nm             varchar(30),
    addr_1              varchar(30),
    addr_2              varchar(30),
    city                varchar(25),
    state               varchar(2),
    postal_cd           varchar(9),
    cntry_id            varchar(3),
    tel_nbr             varchar(10),
    national_acct_id    varchar(10),
    special_flg         varchar(1)
)
;
create table customer_info (
    customer_info_id     numeric(10) primary key not null,
    distributor_customer_id integer  not null,
    etl_customer_id         integer  not null references etl_customer,
    class_of_trade      varchar(4),
    cust_nm             varchar(30),
    addr_1              varchar(30),
    addr_2              varchar(30),
    city                varchar(25),
    state               varchar(2),
    postal_cd           varchar(9),
    cntry_id            varchar(3),
    tel_nbr             varchar(10),
    national_acct_id    varchar(10),
    special_flg         varchar(1)
)

;
create table etl_customer_tot (
    etl_file_id        numeric(10) primary key references etl_file,
    line_number         integer not null,
    customer_count     numeric(9) not null
)
;
create table etl_inventory (
    etl_inventory_id        numeric(10) primary key,
    etl_file_id             integer  not null references etl_file,
    line_number             integer,
    distributor_id          varchar(10),
    mfr_id                  varchar(10),
    mfr_product_id          varchar(8),
    comments                varchar(96),
    cases                   numeric(6),
    boxes                   numeric(6),
    units                   numeric(6),
    case_gtin               varchar(14),
    inventory_qty           numeric(9,3),
    inventory_unit_meas_id  varchar(3)
)
;
create table etl_inventory_tot (
    etl_file_id         numeric(10) primary key references etl_file,
    line_number         integer,
    inventory_dt        date,
    file_creation_dt    date,
    record_cnt_reported numeric(8),
    record_cnt_actual   numeric(8)
)
;
create table etl_sale (
    etl_sale_id         numeric(10) primary key,
    etl_file_id         integer not null references etl_file,
    line_number         integer,
    distrib_Id          varchar(10) not null,
    mfr_id              varchar(10) not null,
    mfr_product_id      varchar(8),
    ship_to_cust_id     varchar(10) not null,
    invoice_cd          varchar(10),
    invoice_dt          date,
    ship_dt             date,
    /* should have a currency */
    extended_Net_Amt    numeric(9,2),
    curr_cd             varchar(3),
    distrib_product_ref varchar(12),
    product_descr       varchar(32),
    cases_shipped       numeric(9),
    boxes_shipped       numeric(9),
    units_shipped       numeric(9),
    case_gtin           varchar(14),
    product_id          integer references product(product_id),
    org_distrib_id      integer references org_distrib(org_id),
    distributor_customer_id integer
        references distributor_customer(distributor_customer_id),
    org_mfr_id          integer references org_mfr(org_id)
)
;
create index etl_sale_etl_file_id on etl_sale(etl_file_id)
;
create table etl_sale_tot (
         etl_file_id     integer primary key references etl_file,
         line_number     integer,
         sales_start_dt  date,
         sales_end_dt    date,
         file_create_dt  date,
         sales_rec_cnt   integer,
         sum_ext_net_amt numeric(12,2)
)
;

create table product_pkg (
    product_pkg_id      numeric(10) primary key,
    product_id          integer not null,
    pkg_id              integer not null,
    pkg_qty_numerator   numeric(5) not null,
    pkg_qty_divisor     numeric(5) not null
)
;
create table product_nomen (
    product_nomen_id   numeric(10)  primary key,
    org_id              integer not null references org(org_id),
    product_id          integer references product(product_id),
    product_ref_cd      varchar(30),
    case_gtin           varchar(14),
    descr               varchar(60)
)


;
create table customer (
    customer_id  numeric(10) primary key references org(org_id)
)
;
create table product_suspect_hdr (
    product_suspect_hdr_id numeric(10) not null primary key,
    descr                  varchar(60)
)
;
create table product_suspect_dtl (
    product_suspect_dtl_id numeric(10) primary key not null,
    product_id             integer not null references product(product_id),
    product_suspect_hdr_id integer not null
)

;
create table post_sale (
    etl_sale_id     numeric(10) primary key references etl_sale(etl_sale_id),
    org_distrib_id  integer references org_distrib(org_id),
    org_mfr_id      integer not null references org_mfr(org_id),
    product_id      integer not null references product(product_id),
    distributor_customer_id integer not null references distributor_customer(distributor_customer_id),
    item_qty  		numeric (13,5) not null,
    case_equiv_qty  numeric(13,5)  not null,
    inv_amt        numeric (13,5) not null,
    inv_dt          date           not null
)
;
create index post_sale_idx1 on post_sale(org_distrib_id)
;
create table validated_address (
    validated_address_id numeric(10) primary key,
    addr_1              varchar(30),
    addr_2              varchar(30),
    city                varchar(25),
    state               varchar(2),
    postal_cd           varchar(9),
    valid_addr_1        varchar(30),
    valid_addr_2        varchar(30),
    valid_city          varchar(25),
    valid_state         varchar(2),
    valid_postal_cd     varchar(9),
    validation_msg      varchar(200)
)
;
create view load_conditions as
select
        to_number(p.parm_value_str,'999999999') etl_file_id,
        cond.table_name,
        cond.condition_name,
        count(row.ut_condition_run_step_id) condition_count
from    ut_condition_row_msg row,
        ut_condition_run_step step,
        ut_condition_run run,
        ut_condition cond,
        ut_condition_run_parm p
where 	row.ut_condition_run_step_id  = step.ut_condition_run_step_id and
       	step.ut_condition_run_id = run.ut_condition_run_id and
       	step.ut_condition_id = cond.ut_condition_id and
    	p.ut_condition_run_id = run.ut_condition_run_id and
    	p.parm_nm= 'ETL_FILE_ID'
group by cond.table_name,
    	cond.condition_name,
    	p.parm_value_str
order by to_number(p.parm_value_str,'999999999'), 
		cond.table_name, 
		cond.condition_name
;
create view etl_sale_post_stats
as
	select etl_file_id,
                count(*)              record_count,
        	count(org_distrib_id) org_distrib_id_count,
        	count(s.org_mfr_id ) org_mfr_id_count,
        	count(s.product_id)  product_id_count,
        	count(s.distributor_customer_id) customer_id_count,
		count(
			case when s.org_distrib_id is not null and
                                  s.org_mfr_id     is not null and
                                  s.product_id     is not null and
				  s.distributor_customer_id is not null
			then 1 else null end
		     ) 
			postable_count
                from etl_sale s
		group by etl_file_id;
;
create view sale_product_cust_vw as
select
 s.etl_sale_id,
 s.org_distrib_id,
 s.org_mfr_id,
 s.product_id,
 s.distributor_customer_id,
 s.inv_amt,
 s.case_equiv_qty,
 s.item_qty,
 s.inv_dt,
 p.product_descr
from post_sale s,
     product p,
     distributor_customer c
where p.product_id = s.product_id and
        c.distributor_customer_id = s.distributor_customer_id
;
create or replace view etl_customer_stat as
select 
     etl_file.etl_file_id,
     count(etl_customer.etl_file_id) etl_customer_count
from etl_file
left outer join etl_customer on
	etl_file.etl_file_id = etl_customer.etl_file_id
group by etl_file.etl_file_id
;
create or replace view etl_sale_stat as 
select 
	etl_file.etl_file_id,
	count(etl_file.etl_file_id) etl_sale_count,
	min(invoice_dt)    invoice_dt_min,
        max(invoice_dt)    invoice_dt_max
from etl_file
left outer join etl_sale on
        etl_sale.etl_file_id = etl_file.etl_file_id
group by etl_file.etl_file_id
;
create or replace view etl_post_sale_stat as 
select 
	etl_file.etl_file_id,
	count(etl_file.etl_file_id) etl_sale_count,
	min(invoice_dt)    invoice_dt_min,
        max(invoice_dt)    invoice_dt_max
from etl_file
left outer join etl_sale on
        etl_sale.etl_file_id = etl_file.etl_file_id
left join post_sale on
	post_sale.etl_sale_id = etl_sale.etl_sale_id
group by etl_file.etl_file_id
;
create index etl_sale_etl_file_id_ndx on etl_sale(etl_file_id)
;
create index etl_customer_etl_file_ndx on etl_customer(etl_file_id)
;
create or replace view etl_file_stat as
select 	ef.etl_file_id,
       	ef.datafeed_org_id,
       	--org.org_cd,
       	--org.org_nm,
       	ec.etl_customer_count,	
       	es.etl_sale_count,
        es.invoice_dt_min,
        es.invoice_dt_max
from 	etl_file ef,
     	--org org,
     	etl_customer_stat ec,
     	etl_sale_stat     es
where 	ec.etl_file_id = ef.etl_file_id and
      	es.etl_file_id = ef.etl_file_id 
	-- and org.org_id     = ef.datafeed_org_id
;
create or replace view etl_sale_unknown_item as
select product_descr,
       distrib_id,
       sum(extended_net_amt) extended_net_amt_sum,
       distrib_product_ref,
       case_gtin
from   etl_sale
where  product_id is null
group  by
       distrib_id,
       distrib_product_ref,
       case_gtin,
       product_descr
order  by sum(extended_net_amt) desc
;
create or replace view product_vw as 
select 
  o.org_cd,
  o.org_nm,
  p.product_id,
  p.mfr_id,
  p.product_descr,
  p.mfr_product_id,
  p.case_gtin,
  p.box_gtin,
  p.unit_gtin,
  p.units_per_box,
  p.units_per_case
from  product p,
      org     o
where p.mfr_id = o.org_id
;

create sequence CUSTOMER_SEQ;
create sequence DISTRIBUTOR_CUSTOMER_SEQ;
create sequence ETL_CUSTOMER_SEQ;
create sequence ETL_CUSTOMER_TOT_SEQ;
create sequence ETL_FILE_SEQ;
create sequence ETL_INVENTORY_SEQ;
create sequence ETL_INVENTORY_TOT_SEQ;
create sequence ETL_SALE_SEQ;
create sequence ETL_SALE_TOT_SEQ;
create sequence ORG_SEQ;
create sequence ORG_CUSTOMER_SEQ;
create sequence ORG_DATAFEED_SEQ;
create sequence ORG_DISTRIB_SEQ;
create sequence ORG_MFR_SEQ;
create sequence POST_SALE_SEQ;
create sequence PRODUCT_SEQ;
create sequence PRODUCT_PKG_SEQ;
create sequence PRODUCT_SUSPECT_HDR_SEQ;
create sequence VALIDATED_ADDRESS_SEQ;
