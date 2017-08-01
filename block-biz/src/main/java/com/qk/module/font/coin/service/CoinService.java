package com.qk.module.font.coin.service;

import java.util.List;
import java.util.Map;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.domain.enums.CoinType;

public interface CoinService {

	/**
	 * 虚拟币转移
	 * 
	 * @param fromMebId
	 *            赠送会员id
	 * @param toMebId
	 *            接收会员id
	 * @param amount
	 *            数量
	 * @param coinType
	 *            虚拟币类别
	 * @return
	 */
	ResultBean give(String fromMebId, String toMebId, int amount, CoinType coinType);

	/**
	 * 虚拟币消费
	 * 
	 * @param mebId
	 *            会员id
	 * @param amount
	 *            数量
	 * @param coinType
	 *            虚拟币类别
	 * @return
	 */
	ResultBean use(String mebId, int amount, CoinType coinType);

	/**
	 * 查询虚拟币变更记录
	 * 
	 * @param coinType
	 *            虚拟币类别
	 * @return
	 */
	List<Map<String, Object>> getLog(CoinType coinType);
}
