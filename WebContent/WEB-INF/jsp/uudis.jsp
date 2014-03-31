<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="service.UudisService, object.Uudis"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>P2kapikud | ${uudis.pealkiri }</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<link rel="stylesheet" type="text/css" href="CSS/uudis.css">
	
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
			<div id="uudis-wrapper" class="uudis-wrapper-less">
				<div class="uudis-pealkiri">
					<h1>${uudis.pealkiri }</h1>
				</div> <!-- uudis-pealkiri -->
				<div class="uudis-tekst">
					<div class="uudis-pilt">
						<img class="main-pilt" alt="olümpiavõitja legkov" src="${uudis.pilt }">
					</div> <!-- uudis-pilt -->
					<c:forEach items="${uudis.tekst}" var="lõik">
						<p><c:out value="${lõik}" /></p>
					</c:forEach>
				</div> <!-- uudis-tekst -->
			</div> <!-- uudis-wrapper -->
			
			<div class="clear"></div>
			
			<div id="uudise-kommentaar">
				
			 	<h3 id="uudise-kommentaar-title">Kommentaarid</h3>
			 	<div id="uudise-kommentaar-vorm">
			 		<form id="kommentaar-vorm" onsubmit="return true" action="uudis" method="post">
	 					<input class="input-field" name="Nimi" placeholder="Nimi" type="text">
	 					<textarea class="input-field" name="content" placeholder="Sisestage oma kommentaar siia." rows="5"></textarea>
		 				<input type="hidden" name="uudisId" value="${uudis.id}">
		 				<input class="submit-button" type="submit" value="Kommenteeri">
		 				<input class="submit-button" type="reset" value="Tühjenda väljad">
			 		</form> <!-- kommentaar-vorm -->

		 		</div> <!-- uudise-kommentaar-vorm -->

				<c:if test="${!empty(kommentaarid)}">
					<div id="uudise-kommentaar-list">
						<c:forEach items="${kommentaarid}" var="kommentaar">
							<blockquote>
								<div class="kommentaar" id="kommentaar-${kommentaar.id}">
									<span class="kommentaar-aeg"> ${kommentaar.aeg} </span>
									<span class="kommentaar-autor"> ${kommentaar.nimi} </span>
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