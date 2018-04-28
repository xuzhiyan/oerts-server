/**
 * @FileName:		OcrUtil.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月27日 上午12:26:43
 *
 */
package com.njfu.bysj.oerts.utils;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

/**
 * @ClassName: OcrUtil
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月27日 上午12:26:43
 *
 */
public class OcrUtil {

	// 设置APPID/AK/SK：百度云自己的帐号信息
	public static final String APP_ID = "11161394";
	public static final String API_KEY = "vmpB3BsW8zbZK1fXRcpNGDME";
	public static final String SECRET_KEY = "R4f3dBjKbBKm3azzmZWkPG2R2rVzTWiv";

	public String OcrIdCard(String path, String side) throws JSONException {

		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		HashMap<String, String> options = new HashMap<String, String>();

		options.put("detect_direction", "true");
		/**
		 * 是否开启身份证风险类型(身份证复印件、临时身份证、身份证翻拍、修改过的身份证)功能， 默认不开启，即：false。
		 * 可选值:true-开启；false-不开启
		 */
		options.put("detect_risk", "false");
		/**
		 * front：身份证含照片的一面 back：身份证带国徽的一面 必须正确声明，否则"error_msg": "recognize id card
		 * error"
		 */
		// idcard 表示读取图片的类型是身份证
		JSONObject res = (JSONObject) client.idcard(path, side, options).get("words_result");

		JSONObject nameResult = (JSONObject) res.get("姓名");
		// System.out.println(nameResult);
		JSONObject idCardResult = (JSONObject) res.get("公民身份号码");
		// System.out.println(idCardResult);

		String name = nameResult.get("words").toString();
		String idCard = idCardResult.get("words").toString();
		// System.out.println(name + idCard);

		return name + idCard;
	}
}
