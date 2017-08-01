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
@TableName(name="meb_wallet_log")
public class MebWalletLog  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="Rid")
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="wallet_type")
	    private String walletType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="wallet_sub_type")
	    private String walletSubType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Change_amount")
	    private Float changeAmount;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="new_amount")
	    private Float newAmount;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Change_reason")
	    private String changeReason;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="change_id")
	    private Integer changeId;  
	    /**  
	     *   
	     */ 
	    private String oper;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="oper_remark")
	    private String operRemark;  
 
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
	    public void setWalletType(String walletType) {  
	        this.walletType = walletType;  
	    }  
	      
	    public String getWalletType() {  
	        return this.walletType;  
	    }  
	    public void setWalletSubType(String walletSubType) {  
	        this.walletSubType = walletSubType;  
	    }  
	      
	    public String getWalletSubType() {  
	        return this.walletSubType;  
	    }  
	    public void setChangeAmount(Float changeAmount) {  
	        this.changeAmount = changeAmount;  
	    }  
	      
	    public Float getChangeAmount() {  
	        return this.changeAmount;  
	    }  
	    public void setNewAmount(Float newAmount) {  
	        this.newAmount = newAmount;  
	    }  
	      
	    public Float getNewAmount() {  
	        return this.newAmount;  
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
	    public void setChangeReason(String changeReason) {  
	        this.changeReason = changeReason;  
	    }  
	      
	    public String getChangeReason() {  
	        return this.changeReason;  
	    }  
	    public void setChangeId(Integer changeId) {  
	        this.changeId = changeId;  
	    }  
	      
	    public Integer getChangeId() {  
	        return this.changeId;  
	    }  
	    public void setOper(String oper) {  
	        this.oper = oper;  
	    }  
	      
	    public String getOper() {  
	        return this.oper;  
	    }  
	    public void setOperRemark(String operRemark) {  
	        this.operRemark = operRemark;  
	    }  
	      
	    public String getOperRemark() {  
	        return this.operRemark;  
	    }  
 
}