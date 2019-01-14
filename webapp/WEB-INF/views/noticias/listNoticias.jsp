<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Listado de Noticias</title> 
    <meta charset="utf-8">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">   
    <spring:url value="/resources" var="urlPublic"></spring:url>
    <spring:url value="/noticias/create" var="urlForm"></spring:url>
    <spring:url value="/noticias/delete" var="urlDelete"></spring:url>
    <spring:url value="/noticias/edit" var="urlEdit"></spring:url>
    <spring:url value="/noticias" var="urlNoticias"></spring:url>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${urlPublic }/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic }/fontawesome/all.css">
   	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/theme.css">

  </head>

  <body>

    <!-- Fixed navbar  los dos puntos .. sirven para volver al directorio anterior -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>


    <div class="container theme-showcase" role="main">
	  
      <h3>Listado de Noticias</h3>
      
      <c:if test="${mensaje != null }">
      	<div class="alert alert-success">${mensaje }</div>
      </c:if>
      <a href="${urlForm}" class="btn btn-success" role="button" title="Nueva Noticia" >Nueva</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Fecha</th>              
                <th>Estatus</th> 
                <th>Detalle</th>             
                <th>Opciones</th>              
            </tr>
            <c:forEach items="${listaNoticias.content }" var="noticia">	
	            <tr>
	                <td>${noticia.id }</td>
	                <td>${noticia.titulo }</td>
	                <td><fmt:formatDate value="${noticia.fecha }" pattern="dd-MM-yyyy"/></td>              
	                <td><span class="label label-success">${noticia.status}</span></td>
	                <td>
	                	 <!-- Button trigger modal -->
						<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal${noticia.id}">
						  Ver Detalle
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="myModal${noticia.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">Detalle de noticia ${noticia.id }</h4>
						      </div>
						      <div class="modal-body">
						        ${noticia.detalle} 
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						      </div>
						    </div>
						  </div>
						</div>
	                </td>
	                
	                <td>
	                    <a href="${urlEdit }/${noticia.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
	                    
	                     <!-- Button trigger modal -->
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal${noticia.id}delete">
						  <span class="glyphicon glyphicon-trash"></span>
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="myModal${noticia.id}delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						        <h4 class="modal-title" id="myModalLabel">Eliminar</h4>
						      </div>
						      <div class="modal-body">
						        Seguro decea eliminar, Noticia: ${noticia.id }
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						        <a href="${urlDelete }/${noticia.id}" class="btn btn-danger btn-sm" role="button" title="Eliminar" >
						        	Eliminar <span class="glyphicon glyphicon-trash"></span>
						        </a>
						      </div>
						    </div>
						  </div>
						</div>
	                </td>
	            </tr>
	    	</c:forEach>         
        </table>
      </div>  
      
      <nav aria-label="">
			<ul class="pager">
				<li><a href="${urlNoticias}/indexPaginate?page=${listaNoticias.number - 1 }">Anterior</a></li>
				<li><a href="${urlNoticias}/indexPaginate?page=${listaNoticias.number + 1 }">Siguiente</a></li>
			</ul>
	  </nav>
      
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

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
