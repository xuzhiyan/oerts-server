/**
 * @FileName:		ExamManagementServiceimpl.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月9日 下午11:44:48
 *
 */
package com.njfu.bysj.oerts.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njfu.bysj.oerts.entity.ExamManagementEntity;
import com.njfu.bysj.oerts.mapper.ExamManagementMapper;
import com.njfu.bysj.oerts.service.ExamManagementService;

/**
 * @ClassName: ExamManagementServiceimpl
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月9日 下午11:44:48
 *
 */
@Service
public class ExamManagementServiceImpl implements ExamManagementService {

	@Autowired
	private ExamManagementMapper examManagementMapper;

	@Override
	public List<ExamManagementEntity> getAllExams() {
		return examManagementMapper.getAllExams();
	}

	@Override
	public ExamManagementEntity getExamById(String examId) {
		return examManagementMapper.getExamById(examId);
	}

	@Override
	public boolean addExam(ExamManagementEntity add) {
		examManagementMapper.getMaxExamId();
		String maxId = examManagementMapper.getMaxExamId();
		if (maxId == null) {
			add.setExamId("1000001");
		} else {
			int addId = Integer.parseInt(maxId) + 1;
			add.setExamId(addId + "");
		}

		if (examManagementMapper.addExam(add) == 1) {
			return true;
		}
		return false;
	}

}
