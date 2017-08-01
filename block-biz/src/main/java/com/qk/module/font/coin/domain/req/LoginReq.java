package com.qk.module.font.coin.domain.req;

public class LoginReq 
{
	private String account;
	
	private String password;
	
	private String gauth;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGauth() {
		return gauth;
	}

	public void setGauth(String gauth) {
		this.gauth = gauth;
	}
	
}
