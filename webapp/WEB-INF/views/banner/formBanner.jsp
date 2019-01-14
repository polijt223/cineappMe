<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
   <head>
        <title>Creacion de imagenes del Banner</title>    
	    <meta charset="utf-8">
	    <meta name="author" content="">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">   
	    <spring:url value="/resources" var="urlPublic"></spring:url>
	    <spring:url value="/banners/save" var="urlSave"></spring:url>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="${urlPublic }/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" href="${urlPublic }/fontawesome/all.css">
	   	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/theme.css">
	   	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	

  </head>

  <body>

    <!-- Fixed navbar  los dos puntos .. sirven para volver al directorio anterior -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>


      <div class="container theme-showcase" role="main">

         <h3 class="blog-title"><span class="label label-success">Datos de la imagen</span></h3>

		<spring:hasBindErrors name="banner">
			<div class="alert alert-danger" role="alert">
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error }" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>


		<form:form action="${urlSave}" method="post" enctype="multipart/form-data" modelAttribute="banner">
            <div class="row">         
               <div class="col-sm-6">
                  <div class="form-group">
                  	 <label for="titulo">Titulo</label> 
                     <form:hidden path="id"/>          
                     <form:input type="text" class="form-control" path="titulo" id="titulo" required="required"/>
                  </div>
               </div>


               <div class="col-sm-3">
                  <div class="form-group">
                     <label for="imagen">Imagen</label>
                     <form:hidden path="imagen"/>
                     <input type="file" id="archivoImagen" name="archivoImagen" required="required" />
                     <p class="help-block">Tamaño recomendado: 1140 x 250 </p>
                  </div> 
               </div> 

               <div class="col-sm-3">
                  <div class="form-group">
                     <label for="estatus">Estatus</label>             
                     <form:select id="estatus" path="estatus" class="form-control">
                        <form:option value="Activo">Activo</form:option>
                        <form:option value="Inactivo">Inactivo</form:option>                
                     </form:select>  
                  </div>
               </div>
            </div>

            <button type="submit" class="btn btn-success" >Guardar</button>
         </form:form> 

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
