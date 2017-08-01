package com.qk.module.font.coin.service;

import com.qk.core.framework.dto.ResultBean;

public interface SmsService {

	/**
	 * 发送验证码
	 * 
	 * @param phone
	 * @return
	 */
	ResultBean sendCode(String phone);

	/**
	 * 校验验证码
	 * 
	 * @param phone
	 * @param code
	 * @return
	 */
	ResultBean verifyCode(String phone, String code);

	/**
	 * 发送短信（保存短信到队列，定时批量发送）
	 * 
	 * @param sms
	 * @return
	 */
	ResultBean sendSms(Object sms);

	/**
	 * 读取短信队列并发送
	 * 
	 * @return
	 */
	ResultBean sendSms();

	/**
	 * 发送短信（即时）
	 * 
	 * @param sms
	 * @return
	 */
	ResultBean sendSmsImmediate(Object sms);

}
