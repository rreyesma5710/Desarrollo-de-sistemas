package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasTickets extends Conexion{
    
    public boolean registrar(Ticket tck) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "INSERT INTO tickets (id_cliente,id_tecnico,descripcion,estado) VALUES (?,?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, tck.getCliente());
            ps.setInt(2, tck.getTecnico());
            ps.setString(3, tck.getDescripcion());
            ps.setInt(4, tck.getEstado());

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
    
    
    
    public boolean modificar(Ticket tck) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "UPDATE tickets SET id_cliente = ?,id_tecnico=?,descripcion=?,estado=? WHERE id_ticket=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, tck.getCliente());
            ps.setInt(2, tck.getTecnico());
            ps.setString(3, tck.getDescripcion());
            ps.setInt(4, tck.getEstado());
            
            ps.setInt(5, tck.getId());
            
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
    
    
    
    public boolean eliminar(Ticket tck) {
    
        PreparedStatement ps = null;
        
        Connection con = getConexion();
        
        String sql = "DELETE FROM tickets  WHERE id_ticket=?";
        
        try {
               
            ps = con.prepareStatement(sql);

            ps.setInt(1, tck.getId());
            
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
    
    
    public boolean buscarPorDescripcion(Ticket tck) throws SQLException {
        
        
        ResultSet rs = null;
        
        Connection con = getConexion();
        
        String sql = "SELECT * FROM tickets  WHERE descripcion = ?";
        
        //PreparedStatement ps = null;
         PreparedStatement ps = con.prepareStatement(sql);
        
        
        try {
                        
            ps.setString(1, tck.getDescripcion());
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                tck.setId(Integer.parseInt(rs.getString("id_ticket")));
                tck.setCliente(Integer.parseInt(rs.getString("id_cliente")));
                tck.setTecnico(Integer.parseInt(rs.getString("id_tecnico")));
                tck.setDescripcion(rs.getString("descripcion"));
                tck.setEstado(Integer.parseInt(rs.getString("estado")));
                
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
