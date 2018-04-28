/**
 * @FileName:		TimeScheduler.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月20日 下午3:32:37
 *
 */
package com.njfu.bysj.oerts.timer;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.njfu.bysj.oerts.service.ExamRegistrationService;

/**
 * @ClassName: TimeScheduler
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月20日 下午3:32:37
 *
 */
@Component
public class TimeScheduler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExamRegistrationService examRegistrationService;

	// 每5分钟执行一次
	// 0 0 2 * * ? 每天早上2点触发
//	@Scheduled(cron = "0 0/1 * * * ?") 
	public void examReviewScheduler() throws JSONException {
		logger.info("============审核考试信息Service启动============");
		examRegistrationService.examReview();
	}
}
