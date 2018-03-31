/**
 * @FileName:		BaseController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年3月11日 下午9:56:19
 *
 */
package com.njfu.bysj.oerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.ExamineeEntity;
import com.njfu.bysj.oerts.service.ExamineeService;

/**
 * @ClassName: BaseController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年3月11日 下午9:56:19
 *
 */
@RestController
public class BaseController {

	@Autowired
	private ExamineeService examineeService;

	@GetMapping("/all")
	public List<ExamineeEntity> getall() {
		return examineeService.getAll();
	}
}
