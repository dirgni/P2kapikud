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
		<jsp:include page="jupid/päis.jsp" />

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

		<%@include file="jupid/jalus.jsp" %>
		
	</div><!-- Rakendus -->
</body>

</html>