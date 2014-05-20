<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Uudisteportaal</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<!--[if lte IE 8]>
		<link rel="stylesheet" type="text/css" href="CSS/ie8-and-down.css">
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="CSS/lisa-uudis.css">
	<link rel="stylesheet" type="text/css" href="CSS/usermenu.css">
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="JavaScript/scripture.js"></script>
	
	<link rel="icon" type="image/png" href="Images/logo-small.png">
</head>

<body>
	<%@include file="jupid/navi-bar.jsp" %>
	
	<div id="Rakendus">
		<jsp:include page="jupid/päis-melditud.jsp"/>
		
		<div id="keskmine">
			<!-- TODO:
				- Pealkiri
				- Pildi osa
				- Keha
				- Autori osa
				- Kommentaaride osa
			 -->
			 <div class="uudise-lisamine-wrapper">
			 	<form id="uudise-vorm" enctype="multipart/form-data" method="post" target="lamp">
					<div id="uudise-andmed">
						<h1>Postita uudis</h1>
						<!--[if lte IE 9]>Uudise pealkiri: <![endif]-->
						<input type="text" name="pealkiri" placeholder="Pealkiri">
						<!--[if lte IE 9]>Pildilink: <![endif]-->
						<input type="url" name="pilt" placeholder="http://pildi.url.com" accept="image/jpg,image/png">
						<!--[if lte IE 9]>Sisu: <![endif]-->
						<textarea rows="7" name="tekst" placeholder="Sisu"></textarea>
					</div> <!-- uudise-andmed -->

					<div class="tagide-valik">
						<!--[if lte IE 9]>Tagid: <![endif]-->
 						<input class="uudise-tagid" name="uudise-tagid" type="text" autocomplete="on" placeholder="tags">
 					</div> <!-- tagide-valik -->
 					
			 		<div class="tegevus-nupud">
			 			<button type="button" class="tegevus-nupp" onclick="postitaUudis()">Postita uudis</button>
			 			<button type="reset" class="tegevus-nupp">Loobu</button>
			 		</div> <!-- tegevus-nupud -->
			 		<div id="info"></div>
			 		
			 	</form> <!-- uudise-vorm -->
			 </div> <!-- uudise-lisamine-wrapper -->
			<iframe id="lamp" name="lamp" style="display: none;"></iframe>
		</div> <!-- keskmine -->
		
		<%@include file="jupid/jalus.jsp" %>
		
	</div> <!-- Rakendus -->
	<script type="text/javascript" src="JavaScript/validation.js"></script>
	<script type="text/javascript" src="JavaScript/postita-uudis.js"></script>
</body>

</html>