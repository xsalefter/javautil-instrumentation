package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EtlSalePostStatsId generated by hbm2java
 */
@Embeddable
public class EtlSalePostStatsId  implements java.io.Serializable {


     private Integer etlFileId;
     private Long recordCount;
     private Long orgDistribIdCount;
     private Long orgMfrIdCount;
     private Long productIdCount;
     private Long customerIdCount;
     private Long postableCount;

    public EtlSalePostStatsId() {
    }

    public EtlSalePostStatsId(Integer etlFileId, Long recordCount, Long orgDistribIdCount, Long orgMfrIdCount, Long productIdCount, Long customerIdCount, Long postableCount) {
       this.etlFileId = etlFileId;
       this.recordCount = recordCount;
       this.orgDistribIdCount = orgDistribIdCount;
       this.orgMfrIdCount = orgMfrIdCount;
       this.productIdCount = productIdCount;
       this.customerIdCount = customerIdCount;
       this.postableCount = postableCount;
    }
   

    @Column(name="etl_file_id")
    public Integer getEtlFileId() {
        return this.etlFileId;
    }
    
    public void setEtlFileId(Integer etlFileId) {
        this.etlFileId = etlFileId;
    }

    @Column(name="record_count")
    public Long getRecordCount() {
        return this.recordCount;
    }
    
    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    @Column(name="org_distrib_id_count")
    public Long getOrgDistribIdCount() {
        return this.orgDistribIdCount;
    }
    
    public void setOrgDistribIdCount(Long orgDistribIdCount) {
        this.orgDistribIdCount = orgDistribIdCount;
    }

    @Column(name="org_mfr_id_count")
    public Long getOrgMfrIdCount() {
        return this.orgMfrIdCount;
    }
    
    public void setOrgMfrIdCount(Long orgMfrIdCount) {
        this.orgMfrIdCount = orgMfrIdCount;
    }

    @Column(name="product_id_count")
    public Long getProductIdCount() {
        return this.productIdCount;
    }
    
    public void setProductIdCount(Long productIdCount) {
        this.productIdCount = productIdCount;
    }

    @Column(name="customer_id_count")
    public Long getCustomerIdCount() {
        return this.customerIdCount;
    }
    
    public void setCustomerIdCount(Long customerIdCount) {
        this.customerIdCount = customerIdCount;
    }

    @Column(name="postable_count")
    public Long getPostableCount() {
        return this.postableCount;
    }
    
    public void setPostableCount(Long postableCount) {
        this.postableCount = postableCount;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof EtlSalePostStatsId) ) return false;
		 EtlSalePostStatsId castOther = ( EtlSalePostStatsId ) other; 
         
		 return ( (this.getEtlFileId()==castOther.getEtlFileId()) || ( this.getEtlFileId()!=null && castOther.getEtlFileId()!=null && this.getEtlFileId().equals(castOther.getEtlFileId()) ) )
 && ( (this.getRecordCount()==castOther.getRecordCount()) || ( this.getRecordCount()!=null && castOther.getRecordCount()!=null && this.getRecordCount().equals(castOther.getRecordCount()) ) )
 && ( (this.getOrgDistribIdCount()==castOther.getOrgDistribIdCount()) || ( this.getOrgDistribIdCount()!=null && castOther.getOrgDistribIdCount()!=null && this.getOrgDistribIdCount().equals(castOther.getOrgDistribIdCount()) ) )
 && ( (this.getOrgMfrIdCount()==castOther.getOrgMfrIdCount()) || ( this.getOrgMfrIdCount()!=null && castOther.getOrgMfrIdCount()!=null && this.getOrgMfrIdCount().equals(castOther.getOrgMfrIdCount()) ) )
 && ( (this.getProductIdCount()==castOther.getProductIdCount()) || ( this.getProductIdCount()!=null && castOther.getProductIdCount()!=null && this.getProductIdCount().equals(castOther.getProductIdCount()) ) )
 && ( (this.getCustomerIdCount()==castOther.getCustomerIdCount()) || ( this.getCustomerIdCount()!=null && castOther.getCustomerIdCount()!=null && this.getCustomerIdCount().equals(castOther.getCustomerIdCount()) ) )
 && ( (this.getPostableCount()==castOther.getPostableCount()) || ( this.getPostableCount()!=null && castOther.getPostableCount()!=null && this.getPostableCount().equals(castOther.getPostableCount()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getEtlFileId() == null ? 0 : this.getEtlFileId().hashCode() );
         result = 37 * result + ( getRecordCount() == null ? 0 : this.getRecordCount().hashCode() );
         result = 37 * result + ( getOrgDistribIdCount() == null ? 0 : this.getOrgDistribIdCount().hashCode() );
         result = 37 * result + ( getOrgMfrIdCount() == null ? 0 : this.getOrgMfrIdCount().hashCode() );
         result = 37 * result + ( getProductIdCount() == null ? 0 : this.getProductIdCount().hashCode() );
         result = 37 * result + ( getCustomerIdCount() == null ? 0 : this.getCustomerIdCount().hashCode() );
         result = 37 * result + ( getPostableCount() == null ? 0 : this.getPostableCount().hashCode() );
         return result;
   }   


}


