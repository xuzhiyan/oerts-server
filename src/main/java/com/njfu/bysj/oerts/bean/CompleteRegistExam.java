/**
 * @FileName:		CompleteRegistExam.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月18日 下午10:14:34
 *
 */
package com.njfu.bysj.oerts.bean;

import java.io.Serializable;

import com.njfu.bysj.oerts.entity.ExamManagementEntity;

/**
 * @ClassName: CompleteRegistExam
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月18日 下午10:14:34
 *
 */
public class CompleteRegistExam extends ExamManagementEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户身份证号 */
	private String idCard;
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