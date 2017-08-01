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
@TableName(name="sms_array")
public class SmsArray  extends Po{  
      
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
    	@FieldName(name="sms_phone")
	    private String smsPhone;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="sms_no")
	    private String smsNo;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="sms_args")
	    private String smsArgs;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="sms_type")
	    private String smsType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="send_time")
	    private Date sendTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="ret_code")
	    private String retCode;  
 
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
	    public void setSmsPhone(String smsPhone) {  
	        this.smsPhone = smsPhone;  
	    }  
	      
	    public String getSmsPhone() {  
	        return this.smsPhone;  
	    }  
	    public void setSmsNo(String smsNo) {  
	        this.smsNo = smsNo;  
	    }  
	      
	    public String getSmsNo() {  
	        return this.smsNo;  
	    }  
	    public void setSmsArgs(String smsArgs) {  
	        this.smsArgs = smsArgs;  
	    }  
	      
	    public String getSmsArgs() {  
	        return this.smsArgs;  
	    }  
	    public void setSmsType(String smsType) {  
	        this.smsType = smsType;  
	    }  
	      
	    public String getSmsType() {  
	        return this.smsType;  
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
	    public String getSendTimeString() {  
	        return DateUtil.formatDatetime(getSendTime());  
	    }  
	    public void setSendTime(Date sendTime) {  
	        this.sendTime = sendTime;  
	    }  
	      
	    public Date getSendTime() {  
	        return this.sendTime;  
	    }  
	    public void setRetCode(String retCode) {  
	        this.retCode = retCode;  
	    }  
	      
	    public String getRetCode() {  
	        return this.retCode;  
	    }  
 
}