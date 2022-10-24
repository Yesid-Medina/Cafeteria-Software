//Detalleventa: Información de la venta (detalla los productos que compra)
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Omar Medina
 */
public class DetalleVenta {

    private int nroVenta;
    private String idProducto;
    private int cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(int nroVenta, String idProducto, int cantidad) {
        this.nroVenta = nroVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
    
    public static DetalleVenta load(ResultSet rs) throws SQLException{
       DetalleVenta detalleventa = new DetalleVenta();
       detalleventa.setNroVenta(rs.getInt(1));
       detalleventa.setIdProducto(rs.getString(2));
       detalleventa.setCantidad(rs.getInt(3));
       return detalleventa;
    }

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "nroVenta=" + nroVenta + ", idProducto=" + idProducto + ", cantidad=" + cantidad + '}';
    }
    
    
}
