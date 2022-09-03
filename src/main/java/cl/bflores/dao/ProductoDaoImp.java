package cl.bflores.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.bflores.connection.AdministradorConexion;
import cl.bflores.interfaces.ProductoDao;
import cl.bflores.model.Producto;

public class ProductoDaoImp extends AdministradorConexion implements ProductoDao {

	public ProductoDaoImp() {
		conn = generaPoolConexion();
	}
	
	//obtiene roducto por id
	@Override
	public Producto findById(int id) {
		
		Producto producto = new Producto();
		String query = "SELECT * FROM producto WHERE id_producto = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return producto;
	}

	//obtiene todos los productos
	@Override
	public List<Producto> findAll() {
		
		List<Producto> listaProductos = new ArrayList<Producto>();
		String query = "SELECT * FROM producto";
		
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
				listaProductos.add(producto);			
			}
			
			return listaProductos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Producto>();
		}
	}

	//agrega un producto
	@Override
	public Producto add(Producto producto) {
		
		String query = "INSERT INTO producto VALUES(producto_sec.nextval,?,?,?,?)";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, producto.getNombre());
			pstm.setInt(2, producto.getPrecio());
			pstm.setString(3, producto.getDescripcion());
			pstm.setInt(4, producto.getIdCategoria());
			
			if(pstm.executeUpdate() == 1) {
				producto.setId(findLastId());
				return producto;
			}else {
				throw new RuntimeException("Ha ocurrido un error en add() del ProductoDaoImp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Producto();
	}

	//actualiza prodcto
	@Override
	public Producto update(Producto producto) {

		String query = "UPDATE producto SET nombre_producto = ?, precio_producto = ?, descripcion_producto = ?, id_categoria = ? WHERE id_producto = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, producto.getNombre());
			pstm.setInt(2, producto.getPrecio());
			pstm.setString(3, producto.getDescripcion());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getId());
			
			if(pstm.executeUpdate() == 1) {
				return producto;
			}else {
				throw new RuntimeException("Ha ocurrido un error en update() del ProductoDaoImp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Producto();
	}

	//borra un producto
	@Override
	public boolean delete(int id) {
		
		String query = "DELETE FROM producto WHERE id_producto = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			
			if(pstm.executeUpdate() == 1) {
				return true;
			}else {
				throw new RuntimeException("Ha ocurrido un error en delete() del ProductoDaoImp");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	//obtiene el ultimo indice
	@Override
	public int findLastId() {
		
		int maxId = -1;
		String query = "SELECT MAX(id_producto) AS max_id FROM producto";
		
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				return maxId = rs.getInt("max_id");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return maxId;
	}
	
}
