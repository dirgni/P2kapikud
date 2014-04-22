if (window.EventSource) {
	var eventSource = new EventSource('TabelFeed');
	eventSource.onmessage = function(e) {
		var uudis = JSON.parse(e.data);
		
		var tabel = document.getElementById("uudised_tabelis");
		var newRow = document.createElement("tr");
		var tdKuupäev = document.createElement("td");
		tdKuupäev.appendChild(document.createTextNode(uudis[0].kuupäev));
		newRow.appendChild(tdKuupäev);
		var tdKell = document.createElement("td");
		tdKell.appendChild(document.createTextNode(uudis[0].kell));
		newRow.appendChild(tdKell);
		var tdPealkiri = document.createElement("td");
		var aPealkiri = document.createElement("a");
		aPealkiri.appendChild(document.createTextNode(uudis[0].pealkiri));
		aPealkiri.href = "uudis?uudisId="+uudis[0].id;
		aPealkiri.setAttribute("class", "temp_link");
		tdPealkiri.appendChild(aPealkiri);
		newRow.appendChild(tdPealkiri);
		var tdKommentaare = document.createElement("td");
		tdKommentaare.appendChild(document.createTextNode(uudis[0].kommentaare));
		newRow.appendChild(tdKommentaare);
		tabel.insertBefore(newRow, tabel.childNodes[0]);
	};
} else {
	//poll
}