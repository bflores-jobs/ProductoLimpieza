package cl.bflores.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.bflores.facade.Facade;
import cl.bflores.model.Categoria;
import cl.bflores.model.Producto;



/**
 * Servlet implementation class AgregarProducto
 * responsabilidad de cargar las categorias y despacharlas a la vista de agregar
 */
@WebServlet("/agregarProducto")
public class AgregarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//instancia de Facade para acceder al data access object y obtener las Categorias
	private Facade facade = new Facade();

	//metodo que recibe la peticion para acceder a la pagina de agregar producto
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//se setean la lista de categorias para ser despachada en la vista		
		List<Categoria> listaCategorias =  facade.findAllCategorias();
		
		if (!listaCategorias.isEmpty()) {
			request.setAttribute("categorias", listaCategorias);
			request.getRequestDispatcher("agregarproducto.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("agregarProducto-error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//objeto para setear los valores obtenidos del request y se actualizara en la base de datos
			Producto producto = new Producto();
			
			//se constituye el producto a guardar mediante los valores obtenidos del request
			producto.setNombre(request.getParameter("nombre"));
			producto.setDescripcion(request.getParameter("descripcion"));
			producto.setPrecio(Integer.parseInt(request.getParameter("precio")));
			producto.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
			
			Producto productoAgregado = facade.addProducto(producto);
			
			if (productoAgregado.getId() != 0) {//si el id del producto recibido es diferente a 0
				
				request.setAttribute("producto", productoAgregado);
				request.getRequestDispatcher("agregarproducto-success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("agregarproducto-error.jsp").forward(request, response);
		}
	}
}
