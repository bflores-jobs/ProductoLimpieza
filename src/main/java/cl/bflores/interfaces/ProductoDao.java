package cl.bflores.interfaces;

import java.util.List;

import cl.bflores.model.Producto;

public interface ProductoDao {
	
	public Producto findById(int id);
	public List<Producto> findAll();
	public Producto add(Producto producto);
	public Producto update(Producto producto);
	public boolean delete(int id);
	public int findLastId();
	
}
