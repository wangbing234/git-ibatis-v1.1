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
@TableName(name="meb_account")
public class MebAccount  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Meb_name")
	    private String mebName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Bank_num")
	    private String bankNum;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Deposit_bank")
	    private String depositBank;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Detail_bank")
	    private String detailBank;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Bank_num2")
	    private String bankNum2;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Deposit_bank2")
	    private String depositBank2;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Detail_bank2")
	    private String detailBank2;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="Alipay_id")
	    private String alipayId;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="MicroMsg_id")
	    private String microMsgId;  
 
	    public void setMebId(Integer mebId) {  
	        this.mebId = mebId;  
	    }  
	      
	    public Integer getMebId() {  
	        return this.mebId;  
	    }  
	    public void setMebName(String mebName) {  
	        this.mebName = mebName;  
	    }  
	      
	    public String getMebName() {  
	        return this.mebName;  
	    }  
	    public void setBankNum(String bankNum) {  
	        this.bankNum = bankNum;  
	    }  
	      
	    public String getBankNum() {  
	        return this.bankNum;  
	    }  
	    public void setDepositBank(String depositBank) {  
	        this.depositBank = depositBank;  
	    }  
	      
	    public String getDepositBank() {  
	        return this.depositBank;  
	    }  
	    public void setDetailBank(String detailBank) {  
	        this.detailBank = detailBank;  
	    }  
	      
	    public String getDetailBank() {  
	        return this.detailBank;  
	    }  
	    public void setBankNum2(String bankNum2) {  
	        this.bankNum2 = bankNum2;  
	    }  
	      
	    public String getBankNum2() {  
	        return this.bankNum2;  
	    }  
	    public void setDepositBank2(String depositBank2) {  
	        this.depositBank2 = depositBank2;  
	    }  
	      
	    public String getDepositBank2() {  
	        return this.depositBank2;  
	    }  
	    public void setDetailBank2(String detailBank2) {  
	        this.detailBank2 = detailBank2;  
	    }  
	      
	    public String getDetailBank2() {  
	        return this.detailBank2;  
	    }  
	    public void setAlipayId(String alipayId) {  
	        this.alipayId = alipayId;  
	    }  
	      
	    public String getAlipayId() {  
	        return this.alipayId;  
	    }  
	    public void setMicroMsgId(String microMsgId) {  
	        this.microMsgId = microMsgId;  
	    }  
	      
	    public String getMicroMsgId() {  
	        return this.microMsgId;  
	    }  
 
}