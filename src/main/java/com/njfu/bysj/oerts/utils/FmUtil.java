/**
 * @FileName:		FmUtil.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月15日 下午3:35:51
 *
 */
package com.njfu.bysj.oerts.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.njfu.bysj.oerts.bean.ExamineeRegistInfo;
import com.njfu.bysj.oerts.bean.FtlInfo;
import com.njfu.bysj.oerts.entity.ExamManagementEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @ClassName: FmUtil
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月15日 下午3:35:51
 *
 */
public class FmUtil {

	// 模板的固定位置
	public final String ftlDir = "src/main/resources/static/freemarker/";

	public void createAdmissionTicket(String savePath, FtlInfo info) throws IOException, TemplateException {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("userPhoto", "../../.." + info.getUserPhoto().substring(6));
		map.put("examName", info.getExamName());
		map.put("userName", info.getUserName());
		map.put("idCard", info.getIdCard());
		map.put("admissionTicket", info.getAdmissionTicket());
		map.put("roomNum", info.getRoomNum());
		map.put("setNum", info.getSetNum());
		map.put("examType", info.getExamType());
		map.put("examPlace", info.getExamPlace());

		map.put("day1", info.getExamTimePeriod1().substring(0, 10));
		map.put("time1", info.getExamTimePeriod1().substring(11));
		map.put("type1", "理论");

		if (info.getExamTimePeriod2().isEmpty()) {
			map.put("day2", "");
			map.put("time2", "");
			map.put("type2", "");
		} else {
			map.put("day2", info.getExamTimePeriod2().substring(0, 10));
			map.put("time2", info.getExamTimePeriod2().substring(11));
			map.put("type2", "理论");
		}

		if (info.getExamTimePeriod3().isEmpty()) {
			map.put("day3", "");
			map.put("time3", "");
			map.put("type3", "");
		} else {
			map.put("day3", info.getExamTimePeriod3().substring(0, 10));
			map.put("time3", info.getExamTimePeriod3().substring(11));
			map.put("type3", "理论");
		}

		// 调用freeMarker
		createHtml(savePath, info.getAdmissionTicket(), map, "AdmissionTicket.ftl");
	}

	public void createExamReport(String savePath, ExamManagementEntity examInfo, List<ExamineeRegistInfo> examineeInfo,
			int paseNum) throws IOException, TemplateException {

		Map<String, Object> map = new HashMap<String, Object>();

		// 模板上的考试信息
		map.put("examName", examInfo.getExamName());
		map.put("examId", examInfo.getExamId());
		map.put("examType", examInfo.getExamType());
		map.put("examPlace", examInfo.getExamPlace());
		map.put("paseScore", examInfo.getPaseScore());
		map.put("totalScore", examInfo.getTotalScore());
		map.put("day1", examInfo.getExamTimePeriod1().substring(0, 10));
		map.put("time1", examInfo.getExamTimePeriod1().substring(11));
		map.put("type1", "理论");
		if (examInfo.getExamTimePeriod2().isEmpty()) {
			map.put("day2", "");
			map.put("time2", "");
			map.put("type2", "");
		} else {
			map.put("day2", examInfo.getExamTimePeriod2().substring(0, 10));
			map.put("time2", examInfo.getExamTimePeriod2().substring(11));
			map.put("type2", "理论");
		}

		if (examInfo.getExamTimePeriod3().isEmpty()) {
			map.put("day3", "");
			map.put("time3", "");
			map.put("type3", "");
		} else {
			map.put("day3", examInfo.getExamTimePeriod3().substring(0, 10));
			map.put("time3", examInfo.getExamTimePeriod3().substring(11));
			map.put("type3", "理论");
		}
		map.put("examNum", examineeInfo.size());

		float rat = (float) paseNum / (float) examineeInfo.size() * 100;
		DecimalFormat decimalFormat = new DecimalFormat(".0");
		map.put("paseRat", decimalFormat.format(rat) + "%");

		// 模板上的学生成绩信息
		map.put("examineeInfo", examineeInfo);

		// 调用freeMarker
		createHtml(savePath, "report", map, "ExamReport.ftl");
	}

	public void createScoreReport(String savePath, FtlInfo info) throws IOException, TemplateException {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("userPhoto", "../../.." + info.getUserPhoto().substring(6));
		map.put("examName", info.getExamName());
		map.put("userName", info.getUserName());
		map.put("idCard", info.getIdCard());
		map.put("admissionTicket", info.getAdmissionTicket());
		map.put("examType", info.getExamType());
		map.put("score", info.getScore());
		map.put("paseScore", info.getPaseScore());
		map.put("totalScore", info.getTotalScore());
		if (info.getIsCertificate().equals("1")) {
			map.put("isCertificate", "是");
		} else {
			map.put("isCertificate", "否");
		}

		createHtml(savePath, info.getAdmissionTicket(), map, "ScoreReport.ftl");
	}
	
	public void createCertificate(String savePath, FtlInfo info) throws IOException, TemplateException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userPhoto", "../../.." + info.getUserPhoto().substring(6));
		map.put("examName", info.getExamName());
		map.put("userName", info.getUserName());
		map.put("idCard", info.getIdCard());
		map.put("admissionTicket", info.getAdmissionTicket());
		
		createHtml(savePath, info.getAdmissionTicket(), map, "Certificate.ftl");
	}

	public void createHtml(String savePath, String htmlName, Map<String, Object> map, String templateName)
			throws IOException, TemplateException {

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
		cfg.setDirectoryForTemplateLoading(new File(ftlDir));
		cfg.setDefaultEncoding("UTF-8");
		Template template = cfg.getTemplate(templateName);

		File targetFile = new File(savePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		Writer out = new FileWriter(new File(savePath + htmlName + ".html"));

		template.process(map, out);

		out.flush();
		out.close();
	}

}
