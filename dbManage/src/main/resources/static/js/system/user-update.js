$(function(){
	userUpdateObj.init();
	$("#updateBtn").unbind().click(function(){
		userUpdateObj.updateUser();
	});
});

var userUpdateObj = {
		init:function(){
			owl.ajaxRequest("/allGroups","",function(e){
				$("#group-select").empty("");
				$("#groupListTemplate").tmpl( e.data ).appendTo("#group-select");	
				$("#group-select").val($("#groupId").val());
			});	
		},
		verification:function(){
			var userName = $("#userName").val();
			var password = $("#password").val();		
			var comfirmpassword = $("#comfirmpassword").val();
			var groupId = $("#group-select").val();
			if(userName == ""){
				layer.msg('账号不允许为空！');
				return false;
			}
			if(password == ""){
				layer.msg('密码不允许为空！');
				return false;
			}
			if(comfirmpassword == ""){
				layer.msg('确认密码还没有填写！');
				return false;
			}
			
			if(groupId == "" || groupId == null){
				layer.msg('用户所属角色还没有选择！');
				return false;
			}
			
			return true;
		},
		getSaveUserData:function(){
			var userId = $("#userId").val();
			var userName = $("#userName").val();
			var password = $("#password").val();		
			var comfirmpassword = $("#comfirmpassword").val();		
			var groupId = $("#group-select").val();
			
			var param = {};
			param.userId= userId;
			param.userAccount= userName;
			param.password= password;
			param.confirmPassword= comfirmpassword;
			param.roleCodes= groupId;
			return param;
		},
		updateUser:function(){
			if(userUpdateObj.verification()){
				var param = userUpdateObj.getSaveUserData();		
				owl.ajaxRequest("/modifyAdmin",param,function(e){
//					console.log(e);
					layer.msg(e.info);
	    			window.top.location=getBasePath()+"/adminListPage"; 
				});	
			}
		}
}