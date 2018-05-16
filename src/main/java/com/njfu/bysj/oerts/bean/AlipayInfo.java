/**
 * @FileName:		AlipayInfo.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月16日 下午9:44:39
 *
 */
package com.njfu.bysj.oerts.bean;

import java.io.Serializable;

/**
 * @ClassName: AlipayInfo
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月16日 下午9:44:39
 *
 */
public class AlipayInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户手机号 */
	private String userPhone;
	/** 充值金额 */
	private String rechargeNum;
	/** 二维码请求状态 */
	private String resStatus;
	/** 订单号 */
	private String outTradeNo;
	/** 二维码码串 */
	private String qrCode;

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
	 * @return the rechargeNum
	 */
	public String getRechargeNum() {
		return rechargeNum;
	}

	/**
	 * @param rechargeNum
	 *            the rechargeNum to set
	 */
	public void setRechargeNum(String rechargeNum) {
		this.rechargeNum = rechargeNum;
	}

	/**
	 * @return the resStatus
	 */
	public String getResStatus() {
		return resStatus;
	}

	/**
	 * @param resStatus the resStatus to set
	 */
	public void setResStatus(String resStatus) {
		this.resStatus = resStatus;
	}

	/**
	 * @return the outTradeNo
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * @param outTradeNo the outTradeNo to set
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * @return the qrCode
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * @param qrCode the qrCode to set
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

}
