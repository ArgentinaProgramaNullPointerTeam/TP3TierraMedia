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
                    <div class="table-responsive">
                        <table class="table table-bordered" table style= "background-color:#FFE4C4">
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
                                    <td><c:out value="${ usuarios.getAtraccionPreferida() }"></c:out></td>
                                     <td><c:out value="${ usuarios.getTiempoDisponible() }"></c:out> Hs</td>
                                     <td><c:out value="${ usuarios.getDineroDisponible() }"></c:out> Monedas </td>
                                     <td><c:choose><c:when test="${usuarios.isAdmin()}">Si</c:when>    
                                     <c:otherwise>No</c:otherwise>
                                     </c:choose></td>
                                    <td><button type="button" class="btn btn-danger" onclick ="document.location.href='delete.adm?id=${ usuarios.getId() }'">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary"  onclick ="document.location.href='editarUsuario.adm?id=${ usuarios.getId() }'">Editar &#9998;</button></td>
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
                    <h1>Atracciones:</h1> 
                    <h4><button type="button" class="btn btn-success"><a href="formAtracciones.jsp">Agregar &#x2795;</button></a></h4>
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
                                <c:forEach items="${atracciones}" var="atracciones">
                                <tr>
                                    <td><c:out value="${ atracciones.getNombre() }"></c:out></td>
                                    <td><c:out value="${ atracciones.getCupo() }"></c:out></td>
                                     <td><c:out value="${ atracciones.getTiempoDeVisita() }"></c:out> Hs </td>
                                     <td><c:out value="${ atracciones.getCostoDeVisita() }"></c:out> Monedas </td>
                                     <td><c:out value="${ atracciones.getTipoAtracciones() }"></c:out></td>
                                    <td><button type="button" class="btn btn-danger" onclick ="document.location.href='deleteAtraccion.adm?id=${ atraccion.getId() }'">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary"  onclick ="document.location.href='editAtraccion.adm?id=${ atraccion.getId() }'">Editar &#9998;</button></td>
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
                    <h1>Promociones:</h1> 
                    <h4><button type="button" class="btn btn-success"><a href="createPromo.adm">Agregar &#x2795;</button></a></h4>
                    <div class="table-responsive">
                        <table class="table table-bordered" table style= "background-color:#FFE4C4">
                            <thead>
                                <tr>
                                    <th>Promocion</th>
                                    <th>Tipo</th>
                                    <th>Que incluye</th>
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
                                     <td><c:out value="${ promociones.getCostoDeVisita() }"></c:out> Monedas </td>
                                     <td><c:out value="${ promociones.getTiempoDeVisita() }"></c:out> Hs </td>
                                     <td><c:out value="${ promociones.getCupo() }"></c:out></td>
                                    <td><button type="button" class="btn btn-danger" onclick ="document.location.href='deletePromo.adm?id=${ promociones.getId() }'">Borrar &#10060;</button>&nbsp;&nbsp;
                                       <button type="button" class="btn btn-secondary" onclick ="document.location.href='editPromo.adm?id=${ promociones.getId() }'">Editar &#9998;</button></td>
                                </tr>
                         	</c:forEach> 
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