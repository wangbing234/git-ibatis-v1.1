package com.qk.module.font.coin.service;

import java.util.List;
import java.util.Map;

import com.qk.core.framework.dto.ResultBean;
import com.qk.module.font.coin.domain.enums.WalletChangeReason;
import com.qk.module.font.coin.domain.enums.WalletSubType;
import com.qk.module.font.coin.domain.enums.WalletType;

public interface WalletService {

	/**
	 * 变更钱包数值
	 * 
	 * @param mebId
	 *            会员id
	 * @param walletName
	 *            钱包名
	 * @param incValue
	 *            变更值
	 * @param changeReason
	 *            变更原因
	 * @param changeId
	 *            关联记录id
	 * @return
	 */
	ResultBean inc(String mebId, String walletName, int incValue, WalletChangeReason changeReason, String changeId);

	/**
	 * 变更钱包数值（多个变更）
	 * 
	 * @param mebId
	 *            会员id
	 * @param incValueMap
	 *            {钱包名, 变更值}
	 * @param changeReason
	 *            变更原因
	 * @param changeId
	 *            关联记录id
	 * @return
	 */
	ResultBean inc(String mebId, Map<String, Integer> incValueMap, WalletChangeReason changeReason, String changeId);

	/**
	 * 变更钱包数值（人工操作）
	 * 
	 * @param mebId
	 *            会员id
	 * @param walletType
	 *            钱包类别
	 * @param walletSubType
	 *            钱包子类别
	 * @param value
	 *            变更值
	 * @param remark
	 *            备注
	 * @return
	 */
	ResultBean inc(String mebId, WalletType walletType, WalletSubType walletSubType, int value, String remark);

	/**
	 * 查询钱包变更记录
	 * 
	 * @param walletType
	 *            钱包类别
	 * @param walletSubType
	 *            钱包子类别
	 * @return
	 */
	List<Map<String, Object>> getLog(WalletType walletType, WalletSubType walletSubType);
}
