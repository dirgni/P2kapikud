<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<%
int uudisId = 1;
// Andmebaasist andmete võtmine

Class.forName("org.postgresql.Driver").newInstance();

Connection con = null;

String url = "jdbc:postgresql://ec2-54-228-224-40.eu-west-1.compute.amazonaws.com:5432/d7vu5vmrh6826v";
Properties props = new Properties();
props.setProperty("user", "gkqowcfxsywapr");
props.setProperty("password", "uTMYU-2zrRPd3ro5LthO0hXc4C");
props.setProperty("ssl", "true");
// Järgmine rida võtab pmst SSL turva maha. Tuleks luua mingi
// SSLSocketFactory objekt, mis sertifikaate toodaks nagu ma aru saan...
props.setProperty("sslfactory",
		"org.postgresql.ssl.NonValidatingFactory");
con = DriverManager.getConnection(url, props);

PreparedStatement ps = con.prepareStatement(
		"SELECT pealkiri, tekst, pilt FROM uudis "
		+ "WHERE id = ?");
ps.setInt(1, uudisId);
ResultSet uudis = ps.executeQuery();
uudis.next();

ps = con.prepareStatement("SELECT id, nimi, tekst, aeg, uudisId FROM "
		+ "kommentaar WHERE id = ?");
ps.setInt(1, uudisId);

ResultSet kommentaarid = ps.executeQuery();
%>

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
	<%@include file="jupid/navi-bar.jsp" %>
	<%@include file="jupid/RSS.jsp" %>
	<%@include file="jupid/meldi.jsp" %>
	<div id="Rakendus">
	
		<%@include file="jupid/päis.jsp" %>

		<div id="keskmine">
			<div id="uudis-wrapper" class="uudis-wrapper-less">
				<div class="uudis-pealkiri">
					<h1><%= uudis.getString("pealkiri") %></h1>
				</div> <!-- uudis-pealkiri -->
				<div class="uudis-tekst">
					<div class="uudis-pilt">
						<img class="main-pilt" alt="olümpiavõitja legkov" src="Images/legkov.png">
					</div> <!-- uudis-pilt -->
					<%= uudis.getString("tekst") %>
				</div> <!-- uudis-tekst -->
			</div> <!-- uudis-wrapper -->
			
			<div class="clear"></div>
			
			<div id="uudise-kommentaar">
				
			 	<h3 id="uudise-kommentaar-title">Kommentaarid</h3>
			 	<div id="uudise-kommentaar-vorm">
			 		<form id="kommentaar-vorm" onsubmit="return true">
	 					<input class="input-field" name="Nimi" placeholder="Nimi" type="text">
	 					<textarea class="input-field" name="content" placeholder="Sisestage oma kommentaar siia." rows="5"></textarea>
		 				<input class="submit-button" type="submit" value="Kommenteeri">
		 				<input class="submit-button" type="reset" value="Tühjenda väljad">
			 		</form> <!-- kommentaar-vorm -->
		 		</div> <!-- uudise-kommentaar-vorm -->
<% if (kommentaarid.isBeforeFirst()) { %>
		 		<div id="uudise-kommentaar-list">
<% 	while (kommentaarid.next()) {  %>
		 			<blockquote>
		 			<div class="kommentaar" id="kommentaar-<%= kommentaarid.getString("id") %>">
		 				<span class="kommentaar-aeg"> <%= kommentaarid.getString("aeg") %> </span>
		 				<span class="kommentaar-autor"> <%= kommentaarid.getString("nimi") %> </span>
		 				<blockquote class="kommentaar-sisu"> <%= kommentaarid.getString("tekst") %> </blockquote>
		 			</div> <!-- kommentaar-<%= kommentaarid.getString("id") %> -->
		 			
<% 	} %>	
		 			</blockquote>
		 		</div> <!-- uudise-kommentaar-list -->
<% } %>
			 </div> <!-- uudise-kommentaar -->
			
		</div> <!-- keskmine -->
		
		<%@include file="jupid/jalus.jsp" %>

	</div><!-- Rakendus -->
		
</body>

</html>