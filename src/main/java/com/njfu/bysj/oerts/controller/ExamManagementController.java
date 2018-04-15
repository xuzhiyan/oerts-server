/**
 * @FileName:		ExamManagementController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月9日 下午11:41:28
 *
 */
package com.njfu.bysj.oerts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamManagementService;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName:     	ExamManagementController
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月9日 下午11:41:28
 *
 */
@RestController
public class ExamManagementController {

	@Autowired
	private ExamManagementService examManagementService;
	
	@GetMapping("/exams")
	public JsonResult getAllExams() {
		return JsonUtil.success(examManagementService.getAllExams());
	}
	
	@GetMapping("/exam/{examId}")
	public JsonResult getExamById(@PathVariable String examId) {
		return JsonUtil.success(examManagementService.getExamById(examId));
	}
}
