package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ProductSuspectDtl generated by hbm2java
 */
@Entity
@Table(name="product_suspect_dtl"
)
public class ProductSuspectDtl  implements java.io.Serializable {


     private int productSuspectDtlId;
     private Product product;
     private int productSuspectHdrId;

    public ProductSuspectDtl() {
    }

    public ProductSuspectDtl(int productSuspectDtlId, Product product, int productSuspectHdrId) {
       this.productSuspectDtlId = productSuspectDtlId;
       this.product = product;
       this.productSuspectHdrId = productSuspectHdrId;
    }
   
     @Id 
    
    @Column(name="product_suspect_dtl_id", unique=true, nullable=false)
    public int getProductSuspectDtlId() {
        return this.productSuspectDtlId;
    }
    
    public void setProductSuspectDtlId(int productSuspectDtlId) {
        this.productSuspectDtlId = productSuspectDtlId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Column(name="product_suspect_hdr_id", nullable=false)
    public int getProductSuspectHdrId() {
        return this.productSuspectHdrId;
    }
    
    public void setProductSuspectHdrId(int productSuspectHdrId) {
        this.productSuspectHdrId = productSuspectHdrId;
    }




}


