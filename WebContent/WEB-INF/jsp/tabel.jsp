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
			
		</div> <!-- pealmine -->
		
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
		
		<%@include file="jalus.jsp" %>
		
	</div> <!-- Rakendus -->
</body>

</html>