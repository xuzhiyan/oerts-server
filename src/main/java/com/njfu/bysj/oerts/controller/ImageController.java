/**
 * @FileName:		PhotoController.java
 * @Description:	TODO
 *
 * @author         	徐至彦
 * @version        	V1.0
 * @Date           	2018年4月16日 下午10:01:27
 *
 */
package com.njfu.bysj.oerts.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.njfu.bysj.oerts.entity.JsonResult;

/**
 * @ClassName:     	PhotoController
 * @Description:	TODO
 *
 * @author:    		徐至彦
 * @date:        	2018年4月16日 下午10:01:27
 *
 */
@RestController
public class ImageController {

	@PostMapping("/userphoto")
	public JsonResult upLoadPhoto(@RequestParam MultipartFile userPhoto, HttpServletRequest request) throws IOException {
//		String fileType = userPhoto.getContentType(); // image/jpeg 文件类型
//		System.out.println(fileType);
//		String fileName = userPhoto.getOriginalFilename(); // 文件原始名字
//		System.out.println(fileName);
//		System.out.println(ResourceUtils.getURL("classpath:").getPath());
//		System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
//		File file = new File("data/userphotos/111.txt");
//		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
//		stream.write(111111);
//		stream.close();
		
		String basePath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(basePath);
		
		return null;
	}
	
}
