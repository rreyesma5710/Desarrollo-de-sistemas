package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasUsuarios extends Conexion{
    
    public boolean registrar(Usuario user) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuarios (nombre,documento,empresa,direccion,password,id_rol,"
                + "id_especialidad) VALUES (?,?,?,?,?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getDocumento());
            ps.setString(3, user.getEmpresa());
            ps.setString(4, user.getDireccion());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRol());
            ps.setInt(7, user.getEspecialidad());
            ps.execute();
            
            return true;
        
        }catch(SQLException e) {
        
            System.out.println(e);
            
            return false;
        
        }finally { //finalizando concexión
        
            try {
                con.close();
            }catch(SQLException e) {
                System.out.println(e);
            }
        
        }
    
    }
    
    
    
    public boolean modificar(Usuario user) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "UPDATE usuarios SET nombre = ?,documento=?,empresa=?,direccion=?"
                + ",password=?,id_rol=?,id_especialidad=? WHERE id_usuario=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getDocumento());
            ps.setString(3, user.getEmpresa());
            ps.setString(4, user.getDireccion());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRol());
            ps.setInt(7, user.getEspecialidad());
            
            ps.setInt(8, user.getId());
            
            ps.execute();
            
            return true;
        
        }catch(SQLException e) {
        
            System.out.println(e);
            
            return false;
        
        }finally { //finalizando concexión
        
            try {
                con.close();
            }catch(SQLException e) {
                System.out.println(e);
            }
        
        }
    
    }
    
    
    
    public boolean eliminar(Usuario user) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "DELETE FROM usuarios  WHERE id_usuario=?";
        
        try {
                  
            ps = con.prepareStatement(sql);

            ps.setInt(1, user.getId());
            
            ps.execute();
            
            return true;
        
        }catch(SQLException e) {
        
            System.out.println(e);
            
            return false;
        
        }finally { //finalizando concexión
        
            try {
                con.close();
            }catch(SQLException e) {
                System.out.println(e);
            }
        
        }
    
    }
    
    
    public boolean buscarPorNombre(Usuario user) throws SQLException {
        
        ResultSet rs = null;
        
        Connection con = getConexion();
        
        String sql = "SELECT * FROM usuarios  WHERE nombre = ?";
        
        //PreparedStatement ps = null;
         PreparedStatement ps = con.prepareStatement(sql);
         
        try {
                        
                ps.setString(1, user.getNombre());
                rs = ps.executeQuery();
   
            if(rs.next()) {
                    user.setId(Integer.parseInt(rs.getString("id_usuario")));
                    user.setNombre(rs.getString("nombre"));
                    user.setDocumento(rs.getString("documento"));
                    user.setEmpresa(rs.getString("empresa"));
                    user.setDireccion(rs.getString("direccion"));
                    user.setPassword(rs.getString("password"));
                    user.setRol(Integer.parseInt(rs.getString("id_rol")));
                    user.setEspecialidad(Integer.parseInt(rs.getString("id_especialidad")));                
                return true;
            }            
            return false;
         
        }catch(SQLException e) {
        
            System.out.println(e);
            
            return false;
        
        }finally { //finalizando concexión
        
            try {
                con.close();
            }catch(SQLException e) {
                System.out.println(e);
            }
        
        }
          
    }
    
}
