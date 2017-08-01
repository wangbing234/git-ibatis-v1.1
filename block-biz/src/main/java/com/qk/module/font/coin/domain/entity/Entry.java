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
@TableName(name="biz_entry")
public class Entry  extends Po{  
      
	    /**  
	     * 主键id  
	     */ 
	    private Integer rid;  
	    /**  
	     * 会员编号  
	     */ 
    	@FieldName(name="meb_id")
	    private Integer mebId;  
	    /**  
	     * 存入金额  
	     */ 
	    private Integer amount;  
	    /**  
	     * 状态：1 初始；2 已确认；3 已取消；4 已解冻  
	     */ 
	    private Integer state;  
	    /**  
	     * 操作人  
	     */ 
	    private String oper;  
	    /**  
	     * 操作时间  
	     */ 
    	@FieldName(name="oper_time")
	    private Date operTime;  
	    /**  
	     * 创建时间  
	     */ 
    	@FieldName(name="create_time")
	    private Date createTime;  
	    /**  
	     * 预计解冻时间  
	     */ 
    	@FieldName(name="to_unfreeze_time")
	    private Date toUnfreezeTime;  
	    /**  
	     * 实际解冻时间  
	     */ 
    	@FieldName(name="unfreeze_time")
	    private Date unfreezeTime;  
	    /**  
	     * 图片路径  
	     */ 
	    private String pic;  
 
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
	    public void setAmount(Integer amount) {  
	        this.amount = amount;  
	    }  
	      
	    public Integer getAmount() {  
	        return this.amount;  
	    }  
	    public void setState(Integer state) {  
	        this.state = state;  
	    }  
	      
	    public Integer getState() {  
	        return this.state;  
	    }  
	    public void setOper(String oper) {  
	        this.oper = oper;  
	    }  
	      
	    public String getOper() {  
	        return this.oper;  
	    }  
	    public String getOperTimeString() {  
	        return DateUtil.formatDatetime(getOperTime());  
	    }  
	    public void setOperTime(Date operTime) {  
	        this.operTime = operTime;  
	    }  
	      
	    public Date getOperTime() {  
	        return this.operTime;  
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
	    public String getToUnfreezeTimeString() {  
	        return DateUtil.formatDatetime(getToUnfreezeTime());  
	    }  
	    public void setToUnfreezeTime(Date toUnfreezeTime) {  
	        this.toUnfreezeTime = toUnfreezeTime;  
	    }  
	      
	    public Date getToUnfreezeTime() {  
	        return this.toUnfreezeTime;  
	    }  
	    public String getUnfreezeTimeString() {  
	        return DateUtil.formatDatetime(getUnfreezeTime());  
	    }  
	    public void setUnfreezeTime(Date unfreezeTime) {  
	        this.unfreezeTime = unfreezeTime;  
	    }  
	      
	    public Date getUnfreezeTime() {  
	        return this.unfreezeTime;  
	    }  
	    public void setPic(String pic) {  
	        this.pic = pic;  
	    }  
	      
	    public String getPic() {  
	        return this.pic;  
	    }  
 
}