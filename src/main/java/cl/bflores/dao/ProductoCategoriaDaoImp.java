package cl.bflores.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.bflores.connection.AdministradorConexion;
import cl.bflores.dto.ProductoCategoria;
import cl.bflores.interfaces.ProductoCategoriaDao;
import cl.bflores.model.Categoria;
import cl.bflores.model.Producto;

public class ProductoCategoriaDaoImp extends AdministradorConexion implements ProductoCategoriaDao {

	public ProductoCategoriaDaoImp() {
		conn = generaPoolConexion();
	}
	
	//obtiene todos los ProductoCategoria
	@Override
	public List<ProductoCategoria> findAll() {		

		List<ProductoCategoria> listaProductoCategoria = new ArrayList<ProductoCategoria>();
		String query = "SELECT * FROM producto pro INNER JOIN categoria cat ON pro.id_categoria = cat.id_categoria";
		
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				ProductoCategoria productoCategoria = new ProductoCategoria();
				Producto producto = new Producto();
				Categoria categoria = new Categoria();
				
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
				
				productoCategoria.setProducto(producto);
				productoCategoria.setCategoria(categoria);
				
				listaProductoCategoria.add(productoCategoria);				
			}
			return listaProductoCategoria;			
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<ProductoCategoria>();
		}		
	}

}
