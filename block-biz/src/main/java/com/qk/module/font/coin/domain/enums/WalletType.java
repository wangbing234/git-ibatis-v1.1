package com.qk.module.font.coin.domain.enums;

/**
 * 钱包类别
 *
 */
public enum WalletType {
	/**
	 * 本金
	 */
	BASE("1"),
	/**
	 * 红利
	 */
	BONUS("2"),
	/**
	 * 提成
	 */
	GROW("3"),
	/**
	 * 消费券
	 */
	SHOP("4"),
	/**
	 * 排单币
	 */
	GAME("5"),
	/**
	 * 激活码
	 */
	ACTIVE("6");

	private String value;

	private WalletType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
