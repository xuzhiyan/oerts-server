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

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;
import com.njfu.bysj.oerts.bean.CompleteRegistExam;
import com.njfu.bysj.oerts.bean.ExamineeRegistInfo;
import com.njfu.bysj.oerts.entity.ExamManagementEntity;
import com.njfu.bysj.oerts.entity.ExamRegistrationEntity;
import com.njfu.bysj.oerts.entity.ExamineeEntity;
import com.njfu.bysj.oerts.mapper.ExamManagementMapper;
import com.njfu.bysj.oerts.mapper.ExamRegistrationMapper;
import com.njfu.bysj.oerts.mapper.ExamineeMapper;
import com.njfu.bysj.oerts.service.ExamRegistrationService;
import com.njfu.bysj.oerts.utils.FmUtil;
import com.njfu.bysj.oerts.utils.OcrUtil;
import com.njfu.bysj.oerts.utils.RasUtil;
import com.njfu.bysj.oerts.utils.SmsUtil;

import freemarker.template.TemplateException;

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
	@Autowired
	private ExamineeMapper examineeMapper;

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

		if (num.getRegistNum() < num.getMaxNum()) {
			// 报名、更新表
			examRegistrationMapper.examRegistByIdCardAndExamID(registration);
			// 报名人数增加
			examManagementMapper.updateRegNumPlusById(regist.getExamId());
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
	public void examReview() throws JSONException, ClientException {
		List<ExamineeRegistInfo> reviewEntity = examRegistrationMapper.examReview();
		OcrUtil ocrUtil = new OcrUtil();

		for (ExamineeRegistInfo entities : reviewEntity) {
			ExamRegistrationEntity updateEntity = new ExamRegistrationEntity();
			updateEntity.setExamId(entities.getExamId());
			updateEntity.setIdCard(entities.getIdCard());
			String ocrResult = ocrUtil.OcrIdCard(entities.getIdCardFront(), "front");
			String examName = examManagementMapper.getExamById(entities.getExamId()).getExamName();
			if (ocrResult.equals(entities.getUserName() + entities.getIdCard())) {
				// if 审核成功 status = 10
				updateEntity.setStatus("10");
				examRegistrationMapper.updateReview(updateEntity);
				// 发送审核情况短信
				SmsUtil.sendSms(entities.getUserPhone(), "SMS_134324277",
						"{\"name\":\"" + examName + "\" , \"status\":\"审核通过\"}");
			} else {
				// 审核失败 status = 11
				updateEntity.setStatus("11");
				examRegistrationMapper.updateReview(updateEntity);
				// Exam的报名人数信息减少
				examManagementMapper.updateRegNumMinusById(entities.getExamId());
				// 发送审核情况短信
				SmsUtil.sendSms(entities.getUserPhone(), "SMS_134324277",
						"{\"name\":\"" + examName + "\" , \"status\":\"审核未通过\"}");
			}
		}

	}

	@Override
	public boolean deleteByIdCardAndExamID(ExamRegistrationEntity delete) {
		if (examRegistrationMapper.deleteByIdCardAndExamID(delete) != 0) {
			if (delete.getStatus().equals("00")) {
				// Exam的报名人数信息减少
				examManagementMapper.updateRegNumMinusById(delete.getExamId());
			}
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

	@Override
	public List<ExamineeRegistInfo> getScoreEntryListById(String examId) {
		return examRegistrationMapper.getScoreEntryListById(examId);
	}

	@Override
	public int entryScore(List<ExamineeRegistInfo> scoreInfo, HttpServletRequest request)
			throws IOException, TemplateException {
		int result = examRegistrationMapper.entryScore(scoreInfo);
		// 获取更新的哪个考试 说明这个考试的成绩已经提交
		String examId = scoreInfo.get(0).getExamId();
		// set isEntry = 1
		examManagementMapper.updateIsEntryById(examId);

		// 在录入考试成绩后生成考试报表
		FmUtil fmUtil = new FmUtil();
		int paseNum = examRegistrationMapper.getPaseNumById(examId);
		String savePath = request.getSession().getServletContext().getRealPath("exam/") + examId + "\\report\\";
		fmUtil.createExamReport(savePath, examManagementMapper.getExamById(examId), examRegistrationMapper.getScoreEntryListById(examId), paseNum);
		return result;
	}

	@Override
	public boolean updatePayRegistration(CompleteRegistExam payInfo, HttpServletRequest request)
			throws IOException, TemplateException {
		// 更新考生表中的余额
		int cost = payInfo.getCost();

		ExamineeEntity userInfo = examineeMapper.getByIdCard(payInfo.getIdCard());
		int balance = userInfo.getUserBalance();
		String userPhone = userInfo.getUserPhone();

		userInfo.setUserBalance(balance - cost);

		examineeMapper.updateUserBalance(userInfo);

		// 更新报名表中的状态和生成准考证
		ExamRegistrationEntity update = new ExamRegistrationEntity();
		update.setAdmissionTicket(payInfo.getExamId() + payInfo.getIdCard() + userPhone.substring(7, 11));
		update.setExamId(payInfo.getExamId());
		update.setIdCard(payInfo.getIdCard());

		// 生成座位号
		RasUtil rasUtil = new RasUtil();
		int[] res = rasUtil.createRoomAndSeat(examRegistrationMapper.getRASInfo(payInfo.getExamId()));
		update.setRoomNum(res[0]);
		update.setSetNum(res[1]);
		examRegistrationMapper.updatePayExam(update);

		// 生成准考证对应的下载文件.html
		FmUtil fmUtil = new FmUtil();
		String savePath = request.getSession().getServletContext().getRealPath("exam/") + payInfo.getExamId() + "\\admissionTicket\\";
		fmUtil.createAdmissionTicket(savePath,
				examRegistrationMapper.getAdmissionTicketInfo(payInfo.getIdCard(), payInfo.getExamId()));
		return true;
	}

	@Override
	public CompleteRegistExam getCompleteResgistInfo(String idCard, String examId) {
		return examRegistrationMapper.getCompleteResgistInfo(idCard, examId);
	}
}
