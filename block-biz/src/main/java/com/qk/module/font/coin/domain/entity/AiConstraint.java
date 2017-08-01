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
@TableName(name="ai_constraint")
public class AiConstraint  extends Po{  
      
	    /**  
	     *   
	     */ 
	    private Integer rid;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="cons_name")
	    private String consName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="table_name")
	    private String tableName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="col_name")
	    private String colName;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="cons_type")
	    private String consType;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="ref_table")
	    private String refTable;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="ref_column")
	    private String refColumn;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="delete_rule")
	    private String deleteRule;  
	    /**  
	     *   
	     */ 
    	@FieldName(name="is_defined_in_db")
	    private String isDefinedInDb;  
 
	    public void setRid(Integer rid) {  
	        this.rid = rid;  
	    }  
	      
	    public Integer getRid() {  
	        return this.rid;  
	    }  
	    public void setConsName(String consName) {  
	        this.consName = consName;  
	    }  
	      
	    public String getConsName() {  
	        return this.consName;  
	    }  
	    public void setTableName(String tableName) {  
	        this.tableName = tableName;  
	    }  
	      
	    public String getTableName() {  
	        return this.tableName;  
	    }  
	    public void setColName(String colName) {  
	        this.colName = colName;  
	    }  
	      
	    public String getColName() {  
	        return this.colName;  
	    }  
	    public void setConsType(String consType) {  
	        this.consType = consType;  
	    }  
	      
	    public String getConsType() {  
	        return this.consType;  
	    }  
	    public void setRefTable(String refTable) {  
	        this.refTable = refTable;  
	    }  
	      
	    public String getRefTable() {  
	        return this.refTable;  
	    }  
	    public void setRefColumn(String refColumn) {  
	        this.refColumn = refColumn;  
	    }  
	      
	    public String getRefColumn() {  
	        return this.refColumn;  
	    }  
	    public void setDeleteRule(String deleteRule) {  
	        this.deleteRule = deleteRule;  
	    }  
	      
	    public String getDeleteRule() {  
	        return this.deleteRule;  
	    }  
	    public void setIsDefinedInDb(String isDefinedInDb) {  
	        this.isDefinedInDb = isDefinedInDb;  
	    }  
	      
	    public String getIsDefinedInDb() {  
	        return this.isDefinedInDb;  
	    }  
 
}