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
    <link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="estilo.css">

 
  </head>
  <header>
  <body>
  
  <nav class="navbar navbar-expand-md  fixed-top bg-primary bg-dark">
        <!-- logo -->
        
        
      

       
      
        <!-- lista enlaces -->
          
              <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'inicio' eq param.pagina ) ? 'active' : '' }" href="index.jsp"><img src="privado/img/home_hover.svg">HOME</a>
            </li>
           </ul> 
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'profesor' eq param.pagina ) ? 'active' : '' }" href="profesor"><img src="privado/img/home_hover.svg">Curso Profesor</a>
            </li>
           </ul>     
              
                       
               	
         
            
      
           
         
      
           
             <ul>
         	
         	<c:if test="${ empty sessionScope.usuario_sesion }">
            	  <a class="nav-link  btn btn-outline-warning" href="login.jsp">Iniciar Sesión</a>
            </c:if>	  
  		
  		</ul>   
			
           	
       
                  
           
      	
  </nav>

    </header>
      
      
   			
      	

  
  
  
  
  
  
  
        
      

       
      
        
          
         
            