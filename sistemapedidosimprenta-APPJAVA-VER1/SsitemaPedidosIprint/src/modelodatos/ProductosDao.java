/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodatos;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author asus
 */
public class ProductosDao {
    Conexion cn = new Conexion();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean RegistrarProductos(Productos pro){
        String sql="INSERT INTO producto (id_producto, nombre_prod, precio, tipo, id_pedido, id_supervisor) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId_producto());
            ps.setString(2, pro.getNombre_prod());
            ps.setDouble(3, pro.getPrecio());
            ps.setString(4, pro.getTipo());
            ps.setInt(5, pro.getId_pedido());
            ps.setInt(6, pro.getId_supervisor());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally { 
            try {
                con.close();
            } catch (SQLException e) {
                System.out.print(e.toString());
            }
        }
    } 
    public List<Productos> ListarProductos(){
        
        List<Productos> Listaprod= new ArrayList<>();
        String sql = "Select * FROM producto;";
        
        
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
                Productos pr = new Productos();
                pr.setId_producto(rs.getInt("id_producto"));
                pr.setNombre_prod(rs.getString("nombre_prod"));
                pr.setPrecio(rs.getDouble("precio"));
                pr.setTipo(rs.getString("tipo"));
                pr.setId_pedido(rs.getInt("id_pedido"));
                pr.setId_supervisor(rs.getInt("id_supervisor"));
                Listaprod.add(pr);
            }
            
            
        } catch (SQLException e){
            System.out.println(e.toString());
            
        }
        
        return Listaprod; 
    } 
    public boolean EliminarProducto(int id_producto){
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            ps.execute();
            return true
            ; }catch (SQLException e)           {
                System.out.println(e.toString());
                return false;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
}
    public boolean ModificarProductos(Productos pro){
       String sql = "UPDATE producto SET nombre_prod=?, precio=?, tipo=?, id_pedido=?, id_supervisor=? WHERE id_producto=?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, pro.getNombre_prod());
           ps.setDouble(2, pro.getPrecio());
           ps.setString(3, pro.getTipo());
           ps.setInt(4, pro.getId_pedido());
           ps.setInt(5, pro.getId_supervisor());
           ps.setInt(6, pro.getId_producto());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
}
