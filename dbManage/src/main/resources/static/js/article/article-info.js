
$(function(){
	var articleId = $("#articleId").val();
	articleInfoObj.getArticleInfo();
	articleInfoObj.scrollList(articleId);
});

var countText = "";
var page=1;
var pageSize=10;
var pageCount=1;
var articleInfoObj = {			
		getArticleInfo:function(){
			var articleId = $("#articleId").val();
			owl.ajaxRequest("/articleDetail",{"articleId":articleId},function(e){
				
				$("#article-title").html(e.data.articleDetail.title);
				$("#article-time").html(e.data.articleDetail.createDate);
				
				var content = JSON.parse(e.data.articleDetail.content); 
				for(var j = 0 ;j<content.length;j++){
					var imgUrl = content[j].imgUrl;
					var con = content[j].content;
					var img=$('<img  src="'+imgUrl+'"/>');
					var p = $('<p>'+con+'</p>');
					var htmlStr=$('<div> </div>');
				
					if(typeof imgUrl == 'undefined'){
						img=$('');
					}
					if(typeof con == 'undefined'){
						p = $('<p></p>');
					}
					htmlStr.append(img);
					htmlStr.append(p);
					$(htmlStr).appendTo($("#article-content"));				
				}	
				
			
			});	
		},
		scrollList:function(articleId){
			$(window).scroll(function(){                
		        var scrollh = $(document).height();  
		        var scrollTop=Math.max(document.documentElement.scrollTop||document.body.scrollTop);  
		        if((scrollTop + $(window).height()) >= scrollh){  
		        	page=page+1;
		        	if(page<=pageCount){
		        		articleInfoObj.getCommentList(articleId);
		        	}else{
		        		layer.msg("没有更多内容了");
		        	}
		        	
		        }  
		    });  
		}
}




