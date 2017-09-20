$(function(){
	businessList.getbusinessList(coursePage,coursePageSize);
});

var coursePage=1;
var coursePageSize=10;
var coursePageCount=1;
var businessList = {
		getbusinessList:function(page,pageSize){
			var param={};
			param.page=page;
			param.pageSize=pageSize;
			owl.ajaxRequest("/businessList",param,function(e){
//				console.log(e);
				coursePageCount = e.data.pageCount;
				$("#course-div").empty("");
				$("#courseListTemplate").tmpl( e.data ).appendTo("#course-div");	
				
				layui.use(['laypage', 'layer'], function(){
					  var laypage = layui.laypage
					  ,layer = layui.layer;
					  
					  laypage({
						    cont: 'coursepage'
						    ,pages: coursePageCount //总页数
						    ,groups: 5 //连续显示分页数
						    ,curr: page || 1, 
						    jump: function(e, first){ //触发分页后的回调			    	
						        if(!first){ //一定要加此判断，否则初始时会无限刷新
						        	var pageNow = e.curr;					        	
						        	businessList.getbusinessList(pageNow,coursePageSize);
						        }
						    }
						  });
					});
			});	
			
		}
}