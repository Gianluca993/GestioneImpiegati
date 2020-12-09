<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>H0M3-P4G3</title>
</head>
<body>
	<%@ include file="nav.html" %>
	<div class="container">
		<div class="jumbotron" style="margin-top:50px;">
			<h2 class="display-4">Gestione impiegati</h2>
			<c:if test="${sessionScope.username == null}">
				<p class="lead">Accedi per continuare</p>
				<hr>
				<a class="btn btn-outline-dark btn-lg" href="loginform" role="button">
					Accedi</a>
				<a class="btn btn-outline-secondary btn-lg" href="signupform" role="button">
					Registrati</a>
			</c:if>
			<c:if test="${sessionScope.username != null}">
				<p class="lead">Ciao <c:out value="${sessionScope.username}">, ben tornato</c:out></p>
				<hr>
				<a class="btn btn-outline-dark btn-lg" href="impreport" role="button">
					Report Impiegati</a>
				<a class="btn btn-outline-dark btn-lg" href="stats" role="button">
					Statistiche Impiegati</a>
				<a class="btn btn-outline-secondary btn-lg" href="impform" role="button">
					Aggiungi Impiegato</a>
			</c:if>
		</div>
	</div>
	<footer class="bg-dark text-light"><%@include file="footer.html" %></footer>
</body>
</html>