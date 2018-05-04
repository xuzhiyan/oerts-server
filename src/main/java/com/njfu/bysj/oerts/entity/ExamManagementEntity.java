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
	/** 考试时间段1 */
	private String examTimePeriod1;
	/** 考试时间段2 */
	private String examTimePeriod2;
	/** 考试时间段3 */
	private String examTimePeriod3;
	/** 报名开始时间 */
	private String regTimeFrom;
	/** 报名结束时间 */
	private String regTimeTo;
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
	/** 是否已经录入成绩 */
	private int isEntry;

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
	 * @return the regTimeFrom
	 */
	public String getRegTimeFrom() {
		return regTimeFrom;
	}

	/**
	 * @param regTimeFrom
	 *            the regTimeFrom to set
	 */
	public void setRegTimeFrom(String regTimeFrom) {
		this.regTimeFrom = regTimeFrom;
	}

	/**
	 * @return the regTimeTo
	 */
	public String getRegTimeTo() {
		return regTimeTo;
	}

	/**
	 * @param regTimeTo
	 *            the regTimeTo to set
	 */
	public void setRegTimeTo(String regTimeTo) {
		this.regTimeTo = regTimeTo;
	}

	/**
	 * @return the isEntry
	 */
	public int getIsEntry() {
		return isEntry;
	}

	/**
	 * @param isEntry the isEntry to set
	 */
	public void setIsEntry(int isEntry) {
		this.isEntry = isEntry;
	}
}
