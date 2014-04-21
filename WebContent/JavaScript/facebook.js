window.fbAsyncInit = function() {
	FB.init({
		appId : '{241385782733686}',
		status : true,
		cookie : true,
		xfbml : true
	});
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=241385782733686";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));