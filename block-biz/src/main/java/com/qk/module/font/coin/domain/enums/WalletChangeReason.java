package com.qk.module.font.coin.domain.enums;

/**
 * 财务变化原因
 *
 */
public enum WalletChangeReason {
	/**
	 * 人工调账
	 */
	MANUAL("0"),
	/**
	 * 充值（确认）
	 */
	ENTRY("1"),
	/**
	 * 充值（解冻）
	 */
	ENTRY_UNFREEZE("1b"),
	/**
	 * 提取（发起）
	 */
	EXIT("2"),
	/**
	 * 提取（确认）
	 */
	EXIT_CONFIRM("2b"),
	/**
	 * 提取（作废）
	 */
	EXIT_CANCEL("2c"),
	/**
	 * 分红（发起）
	 */
	BONUS("3"),
	/**
	 * 分红（解冻）
	 */
	BONUS_UNFREEZE("3b"),
	/**
	 * 商城下单
	 */
	ORDER("16"),
	/**
	 * 商城下单（撤单）
	 */
	ORDER_CANCEL("17");

	private String value;

	private WalletChangeReason(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
