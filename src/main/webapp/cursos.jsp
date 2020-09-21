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
 
 	<h1>Listado Cursos</h1>
	<p>${mensaje}</p>


	<a href="privado/profesor.jsp">Ir a listado de cursos del profesor</a>

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	
 <a href="cursos.jsp">Ir a formulario para Crear/modificar Nuevo
	Curso</a>
 
 
	
	<%@include file="includes/pie.jsp" %>
	