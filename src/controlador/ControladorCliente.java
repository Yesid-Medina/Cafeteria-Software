package controlador;

import dao.ClienteImpDAO;
import java.sql.SQLException;
import java.util.List;
import modelo.Cliente;

public class ControladorCliente {

    ClienteImpDAO clienteImpDAO = new ClienteImpDAO();

    public List<Cliente> listarCliente() throws SQLException {
        return (List<Cliente>) clienteImpDAO.listar();
    }

    public Cliente buscarClientePorId(int codigo) throws SQLException {
        return (Cliente) clienteImpDAO.buscarPorId(codigo);
    }

}
