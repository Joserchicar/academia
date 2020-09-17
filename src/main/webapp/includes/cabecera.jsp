<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index</title>

<!-- fontawesome 5 -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- datatables -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/styles.css">

title> ${param.title} | Academia
</title>

</head>
<body id="top">

	<header>
		<i class="fas fa-cart-arrow-down"></i>

	</header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">
		<!-- logo -->
		<a class="navbar-brand" href="index.html"> <i
			class="fas fa-shopping-cart"></i>
		</a>

		<!-- icono para desplegar menu en moviles -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- lista enlaces -->
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a
					class="nav-link ${ ( 'inicio' eq param.pagina ) ? 'active' : '' }"
					href="index.jsp">Inicio</a></li>


				<c:if test="${not empty usuario_login }">
					<li class="nav-item"><a
						class="nav-link ${ ( 'productos' eq param.pagina ) ? 'active' : '' } "
						href="formulario-producto.jsp"> crear Productos</a></li>
					<li class="nav-item"><a
						class="nav-link ${ ( 'productos' eq param.pagina ) ? 'active' : '' } "
						href="productos">lista Productos</a></li>

					<li class="nav-item"><a
						class="nav-link ${ ( 'usuario' eq param.pagina ) ? 'active' : '' } "
						href="Usuario">Usuarios</a></li>



				</c:if>

			</ul>

			<span class="form-inline"> 
				<c:if test="${ empty usuario_login }">
					<a class="nav-link  btn btn-outline-warning" href="login.jsp">Iniciar
						Sesión</a>
				</c:if> 
				<c:if test="${ not empty usuario_login }">
					<span class="text-primary">${usuarios_conectados.n}  ${usuario_login.nombre}</span>
					<a class="nav-link  btn btn-outline-warning" href="Logout">Cerrar
						Sesión</a>
				</c:if>

			</span>


		</div>
	</nav>


	<main role="main">

		<jsp:include page="Alertas.jsp"></jsp:include>