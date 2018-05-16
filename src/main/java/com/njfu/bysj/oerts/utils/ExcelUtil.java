/**
 * @FileName:		ExcelUtil.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年5月16日 下午3:21:28
 *
 */
package com.njfu.bysj.oerts.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.njfu.bysj.oerts.bean.FtlInfo;

/**
 * @ClassName: ExcelUtil
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年5月16日 下午3:21:28
 *
 */
public class ExcelUtil {

	public static void createExamineeInfoExcel(String savePath, String examName, List<FtlInfo> ftlInfo)
			throws IOException {

		// 第一步，创建一个workbook对应一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 第二部，在workbook中创建一个sheet对应excel中的sheet
		HSSFSheet sheet = workbook.createSheet("考生信息");
		// 第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
		HSSFRow row_f = sheet.createRow(0);
		HSSFRow row = sheet.createRow(1);
		// 第四步，创建单元格，设置表头
		HSSFCell cell_f = row_f.createCell(0);
		cell_f.setCellValue(examName + "_考生信息表");

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("考生姓名");
		cell = row.createCell(1);
		cell.setCellValue("证件号码");
		cell = row.createCell(2);
		cell.setCellValue("准考证号");
		cell = row.createCell(3);
		cell.setCellValue("考场号");
		cell = row.createCell(4);
		cell.setCellValue("座位号");

		// 第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
		for (int i = 0; i < ftlInfo.size(); i++) {
			HSSFRow row1 = sheet.createRow(i + 2);
			FtlInfo info = ftlInfo.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(info.getUserName());
			row1.createCell(1).setCellValue(info.getIdCard());
			row1.createCell(2).setCellValue(info.getAdmissionTicket());
			row1.createCell(3).setCellValue(info.getRoomNum());
			row1.createCell(4).setCellValue(info.getSetNum());
		}

		FileOutputStream fos = new FileOutputStream(savePath);
		workbook.write(fos);

		fos.close();
		workbook.close();
	}

	public static void createScoreInfoExcel(String savePath, String examName, List<FtlInfo> ftlInfo)
			throws IOException {

		// 第一步，创建一个workbook对应一个excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 第二部，在workbook中创建一个sheet对应excel中的sheet
		HSSFSheet sheet = workbook.createSheet("成绩信息");
		// 第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
		HSSFRow row_f = sheet.createRow(0);
		HSSFRow row = sheet.createRow(1);
		// 第四步，创建单元格，设置表头
		HSSFCell cell_f = row_f.createCell(0);
		cell_f.setCellValue(examName + "_成绩信息表");

		HSSFCell cell = row.createCell(0);
		cell.setCellValue("考生姓名");
		cell = row.createCell(1);
		cell.setCellValue("证件号码");
		cell = row.createCell(2);
		cell.setCellValue("准考证号");
		cell = row.createCell(3);
		cell.setCellValue("考试成绩");

		// 第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值
		for (int i = 0; i < ftlInfo.size(); i++) {
			HSSFRow row1 = sheet.createRow(i + 2);
			FtlInfo info = ftlInfo.get(i);
			// 创建单元格设值
			row1.createCell(0).setCellValue(info.getUserName());
			row1.createCell(1).setCellValue(info.getIdCard());
			row1.createCell(2).setCellValue(info.getAdmissionTicket());
			row1.createCell(3).setCellValue(info.getScore());
		}

		FileOutputStream fos = new FileOutputStream(savePath);
		workbook.write(fos);

		fos.close();
		workbook.close();
	}
}
