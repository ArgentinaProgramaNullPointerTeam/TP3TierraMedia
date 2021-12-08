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
  <title> Tierra Media</title>
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
        <a class="nav-link" href="/turismo/logout">Salir</a>
        <a class="nav-link" style="margin-left:95px" aria-current="page" href="index.jsp">Inicio</a>
        <a class="nav-link" href="itinerario.jsp">Itinerario Comprado</a>
        <a class="nav-link" href="nosotros.jsp">Sobre nosotros</a>
        
      </div>
    </div>
  </div>
 
</nav>
  
  <body>
    
       <header>
      <nav>
        <div class="container-fluid">
        
         
           
        </nav>
        <h1 style="margin-top: 8%">Turismo Tierra Media</h1>
      
       </header>
       
      <div class="carruselPrueba">
        <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active" data-interval="10000">
              <img src="assets/img/carruissel.png" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item" data-interval="2000">
              <img src="assets/img/carruissel1.png" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="assets/img/carruissel2.png" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="assets/img/carruissel3.png" class="d-block w-100" alt="...">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Anterior</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Siguiente</span>
          </a>
        </div>
      </div>

    </div>

    <div data-aos="flip-left">      
<h2 style="margin-top: 5%; margin-left: 25%;"><u>A continuación verás nuestra oferta de atracciones</u> </h2> </div>

<div data-aos="fade-right">
    <div class="tarjetasAtracciones">
      <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="assets/img/fondo.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Bosque Negro</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Cupos: 12</li>
            <li class="list-group-item">Tiempo: 4 horas</li>
            <li class="list-group-item">Costo: 3 monedas</li>
            <li class="list-group-item">Tipo: AVENTURA</li>
            </ul>
          <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>

      <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="assets/img/fondo.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Moria</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Cupos: 6</li>
            <li class="list-group-item">Tiempo: 2 horas</li>
            <li class="list-group-item">Costo: 10 monedas</li>
            <li class="list-group-item">Tipo: AVENTURA</li>
            </ul>
            <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>


      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/fondo.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Mordor</h5>
          <ul class="list-group list-group-flush">
          <li class="list-group-item">Cupos: 20</li>
<li class="list-group-item">Tiempo: 5 horas</li>
<li class="list-group-item">Costo: 20 monedas</li>
<li class="list-group-item">Tipo: AVENTURA</li>
</ul>
         <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>
    </div>
  </div>

  <div data-aos="fade-left">

    <div class="tarjetasAtracciones">
      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/fondo.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Lothlórien</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Cupos: 30</li>
            <li class="list-group-item">Tiempo: 1 hora</li>
            <li class="list-group-item">Costo: 35 monedas</li>
            <li class="list-group-item">Tipo: DEGUSTACIÓN</li>
            </ul>
         <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>

      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/fondo.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Erebor</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Cupos: 32</li>
            <li class="list-group-item">Tiempo: 3 horas</li>
            <li class="list-group-item">Costo: 12 monedas</li>
            <li class="list-group-item">Tipo: PAISAJE</li>
            </ul>
         <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>


      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/fondo.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Minas de tirith</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Cupos: 25</li>
            <li class="list-group-item">Tiempo: 2.5 horas</li>
            <li class="list-group-item">Costo: 5 monedas</li>
            <li class="list-group-item">Tipo: PAISAJE</li>
            </ul>
         <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>
    </div>
  </div>

  <div data-aos="fade-right">
    <div class="tarjetasAtracciones">
      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/fondo.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">La comarca</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Cupos: 150</li>
            <li class="list-group-item">Tiempo: 6.5 horas</li>
            <li class="list-group-item">Costo: 3 monedas </li>
            <li class="list-group-item">Tipo: DEGUSTACIÓN</li>
            </ul>
         <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>

      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/fondo.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Abismo de Helm</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Cupos: 15</li>
            <li class="list-group-item">Tiempo: 2 horas</li>
            <li class="list-group-item">Costo: 5 monedas</li>
            <li class="list-group-item">Tipo: PAISAJE</li>
            </ul>
         <a href="#" class="btn btn-success">Comprar atracción</a>
        </div>
      </div>

    </div>
  </div>


  <div data-aos="fade-right">
    <h2 style="margin-top: 5%; margin-left: 30%;"><u>Aquí podrás ver nuestras promociones</u> </h2></div>
    <div data-aos="zoom-in-right">

    <div class="tarjetasAtracciones">
      <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="assets/img/aventura1.jpg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Pack Aventura</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Incluye: Bosque Negro</li>
            <li class="list-group-item">Incluye: Mordor</li>
            <li class="list-group-item">20% descuento</li>
            <li class="list-group-item">Tipo: AVENTURA</li>
            </ul>
          <a href="#" class="btn btn-success">Comprar pack Aventura</a>
        </div>
      </div>
   

      <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="assets/img/degustacion.jpeg" alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Pack degustación</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Incluye: Lothlórien</li>
            <li class="list-group-item">Incluye: La comarca</li>
            <li class="list-group-item">Costo: 36 monedas</li>
            <li class="list-group-item">Tipo: DEGUSTACIÓN
            </li>
            </ul>
            <a href="#" class="btn btn-success">Comprar pack Degustación</a>
        </div>
      </div>


      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/paisaje.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Pack Paisaje</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Incluye: Minas Tirith</li>
            <li class="list-group-item">Incluye: Abismo de Helm</li>
            <li class="list-group-item">Incluye: Erebor de regalo</li>
            <li class="list-group-item">3x2 </li>
            <li class="list-group-item">Tipo: PAISAJE</li>
</ul>
         <a href="#" class="btn btn-success">Comprar pack Paisaje</a>
        </div>
      </div>
    </div>
  </div>

  <div data-aos="fade-left">

    <div class="tarjetasAtracciones">
      <div class="card" style="width: 18rem;">
        <img class="card-img-top"  src="assets/img/aventura2.jpg"  alt="Card image cap">
        <div class="card-body">
          <h5 class="card-title">Pack Aventura Recargado</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">Incluye: Bosque Negro</li>
            <li class="list-group-item">Incluye: Mordor</li>
            <li class="list-group-item">Incluye: La acotada de regalo</li>
            <li class="list-group-item">3x2 </li>
            <li class="list-group-item">Tipo: AVENTURA</li>
            </ul>
         <a href="#" class="btn btn-success">Comprar Pack Recargado</a>
        </div>
      </div>
      </div>
    </div>


    <footer>

   
    <div class="videito" >
      <iframe  src="https://www.youtube.com/embed/3a5k0roFFMg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div>

  <div> <h3 class="footerFrase">Tierra Media creado por Null Pointer Team con sudor y lágrimas jaja</h3>  </div>

    </footer>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script>
      AOS.init();
    </script>
  </body>
</html>