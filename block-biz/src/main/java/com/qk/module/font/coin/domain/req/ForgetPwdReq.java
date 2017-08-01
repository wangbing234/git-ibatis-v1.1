package com.qk.module.font.coin.domain.req;

/**忘记密码请求体
 * @author smart迅
 *
 */
public class ForgetPwdReq
{
	private String phone;

	private String name;
	
	private String authCode;
	
	private String pwd;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
