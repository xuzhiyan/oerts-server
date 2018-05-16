/**
 * @FileName:		ExcelController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月16日 下午3:22:11
 *
 */
package com.njfu.bysj.oerts.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamManagementService;
import com.njfu.bysj.oerts.service.ExamRegistrationService;
import com.njfu.bysj.oerts.utils.ExcelUtil;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName: ExcelController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月16日 下午3:22:11
 *
 */
@RestController
public class ExcelController {

	@Autowired
	private ExamRegistrationService examRegistrationService;
	@Autowired
	private ExamManagementService examManagementService;

	@GetMapping("/excel/info/examinee/{examId}")
	public JsonResult getExamineeExcelById(@PathVariable String examId, HttpServletRequest request) throws IOException {

		String examName = examManagementService.getExamById(examId).getExamName();
		String savePath = request.getSession().getServletContext().getRealPath("exam/") + examId + "\\"
				+ "examineeInfo.xls";

		File targetFile = new File(request.getSession().getServletContext().getRealPath("exam/") + examId + "\\");
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		File excel = new File(savePath);
		if (excel.exists()) {
			return JsonUtil.success();
		} else {
			ExcelUtil.createExamineeInfoExcel(savePath, examName, examRegistrationService.getExamineeInfoById(examId));
			return JsonUtil.success();
		}
	}

	@GetMapping("/excel/info/score/{examId}")
	public JsonResult getScoreExcelById(@PathVariable String examId, HttpServletRequest request) throws IOException {

		String examName = examManagementService.getExamById(examId).getExamName();
		String savePath = request.getSession().getServletContext().getRealPath("exam/") + examId + "\\"
				+ "scoreInfo.xls";

		File targetFile = new File(request.getSession().getServletContext().getRealPath("exam/") + examId + "\\");
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		File excel = new File(savePath);
		if (excel.exists()) {
			return JsonUtil.success();
		} else {
			ExcelUtil.createScoreInfoExcel(savePath, examName, examRegistrationService.getExamineeInfoById(examId));
			return JsonUtil.success();
		}
	}
}
