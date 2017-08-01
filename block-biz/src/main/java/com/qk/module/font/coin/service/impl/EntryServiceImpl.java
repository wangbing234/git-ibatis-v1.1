package com.qk.module.font.coin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.service.EntryService;

/**
 * 存入服务类
 * 
 * @author smart迅
 */
@Service
public class EntryServiceImpl implements EntryService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

/*	@Autowired
	private DaoApi bizEntryDao;

	@Autowired
	private DaoApi mebWalletDao;
	
	@Autowired
	private DaoApi mebInfoDao;

	@Autowired
	private CoreParamCache coreParamCache;*/

	@Autowired
	private WalletServiceImpl walletService;
	
	@Autowired
	private BonusServiceImpl bonusService;

	/**
	 * 客户存入
	 * 
	 * @author smart迅
	 * @param request
	 * @return
	 */
	@Transactional
	public ResultBean entry(int amount, String pic) {
		return null;/*
		String mebId = AiContext.getLoginId();
		ResultBean rsp = new ResultBean();
		Map<String, Object> saveMoneyEntity = new AiMap<Object>();
		try {
			And and = new And();
			and.add("mebId", mebId);
			and.add("state", 1);
			List<Map<String, Object>> list = bizEntryDao.loadRecords(and);

			int beforeAmount = 0;
			for (Map<String, Object> entryMap : list) {
				beforeAmount += (int) entryMap.get("amount");
			}

			Map<String, Object> mebWallet = mebWalletDao.loadRecordById(mebId);
			beforeAmount += (int) mebWallet.get("baseFree");
			beforeAmount += (int) mebWallet.get("baseFreeze");

			//用户状态校验
			Map<String, Object> mebInfo =  mebInfoDao.loadRecordById(mebId);
			if(!mebInfo.get("meb_state").toString().equals(Busi.MEB_STATE_OK))
			{
				rsp.setSuccess(false);
				rsp.setMsg("用户状态错误，请确认已认证");
				log.error("meb state not 1");
				return rsp;
			}
			
			// 校验金额
			if (amount < 1000 || (amount % 1000) != 0 || beforeAmount + amount > 100000) {
				rsp.setSuccess(false);
				rsp.setMsg("请检查充值金额，充值金额范围[1000，100000] 且为1000的整数倍");
				log.error("input amount error.amount must N*1000");
				return rsp;
			}
			// 校验图片
			pic = pic.replaceFirst("^.*;base64,", ""); // 保留base64编码串
			if (pic.length() > 0) {
				// 保存打款图片
				String shortname = new Date().getTime() + ".jpg";
				saveMoneyEntity.put("pic", shortname);

				String filename = Busi.IMG_TYPE_PRE_ENTRY + shortname;
				String file = AiProperties.getProperty("imgDir") + filename;
				ImageUtils.saveImageByPath(pic, file);
				saveMoneyEntity.put("meb_id", mebId);
				saveMoneyEntity.put("amount", amount);
				saveMoneyEntity.put("state", Busi.STATE_INIT);
				String pk = bizEntryDao.insertRecordAndReturnPk(saveMoneyEntity);
				rsp.setSuccess(true);
				rsp.setMsg("save mponey success");
				rsp.setData(pk);
			} else {
				rsp.setSuccess(false);
				rsp.setMsg("解析打款截图错误");
				log.error("save money error.decode img error ");
			}

		} catch (Exception e) {
			rsp.setSuccess(false);
			rsp.setMsg("内部异常，充值失败请重试 ");
			log.error("save money error" + e.getMessage());
		}
		return rsp;
	*/}
	
	/**
	 * 确认打款
	 * 
	 * @param rid
	 */
	public void entryConfirm(String rid) {/*
		Map<String, Object> bizEntry = bizEntryDao.loadRecordById(rid);
		String state = bizEntry.get("state").toString();
		int amount = (int) bizEntry.get("amount");

		if (state.equals(Busi.STATE_INIT)) {
			Map<String, Object> map = new AiMap<>();
			map.put("rid", rid);
			map.put("state", Busi.STATE_FIN);
			map.put("toUnfreezeTime", DateUtil.offsetDate(new Date(), Integer.parseInt(coreParamCache.get("baseFreezeMonths")), Calendar.MONTH));
//			map.put("toUnfreezeTime", DateUtil.offsetDate(new Date(), Integer.parseInt(coreParamCache.get("baseFreezeMonths")), Calendar.MINUTE));
			map.put("oper", AiContext.getLoginId());
			map.put("operTime", new Date());
			bizEntryDao.updateRecord(map);

			// 更新财务
			Map<String, Number> incValue = new HashMap<String, Number>();
			incValue.put("baseFreeze", amount);
			walletService.inc(bizEntry.get("mebId").toString(), incValue, Busi.WALLET_CHANGE_ENTRY, rid);

			// 触发劝退判定
			bonusService.updateNeedExit(bizEntry.get("mebId").toString());
		}
	*/}

	/**
	 * 定时任务调用
	 * @author smart迅
	 *
	 */
	public void entryUnfreezeJob() 
	{/*
		And and = new And();
		and.add("state",Busi.STATE_FIN);
		and.add("toUnfreezeTime", new Date(), FieldOper.OPER_SMALL_EQUAL_DATETIME);
		bizEntryDao.loadRecords(and).forEach(map -> this.entryUnfreeze(String.valueOf(map.get("rid"))));
	*/}
	/**
	 * 充值解冻
	 * 
	 * @param rid
	 */
	public void entryUnfreeze(String rid) {/*
		Map<String, Object> bizEntry = bizEntryDao.loadRecordById(rid);
		String state = bizEntry.get("state").toString();
		int amount = (int) bizEntry.get("amount");
		if(amount <= 0)
		{
			throw new BusiException("解冻金额大于0");
		}
		if (state.equals(Busi.STATE_FIN)) {
			Map<String, Object> map = new AiMap<>();
			map.put("rid", rid);
			map.put("state", Busi.STATE_UNFREEZE);
			map.put("unfreezeTime", new Date());
			bizEntryDao.updateRecord(map);

			// 更新财务
			Map<String, Number> incValue = new HashMap<String, Number>();
			incValue.put("baseFree", amount);
			incValue.put("baseFreeze", -amount);
			walletService.inc(bizEntry.get("mebId").toString(), incValue, Busi.WALLET_CHANGE_ENTRY_UNFREEZE, rid);
		}
	*/}

	/**
	 * 打款取消
	 * 
	 * @param rid
	 */
	public void entryCancel(String rid) {/*
		Map<String, Object> bizEntry = bizEntryDao.loadRecordById(rid);
		String state = bizEntry.get("state").toString();

		if (state.equals(Busi.STATE_INIT)) {
			Map<String, Object> map = new AiMap<>();
			map.put("rid", rid);
			map.put("state", Busi.STATE_CANCEL);
			map.put("oper", AiContext.getLoginId());
			map.put("operTime", new Date());
			bizEntryDao.updateRecord(map);
		}
	*/}

	@Override
	public ResultBean entry(String mebId, int amount) {
		return null;
		// TODO Auto-generated method stub
	}

}
