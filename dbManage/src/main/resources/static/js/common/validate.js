var validate = {
		validatemobile:function(str){
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
			if(!myreg.test(str)) 
			{ 
			    return false; 
			} 
		}
		
}
