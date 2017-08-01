package com.qk.module.font.coin.domain.req;

public class HistoryQueryReq 
{
	/**
	 * action 等于 out 表示查转出
	 * action 等于 in  表示查转入
	 */
	private String action;
	
	/**
	 * 查询页数
	 */
	private String page;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	
	
}
