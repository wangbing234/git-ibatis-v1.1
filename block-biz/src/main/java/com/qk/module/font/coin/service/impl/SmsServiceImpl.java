package com.qk.module.font.coin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.service.SmsService;
import com.qk.module.font.common.exception.BusiException;

@Service
public class SmsServiceImpl implements InitializingBean ,SmsService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

/*	@Autowired
	private DaoApi smsDao;

	@Autowired
	private DaoApi mebBasicDao;

	@Autowired
	private CoreParamCache coreParamCache;*/

	@Override
	public void afterPropertiesSet() throws Exception {/*
		super.setDaoApi(smsDao);
	*/}

	/**
	 * 发送短信验证码<br>
	 * 您本次注册的验证码为%s,10分钟内有效。
	 * 
	 * @param phone
	 * @throws BusiException
	 */
	public void sendcode(String phone) throws BusiException {/*
		String url = "https://api.netease.im/sms/sendcode.action";

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("mobile", phone); // 目标手机号
		args.put("deviceId", phone); // 目标设备号
		args.put("templateid", AiProperties.getProperty("memberRegSms")); // 模板编号
		args.put("codeLen", 6); // 验证码长度
		String retStr;
		try {
			retStr = CheckSumBuilder.sendSms(url, args);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("发送短信失败");
		}

		// 检查发送结果
		String retCode = ((Map<String, Object>) JSON.parse(retStr)).get("code").toString();

		// 记录发送记录
		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", 0);
		map.put("smsPhone", phone);
		map.put("smsNo", AiProperties.getProperty("memberRegSms"));
		map.put("smsArgs", "");
		map.put("smsType", Busi.SMS_TYPE_MEMBERREG);
		map.put("createTime", new Date());
		map.put("sendTime", new Date());
		map.put("retCode", retCode);
		DaoApi smsDao = (DaoApi) AiContext.getBean("smsDao");
		smsDao.insertRecord(map);

		if (retCode.equals("200")) { // 发送成功

		} else { // 发送失败
			throw new BusiException("发送短信失败：" + retCode);
		}
	*/}

	/**
	 * 校验验证码
	 * 
	 * @param phone
	 * @param code
	 * @return
	 */
	public boolean verifycode(String phone, String code) {
		return false;/*
		String url = "https://api.netease.im/sms/verifycode.action";

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("mobile", phone); // 目标手机号
		args.put("code", code); // 验证码
		String retStr;
		try {
			retStr = CheckSumBuilder.sendSms(url, args);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusiException("校验验证码失败");
		}

		// 检查发送结果
		String retCode = ((Map<String, Object>) JSON.parse(retStr)).get("code").toString();
		if (retCode.equals("200")) {
			return true;
		} else {
			throw new BusiException("校验验证码失败：" + retCode);
		}
	*/}

	/**
	 * 通知打款<br>
	 * 尊敬的%s,您提供的%s元捐赠已匹配成功，匹配单号为%s,请在%s小时内打款。
	 * 
	 * @param mebId
	 * @param args
	 * @throws BusiException
	 */
	public void noticeToPay(String mebId, List<String> args) throws BusiException {/*
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
		String mebName = mebBasic.get("mebName").toString();
		args.add(0, mebName);
		String mebPhone = mebBasic.get("mebPhone").toString();

		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", mebId);
		map.put("smsPhone", mebPhone);
		map.put("smsNo", AiProperties.getProperty("toPaySms"));
		map.put("smsType", Busi.SMS_TYPE_TOPAY);
		map.put("smsArgs", StringUtils.join(args, '|'));

		saveSms(map);
	*/}

	/**
	 * 通知确认收款<br>
	 * 尊敬的%s,您得到的%s元捐赠%s已打款，匹配单号为%s,请在%s小时内确认收款。
	 * 
	 * @param mebId
	 * @param args
	 * @throws BusiException
	 */
	public void noticeToConfirm(String mebId, List<String> args) throws BusiException {/*
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
		String mebName = mebBasic.get("mebName").toString();
		args.add(0, mebName);
		String mebPhone = mebBasic.get("mebPhone").toString();

		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", mebId);
		map.put("smsPhone", mebPhone);
		map.put("smsNo", AiProperties.getProperty("toConfirmSms"));
		map.put("smsType", Busi.SMS_TYPE_TOCONFIRM);
		map.put("smsArgs", StringUtils.join(args, '|'));
		saveSms(map);
	*/}

	/**
	 * 通知被冻结<br>
	 * 尊敬的%s,您的会员账户因%s原因被冻结，请联系管理员处理。
	 * 
	 * @param mebId
	 * @param args
	 * @throws BusiException
	 */
	public void noticeToFreeze(String mebId, List<String> args) throws BusiException {/*
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
		String mebName = mebBasic.get("mebName").toString();
		args.add(0, mebName);
		String mebPhone = mebBasic.get("mebPhone").toString();

		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", mebId);
		map.put("smsPhone", mebPhone);
		map.put("smsNo", AiProperties.getProperty("freezeSms"));
		map.put("smsType", Busi.SMS_TYPE_FREEZE);
		map.put("smsArgs", StringUtils.join(args, '|'));

		saveSms(map);
	*/}

	/**
	 * 通知解冻<br>
	 * 尊敬的%s,您的会员账户已解冻。
	 * 
	 * @param mebId
	 * @throws BusiException
	 */
	public void noticeToUnfreeze(String mebId) throws BusiException {/*
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
		String mebName = mebBasic.get("mebName").toString();
		String mebPhone = mebBasic.get("mebPhone").toString();

		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", mebId);
		map.put("smsPhone", mebPhone);
		map.put("smsNo", AiProperties.getProperty("unfreezeSms"));
		map.put("smsType", Busi.SMS_TYPE_UNFREEZE);
		map.put("smsArgs", mebName);

		saveSms(map);
	*/}

	/**
	 * 通知确认开单订单<br>
	 * 尊敬的%s，您的开单商品款项已审核，我们将尽快发货，您可前往互捐中心提供捐助。祝您体验愉快！
	 * 
	 * @param mebId
	 * @throws BusiException
	 */
	public void noticeToConfirmOpenOrder(String mebId) throws BusiException {/*
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
		String mebName = mebBasic.get("mebName").toString();
		String mebPhone = mebBasic.get("mebPhone").toString();

		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", mebId);
		map.put("smsPhone", mebPhone);
		map.put("smsNo", AiProperties.getProperty("openOrderConfirmSms"));
		map.put("smsType", Busi.SMS_TYPE_OPENORDER_CONFIRM);
		map.put("smsArgs", mebName);

		saveSms(map);
	*/}

	/**
	 * 通知开单订单取消<br>
	 * 尊敬的%s,您的开单订单已取消，请您重新下单选购商品，祝您体验愉快！
	 * 
	 * @param mebId
	 * @throws BusiException
	 */
