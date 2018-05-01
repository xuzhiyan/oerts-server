/**
 * @FileName:		AdministratorServiceImpl.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月1日 下午5:19:27
 *
 */
package com.njfu.bysj.oerts.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njfu.bysj.oerts.entity.AdministratorEntity;
import com.njfu.bysj.oerts.mapper.AdministratorMapper;
import com.njfu.bysj.oerts.service.AdministratorService;

/**
 * @ClassName: AdministratorServiceImpl
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月1日 下午5:19:27
 *
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorMapper administratorMapper;

	@Override
	public AdministratorEntity administratorLoginByPassw(AdministratorEntity login) {
		return administratorMapper.administratorLoginByPassw(login);
	}

}
