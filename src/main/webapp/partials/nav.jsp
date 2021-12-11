<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Barra de navegacion -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"></a>
		<form class="d-flex">
			<!-- <input class="form-control me-2" type="search" placeholder="Escribi la atracción que buscas" aria-label="Buscar">
      <button class="btn btn-outline-success" type="submit">Buscar</button> -->
		</form>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavAltMarkup"
			aria-controls="navbarNavAltMarkup" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-link" style="margin-left: 5px" aria-current="page"
					href="index.jsp">Inicio</a> <a class="nav-link"
					href="itinerario.jsp">Itinerario</a> 
					<c:if test="${ usuario.isAdmin() }">
			<a class="nav-link"
					href="abm.adm">ABM</a>
		</c:if>
		<a class="nav-link"
					href="nosotros.jsp">Sobre nosotros</a>
			</div>

			<ul class="navbar-nav">
				<li class="nav-item dropdown" style="margin-left: 800px"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${usuario.getNombre()}"></c:out>
				</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="monedas" style="color: gold;" class="bi bi-coin"></i>
								<c:out value="${usuario.getDineroDisponible()}"></c:out> Monedas
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i>
								<c:out value="${usuario.getTiempoDisponible()}"></c:out> Hs
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="logout" style="margin-left: 14px"
							class="btn btn-success">Cerrar sesión</a>
					</ul></li>
			</ul>
		</div>
	</div>

</nav>
