<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Listado de Banners</title>
    <meta charset="utf-8">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">   
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/banners/search" var="urlSearch"></spring:url>
    <spring:url value="/banners/create" var="urlForm"></spring:url>
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/banners/delete" var="urlDelete"></spring:url>
    <spring:url value="/banners/save" var="urlCreate"></spring:url>
    <spring:url value="/banners/edit" var="urlEdit"></spring:url>
    <spring:url value="/banners" var="urlHorarios"></spring:url>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${urlPublic }/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic }/fontawesome/all.css">
   	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/theme.css">
   	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
   	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/dataTables.bootstrap.min.css">
   	

  </head>

  <body>

    <!-- Fixed navbar  los dos puntos .. sirven para volver al directorio anterior -->
    <jsp:include page="../includesss/menu.jsp"></jsp:include>


    <div class="container theme-showcase" role="main">

      <h3>Listado de imagenes del Banner</h3>
      
      <c:if test="${mensaje != null }">
      	<div class="alert alert-success">${mensaje }</div>
      </c:if>
      <a href="${urlForm }" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>

      <div class="table-responsive">
        <table id="table_id" class="display table table-hover table-striped table-bordered" style="width: 100%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Titulo</th>                           
                <th>Fecha Publicacion</th>              
                <th>Nombre Archivo</th>
                <th>Estatus</th>
                <th>Banner</th>
                <th>Opciones</th>              
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${banners }" var="banner">		
	            <tr>
	                <td>${banner.id }</td>
	                <td>${banner.titulo }</td>
	                <td><fmt:formatDate value="${banner.fecha }" pattern="dd-MM-yyyy"/></td>    
	                <td>${banner.imagen }</td> 
	                <c:choose>
	                	<c:when test="${banner.estatus == 'Activo'}">
	                		<td><span class="label label-success">${banner.estatus }</span></td>
	                	</c:when>
	                	<c:otherwise>
	                		<td><span class="label label-danger">${banner.estatus }</span></td>
	                	</c:otherwise>
	                </c:choose> 
	                <td>
	                	<!-- Button trigger modal -->
						<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${banner.id}imagen">
						  Ver banner
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="myModal${banner.id}imagen" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog modal-lg" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">${banner.titulo }</h4>
						      </div>
						      <div class="modal-body">
						        <img alt="${banner.titulo }" src="${urlPublic }/images/${banner.imagen }" class="img-responsive img-thumbnail"/> 
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						      </div>
						    </div>
						  </div>
						</div>
	                </td>                       
	                <td>
	                    <a href="${urlEdit }/${banner.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
	                    
	                    <!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal${banner.id}">
						  <span class="glyphicon glyphicon-trash"></span>
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="myModal${banner.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">Eliminar</h4>
						      </div>
						      <div class="modal-body">
						        ¿Decea eliminar el registro? 
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        <a href="${urlDelete}/${banner.id}" class="btn btn-danger btn-sm" role="button" title="Eliminar" >
	                    		<span class="glyphicon glyphicon-trash"></span></a>
						      </div>
						    </div>
						  </div>
						</div>
	                </td>
	            </tr>
	        </c:forEach> 
	        </tbody>   
        </table>
      </div>  
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includesss/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script type="text/javascript" src="${urlPublic }/bootstrap/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${urlPublic }/bootstrap/js/popper.min.js"></script>
    <script type="text/javascript" src="${urlPublic }/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${urlPublic }/bootstrap/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${urlPublic }/bootstrap/js/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="${urlPublic }/javascript/functions.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <script>
    $(document).ready( function () {
    $('#table_id').DataTable();
	} );
    
      $(function () {
          $("#fechaActualBusqueda").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>