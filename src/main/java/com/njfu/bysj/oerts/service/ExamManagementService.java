/**
 * @FileName:		ExamManagementService.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月9日 下午11:43:54
 *
 */
package com.njfu.bysj.oerts.service;

import java.util.List;

import com.njfu.bysj.oerts.entity.ExamManagementEntity;

/**
 * @ClassName:     	ExamManagementService
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月9日 下午11:43:54
 *
 */
public interface ExamManagementService {

	List<ExamManagementEntity> getAllExams();
	
	ExamManagementEntity getExamById(String examId);
	
	boolean addExam(ExamManagementEntity add);
	
	List<ExamManagementEntity> getExamByIsEntry(int isEntry);
}
