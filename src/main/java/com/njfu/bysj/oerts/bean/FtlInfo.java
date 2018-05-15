/**
 * @FileName:		FtlInfo.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月15日 下午4:11:51
 *
 */
package com.njfu.bysj.oerts.bean;

import java.io.Serializable;

/**
 * @ClassName: FtlInfo
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月15日 下午4:11:51
 *
 */
public class FtlInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/* 用户照片 */
	private String userPhoto;
	/* 用户身份证号 */
	private String idCard;
	/* 用户姓名 */
	private String userName;
	/** 考试准考证号 */
	private String admissionTicket;
	/** 考试成绩 */
	private int score;
	/** 考场号 */
	private int roomNum;
	/** 座位号 */
	private int setNum;
	/** 考试名称 */
	private String examName;
	/** 考试类型 */
	private String examType;
	/** 考试地点 */
	private String examPlace;
	/** 考试时间段1 */
	private String examTimePeriod1;
	/** 考试时间段2 */
	private String examTimePeriod2;
	/** 考试时间段3 */
	private String examTimePeriod3;
	/** 考试通过分数 */
	private int paseScore;
	/** 考试总分数 */
	private int totalScore;
	/** 是否有证书 */
	private String isCertificate;

	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard
	 *            the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	/**
	 * @return the admissionTicket
	 */
	public String getAdmissionTicket() {
		return admissionTicket;
	}

	/**
	 * @param admissionTicket
	 *            the admissionTicket to set
	 */
	public void setAdmissionTicket(String admissionTicket) {
		this.admissionTicket = admissionTicket;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the roomNum
	 */
	public int getRoomNum() {
		return roomNum;
	}

	/**
	 * @param roomNum
	 *            the roomNum to set
	 */
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	/**
	 * @return the setNum
	 */
	public int getSetNum() {
		return setNum;
	}

	/**
	 * @param setNum
	 *            the setNum to set
	 */
	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}

	/**
	 * @return the examName
	 */
	public String getExamName() {
		return examName;
	}

	/**
	 * @param examName
	 *            the examName to set
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}

	/**
	 * @return the examType
	 */
	public String getExamType() {
		return examType;
	}

	/**
	 * @param examType
	 *            the examType to set
	 */
	public void setExamType(String examType) {
		this.examType = examType;
	}

	/**
	 * @return the examPlace
	 */
	public String getExamPlace() {
		return examPlace;
	}

	/**
	 * @param examPlace
	 *            the examPlace to set
	 */
	public void setExamPlace(String examPlace) {
		this.examPlace = examPlace;
	}

	/**
	 * @return the examTimePeriod1
	 */
	public String getExamTimePeriod1() {
		return examTimePeriod1;
	}

	/**
	 * @param examTimePeriod1
	 *            the examTimePeriod1 to set
	 */
	public void setExamTimePeriod1(String examTimePeriod1) {
		this.examTimePeriod1 = examTimePeriod1;
	}

	/**
	 * @return the examTimePeriod2
	 */
	public String getExamTimePeriod2() {
		return examTimePeriod2;
	}

	/**
	 * @param examTimePeriod2
	 *            the examTimePeriod2 to set
	 */
	public void setExamTimePeriod2(String examTimePeriod2) {
		this.examTimePeriod2 = examTimePeriod2;
	}

	/**
	 * @return the examTimePeriod3
	 */
	public String getExamTimePeriod3() {
		return examTimePeriod3;
	}

	/**
	 * @param examTimePeriod3
	 *            the examTimePeriod3 to set
	 */
	public void setExamTimePeriod3(String examTimePeriod3) {
		this.examTimePeriod3 = examTimePeriod3;
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
	 * @return the paseScore
	 */
	public int getPaseScore() {
		return paseScore;
	}

	/**
	 * @param paseScore the paseScore to set
	 */
	public void setPaseScore(int paseScore) {
		this.paseScore = paseScore;
	}

	/**
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	/**
	 * @return the isCertificate
	 */
	public String getIsCertificate() {
		return isCertificate;
	}

	/**
	 * @param isCertificate the isCertificate to set
	 */
	public void setIsCertificate(String isCertificate) {
		this.isCertificate = isCertificate;
	}

}
