<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
  <jsp:include page="partials/head.jsp"></jsp:include>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/estiloLogin.css">
    <link rel="shortcut icon" href="https://http2.mlstatic.com/anillo-unico-poder-el-hobbit-el-senor-de-los-anillos-titanio-D_NQ_NP_626248-MLM25995146386_092017-O.jpg" >
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Tierra Media</title>
  </head>
  <!--
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"></a>
    <form class="d-flex">
     <!-- <input class="form-control me-2" type="search" placeholder="Escribi la atracción que buscas" aria-label="Buscar">
      <button class="btn btn-outline-success" type="submit">Buscar</button> NO VA
    </form>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
       <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
     	<a class="nav-link" href="login.jsp">Acceder</a>
        <a class="nav-link" href="/turismo/logout">Salir</a>
        <a class="nav-link" style="margin-left:95px" aria-current="page" href="index.jsp">Inicio</a>
        <a class="nav-link" href="itinerario.jsp">Itinerario Comprado</a>
        <a class="nav-link" href="nosotros.jsp">Sobre nosotros</a>
        
      </div>
    </div>
    </div>
 
</nav> -->

  
<body>
	<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>

<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="https://i.pinimg.com/736x/da/f4/02/daf402e81711f4da6ac306856940b2d8.jpg" class="brand_logo" alt="Logo">
					</div>
					
				</div>
				
				
				<div class="d-flex justify-content-center form_container">
						<form action="login" method="post">
					<h5 style="margin-left:25%; margin-top: 1%;">Tierra Media</h5>
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
						
							<input type="text" name="" class="form-control input_user" value="" placeholder="Usuario">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" name="" class="form-control input_pass" value="" placeholder="Contraseña">
						</div>
						<div class="form-group">
							
						</div>
							<div class="d-flex justify-content-center mt-3 login_container">
				 	<button type="button" name="button" class="btn login_btn">Iniciar sesión</button>
				   </div>
					</form>
				</div>
		
				<div class="mt-4">
					
					
				</div>
			</div>
		</div>
	</div>

</body>

</html>