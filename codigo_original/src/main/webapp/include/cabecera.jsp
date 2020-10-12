<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- fontawesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<!-- datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/estilo.css">
	

	
  <base href="${pageContext.request.contextPath}/" />
 
  </head>
  <header>
  

   <!-- lista enlaces -->
          
        
            
             	
           <!-- opciones cuando el usuario esta Logeado -->
            
   <span class="form-inline">
         
         	 
         	<c:if test="${ empty sessionScope.usuario_sesion }">
         	
         	 <li class="nav-item"> 
         	 <nav class="navbar navbar-expand-md  fixed-top bg-primary bg-light">
         	 <a class="nav-link  btn btn-outline-warning" href="login.jsp">Iniciar Sesión</a>
            	 <span class="badge badge-pill badge-light mr-3">${sessionScope.usuario_sesion.nombre}</span>
            	
			
		  <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'inicio' eq param.pagina ) ? 'active' : '' }" href="index.jsp">home</a>
            </li>
           </ul> 
            
                       
               	
         <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'curso' eq param.pagina ) ? 'active' : '' }" href="curso">listado de cursos</a>
            </li>
          </ul>
            
           
           	 </c:if>	
            	 
            	 
        

    <!-- Grid row-->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-12 py-1">
        <div class="mb- flex-center">

          <!-- Facebook -->
          <a class="fb-ic">
            <i class="fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!-- Twitter -->
          <a class="tw-ic">
            <i class="fab fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!-- Google +-->
          <a class="gplus-ic">
            <i class="fab fa-google-plus-g fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!--Linkedin -->
          <a class="li-ic">
            <i class="fab fa-linkedin-in fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!--Instagram-->
          <a class="ins-ic">
            <i class="fab fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
          </a>
          <!--Pinterest-->
          <a class="pin-ic">
            <i class="fab fa-pinterest fa-lg white-text fa-2x"> </i>
          </a>
        </div>
      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row-->

 	 
            	 
            	 
        
        </span>
            
            <c:if test="${ not empty sessionScope.usuario_sesion and usuario_sesion.rol==2}">
            	
 			
 			       <span class="form-inline">
         	<nav class="navbar navbar-expand-md  fixed-top bg-primary bg-dark">
         	
 			         
         	 <ul class="navbar-nav mr-auto">
         	
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'cursosprofesor' eq param.pagina ) ? 'active' : '' }" href="privado/profesor">listado del profesor</a>
            </li>
          </ul>
          </nav></span>
          
              </c:if>	 
          
          <c:if test="${ not empty sessionScope.usuario_sesion and usuario_sesion.rol==1 }">
          
                 <span class="form-inline">
         	<nav class="navbar navbar-expand-md  fixed-top bg-primary bg-dark">
         	
 			         
          
   			<ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'privado/alumno' eq param.pagina ) ? 'active' : '' }" href="privado/alumno">listado del alumno</a>
            </li>
          </ul>  
 		
              </c:if>	   
        
      

       
      
</header>
      
      
   			
      	

      