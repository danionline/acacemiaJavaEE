package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.UsuarioDaoImpl;
import academia.modelo.pojo.Cursos;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/sesion")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String pasword = request.getParameter("pasword");
		int rol = Integer.parseInt(request.getParameter("rol"));

		UsuarioDaoImpl dao = UsuarioDaoImpl.getInstance();

		Usuario usuario = dao.existe(nombre, rol);

		if (usuario == null) {
			String mensaje = "credenciales incorrectas";
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else if (usuario.getRol() == rol) {

			// LISTAR CURSOS DE PROFESORES

			ArrayList<Cursos> cursos = new ArrayList<Cursos>();
			cursos = dao.listarProfesor(usuario.getId()); // Crea el DAO de Cursos y obtento todos
			request.setAttribute("cursos", cursos);

			request.getSession().setAttribute("usuario_sesion", usuario);
			response.sendRedirect(request.getContextPath() + "/privado/profesor");
			// request.getRequestDispatcher("privado/profesor").forward(request, response);

		} else { /// LISTAR CURSOS DE ALUMNOS

			ArrayList<Cursos> cursos = new ArrayList<Cursos>();
			cursos = dao.listarAlumnos(usuario.getId()); // Crea el DAO de Cursos y obtento todos
			request.setAttribute("cursos", cursos);
			request.getSession().setAttribute("usuario_sesion", usuario);
			response.sendRedirect(request.getContextPath() + "/privado/alumno");
			// request.getRequestDispatcher("privado/alumno").forward(request, response);

		}

	}

}
