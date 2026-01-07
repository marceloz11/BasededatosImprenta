/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodatos;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public logginn log(String correo, String Pass){
      logginn l = new  logginn();
      String sql = "Select * From empleado WHERE correo = ? AND pass = ?";
      try {
          con = cn.getConnection();
          ps = con.prepareStatement(sql);
          ps.setString(1,correo);
          ps.setString(2,Pass);
          rs= ps.executeQuery();
          if (rs.next()){
              l.setId(rs.getInt("id_empleado"));
              l.setNombre(rs.getString("nombre_completo"));
              l.setCorreo(rs.getString("correo"));
              l.setPass(rs.getString("pass"));
          }
         } catch (SQLException e) {
             System.out.println(e.toString());
        } 
      return l;
}}
