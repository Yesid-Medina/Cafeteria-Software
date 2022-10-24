package dao;

import controlador.ControladorDetalleVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.DetalleVenta;
import modelo.Venta;

/**
 *
 * @author Omar Medina
 */
public class VentaImpDAO implements InterfaceDAO {

    ArrayList<Venta> listaVenta = new ArrayList<>();//Lista que permite listar venta
    ArrayList<DetalleVenta> listaDetalleVenta = new ArrayList<>();//Lista que permite listar DetalleVenta
    Venta venta = new Venta();
    ConexionDB conectar = new ConexionDB();//Conectar a DB
    PreparedStatement pstm = null;
    ResultSet rs = null;
    private boolean respuesta = false;
    private String mensaje = "";
    int codigo = 0;
    DetalleVentaImpDAO detalleVentImpDAO = new DetalleVentaImpDAO();//Variable de instancia
    ControladorDetalleVenta contDetVenta = new ControladorDetalleVenta();

    @Override
    public void insertar(Object obj) throws SQLException {
        try {
            venta = (Venta) obj;
            pstm = conectar.conexion().prepareStatement("INSERT INTO venta  VALUES (null,?,null,?,?)");
            pstm.setString(1, venta.getCedula());
            pstm.setDouble(2, venta.getTotal());
            pstm.setString(3, venta.getEstado());
            pstm.executeUpdate();

            //Inserta en venta y detalleVenta
            listaDetalleVenta = venta.getDetalleVenta();//Atributo de está venta lo voy a colocar en el ArrayList de detalleventa
            for (DetalleVenta detalleVenta : listaDetalleVenta) {
                contDetVenta.insertarDetalleVenta(detalleVenta);
//        detalleVentImpDAO.insertar(detalleVenta);//Insertar todos los detalleventa en la tabla venta
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
        }
    }

    @Override
    public boolean eliminar(Object obj) throws SQLException {
try {
            venta = (Venta)obj;
            pstm = conectar.conexion().prepareStatement("UPDATE venta SET estado=? WHERE nro_venta=?");
            pstm.setString(1,venta.getEstado());
            pstm.setInt(2,venta.getNroVenta());
            if(pstm.executeUpdate()==1){
              respuesta = true;
            }else{
              respuesta = false;
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally{
           if (conectar!=null)
               conectar.conexion().close();
           
           if (pstm!=null)
               pstm.close();
        }  
        return respuesta;    }

    @Override
    public String modificar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String generarCodigo() throws SQLException {//Para cargar número consecutivo en el formulario venta en nroventa
        try {
        pstm = conectar.conexion().prepareStatement("SELECT COUNT(*) FROM venta");
        rs = pstm.executeQuery();
        while (rs.next()) {
            codigo = Integer.parseInt(rs.getString(1))+1;    
        } 
        }catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.toString());//Muestrame la exeption para yo saber que paso   
        }finally{//Cerrrar conexiones
        if(conectar!=null)
        conectar.conexion().close();//Cerramos la BD
        if(pstm!=null)
            pstm.close();
        }
        return "" + codigo;
    }
    
    @Override
    public Object buscar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
