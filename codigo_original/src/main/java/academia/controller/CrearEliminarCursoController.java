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

/**
 * Servlet implementation class CrearEliminarCursoController
 */
@WebServlet("/privado/registro")
public class CrearEliminarCursoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearEliminarCursoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Cursos> aCursos = new ArrayList();
		CursoDaoImpl dao = CursoDaoImpl.getInstance();
		
		String nombre=(String) request.getParameter("nombre");
		
		int horas= Integer.parseInt(request.getParameter("horas"));
		
		String identificador = (String) request.getParameter("identificador");
		
		try {
			
			if(identificador  != null) {
			
				
				dao.insertarCurso(nombre, horas, identificador);
			
				request.setAttribute("mensaje", "El curso ha sido insertado con exito");
				
			}else {
				
				request.setAttribute("mensaje", "El curso no ha sucedido la correcta inserccion, intentelo de nuevo...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("privado/profesor.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}

}
