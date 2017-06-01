/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luis-Valerio
 */
public class ConexionSQL {

    public ConexionSQL() {
    }

    public Connection ConectaSQLServer() throws SQLException {
        Connection lcnnConexion;
        String classForName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        try {
            Class.forName(classForName);

            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=garante;user=garante;password=Garante#2016;";
            lcnnConexion = DriverManager.getConnection(connectionUrl);

            // Conexión
//            lcnnConexion = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            System.out.println(e.toString());
            lcnnConexion = null;
        }
        return lcnnConexion;
    }
//
//    public Connection ConectaMySQL() {
//        Connection conexion = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String servidor = "jdbc:mysql://localhost/inventario";
//            String usuarioDB = "root";
//            String passwordDB = "";
//            conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
//        } catch (ClassNotFoundException ex) {
////            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
//            conexion = null;
//        } catch (SQLException ex) {
////            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
//            conexion = null;
//        } catch (Exception ex) {
////            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
//            conexion = null;
//        } finally {
//            return conexion;
//        }
//    }

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
