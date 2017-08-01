package com.qk.module.font.coin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qk.core.framework.dto.ResultBean;
import com.qk.core.framework.dto.ResultEnum;
import com.qk.module.font.coin.domain.req.ChangePwdReq;
import com.qk.module.font.coin.domain.req.ForgetPwdReq;
import com.qk.module.font.coin.domain.req.SignupReq;
import com.qk.module.font.coin.service.impl.MemberServiceImpl;
@Controller
@RequestMapping("/meb")
public class MebController
{
	@Autowired
	private MemberServiceImpl memberService;
	/**
	 * 注册
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reg", 
			method = RequestMethod.POST,consumes="application/json")
	@ResponseBody
	private ResultBean signup(HttpServletRequest httpReq ,@RequestBody SignupReq req)
	{
		ResultBean resultBean = null;
		try
		{
			return memberService.reg(httpReq,req);
		}
		catch(Exception e)
		{
			resultBean = new ResultBean(ResultEnum.SERVER_ERROR);
		}
		return resultBean;
	}
	
	/**
	 * 激活
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/active/{mebId}", 
			method = RequestMethod.GET )
	@ResponseBody
	private boolean active(@PathVariable("mebId") int mebId)
	{
		return memberService.active(mebId);
	}
	
	/**
	 * 认证
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/active/{mebId}/{operId}", 
			method = RequestMethod.GET )
	@ResponseBody
	private ResultBean auth(@PathVariable("mebId") String mebId,@PathVariable("operId") String operId)
	{
		return memberService.auth(operId,mebId);
	}

	/**
	 * 注销用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unregmember/{mebId}/{operId}", 
			method = RequestMethod.GET )
	@ResponseBody
	private ResultBean unregMember(@PathVariable("mebId") String mebId,@PathVariable("operId") String operId)
	{
		return memberService.unreg(operId,mebId);
	}
	
	/**
	 * 忘记密码
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/forgetpwd", 
			method = RequestMethod.POST ,consumes="application/json")
	@ResponseBody
	private ResultBean forgetPwd(@RequestBody ForgetPwdReq req)
	{
		return memberService.forget(req);
	}
	
	/**
	 * 冻结
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/freeze/{mebId}", 
			method = RequestMethod.GET )
	@ResponseBody
	private ResultBean freeze(@PathVariable("mebId") String mebId)
	{
		return memberService.freeze(mebId);
	}
	
	/**
	 * 解冻
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/unfreeze/{mebId}", 
			method = RequestMethod.GET )
	@ResponseBody
	private ResultBean unfreeze(@PathVariable("mebId") String mebId)
	{
		return memberService.unfreeze(mebId);
	}
	
	/**
	 * 修改密码
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changepwd", 
			method = RequestMethod.POST,consumes="application/json")
	@ResponseBody
	private ResultBean changePwd(@RequestBody ChangePwdReq req)
	{
		return memberService.pwd(req);
	}
}
