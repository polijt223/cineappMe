<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
	<meta charset="UTF-8">
	<title>Acerca de esta Aplicacion</title>
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

      <div class="jumbotron">        
        <h3>Administraci�n del Sistema</h3>
        <p>Bienvenido(a) <sec:authentication property="principal.username"/> </p>
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
  </body>
</html>
