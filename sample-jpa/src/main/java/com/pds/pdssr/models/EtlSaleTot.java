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
 * EtlSaleTot generated by hbm2java
 */
@Entity
@Table(name="etl_sale_tot"
)
public class EtlSaleTot  implements java.io.Serializable {


     private int etlFileId;
     private EtlFile etlFile;
     private Integer lineNumber;
     private Date salesStartDt;
     private Date salesEndDt;
     private Date fileCreateDt;
     private Integer salesRecCnt;
     private BigDecimal sumExtNetAmt;

    public EtlSaleTot() {
    }

	
    public EtlSaleTot(int etlFileId, EtlFile etlFile) {
        this.etlFileId = etlFileId;
        this.etlFile = etlFile;
    }
    public EtlSaleTot(int etlFileId, EtlFile etlFile, Integer lineNumber, Date salesStartDt, Date salesEndDt, Date fileCreateDt, Integer salesRecCnt, BigDecimal sumExtNetAmt) {
       this.etlFileId = etlFileId;
       this.etlFile = etlFile;
       this.lineNumber = lineNumber;
       this.salesStartDt = salesStartDt;
       this.salesEndDt = salesEndDt;
       this.fileCreateDt = fileCreateDt;
       this.salesRecCnt = salesRecCnt;
       this.sumExtNetAmt = sumExtNetAmt;
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
    @Column(name="sales_start_dt", length=13)
    public Date getSalesStartDt() {
        return this.salesStartDt;
    }
    
    public void setSalesStartDt(Date salesStartDt) {
        this.salesStartDt = salesStartDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="sales_end_dt", length=13)
    public Date getSalesEndDt() {
        return this.salesEndDt;
    }
    
    public void setSalesEndDt(Date salesEndDt) {
        this.salesEndDt = salesEndDt;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="file_create_dt", length=13)
    public Date getFileCreateDt() {
        return this.fileCreateDt;
    }
    
    public void setFileCreateDt(Date fileCreateDt) {
        this.fileCreateDt = fileCreateDt;
    }
    
    @Column(name="sales_rec_cnt")
    public Integer getSalesRecCnt() {
        return this.salesRecCnt;
    }
    
    public void setSalesRecCnt(Integer salesRecCnt) {
        this.salesRecCnt = salesRecCnt;
    }
    
    @Column(name="sum_ext_net_amt", precision=12)
    public BigDecimal getSumExtNetAmt() {
        return this.sumExtNetAmt;
    }
    
    public void setSumExtNetAmt(BigDecimal sumExtNetAmt) {
        this.sumExtNetAmt = sumExtNetAmt;
    }




}


