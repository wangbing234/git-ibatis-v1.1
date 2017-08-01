package com.qk.module.font.coin.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.domain.entity.AiMapping;
import com.qk.module.font.coin.domain.enums.WalletChangeReason;
import com.qk.module.font.coin.domain.enums.WalletSubType;
import com.qk.module.font.coin.domain.enums.WalletType;
import com.qk.module.font.coin.service.WalletService;
import com.qk.module.font.common.exception.BusiException;

/**
 * 实现各钱包数据变更及记账
 *
 */
@Service
public class WalletServiceImpl implements WalletService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static DecimalFormat DECIMAL_TWO = new DecimalFormat("#.##"); // 保留2位小数

	/*@Autowired
	private DaoApi mebWalletDao;
	@Autowired
	private DaoApi mebWalletLogDao;*/

	public boolean save(Map<String, Object> map) throws BusiException {
		return false;/*
		String phone = map.get("mebPhone").toString();
		String name = map.get("mebName").toString();
		And and = new And();
		and.add(new Condition("mebPhone", phone));
		and.add(new Condition("mebName", name));
		DaoApi mebInfoDao = (DaoApi) AiContext.getBean("mebInfoDao");
		List<Map<String, Object>> mebInfoList = mebInfoDao.loadRecords(and);
		if (mebInfoList.size() == 1) {
			String walletType = map.get("walletType").toString();
			String walletSubType = map.get("walletSubType").toString();
			Number amount;
			try {
				amount = Integer.parseInt(map.get("amount").toString());
			} catch (NumberFormatException e) {
				amount = Float.parseFloat(map.get("amount").toString());
			}
			String remark = map.get("remark").toString();
			this.inc(mebInfoList.get(0).get("mebId").toString(), walletType, walletSubType, amount, remark);
		} else {
			throw new BusiException("无效会员信息");
		}
		return true;
	*/}

	/**
	 * 增加钱包数据
	 * 
	 * @param mebId
	 * @param field
	 * @param incValue
	 * @param changeReason
	 * @param changeId
	 * @throws BusiException
	 */
	@Transactional
	public void inc(String mebId, String field, Number incValue, String changeReason, String changeId) throws com.qk.module.font.common.exception.BusiException {/*
		Map<String, Number> values = new HashMap<String, Number>();
		values.put(field, incValue);
		inc(mebId, values, changeReason, changeId);
	*/}

	/**
	 * 批量增加钱包
	 * 
	 * @param mebId
	 * @param incValue（int或float）
	 * @param changeReason
	 * @param changeId
	 * @throws BusiException
	 */
	@Transactional
	public <T extends Number> void inc(String mebId, Map<String, T> incValue, String changeReason, String changeId) throws BusiException {/*
		Map<String, Object> mebWallet = mebWalletDao.loadRecordById(mebId); // 会员钱包
		Map<String, Number> walletValue = new HashMap<String, Number>();

		Map<String, Object> mebWalletLog; // 财务变更日志
		for (Map.Entry<String, T> entry : incValue.entrySet()) {
			String walletName = entry.getKey();
			T value = entry.getValue();
			if (0 == value.doubleValue()) {
				continue;
			}

			mebWalletLog = new AiMap<Object>();
			mebWalletLog.put("mebId", mebId);
			mebWalletLog.put("createTime", new Date());

			// 变更对象
			String[] type = getWalletType(walletName);
			mebWalletLog.put("walletType", type[0]);
			mebWalletLog.put("walletSubType", type[1]);

			// 变更金额
			mebWalletLog.put("changeAmount", value);
			if (value instanceof Integer) { // 整数
				int preValue = (int) mebWallet.get(walletName);
				mebWalletLog.put("newAmount", preValue + (int) value);
			} else { // 小数
				float preValue = (float) mebWallet.get(walletName);
				mebWalletLog.put("newAmount", preValue + (float) value);
			}

			// 变更原因
			mebWalletLog.put("changeReason", changeReason);
			mebWalletLog.put("changeId", changeId);

			mebWalletLogDao.insertRecord(mebWalletLog);

			if (value instanceof Integer) { // 整数
				walletValue.put(walletName, value);
			} else { // 保留2位小数
				walletValue.put(walletName, Float.parseFloat(DECIMAL_TWO.format(value)));
			}
		}

		mebWalletDao.incNumberField(mebId, walletValue);
	*/}

	/**
	 * 增加钱包数据
	 * 
	 * @param mebId
	 * @param walletType
	 * @param walletSubType
	 * @param value（int或float）
	 * @param remark
	 * @throws BusiException
	 */
	@Transactional
	public <T extends Number> void inc(String mebId, String walletType, String walletSubType, T value, String remark) throws BusiException {/*
		Map<String, Object> mebWallet = mebWalletDao.loadRecordById(mebId); // 会员钱包
		Map<String, Number> walletValue = new HashMap<String, Number>();

		Map<String, Object> mebWalletLog; // 财务变更日志

		mebWalletLog = new AiMap<Object>();
		mebWalletLog.put("mebId", mebId);
		mebWalletLog.put("createTime", new Date());
		mebWalletLog.put("walletType", walletType);
		mebWalletLog.put("walletSubType", walletSubType);

		String walletName = getWalletName(walletType, walletSubType);

		// 变更金额
		mebWalletLog.put("changeAmount", value);
		if (value instanceof Integer) { // 整数
			int preValue = (int) mebWallet.get(walletName);
			mebWalletLog.put("newAmount", preValue + (int) value);
		} else { // 小数
			float preValue = (float) mebWallet.get(walletName);
			mebWalletLog.put("newAmount", preValue + (float) value);
		}

		// 变更原因
		mebWalletLog.put("changeReason", Busi.WALLET_CHANGE_MANUAL);
		mebWalletLog.put("oper", AiContext.getLoginId());
		mebWalletLog.put("operRemark", remark);

		mebWalletLogDao.insertRecord(mebWalletLog);

		if (value instanceof Integer) { // 整数
			walletValue.put(walletName, value);
		} else { // 保留2位小数
			walletValue.put(walletName, Float.parseFloat(DECIMAL_TWO.format(value)));
		}

		mebWalletDao.incNumberField(mebId, walletValue);
	*/}

	/**
	 * 获取钱包名称
	 * 
	 * @param walletType
	 * @param walletSubType
	 * @return
	 */
	private String getWalletName(String walletType, String walletSubType) {
		return walletSubType;/*
		// 本金
		if (walletType.equals(Busi.WALLET_TYPE_BASE) && walletSubType.equals(Busi.WALLET_SUB_TYPE_FREE)) {
			return "baseFree";
		}
		if (walletType.equals(Busi.WALLET_TYPE_BASE) && walletSubType.equals(Busi.WALLET_SUB_TYPE_FREEZE)) {
			return "baseFreeze";
		}
		if (walletType.equals(Busi.WALLET_TYPE_BASE) && walletSubType.equals(Busi.WALLET_SUB_TYPE_EXIT)) {
			return "baseDrawing";
		}

		// 红利
		if (walletType.equals(Busi.WALLET_TYPE_BONUS) && walletSubType.equals(Busi.WALLET_SUB_TYPE_FREE)) {
			return "bonusFree";
		}
		if (walletType.equals(Busi.WALLET_TYPE_BONUS) && walletSubType.equals(Busi.WALLET_SUB_TYPE_EXIT)) {
			return "bonusDrawing";
		}

		// 推广
		if (walletType.equals(Busi.WALLET_TYPE_GROW) && walletSubType.equals(Busi.WALLET_SUB_TYPE_FREE)) {
			return "growFree";
		}

		// 消费券
		if (walletType.equals(Busi.WALLET_TYPE_SHOP) && walletSubType.equals(Busi.WALLET_SUB_TYPE_FREE)) {
			return "shopFree";
		}

		// 税收
		if (walletType.equals(Busi.WALLET_TYPE_TAX) && walletSubType.equals(Busi.WALLET_SUB_TYPE_FREE)) {
			return "taxFree";
		}

		// 公益
		if (walletType.equals(Busi.WALLET_TYPE_PUBLIC) && walletSubType.equals(Busi.WALLET_SUB_TYPE_FREE)) {
			return "publicFree";
		}

		return null;
	*/}

	/**
	 * 获取钱包类型
	 * 
	 * @param walletType
	 * @param walletSubType
	 * @return
	 */
	private String[] getWalletType(String walletName) {
		return null;/*
		String[] type = new String[2];

		if (walletName.equals("baseFree")) { // 本金
			type[0] = Busi.WALLET_TYPE_BASE;
			type[1] = Busi.WALLET_SUB_TYPE_FREE;
		} else if (walletName.equals("baseFreeze")) {
			type[0] = Busi.WALLET_TYPE_BASE;
			type[1] = Busi.WALLET_SUB_TYPE_FREEZE;
		} else if (walletName.equals("baseDrawing")) {
			type[0] = Busi.WALLET_TYPE_BASE;
			type[1] = Busi.WALLET_SUB_TYPE_EXIT;

		} else if (walletName.equals("bonusFree")) { // 红利
			type[0] = Busi.WALLET_TYPE_BONUS;
			type[1] = Busi.WALLET_SUB_TYPE_FREE;
		} else if (walletName.equals("bonusDrawing")) {
			type[0] = Busi.WALLET_TYPE_BONUS;
			type[1] = Busi.WALLET_SUB_TYPE_EXIT;

		} else if (walletName.equals("growFree")) { // 推广
			type[0] = Busi.WALLET_TYPE_GROW;
			type[1] = Busi.WALLET_SUB_TYPE_FREE;

		} else if (walletName.equals("shopFree")) { // 消费券
			type[0] = Busi.WALLET_TYPE_SHOP;
			type[1] = Busi.WALLET_SUB_TYPE_FREE;

		} else if (walletName.equals("taxFree")) { // 税收
			type[0] = Busi.WALLET_TYPE_TAX;
			type[1] = Busi.WALLET_SUB_TYPE_FREE;

		} else if (walletName.equals("publicFree")) { // 公益
			type[0] = Busi.WALLET_TYPE_PUBLIC;
			type[1] = Busi.WALLET_SUB_TYPE_FREE;
		}

		return type;
	*/}

	/**
	 * 赠送激活码
	 * 
	 * @param params
	 * @return
	 * @throws BusiException
	 */
	@Transactional
	public boolean activeGive(AiMapping params) throws BusiException {
		return false;/*
		// 用户ID
		String sId = AiContext.getLoginId();
		// 受赠用户ID
		String sTargetId = params.get("id");
		// 赠送激活码数量
		int nCount = Integer.parseInt(params.get("count"));

		String mebState = params.get("mebState");

		// 虚拟货币交易记录表
		DaoApi bizCoinTransDao = (DaoApi) AiContext.getBean("bizCoinTransDao");
		Map<String, Object> bizCoinTransMap = new AiMap<Object>();

		// 1-激活码 2-排单币
		bizCoinTransMap.put("Coin_type", Busi.COIN_TYPE_ACTIVE);

		// 受赠用户状态为 MEB_STATE_OK-1-正常
		if (mebState.equals(Busi.MEB_STATE_OK)) {
			// 当前用户激活码数量减去 赠送数量
			mebWalletDao.incNumberField(sId, "active_coin", -nCount);

			// 受赠用户激活码数量加上 赠送数量
			mebWalletDao.incNumberField(sTargetId, "active_coin", nCount);

			bizCoinTransMap.put("Create_time", new Date());
			bizCoinTransMap.put("Trans_count", nCount);
			bizCoinTransMap.put("sender", sId);
			bizCoinTransMap.put("receiver", sTargetId);
			// 转移方式 1–系统分配 2–会员之间 3–已使用
			bizCoinTransMap.put("Trans_type", Busi.COIN_TRANS_TYPE_MEB);

			bizCoinTransDao.insertRecord(bizCoinTransMap);

			return true;
		}
		// 受赠用户状态为3-未激活
		else {
			// 激活码赠送数量为1
			if (nCount == 1) {
				// 当前用户激活码数量减去 赠送数量
				mebWalletDao.incNumberField(sId, "active_coin", -1);

				bizCoinTransMap.put("Create_time", new Date());
				bizCoinTransMap.put("Trans_count", nCount);
				bizCoinTransMap.put("sender", sId);
				bizCoinTransMap.put("receiver", sTargetId);
				// 转移方式 1–系统分配 2–会员之间 3–已使用
				bizCoinTransMap.put("Trans_type", Busi.COIN_TRANS_TYPE_MEB);
				bizCoinTransDao.insertRecord(bizCoinTransMap);

				bizCoinTransMap.put("Create_time", new Date());
				bizCoinTransMap.put("Trans_count", 1);
				bizCoinTransMap.put("sender", sTargetId);
				bizCoinTransMap.put("receiver", "0");
				// 转移方式 1–系统分配 2–会员之间 3–已使用
				bizCoinTransMap.put("Trans_type", Busi.COIN_TRANS_TYPE_USED);
				bizCoinTransDao.insertRecord(bizCoinTransMap);
			}
			// 激活码赠送数量大于1
			else {
				int vCount = nCount - 1;
				// 当前用户激活码数量减去 （赠送数量）
				mebWalletDao.incNumberField(sId, "active_coin", -nCount);
				// 受赠用户激活码数量加上 （赠送数量-1）
				mebWalletDao.incNumberField(sTargetId, "active_coin", vCount);

				bizCoinTransMap.put("Create_time", new Date());
				bizCoinTransMap.put("Trans_count", nCount);
				bizCoinTransMap.put("sender", sId);
				bizCoinTransMap.put("receiver", sTargetId);
				// 转移方式 1–系统分配 2–会员之间 3–已使用
				bizCoinTransMap.put("Trans_type", Busi.COIN_TRANS_TYPE_MEB);
				bizCoinTransDao.insertRecord(bizCoinTransMap);

				bizCoinTransMap.put("Create_time", new Date());
				bizCoinTransMap.put("Trans_count", 1);
				bizCoinTransMap.put("sender", sTargetId);
				bizCoinTransMap.put("receiver", "0");
				// 转移方式 1–系统分配 2–会员之间 3–已使用
				bizCoinTransMap.put("Trans_type", Busi.COIN_TRANS_TYPE_USED);
				bizCoinTransDao.insertRecord(bizCoinTransMap);

			}

			MemberService memberService = (MemberService) AiContext.getBean("memberService");
			if (memberService.active(Integer.parseInt(sTargetId))) {
				return true;
			}
			return false;
		}
	*/}

	/**
	 * 赠送排单币
	 * 
	 * @param params
	 * @return
	 * @throws BusiException
	 */
	/*
	@Transactional
	public boolean gameCoinGive(AiMap<String> params) throws BusiException {
		// 用户ID
		String sId = AiContext.getLoginId();
		// 受赠用户ID
		String sTargetId = params.get("id");
		// 赠送排单币数量
		int nCount = Integer.parseInt(params.get("count"));

		// String mebState = params.get("mebState");

		// 虚拟货币交易记录表
		DaoApi bizCoinTransDao = (DaoApi) AiContext.getBean("bizCoinTransDao");
		Map<String, Object> bizCoinTransMap = new AiMap<Object>();

		// 1-激活码 2-排单币
		bizCoinTransMap.put("Coin_type", Busi.COIN_TYPE_GAME);

		// 受赠用户状态为 MEB_STATE_OK-1-正常

		// 当前用户排单币数量减去 赠送数量
		mebWalletDao.incNumberField(sId, "game_coin", -nCount);

		// 受赠用户排单币数量加上 赠送数量
		mebWalletDao.incNumberField(sTargetId, "game_coin", nCount);

		bizCoinTransMap.put("Create_time", new Date());
		bizCoinTransMap.put("Trans_count", nCount);
		bizCoinTransMap.put("sender", sId);
		bizCoinTransMap.put("receiver", sTargetId);
		// 转移方式 1–系统分配 2–会员之间 3–已使用
		bizCoinTransMap.put("Trans_type", Busi.COIN_TRANS_TYPE_MEB);

		bizCoinTransDao.insertRecord(bizCoinTransMap);

		return true;
	}*/

	/**
	 * 查询钱包金额变更历史
	 * 
	 * @author smart迅
	 * @return
	 */
	public List<Map<String, Object>> getList(String walletType) {
		return null;/*
		String mebId = AiContext.getLoginId();
		And and = new And();
		and.add("mebId", mebId);
		and.add("walletType", walletType, FieldOper.OPER_IN);
		return mebWalletLogDao.loadRecords(and, new Order("createTime", "desc"));
	*/}

	@Override
	public ResultBean inc(String mebId, String walletName, int incValue, WalletChangeReason changeReason,
			String changeId) {
				return null;
	}

	@Override
	public ResultBean inc(String mebId, Map<String, Integer> incValueMap, WalletChangeReason changeReason,
			String changeId) {
				return null;
	}

	@Override
	public ResultBean inc(String mebId, WalletType walletType, WalletSubType walletSubType, int value, String remark) {
		return null;
	}

	@Override
	public List<Map<String, Object>> getLog(WalletType walletType, WalletSubType walletSubType) {
		return null;
	}
}
