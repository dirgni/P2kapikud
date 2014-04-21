<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>
		Uudisteportaal | ${uudis.pealkiri }
	</title>
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<link rel="stylesheet" type="text/css" href="CSS/uudis.css">
	<link rel="stylesheet" type="text/css" href="CSS/usermenu.css">
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>
	
	<script type="text/javascript" src="JavaScript/scripture.js"></script>
	<script type="text/javascript" src="JavaScript/validation.js"></script>
	
	<link rel="icon" type="image/png" href="Images/logo-small.png">
</head>

<body>
	<%@include file="jupid/navi-bar.jsp" %>
	<%@include file="jupid/RSS.jsp" %>
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
			<!-- 
			
				
  					<h1>
  						
  					</h1>
					<p><c:out value="${uudis.tekst[0]}" /></p>
				 <!-- uudis-tekst -->
			
			<div id="esi-uudis-wrapper" class="uudis-wrapper-less">
			<div id="karusell_container">
				<div id="karusell">
					<c:if test="${!empty (uudised)}">
						<ul>
							<c:forEach items="${uudised}" begin="0" end="0" var="uudis">
									<li class="active">
										<div id="uudis-tekst">
											<h1>
												<a class="temp_link" href="uudis?uudisId=${uudis.id}">
	  												${uudis.pealkiri }
	  											</a>
											</h1>
											
											<p><c:out value="${uudis.tekst[0]}" /></p>
										</div>
									</li>
							</c:forEach>
							<c:forEach items="${uudised}" begin="1" var="uudis">
									<li class="inactive">
										<div id="uudis-tekst">
											<h1>
												<a class="temp_link" href="uudis?uudisId=${uudis.id}">
	  												${uudis.pealkiri }
	  											</a>
											</h1>
											
											<p><c:out value="${uudis.tekst[0]}" /></p>
										</div>
									</li>
							</c:forEach>
						</ul>
					</c:if>
				 
				</div>
		
				<a href="#" class="karusell_button_left">&lsaquo;</a>
				<a href="#" class="karusell_button_right">&rsaquo;</a>
			</div>
			</div> <!-- esi-uudis-wrapper -->
	</div>
			 
	</div> <!-- keskmine -->

		<%@include file="jupid/jalus.jsp" %>
		
	</div><!-- Rakendus -->
</body>

</html>