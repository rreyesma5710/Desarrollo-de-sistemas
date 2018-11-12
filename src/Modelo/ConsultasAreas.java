package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasAreas extends Conexion{
    
    public boolean registrar(Area ar) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "INSERT INTO areas (nombre,descripcion) VALUES (?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, ar.getNombre());
            ps.setString(2, ar.getDescripcion());
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
    
    
    
    public boolean modificar(Area ar) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "UPDATE areas SET nombre = ?,descripcion = ? WHERE id_area = ?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, ar.getNombre());
            ps.setString(2, ar.getDescripcion());            
            ps.setInt(3, ar.getId());
            
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
    
    
    
    public boolean eliminar(Area ar) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "DELETE FROM areas  WHERE id_area = ?";
        
        try {
                        
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, ar.getId());
            
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
    
    
    public boolean buscarPorNombre(Area ar) throws SQLException {
    
        ResultSet rs = null;
        
        Connection con = getConexion();
        
        String sql = "SELECT * FROM areas  WHERE nombre = ?";
        
        //PreparedStatement ps = null;
         PreparedStatement ps = con.prepareStatement(sql);

        try {
                        
            ps.setString(1, ar.getNombre());
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                ar.setId(Integer.parseInt(rs.getString("id_area")));
                ar.setNombre(rs.getString("nombre"));
                ar.setDescripcion(rs.getString("descripcion"));
                
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
