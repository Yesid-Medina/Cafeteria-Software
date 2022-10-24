package controlador;

import dao.DetalleVentaImpDAO;
import java.sql.SQLException;
import modelo.DetalleVenta;

/**
 *
 * @author Omar Medina
 */
public class ControladorDetalleVenta {

    DetalleVentaImpDAO detVentaImpDAO = new DetalleVentaImpDAO();

    public void insertarDetalleVenta(DetalleVenta detalleVenta) throws SQLException {
        detVentaImpDAO.insertar(detalleVenta);
    }
}
