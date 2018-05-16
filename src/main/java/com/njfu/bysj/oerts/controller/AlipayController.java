/**
 * @FileName:		AlipayController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月16日 下午9:33:45
 *
 */
package com.njfu.bysj.oerts.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.njfu.bysj.oerts.bean.AlipayInfo;
import com.njfu.bysj.oerts.entity.ExamineeEntity;
import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.service.ExamineeService;
import com.njfu.bysj.oerts.utils.AlipayUtil;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName: AlipayController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月16日 下午9:33:45
 *
 */
@RestController
public class AlipayController {

	@Autowired
	private ExamineeService examineeService;

	@PostMapping("/balance/alipay/recharge")
	public JsonResult rechargeBalance(@RequestBody AlipayInfo info) throws AlipayApiException {

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// 生成当前订单号
		String outTradeNo = df.format(new Date()) + "_" + info.getUserPhone();

		AlipayInfo result = AlipayUtil.alipayTradePrecreate(outTradeNo, info.getRechargeNum());
		if (result.getResStatus().equals("success")) {
			// 请求成功 拿到二维码码串 需要进行生成
			return JsonUtil.success(result);
		} else {
			return JsonUtil.failed("请求失败");
		}
	}

	@PostMapping("/balance/alipay/query")
	public JsonResult getQueryInfo(@RequestBody AlipayInfo info) throws AlipayApiException {

		AlipayInfo result = AlipayUtil.alipayTradeQuery(info.getOutTradeNo());
		if (result.getResStatus().equals("success")) {

			// 更新数据库中的余额
			ExamineeEntity update = new ExamineeEntity();
			update.setUserPhone(info.getUserPhone());
			update.setUserBalance(Integer.parseInt(info.getRechargeNum()));
			examineeService.updateUserBalance(update);

			return JsonUtil.success(result);
		} else {
			return JsonUtil.failed("没有数据");
		}

	}
}
