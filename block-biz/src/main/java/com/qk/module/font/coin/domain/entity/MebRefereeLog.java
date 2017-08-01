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
@TableName(name="meb_referee_log")
public class MebRefereeLog  extends Po{  
      
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
    	@FieldName(name="link_degree")
	    private Integer linkDegree;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Pre_referee")
	    private Integer preReferee;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="new_referee")
	    private Integer newReferee;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Change_type")
	    private String changeType;  
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
	    public void setMebId(Integer mebId) {  
	        this.mebId = mebId;  
	    }  
	      
	    public Integer getMebId() {  
	        return this.mebId;  
	    }  
	    public void setLinkDegree(Integer linkDegree) {  
	        this.linkDegree = linkDegree;  
	    }  
	      
	    public Integer getLinkDegree() {  
	        return this.linkDegree;  
	    }  
	    public void setPreReferee(Integer preReferee) {  
	        this.preReferee = preReferee;  
	    }  
	      
	    public Integer getPreReferee() {  
	        return this.preReferee;  
	    }  
	    public void setNewReferee(Integer newReferee) {  
	        this.newReferee = newReferee;  
	    }  
	      
	    public Integer getNewReferee() {  
	        return this.newReferee;  
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
	    public void setChangeType(String changeType) {  
	        this.changeType = changeType;  
	    }  
	      
	    public String getChangeType() {  
	        return this.changeType;  
	    }  
	    public void setOper(String oper) {  
	        this.oper = oper;  
	    }  
	      
	    public String getOper() {  
	        return this.oper;  
	    }  
 
}