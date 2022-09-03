package cl.bflores.interfaces;

import java.util.List;

import cl.bflores.model.Categoria;

public interface CategoriaDao {
	
	public Categoria findById(int id);
	public List<Categoria> findAll();

}
