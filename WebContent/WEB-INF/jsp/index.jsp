<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Uudisteportaal</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<link rel="stylesheet" type="text/css" href="CSS/uudis.css">
	
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
				
				<!-- Asendatud top-navi'ga
				
				<div id="navigatsioon">
					TODO Navigatsioon
					<a href="tabel.html">Tabel</a>
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
			<div id="esi-uudis-wrapper" class="uudis-wrapper-less">
					<div id="uudis-tekst">
	  					<h1><a class="temp_link" href="uudis.html">Pealkiri</a></h1>
	  					
						<p>
							Lorem ipsum dolor sit amet,
							consectetur adipiscing elit. Fusce nec metus nec odio pharetra
							ultrices et eget ante. Vivamus adipiscing ante erat, ut molestie sem
							vulputate eu. Aliquam ipsum urna, facilisis quis sodales eget,
							fringilla a ipsum. Praesent sapien nulla, mattis vitae scelerisque
							et, porttitor at nulla. Vestibulum vel turpis congue arcu ornare
							fermentum sed nec elit. Mauris quis convallis elit. Proin aliquet,
							sapien non congue pretium, ante libero tristique nulla, id porttitor
							arcu mauris et massa. Praesent metus est, ultricies id tincidunt id,
							venenatis nec leo. Aenean eget arcu eget dolor congue commodo et in
							turpis.
						</p>
					</div> <!-- uudis-tekst -->
			</div> <!-- esi-uudis-wrapper -->
		</div> <!-- keskmine -->

		<%@include file="jalus.jsp" %>
		
	</div><!-- Rakendus -->
</body>

</html>