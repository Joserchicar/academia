<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="index" />
  <jsp:param name="title" value="index" /> 
</jsp:include>

<%
	// segun carga la pagina principal, redireccionamos a un controlador
	response.sendRedirect( request.getContextPath() + "/login.jsp");
%>


<%@include file="includes/pie.jsp" %>
