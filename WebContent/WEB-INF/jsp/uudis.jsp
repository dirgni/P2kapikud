<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="service.UudisService, object.Uudis"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>P2kapikud | ${uudis.pealkiri }</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<!--[if lte IE 8]>
		<link rel="stylesheet" type="text/css" href="CSS/ie8-and-down.css">
	<![endif]-->
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>
	<script type="text/javascript" src="JavaScript/scripture.js"></script>
	<script type="text/javascript" src="JavaScript/validation.js"></script>
	<script type="text/javascript" src="JavaScript/postita-kommentaar.js"></script>
	<c:if test="${klient.roll == 'admin'}">
		<script type="text/javascript" src="JavaScript/kustuta-kommentaar.js"></script>
	</c:if>	
	
	<link rel="icon" type="image/png" href="Images/logo-small.png">
</head>

<body>
	<%@include file="jupid/navi-bar.jsp" %>
	<c:if test="${klient.roll != 'ajakirjanik' && klient.roll != 'admin'}">
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
			<div id="uudis-wrapper" class="uudis-wrapper-less">
				<div class="uudis-pealkiri">
					<h1>${uudis.pealkiri }</h1>
					<div class="uudis-autor">
						${autor.eesnimi} ${autor.perenimi}
					</div>
					<c:if test="${!empty(kommentaarid)}">
					<a href="#uudise-kommentaar">Kommentaarid</a>
					</c:if>
				</div> <!-- uudis-pealkiri -->

				<div class="uudis-tekst">
					<div class="uudis-pilt">
						<img class="main-pilt" alt="" src="${uudis.pilt}">
					</div> <!-- uudis-pilt -->
					<c:forEach items="${uudis.tekst}" var="lõik" varStatus = "status">
						<p><c:out value="${lõik}" /></p>
					</c:forEach>
				</div> <!-- uudis-tekst -->
				<div id="uudis-tag">
					<c:forEach items="${uudis.tagid}" var="tag">
						#<c:out value="${tag}" />, 
					</c:forEach>
				</div>
			</div> <!-- uudis-wrapper -->
			
			<div class="clear"></div>
			
			<div id="uudise-kommentaar">
				
			 	<h3 id="uudise-kommentaar-title">Kommentaarid</h3>
			 	<div id="uudise-kommentaar-vorm">
			 		<form id="kommentaar-vorm" onsubmit="return true" method="post">
			 			<c:choose>
							<c:when test="${klient.roll == 'ajakirjanik' || klient.roll == 'admin'}">
								<span id="kommenteerija">
									${klient.eesnimi}
									<input id="kommentaar-nimi" name="Nimi" type="hidden" value="${klient.eesnimi}">
								</span>
							</c:when>
							<c:otherwise>
								<!--[if lte IE 9]>Kommenteerija nimi: <![endif]-->
								<input id="kommentaar-nimi" class="input-field" name="Nimi" placeholder="Nimi" type="text">
							</c:otherwise>
						</c:choose>
						<!--[if lte IE 9]>Kirjuta kommentaar: <![endif]-->
	 					<textarea id="kommentaar-sisu" class="input-field" name="content" placeholder="Sisestage oma kommentaar siia." rows="5"></textarea>
		 				<input id="uudis-id" type="hidden" name="uudisId" value="${uudis.id}">
		 				<input class="submit-button" type="button" value="Kommenteeri" onclick="postitaKommentaar()">
		 				<input class="submit-button" type="reset" value="Tühjenda väljad">
		 				<div id="postitamine-info"></div>
			 		</form> <!-- kommentaar-vorm -->
		 		</div> <!-- uudise-kommentaar-vorm -->

				<c:if test="${!empty(kommentaarid)}">
					<div id="uudise-kommentaar-list">
						<c:forEach items="${kommentaarid}" var="kommentaar">
							<blockquote>
								<div class="kommentaar" id="kommentaar-${kommentaar.id}">
									<span class="kommentaar-aeg"> ${kommentaar.kell} ${kommentaar.kuupäev} </span>
									<span class="kommentaar-autor"> ${kommentaar.nimi} </span>
									<c:if test="${klient.roll == 'admin'}">
										<form method="post" >
											<button type="button" class="tegevus-nupp" id="kommentaar-menu-del" onclick="kustutaKommentaar(${kommentaar.id}, ${uudis.id})"></button>
										</form>
									</c:if>
									<blockquote class="kommentaar-sisu">${kommentaar.tekst}</blockquote>
								</div> <!-- kommentaar-${kommentaar.id} -->
							</blockquote>
						</c:forEach>
					</div> <!-- uudise-kommentaar-list -->
				</c:if>

			</div> <!-- uudise-kommentaar -->
			
		</div> <!-- keskmine -->
		
		<%@include file="jupid/jalus.jsp" %>

	</div><!-- Rakendus -->
	
</body>

</html>
