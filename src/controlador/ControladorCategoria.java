//Enviá al DAO para hacer operaciones
//Controlador -> Controla las acciones
//Dao -> Escucha la acción
package controlador;

import dao.CategoriaImpDAO;
import java.sql.SQLException;
import java.util.List;
import modelo.Categoria;

/**
 *
 * @author Omar Medina
 */
public class ControladorCategoria {

    CategoriaImpDAO catImpDao = new CategoriaImpDAO();//Objeto de tipo DAO
    Categoria categoria = new Categoria();

    public void regitrarCategoria(Categoria categoria) throws SQLException {
        catImpDao.insertar(categoria);
    }

    public List<Categoria> listarCategoria() throws SQLException {
        return (List<Categoria>) catImpDao.listar();//Hacer un casting para llevar la lista de tipo Object a Producto
    }

    public String modificarCategoria(Categoria categoria1) throws SQLException {
        return catImpDao.modificar(categoria1);
    }

    public int nuevoCodigoCategorias() throws SQLException {
        return catImpDao.generarCodigo();
    }

    public boolean eliminarCategoria(Categoria categoria2) throws SQLException {
        return catImpDao.eliminar(categoria2);
    }
}
