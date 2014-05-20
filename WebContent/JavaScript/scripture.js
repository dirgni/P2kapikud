//KOMMENTAARI DATAPUSH
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

//TABELI DATAPUSH
function getURLParameter(name) {
	return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
}

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

//FACEBOOKI JS
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



$(document).ready(function(){
	$('#login').css({"display":"block"});
});

function muudaSisu(target, source) {
    document.getElementById(target).innerHTML = document.getElementById(source).innerHTML;
 }

function showMeldi(){
	$('#meld').css({"display":"table-caption"});
	$('#register').css({"display":"none"});
}
function showRegistreeru(){
	$('#register').css({"display":"table-caption"});
	$('#meld').css({"display":"none"});
}

function makeVisible(Id){
	document.getElementById(Id).style.display="block";
	$("body").css("overflow", "hidden");
}

function makeHidden(Id){
	document.getElementById(Id).style.display="none";
	$("body").css("overflow-y", "scroll");
}

//Sortimine uudis eelvaade
function preview(uudisId) {
	var params = "uudisId="+uudisId;
	console.log("preview("+uudisId+")");
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
			window.location.replace("#"+uudisId);
		}
	};
	
	xmlrequest.open("POST", "uudis-preview", true);
	xmlrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlrequest.send(params);
}










