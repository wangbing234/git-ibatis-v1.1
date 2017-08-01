package com.qk.module.font.coin.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qk.core.beanutils.AiProperties;
import com.qk.core.framework.dto.ResultBean;
import com.qk.core.framework.dto.ResultEnum;
import com.qk.module.font.coin.domain.req.ChangeLoginPwdReq;
import com.qk.module.font.coin.domain.req.HistoryQueryReq;
import com.qk.module.font.coin.domain.req.LoginReq;
import com.qk.module.font.coin.domain.req.SignupReq;
import com.qk.module.font.coin.domain.req.UpdateUserReq;
import com.qk.module.font.coin.service.ExchangeService;
import com.qk.module.font.coin.utils.HttpTookit;

@Service
public class ExchangeServiceImpl implements ExchangeService
{

	@Override
	public ResultBean signUp(SignupReq signup) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String url = AiProperties.getProperty("signupUrl");
		Map<String,String> params = new HashMap<String,String>();
		params.put("password", signup.getPassword());
		
		String resultStr = HttpTookit.doPost(url, params, "UTF-8");
		//TODO
		if(null != resultStr)
		{
			resultBean.setMsg(resultStr);
		}
		else
		{
			resultBean.setCode(ResultEnum.SERVER_ERROR.getCode());
			resultBean.setMsg("调取币交所接口异常");
		}
		
