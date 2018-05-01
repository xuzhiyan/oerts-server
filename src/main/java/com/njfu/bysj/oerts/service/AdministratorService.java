/**
 * @FileName:		AdministratorService.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月1日 下午5:19:07
 *
 */
package com.njfu.bysj.oerts.service;

import com.njfu.bysj.oerts.entity.AdministratorEntity;

/**
 * @ClassName:     	AdministratorService
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年5月1日 下午5:19:07
 *
 */
public interface AdministratorService {

	AdministratorEntity administratorLoginByPassw(AdministratorEntity login);
}
