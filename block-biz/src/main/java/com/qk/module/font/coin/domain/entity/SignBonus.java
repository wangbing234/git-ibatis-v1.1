/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.module.font.coin.domain.entity;
import com.qk.core.ibatis.annotation.po.FieldName;
import com.qk.core.ibatis.annotation.po.TableName;
import com.qk.core.ibatis.beans.Po;
/**
 *   数据实体类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@TableName(name="sign_bonus")
public class SignBonus  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_id")
	    private String bonusId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_name")
	    private String bonusName;  
	    /**  
	     * 签到天数要求  
	     */ 
    	@FieldName(name="sign_days")
	    private Integer signDays;  
	    /**  
	     * 奖励次数  
	     */ 
    	@FieldName(name="bonus_count")
	    private Integer bonusCount;  
	    /**  
	     * 奖励  
	     */ 
    	@FieldName(name="bonus_amount")
	    private Integer bonusAmount;  
	    /**  
	     * 随机奖励  
	     */ 
    	@FieldName(name="bonus_amount2")
	    private Integer bonusAmount2;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="is_valid")
	    private String isValid;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setBonusId(String bonusId) {  
	        this.bonusId = bonusId;  
	    }  
	      
	    public String getBonusId() {  
	        return this.bonusId;  
	    }  
	    public void setBonusName(String bonusName) {  
	        this.bonusName = bonusName;  
	    }  
	      
	    public String getBonusName() {  
	        return this.bonusName;  
	    }  
	    public void setSignDays(Integer signDays) {  
	        this.signDays = signDays;  
	    }  
	      
	    public Integer getSignDays() {  
	        return this.signDays;  
	    }  
	    public void setBonusCount(Integer bonusCount) {  
	        this.bonusCount = bonusCount;  
	    }  
	      
	    public Integer getBonusCount() {  
	        return this.bonusCount;  
	    }  
	    public void setBonusAmount(Integer bonusAmount) {  
	        this.bonusAmount = bonusAmount;  
	    }  
	      
	    public Integer getBonusAmount() {  
	        return this.bonusAmount;  
	    }  
	    public void setBonusAmount2(Integer bonusAmount2) {  
	        this.bonusAmount2 = bonusAmount2;  
	    }  
	      
	    public Integer getBonusAmount2() {  
	        return this.bonusAmount2;  
	    }  
	    public void setIsValid(String isValid) {  
	        this.isValid = isValid;  
	    }  
	      
	    public String getIsValid() {  
	        return this.isValid;  
	    }  
 
}