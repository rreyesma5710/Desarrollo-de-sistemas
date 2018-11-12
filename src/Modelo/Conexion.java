package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private final String base = "instance_mesa_ayuda";
    private final String user = "instance_ma";
    private final String password = "mesadeayuda147#";
    private final String url = "jdbc:mysql://192.99.186.112:3306/"+base;
    
    private Connection con = null;
    
    
    public Connection getConexion() {
        
        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
        
        } catch(SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
        
    }
}
