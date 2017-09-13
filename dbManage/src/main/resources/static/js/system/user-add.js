$(function(){
	userAddObj.init();
	$("#addBtn").unbind().click(function(){
		userAddObj.saveUser();
	});
});

var userAddObj = {
		init:function(){
		
			owl.ajaxRequest("/allGroups","",function(e){
				$("#group-select").empty("");
				$("#groupListTemplate").tmpl( e.data ).appendTo("#group-select");	
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
			
			if(password != comfirmpassword){
				layer.msg('确认密码跟密码不一致，请重新输入！');
				return false;
			}
			
			if(groupId == "" || groupId == null){
				layer.msg('用户所属角色还没有选择！');
				return false;
			}
			
			return true;
		},
		getSaveUserData:function(){
			var userName = $("#userName").val();
			var password = $("#password").val();		
			var comfirmpassword = $("#comfirmpassword").val();		
			var groupId = $("#group-select").val();
			
			var param = {};
			param.userAccount= userName;
			param.password= password;
			param.confirmPassword= comfirmpassword;
			param.roleCodes= groupId;
			return param;
		},
		saveUser:function(){
			if(userAddObj.verification()){
				var param = userAddObj.getSaveUserData();		
//				console.log(param);
				owl.ajaxRequest("/addAdmin",param,function(e){
//					console.log(e);
					layer.msg(e.info);
	    			window.top.location=getBasePath()+"/adminListPage"; 
				});	
			}
		}
}