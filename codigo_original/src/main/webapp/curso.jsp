
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="include/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>

	<br><br>
   <body>       
	<div class="col-md-12 ">
	<h1 class="display-4 text-center">Listado de Cursos</h1>
	<table class="tabla table table-striped">
		<thead>
				
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Horas</td>
				<td>Identificador</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c">
				<tr>
				
					<td>${c.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${c.nombre}</td>
					<td>${c.horas}</td>
					<td>${c.identificador}</td>
				</tr>
				</c:forEach>
		
		</tbody>
		</table>
		</div>
		</body>
		<div class="col-md-12">
		<br>	
		<jsp:include page="include/footer.jsp"/>	
		</div>			