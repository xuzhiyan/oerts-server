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
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamRegistrationService;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName:     	ExamRegistrationController
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月17日 下午10:01:48
 *
 */
@RestController
public class ExamRegistrationController {

	@Autowired
	private ExamRegistrationService examRegistrationService;
	
	@GetMapping("/registration/{examId}/{userPhone}")
	public JsonResult examRegistByIdCardAndExamID(@PathVariable String examId, @PathVariable String userPhone) {
		System.out.println(examId+userPhone);
		return JsonUtil.success(examRegistrationService.examRegistByIdCardAndExamID(examId, userPhone));
	}
}
