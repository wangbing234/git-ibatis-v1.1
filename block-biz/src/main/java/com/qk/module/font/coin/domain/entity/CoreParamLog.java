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
@TableName(name="core_param_log")
public class CoreParamLog  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
	    private String name;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="pre_value")
	    private String preValue;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="new_value")
	    private String newValue;  
	    /**  
	     *   
	     */ 
	    private String oper;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Valid_time")
	    private Date validTime;  
	    /**  
	     *   
	     */ 
	    private String type;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="State")
	    private String state;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	      
	    public String getName() {  
	        return this.name;  
	    }  
	    public void setPreValue(String preValue) {  
	        this.preValue = preValue;  
	    }  
	      
	    public String getPreValue() {  
	        return this.preValue;  
	    }  
	    public void setNewValue(String newValue) {  
	        this.newValue = newValue;  
	    }  
	      
	    public String getNewValue() {  
	        return this.newValue;  
	    }  
	    public void setOper(String oper) {  
	        this.oper = oper;  
	    }  
	      
	    public String getOper() {  
	        return this.oper;  
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
	    public String getValidTimeString() {  
	        return DateUtil.formatDatetime(getValidTime());  
	    }  
	    public void setValidTime(Date validTime) {  
	        this.validTime = validTime;  
	    }  
	      
	    public Date getValidTime() {  
	        return this.validTime;  
	    }  
	    public void setType(String type) {  
	        this.type = type;  
	    }  
	      
	    public String getType() {  
	        return this.type;  
	    }  
	    public void setState(String state) {  
	        this.state = state;  
	    }  
	      
	    public String getState() {  
	        return this.state;  
	    }  
 
}