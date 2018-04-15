/**
 * @FileName:		ExamineeService.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年1月11日 下午11:11:07
 *
 */
package com.njfu.bysj.oerts.service;

import java.util.List;

import com.njfu.bysj.oerts.entity.ExamineeEntity;

/**
 * @ClassName: ExamineeService
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年1月11日 下午11:11:07
 *
 */
public interface ExamineeService {

	List<ExamineeEntity> getAll();

	int selectCount();

	boolean loginByPassw(ExamineeEntity userLogin);
	
	int countByUserPhone(String userPhone);
	
	boolean registByPassw(ExamineeEntity userRegist);
	
	ExamineeEntity getByUserPhone(String userPhone);
	
	boolean updateByUserPhone(ExamineeEntity userInfo);
}
