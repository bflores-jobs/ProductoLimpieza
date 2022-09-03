<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<title>Agregar Producto</title>
	</head>
	<body>
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
		          <a class="nav-link active" aria-current="page" href="#">Usuario: Agregar usuario Conectado</a>
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

		<!-- Formulario -->
		<div class="container border border-white col-sm-12">
			<div class="form-body container">
				<div class="row">
					<div class="col-sm-12">
						<div class="form-holder">
							<div class="form-content mx-5 px-5">
								<div class="form-items form-body-color">
									<h3>Agregar Producto</h3>
									<p>Complete los datos a continuaci�n.</p>
									<form class="requires-validation" novalidate action="agregarProducto" method="post">
										<div class="col-md-12 col-sm-12">
											<input class="form-control" type="text" name="nombre" placeholder="Nombre completo" required>
											<div class="valid-feedback">El campo de nombre de usuario es v�lido!</div>
											<div class="invalid-feedback">El campo del nombre de usuario no puede estar en blanco!</div>
										</div>
		
										<div class="col-md-12 col-sm-12">
											<input class="form-control" type="text" name="descripcion" placeholder="Descripci�n" required>
											<div class="valid-feedback">El campo descripci�n es v�lido!</div>
											<div class="invalid-feedback">El campo descripci�n no puede estar en blanco!</div>
										</div>
										
										<div class="col-md-12 col-sm-12">
											<input class="form-control" type="text" name="precio" placeholder="Precio" required>
											<div class="valid-feedback">El campo de precio es v�lido!</div>
											<div class="invalid-feedback">El campo precio no puede estar en blanco!</div>
										</div>
		
										<div class="col-md-12 col-sm-12">	
												<select class="form-select mt-3" name="idCategoria" required>
													<c:forEach items="${categorias}" var="temp">
														<option value="${temp.id}"><c:out value="${temp.nombre}"></c:out></option>
													</c:forEach>
												</select>
											<div class="valid-feedback">Seleccionaste una Categoria!</div>
											<div class="invalid-feedback">Por favor seleccione una Categoria!</div>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value="" id="invalidCheck" required> 
											<label class="form-check-label">Confirmo que todos los datos son correctos</label>
											<div class="invalid-feedback">Confirme que todos los datos ingresados son correctos!</div>
										</div>
										<div class="form-button mt-3">
											<button id="submit" type="submit" class="btn btn-success">Agregar Producto</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div> 
			</div>
		</div>

		<!-- FOOTER -->
		<footer
			class="container-fluid text-center bg-dark text-white py-2 fixed-bottom">
			<h4>Productos</h4>
			<a href="" class="text-white">web site developed by FS-0003 <i class="far fa-registered"></i>
			</a>
		</footer>

		<!--jQuery 3.4.0 version no slim-->
		<script src="https://code.jquery.com/jquery-3.4.0.min.js"
			integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
		<!-- BOOTSTRAP POPPER -->
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
		<!-- BOOTSTRAP JS -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
		<!--Mi script-->
		<script src="assets/js/script.js"></script>
	</body>
</html>