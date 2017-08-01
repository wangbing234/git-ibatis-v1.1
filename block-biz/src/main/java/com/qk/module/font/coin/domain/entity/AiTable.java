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
@TableName(name="ai_table")
public class AiTable  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="table_name")
	    private String tableName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="table_rows")
	    private Integer tableRows;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="update_time")
	    private Date updateTime;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="table_name_chs")
	    private String tableNameChs;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="table_desc")
	    private String tableDesc;  
	    /**  
	     *   
	     */ 
	    private Integer rid;  
 
	    public void setTableName(String tableName) {  
	        this.tableName = tableName;  
	    }  
	      
	    public String getTableName() {  
	        return this.tableName;  
	    }  
	    public void setTableRows(Integer tableRows) {  
	        this.tableRows = tableRows;  
	    }  
	      
	    public Integer getTableRows() {  
	        return this.tableRows;  
	    }  
	    public String getUpdateTimeString() {  
	        return DateUtil.formatDatetime(getUpdateTime());  
	    }  
	    public void setUpdateTime(Date updateTime) {  
	        this.updateTime = updateTime;  
	    }  
	      
	    public Date getUpdateTime() {  
	        return this.updateTime;  
	    }  
	    public void setTableNameChs(String tableNameChs) {  
	        this.tableNameChs = tableNameChs;  
	    }  
	      
	    public String getTableNameChs() {  
	        return this.tableNameChs;  
	    }  
	    public void setTableDesc(String tableDesc) {  
	        this.tableDesc = tableDesc;  
	    }  
	      
	    public String getTableDesc() {  
	        return this.tableDesc;  
	    }  
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
 
}