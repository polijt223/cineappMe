<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<spring:url value="/" var="urlRoot"></spring:url>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
      
      <%--El tag autorize sirve para definir que rol de usuario podra ver su respectivos menus --%>
     <sec:authorize access="isAnonymous()">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot }">My CineSite</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">  
            <li><a href="${urlRoot }contacto">Contacto</a></li>  
            <li><a href="${urlRoot }acercade">Acerca</a></li>
            <li><a href="${urlRoot }formLogin">Login</a></li>            
          </ul>
        </div><!--/.nav-collapse -->
      </sec:authorize>
      
      <sec:authorize access="hasAnyAuthority('GERENTE')">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot }"> <sec:authentication property="principal.username"/> | Gerente</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav"> 
            <li><a href="${urlRoot }peliculas/indexPaginate?page=0">Peliculas</a></li>   
            <li><a href="${urlRoot }noticias/indexPaginate?page=0">Noticias</a></li>  
            <li><a href="${urlRoot }horarios/index">Horarios</a></li>   
            <li><a href="${urlRoot }banners/index">Banner</a></li>     
            <li><a href="${urlRoot }admin/logout">Salir</a></li>         
          </ul>
        </div><!--/.nav-collapse -->
      </sec:authorize>
      
      <sec:authorize access="hasAnyAuthority('EDITOR')">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot }"> <sec:authentication property="principal.username"/> | Editor</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav"> 
            <li><a href="${urlRoot }peliculas/indexPaginate?page=0">Peliculas</a></li>  
            <li><a href="${urlRoot }noticias/indexPaginate?page=0">Noticias</a></li>   
            <li><a href="${urlRoot }horarios/index">Horarios</a></li>   
            <li><a href="${urlRoot }admin/logout">Salir</a></li>     
          </ul>
        </div><!--/.nav-collapse -->
      </sec:authorize>  
        
      </div>
    </nav>