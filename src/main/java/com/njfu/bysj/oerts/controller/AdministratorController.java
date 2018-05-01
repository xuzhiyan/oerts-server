/**
 * @FileName:		AdministratorController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月1日 下午5:09:11
 *
 */
package com.njfu.bysj.oerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.AdministratorEntity;
import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.AdministratorService;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName: AdministratorController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月1日 下午5:09:11
 *
 */
@RestController
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@PostMapping("/administrator/login/password")
	public JsonResult administratorLoginByPassw(@RequestBody AdministratorEntity login) {

		AdministratorEntity result = administratorService.administratorLoginByPassw(login);
		if (result != null) {
			return JsonUtil.success(result);
		}
		return JsonUtil.failed("没有对应用户数据");
	}
}
