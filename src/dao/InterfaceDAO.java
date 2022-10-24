//Estandariza los métodos que vamos a implementar
package dao;

/**
 * @author Omar Medina
 * Declarar los métodos, el que herede de está clase está obligado a realizar todos estos metodos
 */

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO {
    
    public void insertar(Object obj) throws SQLException;//public void - (devuelve el método) insertar (Object obj) - recibe el método
    public boolean eliminar(Object obj) throws SQLException;
    public String modificar(Object obj) throws SQLException;
    public List<?> listar()throws SQLException;
    public Object buscar(Object obj) throws SQLException;//Puede devolver un object, le mando un objeto para buscar por los diferentes campos  
}
