package dao;

//Para la conexión necesitamos utilizar unas clases

import java.sql.Connection;//Sentencias de tipo SQL
import java.sql.DriverManager;//Driver que permite trabajar con la conexión a la BD de Mysql
import java.sql.SQLException;//Me permite capturar excepciones 

public class ConexionDB {
    Connection con;//Declarar el objeto, variable
    private String dateBaseUrl = "jdbc:mysql://localhost:3306/cafeteria_2_0";//Establece donde se encuentra la BD
    private String usuario = "root";//Conocer el usario de la BD
    private String clave = "medina07";//Conocer la contraseña del usuario
    
    public Connection conexion() throws SQLException {//Driver Manager hace la la conexión con la BD, lo que me va a delvover cada vez que yo llame a este método es un objeto Connection
        
        try {
            con = DriverManager.getConnection(this.dateBaseUrl, this.usuario, this.clave);
            if (con!= null) {
                System.out.println("\n--> Conectado <--");
            }
        } catch (Exception ex) {
            System.out.println("\n--> No Conectado <--");
            System.out.println(ex);
        }
        return con;
    }

//    public static void main(String[] args) throws SQLException {//Probando el método si realmente me estoy conectando a la BD
//       ConexionDB objCon = new ConexionDB();
//       objCon.conexion();//Lo que me va a devolver es una conexión
//    }
}
