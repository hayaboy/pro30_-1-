package com.myspring.pro30.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myspring.pro30.common.file.FileDownloadController;

import net.coobird.thumbnailator.Thumbnails;



@Controller
public class FileDownloadController {
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	
	@RequestMapping("/download.do")
	protected void download(@RequestParam("imageFileName") String imageFileName,@RequestParam("articleNO") String articleNO,
            HttpServletResponse response) throws Exception {
		
		OutputStream out = response.getOutputStream();
		String downFile = ARTICLE_IMAGE_REPO + "\\" +  articleNO  + "\\" + imageFileName;
		
		logger.debug(downFile);
		
		File file = new File(downFile);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
		
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer); 
			if (count == -1) 
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
	
	
	//thumbnail
//	@RequestMapping("/download")
//	protected void download(@RequestParam("imageFileName") String imageFileName,
//            HttpServletResponse response) throws Exception {
//		
//		OutputStream out = response.getOutputStream();
//		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
//		
//		logger.info(filePath);
//		
//		File image = new File(filePath);
//		int lastIndex = imageFileName.lastIndexOf(".");
//		System.out.println(lastIndex);
//		
//		String fileName = imageFileName.substring(0,lastIndex);
//		logger.info(fileName);
//		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".png");
//		if (image.exists()) { 
////			thumbnail.getParentFile().mkdirs();
//		    Thumbnails.of(image).size(50,50).outputFormat("png").toOutputStream(out);
//		}else {
//			return;
//		}
//		
////		FileInputStream in = new FileInputStream(thumbnail);
//		byte[] buffer = new byte[1024 * 8];
////		while (true) {
////			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
////			if (count == -1) // 버퍼의 마지막에 도달했는지 체크
////				break;
////			out.write(buffer, 0, count);
////		}
//		
//		out.write(buffer);
//		out.close();
//	}
}
