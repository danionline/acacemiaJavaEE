package academia.modelo.pojo;

public class Usuario {

	public static final int ROL_PROFESOR = 2;
	public static final int ROL_ALUMNO = 1;
	private int id;
	private String nombre;
	private String pasword;
	private String apellido;
	private int rol;

	public Usuario(int id, String nombre, String contrasena, String apellido, int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pasword = contrasena;
		this.apellido = apellido;
		this.rol = rol;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public Usuario(int id, String nombre, String contrasena, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pasword = contrasena;
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.pasword = "";

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

	public String getContrasena() {
		return pasword;
	}

	public void setContrasena(String conse) {
		this.pasword = conse;
	}

	public Usuario(int id, String nombre, String contrasena, int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pasword = contrasena;

	}

	public static int getRolProfesor() {
		return ROL_PROFESOR;
	}

	public static int getRolAlumno() {
		return ROL_ALUMNO;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasena=" + pasword + ", apellido=" + apellido
				+ ", rol=" + rol + "]";
	}

}
