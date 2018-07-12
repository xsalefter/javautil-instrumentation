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
 * CustomerInfo generated by hbm2java
 */
@Entity
@Table(name="customer_info"
)
public class CustomerInfo  implements java.io.Serializable {


     private int customerInfoId;
     private EtlCustomer etlCustomer;
     private int distributorCustomerId;
     private String classOfTrade;
     private String custNm;
     private String addr1;
     private String addr2;
     private String city;
     private String state;
     private String postalCd;
     private String cntryId;
     private String telNbr;
     private String nationalAcctId;
     private String specialFlg;

    public CustomerInfo() {
    }

	
    public CustomerInfo(int customerInfoId, EtlCustomer etlCustomer, int distributorCustomerId) {
        this.customerInfoId = customerInfoId;
        this.etlCustomer = etlCustomer;
        this.distributorCustomerId = distributorCustomerId;
    }
    public CustomerInfo(int customerInfoId, EtlCustomer etlCustomer, int distributorCustomerId, String classOfTrade, String custNm, String addr1, String addr2, String city, String state, String postalCd, String cntryId, String telNbr, String nationalAcctId, String specialFlg) {
       this.customerInfoId = customerInfoId;
       this.etlCustomer = etlCustomer;
       this.distributorCustomerId = distributorCustomerId;
       this.classOfTrade = classOfTrade;
       this.custNm = custNm;
       this.addr1 = addr1;
       this.addr2 = addr2;
       this.city = city;
       this.state = state;
       this.postalCd = postalCd;
       this.cntryId = cntryId;
       this.telNbr = telNbr;
       this.nationalAcctId = nationalAcctId;
       this.specialFlg = specialFlg;
    }
   
     @Id 
    
    @Column(name="customer_info_id", unique=true, nullable=false)
    public int getCustomerInfoId() {
        return this.customerInfoId;
    }
    
    public void setCustomerInfoId(int customerInfoId) {
        this.customerInfoId = customerInfoId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="etl_customer_id", nullable=false)
    public EtlCustomer getEtlCustomer() {
        return this.etlCustomer;
    }
    
    public void setEtlCustomer(EtlCustomer etlCustomer) {
        this.etlCustomer = etlCustomer;
    }
    
    @Column(name="distributor_customer_id", nullable=false)
    public int getDistributorCustomerId() {
        return this.distributorCustomerId;
    }
    
    public void setDistributorCustomerId(int distributorCustomerId) {
        this.distributorCustomerId = distributorCustomerId;
    }
    
    @Column(name="class_of_trade", length=4)
    public String getClassOfTrade() {
        return this.classOfTrade;
    }
    
    public void setClassOfTrade(String classOfTrade) {
        this.classOfTrade = classOfTrade;
    }
    
    @Column(name="cust_nm", length=30)
    public String getCustNm() {
        return this.custNm;
    }
    
    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }
    
    @Column(name="addr_1", length=30)
    public String getAddr1() {
        return this.addr1;
    }
    
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }
    
    @Column(name="addr_2", length=30)
    public String getAddr2() {
        return this.addr2;
    }
    
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }
    
    @Column(name="city", length=25)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="state", length=2)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Column(name="postal_cd", length=9)
    public String getPostalCd() {
        return this.postalCd;
    }
    
    public void setPostalCd(String postalCd) {
        this.postalCd = postalCd;
    }
    
    @Column(name="cntry_id", length=3)
    public String getCntryId() {
        return this.cntryId;
    }
    
    public void setCntryId(String cntryId) {
        this.cntryId = cntryId;
    }
    
    @Column(name="tel_nbr", length=10)
    public String getTelNbr() {
        return this.telNbr;
    }
    
    public void setTelNbr(String telNbr) {
        this.telNbr = telNbr;
    }
    
    @Column(name="national_acct_id", length=10)
    public String getNationalAcctId() {
        return this.nationalAcctId;
    }
    
    public void setNationalAcctId(String nationalAcctId) {
        this.nationalAcctId = nationalAcctId;
    }
    
    @Column(name="special_flg", length=1)
    public String getSpecialFlg() {
        return this.specialFlg;
    }
    
    public void setSpecialFlg(String specialFlg) {
        this.specialFlg = specialFlg;
    }




}

