
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author Omar Medina
 */
public class ProductoImpDAO implements InterfaceDAO{
    ArrayList<Producto> listaProd = new ArrayList<>();
    Producto producto = new Producto ();
    ConexionDB conectar = new ConexionDB();//Conectar a DB
    PreparedStatement pstm = null;
    ResultSet rs = null;
    //Utilizar a nivel de los CRUD
    private boolean respuesta = false;
    private String mensaje="";//Para utilizarla en los metodos que podamos tener

    @Override
    public void insertar(Object obj) throws SQLException {
        try {
            producto = (Producto)obj;
            pstm = conectar.conexion().prepareStatement("INSERT INTO productos VALUES (?,?,?,?,?,?)");
            //Asignar valores a los párametros
            pstm.setString(1,producto.getCodigo());
            pstm.setString(2,producto.getNombre());
            pstm.setInt(3,producto.getCategoria().getCodigo());
            pstm.setDouble(4,producto.getPrecio());
            pstm.setInt(5, producto.getNumeroUnidades());
            pstm.setString(6,producto.getEstado());    
            pstm.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            if (conectar!=null)
               conectar.conexion().close();
           
           if (pstm!=null)
               pstm.close();
        }
    }

    @Override
    public boolean eliminar(Object obj) throws SQLException {
        try {
            producto = (Producto)obj;//Objeto que es tipo object pasa hacer un objeto de tipo Producto
            pstm = conectar.conexion().prepareStatement("UPDATE productos SET estado='Inactivo' WHERE codigo=?");//Eliminado logico
            pstm.setString(1,producto.getCodigo());//Lo que le vas asignar es codigo que tiene el registro
            if(pstm.executeUpdate()==1){
                respuesta = true;  
            } else{
                respuesta = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());//toString para que nos muestre el inconveniente
        }finally{
            if(conectar!=null)
              conectar.conexion().close();
          if(pstm!=null)
              pstm.close();
        }
        return respuesta;//Va hacer un boolean que contiene la variable respuesta
    }

    @Override
    public String modificar(Object obj) throws SQLException {
        try {
            producto = (Producto) obj;//El objeto modificarlo y convertirlo a un objeto de tipo Producto
            pstm = conectar.conexion().prepareStatement("UPDATE productos SET nombre=?,categoria=?,precio=?,nro_unidades=?,estado=? WHERE codigo=?");
            //Asignar valores a cada uno de los párametros
            pstm.setString(1,producto.getNombre());
            pstm.setInt(2,producto.getCategoria().getCodigo());
            pstm.setDouble(3,producto.getPrecio());
            pstm.setInt(4,producto.getNumeroUnidades());
            pstm.setString(5,producto.getEstado());
            pstm.setString(6,producto.getCodigo());//6 párametro que enviamos a nivel de consulta
            if(pstm.executeUpdate()==1){//Si devuelve 1 fue porque hizo la acción
                mensaje = "El producto fue modificado con exito";
            }else{
                mensaje = "No se pudo realizar la operación";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString());//Mostrar contenido del error
        }finally{//Cerrar conexiones para no saturar la App
            if(conectar!=null)
                conectar.conexion().close();
            if(pstm!=null)
                pstm.close();
        }
        return mensaje;
    }

    @Override
    public List<?> listar() throws SQLException {
        try {
            pstm = conectar.conexion().prepareStatement("SELECT * FROM productos WHERE estado=?");//Conectar a DB y enviar consulta que quiero ejecutar
            pstm.setString(1,"Activo");
            rs = pstm.executeQuery();
            //Recorrer ResultSet y a convertirlo en un objeto
            while(rs.next()){
            listaProd.add(Producto.load(rs));//Llenando mi lista de producto
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            if(conectar!=null)
            conectar.conexion().close();
        if(pstm!=null)
            pstm.close();
        if(rs!=null)
            rs.close();
        }
        return listaProd;//Devolvemos el Arrays
    }
    
    public Object buscarPorId(String codigo) throws SQLException {
        try {
            pstm = conectar.conexion().prepareStatement("SELECT * FROM productos WHERE codigo=?");
            pstm.setString(1, codigo);
            //variable rs le asignamos la consulta
            rs = pstm.executeQuery();
            //convertir el resulset y volverlo object
            while (rs.next()) {//next si es verdadero va a seguir repitiendo el proceso
                producto = Producto.load(rs);//Objeto listo __ load convierte el rs en objeto
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString());
            throw new SQLException(" La operación no se pudo realizar : ", e.toString());
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
        return producto;//Devolver el objeto producto
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        try {
            producto = (Producto)obj;
            pstm = conectar.conexion().prepareStatement("SELECT * FROM productos WHERE codigo=?");
            pstm.setString(1, producto.getCodigo());
            rs = pstm.executeQuery();
            while (rs.next()) {                
            producto = Producto.load(rs);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }finally{
            if(conectar!=null)
               conectar.conexion().close();
            if(pstm!=null)
               pstm.close();
            if(rs!=null)
                rs.close();
        }
        return producto;
    }  
}
