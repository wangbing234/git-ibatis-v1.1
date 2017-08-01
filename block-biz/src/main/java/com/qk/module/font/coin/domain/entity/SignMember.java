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
@TableName(name="sign_member")
public class SignMember  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="sign_time")
	    private Date signTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="sign_date_string")
	    private String signDateString;  
 
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
	    public String getSignTimeString() {  
	        return DateUtil.formatDatetime(getSignTime());  
	    }  
	    public void setSignTime(Date signTime) {  
	        this.signTime = signTime;  
	    }  
	      
	    public Date getSignTime() {  
	        return this.signTime;  
	    }  
	    public void setSignDateString(String signDateString) {  
	        this.signDateString = signDateString;  
	    }  
	      
	    public String getSignDateString() {  
	        return this.signDateString;  
	    }  
 
}