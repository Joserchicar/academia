<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="login" />
  <jsp:param name="title" value="login" /> 
</jsp:include>

 <p style="color:red">${mensaje}</p>


<form action="login" method="get" class="form-login" >
	
	 	<div class="form-group">
			<input type="text" name="nombre" placeholder="Tu Nombre"  class="form-control">
		</div>
		
		<div class="form-group">
			<input type="password" id="password" name="password" placeholder="Tu Contraseña"  class="form-control">
		</div>
		
		
		
		<input type="submit" value="Iniciar Sesión" class="btn btn-primary btn-block">
	
	</form>
	

<h2>TAREAS</h2>
<ol>
	<li>Maquetar pagina web, css e includes para reutilizar</li>
	<li>miercoles: Si se logea un PROFESOR que muestre sus curso, desde la misma JSP podria crear un nuevo curso y eliminarlo</li>
	<li>jueves: Si se logea un ALUMNO que muestre sus curso a los que esta inscrito, desde la misma JSP apuntarse a un nuevo curso</li>	
</ol>

<h2>EXTRAS</h2>
<ol>
	<li>Trazas de LOG</li>
	<li>Singleton</li>
	<li>Gestion de errores TRY y CACTH sobre todo en los controladore</li>
	<li>Validacion de datos de los formulario con javax.validation</li>
	<li>Gestion de Seguridad, que los profesores y alumnos solo puedan modificar sus datos, No poder saltarse el Login</li>
	<li>Un ALUMNO puede escribir una reseña de un curso/profesor, calificando del 1 al 5 y escribiendo un comentario</li>	
</ol>






<h1> Listado Cursos </h1>

<p>	${cursos}</p>


<%@include file="includes/pie.jsp" %>
