package com.qk.module.font.coin.service;

import com.qk.core.framework.dto.ResultBean;

public interface EntryService {

	/**
	 * 会员充值<br>
	 * <ol>
	 * <li>币交所：获取“币”交易价格
	 * <li>币交所：从会员账户转入公司账户，“币”数量 = 充值金额 / “币”交易价格
	 * <li>会员本金钱包增加充值金额
	 * </ol>
	 * 
	 * @param mebId
	 *            会员id
	 * @param amount
	 *            充值金额
	 * @return
	 */
	ResultBean entry(String mebId, int amount);

}
