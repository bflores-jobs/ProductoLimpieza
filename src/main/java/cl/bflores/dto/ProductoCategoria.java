package cl.bflores.dto;

import cl.bflores.model.Categoria;
import cl.bflores.model.Producto;

public class ProductoCategoria {
	
	//atributos
	private Producto producto;
	private Categoria categoria;
	//constructores
	public ProductoCategoria() {
	}
	public ProductoCategoria(Producto producto, Categoria categoria) {
		super();
		this.producto = producto;
		this.categoria = categoria;
	}
	//getters and setters
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	//metodo toString()
	@Override
	public String toString() {
		return "ProductoCategoria [producto=" + producto + ", categoria=" + categoria + "]";
	}	

}
