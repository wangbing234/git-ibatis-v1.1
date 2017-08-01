package com.qk.module.font.coin.service;

import com.qk.core.framework.dto.ResultBean;

public interface BonusService {

	/**
	 * 开始分红<br>
	 * <ol>
	 * <li>会员本金钱包充值金额变为“冻结状态”
	 * <li>生成分红记录，包括：状态、预计完成时间等
	 * </ol>
	 * 
	 * @param mebId
	 *            会员id
	 * @param amount
	 *            充值金额
	 * @return
	 */
	ResultBean bonus(String mebId, int amount);

	/**
	 * 分红结算<br>
	 * <ol>
	 * <li>读取“分红利率”参数，计算利率
	 * <li>计算红利（静态收益）、上级提成（动态收益）
	 * <li>变更分红记录状态，生成分红收益记录
	 * <li>会员本金钱包充值金额变为“可用状态”
	 * <li>币交所：获取“币”交易价格
	 * <li>币交所：从公司账户转入会员账户，“币”数量 = 利息 / “币”交易价格
	 * </ol>
	 * 
	 * @param bonusId
	 *            分红记录id
	 * @return
	 */
	ResultBean bonusFinish(String bonusId);
}
