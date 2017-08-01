package com.qk.module.font.coin.domain.enums;

/**
 * 虚拟币类别
 *
 */
public enum CoinType {
	/**
	 * 激活码
	 */
	ACTIVE("1"),
	/**
	 * 排单币
	 */
	GAME("2");

	private String value;

	private CoinType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
