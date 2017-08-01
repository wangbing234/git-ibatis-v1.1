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
@TableName(name="sign_type")
public class SignType  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     * 签到类型1：个人签到  
	     */ 
    	@FieldName(name="sign_type")
	    private Integer signType;  
	    /**  
	     * 签到次数  
	     */ 
    	@FieldName(name="sign_count")
	    private Integer signCount;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="sign_coins_num")
	    private Integer signCoinsNum;  
 
	    public void setMebId(Integer mebId) {  
	        this.mebId = mebId;  
	    }  
	      
	    public Integer getMebId() {  
	        return this.mebId;  
	    }  
	    public void setSignType(Integer signType) {  
	        this.signType = signType;  
	    }  
	      
	    public Integer getSignType() {  
	        return this.signType;  
	    }  
	    public void setSignCount(Integer signCount) {  
	        this.signCount = signCount;  
	    }  
	      
	    public Integer getSignCount() {  
	        return this.signCount;  
	    }  
	    public void setSignCoinsNum(Integer signCoinsNum) {  
	        this.signCoinsNum = signCoinsNum;  
	    }  
	      
	    public Integer getSignCoinsNum() {  
	        return this.signCoinsNum;  
	    }  
 
}