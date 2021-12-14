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
<!-- Nav -->
<jsp:include page="/partials/nav.jsp"></jsp:include>

<!-- CUERPO -->
<body>
	<header>

		<main class="container">
			<div class="bg-light p-1 rounded">
				<h1 style="margin-top: 8%">
					¡Hola, <b><c:out value="${usuario.getNombre()}" /></b>! estás en
					Turismo en la Tierra Media
				</h1>
			</div>
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
		</main>

		<nav>
			<div class="container-fluid">
		</nav>


	</header>

	<!-- Cards -->

	<div class="wrapper">

		<c:forEach items="${productos}" var="productos">

			<div class="card" style="width: 18rem;">
				<h5 class="card-title">${productos.getNombre()}</h5>

				<img class="card-img-top" src="assets/img/fondo.jpg"
					alt="Card image cap">
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Cupos: ${productos.getCupo()}</li>
					<li class="list-group-item">Tiempo:
						${productos.getTiempoDeVisita()} Hs</li>
					<li class="list-group-item">Costo:
						${productos.getCostoDeVisita()} monedas</li>
					<li class="list-group-item">Incluye: ${productos.getIncluye()}</li>
					<li class="list-group-item">Tipo: ${productos.getTipo()}</li>
				</ul>

				<c:choose>
					<c:when
						test="${ usuario.puedeComprar(productos) && productos.hayCupo() }">
						<a
							href="buy.do?id=${ productos.getId() }&esPromo=${ productos.esPromocion() ? 1 : 0 }"
							class="btn btn-success">Comprar</a>
					</c:when>
					<c:otherwise>
						<a
							href="buy.do?id=${ productos.getId() }&esPromo=${ productos.esPromocion() ? 1 : 0 }"
							class="btn btn-secondary disabled">No puede comprar</a>
					</c:otherwise>
				</c:choose>
			</div>
		</c:forEach>

	</div>

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