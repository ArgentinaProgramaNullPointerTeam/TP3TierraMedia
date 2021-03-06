<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon"
	href="https://http2.mlstatic.com/anillo-unico-poder-el-hobbit-el-senor-de-los-anillos-titanio-D_NQ_NP_626248-MLM25995146386_092017-O.jpg">
<link rel="stylesheet" href="assets/css/estiloLogin.css">
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>

	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<main>
			<h1
				style="border-radius: 60px 60px 60px 60px; margin-left:4%; font-weight: bold; padding: 4px; background-color: #808080;">Turismo
				en la Tierra Media</h1>
			<br>
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

			<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>

			<form action="login" method="post">

				<div class="mb-3">
					<label
						style="border-radius: 60px 60px 60px 60px; padding: 10px; background-color: #808080; color: black; font-family: arial, helvetica; font-size: 14px; font-weight: bold"
						for="username" class="form-label">Usuario:</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label
						style="border-radius: 60px 60px 60px 60px; padding: 10px; background-color: #808080; color: black; font-family: arial, helvetica; font-size: 14px; font-weight: bold"
						for="password" class="form-label">Contraseña:</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-lg btn-dark">Iniciar
						sesión</button>
				</div>
			</form>
		</main>
	</div>
</body>
</html>