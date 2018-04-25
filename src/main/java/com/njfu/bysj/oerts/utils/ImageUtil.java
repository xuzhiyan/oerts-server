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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
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

	// @Value("${images.savepath}")
	// public String savePath;

	public boolean saveImage(MultipartFile multipartFile, String savePath, String fileName) throws IOException {

		String fileType = multipartFile.getContentType();

		// 判断文件类型
		if (fileType.equals("image/png") || fileType.equals("image/jpeg")) {
			if (fileType.contains("png")) {
				fileType = ".png";
			} else {
				fileType = ".jpg";
			}
		} else {
			return false;
		}

		File targetFile = new File(savePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		FileOutputStream out = new FileOutputStream(savePath + fileName + fileType);

		out.write(multipartFile.getBytes());
		out.flush();
		out.close();

		return true;
	}
}

// @PutMapping("/article/img/upload")
// public MarkDVo uploadImg(@RequestParam("editormd-image-file") MultipartFile
// multipartFile) {
// if (multipartFile.isEmpty() ||
// StringUtils.isBlank(multipartFile.getOriginalFilename())) {
// throw new BusinessException(ResultEnum.IMG_NOT_EMPTY);
// }
// String contentType = multipartFile.getContentType();
// if (!contentType.contains("")) {
// throw new BusinessException(ResultEnum.IMG_FORMAT_ERROR);
// }
// String root_fileName = multipartFile.getOriginalFilename();
// logger.info("上传图片:name={},type={}", root_fileName, contentType);
// //处理图片
// User currentUser = userService.getCurrentUser();
// //获取路径
// String return_path = ImageUtil.getFilePath(currentUser);
// String filePath = location + return_path;
// logger.info("图片保存路径={}", filePath);
// String file_name = null;
// try {
// file_name = ImageUtil.saveImg(multipartFile, filePath);
// MarkDVo markDVo = new MarkDVo();
// markDVo.setSuccess(0);
// if(StringUtils.isNotBlank(file_name)){
// markDVo.setSuccess(1);
// markDVo.setMessage("上传成功");
// markDVo.setUrl(return_path+File.separator+file_name);
// markDVo.setCallback(callback);
// }
// logger.info("返回值：{}",markDVo);
// return markDVo;
// } catch (IOException e) {
// throw new BusinessException(ResultEnum.SAVE_IMG_ERROE);
// }
// }
//
//
//
/// **
// * 保存文件，直接以multipartFile形式
// * @param multipartFile
// * @param path 文件保存绝对路径
// * @return 返回文件名
// * @throws IOException
// */
// public static String saveImg(MultipartFile multipartFile,String path) throws
// IOException {
// File file = new File(path);
// if (!file.exists()) {
// file.mkdirs();
// }
// FileInputStream fileInputStream = (FileInputStream)
// multipartFile.getInputStream();
// String fileName = Constants.getUUID() + ".png";
// BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path
// + File.separator + fileName));
// byte[] bs = new byte[1024];
// int len;
// while ((len = fileInputStream.read(bs)) != -1) {
// bos.write(bs, 0, len);
// }
// bos.flush();
// bos.close();
// return fileName;
// }