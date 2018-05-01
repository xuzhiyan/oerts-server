/**
 * @FileName:		AdministratorEntity.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月1日 下午5:06:34
 *
 */
package com.njfu.bysj.oerts.entity;

import java.io.Serializable;

/**
 * @ClassName: AdministratorEntity
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月1日 下午5:06:34
 *
 */
public class AdministratorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 管理员登录名 */
	private String accountName;
	/** 管理员登录密码 */
	private String loginPassword;
	/** 管理员名称 */
	private String userName;

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * @param loginPassword
	 *            the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
