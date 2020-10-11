package academia.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import academia.modelo.pojo.ConnectionManager;
import academia.modelo.pojo.Cursos;
import academia.modelo.pojo.Usuario;

public class UsuarioDaoImpl implements UsuarioDAO {

	private static UsuarioDaoImpl INSTANCE = null;
	private final static Logger LOG = Logger.getLogger(UsuarioDaoImpl.class);

	// exceuteQuerys => ResultSet
	static final String SQL_GET_ALL_BY_NOMBRE = " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE nombre LIKE ? LIMIT 500 ;   ";
	static final String SQL_GET_ALL = " SELECT id_usuarios , nombre,MD5(pasword) FROM usuarios ORDER BY id_usuarios DESC LIMIT 500 ; ";
	static final String SQL_GET_BY_ID = " SELECT u.id, u.nombre, contrasenia, id_rol, r.nombre AS 'nombre_rol' FROM usuario AS u INNER JOIN rol AS r ON u.id_rol = r.id WHERE u.id = ? ; ";
	static final String SQL_EXISTE = "SELECT  id, pasword, nombre, rol FROM usuarios WHERE nombre = ? AND pasword = MD5(?) ;";
	static final String SQL_CURSOS_PROFESOR = "SELECT id, nombre, codigo, horas FROM cursos where  id_profesor=? ;";
	static final String SQL_ALUMNOS_CURSOS = "SELECT id, nombre , codigo, horas FROM cursos where  id_alumno=? ;";

	// executeUpdate => int
	static final String SQL_INSERT = " INSERT INTO usuario(nombre, contrasenia, id_rol) VALUES( ? , ? , ? ); ";
	static final String SQL_DELETE = " DELETE FROM usuario WHERE id = ? ;";
	static final String SQL_UPDATE = " UPDATE usuario SET nombre = ?, contrasenia = ? , id_rol = ? WHERE id = ? ; ";

	public UsuarioDaoImpl() {
		super();
	}

	static synchronized public UsuarioDaoImpl getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDaoImpl();
		}

		return INSTANCE;

	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			LOG.debug(pst);
			while (rs.next()) {
				usuarios.add(mapper(rs));
			}

		} catch (Exception e) {
			LOG.error(e);
		}

		return usuarios;
	}

	public ArrayList<Cursos> listarProfesor(int id) {
		ArrayList<Cursos> cursos = new ArrayList<Cursos>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_CURSOS_PROFESOR);

		) {

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
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

		return cursos;
	}

	public ArrayList<Cursos> listarAlumnos(int id) {
		ArrayList<Cursos> cursos = new ArrayList<Cursos>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_ALUMNOS_CURSOS);

		) {

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
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

		return cursos;
	}

	public Usuario buscar(String nombre, String password) {
		Usuario usuario = new Usuario();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_EXISTE);

		) {

			pst.setString(1, nombre);
			pst.setString(2, password);

			// TODO Logger
			System.out.println(pst);

			try (ResultSet rs = pst.executeQuery()) {

				if (rs.next()) {

					usuario.setNombre(rs.getString("nombre"));
					usuario.setContrasena(rs.getString("pasword"));
					usuario.setRol(rs.getInt("rol"));
					usuario.setId(rs.getInt("id"));

				} else {
					usuario = null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	private Usuario mapper(ResultSet rs) throws SQLException {

		Usuario usuario = new Usuario();

		usuario.setId(rs.getInt("id"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setContrasena(rs.getString("contrasena"));

		return usuario;

	}

	@Override
	public ArrayList<Usuario> getAllByNombre(String palabraBuscada) {
		// TODO Auto-generated method stub
		return null;
	}

}
