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
 * 账户信息  数据实体类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@TableName(name="t_account")
public class Taccount  extends Po{  
      
	    /**  
	     * 主键id  
	     */ 
	    private Integer id;  
	    /**  
	     * 账户  
	     */ 
	    private String account;  
	    /**  
	     * 昵称  
	     */ 
	    private String nickname;  
	    /**  
	     * 密码  
	     */ 
	    private String password;  
	    /**  
	     * 城市  
	     */ 
	    private String city;  
	    /**  
	     * 地址  
	     */ 
	    private String address;  
	    /**  
	     * 余额  
	     */ 
	    private String amount;  
	    /**  
	     * 电话  
	     */ 
	    private String tel;  
	    /**  
	     * 邮箱  
	     */ 
	    private String email;  
	    /**  
	     * 是否冻结1冻结0不冻结  
	     */ 
	    private String freeze;  
	    /**  
	     * 最后登录时间  
	     */ 
    	@FieldName(name="last_login_time")
	    private Date lastLoginTime;  
	    /**  
	     * 最后登录ip  
	     */ 
    	@FieldName(name="last_login_ip")
	    private String lastLoginIp;  
	    /**  
	     * 最后登录地区  
	     */ 
    	@FieldName(name="last_login_area")
	    private String lastLoginArea;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="diff_area_login")
	    private String diffAreaLogin;  
	    /**  
	     * 注册日期  
	     */ 
    	@FieldName(name="regeist_date")
	    private Date regeistDate;  
	    /**  
	     * 冻结时间  
	     */ 
    	@FieldName(name="freeze_startdate")
	    private Date freezeStartdate;  
	    /**  
	     * 解冻时间  
	     */ 
    	@FieldName(name="freeze_enddate")
	    private Date freezeEnddate;  
	    /**  
	     * 性别  
	     */ 
	    private String sex;  
	    /**  
	     * 真实姓名  
	     */ 
    	@FieldName(name="true_name")
	    private String trueName;  
	    /**  
	     * 生日  
	     */ 
	    private Date birthday;  
	    /**  
	     * 省  
	     */ 
	    private String province;  
	    /**  
	     * 账户类型  
	     */ 
    	@FieldName(name="account_type")
	    private String accountType;  
	    /**  
	     * 账户级别  
	     */ 
	    private String rank;  
	    /**  
	     * 评分  
	     */ 
	    private Integer score;  
 
	    public void setId(Integer id) {  
	        this.id = id;  
	    }  
	      
	    public Integer getId() {  
	        return this.id;  
	    }  
	    public void setAccount(String account) {  
	        this.account = account;  
	    }  
	      
	    public String getAccount() {  
	        return this.account;  
	    }  
	    public void setNickname(String nickname) {  
	        this.nickname = nickname;  
	    }  
	      
	    public String getNickname() {  
	        return this.nickname;  
	    }  
	    public void setPassword(String password) {  
	        this.password = password;  
	    }  
	      
	    public String getPassword() {  
	        return this.password;  
	    }  
	    public void setCity(String city) {  
	        this.city = city;  
	    }  
	      
	    public String getCity() {  
	        return this.city;  
	    }  
	    public void setAddress(String address) {  
	        this.address = address;  
	    }  
	      
	    public String getAddress() {  
	        return this.address;  
	    }  
	    public void setAmount(String amount) {  
	        this.amount = amount;  
	    }  
	      
	    public String getAmount() {  
	        return this.amount;  
	    }  
	    public void setTel(String tel) {  
	        this.tel = tel;  
	    }  
	      
	    public String getTel() {  
	        return this.tel;  
	    }  
	    public void setEmail(String email) {  
	        this.email = email;  
	    }  
	      
	    public String getEmail() {  
	        return this.email;  
	    }  
	    public void setFreeze(String freeze) {  
	        this.freeze = freeze;  
	    }  
	      
	    public String getFreeze() {  
	        return this.freeze;  
	    }  
	    public String getLastLoginTimeString() {  
	        return DateUtil.formatDatetime(getLastLoginTime());  
	    }  
	    public void setLastLoginTime(Date lastLoginTime) {  
	        this.lastLoginTime = lastLoginTime;  
	    }  
	      
	    public Date getLastLoginTime() {  
	        return this.lastLoginTime;  
	    }  
	    public void setLastLoginIp(String lastLoginIp) {  
	        this.lastLoginIp = lastLoginIp;  
	    }  
	      
	    public String getLastLoginIp() {  
	        return this.lastLoginIp;  
	    }  
	    public void setLastLoginArea(String lastLoginArea) {  
	        this.lastLoginArea = lastLoginArea;  
	    }  
	      
	    public String getLastLoginArea() {  
	        return this.lastLoginArea;  
	    }  
	    public void setDiffAreaLogin(String diffAreaLogin) {  
	        this.diffAreaLogin = diffAreaLogin;  
	    }  
	      
	    public String getDiffAreaLogin() {  
	        return this.diffAreaLogin;  
	    }  
	    public String getRegeistDateString() {  
	        return DateUtil.formatDatetime(getRegeistDate());  
	    }  
	    public void setRegeistDate(Date regeistDate) {  
	        this.regeistDate = regeistDate;  
	    }  
	      
	    public Date getRegeistDate() {  
	        return this.regeistDate;  
	    }  
	    public String getFreezeStartdateString() {  
	        return DateUtil.formatDatetime(getFreezeStartdate());  
	    }  
	    public void setFreezeStartdate(Date freezeStartdate) {  
	        this.freezeStartdate = freezeStartdate;  
	    }  
	      
	    public Date getFreezeStartdate() {  
	        return this.freezeStartdate;  
	    }  
	    public String getFreezeEnddateString() {  
	        return DateUtil.formatDatetime(getFreezeEnddate());  
	    }  
	    public void setFreezeEnddate(Date freezeEnddate) {  
	        this.freezeEnddate = freezeEnddate;  
	    }  
	      
	    public Date getFreezeEnddate() {  
	        return this.freezeEnddate;  
	    }  
	    public void setSex(String sex) {  
	        this.sex = sex;  
	    }  
	      
	    public String getSex() {  
	        return this.sex;  
	    }  
	    public void setTrueName(String trueName) {  
	        this.trueName = trueName;  
	    }  
	      
	    public String getTrueName() {  
	        return this.trueName;  
	    }  
	    public String getBirthdayString() {  
	        return DateUtil.formatDatetime(getBirthday());  
	    }  
	    public void setBirthday(Date birthday) {  
	        this.birthday = birthday;  
	    }  
	      
	    public Date getBirthday() {  
	        return this.birthday;  
	    }  
	    public void setProvince(String province) {  
	        this.province = province;  
	    }  
	      
	    public String getProvince() {  
	        return this.province;  
	    }  
	    public void setAccountType(String accountType) {  
	        this.accountType = accountType;  
	    }  
	      
	    public String getAccountType() {  
	        return this.accountType;  
	    }  
	    public void setRank(String rank) {  
	        this.rank = rank;  
	    }  
	      
	    public String getRank() {  
	        return this.rank;  
	    }  
	    public void setScore(Integer score) {  
	        this.score = score;  
	    }  
	      
	    public Integer getScore() {  
	        return this.score;  
	    }  
 
}