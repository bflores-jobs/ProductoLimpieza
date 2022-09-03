<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0 shrink-to-fit=no" />
		<!-- BOOTSTRAP CSS -->
		<!-- CSS only -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
		
		<!-- Google fonts -->
		<link href="https://fonts.googleapis.com/css?family=Cabin:400,700" rel="stylesheet" />
		<link href="https://fonts.googleapis.com/css?family=Lobster:400,700" rel="stylesheet" />
		
		<!-- Font awesome -->
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
			integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
			crossorigin="anonymous" />
		<!-- estilo -->
		<link rel="stylesheet" href="assets/css/style.css" />
		<title>Listar Productos</title>
	</head>
	<body>
	
		<%
			String usuario = "no existe usuario";
	    	HttpSession misesion = request.getSession();
	    	if(misesion != null){
	    		usuario = (String) misesion.getAttribute("requestLogin");
	    	}else{
	    		request.getRequestDispatcher("login.jsp").forward(request, response);
	    	}
		%>
		
		<!-- NAVBAR  -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div class="container">
		    <a class="navbar-brand" href="#">Productos</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNav">
		      <ul class="navbar-nav ms-auto">		      
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="#">Usuario: <%=usuario %></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="#"><c:out value="${lastLogin}"></c:out></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="listarProductos">Listar Productos</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="agregarProducto">Agregar Producto</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="logout">Logout</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<!-- SECCION VALORES DESPLEGADOS  -->
		<section class="container mt-5 text-center">
			<table class="table table-dark">
			  <thead>
			    <tr class="table-light align-middle">
			      <th scope="col">ID</th>
			      <th scope="col">NOMBRE</th>
			      <th scope="col">DESCRIPCION</th>
			      <th scope="col">PRECIO</th>
			      <th scope="col">CATEGORIAS</th>
			      <th scope="col">ACCIONES <a class="btn btn-success btn-sm" href="agregarProducto">Agregar</a></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:if test="${productos.isEmpty()}">
			  		<td colspan="6">No hay productos disponibles</td>
			  	</c:if>
			  	<c:forEach items="${productos}" var="temp">
				    <tr>
				      <td><c:out value="${temp.getProducto().getId()}"></c:out></td>
				      <td><c:out value="${temp.getProducto().getNombre()}"></c:out></td>
				      <td><c:out value="${temp.getProducto().getDescripcion()}"></c:out></td>
				      <td><c:out value="${temp.getProducto().getPrecio()}"></c:out></td>
				      <td><c:out value="${temp.getCategoria().getNombre()}"></c:out></td>
				      <td>
				      	<a class="btn btn-warning btn-md" href="modificarProducto?id=${temp.getProducto().getId()}">Editar</a>
				      	<a class="btn btn-danger btn-md" href="eliminarProducto?id=${temp.getProducto().getId()}">Eliminar</a>
				      </td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</section>
		<!-- FOOTER  -->
		<footer class="container-fluid text-center bg-dark text-white py-2 fixed-bottom">
			<h4>Productos</h4>
			<a href="" class="text-white">web site developed by FS-0003 <i class="far fa-registered"></i>
			</a>
		</footer>
	<!--jQuery 3.4.0 version no slim-->
	<script src="https://code.jquery.com/jquery-3.4.0.min.js" integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
	<!-- BOOTSTRAP POPPER -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
	<!-- BOOTSTRAP JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
	<!--Mi script-->
	<script src="assets/js/script.js"></script>
	</body>
</html>