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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.njfu.bysj.oerts.bean.ExamineeRegistInfo;
import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamManagementService;
import com.njfu.bysj.oerts.service.ExamRegistrationService;
import com.njfu.bysj.oerts.utils.ExcelUtil;
import com.njfu.bysj.oerts.utils.JsonUtil;

import freemarker.template.TemplateException;

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
	
	@PostMapping("/excel/info/score/upload")
	public JsonResult uploadScoreExcel(@RequestParam MultipartFile excel, @RequestParam String examId, HttpServletRequest request)
			throws IOException, TemplateException {
		
		// 将上传的excel文件保存至服务器指定目录下
		String savePath = request.getSession().getServletContext().getRealPath("upload/");
		File targetFile = new File(savePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(savePath + excel.getOriginalFilename());
		
		out.write(excel.getBytes());
		out.flush();
		out.close();
		
		// 读取excel中的信息，将其更新至数据库
		List<ExamineeRegistInfo> result = ExcelUtil.readScoreExcel(savePath + excel.getOriginalFilename(), examId);
		
		return JsonUtil.success(examRegistrationService.entryScore(result, request));
	}
}
