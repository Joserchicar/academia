<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="cursos" />
  <jsp:param name="title" value="cursos" /> 
</jsp:include>
 
 
     
<h1>  Listado de cursos</h1>

${cursos};


 
 <a href= "login.jsp" > ir al login</a>
 
 	<h1>Listado Productos</h1>
	<p>${mensaje}</p>


	<a href="privado/profesor.jsp">Ir a listado de cursos del profesor</a>

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	
 
 
 <h1>Formulario Para Crear/Modificar cursos</h1>
	
	<div class="row pb-4">
	
		<div class="col">
				<form action="cursos" method="post">
			
				<div class="form-group">
					<label for="id">id:</label>
					<input type="text" name="id" id="id" value="${curso.id}" readonly class="form-control">
				</div>	
				
				<div class="form-group">
					<label for="nombre">nombre:</label>
					<input type="text" name="nombre" id="nombre" value="${curso.nombre}" class="form-control" placeholder="Escribe el nombre del curso" >
				</div>
				
				<div class="form-group">
					<label for="identificador">identificador:</label>
					<input type="text" name="identificador" id="identificador" value="${curso.identificador}" class="form-control"  >
				</div>
				
				<div class="form-group">
					<label for="horas">Horas:</label>
					<input type="text" name="horas" id="horas" value="${curso.horas}" class="form-control" placeholder=" 0 " >
				</div>
				
				<div class="form-group">
					<select class="custom-select" name="categoria_id">
					  <c:forEach items="${usuario}" var="usuario">
					  	<option value="${usuario.id}"  ${ ( usuario.id eq curso.usuario.id ) ? "selected" : "" }  >${usuario.nombre}</option>
					  </c:forEach>					  					  
					</select>
				</div>	
				
				
				<input type="submit" value="Guardar" class="btn btn-primary btn-block">
			</form>
		</div>
	</div>
	
	<%@include file="includes/pie.jsp" %>
	