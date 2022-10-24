//Implementa los metodos o el patrón InterfaceDAO, manipulación de datos
package dao;

/**
 *
 * @author Omar Medina
 */

import dao.InterfaceDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Categoria;

public class CategoriaImpDAO implements InterfaceDAO {//Todos los metodos declarados en la interface deben ser implementados a traves de la clase que la implemente
    ArrayList <Categoria> listCatg = new ArrayList<>();//Todo lo que almacene en este objeto van hacer de tipo categoria
    Categoria objCategoria = new Categoria ();
    ConexionDB objConex = new ConexionDB();//Creo un objeto de la clase ConexionDB y lo instancio
    PreparedStatement psmt = null;//Permite hace la consulta a la BD
    ResultSet rs = null;
    private boolean respuesta = false;
    private String mensaje="";//Para utilizarla en los metodos que podamos tener
    private int codigo;

    @Override
    public void insertar(Object obj) throws SQLException {//Metodo recibe un objeto
        try {//Intento de ejecución
            objCategoria = (Categoria) obj;//Hacemos un cath del objeto que viene
            psmt = objConex.conexion().prepareStatement("INSERT INTO categorias VALUES (null,?,?)");//Ejecute el metodo conectar, cadena de caractares seria la consulta a la BD 
            psmt.setString(1, objCategoria.getNombre());//Set(Modificar) y Get(mostrar) 
            psmt.setString(2, objCategoria.getEstado());
            psmt.executeUpdate();
        } catch (Exception e) {//Catch "Atrapar", Capturo el error
            JOptionPane.showMessageDialog(null, e.toString());//Muestrame la exeption para yo saber que paso
        }finally{//Ejecutarse déspues del try o catch
            if(objConex!=null){
                objConex.conexion().close();//Cerramos la BD
            }
        }
    }

    @Override
    public boolean eliminar(Object obj) throws SQLException {//Va devolver un boolean, enviame un valor eliminado "lógico o fisico"
        try {//Intento de ejeccuión
            objCategoria = (Categoria)obj;//Intento de ejeccuión
           psmt = objConex.conexion().prepareStatement("UPDATE categorias SET estado='Inactivo' WHERE id=?");//Para hacer conexión con BD, asignar esa operación al Prepare Statement
//           psmt = objConex.conexion().prepareStatement("DELETE FROM categorias WHERE id=?");
           psmt.setInt(1, objCategoria.getCodigo());//Hacer la consulta
           psmt.executeUpdate();
           respuesta = true;//Si esto se ejecuta la variable va hacer true
        } catch (Exception e) {//Capturar exepciones
            JOptionPane.showMessageDialog(null, e.toString());//Muestrame el contenido del objeto 
        }finally{//Cerrar conexiones
            if(objConex!=null)
                objConex.conexion().close();//Cerrar conexión de BD
            if(psmt!=null)
                psmt.close();// Cerrar conexión de Interface PSMT
        }
        return respuesta;//Si el try no funciona va hacer "false" 53:51
    }

    @Override
    public String modificar(Object obj) throws SQLException {
        try {//Intento de ejecucción
            objCategoria = (Categoria)obj;//Cast 
            psmt = objConex.conexion().prepareStatement("UPDATE categorias SET nombre=?, estado=? WHERE id=?");// Crear conexión
            psmt.setString(1, objCategoria.getNombre());
            psmt.setString(2, objCategoria.getEstado());
            psmt.setInt(3, objCategoria.getCodigo());
            psmt.executeUpdate(); //Ejecutar consulta
            if(psmt.executeUpdate()==1){
                mensaje="Se ha realizado la consulta correctamente en la base de datos..!!";
            }
        } catch (Exception e) {//Capturar exepciones
            JOptionPane.showMessageDialog(null, e.toString());//Muestrame la exeption para yo saber que paso
        }finally{//Cerrrar conexiones
             if(objConex!=null)
                objConex.conexion().close();//Cerramos la BD
            if(psmt!=null)
                psmt.close();
        }
        return mensaje;
    }

    @Override
    public List<?> listar() throws SQLException {
        try {
            psmt = objConex.conexion().prepareStatement("SELECT * FROM categorias WHERE estado='Activo'");// Crear conexión   
            rs = psmt.executeQuery();
            while(rs.next()){
                listCatg.add(Categoria.load(rs));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());//Muestrame la exeption para yo saber que paso
        }finally{
            if(objConex!=null)
                objConex.conexion().close();//Cerramos la BD
            if(psmt!=null)
                psmt.close();
            if(rs!=null)
                rs.close();
        }
        return listCatg;
    }

    public Object buscarPorID(String codigo) throws SQLException {
        try {
            psmt = objConex.conexion().prepareStatement("SELECT * FROM categorias WHERE id=?");
            psmt.setString(1, codigo);
            rs = psmt.executeQuery();//Ejecutamos el metodo
            while (rs.next()) {//Recorrer registros del arrays
                objCategoria = Categoria.load(rs);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());//Muestrame la exeption para yo saber que paso 
        } finally {
            if (objConex != null) {
                objConex.conexion().close();//Cerramos la BD
            }
            if (psmt != null) {
                psmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return objCategoria;
    }
    
    @Override
    public Object buscar(Object obj) throws SQLException {
        try {
            objCategoria = (Categoria)obj;
            psmt = objConex.conexion().prepareStatement("SELECT * FROM categorias WHERE nombre=?");
            psmt.setString(1, objCategoria.getNombre());
            rs = psmt.executeQuery();//Ejecutamos el metodo
            while(rs.next()){//Recorrer registros del arrays
                objCategoria = Categoria.load(rs);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());//Muestrame la exeption para yo saber que paso
        }finally{
            if(objConex!=null)
                objConex.conexion().close();//Cerramos la BD
            if(psmt!=null)
                psmt.close();
            if(rs!=null)
                rs.close();
        }
        return objCategoria;
    }

    public int generarCodigo() throws SQLException {
        try {
            psmt = objConex.conexion().prepareStatement("SELECT COUNT(*) FROM categorias");//Cuentame cuantos registros hay en la tabla categorias    
            rs = psmt.executeQuery();
            while (rs.next()) { //Realizar el conteo
                codigo = Integer.parseInt(rs.getString(1) + 1); //Aumento donde genero el nuevo codigo
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());//Muestrame la exeption para yo saber que paso 
        } finally {
            if (objConex != null) {
                objConex.conexion().close();//Cerramos la BD
            }
            if (psmt != null) {
                psmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return codigo;
    }
}
