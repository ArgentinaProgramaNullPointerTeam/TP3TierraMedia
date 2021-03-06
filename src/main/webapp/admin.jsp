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
<link rel="stylesheet" href="assets/css/estiloABM&Ventas.css">
<link rel="shortcut icon"
	href="https://http2.mlstatic.com/anillo-unico-poder-el-hobbit-el-senor-de-los-anillos-titanio-D_NQ_NP_626248-MLM25995146386_092017-O.jpg">
<title>Tierra Media</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Inconsolata&display=swap"
	rel="stylesheet">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

</head>

<!-- Barra de navegacion -->
<!-- Nav -->
<jsp:include page="/partials/nav.jsp"></jsp:include>

<br>
<br>
<br>
<body>

	<!-- TABLAS ALTA BAJA LISTADO MODIFICACION -->



	<!-- Usuarios -->
	<main style="margin-top: 2%" role="main" class="container">
		<div class="row">
			<div class="col-12">
				<h1>&#8226;Usuarios:</h1>
				<h4>
					<button type="button" class="btn btn-success"
						onclick="document.location.href='create.adm'">Agregar
						&#x2795;</button>
				</h4>
				<div class="table-responsive">
					<table class="table table-bordered" table
						style="background-color: #FFE4C4">
						<thead>
							<tr>
								<th>Usuario</th>
								<th>Le gusta</th>
								<th>Tiempo disponible</th>
								<th>Monedas</th>
								<th>Es admin</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${usuarios}" var="usuarios">
								<tr>
									<td><c:out value="${ usuarios.getNombre() }"></c:out></td>
									<td><c:out value="${ usuarios.getTipo() }"></c:out></td>
									<td><c:out value="${ usuarios.getTiempoDisponible() }"></c:out>
										Hs</td>
									<td><c:out value="${ usuarios.getDineroDisponible() }"></c:out>
										Monedas</td>
									<td><c:choose>
											<c:when test="${usuarios.isAdmin()}">Si</c:when>
											<c:otherwise>No</c:otherwise>
										</c:choose></td>
									<td><button type="button" class="btn btn-danger"
											onclick="document.location.href='delete.adm?id=${ usuarios.getId() }'">Borrar
											&#10060;</button>&nbsp;&nbsp;
										<button type="button" class="btn btn-secondary"
											onclick="document.location.href='editarUsuario.adm?id=${ usuarios.getId() }'">Editar
											&#9998;</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

	<br>

	<!-- Atracciones -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-12">
				<h1>&#8226;Atracciones:</h1>
				<h4>
					<button type="button" class="btn btn-success"
						onclick="document.location.href='formAtracciones.jsp'">Agregar
						&#x2795;</button>
				</h4>
				<div class="table-responsive">
					<table class="table table-bordered" table
						style="background-color: #FFE4C4">
						<thead>
							<tr>
								<th>Atraccion</th>
								<th>Cupos</th>
								<th>Tiempo</th>
								<th>Costo</th>
								<th>Tipo</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${atracciones}" var="atracciones">
								<tr>
									<td><c:out value="${ atracciones.getNombre() }"></c:out></td>
									<td><c:out value="${ atracciones.getCupo() }"></c:out></td>
									<td><c:out value="${ atracciones.getTiempoDeVisita() }"></c:out>
										Hs</td>
									<td><c:out value="${ atracciones.getCostoDeVisita() }"></c:out>
										Monedas</td>
									<td><c:out value="${ atracciones.getTipo() }"></c:out></td>
									<td><button type="button" class="btn btn-danger"
											onclick="document.location.href='deleteAtraccion.adm?id=${ atracciones.getId() }'">Borrar
											&#10060;</button>&nbsp;&nbsp;
										<button type="button" class="btn btn-secondary"
											onclick="document.location.href='editAtraccion.adm?id=${ atracciones.getId() }'">Editar
											&#9998;</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>


	<br>

	<!-- Promociones -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-12">
				<h1>&#8226;Promociones:</h1>
				<h4>
					<button type="button" class="btn btn-success"
						onclick="document.location.href='createPromo.adm'">Agregar
						&#x2795;</button>
				</h4>
				<div class="table-responsive">
					<table class="table table-bordered" table
						style="background-color: #FFE4C4">
						<thead>
							<tr>
								<th>Promocion</th>
								<th>Tipo</th>
								<th>Que incluye</th>
								<th>Tipo</th>
								<th>Costo</th>
								<th>Tiempo</th>
								<th>Cupo</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${promociones}" var="promociones">
								<tr>
									<td><c:out value="${ promociones.getNombre() }"></c:out></td>
									<td><c:out value="${ promociones.getTipoDePromocion() }"></c:out></td>
									<td><c:out value="${ promociones.getIncluye() }"></c:out></td>
									<td><c:out value="${ promociones.getTipo() }"></c:out></td>
									<td><c:out value="${ promociones.getCostoDeVisita() }"></c:out>
										Monedas</td>
									<td><c:out value="${ promociones.getTiempoDeVisita() }"></c:out>
										Hs</td>
									<td><c:out value="${ promociones.getCupo() }"></c:out></td>
									<td><button type="button" class="btn btn-danger"
											onclick="document.location.href='deletePromo.adm?id=${ promociones.getId() }'">Borrar
											&#10060;</button>&nbsp;&nbsp; <br>
										<button style= "margin-top:7px" type="button" class="btn btn-secondary"
											onclick="document.location.href='editPromo.adm?id=${ promociones.getId() }'">Editar
											&#9998;</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
<br>
<br>
</html>