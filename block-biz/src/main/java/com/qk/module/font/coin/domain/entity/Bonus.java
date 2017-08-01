/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.module.font.coin.domain.entity;
import com.qk.core.ibatis.annotation.po.TableName;
import com.qk.core.ibatis.annotation.po.FieldName;
import com.qk.core.ibatis.beans.Po;
import com.qk.core.ibatis.util.date.DateUtil;
import java.util.Date;
/**
 *   数据实体类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@TableName(name="biz_bonus")
public class Bonus  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     * 会员编号  
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     * 分红次数  
	     */ 
	    private Integer count;  
	    /**  
	     * 分红金额  
	     */ 
	    private Integer amount;  
	    /**  
	     * 分红利率  
	     */ 
    	@FieldName(name="bonus_rate")
	    private Double bonusRate;  
	    /**  
	     * 分红红利  
	     */ 
    	@FieldName(name="bonus_amount")
	    private Integer bonusAmount;  
	    /**  
	     * 计息次数  
	     */ 
    	@FieldName(name="bonus_count")
	    private Integer bonusCount;  
	    /**  
	     * 1-初始、2-已解冻  
	     */ 
	    private String state;  
	    /**  
	     * 创建时间  
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     * 实际解冻时间  
	     */ 
    	@FieldName(name="unfreeze_time")
	    private Date unfreezeTime;  
	    /**  
	     * 预计解冻时间  
	     */ 
    	@FieldName(name="to_unfreeze_time")
	    private Date toUnfreezeTime;  
	    /**  
	     * 赠送积分是否成功 1：初始，2，赠送完成  
	     */ 
    	@FieldName(name="point_flag")
	    private String pointFlag;  
 
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
	    public void setCount(Integer count) {  
	        this.count = count;  
	    }  
	      
	    public Integer getCount() {  
	        return this.count;  
	    }  
	    public void setAmount(Integer amount) {  
	        this.amount = amount;  
	    }  
	      
	    public Integer getAmount() {  
	        return this.amount;  
	    }  
	    public void setBonusRate(Double bonusRate) {  
	        this.bonusRate = bonusRate;  
	    }  
	      
	    public Double getBonusRate() {  
	        return this.bonusRate;  
	    }  
	    public void setBonusAmount(Integer bonusAmount) {  
	        this.bonusAmount = bonusAmount;  
	    }  
	      
	    public Integer getBonusAmount() {  
	        return this.bonusAmount;  
	    }  
	    public void setBonusCount(Integer bonusCount) {  
	        this.bonusCount = bonusCount;  
	    }  
	      
	    public Integer getBonusCount() {  
	        return this.bonusCount;  
	    }  
	    public void setState(String state) {  
	        this.state = state;  
	    }  
	      
	    public String getState() {  
	        return this.state;  
	    }  
	    public String getCreateTimeString() {  
	        return DateUtil.formatDatetime(getCreateTime());  
	    }  
	    public void setCreateTime(Date createTime) {  
	        this.createTime = createTime;  
	    }  
	      
	    public Date getCreateTime() {  
	        return this.createTime;  
	    }  
	    public String getUnfreezeTimeString() {  
	        return DateUtil.formatDatetime(getUnfreezeTime());  
	    }  
	    public void setUnfreezeTime(Date unfreezeTime) {  
	        this.unfreezeTime = unfreezeTime;  
	    }  
	      
	    public Date getUnfreezeTime() {  
	        return this.unfreezeTime;  
	    }  
	    public String getToUnfreezeTimeString() {  
	        return DateUtil.formatDatetime(getToUnfreezeTime());  
	    }  
	    public void setToUnfreezeTime(Date toUnfreezeTime) {  
	        this.toUnfreezeTime = toUnfreezeTime;  
	    }  
	      
	    public Date getToUnfreezeTime() {  
	        return this.toUnfreezeTime;  
	    }  
	    public void setPointFlag(String pointFlag) {  
	        this.pointFlag = pointFlag;  
	    }  
	      
	    public String getPointFlag() {  
	        return this.pointFlag;  
	    }  
 
}