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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.exceptions.ClientException;
import com.njfu.bysj.oerts.entity.ExamManagementEntity;
import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamManagementService;
import com.njfu.bysj.oerts.utils.JsonUtil;
import com.njfu.bysj.oerts.utils.SmsUtil;

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
	
	@GetMapping("/exam/info/all")
	public JsonResult getAllExams() {
		return JsonUtil.success(examManagementService.getAllExams());
	}
	
	@GetMapping("/exam/info/id/{examId}")
	public JsonResult getExamById(@PathVariable String examId) {
		return JsonUtil.success(examManagementService.getExamById(examId));
	}
	
	@PostMapping("/exam/info/add")
	public JsonResult addExam(@RequestBody ExamManagementEntity add) {
		if (examManagementService.addExam(add)) {
			return JsonUtil.success();
		}
		return JsonUtil.failed("录入考试失败");
	}
	
	@GetMapping("/exam/info/{isEntry}")
	public JsonResult getExamByIsEntry(@PathVariable int isEntry) {
		return JsonUtil.success(examManagementService.getExamByIsEntry(isEntry));
	}

}
