package academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import academia.modelo.pojo.ConnectionManager;
import academia.modelo.pojo.Cursos;
import academia.modelo.pojo.Usuario;

/**
 * @author dani
 *
 */
public final class CursoDaoImpl implements CursoDAO {

	private static CursoDaoImpl INSTANCE = null;

	private final static String SQL_LISTAR = "SELECT id, nombre, codigo, horas from cursos Group by id";

	private final static String SQL_LISTARPROFESOR = "SELECT id, nombre, identificador, horas from cursos WHERE id_profesor=?;";

	private final static String SQL_LISTARALUMNO = "SELECT c.id, c.nombre, u.nombre , u.apellidos, c.identificador, c.horas from cursos as c,usuarios as u WHERE c.id_alumno = u.id_usuarios and c.id_alumno=? LIMIT 200;";

	private final static String SQL_LISTARALMO = "SELECT id, nombre, identificador, horas from cursos WHERE id_alumno=?;";

	private final static String SQL_INSERTAR = "INSERT into cursos  values (20,'I021',25,11 ,12 ,'Javascript');";

	private final static String SQL_UPDATE = "Update profesores set=MD5(pasword)";

	private int[] RETURN_GENERATE_KEYS;

	static synchronized public CursoDaoImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CursoDaoImpl();
		}

		return INSTANCE;

	}

	public void insertarCurso(String nombre, int horas, String identificador) throws Exception {

		long key = -1L;

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_INSERTAR, PreparedStatement.RETURN_GENERATED_KEYS)) {

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			pst.setInt(1, (int) key);
			pst.setString(2, nombre);
			pst.setInt(3, horas);
			pst.setString(4, identificador);

			pst.execute();
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				key = rs.getInt(1);
			}

		}
	}

	public void actualizarPasword(int pasw) throws Exception {

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

			pst.executeUpdate();

			pst.setInt(1, pasw);

		}

	}

	public ArrayList<Cursos> listar() {

		ArrayList<Cursos> cursos = new ArrayList<Cursos>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_LISTAR);

		) {

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					Cursos c = new Cursos();
					c.setId(rs.getInt("id"));
					c.setNombre(rs.getString("nombre"));
					c.setIdentificador(rs.getString("codigo"));
					c.setHoras(rs.getInt("horas"));
					cursos.add(c);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	public ArrayList<Cursos> listarAlumno(int id_alumno) {

		ArrayList<Cursos> cursos = new ArrayList<Cursos>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_LISTARALUMNO);

		) {

			pst.setInt(1, id_alumno);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					Cursos c = new Cursos();
					c.setId(rs.getInt("id"));
					c.setNombre(rs.getString("nombre"));
					c.setIdentificador(rs.getString("identificador"));
					c.setHoras(rs.getInt("horas"));

					Usuario u = new Usuario();
					u.setNombre(rs.getString("nombre"));
					u.setApellido(rs.getString("apellidos"));

					c.setUsuarios(u);
					cursos.add(c);

					cursos.add(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

	public ArrayList<Cursos> listar(int id_profesor) {

		ArrayList<Cursos> cursos = new ArrayList<Cursos>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_LISTARPROFESOR);

		) {

			pst.setInt(1, id_profesor);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {

					Cursos c = new Cursos();
					c.setId(rs.getInt("id"));
					c.setNombre(rs.getString("nombre"));
					c.setIdentificador(rs.getString("identificador"));
					c.setHoras(rs.getInt("horas"));
					cursos.add(c);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cursos;
	}

}
