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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/registration/{examId}/{idCard}")
	public JsonResult examRegistByIdCardAndExamID(@PathVariable String examId, @PathVariable String idCard) {
		if (examRegistrationService.examRegistByIdCardAndExamID(examId, idCard)) {
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
}
