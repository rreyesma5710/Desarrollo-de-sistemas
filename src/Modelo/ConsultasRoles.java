package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasRoles extends Conexion{
    
    public boolean registrar(Rol rol) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "INSERT INTO roles (nombre,descripcion) VALUES (?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, rol.getNombre());
            ps.setString(2, rol.getDescripcion());
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
    
    
    
    public boolean modificar(Rol rol) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "UPDATE roles SET nombre = ?,descripcion=? WHERE id_rol=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, rol.getNombre());
            ps.setString(2, rol.getDescripcion());            
            ps.setInt(3, rol.getId());
            
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
    
    
    
    public boolean eliminar(Rol rol) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "DELETE FROM roles  WHERE id_rol=?";
        
        try {
 
            ps = con.prepareStatement(sql);

            ps.setInt(1, rol.getId());
            
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
    
    
    public boolean buscarPorNombre(Rol rol) throws SQLException {
    
        
        
        ResultSet rs = null;
        
        Connection con = getConexion();
        
        String sql = "SELECT * FROM roles  WHERE nombre = ?";
        //PreparedStatement ps = null;
         PreparedStatement ps = con.prepareStatement(sql);
        try {
//System.out.println(rol.getNombre());                        
            ps.setString(1, rol.getNombre());
            
            
            rs = ps.executeQuery();
//System.out.println(rs);
            if(rs.next()) {
                rol.setId(Integer.parseInt(rs.getString("id_rol")));
                rol.setNombre(rs.getString("nombre"));
                rol.setDescripcion(rs.getString("descripcion"));
                
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
