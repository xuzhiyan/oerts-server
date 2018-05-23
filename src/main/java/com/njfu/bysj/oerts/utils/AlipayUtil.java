/**
 * @FileName:		AlipayUtil.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月16日 下午9:38:10
 *
 */
package com.njfu.bysj.oerts.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.njfu.bysj.oerts.bean.AlipayInfo;

/**
 * @ClassName: AlipayUtil
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月16日 下午9:38:10
 *
 */
public class AlipayUtil {

	// 商户appid
	public static String APPID = "2016091500515786";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCJyJhbfVNuY7oGrgV1JT6uWjkObHTpgt2wTMU0GIJ5J/5SMfvP0o+RFjw2+sXnysIiLvSkfm+RVDKThTfHDYAXARA8VnEjyTcM0iqw6zyY26bXECCuDBQUM8ytKCU8lXD6Aw+Dt8l7MyZlszp44VdSpTN6ESQqD9WghBj0auGUH1BWRipWc99N8MdaZASiH/SsZC9d8bkwYFJjDeIHjcF2tKGHsXmQyU00nXTkenHfq9zvIO6rYcks89uFCRXodXK0S0ZbZiQG+FX8GmLHMESKp0fTxa6bDvQOhUciT8c8sIxEdv/uwWELLBM5PCMBwcc4nd9Jvunyh01qV4t/MmMnAgMBAAECggEAZGp4d30gF/zAb+vV+GlbhFAm8xciIakJjlp1AqG2PTxjgl4BSpYHodLVsbAUGflQgP89tsCa6Qy3C4J0gzKYnqtcvMy3CkC0STjGekgG0tSKhISxfIc6/vo9ehkfAkdbnioq3XFNeudtXYNA4yY/sPDLUnQ5qhn+NEzxrvhSTNNqfIbq4cdsRXhBRW0mRGrl6y2GoWFE42A/exVHK6n086dITBRaFJE931Z4tnEnk0JmyShV9o8y0RkRd8MofoQtq1q2zftSb/y+8J8uc1AQTS6CuoODpDRiqYQ5vs5r03ev839Cc4iYQhtzJffiqjyW7AEeGOPZ1Q3zS22E83jzmQKBgQDkhCCD4TKdaO9hKO197GQI+hAbbRjQcsMPIqX2+w9maMoE/X6N3smfrVWJMincSKeq70lmA5wf+tnVFhsKPWgXlD/3ppyLKPqDLZVpOI107jKBUaXQ4ZePPAu7qWA1beqnt+fwGOsnIsVEbZfae4LMOQuk9c+t//S4KI2bobR/qwKBgQCaWt4zshejZ+pq8vXL1mgQmo+KXxPSlc5ty77xnscgsZDeB33NMtB7g1hSRzXuEpTOyVqEEWQzoz9in2wFWGlFJwrBKTOcly6mz8BkpgzYjir+MOwYUbzy2ho1bRF+YmfoDwlfac9S6xElabUT16C4i1wgIQ9BTXA67+BDjDoedQKBgCTzLGLGti13u0VFnek/oQlGjfYxVNLXy6yV2Kov/FR92zSlXKJKBOYZ2/vcLaKd6Oad3ItvR/5vzGtFMMgeF8fAQ/uiaCukS6WMaF1kNJNUtLvuXNaCs8QIXIlSoOjixg+qkAllrhhc6fLfma9NS2AEVVquGI+1FHf2rrcclZgTAoGACLbgnKKNWxhez7Lv1ZZBQc64E+PSRq1WfjRmj1WbgGkF+MMLgy4/PvnnXp3OmaZK6HHNvm8M7S1mQrclbhfTuae+n7EnzMtsQtav0f7d8svz+W3hpm3W8Q8HM8T4m94KZ7uRl+VtYw0KZsZVBs3BsSmNBfNX3SP2Fh2815NvJJECgYAUjiTo1XWLC8Wt3keuTXKEgi+08sBW6VYGvP+Ax3GgxtDV/Q4R8Sap4aSBaHN8bXB2TH7fYjGZQ7qV1C7eL0+KeDaXbJJe/XVY4w8NACUKymhgJ4eGwAk3swNr8CSj7YNK8Buwq3/v1pqlpMyBbY1TopXrRlW1F7iRGIVcvEt3NA==";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 商户可以自定义同步跳转地址
	public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvsqNVyF9iWljsrxklH4xb5xKBiJkV1NHSEuq4SbiJ65JvMOTrQwjZP5hgzBWL8Z7h3W8wlqy3/lZpg0FcOsxC0dH40qR5fD0/uCKUDDFyDFE/IY/KxQb2JeZBYud67pGPTRTWLWmKpjQSHeEpY5hqaLByEO4khRXGzfGykMXaA0rZKuvSbftW7nYhSXRccqkStt004bcE0awdF6Ea5o/K+y/4MesuRqPyBgEF0og31qRvd+/elJVzUUudHsk6hAzKMU+q+DSPVjq8fC1e++ztQnoI35Mm2Qr789itn3Kaz6jXjCp4zBEeUKyKKKsv68Zh25DM4MTdN4dzYS0/YsyGwIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";

	public static AlipayInfo alipayTradePrecreate(String outTradeNo, String rechargeNum) throws AlipayApiException {

		// 初始化支付宝配置
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APPID, RSA_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGNTYPE);
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

		// 生成订单详情 订单号必须唯一 每次都得换
		AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
		model.setOutTradeNo(outTradeNo);
		model.setTotalAmount(rechargeNum);
		model.setSubject("考生报名系统_账户余额充值");
		request.setBizModel(model);

		AlipayTradePrecreateResponse response = alipayClient.execute(request);

		AlipayInfo alipayInfo = new AlipayInfo();
		if (response.isSuccess()) {
			alipayInfo.setResStatus("success");
			alipayInfo.setOutTradeNo(outTradeNo);
			// qr_Code当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码
			alipayInfo.setQrCode(response.getQrCode());
		} else {
			alipayInfo.setResStatus("failed");
		}

		return alipayInfo;
	}

	public static AlipayInfo alipayTradeQuery(String outTradeNo) throws AlipayApiException {

		// 初始化支付宝配置
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APPID, RSA_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGNTYPE);
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();

		AlipayTradeQueryModel model = new AlipayTradeQueryModel();
		model.setOutTradeNo(outTradeNo);
		request.setBizModel(model);

		AlipayTradeQueryResponse response = alipayClient.execute(request);

		AlipayInfo alipayInfo = new AlipayInfo();

		if (response.getTradeStatus().equals("TRADE_SUCCESS")) {
			alipayInfo.setResStatus("success");
			alipayInfo.setOutTradeNo(outTradeNo);
		} else {
			alipayInfo.setResStatus("failed");
			alipayInfo.setOutTradeNo(outTradeNo);
		}
		return alipayInfo;
	}
}
