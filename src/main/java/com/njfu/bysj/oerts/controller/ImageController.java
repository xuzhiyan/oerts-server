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

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.njfu.bysj.oerts.entity.JsonResult;
import com.njfu.bysj.oerts.utils.ImageUtil;
import com.njfu.bysj.oerts.utils.JsonUtil;
import com.njfu.bysj.oerts.utils.OcrUtil;

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

	@PostMapping("/images/upload")
	public JsonResult upLoadImages(@RequestParam MultipartFile image, @RequestParam String userPhone,
			@RequestParam String fileName, HttpServletRequest request) throws IOException {

		ImageUtil imageUtil = new ImageUtil();
		String savePath = request.getSession().getServletContext().getRealPath("images/") + userPhone + "/";
		String result = imageUtil.saveImage(image, savePath, fileName);

		if (result.equals("null")) {
			return JsonUtil.failed("图片上传失败");
		} else {
			return JsonUtil.success(result);
		}
	}
	
	@GetMapping("/ocrtest")
	public JsonResult test() throws JSONException {
		
//		OcrUtil ocrUtil = new OcrUtil();
//		ocrUtil.OcrIdCard();
		
		
		return null;
	}

}
