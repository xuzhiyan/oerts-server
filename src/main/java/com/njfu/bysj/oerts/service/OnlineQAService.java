/**
 * @FileName:		OnlineQAService.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月30日 下午6:45:52
 *
 */
package com.njfu.bysj.oerts.service;

import java.util.List;

import com.njfu.bysj.oerts.entity.OnlineQAEntity;

/**
 * @ClassName: OnlineQAService
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月30日 下午6:45:52
 *
 */
public interface OnlineQAService {

	List<OnlineQAEntity> getCommonQuestion();

	OnlineQAEntity getAnswerByKey(String question);
}
