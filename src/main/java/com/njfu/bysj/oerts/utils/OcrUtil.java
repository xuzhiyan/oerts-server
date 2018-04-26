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
import java.util.Map;

import org.json.JSONArray;
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

	public void OcrIdCard() throws JSONException {

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
		String idCardSide = "front";
		// 本地图片
		String path = "C:\\Users\\pc\\Desktop\\IMG_20180427_004541_1.jpg";
		// idcard 表示读取图片的类型是身份证
		JSONObject res = client.idcard(path, idCardSide, options);
//		System.out.println(res.toString(2));
		System.out.println(res.get("log_id"));
		System.out.println(res.get("words_result"));
		
//		JSONArray idCardInfo = res.getJSONArray("words_result");
//		for (int i = 0; i < idCardInfo.length(); i++) {
//            String s = (String) idCardInfo.get(i);
//            System.out.println(s);
//        }
		
		JSONObject wordsResult = (JSONObject)res.get("words_result");
		System.out.println(wordsResult);
		
		JSONObject nameResult = (JSONObject)wordsResult.get("姓名");
		System.out.println(nameResult);
		
		String name = nameResult.get("words").toString();
		System.out.println(name);
	}
}
