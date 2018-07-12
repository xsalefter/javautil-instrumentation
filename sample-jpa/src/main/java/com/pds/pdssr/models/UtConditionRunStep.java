package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UtConditionRunStep generated by hbm2java
 */
@Entity
@Table(name="ut_condition_run_step"
)
public class UtConditionRunStep  implements java.io.Serializable {


     private int utConditionRunStepId;
     private UtCondition utCondition;
     private UtConditionRun utConditionRun;
     private Date startTs;
     private Date endTs;
     private Set<UtConditionRowMsg> utConditionRowMsgs = new HashSet<UtConditionRowMsg>(0);

    public UtConditionRunStep() {
    }

	
    public UtConditionRunStep(int utConditionRunStepId, UtCondition utCondition, UtConditionRun utConditionRun, Date startTs) {
        this.utConditionRunStepId = utConditionRunStepId;
        this.utCondition = utCondition;
        this.utConditionRun = utConditionRun;
        this.startTs = startTs;
    }
    public UtConditionRunStep(int utConditionRunStepId, UtCondition utCondition, UtConditionRun utConditionRun, Date startTs, Date endTs, Set<UtConditionRowMsg> utConditionRowMsgs) {
       this.utConditionRunStepId = utConditionRunStepId;
       this.utCondition = utCondition;
       this.utConditionRun = utConditionRun;
       this.startTs = startTs;
       this.endTs = endTs;
       this.utConditionRowMsgs = utConditionRowMsgs;
    }
   
     @Id 
    
    @Column(name="ut_condition_run_step_id", unique=true, nullable=false)
    public int getUtConditionRunStepId() {
        return this.utConditionRunStepId;
    }
    
    public void setUtConditionRunStepId(int utConditionRunStepId) {
        this.utConditionRunStepId = utConditionRunStepId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ut_condition_id", nullable=false)
    public UtCondition getUtCondition() {
        return this.utCondition;
    }
    
    public void setUtCondition(UtCondition utCondition) {
        this.utCondition = utCondition;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ut_condition_run_id", nullable=false)
    public UtConditionRun getUtConditionRun() {
        return this.utConditionRun;
    }
    
    public void setUtConditionRun(UtConditionRun utConditionRun) {
        this.utConditionRun = utConditionRun;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_ts", nullable=false, length=29)
    public Date getStartTs() {
        return this.startTs;
    }
    
    public void setStartTs(Date startTs) {
        this.startTs = startTs;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_ts", length=29)
    public Date getEndTs() {
        return this.endTs;
    }
    
    public void setEndTs(Date endTs) {
        this.endTs = endTs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="utConditionRunStep")
    public Set<UtConditionRowMsg> getUtConditionRowMsgs() {
        return this.utConditionRowMsgs;
    }
    
    public void setUtConditionRowMsgs(Set<UtConditionRowMsg> utConditionRowMsgs) {
        this.utConditionRowMsgs = utConditionRowMsgs;
    }




}

