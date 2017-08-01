package com.qk.module.font.coin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.service.ExitService;

@Service
public class ExitServiceImpl implements ExitService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*@Autowired
	private DaoApi exitDao;

	@Autowired
	private DaoApi bizBonusDao;

	@Autowired
	private DaoApi mebInfoDao;
	@Autowired
	private DaoApi mebWalletDao;
	@Autowired
	private DaoApi mebStatsDao;
	@Autowired
	private DaoApi mebGroupDao;
	@Autowired
	private DaoApi mebAccountDao;

	@Autowired
	private ProviderApi groupGrowProvider;

	@Autowired
	private WalletServiceImpl walletService;

	@Autowired
	private CoreParamCache coreParamCache;

	@Autowired
	private BonusServiceImpl bonusService;
*/
	/**
	 * 进入提现页面（本金及红利）
	 * 
	 * @return {canBase, base, base2, bonus, mebAccount{}}
	 */
	public Map<String, Object> toExit() {
		return null;/*
		String mebId = AiContext.getLoginId();

		Map<String, Object> ret = new HashMap<>();
		And and = new And();
		and.add("mebId", mebId);
		and.add("state", Busi.STATE_INIT);
		ret.put("canBase", 0 == bizBonusDao.getRecordsCount(and)); // 是否可提取本金

		Map<String, Object> mebWallet = mebWalletDao.loadRecordById(mebId);
		ret.put("base", mebWallet.get("baseFree")); // 可提取本金
		ret.put("base2", mebWallet.get("baseFreeze")); // 不可提取本金
		ret.put("ratio", coreParamCache.get("exitBaseFeeRatio")); // 本金提取手续费

		int bonus = (int) mebWallet.get("bonusFree");
		ret.put("bonus", bonus); // 可提取红利
		int exitBonusAmountUnit = Integer.valueOf(coreParamCache.get("exitBonusAmountUnit")); // 红利提取单位
		ret.put("bonus2", bonus / exitBonusAmountUnit * exitBonusAmountUnit); // 实际可提取红利

		// 银行卡信息
		Map<String, Object> mebAccount = mebAccountDao.loadRecordById(mebId);
		ret.putAll(mebAccount);

		return ret;
	*/}

	/**
	 * 进入提现页面（团队）
	 * 
	 * @return {canGroup, group, mebAccount{}}
	 */
	public Map<String, Object> toExitGroup() {
		return null;/*
		String mebId = AiContext.getLoginId();
		Map<String, Object> ret = new HashMap<>();

		List<Map<String, Object>> list = mebGroupDao.loadRecords("mebId", mebId);
		if (1 == list.size()) {
			ret.put("canGroup", true);

			int group = (int) list.get(0).get("gorw");
			ret.put("group", group); // 可提取团队
			int exitGroupAmountUnit = Integer.valueOf(coreParamCache.get("exitGroupAmountUnit")); // 团队提取单位
			ret.put("group2", group / exitGroupAmountUnit * exitGroupAmountUnit); // 实际可提取团队

			// 银行卡信息
			Map<String, Object> mebAccount = mebAccountDao.loadRecordById(mebId);
			ret.putAll(mebAccount);

			return ret;
		} else {
			ret.put("canGroup", false);
			return ret;
		}
	*/}

	/**
	 * 创建提取记录主要数据
	 * 
	 * @param mebId
	 * @param amount
	 * @param bankId
	 * @return
	 */
	private Map<String, Object> createExitMap(String mebId, int amount, String bankId) {
		return null;/*
		Map<String, Object> exitMap = new AiMap<Object>();
		exitMap.put("mebId", mebId);
		exitMap.put("amount", amount);
		exitMap.put("state", Busi.STATE_INIT);

		// 提取账户信息
		exitMap.put("mebName", mebInfoDao.loadRecordById(mebId).get("mebName"));
		Map<String, Object> mebAccount = mebAccountDao.loadRecordById(mebId);
		if ("1".equals(bankId)) { // 主卡
			exitMap.put("bankNum", mebAccount.get("bankNum"));
			exitMap.put("depositBank", mebAccount.get("depositBank"));
			exitMap.put("detailBank", mebAccount.get("detailBank"));
		} else { // 备卡
			exitMap.put("bankNum", mebAccount.get("bankNum2"));
			exitMap.put("depositBank", mebAccount.get("depositBank2"));
			exitMap.put("detailBank", mebAccount.get("detailBank2"));
		}
		return exitMap;
	*/}

	/**
	 * 提取本金、全量提取已解冻本金
	 */
	public void exitBase(String bankId) {/*
		Map<String, Object> toExitMap = toExit();

		int baseFree = (int) toExitMap.get("base"); // 已解冻本金
		if (baseFree <= 0) {
			throw new BusiException("无可提取本金");
		}

		boolean canBase = (boolean) toExitMap.get("canBase"); // 是否可提取本金
		if (!canBase) {
			throw new BusiException("分红中，不可提取本金");
		}

		String mebId = AiContext.getLoginId();
		float exitBaseFeeRatio = Float.valueOf(coreParamCache.get("exitBaseFeeRatio")); // 提取本金手续费费率

		Map<String, Object> exitMap = createExitMap(mebId, baseFree, bankId);
		exitMap.put("exitType", Busi.EXIT_TYPE_BASE);
		exitMap.put("feeRate", exitBaseFeeRatio);
		exitMap.put("fee", Math.round(baseFree * exitBaseFeeRatio * 100) / 100); // 手续费
		String rid = exitDao.insertRecordAndReturnPk(exitMap);

		// 更新财务
		Map<String, Number> incValue = new HashMap<String, Number>();
		incValue.put("baseFree", -baseFree);
		incValue.put("baseDrawing", baseFree);
		walletService.inc(mebId, incValue, Busi.WALLET_CHANGE_EXIT, rid);

		// 清除劝退标识
		bonusService.clearNeedExit(mebId);
	*/}

	/**
	 * 提取红利、100的整数倍
	 */
	public ResultBean exitBonus(int amount, String bankId) {
		return null;/*
		ResponseBean rsp = new ResponseBean();
		String mebId = AiContext.getLoginId();
		// 判断金额
		Map<String, Object> walletMap = mebWalletDao.loadRecordById(mebId);
		int canBonus = (int) walletMap.get("bonusFree");
		if (canBonus <= 0 ||
				amount > canBonus || 
				amount % Integer.valueOf(coreParamCache.get("exitBonusAmountUnit")) != 0) 
		{
			log.error("bonus amount bigger than canBonus");
			rsp.setSuccess(false);
			rsp.setMsg("提取金额不符合要求，请确认是否满足提取条件");
			return rsp;
		}

		Map<String, Object> exitMap = createExitMap(mebId, amount, bankId);
		exitMap.put("exitType", Busi.EXIT_TYPE_BONUS);
		String rid = exitDao.insertRecordAndReturnPk(exitMap);

		// 更新财务
		Map<String, Number> incValue = new HashMap<String, Number>();
		incValue.put("bonusFree", -amount);
		incValue.put("bonusDrawing", amount);
		walletService.inc(mebId, incValue, Busi.WALLET_CHANGE_EXIT, rid);

		rsp.setMsg("success");
		rsp.setSuccess(true);
		return rsp;
	*/}

	/**
	 * 提取团队、1000的整数倍
	 */
	public ResultBean exitGroup(int amount, String bankId) {
		return null;/*
		ResponseBean rsp = new ResponseBean();
		String mebId = AiContext.getLoginId();

		int groupId = (int) mebInfoDao.loadRecordById(mebId).get("groupId");

		Map<String, Object> groupMap = mebGroupDao.loadRecordByUnique("mebId", mebId);
		int canBonus = (int) groupMap.get("gorw");
		if (canBonus <= 0 ||
				amount > canBonus || 
				canBonus % Integer.valueOf(coreParamCache.get("exitGroupAmountUnit")) != 0) {
			rsp.setMsg("提取金额不符合要求，请确认是否满足提取条件");
			rsp.setSuccess(false);
			return rsp;
		}

		Map<String, Object> exitMap = createExitMap(mebId, amount, bankId);
		exitMap.put("exitType", Busi.EXIT_TYPE_GROUP);
		exitMap.put("groupId", groupId);
		exitDao.insertRecord(exitMap);

		// 更新团队财务
		Map<String, Number> incValue = new HashMap<String, Number>();
		incValue.put("gorw", -amount);
		incValue.put("gorwDrawing", amount);
		mebGroupDao.incNumberField(String.valueOf(groupId), incValue);

		rsp.setSuccess(true);
		rsp.setMsg("success");
		return rsp;
	*/}

	/**
	 * 提取确认
	 * 
	 * @param rid
	 */
	public void exitConfirm(String rid) {/*
		Map<String, Object> exitMap = exitDao.loadRecordById(rid);
		String state = exitMap.get("state").toString();
		if (state.equals(Busi.STATE_INIT)) {
			Map<String, Object> map = new AiMap<Object>();
			map.put("rid", rid);
			map.put("state", Busi.STATE_FIN);
			map.put("oper", AiContext.getLoginId());
			map.put("operTime", new Date());
			exitDao.updateRecord(map);

			int amount = (int) exitMap.get("amount"); // 提取金额
			String exitType = exitMap.get("exitType").toString();

			// 更新财务
			if (exitType.equals(Busi.EXIT_TYPE_BASE)) {
				walletService.inc(exitMap.get("mebId").toString(), "baseDrawing", -amount, Busi.WALLET_CHANGE_EXIT_CONFIRM, rid);
			} else if (exitType.equals(Busi.EXIT_TYPE_BONUS)) {
				walletService.inc(exitMap.get("mebId").toString(), "bonusDrawing", -amount, Busi.WALLET_CHANGE_EXIT_CONFIRM, rid);
			} else if (exitType.equals(Busi.EXIT_TYPE_GROUP)) {
				mebGroupDao.incNumberField(exitMap.get("groupId").toString(), "gorwDrawing", -amount);
			}

			// 更新统计数据
			if (exitType.equals(Busi.EXIT_TYPE_BASE)) {
				mebStatsDao.incNumberField(exitMap.get("mebId").toString(), "exitBaseTotal", amount);
			} else if (exitType.equals(Busi.EXIT_TYPE_BONUS)) {
				mebStatsDao.incNumberField(exitMap.get("mebId").toString(), "exitBonusTotal", amount);
			} else if (exitType.equals(Busi.EXIT_TYPE_GROUP)) {
				mebStatsDao.incNumberField(exitMap.get("mebId").toString(), "exitGroupTotal", amount);
			}
		}
	*/}

	/**
	 * 提取作废
	 * 
	 * @param rid
	 */
	public void exitCancel(String rid) {/*
		Map<String, Object> exitMap = exitDao.loadRecordById(rid);
		String state = exitMap.get("state").toString();
		if (state.equals(Busi.STATE_INIT)) {
			Map<String, Object> map = new AiMap<Object>();
			map.put("rid", rid);
			map.put("state", Busi.STATE_CANCEL);
			map.put("oper", AiContext.getLoginId());
			map.put("operTime", new Date());
			exitDao.updateRecord(map);

			int amount = (int) exitMap.get("amount"); // 提取金额
			String exitType = exitMap.get("exitType").toString();

			// 更新财务
			Map<String, Number> incValue = new HashMap<String, Number>();
			if (exitType.equals(Busi.EXIT_TYPE_BASE)) {
				incValue.put("baseFree", amount);
				incValue.put("baseDrawing", -amount);
				walletService.inc(exitMap.get("mebId").toString(), incValue, Busi.WALLET_CHANGE_EXIT_CANCEL, rid);
			} else if (exitType.equals(Busi.EXIT_TYPE_BONUS)) {
				incValue.put("bonusFree", amount);
				incValue.put("bonusDrawing", -amount);
				walletService.inc(exitMap.get("mebId").toString(), incValue, Busi.WALLET_CHANGE_EXIT_CANCEL, rid);
			} else if (exitType.equals(Busi.EXIT_TYPE_GROUP)) {
				incValue.put("gorw", amount);
				incValue.put("gorwDrawing", -amount);
				mebGroupDao.incNumberField(exitMap.get("groupId").toString(), incValue);
			}
		}
	*/}

	/**
	 * 提现列表查询
	 * 
	 * @author smart迅
	 * @param type
	 * @return
	 */
	public List<Map<String, Object>> getList(String type) {
		return null;/*
		And and = new And();
		and.add("mebId", AiContext.getLoginId());
		and.add("exitType", type, FieldOper.OPER_IN);
		return exitDao.loadRecords(and);
	*/}

	/**
	 * 团队钱包列表查询
	 * 
	 * @author smart迅
	 * @return
	 */
	public List<Map<String, Object>> groupWalletList() {
		return null;/*
		String mebId = AiContext.getLoginId();
		int groupId = (int) mebInfoDao.loadRecordById(mebId).get("groupId");

		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		// 团队提成表查询
		And and = new And();
		and.add("groupId", groupId);
		List<Map<String, Object>> groupExitList = groupGrowProvider.loadRecords(and);

		// 体现表查询
		List<Map<String, Object>> mebExitList = getList(Busi.EXIT_TYPE_GROUP);

		// 遍历团队提成表
		for (Map<String, Object> groupMap : groupExitList) {
			Map<String, Object> rspMap = new AiMap<Object>();
			rspMap.put("amount", groupMap.get("amount"));
			rspMap.put("name", groupMap.get("Meb_name"));
			rspMap.put("phone", groupMap.get("Meb_phone"));
			rspMap.put("createTime", groupMap.get("create_time"));
			rspMap.put("type", 1); // 团队提成
			rspMap.put("typeMsg", "团队提成");
			resultList.add(rspMap);
		}

		// 遍历提现表
		for (Map<String, Object> groupMap : mebExitList) {
			Map<String, Object> rspMap = new AiMap<Object>();
			rspMap.put("amount", groupMap.get("amount"));
			rspMap.put("createTime", groupMap.get("create_time"));
			rspMap.put("type", 2); // 提现
			rspMap.put("typeMsg", "提现");
			resultList.add(rspMap);
		}
		resultList.sort(new AiComparator("createTime", FieldType.DATE, false));

		return resultList;
	*/}

	@Override
	public ResultBean exit(String mebId, int amount) {
		return null;
		// TODO Auto-generated method stub
	}

}
