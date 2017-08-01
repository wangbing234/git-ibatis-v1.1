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
@TableName(name="ai_column")
public class AiColumn  extends Po{  
      
	    /**  
	     *   
	     */ 
    	@FieldName(name="table_name")
	    private String tableName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="column_name")
	    private String columnName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="table_column_name")
	    private String tableColumnName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="column_name_chs")
	    private String columnNameChs;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="column_desc")
	    private String columnDesc;  
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
	    public void setColumnName(String columnName) {  
	        this.columnName = columnName;  
	    }  
	      
	    public String getColumnName() {  
	        return this.columnName;  
	    }  
	    public void setTableColumnName(String tableColumnName) {  
	        this.tableColumnName = tableColumnName;  
	    }  
	      
	    public String getTableColumnName() {  
	        return this.tableColumnName;  
	    }  
	    public void setColumnNameChs(String columnNameChs) {  
	        this.columnNameChs = columnNameChs;  
	    }  
	      
	    public String getColumnNameChs() {  
	        return this.columnNameChs;  
	    }  
	    public void setColumnDesc(String columnDesc) {  
	        this.columnDesc = columnDesc;  
	    }  
	      
	    public String getColumnDesc() {  
	        return this.columnDesc;  
	    }  
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
 
}