package academia.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.impl.CursoDAOImpl;
import academia.modelo.pojo.Curso;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, int idCurso, int idUsuario) throws Throwable {
		
		//recoge parametro
		String parametroId = request.getParameter("id");
		int id = Integer.parseInt(parametroId);
		
		// llama modelo
		CursoDAOImpl dao = CursoDAOImpl.getInstance();
		String mensaje  = "";
		Curso c = new Curso();
		
		try {
			
				c = dao.delete(idCurso, idUsuario);
			
			mensaje = "Eliminado " + c.getNombre();
			
		} catch (Exception e) {
			mensaje = "Error " + e.getMessage();
			e.printStackTrace();
		}finally {
		
			// guardar datos en session para el mensaje de la vista
			request.getSession().setAttribute("mensaje", mensaje  );
			
			// pedimos al cliente que realize una segunda REQUEST
			response.sendRedirect("curso");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
