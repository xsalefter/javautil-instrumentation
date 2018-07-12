package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


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
 * EtlInventoryTot generated by hbm2java
 */
@Entity
@Table(name="etl_inventory_tot"
)
public class EtlInventoryTot  implements java.io.Serializable {


     private int etlFileId;
     private EtlFile etlFile;
     private Integer lineNumber;
     private Date inventoryDt;
     private Date fileCreationDt;
     private Integer recordCntReported;
     private Integer recordCntActual;

    public EtlInventoryTot() {
    }

	
    public EtlInventoryTot(int etlFileId, EtlFile etlFile) {
        this.etlFileId = etlFileId;
        this.etlFile = etlFile;
    }
    public EtlInventoryTot(int etlFileId, EtlFile etlFile, Integer lineNumber, Date inventoryDt, Date fileCreationDt, Integer recordCntReported, Integer recordCntActual) {
       this.etlFileId = etlFileId;
       this.etlFile = etlFile;
       this.lineNumber = lineNumber;
       this.inventoryDt = inventoryDt;
       this.fileCreationDt = fileCreationDt;
       this.recordCntReported = recordCntReported;
       this.recordCntActual = recordCntActual;
    }
   
     @Id 
    
    @Column(name="etl_file_id", unique=true, nullable=false)
    public int getEtlFileId() {
        return this.etlFileId;
    }
    
    public void setEtlFileId(int etlFileId) {
        this.etlFileId = etlFileId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="etl_file_id", unique=true, nullable=false, insertable=false, updatable=false)
    public EtlFile getEtlFile() {
        return this.etlFile;
    }
    
    public void setEtlFile(EtlFile etlFile) {
        this.etlFile = etlFile;
    }
    
    @Column(name="line_number")
    public Integer getLineNumber() {
        return this.lineNumber;
    }
    
    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="inventory_dt", length=13)
    public Date getInventoryDt() {
        return this.inventoryDt;
    }
    
    public void setInventoryDt(Date inventoryDt) {
        this.inventoryDt = inventoryDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="file_creation_dt", length=13)
    public Date getFileCreationDt() {
        return this.fileCreationDt;
    }
    
    public void setFileCreationDt(Date fileCreationDt) {
        this.fileCreationDt = fileCreationDt;
    }
    
    @Column(name="record_cnt_reported", precision=8, scale=0)
    public Integer getRecordCntReported() {
        return this.recordCntReported;
    }
    
    public void setRecordCntReported(Integer recordCntReported) {
        this.recordCntReported = recordCntReported;
    }
    
    @Column(name="record_cnt_actual", precision=8, scale=0)
    public Integer getRecordCntActual() {
        return this.recordCntActual;
    }
    
    public void setRecordCntActual(Integer recordCntActual) {
        this.recordCntActual = recordCntActual;
    }




}


