<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/cabecera.jsp">
	<jsp:param name="pagina" value="alumno" />
	<jsp:param name="title" value="alumno" />
</jsp:include>




<h1> Hola, Alumno!!! </h1>
<h4>${usuario_sesion}</h4>
<p>${mensaje}</p>

<p>${cursos}</p>

<h1> mostrar cursos del alumno logeado</h1>

<div>
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
					<td>${c.identificador};</td>
					<td>${c.horas}</td>
					<td>${c.profesor.nombre},${c.profesor.apellidos}</td>
					<td><a href="cursos?id=${c.id}" class="mr-4"> <i
							class="far fa-edit fa-2x" title="Editar curso"></i></a> <a
						href="cursoDel?id=${c.id}" onclick="confirmar('${c.nombre}')"><i
							class="fas fa-trash fa-2x" title="Eliminar curso"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>


<div>



<h1>Listado Cursos</h1>
	<p>${mensaje}</p>

	<p>${cursos}</p>

<div>
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
					<td>${c.identificador};</td>
					<td>${c.horas}</td>
					<td>${c.profesor.nombre},${c.profesor.apellidos}</td>
					<td><a href="cursos?id=${c.id}" class="mr-4"> <i
							class="far fa-edit fa-2x" title="Editar curso"></i></a> <a
						href="cursoDel?id=${c.id}" onclick="confirmar('${c.nombre}')"><i
							class="fas fa-trash fa-2x" title="Eliminar curso"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>


<div>


<h1> crear nuevos cursos</h1>




<%@include file="../includes/pie.jsp"%>