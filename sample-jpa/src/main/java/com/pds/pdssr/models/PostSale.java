package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PostSale generated by hbm2java
 */
@Entity
@Table(name="post_sale"
)
public class PostSale  implements java.io.Serializable {


     private int etlSaleId;
     private OrgDistrib orgDistrib;
     private EtlSale etlSale;
     private DistributorCustomer distributorCustomer;
     private Product product;
     private OrgMfr orgMfr;
     private BigDecimal itemQty;
     private BigDecimal caseEquivQty;
     private BigDecimal invAmt;
     private Date invDt;

    public PostSale() {
    }

	
    public PostSale(int etlSaleId, EtlSale etlSale, DistributorCustomer distributorCustomer, Product product, OrgMfr orgMfr, BigDecimal itemQty, BigDecimal caseEquivQty, BigDecimal invAmt, Date invDt) {
        this.etlSaleId = etlSaleId;
        this.etlSale = etlSale;
        this.distributorCustomer = distributorCustomer;
        this.product = product;
        this.orgMfr = orgMfr;
        this.itemQty = itemQty;
        this.caseEquivQty = caseEquivQty;
        this.invAmt = invAmt;
        this.invDt = invDt;
    }
    public PostSale(int etlSaleId, OrgDistrib orgDistrib, EtlSale etlSale, DistributorCustomer distributorCustomer, Product product, OrgMfr orgMfr, BigDecimal itemQty, BigDecimal caseEquivQty, BigDecimal invAmt, Date invDt) {
       this.etlSaleId = etlSaleId;
       this.orgDistrib = orgDistrib;
       this.etlSale = etlSale;
       this.distributorCustomer = distributorCustomer;
       this.product = product;
       this.orgMfr = orgMfr;
       this.itemQty = itemQty;
       this.caseEquivQty = caseEquivQty;
       this.invAmt = invAmt;
       this.invDt = invDt;
    }
   
     @Id 
    
    @Column(name="etl_sale_id", unique=true, nullable=false)
    public int getEtlSaleId() {
        return this.etlSaleId;
    }
    
    public void setEtlSaleId(int etlSaleId) {
        this.etlSaleId = etlSaleId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="org_distrib_id")
    public OrgDistrib getOrgDistrib() {
        return this.orgDistrib;
    }
    
    public void setOrgDistrib(OrgDistrib orgDistrib) {
        this.orgDistrib = orgDistrib;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="etl_sale_id", unique=true, nullable=false, insertable=false, updatable=false)
    public EtlSale getEtlSale() {
        return this.etlSale;
    }
    
    public void setEtlSale(EtlSale etlSale) {
        this.etlSale = etlSale;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="distributor_customer_id", nullable=false)
    public DistributorCustomer getDistributorCustomer() {
        return this.distributorCustomer;
    }
    
    public void setDistributorCustomer(DistributorCustomer distributorCustomer) {
        this.distributorCustomer = distributorCustomer;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="org_mfr_id", nullable=false)
    public OrgMfr getOrgMfr() {
        return this.orgMfr;
    }
    
    public void setOrgMfr(OrgMfr orgMfr) {
        this.orgMfr = orgMfr;
    }
    
    @Column(name="item_qty", nullable=false, precision=13, scale=5)
    public BigDecimal getItemQty() {
        return this.itemQty;
    }
    
    public void setItemQty(BigDecimal itemQty) {
        this.itemQty = itemQty;
    }
    
    @Column(name="case_equiv_qty", nullable=false, precision=13, scale=5)
    public BigDecimal getCaseEquivQty() {
        return this.caseEquivQty;
    }
    
    public void setCaseEquivQty(BigDecimal caseEquivQty) {
        this.caseEquivQty = caseEquivQty;
    }
    
    @Column(name="inv_amt", nullable=false, precision=13, scale=5)
    public BigDecimal getInvAmt() {
        return this.invAmt;
    }
    
    public void setInvAmt(BigDecimal invAmt) {
        this.invAmt = invAmt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="inv_dt", nullable=false, length=13)
    public Date getInvDt() {
        return this.invDt;
    }
    
    public void setInvDt(Date invDt) {
        this.invDt = invDt;
    }




}


