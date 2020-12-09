<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h3>Report impiegati</h3>
		</div>
		<div class="table table-borderless">
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th style="width:200px;">Immagine</th>
						<th style="width:200px;">Nome</th>
						<th style="width:200px;">Stipendio</th>
						<th style="width:200px;">Reparto</th>
						<th style="width:200px;">Modifica</th>
						<th style="width:200px;">Elimina</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="imp" items="${lista}">
						<tr>
							<td><img src="<c:url value="${imp.imgUrl}"/>" style="max-width:100px;"/></td>
							<td>${imp.nome}</td>
							<td>${imp.stipendio}</td>
							<td>${imp.reparto}</td>
							<td>
								<button type="button" class="btn btn-warning btn-sm"
									onclick="window.location.href='modificatemp/${imp.id}'">
									Modifica
								</button>
							</td>
							<td>
								<button type="button" class="btn btn-danger btn-sm"
									onclick="window.location.href='cancella/${imp.id}'">
									Cancella
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="button" class="btn btn-outline-dark"
				onclick="window.location.href='impform'"
				style="margin-top:20px;">
				Aggiungi un nuovo impiegato
			</button>
		</div>
	</div>
	<footer class="bg-dark text-light"><%@include file="/footer.html" %></footer>
</body>
</html>