<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="UTF-8">
	<title>Bienvenido a Cineapp</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <spring:url value="resources" var="urlPublic"></spring:url>
    <spring:url value="/" var="urlRoot"></spring:url>
    <link rel="stylesheet" href="${urlPublic }/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${urlPublic }/fontawesome/all.css">
	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/theme.css">
	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	
  </head>

  <body>

	<jsp:include page="includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <!-- Carousel
    ================================================== -->
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <c:forEach items="${itemsCarrucel }" var="ItemCarrucel">
          	<li data-target="#myCarousel" data-slide-to="${ItemCarrucel}"></li>
          </c:forEach>	
        </ol>
        <!-- Image Size 1140 x 250 -->
        <div class="carousel-inner" role="listbox">
			<div class="item active">         
	            <img src="${urlPublic}/images/${primerbanner.imagen}" alt="Slide" title="${primerbanner.titulo}" >
	        </div>
        	<c:forEach items="${banners }" var="banner">
        		<c:choose>
        			<c:when test="${banner.id != primerbanner.id }">
        				<div class="item">         
				            <img src="${urlPublic}/images/${banner.imagen}" alt="Slide" title="${banner.titulo}" >
				        </div>
        			</c:when>
        		</c:choose>
        	</c:forEach>
        </div>
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div><!-- /.carousel -->

	
      <div class="row page-header">          
        <div class="col-lg-12">         
          <h2 class="text text-center"><span class="label label-success">EN CARTELERA</span></h2>          
          <form class="form-inline" action="${urlRoot }search" method="post">
            <div class="form-group">
              <label for="fechaEstreno">Fecha: </label>    
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>         
              <input type="text" class="form-control" name="fechaActualBusqueda" value="${fechaActualBusqueda}" id="fechaActualBusqueda" required="required" />
            </div>            
            <button type="submit" class="btn btn-primary">Filtrar</button>
          </form>
        </div>
      </div>

      <!-- Marketing messaging -->
      <div class="container marketing">

        <div class="row">
		
		<c:forEach items="${peliculas}" var="pelicula" >
			  <div class="col-xs-12 col-sm-6 col-md-3">
	            <img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}" alt="Generic placeholder image" width="150" height="200">
	            <h4>${ pelicula.titulo }</h4>
	            <h4>
	              <span class="label label-default">${ pelicula.clasificacion }</span>
	              <span class="label label-default">${ pelicula.duracion }</span>
	              <span class="label label-default">${ pelicula.genero }</span>
	            </h4>    
	                 
	            <%-- Url Dinamica tipo get
	            <p><a class="btn btn-sm btn-primary" href="detail/${pelicula.id }/${fechaActualBusqueda}" role="button">Consulta Horarios &raquo;</a></p>
	          	 --%>
	          	 <%-- Url estatica tipo get --%>
	          	<p><a class="btn btn-sm btn-primary" href="detail/${pelicula.id }/${fechaActualBusqueda}" role="button">Consulta Horarios &raquo;</a></p>
	          	  
	          
	          </div>
		</c:forEach>
          

        </div>

        <div class="page-header">
          <h2 class="text text-center"><span class="label label-success">Noticias y novedades</span></h2>
        </div>
		<c:forEach items="${listaNoticias }" var="noticia">
	        <div class="row">
	
	          <div class="col-sm-12 blog-main">
	
	            <div class="blog-post">              
	              <h3 class="blog-post-title">${noticia.titulo }</h3>
	
	              <p class="blog-post-meta"><span class="label label-danger">Publicado: <fmt:formatDate value="${noticia.fecha }" pattern="dd-MM-yyyy"/></span></p>             
	              <p>${noticia.detalle }</p>
	
	              <hr class="featurette-divider">
	            </div>
	          </div>
	        </div>
		</c:forEach>
      </div>
	



		<!-- FOOTER -->
      <jsp:include page="includes/footer.jsp"></jsp:include>

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
      
      $(function () {
          $("#fechaActualBusqueda").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
  </body>
</html>
