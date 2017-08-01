/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.role.dao.impl;


import org.springframework.stereotype.Component;
import com.qk.core.ibatis.dao.impl.BaseDaoImpl;
import com.qk.core.module.role.dao.RoleDao;

import com.qk.core.module.role.entity.Role;



/**
 *   dao实现类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Component("roleDaoSystem")
public class RoleDaoImpl extends  BaseDaoImpl<Role> implements RoleDao {

}
