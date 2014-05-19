if (window.EventSource) {
	var uudisId = getURLParameter("uudisId");
	var eventSource = new EventSource('KommentaarFeed?uudisId=' + uudisId);
	eventSource.onmessage = function(e) {
		var k = JSON.parse(e.data);
		var blockQuote = document.createElement("blockquote");
		var kommDiv = document.createElement("div");
		kommDiv.setAttribute("class", "kommentaar");
		kommDiv.setAttribute("id", "kommentaar-"+k[0].id);
		blockQuote.appendChild(kommDiv);
		var spanAeg = document.createElement("span");
		spanAeg.setAttribute("class", "kommentaar-aeg");
		spanAeg.appendChild(document.createTextNode(k[0].kell + " " + k[0].kuupäev));
		kommDiv.appendChild(spanAeg);
		var spanAutor = document.createElement("span");
		spanAutor.setAttribute("class", "kommentaar-autor");
		spanAutor.appendChild(document.createTextNode(k[0].nimi));
		kommDiv.appendChild(spanAutor);
		var blockSisu = document.createElement("blockquote");
		blockSisu.setAttribute("class", "kommentaar-sisu");
		blockSisu.appendChild(document.createTextNode(k[0].tekst));
		kommDiv.appendChild(blockSisu);
		
		var kommList = document.getElementById("uudise-kommentaar-list");
		kommList.insertBefore(blockQuote, kommList.childNodes[0]);
	};
} else {
	//poll
}

function getURLParameter(name) {
	return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
}