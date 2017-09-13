package com.demoba.manage.web.article.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.demoba.manage.web.article.service.FileService;
import com.owl.common.content.Global;
import com.owl.common.content.Status;
import com.owl.common.oss.util.OSSUtil;
import com.owl.common.util.FileUtil;
import com.owl.common.util.Help;
import com.owl.common.util.MUtil;
import com.owl.common.util.Result;

@Service
public class FileServiceImpl implements FileService {
	private static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
	
	@Value("${tempPath}")
	private String tempPath;
	
	public Result uploadOSSFile(MultipartFile file,String remotePath)
			throws Exception {
		
		Result result = new Result();
		String filename = file.getOriginalFilename();
		
		if(Help.isNull(filename)){
			   result.setStatus(Status.file_empty_status);
			   result.setInfo(Status.file_empty_info);
			   return result;
		}
		String suffixStr = filename.substring(filename.lastIndexOf("."));
		
		if(!".jpg".equalsIgnoreCase(suffixStr)&&!".jpeg".equalsIgnoreCase(suffixStr)&&!".png".equalsIgnoreCase(suffixStr)&&!".gif".equalsIgnoreCase(suffixStr)){
			log.info("图片文件格式错误");
			result.setStatus(Status.img_type_error_status);
			result.setInfo(Status.img_type_error_info);
		}else{
			String newFileName = MUtil.uuid();
			
			String filePath="";
			File localFile = null;
			try {
				localFile = new File(tempPath);
				if(!localFile.exists()){
					localFile.mkdirs();
				}
				String localPath=tempPath+File.separator+newFileName+suffixStr;
				file.transferTo(new File(localPath));
				//tempPath = uploadFile(file, filename);
				filePath = OSSUtil.uploadFile(localPath, remotePath);
				result.setStatus(Status.success_status);
		        result.setInfo(Status.success_info);
				Map<String,Object> data = new HashMap<String, Object>();
				data.put("filePath", filePath);
				result.setData(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result.setStatus(Status.upload_error_status);
				result.setInfo(Status.upload_error_info);
				return result;
			}finally{
				//删除本地临时文件
				localFile.delete();
			}
	    	log.info("上传文件成功");
		}	
		
		return result;
	}

	@Override
	public void downLoadFile(String filename, String filetype,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private String uploadFile(MultipartFile file,String filename) throws Exception{
		String filePath="";
		InputStream is= file.getInputStream();
        CommonsMultipartFile cf= (CommonsMultipartFile)file; 
        DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
        File f = fi.getStoreLocation();
        FileUtil fileUtil = new FileUtil();
        /*if(FinVal.FILE_TYPE_HEAD.equals(fileType)){
        fileUtil.saveFileToTemp(is,filename,Global.HEAD_IMG_PATH);
        }else if(FinVal.FILE_TYPE_BP.equals(fileType)){
        fileUtil.saveFileToTemp(is,filename,Global.BP_FILE_PATH);	
        }else if(FinVal.FILE_TYPE_INDUSTRY.equals(fileType)){
        fileUtil.saveFileToTemp(is,filename,Global.INDUSTRY_IMG_PATH);	
        }else if(FinVal.FILE_TYPE_LICENSE.equals(fileType)){
        fileUtil.saveFileToTemp(is,filename,Global.LICENSE_FILE_PATH);	
        }else if(FinVal.FILE_TYPE_IDENTIFY.equals(fileType)){
        fileUtil.saveFileToTemp(is,filename,Global.IDENTIFY_FILE_PATH);	
        }else if(FinVal.FILE_TYPE_BPIMG.equals(fileType)){
        fileUtil.saveFileToTemp(is,filename,Global.BP_IMG_PATH);	
        }else{
        	throw new Exception("文件类型错误！！");
        }*/
        fileUtil.saveFileToTemp(is,filename,Global.TEMP_FILE_PATH);
       // filePath=Global.DOWNLOAD_URL+"?filename="+fileUtil.getLastFileName()+"&filetype="+fileType;
        filePath= fileUtil.getFilePath();
        return filePath;
	}
	
	
//	 @Bean(name = "multipartResolver")
//     public MultipartResolver multipartResolver(){
//      CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//      resolver.setDefaultEncoding("UTF-8");
//      resolver.setResolveLazily(true);//resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
//      resolver.setMaxInMemorySize(40960);
//      resolver.setMaxUploadSize(50*1024*1024);//上传文件大小 50M 50*1024*1024
//      return resolver;
//  }   
}
