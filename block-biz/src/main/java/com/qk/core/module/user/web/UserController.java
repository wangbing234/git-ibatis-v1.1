/*
 * Powered By [rapid-framework]
 *  copyright © 趋快科技(武汉)有限公司
 * Since 2017 - 2017
 */

package com.qk.core.module.user.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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

import com.qk.core.beanutils.CipherUtil;
import com.qk.core.domain.Busi;
import com.qk.core.framework.BaseController;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.ibatis.beans.PagerModel;
import com.qk.core.ibatis.sql.criteria.And;
import com.qk.core.ibatis.sql.criteria.Restrictions;
import com.qk.core.ibatis.sql.order.Order;
import com.qk.core.jwt.Jwt;
import com.qk.core.module.user.entity.User;
import com.qk.core.module.user.service.UserService;
import com.qk.core.redis.RedisSevice;


/**
 *   Controller
 * @author rapid-code
 * @version 1.0
 * @since 1.0
 * */
@Controller
@ResponseBody
@RequestMapping("/system/user")//域/模块
public class UserController  extends BaseController{
	
	//日志打印类
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//注入UserService
	@Resource(name="userServiceSystem")
	UserService userService;
	
	@Resource(name="redisSevice")
	private RedisSevice redisSevice;
	
	/**
	 * 插入(User)对象
	 * @param user User对象
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	private ResultBean insert(@RequestBody User user) {
		int i = userService.add(user);
		logger.info("插入(User)对象成功！");
		return success(i);
	}
	
	/**
	 * 查询(User)列表
	 *@param user User对象
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private ResultBean update(@RequestBody User user) {
		int flag = userService.update(user);
		logger.info("插入(User)对象成功！");
		return success(flag);
	}
	
	/**
	 * 分页查询(User)分页对象
	 * @param offset 第几页
	 * @param pageSize 分页大小
	 * @param user User对象
	 * @return
	 */
	@RequestMapping(value = "/page/{offset}/{pageSize}", method = RequestMethod.GET)
	private ResultBean page(@PathVariable("offset") Integer offset,@PathVariable("pageSize") Integer pageSize ,@Param("user") User user) {
		
		And and =new And("username", user.getUsername(),Restrictions.EQ);
	 	and.add("status", user.getStatus(),Restrictions.EQ);
	 	and.add("nickname", user.getNickname(),Restrictions.EQ);
	 	and.add("email", user.getEmail(),Restrictions.EQ);
	 	Order order=new Order();
	 	order.add("createtime",Order.DESC);
	 	order.add("status");
		PagerModel<User> pageModel = userService.page(and,order,offset,pageSize);
		logger.info("分页查询(User)分页对象成功！");
		return success(pageModel);
	}

	/**
	 * 根据id获取(User)对象
	 * @param userId 主键id
	 * @return
	 */
	@RequestMapping(value = "/getById/{userId}", method = RequestMethod.GET)
	private ResultBean getById(@PathVariable("userId") Long userId) {
		User user = userService.get(userId);
		logger.info("根据id获取(User)对象成功！");
		return success(user);
	}
	
	/**
	 * 根据id删除(User)对象
	 * @param userId 主键id
	 * @return
	 */
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	private ResultBean deleteById(@PathVariable("userId") Long userId) {
		int flag = userService.del(userId);
		logger.info("根据id删除(User)对象成功！");
		return  success(flag);
	}
	
	/**
	 * 根据id删除对象
	 * @param ids id的数组
	 * @return 修改记录的条数
	 */
	@RequestMapping(value = "/deletes", method = RequestMethod.GET)
	public ResultBean deleteByIds(@RequestParam(value = "ids") String[] ids){
		int flag = userService.deleteByIds(ids);
		logger.info("批量删除(User)对象成功！");
		return  success(flag);
	}
	
	
	/**
	 * 根据id删除账户信息(Account)对象
	 * @param accountId 主键id
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private ResultBean login(@Param("account") User account,HttpSession session) throws Exception {
		if (StringUtils.isBlank(account.getUsername()) || StringUtils.isBlank(account.getPassword())) {
			return fail("账户和密码不能为空");
		}
		account.setPassword(CipherUtil.encodePassword(account.getPassword(), account.getUsername()));
		And and =new And("username", account.getUsername(),Restrictions.EQ);
	 	and.add("password", account.getPassword(),Restrictions.EQ); 
		Integer errorNum = (Integer) session.getAttribute("errorNum");
		if (errorNum == null) {
			errorNum = 0;
		}
		else if (errorNum > 5) {
			return fail("您的账户5次登陆失败,不能再登录!");
		}
		User dbUser = userService.get(and);
		if (dbUser == null) {
			logger.debug("登陆失败，账号不存在！");
			errorNum = errorNum + 1;
			session.setAttribute("errorNum", errorNum);
			return fail("帐号或密码错误!");

		} else if (!Busi.YES_STRING.equals(dbUser.getStatus())) {
			logger.debug("帐号已被禁用，请联系管理员!");
			return fail("帐号已被禁用，请联系管理员!");
		}
		String token = Jwt.createToken(dbUser.getId()+"", dbUser);
		logger.debug("用户登录成功："+dbUser.getUsername());
		return success(token);
	}
	
	/**
	 * 退出登录
	 * @param accountId 主键id
	 * @return
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	private ResultBean loginOut(HttpServletRequest req) throws Exception {
		logger.debug("用户退出登录!");
		return success("退出成功！");
	}
	
}
