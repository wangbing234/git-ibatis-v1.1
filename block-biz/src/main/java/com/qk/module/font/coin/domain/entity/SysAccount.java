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
@TableName(name="sys_account")
public class SysAccount  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_id")
	    private String accountId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_password")
	    private String accountPassword;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_status")
	    private Integer accountStatus;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_inv_date")
	    private Date accountInvDate;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_name")
	    private String accountName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_orgn")
	    private String accountOrgn;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_position")
	    private String accountPosition;  
 
	    public void setAccountId(String accountId) {  
	        this.accountId = accountId;  
	    }  
	      
	    public String getAccountId() {  
	        return this.accountId;  
	    }  
	    public void setAccountPassword(String accountPassword) {  
	        this.accountPassword = accountPassword;  
	    }  
	      
	    public String getAccountPassword() {  
	        return this.accountPassword;  
	    }  
	    public void setAccountStatus(Integer accountStatus) {  
	        this.accountStatus = accountStatus;  
	    }  
	      
	    public Integer getAccountStatus() {  
	        return this.accountStatus;  
	    }  
	    public String getAccountInvDateString() {  
	        return DateUtil.formatDatetime(getAccountInvDate());  
	    }  
	    public void setAccountInvDate(Date accountInvDate) {  
	        this.accountInvDate = accountInvDate;  
	    }  
	      
	    public Date getAccountInvDate() {  
	        return this.accountInvDate;  
	    }  
	    public void setAccountName(String accountName) {  
	        this.accountName = accountName;  
	    }  
	      
	    public String getAccountName() {  
	        return this.accountName;  
	    }  
	    public void setAccountOrgn(String accountOrgn) {  
	        this.accountOrgn = accountOrgn;  
	    }  
	      
	    public String getAccountOrgn() {  
	        return this.accountOrgn;  
	    }  
	    public void setAccountPosition(String accountPosition) {  
	        this.accountPosition = accountPosition;  
	    }  
	      
	    public String getAccountPosition() {  
	        return this.accountPosition;  
	    }  
 
}