
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;

public class ClienteImpDAO implements InterfaceDAO {

    Cliente cliente = new Cliente();
    ConexionDB conex = new ConexionDB();
    ArrayList<Cliente> listaCliente = new ArrayList<>();
    PreparedStatement psmt = null;
    ResultSet rs = null;
    private boolean respuesta = false;
    private String mensaje = "";

    @Override
    public void insertar(Object obj) throws SQLException {
        try {
            cliente = (Cliente) obj;
            psmt = conex.conexion().prepareStatement("INSERT INTO clientes VALUES (null,?,?,?,?,?,?,?)");
            psmt.setString(1, cliente.getTipoCliente());
            psmt.setString(2, cliente.getEst());
            psmt.setString(3, cliente.getNroDocumento());
            psmt.setString(4, cliente.getTipoDocumento());
            psmt.setString(5, cliente.getApellidos());
            psmt.setString(6, cliente.getNombre());
            psmt.setString(7, cliente.getEmail());
            psmt.executeUpdate();
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            if(conex!=null)
                conex.conexion().close();
            if(psmt!=null)
                psmt.close();
        }
    }

    @Override
    public boolean eliminar(Object obj) throws SQLException {
        try {
            cliente = (Cliente)obj;
            psmt = conex.conexion().prepareStatement("UPDATE clientes SET estado='Inactivo' WHERE codigo=?");//Eliminado logico y fisico
            psmt.setInt(1, cliente.getCodigo());
            if(psmt.executeUpdate()==1){
                respuesta = true;
            }else{
                respuesta = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            if(conex!=null)
                conex.conexion().close();
            if(psmt!=null)
                psmt.close();
        }
        return respuesta;
    }

    @Override
    public String modificar(Object obj) throws SQLException {
        try {
        cliente = (Cliente)obj;    
        psmt = conex.conexion().prepareStatement("UPDATE clientes SET tipoCliente=?,nroDocumento=?,tipoDocumento=?,apellidos=?,nombre=?,email=? WHERE codigo=?");
        psmt.setString(1,cliente.getTipoCliente());
        psmt.setString(2,cliente.getNroDocumento());
        psmt.setString(3,cliente.getTipoDocumento());
        psmt.setString(4,cliente.getApellidos());
        psmt.setString(5,cliente.getNombre());
        psmt.setString(6,cliente.getEmail());
        psmt.setInt(7,cliente.getCodigo());
        if(psmt.executeUpdate()==1){
        mensaje = "El registro se actualizo correctamente";
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            if(conex!=null)
                conex.conexion().close();
            if(psmt!=null)
                psmt.close();
        }
        return mensaje;
    }

    public Object buscarPorId(int codigo) throws SQLException {
        try{ 
        psmt = conex.conexion().prepareStatement("SELECT * FROM clientes WHERE codigo=?");
        psmt.setInt(1,codigo);
        rs = psmt.executeQuery();//Ejecutamos el metodo
        while(rs.next()){//Recorrer registros del arrays
          cliente = Cliente.load(rs);
        }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString());//Muestrame la exeption para yo saber que paso 
        }finally{
        if(conex!=null)
        conex.conexion().close();//Cerramos la BD
        if(psmt!=null)
            psmt.close();
        if(rs!=null)
            rs.close();
        } 
        return cliente;
    }

    @Override
    public List<?> listar() throws SQLException {
        try {
            psmt = conex.conexion().prepareStatement("SELECT * FROM clientes WHERE estado=?");
            psmt.setString(1, "Activo");
            rs = psmt.executeQuery();
            while(rs.next()){
                listaCliente.add(Cliente.load(rs));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            if(conex!=null)
                conex.conexion().close();
            if(psmt!=null)
                psmt.close();
            if(rs!=null)
                rs.close();
        }
        return listaCliente;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
