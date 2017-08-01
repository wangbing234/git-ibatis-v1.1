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
@TableName(name="sys_orgn")
public class SysOrgn  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_id")
	    private String orgnId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_name")
	    private String orgnName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="porgn_id")
	    private String porgnId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_code")
	    private String orgnCode;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_level")
	    private String orgnLevel;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_type")
	    private String orgnType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_status")
	    private String orgnStatus;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_addr")
	    private String orgnAddr;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="orgn_tel")
	    private String orgnTel;  
 
	    public void setOrgnId(String orgnId) {  
	        this.orgnId = orgnId;  
	    }  
	      
	    public String getOrgnId() {  
	        return this.orgnId;  
	    }  
	    public void setOrgnName(String orgnName) {  
	        this.orgnName = orgnName;  
	    }  
	      
	    public String getOrgnName() {  
	        return this.orgnName;  
	    }  
	    public void setPorgnId(String porgnId) {  
	        this.porgnId = porgnId;  
	    }  
	      
	    public String getPorgnId() {  
	        return this.porgnId;  
	    }  
	    public void setOrgnCode(String orgnCode) {  
	        this.orgnCode = orgnCode;  
	    }  
	      
	    public String getOrgnCode() {  
	        return this.orgnCode;  
	    }  
	    public void setOrgnLevel(String orgnLevel) {  
	        this.orgnLevel = orgnLevel;  
	    }  
	      
	    public String getOrgnLevel() {  
	        return this.orgnLevel;  
	    }  
	    public void setOrgnType(String orgnType) {  
	        this.orgnType = orgnType;  
	    }  
	      
	    public String getOrgnType() {  
	        return this.orgnType;  
	    }  
	    public void setOrgnStatus(String orgnStatus) {  
	        this.orgnStatus = orgnStatus;  
	    }  
	      
	    public String getOrgnStatus() {  
	        return this.orgnStatus;  
	    }  
	    public void setOrgnAddr(String orgnAddr) {  
	        this.orgnAddr = orgnAddr;  
	    }  
	      
	    public String getOrgnAddr() {  
	        return this.orgnAddr;  
	    }  
	    public void setOrgnTel(String orgnTel) {  
	        this.orgnTel = orgnTel;  
	    }  
	      
	    public String getOrgnTel() {  
	        return this.orgnTel;  
	    }  
 
}