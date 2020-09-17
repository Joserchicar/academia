package academia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import academia.modelo.dao.CursoDAO;
import academia.modelo.dao.impl.CursoDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class CursoController
 */
@WebServlet("/cursos")
public class CursoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		
		cursos=dao.listar();

		request.setAttribute("cursos", cursos);
		request.getRequestDispatcher("cursos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Crear objeto

		Curso curso = new Curso();

		try {

			// recoger los valores del formulario
			String idParametro = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String identificador = request.getParameter("identificador");
			String horasParametro = request.getParameter("horas");
			String profesorId = request.getParameter("idProfesor");

			int id = Integer.parseInt(idParametro);
			int horas = Integer.parseInt(horasParametro);
			int idProfesor = Integer.parseInt(profesorId);

			// DAO
			CursoDAOImpl dao = CursoDAOImpl.getInstance();

			// parametros

			curso.setId(id);
			curso.setNombre(nombre);
			curso.setIdentificador(identificador);
			curso.setHoras(horas);
			Usuario profesor = new Usuario();
			profesor.setId(idProfesor);
			curso.setProfesor(profesor);

			// Set<ConstraintViolation<Curso>> violations = validator.validate(curso);

			// if (violations.isEmpty()) { // sin errores de validacion

			// vuelve al inicio y vuelve para listar los libros (redirecciona)

			if (id == 0) {

				dao.insert(curso, idProfesor);

				request.getSession().setAttribute("mensaje", "Cursoregistrado con exito");
				request.setAttribute("curso", curso);
			} // else {
				// dao.update(curso);

			// ir a la vista del registro de libros
			request.setAttribute("curso", curso);

			// request.setAttribute("mensaje", "El libro ya existe");

			// } // if

			// alerta = new Alerta("success", "Libro registrado. Pendiente de su
			// validacion");
			/*
			 * } else { // Si hay errores de validacion
			 * 
			 * String errores = ""; for (ConstraintViolation<Curso> v : violations) {
			 * 
			 * errores += "<p><b>" + v.getPropertyPath() + "</b>:" + v.getMessage() +
			 * "</p>";
			 * 
			 * } alerta = new Alerta("danger", errores);
			 * 
			 * }
			 */

		} catch (SQLException e) {
			e.printStackTrace();

			// LOG.error(e);
			String mensaje = "Lo sentimos pero ya existe ese NOMBRE,escribe otro por favor ";

		} catch (Exception e) {
			// LOG.error(e);
			String mensaje = "Lo sentimos pero hemos tenido un ERROR inxesperado ";

		} finally {

			// Enviar datos a la vista

			request.getSession().setAttribute("mensaje", "Curso registrado con exito");
			request.setAttribute("curso", curso);
			// request.setAttribute("generos", daoGenero.getAll());

			// ir a la nueva vista o jsp

			request.getRequestDispatcher("/cursos.jsp").forward(request, response);
		} // trycatch

	}

}
