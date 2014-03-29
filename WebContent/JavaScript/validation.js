$(document).ready(function(){

	$("#rss_name").blur(function(){
		
	});
	
	$("#rss_email").blur(function(){
		emailValidate($("#rss_email"));
	});
	
	
	$("#meldi_user").blur(function(){
		
	});
	
	$("#meldi_password").blur(function(){
		
	});

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


