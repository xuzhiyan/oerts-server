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
 * @ClassName: ExamineeServiceImpl
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年1月11日 下午11:12:21
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

	@Override
	public boolean loginByPassw(ExamineeEntity userLogin) {
		if (examineeMapper.loginByPassw(userLogin) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean registByPassw(ExamineeEntity userRegist) {
		if (examineeMapper.countByUserPhone(userRegist.getUserPhone()) == 0) {
			examineeMapper.registByPassw(userRegist);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int countByUserPhone(String userPhone) {
		return examineeMapper.countByUserPhone(userPhone);
	}

	@Override
	public ExamineeEntity getByUserPhone(String userPhone) {
		return examineeMapper.getByUserPhone(userPhone);
	}

	@Override
	public boolean updateByUserPhone(ExamineeEntity userInfo) {
//		if (examineeMapper.countByIdCard(userInfo.getIdCard()) == 0) {
//			examineeMapper.updateByUserPhone(userInfo);
//			return true;
//		} else {
//			return false;
//		}
		examineeMapper.updateByUserPhone(userInfo);
		return true;
	}

	@Override
	public int countByIdCard(String idCard) {
		return examineeMapper.countByIdCard(idCard);
	}
}
