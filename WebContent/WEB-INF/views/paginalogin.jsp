<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/CDN.html" %>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>F0RM 1MP13G4T0</title>
</head>
<body>
	<%@ include file="/nav.html" %>
	<div class="container">
		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h3>Inserisci impiegato</h3>
		</div>
		<div class="col-sm-6">
			<form action="uslogin" method="POST">
				<div class="form-group">
					<label for="username">Username:</label>
					<input type="text" name="username" id="username" placeholder="Username..." class="form-control" required />
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" name="password" id="password" placeholder="Password..." class="form-control" required />
				</div>
				<button type="submit" class="btn btn-outline-dark" style="margin-top:20px;">Accedi</button>
			</form>
		</div>
	</div>
	<footer class="bg-dark text-light"><%@include file="/footer.html" %></footer>
</body>
</html>