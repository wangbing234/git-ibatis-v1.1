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
@TableName(name="sys_datadictionary")
public class SysDatadictionary  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="dd_key")
	    private String ddKey;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="dd_value")
	    private String ddValue;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="dd_text")
	    private String ddText;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="dd_desc")
	    private String ddDesc;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="dd_flag")
	    private Integer ddFlag;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="dd_order")
	    private Integer ddOrder;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="dd_enabled")
	    private Integer ddEnabled;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="is_frame")
	    private String isFrame;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setDdKey(String ddKey) {  
	        this.ddKey = ddKey;  
	    }  
	      
	    public String getDdKey() {  
	        return this.ddKey;  
	    }  
	    public void setDdValue(String ddValue) {  
	        this.ddValue = ddValue;  
	    }  
	      
	    public String getDdValue() {  
	        return this.ddValue;  
	    }  
	    public void setDdText(String ddText) {  
	        this.ddText = ddText;  
	    }  
	      
	    public String getDdText() {  
	        return this.ddText;  
	    }  
	    public void setDdDesc(String ddDesc) {  
	        this.ddDesc = ddDesc;  
	    }  
	      
	    public String getDdDesc() {  
	        return this.ddDesc;  
	    }  
	    public void setDdFlag(Integer ddFlag) {  
	        this.ddFlag = ddFlag;  
	    }  
	      
	    public Integer getDdFlag() {  
	        return this.ddFlag;  
	    }  
	    public void setDdOrder(Integer ddOrder) {  
	        this.ddOrder = ddOrder;  
	    }  
	      
	    public Integer getDdOrder() {  
	        return this.ddOrder;  
	    }  
	    public void setDdEnabled(Integer ddEnabled) {  
	        this.ddEnabled = ddEnabled;  
	    }  
	      
	    public Integer getDdEnabled() {  
	        return this.ddEnabled;  
	    }  
	    public void setIsFrame(String isFrame) {  
	        this.isFrame = isFrame;  
	    }  
	      
	    public String getIsFrame() {  
	        return this.isFrame;  
	    }  
 
}