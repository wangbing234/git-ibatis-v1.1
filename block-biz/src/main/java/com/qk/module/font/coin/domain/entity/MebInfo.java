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
@TableName(name="meb_info")
public class MebInfo  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_phone")
	    private String mebPhone;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_name")
	    private String mebName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_state")
	    private String mebState;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_type")
	    private String mebType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_level")
	    private Integer mebLevel;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_referee")
	    private Integer mebReferee;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_referee2")
	    private Integer mebReferee2;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_referee3")
	    private Integer mebReferee3;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="last_state_time")
	    private Date lastStateTime;  
 
	    public void setMebId(Integer mebId) {  
	        this.mebId = mebId;  
	    }  
	      
	    public Integer getMebId() {  
	        return this.mebId;  
	    }  
	    public void setMebPhone(String mebPhone) {  
	        this.mebPhone = mebPhone;  
	    }  
	      
	    public String getMebPhone() {  
	        return this.mebPhone;  
	    }  
	    public void setMebName(String mebName) {  
	        this.mebName = mebName;  
	    }  
	      
	    public String getMebName() {  
	        return this.mebName;  
	    }  
	    public void setMebState(String mebState) {  
	        this.mebState = mebState;  
	    }  
	      
	    public String getMebState() {  
	        return this.mebState;  
	    }  
	    public void setMebType(String mebType) {  
	        this.mebType = mebType;  
	    }  
	      
	    public String getMebType() {  
	        return this.mebType;  
	    }  
	    public void setMebLevel(Integer mebLevel) {  
	        this.mebLevel = mebLevel;  
	    }  
	      
	    public Integer getMebLevel() {  
	        return this.mebLevel;  
	    }  
	    public void setMebReferee(Integer mebReferee) {  
	        this.mebReferee = mebReferee;  
	    }  
	      
	    public Integer getMebReferee() {  
	        return this.mebReferee;  
	    }  
	    public void setMebReferee2(Integer mebReferee2) {  
	        this.mebReferee2 = mebReferee2;  
	    }  
	      
	    public Integer getMebReferee2() {  
	        return this.mebReferee2;  
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
	    public void setMebReferee3(Integer mebReferee3) {  
	        this.mebReferee3 = mebReferee3;  
	    }  
	      
	    public Integer getMebReferee3() {  
	        return this.mebReferee3;  
	    }  
	    public String getLastStateTimeString() {  
	        return DateUtil.formatDatetime(getLastStateTime());  
	    }  
	    public void setLastStateTime(Date lastStateTime) {  
	        this.lastStateTime = lastStateTime;  
	    }  
	      
	    public Date getLastStateTime() {  
	        return this.lastStateTime;  
	    }  
 
}