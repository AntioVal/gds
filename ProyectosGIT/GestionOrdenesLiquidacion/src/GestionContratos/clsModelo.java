/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionContratos;

import java.sql.*;
import java.util.Vector;
import Common.clsConexion;

/**
 *
 * @author SISTEMASGP
 */
public class clsModelo {

    /**
     * Metodo que inserta o actualiza un contrato en la base de datos
     * @param clave_contrato : clave del contrato del cliente.
     * @param mitxtNombreCliente :Nombre del Cliente.
     * @param mitxtCuentaOrigen : Nombre de la Cuenta de Origen.
     * @param Grupo : Grupo.
     * @param mitxtDomicilioFiscal : Domicilio Fidcal del Cliente.
     * @param mitxtDomicilioFiscal : Grupo.
     * @param mitxtRFC : RFC.
     * @param mitxtTel : Teléfono.
     * @param correo : Correo Electrónico.
     * @param mitxtHonorario : Tipo de Honorario.
     * @param mitxtHonorarioSinIVA : Honorario sin IVA.
     * @param mitxtOficinas : Oficinas.
     * @return boolean valido: Regresa true si se guardo satisfactoriamente
     * la información en la base de datos, false en otro caso.
     */
    public static synchronized boolean guardaContrato(String clave_contrato, String mitxtNombreCliente, String mitxtCuentaOrigen, String mitxtGrupo, String mitxtDomicilioFiscal, String mitxtRFC,
            String mitxtTel, String correo, String mitxtHonorario, String mitxtHonorarioSinIVA, String mitxtOficinas, String mitxtID_codes) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean seGuardo = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            MySql = " insert into contratos ";
            MySql += " (clave_contrato , nombre_cliente , cuenta_origen , grupo , domicilio_fiscal , "
                    + " RFC , telefono , correo , tipo_honorario , honorario_sin_iva , "
                    + " oficinas , fecha_captura , status, saldo, id_codes) ";
            MySql += " values  ";
            MySql += " ( ";
            MySql += "'" + clave_contrato + "',";
            MySql += "'" + mitxtNombreCliente + "',";
            MySql += "'" + mitxtCuentaOrigen + "',";
            MySql += "'" + mitxtGrupo + "', ";
            MySql += "'" + mitxtDomicilioFiscal + "', ";
            MySql += "'" + mitxtRFC + "', ";
            MySql += "'" + mitxtTel + "', ";
            MySql += "'" + correo + "', ";
            MySql += "'" + mitxtHonorario + "', ";
            MySql += mitxtHonorarioSinIVA + ", ";
            MySql += "'" + mitxtOficinas + "', ";
            MySql += " getDate() ,";
            MySql += "'A', ";
            MySql += "0, ";
            MySql += "'" + mitxtID_codes + "' ";
            MySql += " ) ";

//            System.out.println(MySql);
            // Se ejecuta el encabezado
            statement.executeUpdate(MySql);
            seGuardo = true;

            if(seGuardo){
                seGuardo = false;
                
                MySql = "  CREATE TABLE EC_" + clave_contrato + " ( ";
                MySql += " fecha DATETIME NOT NULL, ";
                MySql += " concepto VARCHAR(40) NOT NULL, ";
                MySql += " observaciones VARCHAR(50) DEFAULT '', ";                      
                MySql += " cargo DECIMAL(13,2) NOT NULL DEFAULT 0.0, ";                      
                MySql += " abono DECIMAL(13,2) NOT NULL DEFAULT 0.0, ";                      
                MySql += " saldo DECIMAL(13,2) NOT NULL, ";                      
                MySql += " usuario_genera VARCHAR(50) NOT NULL DEFAULT 'DEFAULT', ";               
                MySql += " nombre_archivo VARCHAR(100) NOT NULL DEFAULT '') ";               
                
            statement.executeUpdate(MySql);
            seGuardo = true;                   
            }
            
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

