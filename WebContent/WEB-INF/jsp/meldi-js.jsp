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
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script async src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>
	<script async type="text/javascript" src="JavaScript/scripture.js"></script>
	<script async type="text/javascript" src="JavaScript/validation.js"></script>
	<script async type="text/javascript" src="JavaScript/facebook.js"></script>
	
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
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
			<div id="Meldi" class="meldi-JS">
				<table id="meldi_container">
					<tbody class="meldi_container-JS">
						<tr id="navi-buttons">
							<th><button id="navi-buttons-meldi" class="navi-buttons-meldiA navi-buttons-specific 
														navi-buttons-placementA"><h3>Meldi</h3></button></th>
							<th><button id="navi-buttons-registreeri" class="navi-buttons-registreeriA navi-buttons-specific 
														navi-buttons-placementA"><h3>Registreeru</h3></button></th>
						</tr>
						<tr>
							<td id="meld">
								<div id="meldi_integr">
									<form id="meldi-vorm" method="post" action="login_JS">
										Kasutajanimi: <input class="input-field" name="k-nimi" placeholder="Kasutajanimi" type="text">
										Parool: <input class="input-field" name="pwd" placeholder="******" type="password">
										<span class="hidden-nupud">
											<button id="button0">Meldi</button>
										</span>
									</form>
									<label id="button1"><a href="/">Katkesta</a></label>
								</div>
							</td>
							<td id="register" class="registerB">
								<form id="registreeru-vorm" method="post" action="register_JS">
									Eesnimi: <input class="input-field" name="e-nimi" placeholder="Eesnimi" type="text">
									Perenimi: <input class="input-field" name="p-nimi" placeholder="Perenimi" type="text">
									Kasutajanimi: <input class="input-field" name="k-nimi" placeholder="Kasutajanimi" type="text">
									Parool: <input class="input-field" name="pwd" placeholder="******" type="password">
									Parool uuesti: <input class="input-field" name="pwd2" placeholder="******" type="password">
									<span class="hidden-nupud">
										<button id="button2">Registreeru</button>
									</span>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div> <!-- keskmine -->
	<%@include file="jupid/jalus.jsp" %>
	</div><!-- Rakendus -->
	
</body>

</html>

