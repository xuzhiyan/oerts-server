/**
 * @FileName:		ExamManagementMapper.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月9日 下午11:45:53
 *
 */
package com.njfu.bysj.oerts.mapper;

import java.util.List;

import com.njfu.bysj.oerts.entity.ExamManagementEntity;

/**
 * @ClassName:     	ExamManagementMapper
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月9日 下午11:45:53
 *
 */
public interface ExamManagementMapper {

	List<ExamManagementEntity> getAllExams();
}
