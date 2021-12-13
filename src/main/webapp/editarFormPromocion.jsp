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

<!-- script de los selects -->
<script src="assets/js/selects.jsp"></script>
<title>Tierra Media</title>
</head>
<!-- Nav -->
<jsp:include page="/partials/nav.jsp"></jsp:include>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="well well-sm">
					<fieldset>
						<legend style="margin-top: 40px" class="text-right header">Completar
							los campos de una nueva promo:</legend>
						<c:if test="${promociones != null && !promociones.isValid()}">
							<div class="alert alert-danger">
								<p>Se encontraron errores la promo.</p>
							</div>
						</c:if>
						<form action="editPromo.adm" method="post">
							<input type="hidden" name="id" value="${ promociones.getId() }">
							<div class="form-group">
								<span class="col-md-1 col-md-offset-2 text-center"><i
									class="fa fa-user bigicon"></i></span>
								<div class="col-md-8">
									<input id="nombre" name="nombre" type="text"
										placeholder="Nombre de la promoción" required
										value="${promociones.getNombre()}" class="form-control">
								</div>
							</div>
							<div class="mb-3">

								<label for="atraccion-select">Tipo de promoción</label> <select
									name="tipo" id="tipo" required="required" disabled>
									<option value="">--Elegir tipo--</option>
									<option value="Porcentual">Porcentual</option>
									<option value="Absoluta">Absoluta</option>
									<option value="AXB">AXB</option>
								</select>
								<script type="text/javascript"> seleccionado('${promociones.getTipoDePromocion()}', 'tipo');</script>
							</div>
							<div class="mb-3" id="combo" style="display: none;">
								<label for="atraccion-select">Gratuita</label> <select
									name="atraccion3" id="atraccion3">
									<option value="">--Elegir atracción--</option>
									<c:forEach items="${atracciones}" var="atracciones">
										<option value="${atracciones.getId()}">${atracciones.getNombre()}</option>
									</c:forEach>
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
							<input type="hidden" name="tipos" value="${ promociones.getTipoDePromocion() }">
							<script type="text/javascript"> mostrar('${promociones.getTipoDePromocion()}');</script>
							<div class="mb-3">
								<label for="atraccion-select">¿Qué le gusta?</label> <select
									name="tipoAtraccion" id="tipoAtraccion">
									<option value="">--Elegir tipo--</option>
									<option value="1">Aventura</option>
									<option value="2">Paisaje</option>
									<option value="3">Degustación</option>
								</select>
								<script type="text/javascript"> seleccionado(${promociones.getTipoAtracciones()}, 'tipoAtraccion');</script>
							</div>

							<div class="mb-3">

								<label for="atraccion-select">Atraccion 1</label> <select
									name="atraccion1" id="atraccion1" required="required">
									<option value="">--Elegir atracción--</option>
									<c:forEach items="${atracciones}" var="atracciones">
										<option value="${atracciones.getId()}">${atracciones.getNombre()}</option>
									</c:forEach>
								</select>
								<script type="text/javascript"> seleccionado(${promociones.getAtracciones().get(0).getId()}, 'atraccion1');</script>

							</div>

							<div class="mb-3">

								<label for="atraccion-select">Atraccion 2</label> <select
									name="atraccion2" id="atraccion2" required="required">
									<option value="">--Elegir atracción--</option>
									<c:forEach items="${atracciones}" var="atracciones">
										<option value="${atracciones.getId()}">${atracciones.getNombre()}</option>
									</c:forEach>
								</select>
								<script type="text/javascript"> seleccionado(${promociones.getAtracciones().get(1).getId()}, 'atraccion2');</script>
							</div>


							<div class="form-group">
								<div class="col-md-8 text-right">
									<button type="submit" class="btn btn-primary btn-lg">Hecho</button>
									<a onclick="window.history.back();" class="btn btn-secondary"
										role="button">Cancelar</a>
								</div>
							</div>
						</form>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</body>
</html>