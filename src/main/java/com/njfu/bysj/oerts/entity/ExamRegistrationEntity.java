/**
 * @FileName:		ExamRegistrationEntity.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月17日 下午9:05:41
 *
 */
package com.njfu.bysj.oerts.entity;

import java.io.Serializable;

/**
 * @ClassName: ExamRegistrationEntity
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月17日 下午9:05:41
 *
 */
public class ExamRegistrationEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户身份证号 */
	private String idCard;
	/** 考试编号 */
	private String examId;
	/** 考试准考证号 */
	private String admissionTicket;
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
}