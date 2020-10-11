
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/include/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>


      <br>
      <br>
          
	
	<table class="tabla table table-striped">
		<thead>
			
	
			
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				
				<td>Horas</td>
				<td>Identificador</td>
				<td>Profesor</td>
			
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c">
				<tr>
				
					<td>${c.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${c.nombre}</td>
					<td>${c.horas}</td>
					<td>${c.codigo	}</td>
					<td>${c.usuario.nombre}${c.usuario.apellido}</td>					
				</tr>
				</c:forEach>
		</tbody>
					
			</table>			       
          
         

  
  
  
  
        
      

       
      
        
 <jsp:include page="/include/pie.jsp"/>         
         
		