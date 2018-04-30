/**
 * @FileName:		OnlineQAController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月29日 下午7:57:35
 *
 */
package com.njfu.bysj.oerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.entity.OnlineQAEntity;
import com.njfu.bysj.oerts.service.OnlineQAService;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName: OnlineQAController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月29日 下午7:57:35
 *
 */
@RestController
public class OnlineQAController {

	@Autowired
	private OnlineQAService onlineQAService;

	@GetMapping("/onlineqa/question/common")
	public JsonResult getCommonQuestion() {

		return JsonUtil.success(onlineQAService.getCommonQuestion());
	}
	
	@GetMapping("/onlineqa/question/{question}")
	public JsonResult getAnswerByKey(@PathVariable String question) {
		
		OnlineQAEntity result = onlineQAService.getAnswerByKey(question);
		if (result.getQuestionAnswer() == null) {
			return JsonUtil.failed("找不到相关答案，请换一种方式询问！");
		} else {
			return JsonUtil.success(result);
		}
	}
}
