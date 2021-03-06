package com.pds.pdssr.models;
// Generated Jul 5, 2018 11:41:30 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UtConditionRowMsgId generated by hbm2java
 */
@Embeddable
public class UtConditionRowMsgId  implements java.io.Serializable {


     private int utConditionRunStepId;
     private int tablePk;

    public UtConditionRowMsgId() {
    }

    public UtConditionRowMsgId(int utConditionRunStepId, int tablePk) {
       this.utConditionRunStepId = utConditionRunStepId;
       this.tablePk = tablePk;
    }
   

    @Column(name="ut_condition_run_step_id", nullable=false)
    public int getUtConditionRunStepId() {
        return this.utConditionRunStepId;
    }
    
    public void setUtConditionRunStepId(int utConditionRunStepId) {
        this.utConditionRunStepId = utConditionRunStepId;
    }

    @Column(name="table_pk", nullable=false)
    public int getTablePk() {
        return this.tablePk;
    }
    
    public void setTablePk(int tablePk) {
        this.tablePk = tablePk;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UtConditionRowMsgId) ) return false;
		 UtConditionRowMsgId castOther = ( UtConditionRowMsgId ) other; 
         
		 return (this.getUtConditionRunStepId()==castOther.getUtConditionRunStepId())
 && (this.getTablePk()==castOther.getTablePk());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUtConditionRunStepId();
         result = 37 * result + this.getTablePk();
         return result;
   }   


}


