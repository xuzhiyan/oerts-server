/**
 * @FileName:		ExamineeController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年1月11日 下午11:15:29
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
import com.njfu.bysj.oerts.bean.IdentifyLogin;
import com.njfu.bysj.oerts.entity.ExamineeEntity;
import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamineeService;
import com.njfu.bysj.oerts.utils.JsonUtil;
import com.njfu.bysj.oerts.utils.SmsUtil;

/**
 * @ClassName: ExamineeController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年1月11日 下午11:15:29
 *
 */
@RestController
public class ExamineeController {

	@Autowired
	private ExamineeService examineeService;

	@PostMapping("/loginbypassw")
	public JsonResult loginByPassw(@RequestBody ExamineeEntity userLogin) {
		if (examineeService.loginByPassw(userLogin)) {
			return JsonUtil.success(examineeService.getByUserPhone(userLogin.getUserPhone()));
		} else {
			return JsonUtil.failed("没有对应用户数据");
		}
	}

	@PostMapping("/registbypassw")
	public JsonResult registByPassw(@RequestBody ExamineeEntity userRegist) {
		if (examineeService.registByPassw(userRegist)) {
			return JsonUtil.success();
		} else {
			return JsonUtil.failed("注册失败");
		}
	}

	@PostMapping("/examinee/regist/identifycode")
	public JsonResult registByIdentifycode(@RequestBody ExamineeEntity userRegist) {
		if (examineeService.registByIdentifycode(userRegist)) {
			return JsonUtil.success();
		} else {
			return JsonUtil.failed("注册失败");
		}
	}

	@PostMapping("/updatebyuserphone")
	public JsonResult updateByUserPhone(@RequestBody ExamineeEntity userInfo) {
		if (examineeService.updateByUserPhone(userInfo)) {
			return JsonUtil.success();
		} else {
			return JsonUtil.failed("更新用户数据失败");
		}
	}

	@GetMapping("/countbyuserphone/{userPhone}")
	public JsonResult countByUserPhone(@PathVariable String userPhone) {
		return JsonUtil.success(examineeService.countByUserPhone(userPhone));
	}

	@GetMapping("/getbyuserphone/{userPhone}")
	public JsonResult getByUserPhone(@PathVariable String userPhone) {
		return JsonUtil.success(examineeService.getByUserPhone(userPhone));
	}

	@GetMapping("/examinee/list/all")
	public JsonResult getAllExaminee() {
		return JsonUtil.success(examineeService.getAllExaminee());
	}

	@PostMapping("/examinee/login/identifycode")
	public JsonResult loginByIdentifycode(@RequestBody ExamineeEntity userLogin) throws ClientException {

		String templateCode = SmsUtil.createIdentifycode();
		String templateParam = "{\"code\":\"" + templateCode + "\"}";

		// 发送短信
		SmsUtil.sendSms(userLogin.getUserPhone(), "SMS_134105056", templateParam);

		// 返回手机号和对应验证码
		IdentifyLogin identify = new IdentifyLogin();
		identify.setUserPhone(userLogin.getUserPhone());
		identify.setCode(templateCode);

		return JsonUtil.success(identify);
	}

	@PostMapping("/examinee/update/identifycode")
	public JsonResult updatePasswByIdentifycode(@RequestBody ExamineeEntity userLogin) throws ClientException {

		String templateCode = SmsUtil.createIdentifycode();
		String templateParam = "{\"code\":\"" + templateCode + "\"}";

		// 发送短信
		SmsUtil.sendSms(userLogin.getUserPhone(), "SMS_134105057", templateParam);

		// 返回手机号和对应验证码
		IdentifyLogin identify = new IdentifyLogin();
		identify.setUserPhone(userLogin.getUserPhone());
		identify.setCode(templateCode);

		return JsonUtil.success(identify);
	}

	@PostMapping("/examinee/update/password")
	public JsonResult updatePasswByUserPhone(@RequestBody ExamineeEntity userInfo) {

		examineeService.updatePasswByUserPhone(userInfo);
		return JsonUtil.success();
	}
}