    public static synchronized boolean cancelaContrato(String cliente) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean cancela = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            MySql = " update contratos ";
            MySql += " set status = 'B' ";
            if (!cliente.equals("TODOS")) {
                MySql += " where nombre_cliente ='" + cliente + "' ";
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

    /**
     * Metodo que regresa los clientes activos.
     * @return Vector clientes: Nombres de los clientes que se encuentran activos
     * a la fecha.
     */
    public static Vector getClientes() {

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

            clientes.add("   ---------------------Selecciona Fideicomitente---------------------   ");

            MySql = " select distinct(nombre_cliente) ";
            MySql += " from contratos ";
            MySql += " where contratos.status='A' ";
            MySql += "order by nombre_cliente asc ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                cliente = rstSQLServer.getString(1);
                clientes.add(cliente);
            }
//            clientes.add("TODOS");
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
     * Método que regresa la información ligada al cliente que se le pasa como
     * parámetro.
     * @return Vector cliente: Información registrada en la base de datos
     * del cliente especificado.
     */
    public static Vector getInfoContrato(String cliente) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        String[] contrato = null;
        Vector contratos = new Vector();
        String MySql = "";
        int idx = 0;
        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = "  select  clave_contrato  ,nombre_cliente , cuenta_origen , grupo , domicilio_fiscal , RFC , "
                    + " telefono , correo , tipo_honorario , honorario_sin_iva , oficinas, saldo, id_codes  ";
            MySql += " from contratos ";
            MySql += " where status ='A' ";

            if (!cliente.equals("TODOS")) {
                MySql += " and nombre_cliente='" + cliente + "' ";
            } else {
                MySql += " order by clave_contrato asc ";
            }
//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                contrato = new String[13];
                contrato[0] = rstSQLServer.getString(1) + ""; // Clave de Contrato
                contrato[1] = rstSQLServer.getString(2) + ""; // Nombre del Cliente
                contrato[2] = rstSQLServer.getString(3) + ""; // Cuenta Origen
                contrato[3] = rstSQLServer.getString(4) + ""; // Grupo
                contrato[4] = rstSQLServer.getString(5) + ""; // Domicilio Fiscal
                contrato[5] = rstSQLServer.getString(6) + ""; // RFC
                contrato[6] = rstSQLServer.getString(7) + ""; //Teléfono
                contrato[7] = rstSQLServer.getString(8) + ""; //Correo electrónico
                contrato[8] = rstSQLServer.getString(9) + ""; //Tipo de Honorario
                contrato[9] = rstSQLServer.getDouble(10) + ""; //Honorario sin INA
                contrato[10] = rstSQLServer.getString(11) + "";//Oficinas
                String saldo = rstSQLServer.getString(12) + "";//Saldo
                Double saldoD= -1.0;
                try{
                    saldoD = Double.parseDouble(saldo);
                }catch(Exception e){ saldoD = -1.0; }
                contrato[11] = saldoD + "";//saldoDouble
                contrato[12] = rstSQLServer.getString(13) + "";//id_codes

                contratos.add(contrato);
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
        }
        return contratos;
    }

    public static boolean verificaContrato(String clave_contrato) {
        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        boolean existe = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = "  select  * ";
            MySql += " from contratos";
            MySql += " where clave_contrato='" + clave_contrato + "' ";

            //System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                existe = true;
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
//            System.out.println(e.toString());
        }
        return existe;
    }

    public static boolean esContratoInactivo(String clave_contrato) {
        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        boolean existe = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = "  select  * ";
            MySql += " from contratos";
            MySql += " where clave_contrato='" + clave_contrato + "' ";
            MySql += " and status='I' ";

            //System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                existe = true;
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            //System.out.println(e.toString());
        }
        return existe;
    }

    /**
     * Método para validar el campo clave de contrato del Lay-Out
     * @param String campo: Clave del contrato
     * @return String[] desErrores: Errores obtenidos al validar
     */
    public static boolean validaClaveContrato(String campo) {

        String subCampo = "";

        boolean valido = true;
        int tmpo = 0;

        if (!campo.isEmpty()) {
            try {
                if (campo.length() == 13) {
                    subCampo = campo.substring(0, 3);
                    if (!subCampo.equals("FID")) {
                        valido = false;

                    }
                    subCampo = campo.substring(3, 6);
                    tmpo = Integer.parseInt(subCampo);
                    subCampo = campo.substring(9, 11);
                    tmpo = Integer.parseInt(subCampo);
                    //Verificamos que sea un mes válido
                    if (tmpo <= 0 || tmpo > 12) {
                        valido = false;
                    }
                    subCampo = campo.substring(11, 13);
                    tmpo = Integer.parseInt(subCampo);
                    if (tmpo <= 9) { //Aqui validar año de apertura de contrato
                        valido = false;
                    }
                } else {
                    valido = false;
                }
            } catch (Exception ex) {
                valido = false;
                // System.out.println(ex.toString());
            }
        } else {
            valido = false;
        }
        return valido;
    }

    //Actualiza los datos de un cierto contrato
    public static synchronized boolean actualizaContrato(String cliente, String clave_contrato, String nombre_cliente,
            String cuenta_origen, String grupo, String domicilio_fiscal, String RFC, String telefono, String correo,
            String tipo_honorario, String honorario_sin_iva, String oficinas, String id_codes) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean actualiza = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            MySql = " update contratos ";
            MySql += " set ";
            if (!clave_contrato.equals("") && !clave_contrato.equals("   -------------------------Selecciona Cliente-------------------------   ")) {
                MySql += " clave_contrato = '" + clave_contrato + "', ";
            }

            if (!nombre_cliente.equals("")) {
                MySql += " nombre_cliente = '" + nombre_cliente + "', ";
            }

            if (!cuenta_origen.equals("    ------------ Selecciona ------------  ")) {
                MySql += " cuenta_origen = '" + cuenta_origen + "', ";
            }

            if (!grupo.equals("")) {
                MySql += " grupo = '" + grupo + "', ";
            }

            if (!domicilio_fiscal.equals("")) {
                MySql += " domicilio_fiscal = '" + domicilio_fiscal + "', ";
            }

            if (!RFC.equals("")) {
                MySql += " RFC = '" + RFC + "', ";
            }

            if (!telefono.equals("")) {
                MySql += " telefono = '" + telefono + "', ";
            }

            if (!correo.equals("")) {
                MySql += " correo = '" + correo + "', ";
            }


            if (!tipo_honorario.equals("    ------------ Selecciona ------------  ")) {
                MySql += " tipo_honorario = '" + tipo_honorario + "', ";
            }

            if (!honorario_sin_iva.equals("")) {
                MySql += " honorario_sin_iva = " + honorario_sin_iva + ", ";
            }

            if (!oficinas.equals("")) {
                MySql += " oficinas = '" + oficinas + "', ";
            }
            if (!id_codes.equals("")) {
                MySql += " id_codes = '" + id_codes + "', ";
            }
            MySql = MySql.substring(0, MySql.length() - 2);

            MySql += " where nombre_cliente ='" + cliente + "' ";


