function kustutaKommentaar(kommentaarId, uudisId) {
	var params = "kId="+kommentaarId+"&uudisId="+uudisId;
	
	var xmlrequest;
	if (window.XMLHttpRequest) {
		xmlrequest = new XMLHttpRequest();
	} else {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlrequest.onreadystatechange = function() {
		if (xmlrequest.readyState==4 && xmlrequest.status==200) {
			// Kustuta kommentaar ekraanilt
			var blockQuote = document.getElementById("kommentaar-"+kommentaarId).parentNode;
			blockQuote.parentNode.removeChild(blockQuote);
		}
	};
	
	xmlrequest.open("POST", "kustuta-kommentaar", true);
	xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlrequest.send(params);
};
