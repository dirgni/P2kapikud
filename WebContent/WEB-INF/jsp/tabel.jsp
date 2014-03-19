<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Uudisteportaal</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<link rel="stylesheet" type="text/css" href="CSS/tabel.css">
	
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
			<!-- 
				Siin toimub kogu maagia
			 -->
			 <div id="uudiste_tabel">
			 	<table>
			 		<tr>
			 			<th>Kuupäev</th>
			 			<th>Kellaaeg</th>
			 			<th>Pealkiri</th>
			 			<th>Loetud</th>
			 			<th>Kommentaare</th>
			 			<th>Pilt</th>
			 		</tr>
			 		
			 		<tr>
			 			<td>14.02.2014</td>
			 			<td>14:45</td>
			 			<td><a class="temp_link" href="uudis.html">Maasikad on magusad</a></td>
			 			<td>100</td>
			 			<td>10</td>
			 			<td>X</td>
			 		</tr>
			 		
			 		<tr>
			 			<td>14.02.2014</td>
			 			<td>14:59</td>
			 			<td><a class="temp_link" href="uudis.html">Lumesõda hoovis</a></td>
			 			<td>59</td>
			 			<td>3</td>
			 			<td>X</td>
			 		</tr>
			 		
			 		<tr>
			 			<td>14.02.2014</td>
			 			<td>15:10</td>
			 			<td><a class="temp_link" href="uudis.html">Uudiste uudis</a></td>
			 			<td>10</td>
			 			<td>1</td>
			 			<td>X</td>
			 		</tr>
			 		
			 	</table>
			 
			 </div>
			 
			 
		</div> <!-- keskmine -->
		
		<%@include file="jupid/jalus.jsp" %>
		
	</div> <!-- Rakendus -->
</body>

</html>