<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../includes/cabecera.jsp">
	<jsp:param name="pagina" value="alumno" />
	<jsp:param name="title" value="alumno" />
</jsp:include>

<h1> ${param.mensaje}</h1>




<h1> mostrar cursos del alumno logeado</h1>

<h1>Listado Cursos</h1>
	<p>${mensaje}</p>

	<p>${cursos}</p>



<h1> crear nuevos cursos</h1>

<h1> Hola, Alumno!!! </h1>
<h3>${usuario_sesion}</h3>
<p>${cursos}</p>


<%@include file="../includes/pie.jsp"%>