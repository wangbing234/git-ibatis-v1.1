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
@TableName(name="meb_state_log")
public class MebStateLog  extends Po{  
      
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
    	@FieldName(name="new_state")
	    private String newState;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
	    private String oper;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="change_reason")
	    private String changeReason;  
 
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
	    public void setNewState(String newState) {  
	        this.newState = newState;  
	    }  
	      
	    public String getNewState() {  
	        return this.newState;  
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
	    public void setChangeReason(String changeReason) {  
	        this.changeReason = changeReason;  
	    }  
	      
	    public String getChangeReason() {  
	        return this.changeReason;  
	    }  
 
}