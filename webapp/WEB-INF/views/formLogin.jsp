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
	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/signin.css">
	<link rel="stylesheet" href="${urlPublic }/bootstrap/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   	
  </head>

  <body>

	<jsp:include page="includes/menu.jsp"></jsp:include>



		<div class="container theme-showcase" role="main">
			<hr class="featurette-divider">
			<img src="${urlPublic }/images/login.png" width="136" height="136" class="center">
			<form class="form-signin" action="${urlRoot }login" method="post">    
				<c:if test="${param.error != null}">
					<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
					<h4 class="form-signin-heading" style="color:red">Acceso denegado</h4>
				</c:if>    
				<h3 class="form-signin-heading">CineSite | Administracion</h3>        
				<label for="username" class="sr-only">Usuario</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
				<label for="password" class="sr-only">Contraseña</label>
				<input type="password" id="j_password" name="password" class="form-control" placeholder="Password" required>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
			</form>
		</div>

		


		

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
>
