/**
 * @FileName:		OnlineQAServiceImpl.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月30日 下午6:49:16
 *
 */
package com.njfu.bysj.oerts.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njfu.bysj.oerts.entity.OnlineQAEntity;
import com.njfu.bysj.oerts.mapper.OnlineQAMapper;
import com.njfu.bysj.oerts.service.OnlineQAService;

/**
 * @ClassName: OnlineQAServiceImpl
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月30日 下午6:49:16
 *
 */
@Service
public class OnlineQAServiceImpl implements OnlineQAService {

	@Autowired
	private OnlineQAMapper onlineQAMapper;

	@Override
	public List<OnlineQAEntity> getCommonQuestion() {
		return onlineQAMapper.getCommonQuestion();
	}

	@Override
	public OnlineQAEntity getAnswerByKey(String question) {
		List<OnlineQAEntity> allQuestion =  onlineQAMapper.getAllQuestion();
		OnlineQAEntity result = new OnlineQAEntity();
		for(OnlineQAEntity entities: allQuestion) {
			String[] keys = entities.getQuestionKey().split(";");
			for(String key: keys) {
				if (question.contains(key)) {
					result.setQuestionId(entities.getQuestionId());
					result.setQuestionContent(entities.getQuestionContent());
					result.setQuestionAnswer(entities.getQuestionAnswer());
					
					// 更新热度
					OnlineQAEntity updateEntity = new OnlineQAEntity();
					updateEntity.setQuestionId(entities.getQuestionId());
					updateEntity.setQuestionClickRate(entities.getQuestionClickRate() + 1);
					onlineQAMapper.updateClickRateById(updateEntity);
				}
			}
		}
		return result;
	}

}
