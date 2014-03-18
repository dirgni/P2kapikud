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
				
			<!-- 	Asendatud top-navi'ga
			
				<div id="navigatsioon">
					TODO Navigatsioon
					Navigatsioon
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
			<div id="uudis-wrapper" class="uudis-wrapper-less">
				<div class="uudis-pealkiri">
					<h1>Pealkiri</h1>
				</div> <!-- uudis-pealkiri -->
				<div class="uudis-tekst">
					<div class="uudis-pilt">
						<img class="main-pilt" alt="olümpiavõtitja legkov" src="Images\legkov.png">
					</div> <!-- uudis-pilt -->
					
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
			</div> <!-- uudis-wrapper -->
			
			<div class="clear"></div>
			
			<div id="uudise-kommentaar">
				
			 	<h3 id="uudise-kommentaar-title">Kommentaarid</h3>
			 	<div id="uudise-kommentaar-vorm">
			 		<form id="kommentaar-vorm" onsubmit="return true">
	 					<input class="input-field" name="Nimi" placeholder="Nimi" type="text">
	 					<textarea class="input-field" name="content" placeholder="Sisestage oma kommentaar siia." rows="5"></textarea>
		 				<input class="submit-button" type="submit" value="Kommenteeri">
		 				<input class="submit-button" type="reset" value="Tühjenda väljad">
			 		</form> <!-- kommentaar-vorm -->
		 		</div> <!-- uudise-kommentaar-vorm -->
		 		<div id="uudise-kommentaar-list">
		 			<blockquote>
		 			<div class="kommentaar" id="kommentaar-001">
		 				<span class="kommentaar-aeg"> 5 minutit tagasi - </span>
		 				<span class="kommentaar-autor"> maia </span>
		 				<blockquote class="kommentaar-sisu"> esimene! :D </blockquote>
		 			</div> <!-- kommentaar-001 -->
		 			
		 			<div class="kommentaar" id="kommentaar-002">
		 				<span class="kommentaar-aeg">59 minutit tagasi - </span>
		 				<span class="kommentaar-autor"> suusk </span>
		 				<blockquote class="kommentaar-sisu">
	 						Kus see lumi on? 
							Eestis tuleb lõpetada suusasport. 
							Eesti suustajad Lapimaale elama ja treenima.
						</blockquote>
		 			</div> <!-- kommentaar-002 -->
		 			
		 			<div class="kommentaar" id="kommentaar-003">
		 				<span class="kommentaar-aeg"> 1 tund tagasi - </span>
		 				<span class="kommentaar-autor"> nojah </span>
		 				<blockquote class="kommentaar-sisu"> vaat siis kui tore.  </blockquote>
		 			</div> <!-- kommentaar-003 -->
		 			
		 			<div class="kommentaar" id="kommentaar-004">
		 				<span class="kommentaar-aeg"> 6 tundi tagasi - </span>
		 				<span class="kommentaar-autor"> Martin Mardikass</span>
		 				<blockquote class="kommentaar-sisu">
		 					Siin pole enam midagi teha. 
		 					Ise läheb suusatama. Ehk õnnestub paremini hakkama saada kui meie noorukid siin.
		 					Minu ajal oli ikka kõik teisiti. Ega midagi muud polegi öelda kui: Noorus on hukas.
		 				</blockquote>
		 			</div> <!-- kommentaar-004 -->
		 			
		 			<div class="kommentaar" id="kommentaar-005">
		 				<span class="kommentaar-aeg"> 2 päeva tagasi - </span>
		 				<span class="kommentaar-autor"> </span>
		 				<blockquote class="kommentaar-sisu"> tore lugu siis </blockquote>
		 			</div> <!-- kommentaar-005 -->
		 			</blockquote>
		 		</div> <!-- uudise-kommentaar-list -->
			 </div> <!-- uudise-kommentaar -->
			
		</div> <!-- keskmine -->
		
		<div id="alumine">

			<div id="valideeringud">
				<p>
					<a href="http://validator.w3.org/check?uri=http%3A%2F%2Fp2kapikud.herokuapp.com%2F">
						<img id="html-valid"
	        			src="data:image/jpeg;base64,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"
	        			alt="HTML5 Ok!" />
					</a>
				
					<a href="http://jigsaw.w3.org/css-validator/check/referer">
	    				<img id="css-valid"
	        			src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
	        			alt="CSS Ok!" />
					</a>
				</p>
			</div><!-- valideeringud -->
			
<!-- 		<div id="kontakt">Kontakt</div> -->

		</div><!-- jalus -->

	</div><!-- Rakendus -->
		
</body>

</html>