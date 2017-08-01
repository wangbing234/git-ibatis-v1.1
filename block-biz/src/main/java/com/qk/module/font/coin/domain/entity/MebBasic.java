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
@TableName(name="meb_basic")
public class MebBasic  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="id")
	    private Integer id;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_phone")
	    private String mebPhone;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_name")
	    private String mebName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_pwd")
	    private String mebPwd;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_pwd_pay")
	    private String mebPwdPay;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Create_ip")
	    private String createIp;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="is_valid")
	    private String isValid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="last_login_time")
	    private Date lastLoginTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="last_login_ip")
	    private String lastLoginIp;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_identity")
	    private String mebIdentity;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="auth_time")
	    private Date authTime;  
 
	    public void setId(Integer id) {  
	        this.id = id;  
	    }  
	      
	    public Integer getId() {  
	        return this.id;  
	    }  
	    public void setMebPhone(String mebPhone) {  
	        this.mebPhone = mebPhone;  
	    }  
	      
	    public String getMebPhone() {  
	        return this.mebPhone;  
	    }  
	    public void setMebName(String mebName) {  
	        this.mebName = mebName;  
	    }  
	      
	    public String getMebName() {  
	        return this.mebName;  
	    }  
	    public void setMebPwd(String mebPwd) {  
	        this.mebPwd = mebPwd;  
	    }  
	      
	    public String getMebPwd() {  
	        return this.mebPwd;  
	    }  
	    public void setMebPwdPay(String mebPwdPay) {  
	        this.mebPwdPay = mebPwdPay;  
	    }  
	      
	    public String getMebPwdPay() {  
	        return this.mebPwdPay;  
	    }  
	    public void setCreateIp(String createIp) {  
	        this.createIp = createIp;  
	    }  
	      
	    public String getCreateIp() {  
	        return this.createIp;  
	    }  
	    public void setIsValid(String isValid) {  
	        this.isValid = isValid;  
	    }  
	      
	    public String getIsValid() {  
	        return this.isValid;  
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
	    public String getLastLoginTimeString() {  
	        return DateUtil.formatDatetime(getLastLoginTime());  
	    }  
	    public void setLastLoginTime(Date lastLoginTime) {  
	        this.lastLoginTime = lastLoginTime;  
	    }  
	      
	    public Date getLastLoginTime() {  
	        return this.lastLoginTime;  
	    }  
	    public void setLastLoginIp(String lastLoginIp) {  
	        this.lastLoginIp = lastLoginIp;  
	    }  
	      
	    public String getLastLoginIp() {  
	        return this.lastLoginIp;  
	    }  
	    public void setMebIdentity(String mebIdentity) {  
	        this.mebIdentity = mebIdentity;  
	    }  
	      
	    public String getMebIdentity() {  
	        return this.mebIdentity;  
	    }  
	    public String getAuthTimeString() {  
	        return DateUtil.formatDatetime(getAuthTime());  
	    }  
	    public void setAuthTime(Date authTime) {  
	        this.authTime = authTime;  
	    }  
	      
	    public Date getAuthTime() {  
	        return this.authTime;  
	    }  
 
}