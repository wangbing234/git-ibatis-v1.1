package com.qk.module.font.coin.domain.req;

/**
 * 修改密码请求体
 * @author smart迅
 *
 */
public class ChangePwdReq
{
	private String mebId;
	
	private String oldPwd;
	
	private String newPwd;

	public String getOldPwd() {
		return oldPwd;
	}

	
	public String getMebId() {
		return mebId;
	}

	public void setMebId(String mebId) {
		this.mebId = mebId;
	}


	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
}
