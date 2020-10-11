package academia.modelo.pojo;

public class Profesores {

	private int id;
	private String nombre;
	private String apellidos;

	public Profesores() {
		super();

	}

	public Profesores(int id, String nombre, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
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

	@Override
	public String toString() {
		return "Profesores [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
