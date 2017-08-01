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
@TableName(name="sys_position")
public class SysPosition  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="post_id")
	    private String postId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="post_name")
	    private String postName;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setPostId(String postId) {  
	        this.postId = postId;  
	    }  
	      
	    public String getPostId() {  
	        return this.postId;  
	    }  
	    public void setPostName(String postName) {  
	        this.postName = postName;  
	    }  
	      
	    public String getPostName() {  
	        return this.postName;  
	    }  
 
}