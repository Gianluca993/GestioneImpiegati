<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="/CDN.html" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>4CC3SS0 N3G4T0</title>
</head>
<body>
	<%@ include file="/nav.html" %>
	<div class="container">
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h3>Accesso Negato</h3>
		</div>
		<div class="card">
			<div class="card-header text-white bg-danger mb-3">
				<h3>Accedi per utilizzare l'applicazione</h3>
			</div>
			<div class="card-body">
				<p class="card-text">
					<a href="loginform">Accedi</a>
				</p>
				<p class="card-text">
					<a href="signupform">Registrati</a>
				</p>
				<p style="margin-top:20px;">
					<input type="button" class="btn btn-outline-dark" value="<<Indietro" onclick="window.history.back()"/>
				</p>
			</div>
		</div>
	</div>
	<footer class="bg-dark text-light"><%@include file="/footer.html" %></footer>
</body>
</html>