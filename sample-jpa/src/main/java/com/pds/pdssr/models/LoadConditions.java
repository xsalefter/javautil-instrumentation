package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * LoadConditions generated by hbm2java
 */
@Entity
@Table(name="load_conditions"
)
public class LoadConditions  implements java.io.Serializable {


     private LoadConditionsId id;

    public LoadConditions() {
    }

    public LoadConditions(LoadConditionsId id) {
       this.id = id;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="etlFileId", column=@Column(name="etl_file_id", precision=131089, scale=0) ), 
        @AttributeOverride(name="tableName", column=@Column(name="table_name", length=60) ), 
        @AttributeOverride(name="conditionName", column=@Column(name="condition_name", length=30) ), 
        @AttributeOverride(name="conditionCount", column=@Column(name="condition_count") ) } )
    public LoadConditionsId getId() {
        return this.id;
    }
    
    public void setId(LoadConditionsId id) {
        this.id = id;
    }




}

