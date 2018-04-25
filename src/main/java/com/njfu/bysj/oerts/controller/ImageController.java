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

import java.io.File;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.utils.ImageUtil;
import com.njfu.bysj.oerts.utils.JsonUtil;

/**
 * @ClassName: PhotoController
 * @Description: TODO
 *
 * @author: 徐至彦
 * @date: 2018年4月16日 下午10:01:27
 *
 */
@RestController
public class ImageController {

	@Value("${images.savepath}")
	public String Path;

	@PostMapping("/userphoto")
	public JsonResult upLoadPhoto(@RequestParam MultipartFile image, @RequestParam String userPhone, @RequestParam String fileName)
			throws IOException {

		ImageUtil imageUtil = new ImageUtil();
		String savePath = Path + userPhone + "/";
		
		if (imageUtil.saveImage(image, savePath, fileName)) {
			return JsonUtil.success();
		} else {
			return JsonUtil.failed("图片上传失败");
		}
	}

}
