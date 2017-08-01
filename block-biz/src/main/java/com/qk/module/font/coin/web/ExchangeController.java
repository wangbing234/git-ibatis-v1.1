package com.qk.module.font.coin.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qk.core.framework.BaseController;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.framework.dto.ResultEnum;
import com.qk.module.font.coin.domain.req.ChangeLoginPwdReq;
import com.qk.module.font.coin.domain.req.HistoryQueryReq;
import com.qk.module.font.coin.domain.req.LoginReq;
import com.qk.module.font.coin.domain.req.SignupReq;
import com.qk.module.font.coin.domain.req.UpdateUserReq;
import com.qk.module.font.coin.service.ExchangeService;
/**币交所/模块**/
@Controller
@RequestMapping("/exchange")

public class ExchangeController extends BaseController
{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private ExchangeService coinService;

	/**
	 * 注册
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signup", 
			method = RequestMethod.POST,
			consumes= "application/json")
	@ResponseBody
	private ResultBean signup(@RequestBody SignupReq req)
	{
		return coinService.signUp(req);
	}
	
	/**
	 * 登录
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", 
			method = RequestMethod.POST,
			consumes= "application/json")
	@ResponseBody
	private ResultBean login(@RequestBody LoginReq req)
	{
		return coinService.login(req);
	}
	
	/**
	 * 敏感校验
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/isauth", 
			method = RequestMethod.GET)
	@ResponseBody
	private ResultBean authCheck()
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String result = coinService.authCheck();
		resultBean.setMsg(result);
		return resultBean;
	}

	/**
	 * 查询余额
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/getBalances", 
			method = RequestMethod.GET)
	@ResponseBody
	private ResultBean getBalances()
	{
		return coinService.getBalances();
		
	}
	
	/**
	 * 获取市场行情
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/markettickers", 
			method = RequestMethod.GET)
	@ResponseBody
	private ResultBean marketTickers()
	{
		return coinService.marketTickers();
	}
	
	
	/**
	 * 获取用户信息
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/getuserinfo", 
			method = RequestMethod.GET)
	@ResponseBody
	private ResultBean getUserInfo()
	{
		return coinService.getUserInfo();
	}
	
	/**
	 * 更新用户信息
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/updateUser", 
			method = RequestMethod.POST)
	@ResponseBody
	private ResultBean updateUser(@RequestBody UpdateUserReq req)
	{
		return coinService.updateUser(req);
	}
	
	
	/**
	 * 获取当前币市场信息
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/marketInfo", 
			method = RequestMethod.GET)
	@ResponseBody
	private ResultBean getMarketInfo()
	{
		return coinService.getMarketInfo();
		
	}
	
	/**
	 * 查询转账记录
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/marketInfo", 
			method = RequestMethod.POST)
	@ResponseBody
	private ResultBean getHistory(@RequestBody HistoryQueryReq req)
	{
		return coinService.getHistory(req);
		
	}
	
	/**
	 * 修改交易密码
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/changetradepwd", 
			method = RequestMethod.GET)
	@ResponseBody
	private ResultBean changeTradePwd(String tradePwd)
	{
		return coinService.changeTradePwd(tradePwd);
		
	}
	
	/**
	 * 修改登录密码
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/changepwd", 
			method = RequestMethod.POST)
	@ResponseBody
	private ResultBean changePwd(@RequestBody ChangeLoginPwdReq req)
	{
		return coinService.changePwd(req);
		
	}
	
	/**
	 * 充值
	 * @author smart迅
	 *
	 * @return
	 */
	@RequestMapping(value = "/createDeposit/{amount}", 
			method = RequestMethod.GET)
	@ResponseBody
	private ResultBean createDeposit(String amount)
	{
		return coinService.createDeposit(amount);
		
	}
}
