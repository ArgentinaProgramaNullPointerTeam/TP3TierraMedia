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
<link rel="stylesheet" href="assets/css/estiloIndex.css">
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
<jsp:include page="/partials/nav.jsp"></jsp:include>

<!-- CUERPO -->
<body>

	<main role="main" class="container">
		<div class="row">
			<div class="col-12">
				<h2 style="margin-top: 7%">Su itinerario de compras:</h2>

				<c:choose>
					<c:when test="${flash != null}">
						<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
					</c:when>

					<c:otherwise>
						<div class="table-responsive">
							<table class="table table-bordered" table
								style="background-color: #FFE4C4">
								<thead>
									<tr>
										<th>Producto</th>
										<th>Incluye</th>
										<th>Costo</th>
										<th>Tiempo</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td><c:out value="${usuario.getNombre()}"></c:out></td>
										<td><c:out value="${usuario.getAtraccionPreferida()}"></c:out></td>
										<td><c:out value="${usuario.getTiempoDisponible()}"></c:out></td>
										<td><c:out value="${usuario.getDineroDisponible()}"></c:out></td>
									</tr>

								</tbody>
							</table>
							<h2 style="margin-top: 7%">Usted gastó:</h2>
							<h2 style="margin-top: 7%">Le queda:</h2>
						</div>
					</c:otherwise>

				</c:choose>

			</div>
		</div>
	</main>

</body>
</html>