package academia.modelo.pojo;

public class Cursos {

	private int id;
	private String nombre;
	private String identificador;
	private int horas;
	private Usuario usuarios;

	public Cursos() {
		super();

	}

	

	public Usuario getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}



	@Override
	public String toString() {
		return "Cursos [id=" + id + ", nombre=" + nombre + ", identificador=" + identificador + ", horas=" + horas
				+ ", usuarios=" + usuarios + "]";
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}


	public Cursos(int id, String nombre, String identificador, int horas, Profesores profesor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificador = identificador;
		this.horas = horas;
		this.usuarios = usuarios;
	}

}
