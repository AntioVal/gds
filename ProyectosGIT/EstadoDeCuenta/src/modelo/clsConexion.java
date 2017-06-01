/*
 *    Creado por:                   Luis-valerio
 *    Fecha:                        23/02/2011
 *    Descripción:                  Controlador : "clsConexion.java" Conecta y Desconecta a la Base de Datos.
 *    Responsable:                  Rafael-Bello
 */
package modelo;

import java.sql.*;

/*
 * Clase que proporciona los métodos necesarios
 * para conectar y desconectar a una Base de Datos.
 */
public class clsConexion {

    /**
     * Creates a new instance of clsConexion
     */
    public clsConexion() {
    }

    /**
     * Método para obtener una conexión a la base de datos mediante un ODBC
     */
    public Connection ConectaSQLServer() throws SQLException {
        Connection lcnnConexion;
        System.out.println("Creando conexion ...");        
        String classForName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";                
        
        try {
            Class.forName(classForName);        
            
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
        //CONEXION BD                
        +   "databaseName=garante;user=garante;password=Garante#2016;";
        lcnnConexion = DriverManager.getConnection(connectionUrl);
        

            // Conexión
//            lcnnConexion = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            System.out.println(e.toString());
            lcnnConexion = null;
        }
        return lcnnConexion;
    }

    /**
     * Método para desconectar una conexión existente
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
