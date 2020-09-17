package academia.modelo.pojo;

public class Usuario {
	
	public static final int ROL_ALUMNO=1;
	public static  final int ROL_PROFESOR =2;
	
	private int id;
	private String nombre;
	private String apellidos;
	private String password;
	private static int rol;
	
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellidos = "";
		this.password="";
		this.rol=0;
			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public static int getRolAlumno() {
		return ROL_ALUMNO;
	}

	public static int getRolProfesor() {
		return ROL_PROFESOR;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", password=" + password
				+ ", rol=" + rol + "]";
	}

	
	
	
}
