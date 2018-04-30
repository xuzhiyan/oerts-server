/**
 * @FileName:		OnlineQAEntity.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月30日 下午6:31:06
 *
 */
package com.njfu.bysj.oerts.entity;

import java.io.Serializable;

/**
 * @ClassName: OnlineQAEntity
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月30日 下午6:31:06
 *
 */
public class OnlineQAEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 问题编号 */
	private String questionId;
	/** 问题内容 */
	private String questionContent;
	/** 问题回答 */
	private String questionAnswer;
	/** 问题关键字 */
	private String questionKey;
	/** 问题点击量 */
	private int questionClickRate;

	/**
	 * @return the questionId
	 */
	public String getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId
	 *            the questionId to set
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the questionContent
	 */
	public String getQuestionContent() {
		return questionContent;
	}

	/**
	 * @param questionContent
	 *            the questionContent to set
	 */
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	/**
	 * @return the questionAnswer
	 */
	public String getQuestionAnswer() {
		return questionAnswer;
	}

	/**
	 * @param questionAnswer
	 *            the questionAnswer to set
	 */
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	/**
	 * @return the questionKey
	 */
	public String getQuestionKey() {
		return questionKey;
	}

	/**
	 * @param questionKey
	 *            the questionKey to set
	 */
	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}

	/**
	 * @return the questionClickRate
	 */
	public int getQuestionClickRate() {
		return questionClickRate;
	}

	/**
	 * @param questionClickRate
	 *            the questionClickRate to set
	 */
	public void setQuestionClickRate(int questionClickRate) {
		this.questionClickRate = questionClickRate;
	}

}