//	public void noticeToCancelOpenOrder(String mebId) throws BusiException {
//		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
//		String mebName = mebBasic.get("mebName").toString();
//		String mebPhone = mebBasic.get("mebPhone").toString();
//
//		Map<String, Object> map = new AiMap<Object>();
//		map.put("mebId", mebId);
//		map.put("smsPhone", mebPhone);
//		map.put("smsNo", AiProperties.getProperty("openOrderCancelSms"));
//		map.put("smsType", Busi.SMS_TYPE_OPENORDER_CANCEL);
//		map.put("smsArgs", mebName);
//
//		saveSms(map);
//	}

	/**
	 * 二次捐赠超时提醒<br>
	 * 尊敬的%s,距您上次捐赠已过去%s天，请于%s日前发起捐赠，以免账户被冻结。
	 * 
	 * @param mebId
	 * @throws BusiException
	 */
	public void warnToNextEntry(String mebId, List<String> args) throws BusiException {/*
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
		String mebName = mebBasic.get("mebName").toString();
		String mebPhone = mebBasic.get("mebPhone").toString();

		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", mebId);
		map.put("smsPhone", mebPhone);
		map.put("smsNo", AiProperties.getProperty("toEntryWarnSms"));
		map.put("smsType", Busi.SMS_TYPE_WARN_TOENTRY);
		args.add(0, mebName);
		map.put("smsArgs", StringUtils.join(args, '|'));

		saveSms(map);
	*/}

	/**
	 * 打款超时提醒<br>
	 * 尊敬的%s,您有已匹配的捐赠单即将超时，请尽快打款，以免账户被冻结。
	 * 
	 * @param mebId
	 * @throws BusiException
	 */
	public void warnToPay(String mebId) throws BusiException {/*
		Map<String, Object> mebBasic = mebBasicDao.loadRecordById(mebId);
		String mebName = mebBasic.get("mebName").toString();
		String mebPhone = mebBasic.get("mebPhone").toString();

		Map<String, Object> map = new AiMap<Object>();
		map.put("mebId", mebId);
		map.put("smsPhone", mebPhone);
		map.put("smsNo", AiProperties.getProperty("toPayWarnSms"));
		map.put("smsType", Busi.SMS_TYPE_WARN_TOPAY);
		map.put("smsArgs", mebName);

		saveSms(map);
	*/}

	/**
	 * 进入短信队列
	 * 
	 * @param map
	 */
	@Transactional
	private void saveSms(Map<String, Object> map) {/*
		boolean isOpenSms = coreParamCache.get("isOpenSms").equals(Busi.YES);
		if (isOpenSms) { // 发送短信
			map.put("sendTime", null);
			map.put("retCode", null);
		} else { // 不发送短信
			map.put("sendTime", new Date());
			map.put("retCode", "999");
		}
		map.put("createTime", new Date());

		DaoApi smsDao = (DaoApi) AiContext.getBean("smsDao");
		smsDao.insertRecord(map);
	*/}

	/**
	 * 读取短信队列并发送
	 */
	@Transactional
	public void autoSms() {/*
		boolean isOpenSms = coreParamCache.get("isOpenSms").equals(Busi.YES);
		if (isOpenSms) {
			String url = "https://api.netease.im/sms/sendtemplate.action";

			// 查询所有未发送短信
			List<Map<String, Object>> list = this.getDaoApi().loadRecords(new Condition("sendTime", null, FieldOper.OPER_IS_NULL));
			Map<String, Object> smsArgs;
			for (Map<String, Object> m : list) {
				smsArgs = new HashMap<String, Object>();
				smsArgs.put("templateid", m.get("smsNo"));
				smsArgs.put("mobiles", JSON.toJSONString(new String[] { m.get("smsPhone").toString() }));
				smsArgs.put("params", JSON.toJSONString(m.get("smsArgs").toString().split("\\|")));

				String retStr;
				try {
					retStr = CheckSumBuilder.sendSms(url, smsArgs);
				} catch (Exception e) {
					e.printStackTrace();
					throw new BusiException("发送短信失败");
				}

				// 记录发送结果
				String retCode = ((Map<String, Object>) JSON.parse(retStr)).get("code").toString();
				m.put("sendTime", new Date());
				m.put("retCode", retCode);
				this.getDaoApi().updateRecord(m);
			}
		}
	*/}

	/**
	 * 管理员通知
	 * 
	 * @param msg
	 *            通知信息
	 */
	public void warning(String msg) {/*
		Map<String, Object> smsArgs = new HashMap<String, Object>();
		smsArgs.put("templateid", "3058450");
		smsArgs.put("mobiles", JSON.toJSONString(new String[] { "13971495014", "13971251023" }));
		smsArgs.put("params", JSON.toJSONString(new String[] { msg }));
		try {
			CheckSumBuilder.sendSms("https://api.netease.im/sms/sendtemplate.action", smsArgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	*/}

	@Override
	public ResultBean sendCode(String phone) {
		return null;
	}

	@Override
	public ResultBean verifyCode(String phone, String code) {
		return null;
		
	}

	@Override
	public ResultBean sendSms(Object sms) {
		return null;
		
	}

	@Override
	public ResultBean sendSms() {
		return null;
		
	}

	@Override
	public ResultBean sendSmsImmediate(Object sms) {
		return null;
		
	}
}
