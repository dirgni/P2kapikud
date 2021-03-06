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
	
	<!--[if lte IE 8]>
		<link rel="stylesheet" type="text/css" href="CSS/ie8-and-down.css">
	<![endif]-->
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script async src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>
	<script async type="text/javascript" src="JavaScript/scripture.js"></script>
	<script async type="text/javascript" src="JavaScript/validation.js"></script>
	<script async type="text/javascript" src="JavaScript/karusell.js"></script>
	
	
	<link rel="icon" type="image/png" href="Images/logo-small.png">
</head>

<body>
	<div id="fb-root"></div>
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
			
			<div id="esi-uudis-wrapper" class="uudis-wrapper-less">
				<div id="karusell_container">
					<div id="karusell">
						<c:if test="${!empty (uudised)}">
							<ul>
								<c:forEach items="${uudised}" begin="0" end="0" var="uudis">
										<li class="active">
										
											<div class="uudise-tekst">
												<h1>
													<a class="temp_link" href="uudis?uudisId=${uudis.id}">
		  												${uudis.pealkiri }
		  											</a>
												</h1>
												
												<p><c:out value="${uudis.tekst[0]}" /></p>
											</div>
											<div class="pic_path">${uudis.pilt}</div>
										</li>
								</c:forEach>
								<c:forEach items="${uudised}" begin="1" var="uudis">
										<li class="inactive">
											<div class="uudise-tekst">
												<h1>
													<a class="temp_link" href="uudis?uudisId=${uudis.id}">
		  												${uudis.pealkiri }
		  											</a>
												</h1>
												
												<p><c:out value="${uudis.tekst[0]}" /></p>
											</div>
											<div class="pic_path">${uudis.pilt}</div>
										</li>
								</c:forEach>
							</ul>
						</c:if>
					 
					</div> <!-- karusell -->
					
					<a class="karusell_button_left"></a>
					<div id="liner"></div>
					<a class="karusell_button_right"></a>
				</div> <!-- karusell_container -->
			</div> <!-- esi-uudis-wrapper -->
			 
		</div> <!-- keskmine -->

		<%@include file="jupid/jalus.jsp" %>
		
	</div><!-- Rakendus -->
	
</body>

</html>
