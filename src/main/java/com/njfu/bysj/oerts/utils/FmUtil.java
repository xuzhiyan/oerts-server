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
import java.util.HashMap;
import java.util.Map;

import com.njfu.bysj.oerts.bean.FtlInfo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @ClassName:     	FmUtil
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年5月15日 下午3:35:51
 *
 */
public class FmUtil {
	
	// 模板的固定位置
	public final String ftlDir = "src/main/resources/static/freemarker/";
	
	public void createAdmissionTicket(String savePath, FtlInfo info) throws IOException, TemplateException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userPhoto", "../.." + info.getUserPhoto().substring(6));
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
		createHtml(savePath, info.getAdmissionTicket(), map);
	}
	
	public void createHtml(String savePath, String htmlName, Map<String, Object> map) throws IOException, TemplateException {
		
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
		cfg.setDirectoryForTemplateLoading(new File(ftlDir));
		cfg.setDefaultEncoding("UTF-8");
		Template template = cfg.getTemplate("AdmissionTicket.ftl");
		
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
