
package vista;

import dao.ProductoImpDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Producto;

/**
 *
 * @author Omar Medina
 */
public class PruebaProducto {
    public static void main(String[] args) throws SQLException {
        Categoria categoria = new Categoria(1,null,null);//objeto categoria
        Producto producto = new Producto("A0001","cafés",categoria,1500.00, 2, "Activo");
        ProductoImpDAO prodImpDao = new ProductoImpDAO();
        ArrayList<Producto> listaProd = new ArrayList<>();//Creo Arrays para almacenar los datos en el ArraysList de tipo producto
        
//        prodImpDao.insertar(producto);
//        listaProd = (ArrayList<Producto>) prodImpDao.listar();//Llamando a listar y este objeto va hacer de tipo categoria
          
          
          //Imprimir los objetos
//          for (Producto producto2 : listaProd) { //Permite imprimir elementos de un arrays
//          System.out.println(producto2.toString());   
//        }
          System.out.println("Modificar: "+prodImpDao.modificar(producto));

//        System.out.println("Resultado: " + prodImpDao.buscar(producto));
//        System.out.println("Eliminar: " + prodImpDao.eliminar(producto));
          
      
    }
}
