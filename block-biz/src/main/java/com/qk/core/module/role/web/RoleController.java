/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.role.web;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qk.core.framework.BaseController;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.ibatis.beans.PagerModel;
import com.qk.core.ibatis.sql.criteria.And;
import com.qk.core.ibatis.sql.criteria.Restrictions;
import com.qk.core.module.role.entity.Role;
import com.qk.core.module.role.service.RoleService;


/**
 *   Controller
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Controller
@RequestMapping("/system/role")//域/模块
@ResponseBody
public class RoleController  extends BaseController{
	
	//日志打印类
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//注入RoleService
	@Resource(name="roleServiceSystem")
	RoleService roleService;
	
	/**
	 * 插入(Role)对象
	 * @param role Role对象
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	private ResultBean insert(@RequestBody Role role) {
		int i = roleService.add(role);
		logger.info("插入(Role)对象成功！");
		return success(i);
	}
	
	/**
	 * 查询(Role)列表
	 *@param role Role对象
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private ResultBean update(@RequestBody Role role) {
		int flag = roleService.update(role);
		logger.info("插入(Role)对象成功！");
		return success(flag);
	}
	
	/**
	 * 分页查询(Role)分页对象
	 * @param offset 第几页
	 * @param pageSize 分页大小
	 * @param role Role对象
	 * @return
	 */
	@RequestMapping(value = "/page/{offset}/{pageSize}", method = RequestMethod.GET)
	private ResultBean page(@PathVariable("offset") Integer offset,@PathVariable("pageSize") Integer pageSize ,@Param("role") Role role) {
		And and =new And("roleName", role.getRoleName(),Restrictions.EQ);
	 	and.add("status", role.getStatus(),Restrictions.EQ);
		PagerModel<Role> pageModel = roleService.page(and,null,offset,pageSize);
		logger.info("分页查询(Role)分页对象成功！");
		return success(pageModel);
	}

	/**
	 * 根据id获取(Role)对象
	 * @param roleId 主键id
	 * @return
	 */
	@RequestMapping(value = "/getById/{roleId}", method = RequestMethod.GET)
	private ResultBean getById(@PathVariable("roleId") Integer roleId) {
		Role role = roleService.getRoleWithPrivilege(roleId);
		logger.info("根据id获取(Role)对象成功！");
		return success(role);
	}
	
	/**
	 * 根据id删除(Role)对象
	 * @param roleId 主键id
	 * @return
	 */
	@RequestMapping(value = "/delete/{roleId}", method = RequestMethod.GET)
	private ResultBean deleteById(@PathVariable("roleId") Integer roleId) {
		int flag = roleService.del(roleId);
		logger.info("根据id删除(Role)对象成功！");
		return  success(flag);
	}
	
	/**
	 * 根据id删除对象
	 * @param ids id的数组
	 * @return 修改记录的条数
	 */
	@RequestMapping(value = "/deletes", method = RequestMethod.GET)
	public ResultBean deleteByIds(@RequestParam(value = "ids") String[] ids){
		int flag = roleService.deleteByIds(ids);
		logger.info("批量删除(Role)对象成功！");
		return  success(flag);
	}
	
}
