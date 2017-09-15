package com.demoba.manage.web.article.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoba.manage.web.article.dto.ArticleDetailDto;
import com.demoba.manage.web.article.dto.ArticleListDto;
import com.demoba.manage.web.article.model.ArticleModel;
import com.demoba.manage.web.article.service.ArticleService;
import com.demoba.manage.web.dao.ArticleMapper;
import com.demoba.manage.web.dao.UserMapper;
import com.demoba.manage.web.entity.Article;
import com.owl.common.content.FinVal;
import com.owl.common.content.Status;
import com.owl.common.util.GsonUtil;
import com.owl.common.util.Help;
import com.owl.common.util.MUtil;
import com.owl.common.util.Paginator;
import com.owl.common.util.Result;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	private static final Logger log= LoggerFactory.getLogger(ArticleServiceImpl.class);
	  @Autowired
	  private ArticleMapper articleMapper;
	  
	  @Autowired
	  private UserMapper userMapper;
	
	  
	  
	  @Override
		public Result articleList(Integer page, Integer pageSize) {
			// TODO Auto-generated method stub
			Result result = new Result();
			log.debug("查询新闻列表开始。。。");
			
			Map<String,Object> data = findArticles(page, pageSize);
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			result.setData(data);
			return result;
		
		}
		
		private Map<String,Object> findArticles(Integer page,Integer pageSize){
			page=page==null?FinVal.DEFAULT_PAGE:page;
			pageSize=pageSize==null?FinVal.DEFAULT_PAGESIZE:pageSize;
			Map<String,Object> data=new HashMap<String,Object>();
			List<ArticleListDto> articleListDtos= new ArrayList<ArticleListDto>();
			Map<String, Object> param = new HashMap<String,Object>();
			int countByParam = articleMapper.countByParam(param);
			Paginator paginator = new Paginator(0, pageSize);
			paginator.gotoPage(page);
			int pageCount = paginator.calcPageCount(countByParam); // 总页数
			
			param.put("startRow", paginator.getStartRow());
			param.put("pageSize", paginator.getPageSize());
			List<Article> list = articleMapper.findByParam(param);
			if(Help.isNotNull(list)){
				for(Article article:list){
					articleListDtos.add(convertArticleDto(article));
				}
			}
			data.put("dataList", articleListDtos);
			data.put("page", page);
			data.put("pageSize", pageSize);
			data.put("pageCount", pageCount);
			return 	data;
		}
		private ArticleListDto convertArticleDto(Article article){
			ArticleListDto articleListDto = new ArticleListDto();
			Long userId = article.getnCreateId();
			articleListDto.setUserId(userId);
			articleListDto.setArticleId(article.getnArticleId());
			articleListDto.setArticleTitle(article.getcArticleTitle());
			articleListDto.setImgs(MUtil.convertStringToList(article.getcArticleImgs()));
			
			//文章图片
			String[] split = article.getcArticleImgs().split("#");
			articleListDto.setArticleImg(split[0]);
			
			articleListDto.setPublisTime(article.gettCreateTime());
			articleListDto.setTagName(article.getcArticleTag());
			String articleContent = article.getcArticleContent();
			String shortContent="";
			if(Help.isNotNull(articleContent)){
				List<Map<String,String>> list = (List<Map<String,String>>) GsonUtil.jsonToObject(articleContent, List.class);
				
				if(Help.isNotNull(list)){
					StringBuffer contentBuf=new StringBuffer();
					for(Map<String,String> map :list){
						String content = map.get("content");
						if(Help.isNotNull(content))
						contentBuf.append(content);
					}
					String txtcontent =contentBuf.toString();
			        if(txtcontent.length()>100){
			        	shortContent=txtcontent.substring(0, 100);
			        }else{
			        	shortContent=txtcontent;
			        }
				}
				
			}
			articleListDto.setShortContent(shortContent);
			return articleListDto;
		}


		@Override
		public Result addArticle(ArticleModel articleModel) {

			// TODO Auto-generated method stub
			Result result = new Result();
			log.info("发布文章，开始。。。");		
			
			if(Help.isNull(articleModel.getContents())){
				log.info("文章内容为空！");
				result.setStatus(Status.newsintro_empty_error_status);
				result.setInfo(Status.newsintro_empty_error_info);
				return result;
			}
			Article record = new Article();
			record.setcArticleContent(articleModel.getContents());
			record.setcContentHtml(articleModel.getContentHtml());
			record.setcArticleImgs(articleModel.getArticleImgs());
			
			Date now = new Date();
			record.settCreateTime(now);
			record.settUpdateTime(now);
			record.setcArticleTitle(articleModel.getTitle());
			articleMapper.insertSelective(record);
			
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			return result;
		
		}

		@Override
		public Result updateArticle(ArticleModel articleModel) {
			// TODO Auto-generated method stub
			Result result = new Result();
			log.info("修改文章，开始。。。");
			if(Help.isNull(articleModel.getContents())){
				log.info("文章内容为空！");
				result.setStatus(Status.newsintro_empty_error_status);
				result.setInfo(Status.newsintro_empty_error_info);
				return result;
			}
			Article article = articleMapper.selectByPrimaryKey(articleModel.getArticleId());
			if(Help.isNull(article)){
				result.setStatus(Status.news_notexist_error_status);
				result.setInfo(Status.news_notexist_error_info);
				return result;
			}
			article.setcArticleContent(articleModel.getContents());
			article.setcContentHtml(articleModel.getContentHtml());
			article.setcArticleImgs(articleModel.getArticleImgs());
			Date now = new Date();
			article.settUpdateTime(now);
			article.setcArticleTitle(articleModel.getTitle());
			
			articleMapper.updateByPrimaryKeySelective(article);
			
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			return result;
		}

		@Override
		public Result articleDetail(Long articleId) {

			// TODO Auto-generated method stub
			Result result = new Result();
			if(Help.isNull(articleId)){
				log.info("articleId为空");
				result.setStatus(Status.article_not_exist_status);
				result.setInfo(Status.article_not_exist_info);
				return result;
			}
			Article article = articleMapper.selectByPrimaryKey(articleId);
			if(Help.isNull(article)){
				log.info("article不存在");
				result.setStatus(Status.article_not_exist_status);
				result.setInfo(Status.article_not_exist_info);
				return result;
			}
			
			ArticleDetailDto articleDetailDto = new ArticleDetailDto();
			articleDetailDto.setArticleId(articleId);
			articleDetailDto.setContent(article.getcArticleContent());
			articleDetailDto.setContentHtml(article.getcContentHtml());
			articleDetailDto.setCreateDate(article.gettCreateTime());
			articleDetailDto.setTitle(article.getcArticleTitle());
			
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("articleDetail", articleDetailDto);
			result.setData(data);
			return result;
		
		}

		@Override
		public List<ArticleListDto> webArticleList() {
			List<ArticleListDto> articleListDtos= new ArrayList<ArticleListDto>();
			Map<String, Object> param = new HashMap<String,Object>();
			
			param.put("startRow", 0);
			param.put("pageSize", 3);
			List<Article> list = articleMapper.findByParam(param);
			if(Help.isNotNull(list)){
				for(Article article:list){
					articleListDtos.add(convertArticleDto(article));
				}
			}
			return articleListDtos;
		}

		@Override
		public Result delArticle(Long articleId) {
			Result result = new Result();
			if(Help.isNull(articleId)){
				log.info("article不存在");
				result.setStatus(Status.article_not_exist_status);
				result.setInfo(Status.article_not_exist_info);
				return result;
			}
			articleMapper.deleteByPrimaryKey(articleId);
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			return result;
		}

}
