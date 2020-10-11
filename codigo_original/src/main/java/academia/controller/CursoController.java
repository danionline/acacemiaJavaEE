package academia.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import academia.modelo.dao.CursoDaoImpl;
import academia.modelo.pojo.Cursos;
import academia.modelo.pojo.Usuario;

/**
 * Servlet implementation class CursoController
 */
@WebServlet("/curso")
public class CursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public CursoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		ArrayList<Cursos> aCursos;
		CursoDaoImpl dao = new CursoDaoImpl();
		
		
		aCursos = dao.listar();

		request.setAttribute("cursos", aCursos);
		request.getRequestDispatcher("curso.jsp").forward(request, response);

	}

}
