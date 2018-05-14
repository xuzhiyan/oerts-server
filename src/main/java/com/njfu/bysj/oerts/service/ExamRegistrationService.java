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

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.json.JSONException;

import com.aliyuncs.exceptions.ClientException;
import com.njfu.bysj.oerts.bean.CompleteRegistExam;
import com.njfu.bysj.oerts.bean.ExamineeRegistInfo;
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

	boolean examRegistByIdCardAndExamID(ExamRegistrationEntity regist, HttpServletRequest request);

	boolean countByIdCardAndExamID(String examId, String idCard);

	List<CompleteRegistExam> completeResgistList(String idCard);

	void examReview() throws JSONException, ClientException;

	boolean deleteByIdCardAndExamID(ExamRegistrationEntity delete);

	List<CompleteRegistExam> getPayList(String idCard, String status);

	CompleteRegistExam getScoreByAdmissionTicket(String admissionTicket);

	List<ExamineeRegistInfo> getScoreEntryListById(String examId);

	int entryScore(List<ExamineeRegistInfo> scoreInfo);

	boolean updatePayRegistration(CompleteRegistExam payInfo, HttpServletRequest request);

	CompleteRegistExam getCompleteResgistInfo(String idCard, String examId);
}
