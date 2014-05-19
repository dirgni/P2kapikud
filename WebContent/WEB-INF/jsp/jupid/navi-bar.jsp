<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="top-navi">
	<a href="/">Avaleht</a> | 
	<a href="tabel">Uudised</a>
	<c:if test="${klient.roll == 'ajakirjanik' || klient.roll == 'admin'}">
		| <a href="postita-uudis">Lisa uudis</a>
	</c:if>
	
<!-- 	<div id="abinupp"></div> -->
</div>