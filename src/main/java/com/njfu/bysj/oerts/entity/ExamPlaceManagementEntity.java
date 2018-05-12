/**
 * @FileName:		ExamPlaceManagementEntity.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月11日 下午2:38:44
 *
 */
package com.njfu.bysj.oerts.entity;

import java.io.Serializable;

/**
 * @ClassName: ExamPlaceManagementEntity
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月11日 下午2:38:44
 *
 */
public class ExamPlaceManagementEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 城市名称 */
	private String city;
	/** 城市区/镇名称 */
	private String district;
	/** 地点名称 */
	private String place;

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

}
