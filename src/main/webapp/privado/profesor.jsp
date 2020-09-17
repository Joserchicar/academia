<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="profesor" />
  <jsp:param name="title" value="profesor" /> 
</jsp:include>


<title>Profesor</title>


<h1> ${mensaje}</h1>
<h3> ${usuario_sesion} </h3>
<h1>  Saludos , Profesor!!!</h1>

<h1> mostrar cursos del profesor logeado</h1>

<h1>Listado Cursos</h1>
	<p>${mensaje}</p>

	<p> ${cursos}</p>
	
	

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	


	<table class="tabla table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Identificador</td>
				<td>Horas</td>
				<td>Profesor</td>
				<td>Operaciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c">
				<tr>
					<td>${c.id}</td> 
					<td>${c.nombre}</td>
					<td>${c.identificador} ;</td>
					<td>${c.horas}</td>
					<td>${c.profesor.nombre},${c.profesor.apellidos} </td>
					<td>
						<a href="curso?id=${c.id}" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar curso"></i></a>
						<a href="curso-eliminar?id=${c.id}"
						   onclick="confirmar('${c.nombre}')" 
						   ><i class="fas fa-trash fa-2x" title="Eliminar curso"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



<h1> crear nuevos cursos</h1>

<a href="cursos.jsp">Ir a formulario para Crear/modificar Nuevo Curso</a>

<h1> borrar  cursos</h1>



<%@include file="../includes/pie.jsp" %>