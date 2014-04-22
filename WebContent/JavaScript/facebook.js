
window.fbAsyncInit = function() {
	FB.init({
		appId : '241385782733686',
		status : true,
		cookie : true,
		xfbml : true
	});

	
	
	var auth_response_change_callback = function(response) {
	  console.log("auth_response_change_callback");
	  console.log(response);
	  
	  if (response.status === 'connected') {  
		var uid = response.authResponse.userID;
		post_to_url('/Facebooklogin', {FBuid:uid});
	  }else{
		  
	  }
	};

	var auth_status_change_callback = function(response) {
	  console.log("auth_status_change_callback: " + response.status);
	};
	
	
	FB.Event.subscribe('auth.login', auth_response_change_callback);
	FB.Event.subscribe('auth.statusChange', auth_status_change_callback);
	
	
	
	
	function post_to_url(path, params, method) {
	    method = method || "post"; // Set method to post by default if not specified.

	    // The rest of this code assumes you are not using a library.
	    // It can be made less wordy if you use one.
	    var form = document.createElement("form");
	    form.setAttribute("method", method);
	    form.setAttribute("action", path);

	    for(var key in params) {
	        if(params.hasOwnProperty(key)) {
	            var hiddenField = document.createElement("input");
	            hiddenField.setAttribute("type", "hidden");
	            hiddenField.setAttribute("name", key);
	            hiddenField.setAttribute("value", params[key]);

	            form.appendChild(hiddenField);
	         }
	    }

	    document.body.appendChild(form);
	    form.submit();
	}
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/all.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));