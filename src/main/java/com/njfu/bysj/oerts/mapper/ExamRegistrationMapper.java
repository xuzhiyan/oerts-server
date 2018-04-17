/**
 * @FileName:		ExamRegistrationMapper.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月17日 下午9:55:42
 *
 */
package com.njfu.bysj.oerts.mapper;

import org.apache.ibatis.annotations.Param;

import com.njfu.bysj.oerts.entity.ExamRegistrationEntity;

/**
 * @ClassName:     	ExamRegistrationMapper
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月17日 下午9:55:42
 *
 */
public interface ExamRegistrationMapper {

	int examRegistByIdCardAndExamID(ExamRegistrationEntity registration);
	
	int countByIdCardAndExamID(@Param(value = "idCard") String idCard, @Param(value = "examId") String examId);
}
