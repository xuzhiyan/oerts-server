/**
 * @FileName:		ExamRegistrationController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月17日 下午10:01:48
 *
 */
package com.njfu.bysj.oerts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.bean.CompleteRegistExam;
import com.njfu.bysj.oerts.bean.ExamineeRegistInfo;
import com.njfu.bysj.oerts.entity.ExamRegistrationEntity;
import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamRegistrationService;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName: ExamRegistrationController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月17日 下午10:01:48
 *
 */
@RestController
public class ExamRegistrationController {

	@Autowired
	private ExamRegistrationService examRegistrationService;

	@PostMapping("/exam/registration/regist")
	public JsonResult examRegistByIdCardAndExamID(@RequestBody ExamRegistrationEntity regist,
			HttpServletRequest request) {
		if (examRegistrationService.examRegistByIdCardAndExamID(regist, request)) {
			return JsonUtil.success();
		} else {
			return JsonUtil.failed("报名失败");
		}
	}

	@GetMapping("/countregist/{examId}/{idCard}")
	public JsonResult countByIdCardAndExamID(@PathVariable String examId, @PathVariable String idCard) {
		if (examRegistrationService.countByIdCardAndExamID(examId, idCard)) {
			return JsonUtil.success();
		} else {
			return JsonUtil.failed("不能重复报名");
		}
	}

	@GetMapping("/testcompletelist/{idCard}")
	public JsonResult completeResgistList(@PathVariable String idCard) {
		return JsonUtil.success(examRegistrationService.completeResgistList(idCard));
	}

	@GetMapping("/registration/payList/{idCard}/{status}")
	public JsonResult getPayList(@PathVariable String idCard, @PathVariable String status) {
		return JsonUtil.success(examRegistrationService.getPayList(idCard, status));
	}

	@PostMapping("/registration/delete")
	public JsonResult deleteByIdCardAndExamID(@RequestBody ExamRegistrationEntity delete) {
		if (examRegistrationService.deleteByIdCardAndExamID(delete)) {
			return JsonUtil.success();
		} else {
			return JsonUtil.failed("删除失败");
		}
	}

	@GetMapping("/registration/score/{admissionTicket}")
	public JsonResult getScoreByAdmissionTicket(@PathVariable String admissionTicket) {
		CompleteRegistExam scoreEntity = examRegistrationService.getScoreByAdmissionTicket(admissionTicket);
		if (scoreEntity == null) {
			return JsonUtil.failed("没有对应数据");
		} else {
			return JsonUtil.success(scoreEntity);
		}
	}

	@GetMapping("/registration/score/list/{examId}")
	public JsonResult getScoreEntryListById(@PathVariable String examId) {
		return JsonUtil.success(examRegistrationService.getScoreEntryListById(examId));
	}

	@PostMapping("/registration/score/entry")
	public JsonResult entryScore(@RequestBody List<ExamineeRegistInfo> scoreInfo) {
		return JsonUtil.success(examRegistrationService.entryScore(scoreInfo));
	}
	
	@PostMapping("/registration/pay/update")
	public JsonResult updatePayRegistration(@RequestBody CompleteRegistExam payInfo) {
		examRegistrationService.updatePayRegistration(payInfo);
		return JsonUtil.success();
	}
	
	@GetMapping("/registration/info/{idCard}/{examId}")
	public JsonResult getCompleteResgistInfo(@PathVariable String idCard, @PathVariable String examId) {
		return JsonUtil.success(examRegistrationService.getCompleteResgistInfo(idCard, examId));
	}
}
