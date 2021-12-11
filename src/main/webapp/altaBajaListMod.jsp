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
     <link
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous">
            <link rel="shortcut icon" href="https://http2.mlstatic.com/anillo-unico-poder-el-hobbit-el-senor-de-los-anillos-titanio-D_NQ_NP_626248-MLM25995146386_092017-O.jpg" >
    <title>Tierra Media</title>

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
 <main role="main" class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Usuarios:</h1> 
                    <h4><button type="button" class="btn btn-success"><a href="formUsuarios.jsp">Agregar &#x2795;</button></a></h4>
                    <a href="index.jsp" target="_blank">Tierra Media</a>
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
                                    <td>Usuario1</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                <tr>
                                    <td>Usuario2</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                  <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                 <tr>
                                    <td>Usuario3</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                 <tr>
                                    <td>Usuario4</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                               
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
                    <h1>Atracciones:</h1> 
                    <h4><button type="button" class="btn btn-success"><a href="formAtracciones.jsp">Agregar &#x2795;</button></a></h4>
                    <a href="index.jsp" target="_blank">Tierra Media</a>
                    <div class="table-responsive">
                        <table class="table table-bordered" table style= "background-color:#FFE4C4">
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
                                <tr>
                                    <td>Atraccion1</td> 
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr> 
                                <tr>
                                    <td>Atraccion2</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr>
                                 <tr>
                                    <td>Atraccion3</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr>
                                 <tr>
                                    <td>Atraccion4</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr>
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
                    <h1>Promociones:</h1> 
                    <h4><button type="button" class="btn btn-success"><a href="formPromociones.jsp">Agregar &#x2795;</button></a></h4>
                    <a href="index.jsp" target="_blank">Tierra Media</a>
                    <div class="table-responsive">
                        <table class="table table-bordered" table style= "background-color:#FFE4C4">
                            <thead>
                                <tr>
                                    <th>Promocion</th>
                                    <th>Que incluye</th>
                                    <th>Costo<th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Promocion1</td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr>
                                <tr>
                                    <td>Promocion2</td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr>
                                  <tr>
                                    <td>Promocion3</td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr>
                                  <tr>
                                    <td>Promocion4</td>
                                    <td></td>
                                    <td></td>
                                    <td><button type="button" class="btn btn-danger">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary">Editar &#9998;</button></td>
                                </tr>
                                </tr>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
  
  
  
  
  </body>
  <br>
  <br>
</html>