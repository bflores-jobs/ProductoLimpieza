package cl.bflores.interfaces;

import java.util.List;

import cl.bflores.dto.ProductoCategoria;

public interface ProductoCategoriaDao {
	
	public List<ProductoCategoria> findAll();

}
