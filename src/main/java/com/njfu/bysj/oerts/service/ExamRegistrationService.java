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

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

import com.aliyuncs.exceptions.ClientException;
import com.njfu.bysj.oerts.bean.CompleteRegistExam;
import com.njfu.bysj.oerts.bean.ExamineeRegistInfo;
import com.njfu.bysj.oerts.bean.FtlInfo;
import com.njfu.bysj.oerts.entity.ExamRegistrationEntity;

import freemarker.template.TemplateException;

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
	
	void examOverdue();

	boolean deleteByIdCardAndExamID(ExamRegistrationEntity delete);

	List<CompleteRegistExam> getPayList(String idCard, String status);

	CompleteRegistExam getScoreByAdmissionTicket(String admissionTicket);

	List<ExamineeRegistInfo> getScoreEntryListById(String examId);

	int entryScore(List<ExamineeRegistInfo> scoreInfo, HttpServletRequest request)
			throws IOException, TemplateException;

	boolean updatePayRegistration(CompleteRegistExam payInfo, HttpServletRequest request)
			throws IOException, TemplateException;

	CompleteRegistExam getCompleteResgistInfo(String idCard, String examId);
	
	List<FtlInfo> getExamineeInfoById(String examId);
}
