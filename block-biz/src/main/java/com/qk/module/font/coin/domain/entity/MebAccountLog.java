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
@TableName(name="meb_account_log")
public class MebAccountLog  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="Rid")
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Pre_value")
	    private String preValue;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="new_value")
	    private String newValue;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="account_type")
	    private String accountType;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setMebId(Integer mebId) {  
	        this.mebId = mebId;  
	    }  
	      
	    public Integer getMebId() {  
	        return this.mebId;  
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
	    public String getCreateTimeString() {  
	        return DateUtil.formatDatetime(getCreateTime());  
	    }  
	    public void setCreateTime(Date createTime) {  
	        this.createTime = createTime;  
	    }  
	      
	    public Date getCreateTime() {  
	        return this.createTime;  
	    }  
	    public void setAccountType(String accountType) {  
	        this.accountType = accountType;  
	    }  
	      
	    public String getAccountType() {  
	        return this.accountType;  
	    }  
 
}