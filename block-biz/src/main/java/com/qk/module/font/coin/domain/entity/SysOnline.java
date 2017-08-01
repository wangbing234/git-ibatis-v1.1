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
@TableName(name="sys_online")
public class SysOnline  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_id")
	    private String accountId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_name")
	    private String accountName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="session_id")
	    private String sessionId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="login_ip")
	    private String loginIp;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="login_datetime")
	    private Date loginDatetime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="logout_datetime")
	    private Date logoutDatetime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="logout_type")
	    private String logoutType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="last_accessed_time")
	    private Date lastAccessedTime;  
	    /**  
	     *   
	     */ 
	    private Integer rid;  
 
	    public void setAccountId(String accountId) {  
	        this.accountId = accountId;  
	    }  
	      
	    public String getAccountId() {  
	        return this.accountId;  
	    }  
	    public void setAccountName(String accountName) {  
	        this.accountName = accountName;  
	    }  
	      
	    public String getAccountName() {  
	        return this.accountName;  
	    }  
	    public void setSessionId(String sessionId) {  
	        this.sessionId = sessionId;  
	    }  
	      
	    public String getSessionId() {  
	        return this.sessionId;  
	    }  
	    public void setLoginIp(String loginIp) {  
	        this.loginIp = loginIp;  
	    }  
	      
	    public String getLoginIp() {  
	        return this.loginIp;  
	    }  
	    public String getLoginDatetimeString() {  
	        return DateUtil.formatDatetime(getLoginDatetime());  
	    }  
	    public void setLoginDatetime(Date loginDatetime) {  
	        this.loginDatetime = loginDatetime;  
	    }  
	      
	    public Date getLoginDatetime() {  
	        return this.loginDatetime;  
	    }  
	    public String getLogoutDatetimeString() {  
	        return DateUtil.formatDatetime(getLogoutDatetime());  
	    }  
	    public void setLogoutDatetime(Date logoutDatetime) {  
	        this.logoutDatetime = logoutDatetime;  
	    }  
	      
	    public Date getLogoutDatetime() {  
	        return this.logoutDatetime;  
	    }  
	    public void setLogoutType(String logoutType) {  
	        this.logoutType = logoutType;  
	    }  
	      
	    public String getLogoutType() {  
	        return this.logoutType;  
	    }  
	    public String getLastAccessedTimeString() {  
	        return DateUtil.formatDatetime(getLastAccessedTime());  
	    }  
	    public void setLastAccessedTime(Date lastAccessedTime) {  
	        this.lastAccessedTime = lastAccessedTime;  
	    }  
	      
	    public Date getLastAccessedTime() {  
	        return this.lastAccessedTime;  
	    }  
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
 
}