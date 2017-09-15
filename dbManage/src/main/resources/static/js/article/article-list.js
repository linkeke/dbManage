
$(function(){
	articleListObj.getDataList(page);
	articleListObj.scrollList();
	
	
	$("#addBtn").click(function(){
		var addArticleIndex = layer.open({
			  type: 2, //page层
			  area: ['800px', '800px'],
			  maxmin: true,
			  title: '添加文章',
			  shade: 0.6, //遮罩透明度
			  moveType: 1, //拖拽风格，0是默认，1是传统拖动
			  shift: 1, //0-6的动画形式，-1不开启
			  content: getBasePath()+"/articleAddPage"
			}); 
		layer.full(addArticleIndex);
	});
	
});

var page=1;
var pageSize=10;
var pageCount=1;
var articleListObj = {	
		getDataList:function(page){
			var param = {};
			param.page = page;
			param.pageSize = pageSize;
			
			owl.ajaxRequest("/articleList",param,function(e){
//				 console.log(JSON.stringify(e));
				 pageCount=e.data.pageCount;				
				 $("#articleListTemplate").tmpl( e.data ).appendTo("#articleList");
				 articleListObj.articleInfoPage();
				 articleListObj.articleEditClick();
				 articleListObj.articleDelClick();
			});	
		},
		articleInfoPage:function(){
			 $(".intro,.article-intro").click(function(){		
					event.preventDefault();
					event.stopPropagation();
					var articleId = $(this).attr("articleId");
					var editArticleIndex = layer.open({
						  type: 2, //page层
						  area: ['800px', '800px'],
						  maxmin: true,
						  title: '文章详情',
						  shade: 0.6, //遮罩透明度
						  moveType: 1, //拖拽风格，0是默认，1是传统拖动
						  shift: 1, //0-6的动画形式，-1不开启
						  content: getBasePath()+"/articleInfoPage?articleId="+articleId
						}); 
					layer.full(editArticleIndex);
				});
		},
		articleEditClick:function(){
			
			$(".article-edit").unbind().click(function(){
				event.preventDefault();
				event.stopPropagation();
				var articleId = $(this).attr("articleId");
				var editArticleIndex = layer.open({
					  type: 2, //page层
					  area: ['800px', '800px'],
					  maxmin: true,
					  title: '修改文章',
					  shade: 0.6, //遮罩透明度
					  moveType: 1, //拖拽风格，0是默认，1是传统拖动
					  shift: 1, //0-6的动画形式，-1不开启
					  content: getBasePath()+"/updateArticlePage?articleId="+articleId
					}); 
				layer.full(editArticleIndex);
			});
			
		},
		articleDelClick:function(){
			$(".article-del").unbind().click(function(event){
				event.preventDefault();
				event.stopPropagation();
				var articleId = $(this).attr("articleId");
				
				var confirmIndex = layer.confirm('您确定要删除？', {
					  btn: ['确定','取消'] //按钮
					}, function(){
						owl.ajaxRequest("/delArticle",{"articleId":articleId},function(e){
//							 console.log(JSON.stringify(e));
							location.href=getBasePath()+"/articleListPage";
							layer.close(confirmIndex);
						});	

					}, function(){
						layer.close(confirmIndex);
					});
			});
		},
		scrollList:function(){
			$(window).scroll(function(){                
		        var scrollh = $(document).height();  
		        var scrollTop=Math.max(document.documentElement.scrollTop||document.body.scrollTop);  
		        if((scrollTop + $(window).height()) >= (scrollh-1)){  
		        	page=page+1;
		        	if(page<=pageCount){
		        		articleListObj.getDataList(page);
		        	}else{
		        		layer.msg("没有更多内容了");
		        	}
		        }  
		    });  
		}
}