		return resultBean;
	}

	/**
	 * 登录
	 * @author smart迅
	 *
	 * @param req
	 * @return
	 */
	@Override
	public ResultBean login(LoginReq req)
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String url = AiProperties.getProperty("signupUrl");
		Map<String,String> params = new HashMap<String,String>();
		params.put("account", req.getAccount());
		params.put("password", req.getPassword());
		params.put("gauth", req.getGauth());
		
		String resultStr = HttpTookit.doPost(url, params, "UTF-8");
		
		if(null != resultStr)
		{
			resultBean.setMsg(resultStr);
		}
		else
		{
			resultBean.setCode(ResultEnum.SERVER_ERROR.getCode());
			resultBean.setMsg("调取币交所接口异常");
		}
		
		return resultBean;
	}

	/**
	 * 敏感操作鉴权
	 * @author smart迅
	 *
	 * @return
	 */
	@Override
	public String authCheck()
	{
		String authCheckUrl = AiProperties.getProperty("authCheckUrl");
		
		String result = null;
		try 
		{
			result = HttpTookit.sendGet(authCheckUrl, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询余额
	 * @author smart迅
	 *
	 * @return
	 */
	@Override
	public ResultBean getBalances() 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String getBalancesUrl = "";
		
		String result = null;
		try 
		{
			result = HttpTookit.sendGet(getBalancesUrl, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		resultBean.setMsg(result);
		return resultBean;
		
	}

	/**
	 * 查询市场行情
	 * @author smart迅
	 *
	 * @return
	 */
	@Override
	public ResultBean marketTickers() 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String getMarketTickersUrl = "";
		
		String result = null;
		try 
		{
			result = HttpTookit.sendGet(getMarketTickersUrl, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		resultBean.setMsg(result);
		return resultBean;
		
	}

	/**
	 * 查询用户信息
	 * @author smart迅
	 *
	 * @return
	 */
	@Override
	public ResultBean getUserInfo() 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String getUserInfoUrl = "";
		
		String result = null;
		try 
		{
			result = HttpTookit.sendGet(getUserInfoUrl, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		resultBean.setMsg(result);
		return resultBean;
	
	}

	/**
	 * 修改用户信息
	 * @author smart迅
	 *
	 * @param req
	 * @return
	 */
	@Override
	public ResultBean updateUser(UpdateUserReq req)
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String updateUserUrl = "http://api.coinvc.com/api/v2/auth/signup";
//				AiProperties.getProperty("signupUrl");
		Map<String,String> params = new HashMap<String,String>();
		if(!StringUtils.isEmpty(req.getUsername()))
		{
			params.put("username", req.getUsername());
		}
		if(StringUtils.isEmpty(req.getTruename()))
		{
			params.put("truename", req.getTruename());
		}
		if(StringUtils.isEmpty(req.getIdcard()))
		{
			params.put("idcard", req.getIdcard());
		}
		
		String resultStr = HttpTookit.doPost(updateUserUrl, params, "UTF-8");
		
		if(null != resultStr)
		{
			resultBean.setMsg(resultStr);
		}
		else
		{
			resultBean.setCode(ResultEnum.SERVER_ERROR.getCode());
			resultBean.setMsg("调取币交所接口异常");
		}
		return resultBean;
	}

	/**
	 * 获取当前币市场信息
	 * @author smart迅
	 *
	 * @return
	 */
	@Override
	public ResultBean getMarketInfo() 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String getMarketInfoUrl = "";
		String result = null;
		try 
		{
			result = HttpTookit.sendGet(getMarketInfoUrl, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		resultBean.setMsg(result);
		return resultBean;
	
	
	}

	/**
	 * 查询转账记录
	 * @author smart迅
	 *
	 * @return
	 */
	@Override
	public ResultBean getHistory(HistoryQueryReq req) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String getMarketInfoUrl = "http://api2.coinvc.com/api/v2/history/transfer/CNY?action="+req.getAction()+"&p="+req.getPage();
		String result = null;
		try 
		{
			result = HttpTookit.sendGet(getMarketInfoUrl, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		resultBean.setMsg(result);
		return resultBean;
	
		
	}

	/**
	 * 修改交易密码
	 * @author smart迅
	 *
	 * @param tradePwd
	 * @return
	 */
	@Override
	public ResultBean changeTradePwd(String tradePwd) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String changeTradeUrl = "http://api.coinvc.com/api/v2/auth/signup";
//				AiProperties.getProperty("signupUrl");
		Map<String,String> params = new HashMap<String,String>();
		params.put("newPassword ", tradePwd);
		
		String resultStr = HttpTookit.doPost(changeTradeUrl, params, "UTF-8");
		if(null != resultStr)
		{
			resultBean.setMsg(resultStr);
		}
		else
		{
			resultBean.setCode(ResultEnum.SERVER_ERROR.getCode());
			resultBean.setMsg("调取币交所接口异常");
		}
		return resultBean;
		
	}

	/**
	 * 修改登录密码
	 * @author smart迅
	 *
	 * @param req
	 * @return
	 */
	@Override
	public ResultBean changePwd(ChangeLoginPwdReq req) 
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String changePwdUrl = "http://api.coinvc.com/api/v2/auth/signup";
//				AiProperties.getProperty("signupUrl");
		Map<String,String> params = new HashMap<String,String>();
		params.put("oldPassword ", req.getOldPassword());
		params.put("newPassword ", req.getNewPassword());
		
		String resultStr = HttpTookit.doPost(changePwdUrl, params, "UTF-8");
		if(null != resultStr)
		{
			resultBean.setMsg(resultStr);
		}
		else
		{
			resultBean.setCode(ResultEnum.SERVER_ERROR.getCode());
			resultBean.setMsg("调取币交所接口异常");
		}
		return resultBean;
	}

	@Override
	public ResultBean createDeposit(String amount)
	{
		ResultBean resultBean = new ResultBean(ResultEnum.SUCCESS);
		String changePwdUrl = "http://api.coinvc.com/api/v2/auth/signup";
//				AiProperties.getProperty("signupUrl");
		Map<String,String> params = new HashMap<String,String>();
		params.put("amount ", amount);
		
		String resultStr = HttpTookit.doPost(changePwdUrl, params, "UTF-8");
		if(null != resultStr)
		{
			resultBean.setMsg(resultStr);
		}
		else
		{
			resultBean.setCode(ResultEnum.SERVER_ERROR.getCode());
			resultBean.setMsg("调取币交所接口异常");
		}
		return resultBean;
		
	}

}
