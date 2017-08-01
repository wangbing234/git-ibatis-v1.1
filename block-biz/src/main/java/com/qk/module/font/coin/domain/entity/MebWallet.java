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
@TableName(name="meb_wallet")
public class MebWallet  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="base_free")
	    private Integer baseFree;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="base_freeze")
	    private Integer baseFreeze;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_free")
	    private Integer bonusFree;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="grow_free")
	    private Integer growFree;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="shop_free")
	    private Integer shopFree;  
 
	    public void setMebId(Integer mebId) {  
	        this.mebId = mebId;  
	    }  
	      
	    public Integer getMebId() {  
	        return this.mebId;  
	    }  
	    public void setBaseFree(Integer baseFree) {  
	        this.baseFree = baseFree;  
	    }  
	      
	    public Integer getBaseFree() {  
	        return this.baseFree;  
	    }  
	    public void setBaseFreeze(Integer baseFreeze) {  
	        this.baseFreeze = baseFreeze;  
	    }  
	      
	    public Integer getBaseFreeze() {  
	        return this.baseFreeze;  
	    }  
	    public void setBonusFree(Integer bonusFree) {  
	        this.bonusFree = bonusFree;  
	    }  
	      
	    public Integer getBonusFree() {  
	        return this.bonusFree;  
	    }  
	    public void setGrowFree(Integer growFree) {  
	        this.growFree = growFree;  
	    }  
	      
	    public Integer getGrowFree() {  
	        return this.growFree;  
	    }  
	    public void setShopFree(Integer shopFree) {  
	        this.shopFree = shopFree;  
	    }  
	      
	    public Integer getShopFree() {  
	        return this.shopFree;  
	    }  
 
}