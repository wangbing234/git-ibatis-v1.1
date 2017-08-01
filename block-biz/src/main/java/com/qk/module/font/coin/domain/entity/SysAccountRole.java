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
@TableName(name="sys_account_role")
public class SysAccountRole  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_id")
	    private String accountId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="role_id")
	    private String roleId;  
 
	    public void setAccountId(String accountId) {  
	        this.accountId = accountId;  
	    }  
	      
	    public String getAccountId() {  
	        return this.accountId;  
	    }  
	    public void setRoleId(String roleId) {  
	        this.roleId = roleId;  
	    }  
	      
	    public String getRoleId() {  
	        return this.roleId;  
	    }  
 
}