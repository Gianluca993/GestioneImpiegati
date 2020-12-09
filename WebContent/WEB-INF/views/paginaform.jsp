<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<%@include file="/CDN.html"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<%@include file="/nav.html"%>
	<div class="container">

		<div class="pb-2 mt-4 mb-2 border-bottom">
			<h3>Inserire i dati dell'impiegato</h3>
		</div>

		<form:form action="salva" method="post" class="form-horizontal"
			modelAttribute="impiegato" enctype="multipart/form-data">

			<div class="form-group row">
				<label for="img" class="col-sm-1 col-form-label mr-2">Immagine</label>
				<div class="col-sm-4">
					<input type="file" accept="image/x-png,image/gif,image/jpeg" name="img" id="img" class="form-control"/>
				</div>
				<div class="col-sm-6">
					<form:errors path="img" cssClass="error" />
				</div>
			</div>
			<div class="form-group row">
				<label for="nome" class="col-sm-1 col-form-label mr-2">Nome</label>
				<div class="col-sm-4">
					<form:input path="nome" placeholder="Nome..." class="form-control" />
				</div>
				<div class="col-sm-6">
					<form:errors path="nome" cssClass="error" />
				</div>
			</div>

			<div class="form-group row">
				<label for="nome" class="col-sm-1 col-form-label mr-2">Stipendio</label>
				<div class="col-sm-4">
					<form:input path="stipendio" value="" placeholder="Stipendio..."
						class="form-control" />
				</div>
				<div class="col-sm-6">
					<form:errors path="stipendio" cssClass="error" />
				</div>
			</div>

			<div class="form-group row">
				<label for="nome" class="col-sm-1 col-form-label mr-2">Reparto</label>
				<div class="col-sm-4">
					<form:input path="reparto" placeholder="Reparto..."
						class="form-control" />
				</div>
				<div class="col-sm-6">
					<form:errors path="reparto" cssClass="error" />
				</div>
			</div>

			<button type="submit" class="btn btn-outline-dark"
				style="margin-top: 20px;">Registra impiegato</button>
		</form:form>
	</div>
	<footer class="bg-dark text-light"><%@include
			file="/footer.html"%></footer>
</body>
</html>