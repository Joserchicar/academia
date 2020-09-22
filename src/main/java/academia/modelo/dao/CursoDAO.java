package academia.modelo.dao;

import java.util.ArrayList;

import javax.naming.NamingException;

import academia.modelo.pojo.Curso;

public interface CursoDAO {
	/**
	 * Listado de cursos sin datos de Alumnos matriculados
	 * @return ArrayList&lt;Curso&gt;
	 */
	ArrayList<Curso> listar();
	
	/**
	 * Obtiene todos los productos de un usuario, estos pueden estar validados o no
	 * @param idUsuario int identificador del usuario
	 * @param isValidado boolean true para mostrar los productos con fecha_validacion, false para mostrar los pendientes de validar
	 * @return
	 * @throws NamingException 
	 * @throws ClassNotFoundException 
	 */
	ArrayList<Curso> listar_por_usuario( int idUsuario ) throws ClassNotFoundException, NamingException;
	
	/**
	* Eliminar un registro, pero comprobamos que pertenezca a un usuario
	 * @param idProducto
	 * @param idUsuario
	 * @return Producto eliminado
	 * @throws SeguridadException Si no puede eliminar el producto porque no pertenece al usuario
	 * @throws Exception 
	 * @throws Throwable 
	 */
	Curso delete(int idCurso) throws Exception, Throwable ;
	
	
	
	
	
	Curso insert(Curso curso,int idUsuario)throws Exception;
	
}
