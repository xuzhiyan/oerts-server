/**
 * @FileName:		ExamineeRegistInfo.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月29日 上午12:17:46
 *
 */
package com.njfu.bysj.oerts.bean;

import java.io.Serializable;

import com.njfu.bysj.oerts.entity.ExamineeEntity;

/**
 * @ClassName: ExamineeRegistInfo
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月29日 上午12:17:46
 *
 */
public class ExamineeRegistInfo extends ExamineeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户身份证号 */
	private String idCard;
	/** 考试编号 */
	private String examId;
	/** 考试准考证号 */
	private String admissionTicket;
	/** 身份证正面(有照片的一面) */
	private String idCardFront;
	/** 身份证反面(有国徽的一面) */
	private String idCardBack;
	/** 报名状态 */
	private String status;
	/** 考试成绩 */
	private int score;

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
	 * @return the idCardFront
	 */
	public String getIdCardFront() {
		return idCardFront;
	}

	/**
	 * @param idCardFront
	 *            the idCardFront to set
	 */
	public void setIdCardFront(String idCardFront) {
		this.idCardFront = idCardFront;
	}

	/**
	 * @return the idCardBack
	 */
	public String getIdCardBack() {
		return idCardBack;
	}

	/**
	 * @param idCardBack
	 *            the idCardBack to set
	 */
	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the examId
	 */
	public String getExamId() {
		return examId;
	}

	/**
	 * @param examId the examId to set
	 */
	public void setExamId(String examId) {
		this.examId = examId;
	}

}
