package cl.bflores.facade;

import java.util.List;

import cl.bflores.dao.CategoriaDaoImp;
import cl.bflores.dao.LoginDaoImp;
import cl.bflores.dao.ProductoCategoriaDaoImp;
import cl.bflores.dao.ProductoDaoImp;
import cl.bflores.dto.ProductoCategoria;
import cl.bflores.interfaces.CategoriaDao;
import cl.bflores.interfaces.LoginDao;
import cl.bflores.interfaces.ProductoCategoriaDao;
import cl.bflores.interfaces.ProductoDao;
import cl.bflores.model.Categoria;
import cl.bflores.model.Producto;

public class Facade {
	
	//instancias para acceder a los data access Object
	private ProductoDao productoDao = new ProductoDaoImp();
	private CategoriaDao categoriaDao = new CategoriaDaoImp();
	private ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImp();
	private LoginDao loginDao = new LoginDaoImp();
	
	//metodos de acceso para data access objest ProductoDao
	public Producto findProductoById(int id) {
		return productoDao.findById(id);
	}
	public List<Producto> findAllProductos(){
		return productoDao.findAll();
	}
	public Producto addProducto(Producto producto) {
		return productoDao.add(producto);
	}
	public Producto updateProducto(Producto producto) {
		return productoDao.update(producto);
	}
	public boolean deleteProducto(int id) {
		return productoDao.delete(id);
	}
	public int findProductoLastId() {
		return productoDao.findLastId();
	}
	
	//metodos de acceso para data access object CategoriaDao
	public Categoria findCategoriaById(int id) {
		return categoriaDao.findById(id);
	}
	public List<Categoria> findAllCategorias(){
		return categoriaDao.findAll();
	}
	
	//metodos de acceso para data access object ProductoCategoriaDao
	public List<ProductoCategoria> findAllProductoCategoria(){
		return productoCategoriaDao.findAll();
	}
	
	//metodos de acceso para data access object LoginDao
	public boolean usuarioRegistrado(String usr, String pwd) {
		return loginDao.usuarioRegistrado(usr, pwd);
	}
		
}
