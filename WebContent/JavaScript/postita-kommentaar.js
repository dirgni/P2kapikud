function postitaKommentaar() {
	var nimi = document.getElementById("kommentaar-nimi").value;
	var tekst = document.getElementById("kommentaar-sisu").value;
	var uudisId = document.getElementById("uudis-id").value;

	var params = "Nimi="+nimi+"&content="+tekst+"&uudisId="+uudisId;
	
	var xmlrequest;
	if (window.XMLHttpRequest) {
		xmlrequest = new XMLHttpRequest();
	} else {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlrequest.onreadystatechange = function() {
		if (xmlrequest.readyState==4 && xmlrequest.status==200) {
			clearTimeout(t);
			document.getElementById("kommentaar-vorm").reset();
			document.getElementById("postitamine-info").innerHTML = "";
	    } else if (xmlrequest.readyState==4) {
	    	clearTimeout(t);
	    	document.getElementById("postitamine-info").innerHTML = "<br>Kommenteerimine ebaõnnestus :(. Status: " + xmlrequest.status;
	    }
	  };
	
	xmlrequest.open("POST", "postita-kommentaar", true);
	xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlrequest.send(params);
	
	// Nüüd võiks mingi loading värgi teha lehele
	document.getElementById("postitamine-info").innerHTML = "<br>Postitan kommentaari...";
	var t = window.setTimeout(timeOut, 10000);
};

function timeOut() {
	document.getElementById("postitamine-info").innerHTML = "Palun kontrollige oma internetiühendust.";
};