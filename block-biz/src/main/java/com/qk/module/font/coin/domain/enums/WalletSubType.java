package com.qk.module.font.coin.domain.enums;

/**
 * 钱包子类别
 *
 */
public enum WalletSubType {
	/**
	 * 可用
	 */
	FREE("1"),
	/**
	 * 冻结
	 */
	FREEZE("2"),
	/**
	 * 待转入
	 */
	ENTRY("3"),
	/**
	 * 待转出
	 */
	EXIT("4");

	private String value;

	private WalletSubType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
