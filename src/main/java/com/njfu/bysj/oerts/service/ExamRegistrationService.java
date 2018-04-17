/**
 * @FileName:		ExamRegistrationService.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月17日 下午9:57:09
 *
 */
package com.njfu.bysj.oerts.service;

/**
 * @ClassName:     	ExamRegistrationService
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月17日 下午9:57:09
 *
 */
public interface ExamRegistrationService {

	boolean examRegistByIdCardAndExamID(String examId, String userPhone);
}
