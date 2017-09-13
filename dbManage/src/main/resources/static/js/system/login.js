
$(function(){
	$("#loginBtn").click(function(){
		var account=$.trim($("#account").val());
		var password=$("#password").val();
		loginObject.login(account,password);
	});
	
});

var loginObject={
		login:function(loginName,loginPassword){
			var param = {};
	       param.loginName=loginName;
	       param.loginPassword=loginPassword;
	       $.post(getBasePath()+"/login", param, function(result) {
	          console.log(result);
	          
	          if(result.status == 10000){
	        	  location.href=getBasePath();
	          }else{
	          	layer.msg("用户名或密码错误！")
	          }
	          
	       }, 'json');
		}
};

