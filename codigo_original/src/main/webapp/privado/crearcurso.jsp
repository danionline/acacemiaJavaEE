
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="/include/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>





		<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>Mensaje</strong> ${mensaje}
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>


<div class="contenedor">
<span></span>
  <img src="img/digitilogo.jpg">

</div>
<table class="tabla table table-striped">
		<thead>
			
	
			
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Horas</td>
				<td>Identificador</td>
				<td>Crear   Eliminar</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c">
				<tr>
				
					<td>${c.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${c.nombre}</td>
					<td>${c.horas}</td>
					<td>${c.identificador}</td>
				
					<td>
							</td>
</tr>
				</c:forEach>
</table>
		<form action="registro" method="post">
			
			<br>
		
			<label for="textlabel"	style="color:  orange" class="col-sm-3 col-form-texto">Nombre</label>	
			
				
			<input class="form-control" style="color:  white"name="nombre" type="text" placeholder="Nombre">
			
			<label for="textlabel" style="color:  orange" class="col-sm-3 col-form-label">Horas</label>
				 
			<input class="form-control" style="color:  white" name="horas" type="text" placeholder="Horas del Curso">
				
			<label for="textlabel" style="color:  orange" class="col-sm-3 col-form-label">Identificador</label> 
			
			<input	class="form-control" style="color:  white" name="identificador" type="text" placeholder="Identificador">
			<br>
		
			<button type="submit" class="btn btn-warnning mb-2">Crear Curso</button>
			<br>
			
		
			
			</form>
			
			
	
		<br>

		<form action="eliminaregistros" method="post">
			
			<br>
			
			
			
			<label for="textlabel" class="col-sm-3 col-form-label">ID</label>
			
			<input class="form-control" name="ideliminar" type="text" placeholder="ID">
			 <br>
			
			<button type="submit" class="btn btn-warning mb-2">Eliminar</button>
			
		
		</form>
		

		
		
		
		
		
		
		