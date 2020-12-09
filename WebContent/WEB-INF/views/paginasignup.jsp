<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<form:form action="ussalva" method="POST" class="form-horizontal" modelAttribute="utente">
				<div class="form-group row">
					<label for="nome" class="col-sm-1 col-form-label mr-2">Nome:</label>
					<div class="col-sm-4">
						<form:input path="nome" id="nome" placeholder="Nome..." class="form-control" />
					</div>
					<div class="col-sm-6">
						<form:errors path="nome" cssClass="error" />
					</div>
				</div>
				<div class="form-group row">
					<label for="cognome" class="col-sm-1 col-form-label mr-2">Cognome:</label>
					<div class="col-sm-4">
						<form:input path="cognome" id="cognome" placeholder="Cognome..." class="form-control"/>
					</div>
					<div class="col-sm-6">
						<form:errors path="cognome" cssClass="error" />
					</div>
				</div>
				<div class="form-group row">
					<label for="email" class="col-sm-1 col-form-label mr-2">Email:</label>
					<div class="col-sm-4">
						<form:input path="email" id="email" placeholder="Email..." class="form-control" />
					</div>
					<div class="col-sm-6">
						<form:errors path="email" cssClass="error" />
					</div>
				</div>
				<div class="form-group row">
					<label for="username" class="col-sm-1 col-form-label mr-2">Username:</label>
					<div class="col-sm-4">
						<form:input path="username" id="username" placeholder="Username..." class="form-control" />
					</div>
					<div class="col-sm-6">
						<form:errors path="username" cssClass="error" />
					</div>
				</div>
				<div class="form-group row">
					<label for="password" class="col-sm-1 col-form-label mr-2">Password:</label>
					<div class="col-sm-4">
						<form:password path="password" name="password" id="password" placeholder="Password..." class="form-control" />
					</div>
					<div class="col-sm-6">
						<form:errors path="password" cssClass="error" />
					</div>
				</div>
				<button type="submit" class="btn btn-outline-dark" style="margin-top:20px;">Registrati</button>
			</form:form>
		</div>
	</div>
	<footer class="bg-dark text-light"><%@include file="/footer.html" %></footer>
</body>
</html>