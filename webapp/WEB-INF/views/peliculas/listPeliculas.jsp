<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Listado de Peliculas</title>
    <meta charset="utf-8">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">   
    <spring:url value="/" var="urlRoot"></spring:url>
    <spring:url value="/peliculas/create" var="urlCreate"></spring:url>
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/peliculas/delete" var="urlDelete"></spring:url>
    <spring:url value="/peliculas/save" var="urlForm"></spring:url>
    <spring:url value="/peliculas/edit" var="urlEdit"></spring:url>
    <spring:url value="/peliculas" var="urlPeliculas"></spring:url>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${urlPublic }/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic }/fontawesome/all.css">
   	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/theme.css">
   	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	

  </head>

  <body>

    <!-- Fixed navbar  los dos puntos .. sirven para volver al directorio anterior -->
    <jsp:include page="../includesss/menu.jsp"></jsp:include>


    <div class="container theme-showcase" role="main">

      <h3>Listado de Peliculas</h3> <br/>
      
      <c:if test="${mensaje != null }">
      	<div class="alert alert-success">${mensaje }</div>
      </c:if>
      <a href="${urlCreate }" class="btn btn-success" role="button" title="Nueva Pelicula" >Nueva</a><br><br>
	
      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Titulo</th>
                <th>Portada</th>
                <th>Genero</th>
                <th>Clasificacion</th>
                <th>Duracion</th>
                <th>Fecha Estreno</th>
                <th>Estatus</th>
                <th>Opciones</th>
            </tr>
            <c:forEach var="pelicula" items="${peliculas.content}">	
            	<tr>
            	
            		<td>${pelicula.titulo}</td>
            		<td><img alt="imagen" height="100px" width="80px" src="${urlPublic }/images/${pelicula.imagen}"></td>
	                <td>${pelicula.genero}</td>
	                <td>${pelicula.clasificacion}</td>
	                <td>${pelicula.duracion}</td>
	                <td><fmt:formatDate value="${ pelicula.fechaEstreno }" pattern="dd-MM-yyyy"/></td>
	                <c:choose>
	                	<c:when test="${pelicula.estatus == 'Activa'}">
	                		<td><span class="label label-success">${pelicula.estatus}</span></td>
	                	</c:when>
	                	<c:otherwise>
	                		<td><span class="label label-danger">${pelicula.estatus}</span></td>
	                	</c:otherwise>
	                </c:choose>
	                <td>
	                    <a href="${urlEdit }/${pelicula.id}" class="btn btn-success btn-sm" role="button" title="Edit" >
	                    	<span class="glyphicon glyphicon-pencil"></span>
	                    </a>
	                    <!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal${pelicula.id}">
						  <span class="glyphicon glyphicon-trash"></span>
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="myModal${pelicula.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
						        <a href="${urlDelete}/${pelicula.id}" class="btn btn-danger btn-sm" role="button" title="Eliminar" >
	                    		<span class="glyphicon glyphicon-trash"></span></a>
						      </div>
						    </div>
						  </div>
						</div>
	                </td>
            	
            	</tr>
            </c:forEach>
        </table>
        <nav aria-label="">
			<ul class="pager">
				<li><a href="${urlPeliculas}/indexPaginate?page=${peliculas.number - 1 }">Anterior</a></li>
				<li><a href="${urlPeliculas}/indexPaginate?page=${peliculas.number + 1 }">Siguiente</a></li>
			</ul>
		</nav>
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
    <script type="text/javascript" src="${urlPublic }/javascript/functions.js"></script>
    
  </body>
</html>
