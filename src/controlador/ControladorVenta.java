
package controlador;

import dao.VentaImpDAO;
import java.sql.SQLException;
import modelo.Venta;

/**
 *
 * @author Omar Medina
 */
public class ControladorVenta {
    
    VentaImpDAO ventaImpDAO = new VentaImpDAO();
    String mensaje = null;
    
    public String insertarVenta(Venta venta) throws SQLException{
       ventaImpDAO.insertar(venta);
       return mensaje = ""+"La venta fue registrada con exito";
    }
    
    public String generarCodigoVenta() throws SQLException{
         return ventaImpDAO.generarCodigo();
    }
}
