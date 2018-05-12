/**
 * @FileName:		ExamPlaceManagementController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月12日 下午3:16:09
 *
 */
package com.njfu.bysj.oerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamPlaceManagementService;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName:     	ExamPlaceManagementController
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年5月12日 下午3:16:09
 *
 */
@RestController
public class ExamPlaceManagementController {

	@Autowired
	private ExamPlaceManagementService examPlaceManagementService;
	
	@GetMapping("/examplace/all")
	public JsonResult getAllExamPlace() {
		return JsonUtil.success(examPlaceManagementService.getAllExamPlace());
	}
	
	@GetMapping("/examplace/city/all")
	public JsonResult getAllCity() {
		return JsonUtil.success(examPlaceManagementService.getAllCity());
	}
	
	@GetMapping("/examplace/district/{city}")
	public JsonResult getDistrictByCity(@PathVariable String city) {
		return JsonUtil.success(examPlaceManagementService.getDistrictByCity(city));
	}
	
	@GetMapping("/examplace/palce/{district}")
	public JsonResult getPlaceByDistrict(@PathVariable String district) {
		return JsonUtil.success(examPlaceManagementService.getPlaceByDistrict(district));
	}
}
