<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<jsp:include page="include/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>

<body>

	 <div class="col-md-12">
		

		<form action="sesion" method="post">

		
		
		<br>
		<h1 class="display-4 text-center">Iniciar Sesion</h1>
		<br>
		<label for="textlabel"	class="col-sm-3 col-form-label">Nombre</label>	
		
		<input class="form-control" name="nombre" type="text" placeholder="Nombre">
	
		<label for="textlabel" class="col-sm-3 col-form-label">Contraseña</label>			
		<input class="form-control" name="pasword" type="text" placeholder="Contrasena"> 
		<br>
	

		<input class="form-control" name="rol" hidden="hidden" value=1 type="text">
	
		<button type="submit" class="btn btn-warning mb-3">Iniciar Sesion</button>
	
			 </form>
		
		
	</div>
	



	 <div class="col-md-12">	
	
		${mensaje}	
<jsp:include page="include/footer.jsp"/>

</div>

</body>

		