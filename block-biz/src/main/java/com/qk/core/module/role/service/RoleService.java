/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.role.service;

import com.qk.core.ibatis.service.BaseService;
import com.qk.core.module.role.dao.RoleDao;
import com.qk.core.module.role.entity.Role;


/**
 *   Service接口
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
public interface RoleService  extends BaseService<Role,RoleDao>{

	public Role getRoleWithPrivilege(Integer id);
}
