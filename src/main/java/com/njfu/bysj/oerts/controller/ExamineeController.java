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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.ExamineeEntity;
import com.njfu.bysj.oerts.service.ExamineeService;

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
	public boolean loginByPassw(@RequestBody ExamineeEntity userLogin) {
		return examineeService.loginByPassw(userLogin);
	}
	
	@PostMapping("/registbypassw")
	public boolean registByPassw(@RequestBody ExamineeEntity userRegist) {
		examineeService.registByPassw(userRegist);
		return false;
	}
}
