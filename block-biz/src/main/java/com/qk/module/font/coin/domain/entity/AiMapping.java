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
@TableName(name="ai_mapping")
public class AiMapping  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="request_path")
	    private String requestPath;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="request_method")
	    private String requestMethod;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="request_type")
	    private String requestType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="response_class")
	    private String responseClass;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="response_method")
	    private String responseMethod;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="response_args")
	    private String responseArgs;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="is_auth")
	    private String isAuth;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="is_frequent")
	    private String isFrequent;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setRequestPath(String requestPath) {  
	        this.requestPath = requestPath;  
	    }  
	      
	    public String getRequestPath() {  
	        return this.requestPath;  
	    }  
	    public void setRequestMethod(String requestMethod) {  
	        this.requestMethod = requestMethod;  
	    }  
	      
	    public String getRequestMethod() {  
	        return this.requestMethod;  
	    }  
	    public void setRequestType(String requestType) {  
	        this.requestType = requestType;  
	    }  
	      
	    public String getRequestType() {  
	        return this.requestType;  
	    }  
	    public void setResponseClass(String responseClass) {  
	        this.responseClass = responseClass;  
	    }  
	      
	    public String getResponseClass() {  
	        return this.responseClass;  
	    }  
	    public void setResponseMethod(String responseMethod) {  
	        this.responseMethod = responseMethod;  
	    }  
	      
	    public String getResponseMethod() {  
	        return this.responseMethod;  
	    }  
	    public void setResponseArgs(String responseArgs) {  
	        this.responseArgs = responseArgs;  
	    }  
	      
	    public String getResponseArgs() {  
	        return this.responseArgs;  
	    }  
	    public void setIsAuth(String isAuth) {  
	        this.isAuth = isAuth;  
	    }  
	      
	    public String getIsAuth() {  
	        return this.isAuth;  
	    }  
	    public void setIsFrequent(String isFrequent) {  
	        this.isFrequent = isFrequent;  
	    }  
	      
	    public String getIsFrequent() {  
	        return this.isFrequent;  
	    }  
 
}