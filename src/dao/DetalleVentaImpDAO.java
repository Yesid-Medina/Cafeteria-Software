package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DetalleVenta;

/**
 *
 * @author Omar Medina
 */
public class DetalleVentaImpDAO implements InterfaceDAO {

    ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<>();
    DetalleVenta detalleVenta = new DetalleVenta();
    ConexionDB conectar = new ConexionDB();//Conectar a DB
    PreparedStatement pstm = null;
    ResultSet rs = null;
    private boolean respuesta = false;
    private String mensaje = "";

    @Override
    public void insertar(Object obj) throws SQLException {
        try {
            detalleVenta = (DetalleVenta) obj;
            pstm = conectar.conexion().prepareStatement("INSERT INTO detalle_venta VALUES (?,?,?)");
            pstm.setInt(1, detalleVenta.getNroVenta());
            pstm.setString(2, detalleVenta.getIdProducto());
            pstm.setInt(3, detalleVenta.getCantidad());
            pstm.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            if (conectar != null) {
                conectar.conexion().close();
            }
            if (pstm != null) {
                pstm.close();
            }
        }
    }

    @Override
    public boolean eliminar(Object obj) throws SQLException {
        try {
            detalleVenta = (DetalleVenta) obj;
            pstm = conectar.conexion().prepareStatement("DELETE FROM detalle_venta WHERE nro_venta=? AND cod_producto=?");//Eliminado
            pstm.setInt(1, detalleVenta.getNroVenta());
            pstm.setString(2, detalleVenta.getIdProducto());
            if (pstm.executeUpdate() == 1) {
                respuesta = true;
            } else {
                respuesta = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());//toString para que nos muestre el inconveniente
        } finally {
            if (conectar != null) {
                conectar.conexion().close();
            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return respuesta;
    }

    @Override
    public String modificar(Object obj) throws SQLException {
        try {
            detalleVenta = (DetalleVenta) obj;
            pstm = conectar.conexion().prepareStatement("UPDATE detalle_venta SET cantidad=? WHERE nro_venta=? AND cod_producto=?");
            pstm.setInt(1, detalleVenta.getCantidad());
            pstm.setInt(2, detalleVenta.getNroVenta());
            pstm.setString(3, detalleVenta.getIdProducto());
            if (pstm.executeUpdate() == 1) {
                mensaje = "El producto fue modificado con exito";
            } else {
                mensaje = "No se pudo realizar la operación";
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());//Mostrar contenido del error
        } finally {//Cerrar conexiones para no saturar la App
            if (conectar != null) {
                conectar.conexion().close();
            }
            if (pstm != null) {
                pstm.close();
            }
        }
        return mensaje;
    }

    @Override
    public List<?> listar() throws SQLException {
        try {
            pstm = conectar.conexion().prepareStatement("SELECT * FROM detalle_venta WHERE nro_venta=?");
            pstm.setInt(1, 1);
            rs = pstm.executeQuery();
            while (rs.next()) {
                listaDetalleVenta.add(DetalleVenta.load(rs));//Llenando mi lista de producto
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            if (conectar != null) {
                conectar.conexion().close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return listaDetalleVenta;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        try {
            detalleVenta = (DetalleVenta) obj;
            pstm = conectar.conexion().prepareStatement("SELECT * FROM detalle_venta WHERE nro_venta=? AND cod_producto=?");
            pstm.setInt(1, detalleVenta.getNroVenta());
            pstm.setString(2, detalleVenta.getIdProducto());
            rs = pstm.executeQuery();
            //convertir el resulset y volverlo object
            while (rs.next()) {//next si es verdadero va a seguir repitiendo el proceso
                detalleVenta = DetalleVenta.load(rs);//Objeto listo
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            if (conectar != null) {
                conectar.conexion().close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return detalleVenta;//Devolver el objeto producto    
    }
}
