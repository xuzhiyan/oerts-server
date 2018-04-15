/**
 * @FileName:		ExamineeEntity.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年1月11日 下午11:00:17
 *
 */
package com.njfu.bysj.oerts.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @ClassName:     	ExamineeEntity
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年1月11日 下午11:00:17
 *
 */
public class ExamineeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/* 用户身份证号 */
	private String idCard;
	/* 用户手机号 */
	private String userPhone;
	/* 用户姓名 */
	private String userName;
	/* 用户性别 */
	private int userSex;
	/* 用户职业 */
	private String userProfession;
	/* 登录系统密码 */
	private String loginPassword;
	/* 支付密码 */
	private String payPassword;
	/* 用户照片 */
	private String userPhoto;
	/* 现居住地址 */
	private String residentialAddress;
	/* 电子邮件地址 */
	private String emailAddress;
	/* 用户余额 */
	private String userBalance;
	/* 上次登录时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date lastLogintime;
	
	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userSex
	 */
	public int getUserSex() {
		return userSex;
	}
	/**
	 * @param userSex the userSex to set
	 */
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	/**
	 * @return the userProfession
	 */
	public String getUserProfession() {
		return userProfession;
	}
	/**
	 * @param userProfession the userProfession to set
	 */
	public void setUserProfession(String userProfession) {
		this.userProfession = userProfession;
	}
	/**
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}
	/**
	 * @param loginPassword the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	/**
	 * @return the payPassword
	 */
	public String getPayPassword() {
		return payPassword;
	}
	/**
	 * @param payPassword the payPassword to set
	 */
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	/**
	 * @return the userPhoto
	 */
	public String getUserPhoto() {
		return userPhoto;
	}
	/**
	 * @param userPhoto the userPhoto to set
	 */
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	/**
	 * @return the residentialAddress
	 */
	public String getResidentialAddress() {
		return residentialAddress;
	}
	/**
	 * @param residentialAddress the residentialAddress to set
	 */
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the userBalance
	 */
	public String getUserBalance() {
		return userBalance;
	}
	/**
	 * @param userBalance the userBalance to set
	 */
	public void setUserBalance(String userBalance) {
		this.userBalance = userBalance;
	}
	/**
	 * @return the lastLogintime
	 */
	public Date getLastLogintime() {
		return lastLogintime;
	}
	/**
	 * @param lastLogintime the lastLogintime to set
	 */
	public void setLastLogintime(Date lastLogintime) {
		this.lastLogintime = lastLogintime;
	}
	
}
