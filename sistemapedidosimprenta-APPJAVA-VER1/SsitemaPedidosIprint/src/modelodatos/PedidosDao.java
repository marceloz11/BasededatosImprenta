/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodatos;
import java.util.List;
import java.util.Date;
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
public class PedidosDao {
    Conexion cn = new Conexion();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean RegistrarPedido(Pedidos pd){
        String sql="INSERT INTO pedido (id_pedido, fecha_emision, fecha_entrega, precio_pedido) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pd.getId_pedido());
            ps.setDate(2, new java.sql.Date(pd.getEmision().getTime()));
            ps.setDate(3, new java.sql.Date(pd.getEntrega().getTime()));
            ps.setDouble(4, pd.getPtotal());
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

    
    public List<Pedidos> ListarPedidos(){
        
        List<Pedidos> ListaPD= new ArrayList<>();
        String sql = "Select * FROM pedido;";
        
        
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
                Pedidos pd = new Pedidos();
                pd.setId_pedido(rs.getInt("id_pedido"));
                pd.setEmision(rs.getDate("fecha_emision"));
                pd.setEntrega(rs.getDate("fecha_entrega"));
                pd.setPtotal(rs.getDouble("precio_pedido"));
                ListaPD.add(pd);
            }
            
            
        } catch (SQLException e){
            System.out.println(e.toString());
            
        }
        
        return ListaPD; 
    } 
    public boolean EliminarPedido(int id_pedido){
        String sql = "{call sp_eliminar_pedido(?)}";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
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
    public boolean ModificarPedido (Pedidos pd) {
    String sql = "UPDATE pedido SET  fecha_emision = ?, fecha_entrega = ?, precio_pedido = ?  WHERE id_pedido = ?";
        try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(pd.getEmision().getTime()));
        ps.setDate(2, new java.sql.Date(pd.getEntrega().getTime()));
        ps.setDouble(3,pd.getPtotal());
        ps.setInt(4, pd.getId_pedido());
        ps.execute();
        return true;
        } catch (SQLException e) {
        System.out.println(e.toString());
        return false;
        }finally{
        try{
        con.close();
        } catch (SQLException e) {
        System.out.println(e.toString());
        }}}}
