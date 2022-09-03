<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0 shrink-to-fit=no" />

		<!-- Bootstrap CSS -->
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
		<title>Error al agregar producto</title>
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
		
		<!-- NAVBAR -->
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

		<div class="container mt-5 text-left">
			<div class="col-sm-6">
				<p>Error agregando producto</p>
			</div>
			<div class="btn-group mt-1 col-sm-6" role="group" aria-label="Basic example">
				<a class="nav-link" href="listarProductos">
					<button type="button" class="btn btn-primary">Listar Productos</button>
				</a> 
				<a class="nav-link" href="agregarProducto">
					<button type="button" class="btn btn-primary">Agregar Producto</button>
				</a>
			</div>
		</div>

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