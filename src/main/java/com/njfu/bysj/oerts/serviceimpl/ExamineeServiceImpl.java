/**
 * @FileName:		ExamineeServiceImpl.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年1月11日 下午11:12:21
 *
 */
package com.njfu.bysj.oerts.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njfu.bysj.oerts.entity.ExamineeEntity;
import com.njfu.bysj.oerts.mapper.ExamineeMapper;
import com.njfu.bysj.oerts.service.ExamineeService;

/**
 * @ClassName:     	ExamineeServiceImpl
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年1月11日 下午11:12:21
 *
 */
@Service
public class ExamineeServiceImpl implements ExamineeService {

	@Autowired
	private ExamineeMapper examineeMapper;
	
	@Override
	public List<ExamineeEntity> getAll() {
		
		return examineeMapper.getAll();
	}
	
	@Override
	public int selectCount() {
		
		return examineeMapper.selectCount();
	}
}
