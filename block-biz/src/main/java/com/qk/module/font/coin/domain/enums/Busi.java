package com.qk.module.font.coin.domain.enums;

public class Busi {
	public static final String YES = "1";
	public static final String NO = "0";

	/**
	 * 通用状态：初始
	 */
	public static final String STATE_INIT = "1";
	/**
	 * 通用状态：完成
	 */
	public static final String STATE_FIN = "2";
	/**
	 * 通用状态：取消
	 */
	public static final String STATE_CANCEL = "3";
	/**
	 * 通用状态：解冻
	 */
	public static final String STATE_UNFREEZE = "4";

	// ************************
	/**
	 * 钱包类别：本金
	 */
	public static final String WALLET_TYPE_BASE = "1";
	/**
	 * 钱包类别：红利
	 */
	public static final String WALLET_TYPE_BONUS = "2";
	/**
	 * 钱包类别：提成
	 */
	public static final String WALLET_TYPE_GROW = "3";
	/**
	 * 钱包类别：消费券
	 */
	public static final String WALLET_TYPE_SHOP = "4";
	/**
	 * 钱包类别：排单币
	 */
	public static final String WALLET_TYPE_GAME = "5";
	/**
	 * 钱包类别：激活码
	 */
	public static final String WALLET_TYPE_ACTIVE = "6";
	/**
	 * 钱包类别：税收
	 */
	public static final String WALLET_TYPE_TAX = "7";
	/**
	 * 钱包类别：公益
	 */
	public static final String WALLET_TYPE_PUBLIC = "8";

	// ************************
	/**
	 * 钱包子类别：可用
	 */
	public static final String WALLET_SUB_TYPE_FREE = "1";
	/**
	 * 钱包子类别：冻结
	 */
	public static final String WALLET_SUB_TYPE_FREEZE = "2";
	/**
	 * 钱包子类别：待转入
	 */
	public static final String WALLET_SUB_TYPE_ENTRY = "3";
	/**
	 * 钱包子类别：待转出
	 */
	public static final String WALLET_SUB_TYPE_EXIT = "4";

	// ************************
	/**
	 * 财务变化原因：人工调账
	 */
	public static final String WALLET_CHANGE_MANUAL = "0";
	/**
	 * 财务变化原因：充值（确认）
	 */
	public static final String WALLET_CHANGE_ENTRY = "1";
	/**
	 * 财务变化原因：充值（解冻）
	 */
	public static final String WALLET_CHANGE_ENTRY_UNFREEZE = "1b";
	/**
	 * 财务变化原因：提取（发起）
	 */
	public static final String WALLET_CHANGE_EXIT = "2";
	/**
	 * 财务变化原因：提取（确认）
	 */
	public static final String WALLET_CHANGE_EXIT_CONFIRM = "2b";
	/**
	 * 财务变化原因：提取（作废）
	 */
	public static final String WALLET_CHANGE_EXIT_CANCEL = "2c";
	/**
	 * 财务变化原因：分红（发起）
	 */
	public static final String WALLET_CHANGE_BONUS = "3";
	/**
	 * 财务变化原因：分红（解冻）
	 */
	public static final String WALLET_CHANGE_BONUS_UNFREEZE = "3b";
	/**
	 * 财务变化原因：商城下单
	 */
	public static final String WALLET_CHANGE_ORDER = "16";
	/**
	 * 财务变化原因：商城下单（撤单）
	 */
	public static final String WALLET_CHANGE_ORDER_CANCEL = "17";

	// ************************
	/**
	 * 用户类别：外部用户
	 */
	public static final String MEB_OUTTER = "1";

	// ************************
	/**
	 * 用户状态：正常
	 */
	public static final String MEB_STATE_OK = "1";
	/**
	 * 用户状态：未实名认证
	 */
	public static final String MEB_STATE_UNAUTH = "2";
	/**
	 * 用户状态：未激活
	 */
	public static final String MEB_STATE_UNACTIVE = "3";
	/**
	 * 用户状态：已冻结
	 */
	public static final String MEB_STATE_LOCK = "4";
	/**
	 * 用户状态：已销户
	 */
	public static final String MEB_STATE_CLOSE = "5";

