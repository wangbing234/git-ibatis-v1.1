/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.role.entity;
import com.qk.core.ibatis.annotation.po.TableName;
import com.qk.core.ibatis.annotation.po.TempField;
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
@TableName(name="t_role")
public class Role  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer id;  
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
	    /**  
	     *   
	     */ 
    	@FieldName(name="role_db_privilege")
	    private String roleDbPrivilege;  
    	
    	@TempField
    	private String privileges;
	    /**  
	     *   
	     */ 
	    private String status;  
 
	    public void setId(Integer id) {  
	        this.id = id;  
	    }  
	      
	    public Integer getId() {  
	        return this.id;  
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
	    public void setRoleDbPrivilege(String roleDbPrivilege) { 
	        this.roleDbPrivilege = roleDbPrivilege;  
	    }  
	      
	    public String getRoleDbPrivilege() {  
	        return this.roleDbPrivilege;  
	    }  
	    public void setStatus(String status) {  
	        this.status = status;  
	    }  
	      
	    public String getStatus() {  
	        return this.status;  
	    }

		public String getPrivileges() {
			return privileges;
		}

		public void setPrivileges(String privileges) {
			this.privileges = privileges;
		}  
	    
 
}