/**
 * @FileName:		ExamRegistrationServiceImpl.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月17日 下午9:58:33
 *
 */
package com.njfu.bysj.oerts.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njfu.bysj.oerts.bean.CompleteRegistExam;
import com.njfu.bysj.oerts.bean.ExamineeRegistInfo;
import com.njfu.bysj.oerts.entity.ExamManagementEntity;
import com.njfu.bysj.oerts.entity.ExamRegistrationEntity;
import com.njfu.bysj.oerts.mapper.ExamManagementMapper;
import com.njfu.bysj.oerts.mapper.ExamRegistrationMapper;
import com.njfu.bysj.oerts.service.ExamRegistrationService;
import com.njfu.bysj.oerts.utils.OcrUtil;

/**
 * @ClassName: ExamRegistrationServiceImpl
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月17日 下午9:58:33
 *
 */
@Service
public class ExamRegistrationServiceImpl implements ExamRegistrationService {

	@Autowired
	private ExamRegistrationMapper examRegistrationMapper;
	@Autowired
	private ExamManagementMapper examManagementMapper;

	@Override
	public boolean examRegistByIdCardAndExamID(ExamRegistrationEntity regist, HttpServletRequest request) {

		String savePath = request.getSession().getServletContext().getRealPath("images/");
		ExamRegistrationEntity registration = new ExamRegistrationEntity();

		registration.setExamId(regist.getExamId());
		registration.setIdCard(regist.getIdCard());
		registration.setStatus("00");
		registration.setAdmissionTicket("");
		registration.setScore(0);
		registration.setIdCardFront(savePath + regist.getIdCardFront());
		registration.setIdCardBack(savePath + regist.getIdCardBack());

		// 查看已经报名人数
		ExamManagementEntity num = examManagementMapper.getExamById(regist.getExamId());
		int maxNum = num.getMaxNum();
		int regNum = num.getRegistNum();

		if (regNum < maxNum) {
			examRegistrationMapper.examRegistByIdCardAndExamID(registration);
			// 更新报名人数
			num.setRegistNum(regNum + 1);
			examManagementMapper.updateRegNumById(num);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean countByIdCardAndExamID(String examId, String idCard) {
		if (examRegistrationMapper.countByIdCardAndExamID(idCard, examId) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CompleteRegistExam> completeResgistList(String idCard) {
		return examRegistrationMapper.completeResgistList(idCard);
	}

	@Override
	public void examReview() throws JSONException {
		List<ExamineeRegistInfo> reviewEntity = examRegistrationMapper.examReview();
		OcrUtil ocrUtil = new OcrUtil();

		for (ExamineeRegistInfo entities : reviewEntity) {
			ExamRegistrationEntity updateEntity = new ExamRegistrationEntity();
			updateEntity.setExamId(entities.getExamId());
			updateEntity.setIdCard(entities.getIdCard());
			String ocrResult = ocrUtil.OcrIdCard(entities.getIdCardFront(), "front");
			if (ocrResult.equals(entities.getUserName() + entities.getIdCard())) {
				// if 审核成功 status = 10
				updateEntity.setStatus("10");
				examRegistrationMapper.updateReview(updateEntity);
			} else {
				// 审核失败 status = 11
				updateEntity.setStatus("11");
				examRegistrationMapper.updateReview(updateEntity);
			}
		}

	}

	@Override
	public boolean deleteByIdCardAndExamID(ExamRegistrationEntity delete) {
		if (examRegistrationMapper.deleteByIdCardAndExamID(delete) != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CompleteRegistExam> getPayList(String idCard, String status) {
		return examRegistrationMapper.getPayList(idCard, status);
	}

	@Override
	public CompleteRegistExam getScoreByAdmissionTicket(String admissionTicket) {
		return examRegistrationMapper.getScoreByAdmissionTicket(admissionTicket);
	}
}
