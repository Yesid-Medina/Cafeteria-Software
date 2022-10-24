//Venta: información de la venta (información relacionada al proceso de la venta)
//Es importante tener un ID (Identificador) para el tema de busqueda
//Estado de la Venta: "Anulada" - "Pagada"

package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Omar Medina
 */
public class Venta {

    private int nroVenta;
    private String cedula;
    private Date fecha;
    private double total;
    private ArrayList<DetalleVenta> detalleVenta;
    private String estado;

    public Venta() {
    }

    public Venta(int nroVenta, String cedula, Date fecha, double total, ArrayList<DetalleVenta> detalleVenta, String estado) {
        this.nroVenta = nroVenta;
        this.cedula = cedula;
        this.fecha = fecha;
        this.total = total;
        this.detalleVenta = detalleVenta;
        this.estado = estado;
    }
    
    public static Venta load(ResultSet rs) throws SQLException{
       Venta venta = new Venta();
       venta.setNroVenta(rs.getInt(1));
       venta.setCedula(rs.getString(2));
       venta.setFecha(rs.getDate(3));
//       venta.setDetalleVenta(rs.getD);
       venta.setEstado(rs.getString(5));
       return venta;
    }

    public int getNroVenta() {
        return nroVenta;
    }

    public void setNroVenta(int nroVenta) {
        this.nroVenta = nroVenta;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "nroVenta=" + nroVenta + ", cedula=" + cedula + ", fecha=" + fecha + ", total=" + total + ", detalleVenta=" + detalleVenta + ", estado=" + estado + '}';
    }
    
    
}
