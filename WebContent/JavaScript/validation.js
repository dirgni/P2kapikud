$(document).ready(function(){

	$("#rss_name").blur(function(){
		nameValidate($("#rss_name"));
	});
	
	$("#rss_email").blur(function(){
		emailValidate($("#rss_email"));
	});
	
	$("#meldi_user").blur(function(){
		userValidate($("#meldi_user"));
	});
	
	$("#meldi_password").blur(function(){
		passwordValidate($("#meldi_password"));
	});
	
	
	function nameValidate(name){
		var text = name.val();
		var filter = /^([a-zA-Z\-])+\ ([a-zA-Z\-])+$/;
		
		if(!filter.test(text)){
			name.removeClass();
			name.addClass("invalid");
			name.val("");
		}else{
			name.removeClass();
			name.addClass("valid");
		}
		
	}
	
	function userValidate(user){
		var text = user.val();
		var filter = /^([a-zA-Z0-9_])+$/;
		
		if(!filter.test(text)){
			user.removeClass();
			user.addClass("invalid");
		}else{
			user.removeClass();
			user.addClass("valid");
		}
	}
	
	function passwordValidate(password){
		var text = password.val();
		var filter = /^([a-zA-Z0-9])+$/;
		if(!filter.test(text)){
			password.removeClass();
			password.addClass("invalid");
		}else{
			password.removeClass();
			password.addClass("valid");
		}
	}
	
	function emailValidate(email){
		var text=email.val();
		
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		if(!filter.test(text)){
			email.removeClass();
			email.addClass("invalid");
		}else{

			email.removeClass();
			email.addClass("valid");
		}
	}
});


