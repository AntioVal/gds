/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCuentasBancarias;

import java.sql.*;
import java.util.Vector;
import Common.clsConexion;

public class clsModelo {

    /**
     * Método que regresa todas las cuentas bancarias activas.
     * @return Vector clientes: Regresa todos los nombre del
     * las cuentas de origen activas en el sistema.
     */
    public static Vector getCuentasOrigen() {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        Vector clientes = new Vector();
        String MySql = "";
        String cliente = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            clientes.add("   -----Selecciona Cuenta-----   ");

            MySql = " select cuenta_origen ";
            MySql += " from cuentas_banco ";
            MySql += " where status ='A' ";
            MySql += " order by cuenta_origen asc ";

            //System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                cliente = rstSQLServer.getString(1);
                clientes.add(cliente);
            }
           
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
        }
        return clientes;
    }

    /**
     * Método que da de baja la cuenta que esta asociada a la cuenta de
     * origen que se le pasa como parámetro.
     * @param mitxtHonorarioSinIVA : Honorario sin IVA.
     * @return boolean cancela: Si la cancelación se realizo
     * satisfactoriamente regresa true, false en otro caso.
     */
    public static synchronized boolean cancelaCuenta(String cuenta_origen) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean cancela = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            MySql = " update cuentas_banco ";
            MySql += " set status = 'I' ";
            if (!cuenta_origen.equals("TODOS")) {
                MySql += " where cuenta_origen ='" + cuenta_origen + "' ";
            }
//            System.out.println(MySql);
            // Se ejecuta el encabezado
            statement.executeUpdate(MySql);
            cancela = true;

            connection.commit();
//            System.out.println("Transaction commit...");
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
            e.printStackTrace();
            if (connection != null) {
                conn.Desconecta(connection);
            }
        }
        return cancela;
    }

    public static String validaCuenta(String cuenta_origen) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        String valida = "";
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = " select status ";
            MySql += " from cuentas_banco ";
            MySql += " where cuenta_origen ='" + cuenta_origen + "' ";


//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            if (rstSQLServer.next()) {
                valida = rstSQLServer.getString(1);
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
        }
        return valida;
    }

    public static synchronized boolean guardaCuenta(String cuenta_origen, String num_cuenta, String clave_cuenta, String status) {
        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean seGuardo = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            if (status.equals("")) {
                MySql = " insert into cuentas_banco ";
                MySql += " (cuenta_origen,num_cuenta,clave_cuenta,status)";
                MySql += " values  ";
                MySql += " ( ";
                MySql += "'" + cuenta_origen + "',";
                MySql += "'" + num_cuenta + "',";
                MySql += "'" + clave_cuenta + "',";
                MySql += "'A' ";
                MySql += " ) ";
            } else {
                if (status.equals("I")) {
                    MySql = " update cuentas_banco ";
                    MySql += " set cuenta_origen = '" + cuenta_origen + "', ";
                    MySql += " num_cuenta = '" + num_cuenta + "', ";
                    MySql += " clave_cuenta = '" + clave_cuenta + "', ";
                    MySql += " status = 'A' ";
                    MySql += " where cuenta_origen = '" + cuenta_origen + "' ";
                }
            }

//            System.out.println(MySql);
            // Se ejecuta el encabezado
            statement.executeUpdate(MySql);
            seGuardo = true;

            connection.commit();
//            System.out.println("Transaction commit...");
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
            e.printStackTrace();
            if (connection != null) {
                conn.Desconecta(connection);
            }
        }
        return seGuardo;
    }

    /**
     * Método que regresa la información de la cuenta bancaria ligada a la
     * cuenta de origen que se le pasa como parámetro.
     * @return Vector cuentas: Información registrada en la base de datos
     * de la cuenta origen especificada.
     */
    public static Vector getInfoCuentas(String cuenta_origen) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        String[] cuenta = null;
        Vector cuentas = new Vector();
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = "  select  cuenta_origen,num_cuenta,clave_cuenta";
            MySql += " from cuentas_banco";
            MySql += " where status = 'A' ";

            if (!cuenta_origen.equals("TODOS")) {
                MySql += " and cuenta_origen='" + cuenta_origen + "' ";
            } else {
                MySql += " order by cuenta_origen asc ";
            }
//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                cuenta = new String[3];
                cuenta[0] = rstSQLServer.getString(1).toString().trim();
                cuenta[1] = rstSQLServer.getString(2).toString().trim();
                cuenta[2] = rstSQLServer.getString(3).toString().trim();
                cuentas.add(cuenta);
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
        }
        return cuentas;
    }

    public static boolean validaCuentaOrigen(String cuenta_origen) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        boolean valida = false;
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = " select cuenta_origen ";
            MySql += " from cuentas_banco ";
            MySql += " where cuenta_origen ='" + cuenta_origen + "' ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            if (rstSQLServer.next()) {
                valida = true;
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
        }
        return valida;
    }

    public static synchronized boolean actualizaCuenta(String cuenta_origen, String cuenta, String num_cuenta,
            String clave_cuenta) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean cancela = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            MySql = " update cuentas_banco set ";

            if (!cuenta.equals("")) {
                MySql += "  cuenta_origen = '" + cuenta + "', ";
            }

            if (!num_cuenta.equals("")) {
                MySql += " num_cuenta= '" + num_cuenta + "', ";
            }

            if (!clave_cuenta.equals("")) {
                MySql += " clave_cuenta= '" + clave_cuenta + "', ";
            }
            MySql = MySql.substring(0, MySql.length() - 2);

            MySql += " where cuenta_origen ='" + cuenta_origen + "' ";

            //System.out.println(MySql);
            // Se ejecuta el encabezado
            statement.executeUpdate(MySql);
            cancela = true;

            connection.commit();
//            System.out.println("Transaction commit...");
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
            e.printStackTrace();
            if (connection != null) {
                conn.Desconecta(connection);
            }
        }
        return cancela;
    }
}
