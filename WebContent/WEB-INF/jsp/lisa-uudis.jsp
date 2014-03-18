<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Uudisteportaal</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<link rel="stylesheet" type="text/css" href="CSS/lisa-uudis.css">
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="JavaScript/scripture.js"></script>
	
	<link rel="icon" type="image/png" href="Images\logo-small.png">
</head>

<body>
	<div id="top-navi">
			<a href="index.html">Avaleht</a> | 
			<a href="lisa-uudis.html">Lisa uudis</a> | 
			<a href="tabel.html">Uudised</a>
			
			<div id="abinupp"></div>
	</div>
	
	<div id="RSS" class="invisible">
		<!-- 
			TODO Overlayer
			TODO RSS lisamine
		 -->
		 <div id="rss_container">
		 		<h3> Uudiskirjale registreerimine </h3>
		 		<form id="rss-registreeri-vorm" class="hidden-vorm">
			 		Nimi: <input class="input-field" name="nimi" placeholder="Eesnimi Perekonnanimi" type="text">
			 		E-mail: <input class="input-field" name="e-mail" placeholder="mailiaadress@kuskil.com" type="email">
			 		<span id="rss-vorm-nupud" class="hidden-nupud">
				 		<button onclick="makeHidden('RSS');"> Registreeri </button>
				 		<button onclick="makeHidden('RSS');"> Katkesta </button>
			 		</span>
		 		</form>
		 </div>
	</div> <!-- RSS -->
	
	<div id="Meldi" class="invisible">
		<!-- 
			TODO Overlayer
			TODO Meldi lisamine
		 -->
		 <div id="meldi_container">
		 		<h3> Meldi </h3>
		 		<form id="meldi-vorm" class="hidden-vorm">
			 		Kasutajanimi: <input class="input-field" name="k-nimi" placeholder="Kasutajanimi" type="text">
			 		Parool: <input class="input-field" name="pwd" placeholder="******" type="password">
			 		<span id="meldi-vorm-nupud" class="hidden-nupud">
				 		<button onclick="makeHidden('RSS');"> Meldi </button>
				 		<button onclick="makeHidden('RSS');"> Katkesta </button>
			 		</span>
		 		</form>
		 </div>
	</div> <!-- Meldi -->
	
	<div id="Rakendus">
		<div id="pealmine">

			<div id="pealmine_vasakpoolne">
			
				<div id="logo">
					<!-- Done -->
				</div>
				
<!-- 			Asendatud, top-navi'ga. Hetkel jätab veel alles juhul kui ümber otsustab :P

				<div id="navigatsioon">
					TODO Navigatsioon
					<ul id="navi">
					    <li><a href="index.html">Avaleht</a></li>
					    <li><a href="lisa-uudis.html">Lisa uudis</a></li>
					    <li><a href="tabel.html">Uudised</a></li>
					</ul>
				</div>  -->
				
			</div> <!-- pealmine_vasakpoolne -->
			
			<div id="pealmine_parempoolne">
				<!-- 
					TODO Meldi
					TODO RSS
					TODO Otsing
				 -->
				 
				 <div id="buttons">
				 	<div id="LOGIN-button">
				 		<button id="login" onclick="makeVisible('Meldi')">Meldi</button>
				 	</div>
				 	<div id="RSS-button" onclick="makeVisible('RSS')"></div>
				 </div>
				 
				 <div id="otsing">
				 	<form action="tabel.html">
				 		<input type="text" placeholder="Sisesta otsisõna">
				 	</form>
				 </div> <!-- otsing -->
			</div> <!-- pealmine_parempoolne -->

		</div><!-- päis -->

		
		
		<div id="keskmine">
			<!-- TODO:
				- Pealkiri
				- Pildi osa
				- Keha
				- Autori osa
				- Kommentaaride osa
			 -->
			 <div class="uudise-lisamine-wrapper">
			 	<form id="uudise-vorm" enctype="multipart/form-data" method="post">
			 	
	 				<div id="uudise-autor-select">
 						Sisseloginud kirjutaja nimi
	 				</div> <!-- uudise-autor-select -->
	 				
					<div id="uudise-andmed">
						<input type="text" placeholder="Pealkiri">
						<input type="file" accept="image/jpg,image/png">
						<textarea rows="7" placeholder="Sisu"></textarea>
					</div> <!-- uudise-andmed -->
					
 					<div class="tagide-valik">
 						<input class="uudise-tagid" type="text" autocomplete="on" placeholder="tags">
 					</div> <!-- tagide-valik -->
 					
			 		<div class="tegevus-nupud">
			 			<button type="button" class="tegevus-nupp">Postita uudis</button>
			 			<button type="button" class="tegevus-nupp">Loobu</button>
			 		</div> <!-- tegevus-nupud -->
			 		
			 	</form> <!-- uudise-vorm -->
			 </div> <!-- uudise-lisamine-wrapper -->
			
		</div> <!-- keskmine -->
		
		<%@include file="jalus.jsp" %>
		
	</div> <!-- Rakendus -->
</body>

</html>