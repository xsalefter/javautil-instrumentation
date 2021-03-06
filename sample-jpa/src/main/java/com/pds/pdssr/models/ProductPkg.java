package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ProductPkg generated by hbm2java
 */
@Entity
@Table(name="product_pkg"
)
public class ProductPkg  implements java.io.Serializable {


     private int productPkgId;
     private int productId;
     private int pkgId;
     private int pkgQtyNumerator;
     private int pkgQtyDivisor;

    public ProductPkg() {
    }

    public ProductPkg(int productPkgId, int productId, int pkgId, int pkgQtyNumerator, int pkgQtyDivisor) {
       this.productPkgId = productPkgId;
       this.productId = productId;
       this.pkgId = pkgId;
       this.pkgQtyNumerator = pkgQtyNumerator;
       this.pkgQtyDivisor = pkgQtyDivisor;
    }
   
     @Id 
    
    @Column(name="product_pkg_id", unique=true, nullable=false)
    public int getProductPkgId() {
        return this.productPkgId;
    }
    
    public void setProductPkgId(int productPkgId) {
        this.productPkgId = productPkgId;
    }
    
    @Column(name="product_id", nullable=false)
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    @Column(name="pkg_id", nullable=false)
    public int getPkgId() {
        return this.pkgId;
    }
    
    public void setPkgId(int pkgId) {
        this.pkgId = pkgId;
    }
    
    @Column(name="pkg_qty_numerator", nullable=false, precision=5, scale=0)
    public int getPkgQtyNumerator() {
        return this.pkgQtyNumerator;
    }
    
    public void setPkgQtyNumerator(int pkgQtyNumerator) {
        this.pkgQtyNumerator = pkgQtyNumerator;
    }
    
    @Column(name="pkg_qty_divisor", nullable=false, precision=5, scale=0)
    public int getPkgQtyDivisor() {
        return this.pkgQtyDivisor;
    }
    
    public void setPkgQtyDivisor(int pkgQtyDivisor) {
        this.pkgQtyDivisor = pkgQtyDivisor;
    }




}


