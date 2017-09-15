package com.demoba.manage.web.article.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.demoba.manage.web.article.model.ArticleListModel;
import com.demoba.manage.web.article.model.ArticleModel;
import com.demoba.manage.web.article.service.ArticleService;
import com.demoba.manage.web.article.service.FileService;
import com.owl.common.content.FinVal;
import com.owl.common.log.BKLogger;
import com.owl.common.util.LayUIResultUtil;
import com.owl.common.util.LayUploadResult;
import com.owl.common.util.Result;

@Controller
public class ArticleController {
	BKLogger logger = BKLogger.getLogger(ArticleController.class);
	private static final Logger log= LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/articleListPage")
    public String articleListPage() {
        return "article/article-list";
    }
	
	@RequestMapping("/articleAddPage")
    public String articleAddPage() {
        return "article/article-add";
    }
	
	@RequestMapping("/articleList")
	@ResponseBody
	 public Object articleList(HttpServletRequest request,Model model,Integer page,Integer pageSize){
		 Result result = null;
		 try{
			 result = articleService.articleList(page, pageSize);
		 }catch(Exception ex){
			 log.error("业务咨询列表查询失败", ex);
			 result = new Result ();
		 }
		  return logger.infobk("业务咨询列表查询", result);		 
	 }
	 
	 @RequestMapping("/addArticle")
	 @ResponseBody
	 public Object addArticle(HttpServletRequest request,Model model,ArticleModel articleModel){
		 Result result = null;
		 try{
			 result = articleService.addArticle(articleModel);
		 }catch(Exception ex){
			 log.error("保存新闻失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("保存新闻", result);	 
	 }
	 
	 @RequestMapping("/updateArticle")
	 @ResponseBody
	 public Object updateArticle(HttpServletRequest request,Model model,ArticleModel articleModel){
		 Result result = null;
		 try{
			 result = articleService.updateArticle(articleModel);
		 }catch(Exception ex){
			 log.error("更新新闻失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("更新新闻", result);		 
	 }
	 
	 @RequestMapping(value = "/uploadArticleImg.do",method=RequestMethod.POST)	
	 @ResponseBody
	 public Object uploadArticleImg(@RequestParam("file") MultipartFile file,HttpServletRequest request, Model model){
		 Result result=null;
		 try{
			 result = fileService.uploadOSSFile(file,FinVal.ARTICLE);		
		 }catch(Exception ex){
			 log.error("上传文章图片失败！");
			 log.error("上传文章图片失败！", ex);
			 result=new Result(); 
		 }
		 LayUploadResult layUploadResult = LayUIResultUtil.convertResult(result);
		 return logger.infobk("上传文章图片", layUploadResult);
	 }
	 
	 @RequestMapping("/articleInfoPage")	 
	 public String articleInfoPage(HttpServletRequest request,Model model,Long articleId){		 		 		
		 model.addAttribute("articleId", articleId);
	     return "article/article-info";	 	
	 }
	 
	 @RequestMapping("/articleDetail")
	 @ResponseBody
	 public Object articleDetailController(HttpServletRequest request,Model model,String accesstoken,Long articleId){
		 Result result = null;
		 try{
			 result= articleService.articleDetail(articleId);
		 }catch(Exception ex){
			 log.error("查询文章详情失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("查询文章详情输出列表", result);
	 }
	 
	 @RequestMapping("/updateArticlePage")	 
	 public String updateArticlePage(HttpServletRequest request,Model model,Long articleId){		 
		 model.addAttribute("articleId", articleId);
		 return "article/article-update";	 
	 }
	 
	 @RequestMapping("/delArticle")
	 @ResponseBody
	 public Object delArticleController(HttpServletRequest request,Model model,Long articleId){
		 Result result = null;
		 try{
			 result = articleService.delArticle(articleId);
		 }catch(Exception ex){
			 log.error("删除新闻失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("删除新闻", result);	 
	 }
	
}
