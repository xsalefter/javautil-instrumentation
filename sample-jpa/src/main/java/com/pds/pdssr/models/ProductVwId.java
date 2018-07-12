package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductVwId generated by hbm2java
 */
@Embeddable
public class ProductVwId  implements java.io.Serializable {


     private String orgCd;
     private String orgNm;
     private Integer productId;
     private Integer mfrId;
     private String productDescr;
     private String mfrProductId;
     private String caseGtin;
     private String boxGtin;
     private String unitGtin;
     private Integer unitsPerBox;
     private Integer unitsPerCase;

    public ProductVwId() {
    }

    public ProductVwId(String orgCd, String orgNm, Integer productId, Integer mfrId, String productDescr, String mfrProductId, String caseGtin, String boxGtin, String unitGtin, Integer unitsPerBox, Integer unitsPerCase) {
       this.orgCd = orgCd;
       this.orgNm = orgNm;
       this.productId = productId;
       this.mfrId = mfrId;
       this.productDescr = productDescr;
       this.mfrProductId = mfrProductId;
       this.caseGtin = caseGtin;
       this.boxGtin = boxGtin;
       this.unitGtin = unitGtin;
       this.unitsPerBox = unitsPerBox;
       this.unitsPerCase = unitsPerCase;
    }
   

    @Column(name="org_cd", length=16)
    public String getOrgCd() {
        return this.orgCd;
    }
    
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    @Column(name="org_nm", length=32)
    public String getOrgNm() {
        return this.orgNm;
    }
    
    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    @Column(name="product_id")
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name="mfr_id")
    public Integer getMfrId() {
        return this.mfrId;
    }
    
    public void setMfrId(Integer mfrId) {
        this.mfrId = mfrId;
    }

    @Column(name="product_descr", length=60)
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

    @Column(name="case_gtin", length=14)
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

    @Column(name="units_per_box", precision=9, scale=0)
    public Integer getUnitsPerBox() {
        return this.unitsPerBox;
    }
    
    public void setUnitsPerBox(Integer unitsPerBox) {
        this.unitsPerBox = unitsPerBox;
    }

    @Column(name="units_per_case", precision=9, scale=0)
    public Integer getUnitsPerCase() {
        return this.unitsPerCase;
    }
    
    public void setUnitsPerCase(Integer unitsPerCase) {
        this.unitsPerCase = unitsPerCase;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProductVwId) ) return false;
		 ProductVwId castOther = ( ProductVwId ) other; 
         
		 return ( (this.getOrgCd()==castOther.getOrgCd()) || ( this.getOrgCd()!=null && castOther.getOrgCd()!=null && this.getOrgCd().equals(castOther.getOrgCd()) ) )
 && ( (this.getOrgNm()==castOther.getOrgNm()) || ( this.getOrgNm()!=null && castOther.getOrgNm()!=null && this.getOrgNm().equals(castOther.getOrgNm()) ) )
 && ( (this.getProductId()==castOther.getProductId()) || ( this.getProductId()!=null && castOther.getProductId()!=null && this.getProductId().equals(castOther.getProductId()) ) )
 && ( (this.getMfrId()==castOther.getMfrId()) || ( this.getMfrId()!=null && castOther.getMfrId()!=null && this.getMfrId().equals(castOther.getMfrId()) ) )
 && ( (this.getProductDescr()==castOther.getProductDescr()) || ( this.getProductDescr()!=null && castOther.getProductDescr()!=null && this.getProductDescr().equals(castOther.getProductDescr()) ) )
 && ( (this.getMfrProductId()==castOther.getMfrProductId()) || ( this.getMfrProductId()!=null && castOther.getMfrProductId()!=null && this.getMfrProductId().equals(castOther.getMfrProductId()) ) )
 && ( (this.getCaseGtin()==castOther.getCaseGtin()) || ( this.getCaseGtin()!=null && castOther.getCaseGtin()!=null && this.getCaseGtin().equals(castOther.getCaseGtin()) ) )
 && ( (this.getBoxGtin()==castOther.getBoxGtin()) || ( this.getBoxGtin()!=null && castOther.getBoxGtin()!=null && this.getBoxGtin().equals(castOther.getBoxGtin()) ) )
 && ( (this.getUnitGtin()==castOther.getUnitGtin()) || ( this.getUnitGtin()!=null && castOther.getUnitGtin()!=null && this.getUnitGtin().equals(castOther.getUnitGtin()) ) )
 && ( (this.getUnitsPerBox()==castOther.getUnitsPerBox()) || ( this.getUnitsPerBox()!=null && castOther.getUnitsPerBox()!=null && this.getUnitsPerBox().equals(castOther.getUnitsPerBox()) ) )
 && ( (this.getUnitsPerCase()==castOther.getUnitsPerCase()) || ( this.getUnitsPerCase()!=null && castOther.getUnitsPerCase()!=null && this.getUnitsPerCase().equals(castOther.getUnitsPerCase()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getOrgCd() == null ? 0 : this.getOrgCd().hashCode() );
         result = 37 * result + ( getOrgNm() == null ? 0 : this.getOrgNm().hashCode() );
         result = 37 * result + ( getProductId() == null ? 0 : this.getProductId().hashCode() );
         result = 37 * result + ( getMfrId() == null ? 0 : this.getMfrId().hashCode() );
         result = 37 * result + ( getProductDescr() == null ? 0 : this.getProductDescr().hashCode() );
         result = 37 * result + ( getMfrProductId() == null ? 0 : this.getMfrProductId().hashCode() );
         result = 37 * result + ( getCaseGtin() == null ? 0 : this.getCaseGtin().hashCode() );
         result = 37 * result + ( getBoxGtin() == null ? 0 : this.getBoxGtin().hashCode() );
         result = 37 * result + ( getUnitGtin() == null ? 0 : this.getUnitGtin().hashCode() );
         result = 37 * result + ( getUnitsPerBox() == null ? 0 : this.getUnitsPerBox().hashCode() );
         result = 37 * result + ( getUnitsPerCase() == null ? 0 : this.getUnitsPerCase().hashCode() );
         return result;
   }   


}

