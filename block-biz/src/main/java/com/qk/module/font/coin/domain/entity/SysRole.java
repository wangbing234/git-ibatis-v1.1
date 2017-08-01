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
@TableName(name="sys_role")
public class SysRole  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="role_name")
	    private String roleName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="role_desc")
	    private String roleDesc;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setRoleName(String roleName) {  
	        this.roleName = roleName;  
	    }  
	      
	    public String getRoleName() {  
	        return this.roleName;  
	    }  
	    public void setRoleDesc(String roleDesc) {  
	        this.roleDesc = roleDesc;  
	    }  
	      
	    public String getRoleDesc() {  
	        return this.roleDesc;  
	    }  
 
}