
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="head.jsp" />
<main id="index">
	<h2>Lista de Cursos</h2>
	<section class='ficha_entrada'>
		<table class="tabla_ipartek">
			<thead>
				<tr>
					<th>Curso</th>
					<th>Profesor</th>
					<th>Horas</th>
				</tr>
			</thead>
			<tbody>
				<jsp:include page="listaCursos.jsp" />
			</tbody>
		</table>
	</section>
</main>
<jsp:include page="footer.jsp" />
