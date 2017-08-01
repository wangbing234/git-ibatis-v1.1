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
@TableName(name="core_rate_daily")
public class CoreRateDaily  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="date_str")
	    private String dateStr;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="base_rate")
	    private Float baseRate;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="point_rate")
	    private Float pointRate;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
	    private String oper;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setDateStr(String dateStr) {  
	        this.dateStr = dateStr;  
	    }  
	      
	    public String getDateStr() {  
	        return this.dateStr;  
	    }  
	    public void setBaseRate(Float baseRate) {  
	        this.baseRate = baseRate;  
	    }  
	      
	    public Float getBaseRate() {  
	        return this.baseRate;  
	    }  
	    public void setPointRate(Float pointRate) {  
	        this.pointRate = pointRate;  
	    }  
	      
	    public Float getPointRate() {  
	        return this.pointRate;  
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
	    public void setOper(String oper) {  
	        this.oper = oper;  
	    }  
	      
	    public String getOper() {  
	        return this.oper;  
	    }  
 
}