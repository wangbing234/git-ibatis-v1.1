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
@TableName(name="core_param")
public class CoreParam  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private String name;  
	    /**  
	     *   
	     */ 
	    private String desc;  
	    /**  
	     *   
	     */ 
	    private String value;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="next_value")
	    private String nextValue;  
 
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	      
	    public String getName() {  
	        return this.name;  
	    }  
	    public void setDesc(String desc) {  
	        this.desc = desc;  
	    }  
	      
	    public String getDesc() {  
	        return this.desc;  
	    }  
	    public void setValue(String value) {  
	        this.value = value;  
	    }  
	      
	    public String getValue() {  
	        return this.value;  
	    }  
	    public void setNextValue(String nextValue) {  
	        this.nextValue = nextValue;  
	    }  
	      
	    public String getNextValue() {  
	        return this.nextValue;  
	    }  
 
}