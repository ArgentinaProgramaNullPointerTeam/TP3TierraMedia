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
<script type="text/javascript">
function seleccionado(valueToSelect, id) {   
    let element = document.getElementById(id);
    element.value = valueToSelect;
}
</script>
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
						<fieldset>
							<legend style="margin-top: 40px" class="text-right header">Completar
								los campos de un nuevo Usuario:</legend>
							<form action="editarUsuario.adm" method="post">
							<input type="hidden" name="id" value="${ usuario.getId() }">
								<div class="mb-3">
									<label for="admin-select">¿Es administrador?</label> <select
										name="isAdmin" id="isAdmin"
										selected="${usuario.isAdmin() ? 1 : 0}">
										<option value="">--Elegir opción--</option>
										<option value="1">Si</option>
										<option value="2">No</option>
									</select>
									<script type="text/javascript"> seleccionado(${usuario.isAdmin() ? 1 : 0}, 'isAdmin');</script>
								</div>

								<div class="mb-3">
									<label for="name" class="col-form-label">Nombre de
										usuario:</label> <input type="text" class="form-control" id="nombre"
										name="nombre" required value="${usuario.getNombre()}">
								</div>

								<div class="mb-3">
									<label for="password"
										class='col-form-label ${usuarios.errores.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
									<input class="form-control" id="password" name="password"
										required value="${usuario.getPassword()}"></input>
									<div class="invalid-feedback">
										<c:out value='${usuarios.errores.get("password")}'></c:out>
									</div>
								</div>
								<div class="mb-3">

									<label for="atraccion-select">¿Qué le gusta?</label> <select
										name="atraccionPreferida" id="atraccionPreferida">
										<option value="">--Elegir atracción--</option>
										<option value="1">Aventura</option>
										<option value="2">Paisaje</option>
										<option value="3">Degustación</option>
									</select>
									<script type="text/javascript"> seleccionado(${usuario.getAtraccionPreferida()}, 'atraccionPreferida');</script>
								</div>
								<div class="mb-3">
									<label for="coins"
										class='col-form-label ${usuarios.errores.get("dineroDisponible") != null ? "is-invalid" : "" }'>Monedas:</label>
									<input class="form-control" type="number" id="dineroDisponible"
										name="dineroDisponible" required
										value="${usuario.getDineroDisponible()}"></input>
									<div class="invalid-feedback">
										<c:out value='${usuarios.errores.get("dineroDisponible")}'></c:out>
									</div>
								</div>

								<div class="mb-3">
									<label for="time"
										class='col-form-label ${usuarios.errores.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo:</label>
									<input class="form-control" type="number" id="tiempoDisponible"
										name="tiempoDisponible" required
										value="${usuario.getTiempoDisponible()}"></input>
									<div class="invalid-feedback">
										<c:out value='${usuarios.errores.get("tiempoDisponible")}'></c:out>
									</div>
								</div>



								<div>
									<button type="submit" class="btn btn-primary">Hecho</button>
									<a onclick="window.history.back();" class="btn btn-secondary"
										role="button">Cancelar</a>
								</div>
								<br> <br>
							</form>
						</fieldset>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>