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
@TableName(name="sign_count")
public class SignCount  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_id")
	    private Integer bonusId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="sign_days")
	    private Integer signDays;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_count")
	    private Integer bonusCount;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_sum")
	    private Integer bonusSum;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="is_bonus")
	    private String isBonus;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setMebId(Integer mebId) {  
	        this.mebId = mebId;  
	    }  
	      
	    public Integer getMebId() {  
	        return this.mebId;  
	    }  
	    public void setBonusId(Integer bonusId) {  
	        this.bonusId = bonusId;  
	    }  
	      
	    public Integer getBonusId() {  
	        return this.bonusId;  
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
	    public void setBonusSum(Integer bonusSum) {  
	        this.bonusSum = bonusSum;  
	    }  
	      
	    public Integer getBonusSum() {  
	        return this.bonusSum;  
	    }  
	    public void setIsBonus(String isBonus) {  
	        this.isBonus = isBonus;  
	    }  
	      
	    public String getIsBonus() {  
	        return this.isBonus;  
	    }  
 
}