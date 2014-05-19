function postitaUudis() {
	var uudis = document.getElementById("uudise-vorm");
	
	var pealkiri = uudis.elements[0].value;
	var piltUrl = uudis.elements[1].value;
	var tekst = uudis.elements[2].value;
	var tagid = uudis.elements[3].value;
	
	var params = "pealkiri="+pealkiri+"&pilt="+piltUrl+"&tekst="+tekst+"&uudise-tagid="+tagid;
	//var params = "pealkiri="+pealkiri+"&pilt="+pilt;
	
	var httprequest;
	if (window.XMLHttpRequest) {
		httprequest = new XMLHttpRequest();
	} else {
		httprequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	httprequest.onreadystatechange = function() {
		if (httprequest.readyState==4 && httprequest.status==200) {
			document.getElementById("info").innerHTML = "Kõik läks hästi! :)";
			// Pöördub servleti poole, mis viib äsja postitatud uudise lehele
			var id = httprequest.responseText;
			document.location.href='uudis?uudisId=' + id;
	    } else if (httprequest.readyState==4) {
	    	clearTimeout(t);
	    	document.getElementById("info").innerHTML = "Üleslaadimine ebaõnnestus :(. Status: " + httprequest.status;
	    };
	  };
	
	httprequest.open("POST", "postita-uudis", true);
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send(params);
	
	// Nüüd võiks mingi loading värgi teha lehele
	document.getElementById("info").innerHTML = "Laen üles...";
	var t = window.setTimeout(timeOut, 5000);
};

function timeOut() {
	document.getElementById("info").innerHTML = "Palun kontrollige oma internetiühendust.";
};