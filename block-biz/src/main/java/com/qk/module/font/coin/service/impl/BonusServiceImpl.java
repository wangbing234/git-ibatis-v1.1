package com.qk.module.font.coin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.service.BonusService;

/**
 * 计算分红service
 * 
 * @author smart迅
 * 
 */
@Service
public class BonusServiceImpl implements BonusService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

/*	@Autowired
	private DaoApi bizBonusDao;

	@Autowired
	private DaoApi bizBonusGrowDao;

	@Autowired
	private DaoApi mebWalletDao;

	@Autowired
	private DaoApi mebInfoDao;

	@Autowired
	private DaoApi mebStatsDao;

	@Autowired
	private DaoApi groupGrowDao;

	@Autowired
	private CoreParamCache coreParamCache;*/

	@Autowired
	private WalletServiceImpl walletService;

	@Autowired
	private CoinServiceImpl coinTransService;

/*	@Autowired
	private ProviderApi bonusProvider;

	@Autowired
	private SysInteractionService sysInteractionService;*/

	/**
	 * 返回值所在档位
	 * 
	 * @param value
	 *            值
	 * @param stages
	 *            阶梯
	 * @return
	 */
	private int getStage(int value, String[] stages) {
		int ret = 0;
		for (String s : stages) {
			if (value > Integer.parseInt(s)) {
				ret += 1;
			} else {
				break;
			}
		}
		return ret;
	}

	/**
	 * 拆分收益
	 * 
	 * @param value
	 * @return
	 */
	private int[] splitProfit(int value) {
		return null;/*
		String[] ratios = coreParamCache.getValues("toWalletRatio");
		int[] ret = new int[ratios.length];
		ret[ret.length - 1] = value;
		for (int i = 0; i < ret.length - 1; i++) {
			ret[i] = Math.round(value * Float.valueOf(ratios[i]) * 100) / 100;
			ret[ret.length - 1] -= ret[i];
		}
		return ret;
	*/}

	/**
	 * 返回分红信息
	 * 
	 * @return {base, bonusRatio, bonus, canNotBonusReason, game, gameNeeded}
	 */
	public Map<String, Object> toBonus() {
		return null;/*
		String mebId = AiContext.getLoginId();
		Map<String, Object> mebWallet = mebWalletDao.loadRecordById(mebId);
		int totalBase = (int) mebWallet.get("baseFree") + (int) mebWallet.get("baseFreeze"); // 合计本金

		String[] bonusRateStageParam = coreParamCache.getValues("bonusRateStage"); // 参数：分红静态利息阶梯
		String[] bonusRatioParam = coreParamCache.getValues("bonusRatio"); // 参数：分红静态利息
		float bonusRatio = Float.valueOf(bonusRatioParam[getStage(totalBase, bonusRateStageParam)]); // 利率

		// 分红中
		And and = new And();
		and.add("mebId", mebId);
		and.add("state", Busi.STATE_INIT);

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("base", totalBase); // 本金
		ret.put("ratio", bonusRatio); // 利率
		ret.put("bonus", Math.round(totalBase * bonusRatio * 100) / 100); // 红利
		// 不可分红原因
		if (0 == totalBase) {
			ret.put("canNotBonusReason", "无可分红本金，不可参与分红");
		} else if (bizBonusDao.getRecordsCount(and) > 0) {
			ret.put("canNotBonusReason", "分红中，不可再参与分红");
		} else if (mebWallet.get("isNeedExit").toString().equals(Busi.YES)) {
			ret.put("canNotBonusReason", "收益已满，不可再参与分红，请提取本金");
		} else {
			ret.put("canNotBonusReason", null);
		}
		ret.put("game", mebWallet.get("gameCoin")); // 持有排单币
		ret.put("gameNeeded", coinTransService.calGame(totalBase)); // 所需排单币
		return ret;
	*/}

	/**
	 * @author smart迅 计算分红
	 * @param request
	 * @return
	 */
	@Transactional
	public ResultBean bonus() {
		return null;/*
		ResultBean rsp = new ResultBean();
		rsp.setSuccess(false);
		String mebId = AiContext.getLoginId();
		Map<String, Object> toBonusMap = toBonus();

		// 用户状态校验
		Map<String, Object> mebInfo = mebInfoDao.loadRecordById(mebId);
		if (!mebInfo.get("meb_state").toString().equals(Busi.MEB_STATE_OK)) {
			rsp.setSuccess(false);
			rsp.setMsg("用户状态错误，请确认已认证");
			log.error("meb state not 1");
			return rsp;
		}

		if (null != toBonusMap.get("canNotBonusReason")) {
			rsp.setMsg(toBonusMap.get("canNotBonusReason").toString());
			return rsp;
		}

		if ((int) toBonusMap.get("game") < (int) toBonusMap.get("gameNeeded")) {
			rsp.setMsg("分红服务次数不足");
			return rsp;
		}

		int totalFree = (int) toBonusMap.get("base"); // 合计本金
		// 扣排单币
		coinTransService.gameCoinUse(mebId, totalFree);

		int bonusCount = (int) mebStatsDao.loadRecordById(mebId).get("bonusCount"); // 分红次数

		Map<String, Object> bizBonusMap = new AiMap<Object>();
		bizBonusMap.put("meb_id", mebId);
		bizBonusMap.put("state", Busi.STATE_INIT);
		bizBonusMap.put("count", bonusCount + 1);
		bizBonusMap.put("amount", (int) totalFree);
		bizBonusMap.put("bonus_rate", 0);
		bizBonusMap.put("bonus_amount", 0);
		bizBonusMap.put("bonusCount", 0);
		// 临时调整为秒级测试用，默认天级
		bizBonusMap.put("to_unfreeze_time", DateUtil.offsetDate(new Date(), Integer.parseInt(coreParamCache.get("bonusFreezeDays"))));
		bizBonusDao.insertRecord(bizBonusMap);

		// 累加分红次数
		mebStatsDao.incNumberField(mebId, "bonusCount", 1);

		rsp.setSuccess(true);
		return rsp;
	*/}

	/**
	 * 定时任务调用
	 * 
	 * @author smart迅
	 *
	 */
	public void bonusUnfreezeJob() {/*
		And and = new And();
		and.add("state", Busi.STATE_INIT);
		and.add("toUnfreezeTime", new Date(), FieldOper.OPER_SMALL_EQUAL_DATETIME);
		bizBonusDao.loadRecords(and).forEach(map -> this.bonusUnfreeze(String.valueOf(map.get("rid"))));
	*/}

	/**
	 * 分红解冻
	 * 
	 * @param rid
	 */
	@Transactional
	public void bonusUnfreeze(String rid) {/*
		Map<String, Object> bizBonus = bizBonusDao.loadRecordById(rid);
		String state = bizBonus.get("state").toString();

		// 检查当前状态
		if (state.equals(Busi.STATE_UNFREEZE)) {
			log.warn("重复解冻, rid=" + rid);
			return;
		}

		// 分红主表变更状态
		Map<String, Object> map = new AiMap<Object>();
		map.put("rid", rid);
		map.put("unfreezeTime", new Date());
		map.put("state", Busi.STATE_UNFREEZE);
		bizBonusDao.updateRecord(map);

		String mebId = bizBonus.get("mebId").toString(); // 分红会员
		int bonus = (int) bizBonus.get("bonusAmount"); // 红利

		updateWallet(mebId, bonus, true, rid);

		// 更新统计数据
		mebStatsDao.incNumberField(mebId, "bonusTotal", bonus);
		mebStatsDao.incNumberField(mebId, "thisBonusTotal", bonus);

		// 分红完成时，创建提成副表
		Map<String, Object> bizBonusGrow = new AiMap<Object>();
		bizBonusGrow.put("id", rid);

		int base = (int) bizBonus.get("amount"); // 本金
		int bonusCount = (int) bizBonus.get("count"); // 分红次数
		Map<String, Object> mebInfo = mebInfoDao.loadRecordById(mebId);
		int referee = (int) mebInfo.get("mebReferee"); // 推荐人
		int referee2 = (int) mebInfo.get("mebReferee2"); // 二级推荐人
		int groupId = (int) mebInfo.get("groupId"); // 所属团队

		bizBonusGrow.put("referee", referee);
		bizBonusGrow.put("referee2", referee2);

		// 计算推荐奖（仅初次分红有效）
		int rewardAmount = 0; // 推荐奖
		if (1 == bonusCount && referee > 0) {
			String[] rewardStageParams = coreParamCache.getValues("rewardStage");
			String[] rewardGrowRateParam = coreParamCache.getValues("rewardRatio");
			float rewardGrowRate = Float.valueOf(rewardGrowRateParam[getStage(base, rewardStageParams)]); // 推荐奖提成比率
			rewardAmount = Math.round(base * rewardGrowRate * 100) / 100;

			bizBonusGrow.put("reward_grow_rate", rewardGrowRate);
			bizBonusGrow.put("reward_grow", rewardAmount);
		}

		// 计算团队提成（仅初次分红有效）
		if (1 == bonusCount && groupId > 0) {
			float groupRate = Float.valueOf(coreParamCache.get("groupGrowRatio")); // 团队提成比率

			bizBonusGrow.put("group_rate", groupRate);
			bizBonusGrow.put("group_grow", Math.round(base * groupRate * 100) / 100);

			// 新增团队贡献数据
			Map<String, Object> groupGrow = new AiMap<>();
			groupGrow.put("mebId", mebId);
			groupGrow.put("amount", Math.round(base * groupRate * 100) / 100);
			groupGrow.put("bonusId", rid);
			groupGrowDao.insertRecord(groupGrow);
		}

		// 计算领导奖
		int growAmount = 0; // 推荐人提成
		if (referee > 0) {
			map = calGrow(String.valueOf(referee), bonus);
			growAmount = (int) map.get("amount");

			// 保存数据
			bizBonusGrow.put("groupCount", map.get("count"));
			bizBonusGrow.put("growlv", map.get("lv"));
			bizBonusGrow.put("growRate", map.get("ratio"));
			bizBonusGrow.put("growAmount", growAmount);

			updateWallet(String.valueOf(referee), growAmount, false, rid);
		}

		int grow2Amount = 0; // 二级推荐人提成
		if (referee2 > 0) {
			map = calGrow(String.valueOf(referee2), growAmount);
			grow2Amount = (int) map.get("amount");

			// 保存数据
			bizBonusGrow.put("group2Count", map.get("count"));
			bizBonusGrow.put("grow2lv", map.get("lv"));
			bizBonusGrow.put("grow2Rate", map.get("ratio"));
			bizBonusGrow.put("grow2Amount", grow2Amount);

			updateWallet(String.valueOf(referee2), grow2Amount, false, rid);
		}
		// 保存数据
		bizBonusGrowDao.insertRecord(bizBonusGrow);

		// 更新统计数据
		if (growAmount + rewardAmount > 0) {
			mebStatsDao.incNumberField(String.valueOf(referee), "growTotal", growAmount + rewardAmount);
			mebStatsDao.incNumberField(String.valueOf(referee), "thisGrowTotal", growAmount + rewardAmount);
		}
		if (grow2Amount > 0) {
			mebStatsDao.incNumberField(String.valueOf(referee2), "growTotal", grow2Amount);
			mebStatsDao.incNumberField(String.valueOf(referee2), "thisGrowTotal", grow2Amount);
		}

		// 触发劝退判定
		updateNeedExit(mebId);
		if (referee > 0) {
			updateNeedExit(String.valueOf(referee));
		}
		if (referee2 > 0) {
			updateNeedExit(String.valueOf(referee2));
		}

		// 赠送积分
		givePoint(rid, mebId, referee);
	*/}

	/**
	 * 维护分红表point_flag字段，调接口成功后更新为2，否则用默认值1
	 * 
	 * @author smart迅
	 * @param mebId
	 * @param referee
	 */
	private void givePoint(String rid, String mebId, int referee) {/*
		ResponseBean rsp = new ResponseBean();
		// 赠送积分
		int pointPerBonus = Integer.parseInt(coreParamCache.get("pointPerBonus"));

		rsp = sysInteractionService.addNonactivatedPoint(mebId, pointPerBonus);
		// 赠送积分成功
		if (rsp.isSuccess()) {
			bizBonusDao.updateRecord(rid, "point_flag", Busi.STATE_FIN);
		}
		if (referee > 0) {
			int point2PerBonus = Integer.parseInt(coreParamCache.get("point2PerBonus"));
			rsp = sysInteractionService.addNonactivatedPoint(String.valueOf(referee), point2PerBonus);
			// 赠送积分成功
			if (rsp.isSuccess()) {
				bizBonusDao.updateRecord(rid, "point_flag", Busi.STATE_FIN);
			}
		}
	*/}

	/**
	 * 定时任务<br>
	 * 检查分红解冻但积分还未赠送的继续执行赠送积分动作
	 * 
	 * @author smart迅
	 *
	 */
	public void recheckPointGive() {/*
		And and = new And();
		and.add("state", Busi.STATE_UNFREEZE);
		and.add("point_flag", Busi.STATE_INIT);
		List<Map<String, Object>> bonusList = bizBonusDao.loadRecords(and);
		log.info("bonusList size " + bonusList.size());
		for (Map<String, Object> m : bonusList) {
			log.info("recheckPointGive mebid = " + m.get("mebId").toString());
			Map<String, Object> mebInfo = mebInfoDao.loadRecordById(m.get("mebId").toString());
			int referee = (int) mebInfo.get("mebReferee"); // 推荐人
			givePoint(m.get("rid").toString(), m.get("mebId").toString(), referee);
		}

	*/}

	/**
	 * 计算推荐人提成
	 * 
	 * @param mebId
	 *            提成推荐人
	 * @param preProfit
	 *            提成计算金额
	 * @return {lv, count, ratio, amount}
	 */
	private Map<String, Object> calGrow(String mebId, int preProfit) {
		return null;/*
		// 一级团队人数
		int mebGroupCount = (int) mebStatsDao.loadRecordById(mebId).get("mebGroupCount");
		// 提成等级
		String[] growStageParam = coreParamCache.getValues("growStage");
		String[] growRatioParam = coreParamCache.getValues("growRatio");
		int lv = getStage(mebGroupCount, growStageParam);
		// 提成比率
		float ratio = Float.valueOf(growRatioParam[lv]);

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("lv", lv); // 提成等级
		ret.put("count", mebGroupCount); // 直推人数
		ret.put("ratio", ratio); // 提成比率
		ret.put("amount", Math.round(preProfit * ratio * 100) / 100); // 提成金额

		return ret;
	*/}

	/**
	 * 更新财务数据
	 * 
	 * @param mebId
	 *            会员
	 * @param profit
	 *            收益
	 * @param isBonus
	 *            是红利还是提成
	 * @param rid
	 *            分红单编号
	 */
	private void updateWallet(String mebId, int profit, boolean isBonus, String rid) {/*
		if (profit > 0) {
			// 拆分收益
			int[] values = splitProfit(profit);

			// 更新财务数据
			Map<String, Number> incValue = new HashMap<String, Number>();
			if (isBonus) {
				incValue.put("bonusFree", values[0]); // 红利
			} else {
				incValue.put("growFree", values[0]); // 提成
			}
			incValue.put("shopFree", values[1]); // 消费券
			incValue.put("taxFree", values[2]); // 税收
			incValue.put("publicFree", values[3]); // 公益
			walletService.inc(String.valueOf(mebId), incValue, Busi.WALLET_CHANGE_BONUS, rid);
		}
	*/}

	/**
	 * 更新是否劝退
	 * 
	 * @param mebId
	 */
	public void updateNeedExit(String mebId) {/*
		Map<String, Object> mebWallet = mebWalletDao.loadRecordById(mebId);
		int baseFree = (int) mebWallet.get("baseFree");
		int baseFreeze = (int) mebWallet.get("baseFreeze");
		Map<String, Object> mebStats = mebStatsDao.loadRecordById(mebId);
		int bonus = (int) mebStats.get("thisBonusTotal");
		int grow = (int) mebStats.get("thisGrowTotal");
		int needExitTimes = Integer.valueOf(coreParamCache.get("needExitTimes"));
		int needExitTimes2 = Integer.valueOf(coreParamCache.get("needExitTimes2"));

		if (bonus > (baseFree + baseFreeze) * needExitTimes || bonus + grow > (baseFree + baseFreeze) * needExitTimes2) {
			mebWalletDao.updateRecord(mebId, "isNeedExit", Busi.YES);
		}
	*/}

	/**
	 * 提取本金后，清除劝退标识
	 * 
	 * @param mebId
	 */
	@Transactional
	public void clearNeedExit(String mebId) {/*
		Map<String, Object> mebWallet = mebWalletDao.loadRecordById(mebId);
		boolean isNeedExit = mebWallet.get("isNeedExit").toString().equals(Busi.YES);
		if (isNeedExit) {
			mebWalletDao.updateRecord(mebId, "isNeedExit", Busi.NO);
			mebStatsDao.updateRecord(mebId, "thisBonusTotal", 0);
			mebStatsDao.updateRecord(mebId, "thisGrowTotal", 0);
		}
	*/}

	/**
	 * 利润分红历史
	 * 
	 * @author smart迅
	 * @return
	 */
	public List<Map<String, Object>> bonusList() {
		return null;/*
		return bizBonusDao.loadRecords("meb_id", AiContext.getLoginId());
	*/}

	/**
	 * 市场分红历史
	 * 
	 * @author smart迅
	 * @return
	 */
	public List<Map<String, Object>> growList() {
		return null;/*
		String mebId = AiContext.getLoginId();
		log.info("growList mebid :" +mebId);
		Or or = new Or();
		or.add("referee", mebId);
		or.add("referee2", mebId);
		List<Map<String, Object>> list = bonusProvider.loadRecords(or);
		list.forEach(map -> {
			if (map.get("referee").toString().equals(mebId)) {
				map.put("linkDegree", 1); // 一级团队
			} else {
				map.put("linkDegree", 2); // 二级团队
			}
		});
		return list;
	*/}

	/**
	 * 查询最近一次分红
	 * 
	 * @author smart迅
	 * @return
	 */
	public Map<String, Object> getLatestBonus() {
		return null;/*
		List<Map<String, Object>> result = bizBonusDao.loadRecords(new Condition("mebId", AiContext.getLoginId()), new Order("createTime", "desc"));
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
	*/}

	/**
	 * 定时任务更新昨日分红
	 * 
	 * @author smart迅
	 *
	 */
	public void updateBonusDay() {/*
		And and = new And();
		and.add("state", Busi.STATE_INIT);
		List<Map<String, Object>> bonusList = bizBonusDao.loadRecords(and);
		for (Map<String, Object> m : bonusList) {
			int mebId = (int) m.get("meb_id");
			int rid = new Long((long) m.get("rid")).intValue();
			int amount = (int) m.get("amount");
			int bonusCount = (int) m.get("bonusCount");

			int bonusFreezeDays = Integer.parseInt(coreParamCache.get("bonusFreezeDays")); // 分红周期
			if (bonusCount >= bonusFreezeDays) {
				continue;
			}

			String[] bonusRateStageParam = coreParamCache.getValues("bonusRateStage"); // 参数：分红静态利息阶梯
			String[] bonusRatioParam = coreParamCache.getValues("bonusRatio"); // 参数：分红静态利息
			float bonusRatio = Float.valueOf(bonusRatioParam[getStage(amount, bonusRateStageParam)]); // 利率

			int increaceBonus = (int) ((bonusRatio * amount) / bonusFreezeDays);
			if (1 == mebStatsDao.updateRecord(String.valueOf(mebId), "last_bonus", increaceBonus)) {
				Map<String, Number> incValue = new HashMap<>();
				incValue.put("bonusCount", 1);
				incValue.put("bonusAmount", increaceBonus);
				bizBonusDao.incNumberField(String.valueOf(rid), incValue);
			}
		}
	*/}

	@Override
	public ResultBean bonus(String mebId, int amount) {
		return null;
	}

	@Override
	public ResultBean bonusFinish(String bonusId) {
		return null;
		
	}
}