//            System.out.println(MySql);
            // Se ejecuta el encabezado
            statement.executeUpdate(MySql);
            actualiza = true;
            
            connection.commit();
            //System.out.println("Transaction commit...");
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                conn.Desconecta(connection);
            }
        }
        return actualiza;
    }

    public static synchronized boolean activaContrato(String clave_contrato) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean cancela = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            MySql = " update contratos ";
            MySql += " set status = 'A' ";
            MySql += " where clave_contrato ='" + clave_contrato + "' ";

            // System.out.println(MySql);
            // Se ejecuta el encabezado
            statement.executeUpdate(MySql);
            cancela = true;

            connection.commit();
            // System.out.println("Transaction commit...");
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            // System.out.println(e.toString());
            e.printStackTrace();
            if (connection != null) {
                conn.Desconecta(connection);
            }
        }
        return cancela;
    }

    public static Vector getCuentaOrigen() {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        Vector cuentas = new Vector();
        String cuenta = "";
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = "  select cuenta_origen ";
            MySql += " from cuentas_banco ";
            MySql += " where status = 'A' ";
            MySql += " order by cuenta_origen asc ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);
            cuentas.add("    ------------ Selecciona ------------  ");
            while (rstSQLServer.next()) {
                cuenta = rstSQLServer.getString(1).toString().trim();
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
}
