package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * EtlCustomerStat generated by hbm2java
 */
@Entity
@Table(name="etl_customer_stat"
)
public class EtlCustomerStat  implements java.io.Serializable {


     private EtlCustomerStatId id;

    public EtlCustomerStat() {
    }

    public EtlCustomerStat(EtlCustomerStatId id) {
       this.id = id;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="etlFileId", column=@Column(name="etl_file_id") ), 
        @AttributeOverride(name="etlCustomerCount", column=@Column(name="etl_customer_count") ) } )
    public EtlCustomerStatId getId() {
        return this.id;
    }
    
    public void setId(EtlCustomerStatId id) {
        this.id = id;
    }




}


