package academia.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.impl.CursoDAOImpl;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class AlumnoController
 */
@WebServlet("/Alumno")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		Usuario alumno =  (Usuario)request.getSession().getAttribute("usuario_sesion");
	
		cursos = dao.listar_por_alumno(alumno.getId());
		
		request.setAttribute("cursos", cursos);
		request.getRequestDispatcher("/privado/alumno.jsp").forward(request, response);

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Crear objeto

		Curso curso = new Curso();

		try {

			// recoger los valores del formulario
			// String idParametro = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String identificador = request.getParameter("identificador");
			String horasParametro = request.getParameter("horas");
			 String profesorId = request.getParameter("idProfesor");

			// int id = Integer.parseInt(idParametro);
			int horas = Integer.parseInt(horasParametro);
			int idProfesor = Integer.parseInt(profesorId);

			// DAO
			CursoDAOImpl dao = CursoDAOImpl.getInstance();

			// parametros

			// curso.setId(id);
			curso.setNombre(nombre);
			curso.setIdentificador(identificador);
			curso.setHoras(horas);
			curso.setProfesor();
			Usuario alumno = (Usuario) request.getSession().getAttribute("usuario_sesion");
			// profesor.setId(idProfesor);

			curso.setAlumno(alumno);

			dao.insert(curso, alumno.getId());
		} catch (SQLException e) {
			e.printStackTrace();

			// LOG.error(e);
			String mensaje = "Lo sentimos pero ya existe ese NOMBRE,escribe otro por favor ";

		} catch (Exception e) {
			// LOG.error(e);
			e.printStackTrace();
			String mensaje = "Lo sentimos pero hemos tenido un ERROR inxesperado ";

		} finally {

			// Enviar datos a la vista

			request.getSession().setAttribute("mensaje", "Curso registrado con exito");
			request.setAttribute("curso", curso);
			// request.setAttribute("generos", daoGenero.getAll());

			// ir a la nueva vista o jsp

			request.getRequestDispatcher("/privado/alumno.jsp").forward(request, response);

		}

	}
}
