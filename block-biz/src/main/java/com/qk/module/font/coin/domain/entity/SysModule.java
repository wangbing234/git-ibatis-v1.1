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
@TableName(name="sys_module")
public class SysModule  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_id")
	    private String moduleId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_name")
	    private String moduleName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="pmodule_id")
	    private String pmoduleId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_level")
	    private Integer moduleLevel;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_entry")
	    private String moduleEntry;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_type")
	    private String moduleType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_valid")
	    private String moduleValid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_order")
	    private Long moduleOrder;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="module_css")
	    private String moduleCss;  
 
	    public void setModuleId(String moduleId) {  
	        this.moduleId = moduleId;  
	    }  
	      
	    public String getModuleId() {  
	        return this.moduleId;  
	    }  
	    public void setModuleName(String moduleName) {  
	        this.moduleName = moduleName;  
	    }  
	      
	    public String getModuleName() {  
	        return this.moduleName;  
	    }  
	    public void setPmoduleId(String pmoduleId) {  
	        this.pmoduleId = pmoduleId;  
	    }  
	      
	    public String getPmoduleId() {  
	        return this.pmoduleId;  
	    }  
	    public void setModuleLevel(Integer moduleLevel) {  
	        this.moduleLevel = moduleLevel;  
	    }  
	      
	    public Integer getModuleLevel() {  
	        return this.moduleLevel;  
	    }  
	    public void setModuleEntry(String moduleEntry) {  
	        this.moduleEntry = moduleEntry;  
	    }  
	      
	    public String getModuleEntry() {  
	        return this.moduleEntry;  
	    }  
	    public void setModuleType(String moduleType) {  
	        this.moduleType = moduleType;  
	    }  
	      
	    public String getModuleType() {  
	        return this.moduleType;  
	    }  
	    public void setModuleValid(String moduleValid) {  
	        this.moduleValid = moduleValid;  
	    }  
	      
	    public String getModuleValid() {  
	        return this.moduleValid;  
	    }  
	    public void setModuleOrder(Long moduleOrder) {  
	        this.moduleOrder = moduleOrder;  
	    }  
	      
	    public Long getModuleOrder() {  
	        return this.moduleOrder;  
	    }  
	    public void setModuleCss(String moduleCss) {  
	        this.moduleCss = moduleCss;  
	    }  
	      
	    public String getModuleCss() {  
	        return this.moduleCss;  
	    }  
 
}