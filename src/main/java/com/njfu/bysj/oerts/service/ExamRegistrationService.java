/**
 * @FileName:		ExamRegistrationService.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月17日 下午9:57:09
 *
 */
package com.njfu.bysj.oerts.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njfu.bysj.oerts.bean.CompleteRegistExam;
import com.njfu.bysj.oerts.entity.ExamRegistrationEntity;

/**
 * @ClassName: ExamRegistrationService
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月17日 下午9:57:09
 *
 */
public interface ExamRegistrationService {

	boolean examRegistByIdCardAndExamID(String examId, String idCard);

	boolean countByIdCardAndExamID(String examId, String idCard);

	List<CompleteRegistExam> completeResgistList(String idCard);

	void examReview();

	boolean deleteByIdCardAndExamID(ExamRegistrationEntity delete);

	List<CompleteRegistExam> getPayList(String idCard, String status);
	
	CompleteRegistExam getScoreByAdmissionTicket(String admissionTicket);
}
