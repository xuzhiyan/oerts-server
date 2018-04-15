/**
 * @FileName:		JsonUtil.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月14日 上午12:46:07
 *
 */
package com.njfu.bysj.oerts.utils;

import com.njfu.bysj.oerts.entity.JsonResult;

/**
 * @ClassName: JsonUtil
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月14日 上午12:46:07
 *
 */
public class JsonUtil {

	public static JsonResult success(Object object) {
		JsonResult jsonresult = new JsonResult();
		jsonresult.setStatus("success");
		jsonresult.setMessage("请求成功");
		jsonresult.setData(object);

		return jsonresult;
	}

	public static JsonResult success() {
		return success(null);
	}

	public static JsonResult failed(String message) {
		JsonResult jsonresult = new JsonResult();
		jsonresult.setStatus("failed");
		jsonresult.setMessage(message);
		jsonresult.setData(null);

		return jsonresult;
	}

}
