<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>0H-0H P4G1N4 N0N TR0V4T4</title>
</head>
<body>
	<%@ include file="nav.html" %>
	<div class="container">
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h3>Oh-Oh Pagina non trovata!</h3>
		</div>
		<div class="card">
			<div class="card-header text-white bg-danger mb-3">
				<h3>Quello che cercavi non è qui</h3>
			</div>
			<div class="card-body">
				<h5 class="card-title">Forse dovresti cercarlo altrove</h5>
				<p class="card-text">
					Per segnalare il problema: &nbsp; <a href="mailto:admin@app.it">Lamentati</a>
				</p>
				<p style="margin-top:20px;">
					<input type="button" class="btn btn-outline-dark" value="<<Indietro" onclick="window.history.back()"/>
				</p>
			</div>
		</div>
	</div>
	<footer class="bg-dark text-light"><%@include file="footer.html" %></footer>
</body>
</html>