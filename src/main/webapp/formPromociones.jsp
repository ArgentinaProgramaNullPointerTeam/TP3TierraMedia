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
	function esconder(tipo) {
		let select = document.getElementById('combo');
		let campo = document.getElementById('descuento');
		if (tipo == 'AXB') {
			select.style.display = "block";
			campo.style.display = "none";
		} else {
			campo.style.display = "block";
			select.style.display = "none";
		}
		if (tipo == "") {
			campo.style.display = "none";
			select.style.display = "none";
		}
	}
</script>
<title>Tierra Media</title>
</head>
<!-- Nav -->
<jsp:include page="/partials/nav.jsp"></jsp:include>

<body>

	<form action="list" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="well well-sm">
						<form class="form-horizontal" method="post">
							<fieldset>
								<legend class="text-right header">Completar los campos</legend>

								<div class="form-group">
									<span class="col-md-1 col-md-offset-2 text-center"><i
										class="fa fa-user bigicon"></i></span>
									<div class="col-md-8">
										<input id="nombrePromocion" name="nombrePromocion" type="text"
											placeholder="Nombre de la promoción" class="form-control">
									</div>
								</div>
								<div class="mb-3">

									<label for="atraccion-select">Tipo de promoción</label> <select
										name="tipoAtraccion" id="tipoAtraccion"
										onclick="esconder(document.getElementById('tipoAtraccion').value)">
										<option value="">--Elegir tipo--</option>
										<option value="Porcentual">Porcentual</option>
										<option value="Absoluta">Absoluta</option>
										<option value="AXB">AXB</option>
									</select>
								</div>
								<div class="mb-3" id="combo" style="display: none;">

									<label for="atraccion-select">Tipo de promoción</label> <select
										name="gratuita" id="gratuita">
										<option value="">--Elegir tipo--</option>
										<option value="Porcentual">Porcentual</option>
										<option value="Absoluta">Absoluta</option>
										<option value="AXB">AXB</option>
									</select>
								</div>
								<div class="form-group">
									<span class="col-md-1 col-md-offset-2 text-center"><i
										class="fa fa-user bigicon"></i></span>
									<div class="col-md-8">
										<input id="descuento" name="descuento" type="number"
											placeholder="Descuento" class="form-control"
											style="display: none;">
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
								</div>

								<div class="mb-3">

									<label for="atraccion-select">Atraccion 2</label> <select
										name="atraccionPreferida" id="atraccionPreferida">
										<option value="">--Elegir atracción--</option>
										<option value="1">Aventura</option>
										<option value="2">Paisaje</option>
										<option value="3">Degustación</option>
									</select>
								</div>
								
								<div class="mb-3">

									<label for="atraccion-select">Atraccion 2</label> <select
										name="atraccionPreferida" id="atraccionPreferida">
										<option value="">--Elegir atracción--</option>
										<option value="1">Aventura</option>
										<option value="2">Paisaje</option>
										<option value="3">Degustación</option>
									</select>
								</div>


								<div class="form-group">
									<div class="col-md-8 text-right">
										<button type="submit" class="btn btn-primary btn-lg">Enviar</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>