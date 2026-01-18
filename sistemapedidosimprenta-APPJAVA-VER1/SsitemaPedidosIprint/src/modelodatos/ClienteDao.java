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
public class ClienteDao {
    Conexion cn = new Conexion();
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean RegistrarCliente(Cliente cl){
        String sql="INSERT INTO cliente (cedula, correo, nombre, direccion, telefono) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getCedula());
            ps.setString(5, cl.getCorreo());
            ps.setString(2, cl.getNombre());
            ps.setString(4, cl.getDireccion());
            ps.setString(3, cl.getTelefono());
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

    
    public List<Cliente> ListarCliente(){
        
        List<Cliente> ListaCl= new ArrayList<>();
        String sql = "Select * FROM cliente;";
        
        
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setCedula(rs.getInt("Cedula"));
                cl.setCorreo(rs.getString("Correo"));
                cl.setNombre(rs.getString("Nombre"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setTelefono(rs.getString("Telefono"));
                ListaCl.add(cl);
            }
            
            
        } catch (SQLException e){
            System.out.println(e.toString());
            
        }
        
        return ListaCl; 
    } 
    public boolean EliminarCliente(int cedula){
        String sql = "DELETE FROM cliente WHERE cedula = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cedula);
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
    public boolean ModificarCliente (Cliente cl) {
    String sql = "UPDATE cliente SET  correo = ?, nombre = ?, direccion = ? , telefono = ? WHERE cedula = ?";
        try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, cl.getCorreo());
        ps.setString(2, cl.getNombre());
        ps.setString(3, cl.getDireccion());
        ps.setString(4, cl.getTelefono());
        ps.setInt(5, cl.getCedula());
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