/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.CategoriaImpDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author Omar Medina
 */
public class PruebaCategoria {
    public static void main(String[] args) throws SQLException {
        //Si hay algun problema con la conexión SQL Exception lo captura
        //Crear un objeto de tipo categoria y voy a insertarlo dentro del Arrays
          Categoria objCategoria = new Categoria(2,"Bebidas","Activo");//Llamo al objeto, creo un objeto Categoria
          CategoriaImpDAO objImpCat = new CategoriaImpDAO();//Llamo a los metodos modificar, insertar creo un objeto Categoria de tipo implement
          ArrayList<Categoria> listCatg = new ArrayList<>();//Creo Arrays para almacenar los datos en el ArraysList
      
//          objImpCat.insertar(objCategoria);
          objImpCat.modificar(objCategoria);
//          objImpCat.eliminar(objCategoria);
         
//          System.out.println("Buscar "+ objImpCat.buscar(objCategoria));
          
//          listCatg = (ArrayList<Categoria>) objImpCat.listar();//Llamando a listar y este objeto va hacer de tipo categoria
     
//          for (Categoria categoria : listCatg) { //Permite imprimir elementos de un arrays
//          System.out.println("Objeto: " + categoria.toString());   
//          }
        
//          ConexionDB objCon = new ConexionDB();
//          objCon.conexion();//Lo que me va a devolver es una conexión
    }
}
