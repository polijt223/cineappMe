<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Listado de Horarios</title>
    <meta charset="utf-8">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">   
    <spring:url value="/usuarios/index" var="urlRoot"></spring:url>
    <spring:url value="/usuarios/create" var="urlForm"></spring:url>
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/usuarios/delete" var="urlDelete"></spring:url>
    <spring:url value="/usuarios/activar" var="urlActivar"></spring:url>
    <spring:url value="/usuarios/edit" var="urlEdit"></spring:url>
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
	  
      <h3>Listado de Usuarios</h3>
      <c:if test="${mensaje != null }">
      	<div class="alert alert-success">${mensaje }</div>
      </c:if>
      <a href="${urlForm }" class="btn btn-success" role="button" title="Nueva Horario" >Nuevo</a><br><br>

		<div class="table-responsive">
        <table id="table_id" class="display table table-hover table-striped table-bordered" style="width: 100%">
            <thead>
            <tr>
            	<th>Id</th>
                <th>cuenta</th>
                <th>activo</th>
                <th>email</th>
                <th>telefono</th>
            </tr>
            <thead>
            <tbody>
            <c:forEach items="${listaUsuario }" var="usuario">
	            <tr>
	            	<td>${usuario.id}</td>
	                <td>${usuario.cuenta}</td>
	                <c:choose>
	                	<c:when test="${usuario.activo==1 }">
	                		<td class="success">Activo</td>
	                	</c:when>
	                	<c:otherwise>
	                		<td class="danger">Inactivo</td>
	                	</c:otherwise>
	                </c:choose>
	                
	                <td>${usuario.email}</td>
	                <td>${usuario.telefono}</td>              
	                <td>
						<a href="${urlEdit}/${usuario.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
						
						<c:choose>
							<c:when test="${usuario.activo == 1 }">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal${usuario.id}Desactivar">
								  Desactivar <span class="glyphicon glyphicon-trash"></span>
								</button>
								
								<!-- Modal -->
								<div class="modal fade" id="myModal${usuario.id}Desactivar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title" id="myModalLabel">Desactivar</h4>
								      </div>
								      <div class="modal-body">
								        ¿Decea desactivar la cuenta? 
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								        <a href="${urlDelete}/${usuario.id}" class="btn btn-danger btn-sm" role="button" title="Eliminar" >
			                    		Desactivar cuenta</a>
								      </div>
								    </div>
								  </div>
								</div>
							</c:when>
							<c:otherwise>
								<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal${usuario.id}Activar">
								  Activar <span class="glyphicon glyphicon-trash"></span>
								</button>
								<!-- Modal -->
								<div class="modal fade" id="myModal${usuario.id}Activar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title" id="myModalLabel">Activar</h4>
								      </div>
								      <div class="modal-body">
								        ¿Decea Activar la cuenta? 
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								        <a href="${urlActivar}/${usuario.id}" class="btn btn-danger btn-sm" role="button" title="Eliminar" >
			                    		Activar cuenta</a>
								      </div>
								    </div>
								  </div>
								</div>
							</c:otherwise>
						</c:choose>
						
						
						
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
    </script>
  </body>
</html>