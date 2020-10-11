package academia.controller.privado;

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
 * Servlet implementation class CursoControllerProfesor
 */
@WebServlet("/privado/profesor")
public class CursoControllerProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CursoControllerProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Cursos> pCursos;
		CursoDaoImpl dao = new CursoDaoImpl();
		
	
		Usuario  usuario=  (Usuario)request.getSession().getAttribute("usuario_sesion");
		
		pCursos = dao.listar(usuario.getId());

		request.setAttribute("cursosprofesor", pCursos);
		request.getRequestDispatcher("/privado/profesor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
