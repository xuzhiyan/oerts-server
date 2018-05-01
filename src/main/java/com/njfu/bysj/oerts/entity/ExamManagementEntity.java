/**
 * @FileName:		ExamManagementEntity.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月9日 下午11:35:19
 *
 */
package com.njfu.bysj.oerts.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @ClassName: ExamManagementEntity
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月9日 下午11:35:19
 *
 */
public class ExamManagementEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 考试编号 */
	private String examId;
	/** 考试名称 */
	private String examName;
	/** 报名费用 */
	private int cost;
	/** 上限人数 */
	private int maxNum;
	/** 考试地点 */
	private String examPlace;
	/** 考试开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date examTimeFrom;
	/** 考试结束时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date examTimeTo;
	/** 报名开始时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date regTimeFrom;
	/** 报名结束时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date regTimeTo;
	/** 考试介绍 */
	private String examIntroduce;
	/** 已报名人数 */
	private int registNum;
	/** 考试通过分数 */
	private int paseScore;
	/** 考试总分数 */
	private int totalScore;
	/** 是否有证书 */
	private String isCertificate;

	/**
	 * @return the examId
	 */
	public String getExamId() {
		return examId;
	}

	/**
	 * @param examId
	 *            the examId to set
	 */
	public void setExamId(String examId) {
		this.examId = examId;
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
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the maxNum
	 */
	public int getMaxNum() {
		return maxNum;
	}

	/**
	 * @param maxNum
	 *            the maxNum to set
	 */
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
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
	 * @return the examTimeFrom
	 */
	public Date getExamTimeFrom() {
		return examTimeFrom;
	}

	/**
	 * @param examTimeFrom
	 *            the examTimeFrom to set
	 */
	public void setExamTimeFrom(Date examTimeFrom) {
		this.examTimeFrom = examTimeFrom;
	}

	/**
	 * @return the examTimeTo
	 */
	public Date getExamTimeTo() {
		return examTimeTo;
	}

	/**
	 * @param examTimeTo
	 *            the examTimeTo to set
	 */
	public void setExamTimeTo(Date examTimeTo) {
		this.examTimeTo = examTimeTo;
	}

	/**
	 * @return the regTimeFrom
	 */
	public Date getRegTimeFrom() {
		return regTimeFrom;
	}

	/**
	 * @param regTimeFrom
	 *            the regTimeFrom to set
	 */
	public void setRegTimeFrom(Date regTimeFrom) {
		this.regTimeFrom = regTimeFrom;
	}

	/**
	 * @return the regTimeTo
	 */
	public Date getRegTimeTo() {
		return regTimeTo;
	}

	/**
	 * @param regTimeTo
	 *            the regTimeTo to set
	 */
	public void setRegTimeTo(Date regTimeTo) {
		this.regTimeTo = regTimeTo;
	}

	/**
	 * @return the examIntroduce
	 */
	public String getExamIntroduce() {
		return examIntroduce;
	}

	/**
	 * @param examIntroduce
	 *            the examIntroduce to set
	 */
	public void setExamIntroduce(String examIntroduce) {
		this.examIntroduce = examIntroduce;
	}

	/**
	 * @return the registNum
	 */
	public int getRegistNum() {
		return registNum;
	}

	/**
	 * @param registNum
	 *            the registNum to set
	 */
	public void setRegistNum(int registNum) {
		this.registNum = registNum;
	}

	/**
	 * @return the paseScore
	 */
	public int getPaseScore() {
		return paseScore;
	}

	/**
	 * @param paseScore
	 *            the paseScore to set
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
	 * @param totalScore
	 *            the totalScore to set
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
	 * @param isCertificate
	 *            the isCertificate to set
	 */
	public void setIsCertificate(String isCertificate) {
		this.isCertificate = isCertificate;
	}
}
