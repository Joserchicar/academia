<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/cabecera.jsp">
	<jsp:param name="pagina" value="profesor" />
	<jsp:param name="title" value="profesor" />
</jsp:include>


<title>Profesor</title>


<div></div>

<h1>Saludos , Profesor!!!</h1>
<h3>${usuario_sesion}</h3>

</div>

<div>

	<h1>Listado Cursos</h1>
	<p>${mensaje}</p>

	<p>${cursos}</p>

</div>


<%
	// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
	// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
	// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
%>

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


<h1>Formulario Para Crear cursos</h1>


</div>

<div>

<div class="row pb-4">

	<div class="col">
		<form action="cursos" method="post">

			<div class="form-group">
				<label for="id">id:</label> <input type="text" name="id" id="id"
					value="${curso.id}" readonly class="form-control">
			</div>

			<div class="form-group">
				<label for="nombre">nombre:</label> <input type="text" name="nombre"
					id="nombre" value="${curso.nombre}" class="form-control"
					placeholder="Escribe el nombre del curso">
			</div>

			<div class="form-group">
				<label for="identificador">identificador:</label> <input type="text"
					name="identificador" id="identificador"
					value="${curso.identificador}" class="form-control">
			</div>

			<div class="form-group">
				<label for="horas">Horas:</label> <input type="text" name="horas"
					id="horas" value="${curso.horas}" class="form-control"
					placeholder=" 0 ">
			</div>

			<div class="form-group">
				<select class="custom-select" name="uduario_id">
					<c:forEach items="${usuario}" var="usuario">
						<option value="${usuario.id}"
							${ ( usuario.id eq curso.usuario.id ) ? "selected" : "" }>${usuario.nombre}</option>
					</c:forEach>
				</select>
			</div>


			<input type="submit" value="Guardar"
				class="btn btn-primary btn-block">
		</form>
	</div>
</div>


</div>



<h1>borrar cursos</h1>



<%@include file="../includes/pie.jsp"%>