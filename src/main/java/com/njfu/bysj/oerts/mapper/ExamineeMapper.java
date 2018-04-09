/**
 * @FileName:		ExamineeMapper.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年1月11日 下午11:03:37
 *
 */
package com.njfu.bysj.oerts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njfu.bysj.oerts.entity.ExamineeEntity;

/**
 * @ClassName: ExamineeMapper
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年1月11日 下午11:03:37
 *
 */
public interface ExamineeMapper {

	List<ExamineeEntity> getAll();

	int selectCount();

	ExamineeEntity loginByPassw(ExamineeEntity userLogin);
	
	int registByPassw(ExamineeEntity userRegist);
}
