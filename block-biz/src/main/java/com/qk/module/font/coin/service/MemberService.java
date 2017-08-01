package com.qk.module.font.coin.service;

import javax.servlet.http.HttpServletRequest;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.domain.req.ChangePwdReq;
import com.qk.module.font.coin.domain.req.ForgetPwdReq;
import com.qk.module.font.coin.domain.req.SignupReq;

public interface MemberService {

	/**
	 * 会员注册
	 * 
	 * @param member
	 * @param pwd
	 * @return
	 */
	ResultBean reg(HttpServletRequest httpReq,SignupReq req);

	/**
	 * 会员激活
	 * 
	 * @param mebId
	 * @return
	 */
	boolean active(int mebId);

	/**
	 * 会员认证
	 * 
	 * @param mebId
	 * @return
	 */
	ResultBean auth(String operId,String mebId);

	/**
	 * 会员冻结
	 * 
	 * @param mebId
	 * @return
	 */
	ResultBean freeze(String mebId);

	/**
	 * 会员解冻
	 * 
	 * @param mebId
	 * @return
	 */
	ResultBean unfreeze(String mebId);

	/**
	 * 会员销号
	 * 
	 * @param mebId
	 * @return
	 */
	ResultBean unreg(String operId,String mebId);

	/**
	 * 修改密码
	 * 
	 * @param mebId
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	ResultBean pwd(ChangePwdReq req);

	/**
	 * 忘记密码
	 * 
	 * @param member
	 * @param pwd
	 * @return
	 */
	ResultBean forget(ForgetPwdReq req);
}
