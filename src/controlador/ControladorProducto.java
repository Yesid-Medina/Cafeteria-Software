package controlador;

import dao.ProductoImpDAO;
import java.sql.SQLException;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author Omar Medina
 */
public class ControladorProducto {

    ProductoImpDAO prodImpDao = new ProductoImpDAO();
    Producto producto = new Producto();

    public void registrarProducto(Producto producto) throws SQLException {
        prodImpDao.insertar(producto);
    }

    public List<Producto> listarProducto() throws SQLException {
        return (List<Producto>) prodImpDao.listar();//Hacer un casting para llevar la lista de tipo Object a Producto  
    }   // el metodo list esta devolviendo un object por eso se hace un casting

    public String modificarProducto (Producto obj) throws SQLException{
        return prodImpDao.modificar(obj);   
    }
    
    public boolean eliminarProducto(Producto obj) throws SQLException{
        return prodImpDao.eliminar(obj);    
    }
    
    public Producto buscarProductoId(String id) throws SQLException {
        return (Producto) prodImpDao.buscarPorId(id);
    }

}
