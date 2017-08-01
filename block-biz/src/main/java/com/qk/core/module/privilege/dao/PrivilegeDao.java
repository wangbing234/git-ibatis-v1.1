/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */


package com.qk.core.module.privilege.dao;
import com.qk.core.ibatis.dao.BaseDao;
import com.qk.core.module.privilege.entity.Privilege;



/**
 *   dao层接口类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
public interface PrivilegeDao extends BaseDao<Privilege>{

   public void deletePrivilege(Integer rid);

}
