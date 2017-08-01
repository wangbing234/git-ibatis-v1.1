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
@TableName(name="biz_exit_base")
public class ExitBase  extends Po{  
      
	    /**  
	     * 系统编号  
	     */ 
    	@FieldName(name="Rid")
	    private Integer rid;  
	    /**  
	     * 会员编号  
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     * 创建时间  
	     */ 
    	@FieldName(name="Create_time")
	    private Date createTime;  
	    /**  
	     * 提取金额  
	     */ 
	    private Integer amount;  
	    /**  
	     * 免手续费金额  
	     */ 
    	@FieldName(name="free_amount")
	    private Integer freeAmount;  
	    /**  
	     * 手续费费率  
	     */ 
    	@FieldName(name="fee_rate")
	    private Float feeRate;  
	    /**  
	     * 手续费  
	     */ 
	    private Integer fee;  
	    /**  
	     * 打款时间  
	     */ 
    	@FieldName(name="exit_time")
	    private Integer exitTime;  
	    /**  
	     * 状态  
	     */ 
	    private String state;  
	    /**  
	     * 操作人  
	     */ 
	    private String oper;  
	    /**  
	     * 操作时间  
	     */ 
    	@FieldName(name="oper_time")
	    private Date operTime;  
 
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
	    public String getCreateTimeString() {  
	        return DateUtil.formatDatetime(getCreateTime());  
	    }  
	    public void setCreateTime(Date createTime) {  
	        this.createTime = createTime;  
	    }  
	      
	    public Date getCreateTime() {  
	        return this.createTime;  
	    }  
	    public void setAmount(Integer amount) {  
	        this.amount = amount;  
	    }  
	      
	    public Integer getAmount() {  
	        return this.amount;  
	    }  
	    public void setFreeAmount(Integer freeAmount) {  
	        this.freeAmount = freeAmount;  
	    }  
	      
	    public Integer getFreeAmount() {  
	        return this.freeAmount;  
	    }  
	    public void setFeeRate(Float feeRate) {  
	        this.feeRate = feeRate;  
	    }  
	      
	    public Float getFeeRate() {  
	        return this.feeRate;  
	    }  
	    public void setFee(Integer fee) {  
	        this.fee = fee;  
	    }  
	      
	    public Integer getFee() {  
	        return this.fee;  
	    }  
	    public void setExitTime(Integer exitTime) {  
	        this.exitTime = exitTime;  
	    }  
	      
	    public Integer getExitTime() {  
	        return this.exitTime;  
	    }  
	    public void setState(String state) {  
	        this.state = state;  
	    }  
	      
	    public String getState() {  
	        return this.state;  
	    }  
	    public void setOper(String oper) {  
	        this.oper = oper;  
	    }  
	      
	    public String getOper() {  
	        return this.oper;  
	    }  
	    public String getOperTimeString() {  
	        return DateUtil.formatDatetime(getOperTime());  
	    }  
	    public void setOperTime(Date operTime) {  
	        this.operTime = operTime;  
	    }  
	      
	    public Date getOperTime() {  
	        return this.operTime;  
	    }  
 
}