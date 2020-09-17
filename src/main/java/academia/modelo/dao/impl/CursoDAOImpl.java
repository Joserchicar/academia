package academia.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import academia.modelo.ConnectionManager;
import academia.modelo.dao.CursoDAO;
import academia.modelo.pojo.Curso;
import academia.modelo.pojo.Usuario;

public class CursoDAOImpl implements CursoDAO {
	private static CursoDAOImpl INSTANCE = null;

	private CursoDAOImpl() {
		super();
	}

	public static synchronized CursoDAOImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CursoDAOImpl();
		}

		return INSTANCE;
	}

	private final static String SQL_LISTAR = "SELECT " + "	c.id as 'curso_id', " + "	c.identificador, "
			+ "	c.curso as 'curso_nombre', " + "	c.horas, " + "	f.id as 'profesor_id', "
			+ "	f.nombre as 'profesor_nombre', " + "	f.apellidos as 'profesor_apellidos', " + "	rol "
			+ " FROM cursos c, usuarios f " + " WHERE " + "	c.idProfesor = f.id;";

	private final static String SQL_GET_BY_ID = " SELECT c.id'curso_id',  curso ,identificador,\n"
			+ "horas,idProfesor  FROM cursos c ,usuarios u \n" + "WHERE c.idProfesor = u.id AND c.id=? LIMIT 500;";

	private final static String SQL_LISTAR_BY_USUARIO = "SELECT c.id as 'curso_id' ,c.curso as 'curso_nombre',c.identificador,horas ,idProfesor as 'profesor_id',u.nombre as 'profesor_nombre', u.apellidos as 'profesor_apellidos',u.rol \n"
			+ "FROM cursos c,usuarios u \n" + "WHERE c.idProfesor=u.id AND idProfesor=?;  ";

	private final static String SQL_INSERT = "INSERT INTO cursos (curso,identificador,horas,idProfesor ) VALUES ( ? ,?,?,?) ;";

	private final static String SQL_DELETE_BY_USER = "DELETE FROM cursos WHERE id = ? AND idProfesor= ?; ";

	@Override
	public ArrayList<Curso> listar() {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_LISTAR);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {

				Curso c = new Curso();
				c.setId(rs.getInt("curso_id"));
				c.setNombre(rs.getString("curso_nombre"));
				c.setIdentificador(rs.getString("identificador"));
				c.setHoras(rs.getInt("horas"));

				Usuario p = new Usuario();
				p.setId(rs.getInt("profesor_id"));
				p.setNombre(rs.getString("profesor_nombre"));
				p.setApellidos(rs.getString("profesor_apellidos"));
				p.setRol(rs.getInt("rol"));

				c.setProfesor(p);

				cursos.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	/**
	 * lista cursos del usuario registrado
	 * 
	 * @throws NamingException
	 * @throws ClassNotFoundException
	 */
	@Override
	public ArrayList<Curso> listar_por_usuario(int idUsuario) throws ClassNotFoundException, NamingException {
		ArrayList<Curso> cursos = new ArrayList<Curso>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_LISTAR_BY_USUARIO);

		) {
			pst.setInt(1, idUsuario);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {

					Curso c = new Curso();
					c.setId(rs.getInt("curso_id"));
					c.setNombre(rs.getString("curso_nombre"));
					c.setIdentificador(rs.getString("identificador"));
					c.setHoras(rs.getInt("horas"));

					Usuario p = new Usuario();
					p.setId(rs.getInt("profesor_id"));
					p.setNombre(rs.getString("profesor_nombre"));
					p.setApellidos(rs.getString("profesor_apellidos"));
					p.setRol(rs.getInt("rol"));

					c.setProfesor(p);

					cursos.add(c);

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cursos;

	}

	private Curso getById(int idCurso, int idUsuario) throws SQLException, Throwable, NamingException {
		Curso curso = new Curso();
		
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_GET_BY_ID);

		) {

			pst.setInt(1, idCurso);
			pst.setInt(2, idUsuario);
			//LOG.debug(pst);

			ResultSet rs = pst.executeQuery();

			
			while (rs.next()) {

				Curso c = new Curso();
				c.setId(rs.getInt("curso_id"));
				c.setNombre(rs.getString("curso_nombre"));
				c.setIdentificador(rs.getString("identificador"));
				c.setHoras(rs.getInt("horas"));

				Usuario p = new Usuario();
				p.setId(rs.getInt("profesor_id"));
				p.setNombre(rs.getString("profesor_nombre"));
				p.setApellidos(rs.getString("profesor_apellidos"));
				p.setRol(rs.getInt("rol"));

				c.setProfesor(p);
				curso = new Curso();
			
				} 

			}
		return curso;
	}	
		
	
	
	
	@Override
	public Curso delete(int idCurso, int idUsuario) throws SQLException, NamingException, Throwable {
		
		
		Curso curso = getById(idCurso, idUsuario);
		
		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_DELETE_BY_USER);

		) {

			pst.setInt(1, idCurso);
			pst.setInt(2, idUsuario);
			// LOG.debug(pst);

			pst.executeUpdate();

		} // try
 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return curso;

	}

	

	@Override
	public Curso insert(Curso curso, int idUsuario) throws Exception {

		ArrayList<Curso> cursos = new ArrayList<Curso>();

		// Execute Query

		try (Connection conexion = ConnectionManager.getConnection();
				PreparedStatement pst = conexion.prepareStatement(SQL_INSERT,

						PreparedStatement.RETURN_GENERATED_KEYS);) {
			pst.setInt(1, curso.getId());
			pst.setString(1, curso.getNombre());
			pst.setInt(2, curso.getHoras());
			pst.setString(3, curso.getIdentificador());
			pst.setInt(4, curso.getProfesor().getId());

			// LOG.debug(pst);
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {

				// conseguir el id

				try (ResultSet rsKeys = pst.getGeneratedKeys()) {

					if (rsKeys.next()) {
						// recuperamos columnas del rs(resultSet)
						int id = rsKeys.getInt(1);
						curso.setId(id);
					}

				}

			} else {
				throw new Exception("No se ha podido guardar el registro " + curso);
			}
		} catch (Exception e) {

			e.printStackTrace();

		}

		return curso;
	}
}
