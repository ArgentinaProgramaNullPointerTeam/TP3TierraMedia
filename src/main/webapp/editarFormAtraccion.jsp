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
<!-- Script para los selects -->
<script src="assets/js/selects.jsp"></script>
</head>
<!-- Nav -->
<jsp:include page="/partials/nav.jsp"></jsp:include>
<body>
	<main class="container">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="well well-sm">

						<fieldset>
							<legend style="margin-top: 40px" class="text-right header">Completar
								los campos de una Atracción:</legend>
							<c:if
								test="${atraccionEditar != null && !atraccionEditar.isValid()}">
								<div class="alert alert-danger">
									<p>Se encontraron errores al crear la atracción.</p>
								</div>
							</c:if>
							<form action="editAtraccion.adm" method="post">
								<input type="hidden" name="id"
									value="${ atraccionEditar.getId() }">
								<div class="mb-3">
									<label for="name" class="col-form-label">Nombre de la
										atracción:</label> <input type="text" class="form-control" id="nombre"
										name="nombre" required value="${atraccionEditar.getNombre() }">
								</div>


								<div class="mb-3">
									<label for="cupo" class="col-form-label">Cupos:</label> <input
										type="text" class="form-control" id="cupo" name="cupo"
										required value="${atraccionEditar.getCupo() }">
								</div>

								<div class="mb-3">
									<label for="duracion"
										class='col-form-label ${atraccionEditar.errors.get("tiempoDeVisita") != null ? "is-invalid" : "" }'>Tiempo:</label>
									<input class="form-control" type="number" id="duracion"
										name="duracion" required
										value="${atraccionEditar.getTiempoDeVisita()}"></input>
									<div class="invalid-feedback">
										<c:out value='${atraccionEditar.errors.get("tiempoDeVisita")}'></c:out>
									</div>
								</div>

								<div class="mb-3">
									<label for="costo"
										class='col-form-label ${atraccionEditar.errors.get("costoDeVisita") != null ? "is-invalid" : "" }'>Costo:</label>
									<input class="form-control" type="number" id="costo"
										name="costo" required
										value="${atraccionEditar.getCostoDeVisita()}"></input>
									<div class="invalid-feedback">
										<c:out value='${atraccionEditar.errors.get("costoDeVisita")}'></c:out>
									</div>
								</div>

								<div class="mb-3">
									<label for="atraccion-select">Tipo</label> <select
										name="tipoAtraccion" id="tipoAtraccion" required="required">
										<option value="">--Elegir atracción--</option>
										<option value="1">Aventura</option>
										<option value="2">Paisaje</option>
										<option value="3">Degustación</option>
									</select>
								</div>
								<script type="text/javascript"> seleccionado(${atraccionEditar.getTipoAtracciones() }, 'tipoAtraccion');</script>
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
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
	<script>
		AOS.init();
	</script>
</body>
</html>