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
@TableName(name="t_user")
public class Tuser  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer id;  
	    /**  
	     *   
	     */ 
	    private String username;  
	    /**  
	     *   
	     */ 
	    private String password;  
	    /**  
	     *   
	     */ 
	    private Date createtime;  
	    /**  
	     *   
	     */ 
	    private Date updatetime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="create_account")
	    private String createAccount;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="update_account")
	    private String updateAccount;  
	    /**  
	     *   
	     */ 
	    private String status;  
	    /**  
	     *   
	     */ 
	    private String rid;  
	    /**  
	     *   
	     */ 
	    private String nickname;  
	    /**  
	     *   
	     */ 
	    private String email;  
 
	    public void setId(Integer id) {  
	        this.id = id;  
	    }  
	      
	    public Integer getId() {  
	        return this.id;  
	    }  
	    public void setUsername(String username) {  
	        this.username = username;  
	    }  
	      
	    public String getUsername() {  
	        return this.username;  
	    }  
	    public void setPassword(String password) {  
	        this.password = password;  
	    }  
	      
	    public String getPassword() {  
	        return this.password;  
	    }  
	    public String getCreatetimeString() {  
	        return DateUtil.formatDatetime(getCreatetime());  
	    }  
	    public void setCreatetime(Date createtime) {  
	        this.createtime = createtime;  
	    }  
	      
	    public Date getCreatetime() {  
	        return this.createtime;  
	    }  
	    public String getUpdatetimeString() {  
	        return DateUtil.formatDatetime(getUpdatetime());  
	    }  
	    public void setUpdatetime(Date updatetime) {  
	        this.updatetime = updatetime;  
	    }  
	      
	    public Date getUpdatetime() {  
	        return this.updatetime;  
	    }  
	    public void setCreateAccount(String createAccount) {  
	        this.createAccount = createAccount;  
	    }  
	      
	    public String getCreateAccount() {  
	        return this.createAccount;  
	    }  
	    public void setUpdateAccount(String updateAccount) {  
	        this.updateAccount = updateAccount;  
	    }  
	      
	    public String getUpdateAccount() {  
	        return this.updateAccount;  
	    }  
	    public void setStatus(String status) {  
	        this.status = status;  
	    }  
	      
	    public String getStatus() {  
	        return this.status;  
	    }  
	    public void setRid(String rid) {  
	        this.rid = rid;  
	    }  
	      
	    public String getRid() {  
	        return this.rid;  
	    }  
	    public void setNickname(String nickname) {  
	        this.nickname = nickname;  
	    }  
	      
	    public String getNickname() {  
	        return this.nickname;  
	    }  
	    public void setEmail(String email) {  
	        this.email = email;  
	    }  
	      
	    public String getEmail() {  
	        return this.email;  
	    }  
 
}