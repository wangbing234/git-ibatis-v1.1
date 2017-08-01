/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qk.core.ibatis.dao.BaseDao;
import com.qk.core.ibatis.service.impl.BaseServiceImpl;
import com.qk.core.ibatis.sql.criteria.And;
import com.qk.core.ibatis.sql.criteria.Restrictions;
import com.qk.core.module.privilege.dao.PrivilegeDao;
import com.qk.core.module.privilege.entity.Privilege;
import com.qk.core.module.role.dao.RoleDao;
import com.qk.core.module.role.entity.Role;
import com.qk.core.module.role.service.RoleService;


/**
 *   Service实现类
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Service
@Component("roleServiceSystem")
public class RoleServiceImpl extends BaseServiceImpl<Role,RoleDao> implements RoleService {

	@Resource(name="privilegeDaoSystem")
	private PrivilegeDao privilegeDao;
	
	@Override
	public int add(Role role) {
		String[] pArr = role.getPrivileges().split(",");
		for (int i = 0; i < pArr.length; i++) {
			Privilege privilege=new Privilege();
			privilege.setMid(Integer.parseInt(pArr[i]));
			privilege.setRid(role.getId());
			privilegeDao.add(privilege);
		}
		return baseDao.add(role);
	}

	@Override
	public int update(Role role) {
		privilegeDao.deletePrivilege(role.getId());
		String[] pArr = role.getPrivileges().split(",");
		for (int i = 0; i < pArr.length; i++) {
			Privilege privilege=new Privilege();
			privilege.setMid(Integer.parseInt(pArr[i]));
			privilege.setRid(role.getId());
			privilegeDao.add(privilege);
		}
		return baseDao.update(role);
	}
	
	@Override
	public int del(Serializable id) {
		Role role = baseDao.get(id);
		if(role!=null)
			privilegeDao.deletePrivilege(role.getId());
		return baseDao.del(id);
	}
	
	@Override
	public Role getRoleWithPrivilege(Integer id) {
		Role role = baseDao.get(id);
		And and =new And("roleName", id,Restrictions.EQ);
		List<Privilege> pList = privilegeDao.list(and,null);
		String pIds="";
		for (Privilege privilege : pList) {
			pIds+=","+privilege.getMid();
		}
		if(StringUtils.isNotEmpty(pIds))
			role.setPrivileges(pIds.substring(1));
		return role;
	}
	
	public void testJob(){
		System.out.println("=======testJob==="); 
	}
	
	

}
