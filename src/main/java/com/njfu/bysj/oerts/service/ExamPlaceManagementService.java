/**
 * @FileName:		ExamPlaceManagementService.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月11日 下午4:31:30
 *
 */
package com.njfu.bysj.oerts.service;

import java.util.List;

import com.njfu.bysj.oerts.entity.ExamPlaceManagementEntity;

/**
 * @ClassName: ExamPlaceManagementService
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月11日 下午4:31:30
 *
 */
public interface ExamPlaceManagementService {

	List<ExamPlaceManagementEntity> getAllExamPlace();

	List<ExamPlaceManagementEntity> getAllCity();

	List<ExamPlaceManagementEntity> getDistrictByCity(String city);

	List<ExamPlaceManagementEntity> getPlaceByDistrict(String district);
	
	int deleteExamPlace(ExamPlaceManagementEntity delete);
	
	boolean addExamPlace(ExamPlaceManagementEntity add);
}
