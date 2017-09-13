package com.demoba.manage.web.article.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import com.owl.common.util.Result;

public interface FileService {
	
	/**
	 * 下载文件
	 * */
	public void downLoadFile(String filename,String filetype,HttpServletRequest request,
			HttpServletResponse response);
	
	public Result uploadOSSFile(MultipartFile file,String remotePath)throws Exception;
}
