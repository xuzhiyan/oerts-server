/**
 * @FileName:		ExamPlaceManagementMapper.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月11日 下午3:54:46
 *
 */
package com.njfu.bysj.oerts.mapper;

import java.util.List;

import com.njfu.bysj.oerts.entity.ExamPlaceManagementEntity;

/**
 * @ClassName: ExamPlaceManagementMapper
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月11日 下午3:54:46
 *
 */
public interface ExamPlaceManagementMapper {

	List<ExamPlaceManagementEntity> getAllExamPlace();

	List<ExamPlaceManagementEntity> getAllCity();

	List<ExamPlaceManagementEntity> getDistrictByCity(String city);

	List<ExamPlaceManagementEntity> getPlaceByDistrict(String district);
}
