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
	
	<%@include file="jupid/RSS.jsp" %>
	<%@include file="jupid/meldi.jsp" %>
	<div id="Rakendus">
	
		<%@include file="jupid/päis.jsp" %>

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
		
		<%@include file="jupid/jalus.jsp" %>

	</div><!-- Rakendus -->
		
</body>

</html>