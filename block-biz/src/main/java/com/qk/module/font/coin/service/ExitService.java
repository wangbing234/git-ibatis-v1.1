package com.qk.module.font.coin.service;

import com.qk.core.framework.dto.ResultBean;

public interface ExitService {

	/**
	 * 会员提取<br>
	 * <ol>
	 * <li>会员本金钱包扣减提取金额
	 * <li>币交所：获取“币”交易价格
	 * <li>币交所：从公司账户转入会员账户，“币”数量 = 提取金额 / “币”交易价格
	 * </ol>
	 * 
	 * @param mebId
	 *            会员id
	 * @param amount
	 *            提取金额
	 * @return
	 */
	ResultBean exit(String mebId, int amount);

}
