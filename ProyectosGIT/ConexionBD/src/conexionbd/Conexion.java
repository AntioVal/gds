package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private final String user, password, driver, url;
    
    public Conexion() {
        this.user = "garante";
        this.password = "Garante#2016";
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.url = "jdbc:sqlserver://localhost:1433;databaseName=garante;";
    }
    
    protected Connection conectar(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    protected void desconectar(ResultSet res, PreparedStatement declaracion, Connection conn) {
        try {
            if (res != null) {            
                res.close();
            }
            if (declaracion != null) {
                declaracion.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
