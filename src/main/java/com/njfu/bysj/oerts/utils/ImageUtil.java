/**
 * @FileName:		ImageUtil.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月16日 下午10:15:43
 *
 */
package com.njfu.bysj.oerts.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: ImageUtil
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月16日 下午10:15:43
 *
 */
public class ImageUtil {

	public String saveImage(MultipartFile multipartFile, String savePath, String fileName) throws IOException {

		String fileType = multipartFile.getContentType();

		// 判断文件类型
		if (fileType.equals("image/png") || fileType.equals("image/jpeg")) {
			if (fileType.contains("png")) {
				fileType = ".png";
			} else {
				fileType = ".jpg";
			}
		} else {
			return "null";
		}

		File targetFile = new File(savePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(savePath + fileName + fileType);

		out.write(multipartFile.getBytes());
		out.flush();
		out.close();

		return fileType;
	}
}