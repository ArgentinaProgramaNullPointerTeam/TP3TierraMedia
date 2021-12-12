<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/estiloForms.css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Tierra Media</title>
</head>
<jsp:include page="/partials/nav.jsp"></jsp:include>

<body>

	<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="well well-sm">
							<fieldset>
								<legend style="margin-top: 40px" class="text-right header">Completar
									los campos de una nueva Promoción:</legend>
								<form action="create.adm" method="post">
								
									<div class="mb-3">
										<label for="name" class="col-form-label">Nombre de la promoción:</label> <input
											type="text" class="form-control" id="nombre" name="nombre"
											required value="">
									</div>
									
									
									</div>
									<div class="mb-3">
										<label for="promocion-select">Tipo</label> <select
											name="tipo" id="tipo">
											<option value="">--Elegir opción--</option>
											<option value="1">AxB</option>
											<option value="2">Porcentual</option>
											<option value="3">Absoluta</option>
										</select>
									</div>
									
									<div class="mb-3">
										<label for="costo"
											class='col-form-label ${promocion.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
										<input class="form-control" type="number" id="costo"
											name="costo" required value="${promocion.setCostoDeVisita()}"></input>
										<div class="invalid-feedback">
											<c:out value='${promocion.errors.get("costo")}'></c:out>
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

</body>
</html>