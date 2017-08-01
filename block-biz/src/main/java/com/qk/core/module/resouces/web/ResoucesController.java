/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.resouces.web;

import java.util.List;
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
import com.qk.core.beanutils.annotation.OAuthRequired;
import com.qk.core.domain.SystemCache;
import com.qk.core.framework.BaseController;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.ibatis.beans.PagerModel;
import com.qk.core.ibatis.sql.criteria.And;
import com.qk.core.ibatis.sql.criteria.Restrictions;
import com.qk.core.ibatis.sql.order.Order;
import com.qk.core.module.resouces.entity.Resouces;
import com.qk.core.module.resouces.service.ResoucesService;
import com.qk.core.module.user.entity.User;
import com.qk.core.redis.RedisSevice;


/**
 *   Controller
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Controller
@ResponseBody
@RequestMapping("/system/resouces")//域/模块
public class ResoucesController  extends BaseController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource(name="resoucesServiceSystem")
	ResoucesService resoucesService;
	
	@Resource(name="redisSevice")
	private RedisSevice redisSevice;
	
	/**
	 * 插入(Resouces)对象
	 * @param resouces Resouces对象
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	private ResultBean insert(@RequestBody Resouces resouces) {
		int i = resoucesService.add(resouces);
		logger.info("插入(Resouces)对象成功！");
		return success(i);
	}
	
	/**
	 * 查询(Resouces)列表
	 *@param resouces Resouces对象
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private ResultBean update(@RequestBody Resouces resouces) {
		int flag = resoucesService.update(resouces);
		logger.info("插入(Resouces)对象成功！");
		return success(flag);
	}
	
	
	
	/**
	 * 分页查询(Resouces)分页对象
	 * @param offset 第几页
	 * @param pageSize 分页大小
	 * @param resouces Resouces对象
	 * @return
	 */
	@RequestMapping(value = "/page/{offset}/{pageSize}", method = RequestMethod.GET)
	private ResultBean page(@PathVariable("offset") Integer offset,@PathVariable("pageSize") Integer pageSize ,@Param("resouces") Resouces resouces) {
		
			And and =new And("type", resouces.getType(),Restrictions.EQ);
		 	and.add("remarks", resouces.getRemarks(),Restrictions.EQ);
		 	Order order=new Order();
			order.add("orderNum");
			order.add("type");
		PagerModel<Resouces> pageModel = resoucesService.page(and,order,offset,pageSize);
		logger.info("分页查询(Resouces)分页对象成功！");
		return success(pageModel);
	}

	/**
	 * 根据id获取(Resouces)对象
	 * @param resoucesId 主键id
	 * @return
	 */
	@RequestMapping(value = "/getById/{resoucesId}", method = RequestMethod.GET)
	private ResultBean getById(@PathVariable("resoucesId") Long resoucesId) {
		Resouces resouces = resoucesService.get(resoucesId);
		logger.info("根据id获取(Resouces)对象成功！");
		return success(resouces);
	}
	
	/**
	 * 根据id删除(Resouces)对象
	 * @param resoucesId 主键id
	 * @return
	 */
	@RequestMapping(value = "/delete/{resoucesId}", method = RequestMethod.GET)
	private ResultBean deleteById(@PathVariable("resoucesId") Long resoucesId) {
		int flag = resoucesService.del(resoucesId);
		logger.info("根据id删除(Resouces)对象成功！");
		return  success(flag);
	}
	
	/**
	 * 根据id删除对象
	 * @param ids id的数组
	 * @return 修改记录的条数
	 */
	@RequestMapping(value = "/deletes", method = RequestMethod.GET)
	public ResultBean deleteByIds(@RequestParam(value = "ids") String[] ids){
		int flag = resoucesService.deleteByIds(ids);
		logger.info("批量删除(Resouces)对象成功！");
		return  success(flag);
	}
	
	/**
	 * 根据id获取子资源列表
	 * @param resoucesId 资源id
	 * @return
	 */
	@RequestMapping(value = "/getResourceByPid/{resoucesId}", method = RequestMethod.GET)
	private ResultBean getResourceByPid(@PathVariable("resoucesId") Long resoucesId) {
		And and =new And("pid", resoucesId,Restrictions.EQ);
		 List<Resouces> list = resoucesService.list(and, null);
		logger.info("获取字段对id对象成功！");
		return  success(list);
	}
	
	/**
	 * 根据token获取菜单
	 * @param req  请求对象
	 * @return
	 */
	@RequestMapping(value = "/getAuthMenus", method = RequestMethod.GET)
	@OAuthRequired
	private ResultBean getAuthMenus() {
		User user = SystemCache.getLoaclUser();
		List<Resouces> list = resoucesService.getMenus(user.getId()+"");
		logger.info("根据token获取菜单！");
		return  success(list);
	}
	
	
}
