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
@TableName(name="biz_exit")
public class Exit  extends Po{  
      
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
	     * 提取类型  
	     */ 
    	@FieldName(name="exit_type")
	    private String exitType;  
	    /**  
	     * 提取金额  
	     */ 
	    private Integer amount;  
	    /**  
	     * 团队编号  
	     */ 
    	@FieldName(name="group_id")
	    private Integer groupId;  
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
	     * 会员姓名  
	     */ 
    	@FieldName(name="meb_name")
	    private String mebName;  
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
	    /**  
	     * 银行卡号  
	     */ 
    	@FieldName(name="Bank_num")
	    private String bankNum;  
	    /**  
	     * 开户行  
	     */ 
    	@FieldName(name="Deposit_bank")
	    private String depositBank;  
	    /**  
	     * 开户行明细  
	     */ 
    	@FieldName(name="Detail_bank")
	    private String detailBank;  
 
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
	    public void setExitType(String exitType) {  
	        this.exitType = exitType;  
	    }  
	      
	    public String getExitType() {  
	        return this.exitType;  
	    }  
	    public void setAmount(Integer amount) {  
	        this.amount = amount;  
	    }  
	      
	    public Integer getAmount() {  
	        return this.amount;  
	    }  
	    public void setGroupId(Integer groupId) {  
	        this.groupId = groupId;  
	    }  
	      
	    public Integer getGroupId() {  
	        return this.groupId;  
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
	    public void setMebName(String mebName) {  
	        this.mebName = mebName;  
	    }  
	      
	    public String getMebName() {  
	        return this.mebName;  
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
	    public void setBankNum(String bankNum) {  
	        this.bankNum = bankNum;  
	    }  
	      
	    public String getBankNum() {  
	        return this.bankNum;  
	    }  
	    public void setDepositBank(String depositBank) {  
	        this.depositBank = depositBank;  
	    }  
	      
	    public String getDepositBank() {  
	        return this.depositBank;  
	    }  
	    public void setDetailBank(String detailBank) {  
	        this.detailBank = detailBank;  
	    }  
	      
	    public String getDetailBank() {  
	        return this.detailBank;  
	    }  
 
}