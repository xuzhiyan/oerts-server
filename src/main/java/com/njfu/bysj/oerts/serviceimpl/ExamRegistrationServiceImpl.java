/**
 * @FileName:		ExamRegistrationServiceImpl.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月17日 下午9:58:33
 *
 */
package com.njfu.bysj.oerts.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njfu.bysj.oerts.entity.ExamRegistrationEntity;
import com.njfu.bysj.oerts.entity.ExamineeEntity;
import com.njfu.bysj.oerts.mapper.ExamRegistrationMapper;
import com.njfu.bysj.oerts.mapper.ExamineeMapper;
import com.njfu.bysj.oerts.service.ExamRegistrationService;

/**
 * @ClassName: ExamRegistrationServiceImpl
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月17日 下午9:58:33
 *
 */
@Service
public class ExamRegistrationServiceImpl implements ExamRegistrationService {

	@Autowired
	private ExamRegistrationMapper examRegistrationMapper;
	@Autowired
	private ExamineeMapper examineeMapper;

	@Override
	public boolean examRegistByIdCardAndExamID(String examId, String userPhone) {
		ExamineeEntity userInfo = examineeMapper.getByUserPhone(userPhone);
		ExamRegistrationEntity registration = new ExamRegistrationEntity();
		registration.setExamId(examId);
		registration.setIdCard(userInfo.getIdCard());
		registration.setStatus("00");
		registration.setAdmissionTicket("");
		registration.setScore(0);
		if (examRegistrationMapper.examRegistByIdCardAndExamID(registration) != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean countByIdCardAndExamID(String examId, String userPhone) {
		ExamineeEntity userInfo = examineeMapper.getByUserPhone(userPhone);
		if (examRegistrationMapper.countByIdCardAndExamID(userInfo.getIdCard(), examId) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
