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
@TableName(name="meb_statistics")
public class MebStatistics  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_count")
	    private Integer bonusCount;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="base_total")
	    private Integer baseTotal;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="bonus_total")
	    private Integer bonusTotal;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="last_bonus")
	    private Integer lastBonus;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="grow_total")
	    private Integer growTotal;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="exit_base_total")
	    private Integer exitBaseTotal;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Exit_bonus_total")
	    private Integer exitBonusTotal;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="exit_grow_total")
	    private Integer exitGrowTotal;  
    	/**  
	     *   
	     */ 
    	@FieldName(name="sign_count")
	    private Integer signCount;
		
    	public Integer getMebId() {
			return mebId;
		}
		public void setMebId(Integer mebId) {
			this.mebId = mebId;
		}
		public Integer getBonusCount() {
			return bonusCount;
		}
		public void setBonusCount(Integer bonusCount) {
			this.bonusCount = bonusCount;
		}
		public Integer getBaseTotal() {
			return baseTotal;
		}
		public void setBaseTotal(Integer baseTotal) {
			this.baseTotal = baseTotal;
		}
		public Integer getBonusTotal() {
			return bonusTotal;
		}
		public void setBonusTotal(Integer bonusTotal) {
			this.bonusTotal = bonusTotal;
		}
		public Integer getLastBonus() {
			return lastBonus;
		}
		public void setLastBonus(Integer lastBonus) {
			this.lastBonus = lastBonus;
		}
		public Integer getGrowTotal() {
			return growTotal;
		}
		public void setGrowTotal(Integer growTotal) {
			this.growTotal = growTotal;
		}
		public Integer getExitBaseTotal() {
			return exitBaseTotal;
		}
		public void setExitBaseTotal(Integer exitBaseTotal) {
			this.exitBaseTotal = exitBaseTotal;
		}
		public Integer getExitBonusTotal() {
			return exitBonusTotal;
		}
		public void setExitBonusTotal(Integer exitBonusTotal) {
			this.exitBonusTotal = exitBonusTotal;
		}
		public Integer getExitGrowTotal() {
			return exitGrowTotal;
		}
		public void setExitGrowTotal(Integer exitGrowTotal) {
			this.exitGrowTotal = exitGrowTotal;
		}
		public Integer getSignCount() {
			return signCount;
		}
		public void setSignCount(Integer signCount) {
			this.signCount = signCount;
		}
 
}