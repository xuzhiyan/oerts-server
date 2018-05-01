/**
 * @FileName:		AdministratorMapper.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月1日 下午5:14:14
 *
 */
package com.njfu.bysj.oerts.mapper;

import com.njfu.bysj.oerts.entity.AdministratorEntity;

/**
 * @ClassName:     	AdministratorMapper
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年5月1日 下午5:14:14
 *
 */
public interface AdministratorMapper {

	AdministratorEntity administratorLoginByPassw(AdministratorEntity login);
}
