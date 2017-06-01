/*
 *    Creado por:                   Hernández Paredes Denis Alin
 *    Fecha:                        23/02/2011
 *    Descripción:                  Controlador : "clsConexion.java" Conecta y desconecta a la BD
 *    Responsable:                  Carlos Altamirano
 */
package Common;

import java.sql.*;

/*
 * Clase que proporciona los metodos necesarios
 * para conectar y desconectar a la base de datos sofom
 */
public class clsConexion {

    /**
     * Creates a new instance of clsConexion
     */
    public clsConexion() {
    }

    /**
     * Metodo para obtener una conexion a la base de datos sofom
     */
    public Connection ConectaSQLServer() {
        Connection lcnnConexion=null;

        // BD SERVIDOR TOCALWEB
//        String login = "fideicomiso";
//        String password = "FIDEICOMISO2011X";
//        String classForName = "sun.jdbc.odbc.JdbcOdbcDriver";
//        String url = "jdbc:odbc:ServerPrincipal";


        // BD LOCAL
        // Conexión local
//        String login = "admin";
//        String password = "admin";
//        String classForName = "sun.jdbc.odbc.JdbcOdbcDriver";
//        String url = "jdbc:odbc:prueba";


        //nueva conexion java version: 8_25
//        String classForName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //antes de la nueva version
         String classForName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(classForName);        
            //        CONEXION EN SERVIDOR ABUGABER
        String connectionUrl = "jdbc:sqlserver://149.56.134.20:1433;" +              
        "databaseName=garante;user=garante;password=Garante#2016;";                
        lcnnConexion = DriverManager.getConnection(connectionUrl);        


//        try {
//            Class.forName(classForName);
//            lcnnConexion = DriverManager.getConnection(url, login, password);

        } catch (SQLException sqlE) {
            System.out.println("SQLException-clsConexion" + sqlE.getMessage());
        } catch (Exception e) {
            System.out.println("Exception-clsConexion:" + e.getMessage());
        } finally {
//            lcnnConexion = null;
        }
        return lcnnConexion;
    }

    /**
     * Metodo para desconectar una conexion
     */
    public boolean Desconecta(Connection lcnnConexion) {
        try {
            lcnnConexion.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
