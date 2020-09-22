package academia.controller;

import java.io.IOException;
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
 * Servlet implementation class cursoDeleteController
 */
@WebServlet("/cursoDel")
public class cursoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param idCurso
	 * @param idUsuario
	 * @throws Throwable
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, int idCurso) throws Throwable {
		
		
		
		
		// recoge parametro
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);

		// llama modelo
		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		String mensaje = "";

		Usuario profesor = (Usuario) request.getSession().getAttribute("usuario_sesion");
		int idProfesor=profesor.getId();		
		try {

			Curso c = dao.delete(idCurso);

			mensaje = "Eliminado " + c.getNombre();

		} catch (Exception e) {
			mensaje = "Error " + e.getMessage();
			e.printStackTrace();
			{
			}
			// encvio datos a la vista
			ArrayList<Curso> cursos = new ArrayList();
			cursos = dao.listar_por_usuario(idProfesor);

			request.setAttribute("cursos", cursos);

			// guardar datos en session para el mensaje de la vista
			request.getSession().setAttribute("mensaje", mensaje);

			// ir a la nueva vista o jsp
			request.getRequestDispatcher("/privado/profesor.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
}
