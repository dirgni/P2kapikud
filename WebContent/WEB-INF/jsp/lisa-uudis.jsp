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
	<%@include file="jupid/navi-bar.jsp" %>
	
	<%@include file="jupid/RSS.jsp" %>
	<%@include file="jupid/meldi.jsp" %>
	
	<div id="Rakendus">
		<%@include file="jupid/päis.jsp" %>
		
		<div id="keskmine">
			<!-- TODO:
				- Pealkiri
				- Pildi osa
				- Keha
				- Autori osa
				- Kommentaaride osa
			 -->
			 <div class="uudise-lisamine-wrapper">
			 	<form id="uudise-vorm" enctype="multipart/form-data" method="post" action="PostitaUudisServlet">
			 	
	 				<div id="uudise-autor-select">
 						Sisseloginud kirjutaja nimi
	 				</div> <!-- uudise-autor-select -->

					<div id="uudise-andmed">
						<input type="text" placeholder="Pealkiri">
						<div id="input-image-wrap">
							<label for="def-hide">
								<input id="def-hide" type="file" accept="image/jpg,image/png">
							</label>
						</div> <!-- input-image-wrap -->
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
		
		<%@include file="jupid/jalus.jsp" %>
		
	</div> <!-- Rakendus -->
</body>

</html>