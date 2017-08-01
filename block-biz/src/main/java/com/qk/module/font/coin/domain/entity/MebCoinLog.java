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
@TableName(name="meb_coin_log")
public class MebCoinLog  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="Rid")
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="trans_count")
	    private Integer transCount;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Create_time")
	    private Date createTime;  
	    /**  
	     *   
	     */ 
	    private Integer sender;  
	    /**  
	     *   
	     */ 
	    private Integer receiver;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Trans_type")
	    private String transType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="coin_type")
	    private String coinType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="trans_oper")
	    private String transOper;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setTransCount(Integer transCount) {  
	        this.transCount = transCount;  
	    }  
	      
	    public Integer getTransCount() {  
	        return this.transCount;  
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
	    public void setSender(Integer sender) {  
	        this.sender = sender;  
	    }  
	      
	    public Integer getSender() {  
	        return this.sender;  
	    }  
	    public void setReceiver(Integer receiver) {  
	        this.receiver = receiver;  
	    }  
	      
	    public Integer getReceiver() {  
	        return this.receiver;  
	    }  
	    public void setTransType(String transType) {  
	        this.transType = transType;  
	    }  
	      
	    public String getTransType() {  
	        return this.transType;  
	    }  
	    public void setCoinType(String coinType) {  
	        this.coinType = coinType;  
	    }  
	      
	    public String getCoinType() {  
	        return this.coinType;  
	    }  
	    public void setTransOper(String transOper) {  
	        this.transOper = transOper;  
	    }  
	      
	    public String getTransOper() {  
	        return this.transOper;  
	    }  
 
}