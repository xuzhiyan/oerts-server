/**
 * @FileName:		JsonResult.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月14日 上午12:41:29
 *
 */
package com.njfu.bysj.oerts.entity;

import java.io.Serializable;

/**
 * @ClassName: JsonResult
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月14日 上午12:41:29
 *
 */
public class JsonResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/** JSON状态 */
	private String status;
	/** JSON提示信息 */
	private String message;
	/** JSON内容 */
	private Object data;

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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
