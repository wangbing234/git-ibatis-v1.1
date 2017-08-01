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
@TableName(name="biz_bonus_grow")
public class BonusGrow  extends Po{  
      
	    /**  
	     * 主键id  
	     */ 
	    private Integer id;  
	    /**  
	     * 团队提成比例  
	     */ 
    	@FieldName(name="group_rate")
	    private Float groupRate;  
	    /**  
	     * 团队提成金额  
	     */ 
    	@FieldName(name="group_grow")
	    private Integer groupGrow;  
	    /**  
	     * 推荐奖比例  
	     */ 
    	@FieldName(name="reward_grow_rate")
	    private Float rewardGrowRate;  
	    /**  
	     * 推荐奖金额  
	     */ 
    	@FieldName(name="reward_grow")
	    private Integer rewardGrow;  
	    /**  
	     * 推荐人  
	     */ 
	    private Integer referee;  
	    /**  
	     * 提成等级 1 – 直推3人  
	     */ 
    	@FieldName(name="grow_lv")
	    private Integer growLv;  
	    /**  
	     * 提成比例  
	     */ 
    	@FieldName(name="grow_rate")
	    private Float growRate;  
	    /**  
	     * 提成金额  
	     */ 
    	@FieldName(name="grow_amount")
	    private Integer growAmount;  
	    /**  
	     * 直推人数  
	     */ 
    	@FieldName(name="group_count")
	    private Integer groupCount;  
	    /**  
	     * 二级推荐人  
	     */ 
	    private Integer referee2;  
	    /**  
	     * 提成等级  
	     */ 
    	@FieldName(name="grow2_lv")
	    private Integer grow2Lv;  
	    /**  
	     * 提成比例  
	     */ 
    	@FieldName(name="grow2_rate")
	    private Float grow2Rate;  
	    /**  
	     * 提成金额  
	     */ 
    	@FieldName(name="grow2_amount")
	    private Integer grow2Amount;  
	    /**  
	     * 二级直推人数  
	     */ 
    	@FieldName(name="group2_count")
	    private Integer group2Count;  
 
	    public void setId(Integer id) {  
	        this.id = id;  
	    }  
	      
	    public Integer getId() {  
	        return this.id;  
	    }  
	    public void setGroupRate(Float groupRate) {  
	        this.groupRate = groupRate;  
	    }  
	      
	    public Float getGroupRate() {  
	        return this.groupRate;  
	    }  
	    public void setGroupGrow(Integer groupGrow) {  
	        this.groupGrow = groupGrow;  
	    }  
	      
	    public Integer getGroupGrow() {  
	        return this.groupGrow;  
	    }  
	    public void setRewardGrowRate(Float rewardGrowRate) {  
	        this.rewardGrowRate = rewardGrowRate;  
	    }  
	      
	    public Float getRewardGrowRate() {  
	        return this.rewardGrowRate;  
	    }  
	    public void setRewardGrow(Integer rewardGrow) {  
	        this.rewardGrow = rewardGrow;  
	    }  
	      
	    public Integer getRewardGrow() {  
	        return this.rewardGrow;  
	    }  
	    public void setReferee(Integer referee) {  
	        this.referee = referee;  
	    }  
	      
	    public Integer getReferee() {  
	        return this.referee;  
	    }  
	    public void setGrowLv(Integer growLv) {  
	        this.growLv = growLv;  
	    }  
	      
	    public Integer getGrowLv() {  
	        return this.growLv;  
	    }  
	    public void setGrowRate(Float growRate) {  
	        this.growRate = growRate;  
	    }  
	      
	    public Float getGrowRate() {  
	        return this.growRate;  
	    }  
	    public void setGrowAmount(Integer growAmount) {  
	        this.growAmount = growAmount;  
	    }  
	      
	    public Integer getGrowAmount() {  
	        return this.growAmount;  
	    }  
	    public void setGroupCount(Integer groupCount) {  
	        this.groupCount = groupCount;  
	    }  
	      
	    public Integer getGroupCount() {  
	        return this.groupCount;  
	    }  
	    public void setReferee2(Integer referee2) {  
	        this.referee2 = referee2;  
	    }  
	      
	    public Integer getReferee2() {  
	        return this.referee2;  
	    }  
	    public void setGrow2Lv(Integer grow2Lv) {  
	        this.grow2Lv = grow2Lv;  
	    }  
	      
	    public Integer getGrow2Lv() {  
	        return this.grow2Lv;  
	    }  
	    public void setGrow2Rate(Float grow2Rate) {  
	        this.grow2Rate = grow2Rate;  
	    }  
	      
	    public Float getGrow2Rate() {  
	        return this.grow2Rate;  
	    }  
	    public void setGrow2Amount(Integer grow2Amount) {  
	        this.grow2Amount = grow2Amount;  
	    }  
	      
	    public Integer getGrow2Amount() {  
	        return this.grow2Amount;  
	    }  
	    public void setGroup2Count(Integer group2Count) {  
	        this.group2Count = group2Count;  
	    }  
	      
	    public Integer getGroup2Count() {  
	        return this.group2Count;  
	    }  
 
}