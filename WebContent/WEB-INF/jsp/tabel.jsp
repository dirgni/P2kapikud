<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Uudisteportaal | Tabel</title>
	
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<!--[if lte IE 8]>
		<link rel="stylesheet" type="text/css" href="CSS/ie8-and-down.css">
	<![endif]-->
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="JavaScript/scripture.js"></script>
	
	<script type="text/javascript" src="JavaScript/sortimineTabel.js"></script>
	<script type="text/javascript" src="JavaScript/validation.js"></script>
	<script type="text/javascript" src="JavaScript/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="JavaScript/jquery.tablesorter.pager.js"></script>
	
	<link rel="icon" type="image/png" href="Images/logo-small.png">
</head>

<body>
	<%@include file="jupid/navi-bar.jsp" %>
	<c:if test="${klient.roll != 'ajakirjanik' || klient.roll != 'admin'}">
		<%@include file="jupid/meldi.jsp" %>
	</c:if>
	
	<div id="Rakendus">
		<c:choose>
			<c:when test="${klient.roll == 'ajakirjanik' || klient.roll == 'admin'}">
				<jsp:include page="jupid/päis-melditud.jsp"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="jupid/päis.jsp"/>
			</c:otherwise>
		</c:choose>
		
		<div id="keskmine">

			 <div id="uudiste_tabel">
			 	<table id="uudised_tabelis" class="tablesorter">
			 		<thead>
				 		<tr>
				 			<th>Kuupäev</th>
				 			<th>Kellaaeg</th>
				 			<th>Pealkiri</th>
				 			<th>Kommentaare</th>
				 			<c:if test="${klient.roll == 'admin'}">
								<th class="tabel-min">Eemalda</th>
							</c:if>
				 		</tr>
			 		</thead>
					<c:if test="${!empty (uudised)}">
						<tbody>
							<c:forEach items="${uudised}" var="uudis">
								<tr id="uudisId-${uudis.id}" onclick="preview(${uudis.id})">
									<td>${uudis.kuupäev}</td>
									<td>${uudis.kell}</td>
									<td><a class="temp_link" href="uudis?uudisId=${uudis.id}">${uudis.pealkiri}</a></td>
									<td>${uudis.kommentaare}</td>
									<c:if test="${klient.roll == 'admin'}">
										<td>
											<form onsubmit="return true" action="kustuta-uudis" method="post">
												<input type="hidden" name="uId" value="${uudis.id}">
												<button type="submit" class="tegevus-nupp" id="tabel-menu-del"></button>
											</form>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table> <!-- uudised-tabelis -->
			 </div> <!-- uudiste-tabel -->
			 
		</div> <!-- keskmine -->
		
		<%@include file="jupid/jalus.jsp" %>
		
	</div> <!-- Rakendus -->
	
</body>

</html>
