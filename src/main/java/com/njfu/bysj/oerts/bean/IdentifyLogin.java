/**
 * @FileName:		IdentifyLogin.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月3日 下午5:35:11
 *
 */
package com.njfu.bysj.oerts.bean;

import java.io.Serializable;

/**
 * @ClassName: IdentifyLogin
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月3日 下午5:35:11
 *
 */
public class IdentifyLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 手机号 */
	private String userPhone;
	/** 验证码 */
	private String code;

	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * @param userPhone
	 *            the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
