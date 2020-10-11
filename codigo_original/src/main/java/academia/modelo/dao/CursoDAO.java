package academia.modelo.dao;

import java.util.ArrayList;

import academia.modelo.pojo.Cursos;

public interface CursoDAO {

	
	ArrayList<Cursos> listar(int id);
	void insertarCurso(String nomb,int horas, String identificador) throws Exception;
	void actualizarPasword(int pasw) throws Exception;
	
}
