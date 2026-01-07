/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class Conexion {
    Connection con = null;
    String usuario12="root";
    String contra12="Rafael011111@"; 
    String db12= "sistemaimprenta";
    String ip= "localhost";
    String puerto="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+db12;
    public Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(cadena,usuario12,contra12);
        JOptionPane.showMessageDialog(null,"Se conecto a la base de datos exitosamente: ");
        }catch (Exception e ){
         JOptionPane.showMessageDialog(null, "No se conecto a la base de datos, error: "+ e.toString());
        } 
         return con;
    }
}
