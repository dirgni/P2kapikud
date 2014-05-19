function preview(uudisId) {
	var params = "uudisId="+uudisId;
	
	var xmlrequest;
	if (window.XMLHttpRequest) {
		xmlrequest = new XMLHttpRequest();
	} else {
		xmlrequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlrequest.onreadystatechange = function() {
		if (xmlrequest.readyState==4 && xmlrequest.status==200) {
			// Kustuta tr, mille id on active-preview
			var oldPreview = document.getElementById("active-preview");
			if (oldPreview !== null) {
				oldPreview.parentNode.removeChild(oldPreview);
			}
			
			// Lisa tr id-ga active-preview, kus on uudise tekst
			var tr = document.getElementById("uudisId-"+uudisId);
			
			var newTR = document.createElement("tr");
			newTR.setAttribute("id", "active-preview");
			newTR.appendChild(document.createElement("td"));
			newTR.appendChild(document.createElement("td"));
			
			var tdPreview = document.createElement("td");
			tdPreview.appendChild(document.createTextNode(xmlrequest.responseText));
			newTR.appendChild(tdPreview);
			
			newTR.appendChild(document.createElement("td"));
			// Paneme pärast antud uudist selle nüüd sinna DOMi
			tr.parentNode.insertBefore(newTR, tr.nextSibling);
			
			// Muudame hashi URLil
			window.location.hash = uudisId;
		}
	};
	
	xmlrequest.open("POST", "uudis-preview", true);
	xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlrequest.send(params);
}