	// ************************
	/**
	 * 用户状态变更原因：注册
	 */
	public static final String MEB_STATE_CHANGE_REG = "1";
	/**
	 * 用户状态变更原因：实名认证
	 */
	public static final String MEB_STATE_CHANGE_AUTH = "2";
	/**
	 * 用户状态变更原因：激活
	 */
	public static final String MEB_STATE_CHANGE_ACTIVE = "3";
	/**
	 * 用户状态变更原因：冻结
	 */
	public static final String MEB_STATE_CHANGE_LOCK = "4";
	/**
	 * 用户状态变更原因：解冻
	 */
	public static final String MEB_STATE_CHANGE_UNLOCK = "5";
	/**
	 * 用户状态变更原因：销户
	 */
	public static final String MEB_STATE_CHANGE_UNREG = "6";

	// ************************
	/**
	 * 提取类别：本金
	 */
	public static final String EXIT_TYPE_BASE = "1";
	/**
	 * 提取类别：红利
	 */
	public static final String EXIT_TYPE_BONUS = "2";
	/**
	 * 提取类别：提成
	 */
	public static final String EXIT_TYPE_GROW = "3";
	/**
	 * 提取类别：团队
	 */
	public static final String EXIT_TYPE_GROUP = "4";

	// ************************
	/**
	 * 虚拟币类别：激活码
	 */
	public static final String COIN_TYPE_ACTIVE = "1";
	/**
	 * 虚拟币类别：排单币
	 */
	public static final String COIN_TYPE_GAME = "2";

	// ************************
	/**
	 * 虚拟币变更类别：系统分配
	 */
	public static final String COIN_TRANS_TYPE_SYS = "1";
	/**
	 * 虚拟币变更类别：会员互赠
	 */
	public static final String COIN_TRANS_TYPE_MEB = "2";
	/**
	 * 虚拟币变更类别：使用
	 */
	public static final String COIN_TRANS_TYPE_USED = "3";
	/**
	 * 虚拟币变更类别：签到奖励
	 */
	public static final String COIN_TRANS_TYPE_SIGN = "4";

	// ************************
	/**
	 * 图片分类命名前缀：实名认证
	 */
	public static final String IMG_TYPE_PRE_AUTH = "/auth/auth_";
	/**
	 * 图片分类命名前缀：实名认证（第二张图）
	 */
	public static final String IMG_TYPE_PRE_AUTH2 = "/auth/auth2_";
	/**
	 * 图片分类命名前缀：充值截图
	 */
	public static final String IMG_TYPE_PRE_ENTRY = "/entry/entry_";

	// ************************
	/**
	 * 短信类型：会员注册
	 */
	public static final String SMS_TYPE_MEMBERREG = "1";
	/**
	 * 短信类型：修改密码
	 */
	public static final String SMS_TYPE_MODIFYPWD = "2";
	/**
	 * 短信类型：会员冻结
	 */
	public static final String SMS_TYPE_FREEZE = "3";
	/**
	 * 短信类型：会员解冻
	 */
	public static final String SMS_TYPE_UNFREEZE = "4";
	/**
	 * 短信类型：通知打款
	 */
	public static final String SMS_TYPE_TOPAY = "5";
	/**
	 * 短信类型：通知收款
	 */
	public static final String SMS_TYPE_TOCONFIRM = "6";
	/**
	 * 短信类型：通知已发货
	 */
	public static final String SMS_TYPE_ORDERPOSTED = "7";
	/**
	 * 短信类型：开单订单确认
	 */
	public static final String SMS_TYPE_OPENORDER_CONFIRM = "8";
	/**
	 * 短信类型：开单订单取消
	 */
	public static final String SMS_TYPE_OPENORDER_CANCEL = "9";
	/**
	 * 短信类型：二次捐赠超时提醒
	 */
	public static final String SMS_TYPE_WARN_TOENTRY = "A";
	/**
	 * 短信类型：付款超时提醒
	 */
	public static final String SMS_TYPE_WARN_TOPAY = "B";

	// ************************
	/**
	 * 推荐人变更原因：人工调整
	 */
	public static final String REFEREE_CHANGE_MANUAL = "1";
	/**
	 * 推荐人变更原因：会员销号
	 */
	public static final String REFEREE_CHANGE_UNREG = "2";
}
