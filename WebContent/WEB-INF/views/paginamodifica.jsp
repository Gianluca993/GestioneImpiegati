<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<h3>Modifica impiegato</h3>
		</div>
		<form:form method="post" action="${pageContext.request.contextPath}/modifica" modelAttribute="impiegato" enctype="multipart/form-data">
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th style="width:200px;">Immagine</th>
						<th style="width:200px;">Nome</th>
						<th style="width:200px;">Stipendio</th>
						<th style="width:200px;">Reparto</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<form:hidden path="id"/>
						<form:hidden path="imgUrl"/>
						<td><input type="file" accept="image/x-png,image/gif,image/jpeg" name="img" id="img" class="form-control"/></td>
						<td><form:input path="nome" class="form-control"/></td>
						<td><form:input path="stipendio" class="form-control"/></td>
						<td><form:input path="reparto" class="form-control"/></td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="button" class="btn btn-outline-dark" value="<< Indietro" onclick="window.history.back()"/>
							<button type="submit" class="btn btn-outline-warning btn-xl float-right">Modifica impiegato</button>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<form:errors path="nome" cssClass="error" />
			</div>
			<div>
				<form:errors path="stipendio" cssClass="error" />
			</div>
			<div>
				<form:errors path="reparto" cssClass="error" />
			</div>
		</form:form>
	</div>
	<footer class="bg-dark text-light"><%@include file="/footer.html" %></footer>
</body>
</html>