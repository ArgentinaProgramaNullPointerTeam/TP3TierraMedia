<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="assets/css/estiloForms.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Tierra Media</title>
</head>
<!-- Nav -->
<jsp:include page="/partials/nav.jsp"></jsp:include>
<body>

	<main class="container">

		<c:if test="${usuario != null && !usuario.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear el usuario.</p>
			</div>
		</c:if>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="well well-sm">
						<form action="login" method="post">
							<fieldset>
								<legend style="margin-top:40px" class="text-right header">Completar los campos de un nuevo Usuario:</legend>
								<form action="create.adm" method="post">
									<div class="mb-3">
										<label for="name" class="col-form-label">Usuario:</label> <input
											type="text" class="form-control" id="name" name="nombre"
											required value="">
									</div>
									<div class="mb-3">
										<label for="password"
											class='col-form-label ${usuarios.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
										<input class="form-control" id="password" name="password"
											required value="${usuarios.setPassword()}"></input>
										<div class="invalid-feedback">
											<c:out value='${usuarios.errors.get("password")}'></c:out>
										</div>
									</div>
									<div class="mb-3">
										<label for="name" class="col-form-label">¿Qué le
											gusta?:</label> <input type="text" class="form-control"
											id="queLeGusta" name="queLeGusta" required
											value="${usuarios.setAtraccionPreferida()}">
									</div>
									<div class="mb-3">
										<label for="coins"
											class='col-form-label ${usuarios.errors.get("coins") != null ? "is-invalid" : "" }'>Monedas:</label>
										<input class="form-control" type="number" id="coins"
											name="coins" required
											value="${usuarios.setDineroDisponible()}"></input>
										<div class="invalid-feedback">
											<c:out value='${usuarios.errors.get("coins")}'></c:out>
										</div>
									</div>

									<div class="mb-3">
										<label for="time"
											class='col-form-label ${usuarios.errors.get("time") != null ? "is-invalid" : "" }'>Tiempo:</label>
										<input class="form-control" type="number" id="time"
											name="time" required value="${usuarios.setTiempoDisponible()}"></input>
										<div class="invalid-feedback">
											<c:out value='${usuarios.errors.get("time")}'></c:out>
										</div>
									</div>



									<div>
										<button type="submit" class="btn btn-primary">Hecho</button>
										<a onclick="window.history.back();" class="btn btn-secondary"
											role="button">Cancelar</a>
									</div>
									<br>
									<br>
							</fieldset>
						</form>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>