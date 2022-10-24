
package modelo;

/**
 *
 * @author Omar Medina
 */

import java.sql.ResultSet;
import java.sql.SQLException;

public class Categoria {
    //Los atributos de la clase privados
    private int codigo;
    private String nombre;
    private String estado;

    //Constructures 
    public Categoria() {
    }
    
    //Constructor con parámetros
    public Categoria(int codigo, String nombre, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    //Método para convertir registro del ResulSet en objetos de tipo Categoría
    public static Categoria load(ResultSet rs) throws SQLException{
        Categoria objCategoria = new Categoria();
        objCategoria.setCodigo(Integer.parseInt(rs.getString(1)));
        objCategoria.setNombre(rs.getString(2));
        objCategoria.setEstado(rs.getString(3));
        return objCategoria;
    }

    //Métodos setter and getter (Para manipular los atributos que son de tipo private)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Sobre escribiendo el método toString
    @Override
    public String toString() {
        return  nombre;
    }
   
}
