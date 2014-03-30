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
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="JavaScript/scripture.js"></script>
	
	<link rel="icon" type="image/png" href="Images/logo-small.png">
</head>

<body>
	<%@include file="jupid/navi-bar.jsp" %>
	<%@include file="jupid/RSS.jsp" %>
	<%@include file="jupid/meldi.jsp" %>
	
	<div id="Rakendus">
		<jsp:include page="jupid/päis.jsp" />

		<div id="keskmine">
			<div id="esi-uudis-wrapper" class="uudis-wrapper-less">
					<div id="uudis-tekst">
	  					<h1>
	  						<a class="temp_link" href="uudis.html">
	  							${uudis.pealkiri }
	  						</a>
	  					</h1>
						<c:forEach items="${uudis.tekst}" var="lõik">
							<p><c:out value="${lõik}" /></p>
						</c:forEach>
				</div> <!-- uudis-tekst -->
			</div> <!-- esi-uudis-wrapper -->
		</div> <!-- keskmine -->

		<%@include file="jupid/jalus.jsp" %>
		
	</div><!-- Rakendus -->
</body>

</html>