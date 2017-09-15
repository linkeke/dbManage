$(function(){
	articleObj.getArticleInfo();
	$("#saveArticle").bind("click",function(){	
		articleObj.getLayEditContent();
		articleObj.saveData();
	});
});

var layedit;
var index;
var contentArr=[];
var articleImgs = [];
var articleObj = {
		initLayEdit:function(){
			
			layui.use('layedit', function(){
				
		        layedit = layui.layedit
		                ,$ = layui.jquery;
		        layedit.set({
		        	  uploadImage: {
		        	    url: getBasePath()+"/uploadArticleImg" //接口url
		        	    ,type: 'post' //默认post
		        	  }
		        	});
		        //构建一个自定义的编辑器
		        index =  layedit.build('article-content', {
		            tool: ['strong' //加粗
		                   ,'italic' //斜体
		                   ,'del' //删除线
		                   ,'|' //分割线
		                   ,'left' //左对齐
		                   ,'center' //居中对齐
		                   ,'right' //右对齐
		                   ,'link' //超链接
		                   ,'unlink' //清除链接
		                   ,'image' //插入图片
		                   ]
		            ,height: 400
		        });
		        
		        
		    });
		},
		getLayEditContent:function(){
			var tempArr=[];
			var imgArr=[];
			var editContent = $(layedit.getContent(index));
			editContent.each(function(i,ele){
				var content={};
				var txt=$(ele).text();
				if(txt!=""){
					content.content=$(ele).text();
					tempArr.push(content);
				}
				$(ele).find("img").each(function(j,element){
					var imgContent={};
					imgContent.imgUrl=$(element).attr("src");
					imgArr.push(imgContent.imgUrl);
					tempArr.push(imgContent);
				});
			});
			contentArr=tempArr;
			articleImgs = imgArr;
		},
		getArticleInfo:function(){
			var articleId = $("#articleId").val();
			owl.ajaxRequest("/articleDetail",{"articleId":articleId},function(e){
				var contentHtml = e.data.articleDetail.contentHtml;
				$("#article-title").val(e.data.articleDetail.title);
				$("#article-content").html(contentHtml);
				articleObj.initLayEdit();
			});	
		},
		verify:function(){
			var title = $('#article-title').val();
			if(title == ""){
				layer.msg("请填写标题！");
				return false;
			}
			var contentSize = contentArr.length;
			if(contentSize == 0){
				layer.msg("请添加文章内容！");
				return false;
			}
			return true;
		},
		saveData:function(){
			
			if(articleObj.verify()){
				var param = {};
				param.articleId = $("#articleId").val();
				param.title = $('#article-title').val();
				
				param.articleImgs = articleImgs.join("#");
				param.contents = JSON.stringify(contentArr);
				param.contentHtml = layedit.getContent(index);
				
				owl.ajaxRequest("/updateArticle",param,function(e){
					 layer.msg("修改文章成功!");
//					 location.href=getBasePath()+"/article/articleListPage";
				});	
			}
			
			
			
		}
}




