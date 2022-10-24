
package modelo;

/**
 *
 * @author Omar Medina
 */

import java.sql.ResultSet;
import java.sql.SQLException;

public class Producto {//Atributos de producto
    private String codigo;
    private String nombre;
    private Categoria categoria;
    private double precio;
    private int numeroUnidades;
    private String estado;

    //Método constructor (Crea objetos vacio)
    public Producto() {
    }

    //Sobrecarga de Métodos
    public Producto(String codigo, String nombre, Categoria categoria, double precio, int numeroUnidades, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.numeroUnidades = numeroUnidades;
        this.estado = estado;
    }

    //Método static no necesita ser estatico lo llamas
    public static Producto load(ResultSet rs) throws SQLException{
        Producto producto = new Producto();
        producto.setCodigo(rs.getString(1));
        producto.setNombre(rs.getString(2));
        producto.setCategoria(new Categoria(rs.getInt(3),null,null));
        producto.setPrecio(rs.getDouble(4));
        producto.setNumeroUnidades(rs.getInt(5));
        producto.setEstado(rs.getString(6));
        return producto;
    }
    
    //Métodos getter and setter
    public String getCodigo() {//retorno el valor de una variable
        return codigo;
    }

    public void setCodigo(String codigo) {//codigo la variable es asignada al atributo codigo
        this.codigo = codigo;//modificar el dato, this referirse al atributo de la clase
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Método toString
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + ", numeroUnidades=" + numeroUnidades + ", estado=" + estado + '}';
    }
 
}
