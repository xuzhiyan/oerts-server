/**
 * @FileName:		ExamPlaceManagementServiceImpl.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月11日 下午4:31:50
 *
 */
package com.njfu.bysj.oerts.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njfu.bysj.oerts.entity.ExamPlaceManagementEntity;
import com.njfu.bysj.oerts.mapper.ExamPlaceManagementMapper;
import com.njfu.bysj.oerts.service.ExamPlaceManagementService;

/**
 * @ClassName: ExamPlaceManagementServiceImpl
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月11日 下午4:31:50
 *
 */
@Service
public class ExamPlaceManagementServiceImpl implements ExamPlaceManagementService {

	@Autowired
	private ExamPlaceManagementMapper examPlaceManagementMapper;

	@Override
	public List<ExamPlaceManagementEntity> getAllExamPlace() {
		return examPlaceManagementMapper.getAllExamPlace();
	}

	@Override
	public List<ExamPlaceManagementEntity> getAllCity() {
		return examPlaceManagementMapper.getAllCity();
	}

	@Override
	public List<ExamPlaceManagementEntity> getDistrictByCity(String city) {
		return examPlaceManagementMapper.getDistrictByCity(city);
	}

	@Override
	public List<ExamPlaceManagementEntity> getPlaceByDistrict(String district) {
		return examPlaceManagementMapper.getPlaceByDistrict(district);
	}

}
