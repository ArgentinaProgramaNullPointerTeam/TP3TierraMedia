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
    <link rel="stylesheet" href="assets/css/estiloIndex.css">
    <link rel="shortcut icon" href="https://http2.mlstatic.com/anillo-unico-poder-el-hobbit-el-senor-de-los-anillos-titanio-D_NQ_NP_626248-MLM25995146386_092017-O.jpg" >
    <title>Tierra Media</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inconsolata&display=swap" rel="stylesheet">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
  </head>
  
   <!-- Barra de navegacion -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"></a>
    <form class="d-flex">		
     <!-- <input class="form-control me-2" type="search" placeholder="Escribi la atracción que buscas" aria-label="Buscar">
      <button class="btn btn-outline-success" type="submit">Buscar</button> -->
    </form>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
     <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">      
        <a class="nav-link" style="margin-left:5px" aria-current="page" href="index.jsp">Inicio</a>
        <a class="nav-link" href="itinerario.jsp">Itinerario Comprado</a>
        <a class="nav-link" href="nosotros.jsp">Sobre nosotros</a>
      </div>
      
     <ul class="navbar-nav">
      <li class="nav-item dropdown" style="margin-left:800px">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${usuario.getNombre()}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: gold;" class="bi bi-coin"></i> <c:out value="${usuario.getDineroDisponible()}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i> <c:out value="${usuario.getTiempoDisponible()}"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="logout" style="margin-left:14px" class="btn btn-success">Cerrar sesión</a>
					</ul>
				</li>
				</ul>
    </div>
  </div>
 
</nav>

				<!-- CUERPO -->		
  <body>
    <main role="main" class="container">
            <div class="row">
                <div class="col-12">
                    <h2 style="margin-top: 7%">Su itinerario de compras:</h2> 
                    <div class="table-responsive">
                        <table class="table table-bordered" table style= "background-color:#FFE4C4">
                            <thead>
                                <tr>
                                    <th>Usuario</th>
                                    <th>Le gusta</th>
                                    <th>Tiempo disponible</th>
                                    <th>Monedas</th>
                                   
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
                    </div>
                </div>
            </div>
        </main>
        
  </body>
</html>