package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Omar Medina
 */
public class Cliente extends Persona {

    private int codigo;
    private String tipoCliente;
    private String est;

    public Cliente() {
    }

    public Cliente(int codigo, String tipoCliente, String est, String nroDocumento, String tipoDocumento, String apellidos, String nombre, String email, String estado) {
        super(nroDocumento, tipoDocumento, apellidos, nombre, email, estado);
        this.codigo = codigo;
        this.tipoCliente = tipoCliente;
        this.est = est;
    }

    //Construye el objeto completo
    public static Cliente load(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setCodigo(rs.getInt(1));
        cliente.setTipoCliente(rs.getString(2));
        cliente.setEst(rs.getString(3));
        cliente.setNroDocumento(rs.getString(4));
        cliente.setTipoDocumento(rs.getString(5));
        cliente.setApellidos(rs.getString(6));
        cliente.setNombre(rs.getString(7));
        cliente.setEmail(rs.getString(8));
        return cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", tipoCliente=" + tipoCliente + ", est=" + est + '}';
    }

    
    
}
