package com.qk.module.font.coin.service;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.domain.req.ChangeLoginPwdReq;
import com.qk.module.font.coin.domain.req.HistoryQueryReq;
import com.qk.module.font.coin.domain.req.LoginReq;
import com.qk.module.font.coin.domain.req.SignupReq;
import com.qk.module.font.coin.domain.req.UpdateUserReq;

public interface ExchangeService 
{
	public ResultBean signUp(SignupReq req);
	
	public ResultBean login(LoginReq req);
	
	public String authCheck();
	
	public ResultBean getBalances();
	
	public ResultBean marketTickers();
	
	public ResultBean getUserInfo();
	
	public ResultBean updateUser(UpdateUserReq req);
	
	public ResultBean getMarketInfo();

	public ResultBean getHistory(HistoryQueryReq req);

	public ResultBean changeTradePwd(String tradePwd);

	public ResultBean changePwd(ChangeLoginPwdReq req);

	public ResultBean createDeposit(String amount);
	
	
}
