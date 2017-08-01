package com.qk.module.font.coin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.domain.enums.CoinType;
import com.qk.module.font.coin.service.CoinService;
import com.qk.module.font.common.exception.BusiException;

/**
 * 排单币服务类
 * 
 * @author bing.wang
 *
 */
@Service
public class CoinServiceImpl implements InitializingBean,CoinService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

/*	@Autowired
	private DaoApi bizCoinTransDao;

	@Autowired
	private DaoApi mebWalletDao;

	@Autowired
	private CoreParamCache coreParamCache;*/

	@Override
	public void afterPropertiesSet() throws Exception {/*
		super.setDaoApi(bizCoinTransDao);
	*/}

	@Transactional
	public boolean save(Map<String, Object> map) throws BusiException {
		return false;/*
		int transCount = Integer.parseInt(map.get("transCount").toString());
		String coinType = map.get("coinType").toString();

		DaoApi mebInfoDao = (DaoApi) AiContext.getBean("mebInfoDao");
		And and = new And();
		and.add("mebPhone", map.get("mebPhone"));
		and.add("mebName", map.get("mebName"));
		List<Map<String, Object>> mebInfoList = mebInfoDao.loadRecords(and);
		if (mebInfoList.size() == 1) {
			String receiverId = mebInfoList.get(0).get("mebId").toString();

			map.put("createTime", new Date());
			map.put("transCount", transCount);
			map.put("sender", 0);
			map.put("receiver", receiverId);
			map.put("transType", Busi.COIN_TRANS_TYPE_SYS);
			map.put("transOper", AiContext.getLoginId());
			map.put("coinType", coinType);

			// 更新会员财务表
			DaoApi mebWalletDao = (DaoApi) AiContext.getBean("mebWalletDao");
			if (coinType.equals(Busi.COIN_TYPE_ACTIVE)) {
				mebWalletDao.incNumberField(receiverId, "activeCoin", transCount);
			} else {
				mebWalletDao.incNumberField(receiverId, "gameCoin", transCount);
			}

			return super.save(map);
		} else {
			throw new BusiException("无效会员信息");
		}
	*/}

	/**
	 * @author smart迅 赠送排单币
	 * @param params
	 * @return
	 */
	@Transactional
	public synchronized void gameCoinUse(String memId, int amount) {/*
		int gameCoin = calGame(amount);

		// 扣减排单币
		mebWalletDao.incNumberField(memId, "gameCoin", gameCoin * -1);

		// 插入虚拟币交易表
		Map<String, Object> mebCoin = new AiMap<Object>();
		mebCoin.put("createTime", new Date());
		mebCoin.put("transCount", gameCoin);
		mebCoin.put("sender", memId);
		mebCoin.put("receiver", null);
		mebCoin.put("transType", Busi.COIN_TRANS_TYPE_USED); // 使用
		mebCoin.put("transOper", null);
		mebCoin.put("coinType", Busi.COIN_TYPE_GAME); // 排单币
		this.getDaoApi().insertRecord(mebCoin);
	*/}

	/**
	 * 计算所需排单币
	 * 
	 * @param amount
	 * @return
	 */
	public int calGame(int amount) {
		return amount;/*
		int gameCoinUnit = Integer.parseInt(coreParamCache.get("gameCoinUnit"));
		return amount / gameCoinUnit;
	*/}

	@Override
	public ResultBean give(String fromMebId, String toMebId, int amount, CoinType coinType) {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public ResultBean use(String mebId, int amount, CoinType coinType) {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Map<String, Object>> getLog(CoinType coinType) {
		return null;
		// TODO Auto-generated method stub
	}

}
