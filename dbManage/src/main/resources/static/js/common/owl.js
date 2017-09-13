var owl={};
function getBasePath(){
	 //获取当前网址，如： http://localhost:8083/proj/meun.jsp  
   var curWwwPath = window.document.location.href;  
   //获取主机地址之后的目录，如： proj/meun.jsp  
   var pathName = window.document.location.pathname;  
   var pos = curWwwPath.indexOf(pathName);  
   //获取主机地址，如： http://localhost:8083  
   var localhostPath = curWwwPath.substring(0, pos);  
   //获取带"/"的项目名，如：/proj  
   var projectName = pathName.substring(0, pathName.substr(1).indexOf('/')+1);  
   return localhostPath + projectName;
};
owl.ajaxRequest=function(requestPath,param,fn){
	 var load=layer.load();
	$.ajax({
		url:getBasePath()+requestPath,
		type:"post",
		dataType:"json",
		data:param,
		success:function(e){			
			layer.close(load);
			if(e.status==10000)
			fn(e);
			if(e.status==10030){
				top.location.href=getBasePath();
			}
		},
		error:function(){
			/*alert("服务器异常");*/
			layer.close(load);
		}
		
	});
};
owl.ajaxRequestContentType=function(requestPath,param,contentType,fn){
	 var load=layer.load();
	$.ajax({
		url:getBasePath()+requestPath,
		type:"post",
		dataType:"json",
		contentType:contentType,
		data:param,
		success:function(e){			
			layer.close(load);
			if(e.status==10000)
			fn(e);
			if(e.status==10030){
				top.location.href=getBasePath()+"/";
			}
		},
		error:function(){
			/*alert("服务器异常");*/
			layer.close(load);
		}
		
	});
};
//打开页面
owl.openPage=function(obj,url,tabName){	
	$(obj).attr("_href",getBasePath()+url);
	$(obj).attr("data-title",tabName);
	  Hui_admin_tab(obj);
};
//关闭页面
owl.closePage=function(){
	removeIframe();
}


