/**
 * @FileName:		OnlineQAMapper.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月30日 下午6:36:40
 *
 */
package com.njfu.bysj.oerts.mapper;

import java.util.List;

import com.njfu.bysj.oerts.entity.OnlineQAEntity;

/**
 * @ClassName:     	OnlineQAMapper
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月30日 下午6:36:40
 *
 */
public interface OnlineQAMapper {
	
	List<OnlineQAEntity> getAllQuestion();

	List<OnlineQAEntity> getCommonQuestion();
	
	OnlineQAEntity getQuestionById(String questionId);
	
	int updateClickRateById(OnlineQAEntity update);
}
