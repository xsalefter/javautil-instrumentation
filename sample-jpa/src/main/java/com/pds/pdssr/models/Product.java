package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
)
public class Product  implements java.io.Serializable {


     private int productId;
     private OrgMfr orgMfr;
     private String productDescr;
     private String mfrProductId;
     private String caseGtin;
     private String boxGtin;
     private String unitGtin;
     private int unitsPerBox;
     private int unitsPerCase;
     private Set<ProductSuspectDtl> productSuspectDtls = new HashSet<ProductSuspectDtl>(0);
     private Set<ProductNomen> productNomens = new HashSet<ProductNomen>(0);
     private Set<EtlSale> etlSales = new HashSet<EtlSale>(0);
     private Set<PostSale> postSales = new HashSet<PostSale>(0);

    public Product() {
    }

	
    public Product(int productId, OrgMfr orgMfr, String productDescr, String caseGtin, int unitsPerBox, int unitsPerCase) {
        this.productId = productId;
        this.orgMfr = orgMfr;
        this.productDescr = productDescr;
        this.caseGtin = caseGtin;
        this.unitsPerBox = unitsPerBox;
        this.unitsPerCase = unitsPerCase;
    }
    public Product(int productId, OrgMfr orgMfr, String productDescr, String mfrProductId, String caseGtin, String boxGtin, String unitGtin, int unitsPerBox, int unitsPerCase, Set<ProductSuspectDtl> productSuspectDtls, Set<ProductNomen> productNomens, Set<EtlSale> etlSales, Set<PostSale> postSales) {
       this.productId = productId;
       this.orgMfr = orgMfr;
       this.productDescr = productDescr;
       this.mfrProductId = mfrProductId;
       this.caseGtin = caseGtin;
       this.boxGtin = boxGtin;
       this.unitGtin = unitGtin;
       this.unitsPerBox = unitsPerBox;
       this.unitsPerCase = unitsPerCase;
       this.productSuspectDtls = productSuspectDtls;
       this.productNomens = productNomens;
       this.etlSales = etlSales;
       this.postSales = postSales;
    }
   
     @Id 
    
    @Column(name="product_id", unique=true, nullable=false)
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mfr_id", nullable=false)
    public OrgMfr getOrgMfr() {
        return this.orgMfr;
    }
    
    public void setOrgMfr(OrgMfr orgMfr) {
        this.orgMfr = orgMfr;
    }
    
    @Column(name="product_descr", nullable=false, length=60)
    public String getProductDescr() {
        return this.productDescr;
    }
    
    public void setProductDescr(String productDescr) {
        this.productDescr = productDescr;
    }
    
    @Column(name="mfr_product_id", length=8)
    public String getMfrProductId() {
        return this.mfrProductId;
    }
    
    public void setMfrProductId(String mfrProductId) {
        this.mfrProductId = mfrProductId;
    }
    
    @Column(name="case_gtin", nullable=false, length=14)
    public String getCaseGtin() {
        return this.caseGtin;
    }
    
    public void setCaseGtin(String caseGtin) {
        this.caseGtin = caseGtin;
    }
    
    @Column(name="box_gtin", length=14)
    public String getBoxGtin() {
        return this.boxGtin;
    }
    
    public void setBoxGtin(String boxGtin) {
        this.boxGtin = boxGtin;
    }
    
    @Column(name="unit_gtin", length=14)
    public String getUnitGtin() {
        return this.unitGtin;
    }
    
    public void setUnitGtin(String unitGtin) {
        this.unitGtin = unitGtin;
    }
    
    @Column(name="units_per_box", nullable=false, precision=9, scale=0)
    public int getUnitsPerBox() {
        return this.unitsPerBox;
    }
    
    public void setUnitsPerBox(int unitsPerBox) {
        this.unitsPerBox = unitsPerBox;
    }
    
    @Column(name="units_per_case", nullable=false, precision=9, scale=0)
    public int getUnitsPerCase() {
        return this.unitsPerCase;
    }
    
    public void setUnitsPerCase(int unitsPerCase) {
        this.unitsPerCase = unitsPerCase;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")
    public Set<ProductSuspectDtl> getProductSuspectDtls() {
        return this.productSuspectDtls;
    }
    
    public void setProductSuspectDtls(Set<ProductSuspectDtl> productSuspectDtls) {
        this.productSuspectDtls = productSuspectDtls;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")
    public Set<ProductNomen> getProductNomens() {
        return this.productNomens;
    }
    
    public void setProductNomens(Set<ProductNomen> productNomens) {
        this.productNomens = productNomens;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")
    public Set<EtlSale> getEtlSales() {
        return this.etlSales;
    }
    
    public void setEtlSales(Set<EtlSale> etlSales) {
        this.etlSales = etlSales;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="product")
    public Set<PostSale> getPostSales() {
        return this.postSales;
    }
    
    public void setPostSales(Set<PostSale> postSales) {
        this.postSales = postSales;
    }




}


