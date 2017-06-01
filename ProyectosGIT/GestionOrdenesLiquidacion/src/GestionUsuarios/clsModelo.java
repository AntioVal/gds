/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuarios;

import java.sql.*;
import java.io.*;
import java.util.Vector;
import Common.clsConexion;

public class clsModelo {

    public static Vector bajaClaveFiso = new Vector();
//    public static Vector altaClaveFiso = new Vector();

    public clsModelo() {
    }

    /**
     * Método que inserta o actualiza un usuario en la base de datos
     * @param clave_contrato : clave del contrato del cliente.
     * @param clave_cliente : clave del cliente.
     * @param usuario : nombre del usuario.
     * @param password : Password del usuario.
     * @return boolean valido: Regresa true si se guardo satisfactoriamente
     * la información en la base de datos, false en otro caso.
     */
    public static synchronized boolean guardaDatos(String clave_contrato, String clave_cliente, String nombre_usuario, String telefono_usuario, String usuario, String password, String correo, String status) {

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
                MySql = " insert into usuarios ";
                MySql += " (clave_contrato,clave_cliente,nombre_usuario,telefono_usuario,contacto_usuario,usuario,password,fecha_alta,status) ";
                MySql += " values  ";
                MySql += " ( ";
                MySql += "'" + clave_contrato + "',";
                MySql += "'" + clave_cliente + "',";
                MySql += "'" + nombre_usuario + "',";
                MySql += "'" + telefono_usuario + "',";
                MySql += "'" + correo + "',";
                MySql += "'" + usuario + "',";
                MySql += "'" + password + "', ";
                MySql += " getDate(), ";
                MySql += "'A'";
                MySql += " ) ";
            } else {
                if (status.equals("I")) {
                    MySql = " update usuarios";
                    MySql += " set status='A' ,";
                    MySql += " fecha_alta = getDate() ,";
                    MySql += " password ='" + password + "' ";
                    MySql += " where clave_cliente='" + clave_cliente + "' ";
                    MySql += " and clave_contrato='" + clave_contrato + "' ";
                    MySql += " and usuario='" + usuario + "' ";
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
     * Método que regresa los clientes activos en el sistema de liquidaciones.
     * @return Vector clientes: Nombres de los clientes que se encuentran activos
     * a la fecha, regresa null si ocurrio algún error.
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

            clientes.add(" -----Seleccione----- ");

            MySql = " select clave_contrato ";
            MySql += " from contratos ";
            MySql += " where status='A' ";
            MySql += "order by clave_contrato asc ";

//            System.out.println(MySql);
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
            clientes = null;
        }
        return clientes;
    }

    /**
     * Método que el nombre del fideicomitente asociado a la clave de contrato
     * que se le pasa como parámetro.
     * @return nombre del fideicomitente, en caso de error
     * regresa null.
     */
    public static String getFideicomitente(String clave_contrato) {
        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        String nombre = "";
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = " select nombre_cliente ";
            MySql += " from contratos ";
            MySql += " where clave_contrato='" + clave_contrato + "' ";
            MySql += " and status='A' ";
//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);
            if (rstSQLServer.next()) {
                nombre = rstSQLServer.getString(1);
            }
            rstSQLServer.close();
            statement.close();
            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            nombre = null;
        }
        return nombre;
    }

    /**
     * Metodo que regresa los clientes activos.
     * @return Vector clientes: Nombres de los clientes que se encuentran activos
     * a la fecha.
     */
    public static Vector getClientesBaja() {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        Vector clientes = new Vector();
        bajaClaveFiso = new Vector();
        String MySql = "";
        String cliente = "";
        int idx = 1;

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            clientes.add("   -------------------------Selecciona Fideicomitente-------------------------   ");

            MySql = " select distinct(contrato.nombre_cliente), contrato.clave_contrato   ";
            MySql += " from contratos contrato , usuarios usuario  ";
            MySql += " where contrato.clave_contrato = usuario.clave_contrato  ";
            MySql += " and usuario.status='B' order by contrato.nombre_cliente asc   ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                cliente = idx + ".- " + rstSQLServer.getString(1);
                clientes.add(cliente);
                cliente = rstSQLServer.getString(2).toString().trim();
                bajaClaveFiso.add(cliente);
                idx++;
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            clientes = null;
        }
        return clientes;
    }

    /**
     * Metodo que regresa los clientes activos.
     * @return Vector clientes: Nombres de los clientes que se encuentran activos
     * a la fecha.
     */
    public static Vector getUsuariosBaja(String clave_contrato) {

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

            clientes.add("   -------Selecciona Usuario--------   ");

            MySql = " select distinct usuario ";
            MySql += " from usuarios ";
            MySql += " where status='B' ";
            MySql += " and clave_contrato ='" + clave_contrato + "' ";
            MySql += "order by usuario asc ";

//            System.out.println(MySql);
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
     * Método que regresa el conjunto de usuarios bloqueados en el sistema de liquidaciones
     * correspondientes al fideicomiso que se le pasa como parámetro.
     * @param String clave_contrato: Clave asociada al Fideicomiso.
     * @return Vector usuarios: Conjunto de usuarios bloqueados en el sistema.
     */
    public static Vector getUsuariosBloqueados(String clave_contrato) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        Vector usuarios = new Vector();
        String usuario = "";
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = " select distinct usuario ";
            MySql += " from usuarios ";
            MySql += " where status='B' ";
            MySql += " and clave_contrato ='" + clave_contrato + "' ";
            MySql += "order by usuario asc ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            usuarios.add("   -------Selecciona Usuario--------   ");

            while (rstSQLServer.next()) {
                usuario = rstSQLServer.getString(1).toString().trim();
                usuarios.add(usuario);
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            usuarios = null;
        }
        return usuarios;
    }

    public static String verificaUsuario(String usuario) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        String existe = "";
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = " select clave_cliente,clave_contrato,status ";
            MySql += " from usuarios ";
            MySql += " where usuario='" + usuario + "' ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            if (rstSQLServer.next()) {
                existe = rstSQLServer.getString(1).toString().trim();
                existe += " " + rstSQLServer.getString(2).toString().trim();
                existe += " " + rstSQLServer.getString(3).toString().trim();
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            existe = "Error";
//            System.out.println(e.toString());
        }
        return existe;
    }
//Regresa la fecha en la que se bloqueo la cuenta del usuario que se le pasa como parámetro.

    public static String getFechaBloqueo(String clave_contrato, String usuario) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        String fecha = "";
        String MySql = "";
        int idx = 0;

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = " select fecha_bloqueo ";
            MySql += " from usuarios ";
            MySql += " where clave_contrato ='" + clave_contrato + "' ";
            MySql += " and usuario='" + usuario + "' ";
            MySql += " and status='B' ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            if (rstSQLServer.next()) {
                fecha = rstSQLServer.getString(1).toString().trim();
                // Obtenemos la clave del Fideicomiso.
                idx = fecha.indexOf(".");
                fecha = fecha.substring(0, idx).toString().trim();
            }
            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            fecha = "";
        }
        return fecha;
    }

    public static String verificaUsuario(String usuario, String clave_contrato) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;

        String existe = "";
        String MySql = "";

        try {
            connection = conn.ConectaSQLServer();
            statement = connection.createStatement();
            statement.execute("SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED");

            MySql = " select status ";
            MySql += " from usuarios ";
            MySql += " where clave_contrato='" + clave_contrato + "' ";
            MySql += " and usuario='" + usuario + "' ";

//            System.out.println(MySql);

            ResultSet rstSQLServer = statement.executeQuery(MySql);

            if (rstSQLServer.next()) {
                existe = rstSQLServer.getString(1).toString().trim();
            }

            rstSQLServer.close();
            statement.close();

            if (connection != null) {
                conn.Desconecta(connection);
            }
        } catch (Exception e) {
            existe = "Error";
        }
        return existe;
    }

    public static Vector getUsuarios(String clave_contrato) {

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

            clientes.add(" -----Seleccione----- ");

            MySql = " select distinct usuario ";
            MySql += " from usuarios ";
            MySql += " where status='A' ";
            MySql += " and clave_contrato ='" + clave_contrato + "' ";
            MySql += "order by usuario asc ";

//            System.out.println(MySql);
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
    
    
    public static Vector getInfoUsuario(String clave_contrato,String usuario) {

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

//            clientes.add("   -----Selecciona Usuario-----   ");

            MySql = " select nombre_usuario,puesto_usuario,contacto_usuario,fecha_alta ";
            MySql += " from usuarios ";
            MySql += " where status='A' ";
            MySql += " and clave_contrato ='" + clave_contrato + "' ";
            MySql += " and usuario ='" + usuario + "' ";
            MySql += "order by usuario asc ";

//            System.out.println(MySql);
            ResultSet rstSQLServer = statement.executeQuery(MySql);

            while (rstSQLServer.next()) {
                String temporal = "";
                temporal = rstSQLServer.getString(1);
                if(temporal==null)
                    temporal ="";
                clientes.add(temporal);
                temporal = rstSQLServer.getString(2);
                if(temporal==null)
                    temporal ="";
                clientes.add(temporal); 
                temporal = rstSQLServer.getString(3);
                if(temporal==null)
                    temporal ="";
                clientes.add(temporal);
                temporal = rstSQLServer.getString(4);
                if(temporal==null)
                    temporal ="";
                clientes.add(temporal);                
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
     * Metodo que actualiza como baja a un usuario con los datos que se le pasan
     * como parámetro.
     * @param clave_contrato : clave del contrato del cliente.
     * @param clave_cliente : clave del cliente.
     * @param usuario : nombre del usuario.
     * @return boolean seGuardo: Regresa true si se actualizo satisfactoriamente
     * la información en la base de datos, false en otro caso.
     */
    public static synchronized boolean BajaUsuario(String clave_contrato, String clave_cliente, String usuario) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean seGuardo = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            MySql = " update usuarios";
            MySql += " set status='B', ";
            MySql += " fecha_bloqueo=getDate() ";
            MySql += " where clave_contrato ='" + clave_contrato + "' ";
            MySql += " and clave_cliente='" + clave_cliente + "' ";
            MySql += " and usuario='" + usuario + "' ";

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
            seGuardo = false;
//            System.out.println(e.toString());
            e.printStackTrace();
            if (connection != null) {
                conn.Desconecta(connection);
            }
        }
        return seGuardo;
    }

    public static synchronized boolean actualizaDatos(String clave_cliente, String usuario, String usuarioNuevo, String password) {

        clsConexion conn = new clsConexion();
        Connection connection = null;
        Statement statement = null;
        boolean seGuardo = false;
        String MySql = "";
        try {
            connection = conn.ConectaSQLServer();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            if (!usuarioNuevo.equals("")) {
                MySql = " update usuarios";
                MySql += " set status = 'A' ,";
                MySql += " password = '" + password + "', ";
                MySql += " usuario = '" + usuarioNuevo + "' ";
                MySql += " where clave_cliente = '" + clave_cliente + "' ";
                MySql += " and usuario = '" + usuario + "' ";
            } else {
                MySql = " update usuarios";
                MySql += " set status = 'A' ,";
                MySql += " password = '" + password + "' ";
                MySql += " where clave_cliente = '" + clave_cliente + "' ";
                MySql += " and usuario = '" + usuario + "' ";
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

    public static String generaPassword() {
        String newPassword = "";
        try {
            int random = 0, val;
            String[] specialChar = {"B", "b", "#", "x", "W", "z", "X", "*", "Z", "w", "F", "f"};
            newPassword = (int) (Math.random() * 1000000000.0) + "";
            val = 12 - newPassword.length();
            for (int j = 0; j < val; j++) {
                random = (int) Math.floor(Math.random() * (12) + 0);
                newPassword = newPassword + specialChar[random];
            }
        } catch (Exception e) {
            newPassword = "";
        }
        return newPassword;
    }

    /**
     * Método que verifica si existe el directorio correspodiente al
     * que se especifica con los datos que se pasan como parámetro.
     * En caso de no existir lo crea.
     * @param clave_contrato : Clave de Fideicomiso
     * @param urlArchivo : Ruta del directorio.
     * @return boolean: si el directorio no existe lo crea y
     * regresa true, si ya esxiste regresa true y si ocurre
     * algún error regresa false.
     */
    public synchronized boolean existeDirectorio(String contrato, String urlArchivo) throws Exception {
        //Variable que almacena el archivo a trabajar.
        File archivo = null;
        //Permite abrir un archivo para leer caracteres.
        FileReader fr = null;
        //Permite manejar lineas completas a diferencia de FileReader.
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        //Varible que identifica si ocurrio algun error al realizar la transaccion.
        boolean existe = false;
        //Almacena una linea del archivo a leer.
        String linea = "";
        //Comando ms-dos a ejecutar.
        String comando = "cmd /c md \"" + urlArchivo + "\"";
//        System.out.println("comando:" + comando);
        try {
            /* Apertura del fichero y creacion de BufferedReader para poder
             * hacer una lectura comoda (disponer del metodo readLine()).
             */
            archivo = new File("./Common/Contratos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                if (linea.trim().equals(contrato.trim())) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec(comando);
//                    System.out.println(comando);
                    fw = new FileWriter("./Common/Contratos.txt", true);
                    pw = new PrintWriter(fw);
                    pw.println(contrato);
                    existe = true;
                } catch (IOException ioe) {
                    existe = false;
                    System.out.println("existeDirectorio:" + ioe.getMessage());
                }
            }
        } catch (Exception e) {
            existe = false;
            e.printStackTrace();
            System.out.println("existeDirectorio:" + e.getMessage());
        } finally {
            // Cerramos el fichero, nos asegurarnos que se cierra,
            // tanto si todo va bien como si surgio una excepción.
            try {
                if (null != fr) {
                    fr.close();
                }
                if (null != fw) {
                    fw.close();
                }
            } catch (Exception e2) {
                existe = false;
                e2.printStackTrace();
                try {
                    if (null != fw) {
                        fw.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    existe = false;
                }
            }
        }
        return existe;
    }

    /**
     * Regresa una cadena con código HTML con el formato del cuerpo del correo
     * informativo destinado al cliente para la notificación de la creación de su
     * cuenta en el sistema de liquidaciones.
     * @param clave_contrato: Clave del contrato.
     * @param nombre_fideicomitente : Nombre del Cliente.
     * @param nombre_usuario : Nombre Completo del usuario.
     * @param correo_usuario : Contacto del usuario.
     * @param telefono_usuario : Teléfono del usuario.
     * @param clave_cliente : Clave del cliente en el sistema.
     * @param usuario : Usuario del sistema.
     * @param contrasenna : Contraseña del usuario.
     * @return Cadena en HTML con el formato del correo.
     */
    public static String getBody(String clave_contrato, String clave_cliente, String nombre_fideicomitente,
            String nombre_usuario, String telefono_usuario, String usuario, String contrasenna, String correo_usuario) {
        String lstrBody = "";
        String lstrMensaje = "";

        lstrBody += "<html>";
        lstrBody += "<head> ";
        lstrBody += "<title>Documento sin t&iacute;tulo</title> ";
        lstrBody += "</head> ";

        lstrBody += "<body> ";
        lstrBody += "<table border=\"0\" width=\"80%\" style=\"font-size:12px;font-family:Arial;\"   > ";

        lstrMensaje = "Estimad@ Cliente: ";
        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">" + lstrMensaje + "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrMensaje = "Agradecemos su inscripción como usuario del Sistema de Liquidaciones. ";
        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">" + lstrMensaje + "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrMensaje = "La información registrada es la siguiente: ";
        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">" + lstrMensaje + "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">  ";
        lstrBody += "<ul> <li type=\"disc\"> Clave de Fideicomiso: " + clave_contrato + " </li> </ul> ";
        lstrBody += "</td> ";
        lstrBody += "<tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">  ";
        lstrBody += "<ul> <li type=\"disc\"> Nombre del Fideicomitente: " + nombre_fideicomitente + " </li> </ul> ";
        lstrBody += " </td> ";
        lstrBody += "<tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">  ";
        lstrBody += "<ul> <li type=\"disc\"> Nombre de Usuario: " + nombre_usuario + " </li> </ul> ";
        lstrBody += " </td> ";
        lstrBody += "<tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">  ";
        lstrBody += "<ul> <li type=\"disc\"> Correo Electrónico: " + correo_usuario + " </li> </ul> ";
        lstrBody += " </td> ";
        lstrBody += "<tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">  ";
        lstrBody += "<ul> <li type=\"disc\"> Teléfono de Contacto: " + telefono_usuario + " </li> </ul> ";
        lstrBody += " </td> ";
        lstrBody += "<tr> ";

        lstrMensaje = "Su Clave de Cliente, Usuario y Contraseña para acceder a nuestro sitio www.fideicomisogds.mx son las que se muestran a continuación: ";
        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">" + lstrMensaje + "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\"> ";
        lstrBody += "<table align=\"center\" style=\"border:#006699 1px solid;\"> ";
        lstrBody += "<tr> ";
        lstrBody += "<td align=\"right\"> <b>Clave de Cliente: </b></td> ";
        lstrBody += "<td align=\"left\"> <b>" + clave_cliente + "</b></td> ";
        lstrBody += "</tr> ";
        lstrBody += "<tr> ";
        lstrBody += "<td align=\"right\"> <b> Usuario: </b></td> ";
        lstrBody += "<td align=\"left\"> <b>" + usuario + " </b></td> ";
        lstrBody += "</tr> ";
        lstrBody += "<tr> ";
        lstrBody += "<td align=\"right\"> <b> Contraseña: </b></td> ";
        lstrBody += "<td align=\"left\"> <b> " + contrasenna + "</b></td> ";
        lstrBody += "</tr> ";
        lstrBody += "</table> ";
        lstrBody += "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrMensaje = "Como usuario del sistema de liquidaciones, usted tendrá acceso a servicios exclusivos en nuestro sitio, "
                + "por lo que esperamos poder atenderles con un servicio de calidad. ";
        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">" + lstrMensaje + "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrMensaje = "Para cualquier duda o aclaración, por favor envíenos un mensaje de correo a"
                + " soporte@fideicomisogds.mx donde con gusto lo atenderemos.";
        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">" + lstrMensaje + "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td style=\"font-size:10px;font-family:Arial;\"> Nota: Este mensaje responde a una solicitud automatizada"
                + " de la correcta activación de cuenta en el sistema de liquidaciones y es enviado desde una cuenta que es"
                + " exclusiva para enviar mensajes de salida, por lo que no es posible responder correos electrónicos si"
                + " usted usa la opción de responder.</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrMensaje = "Atentamente. ";
        lstrBody += "<tr> ";
        lstrBody += "<td colspan=\"5\">" + lstrMensaje + "</td> ";
        lstrBody += "</tr> ";

        lstrBody += "<tr> ";
        lstrBody += "<td >&nbsp;</td> ";
        lstrBody += "</tr> ";

        lstrBody += "</table> ";
        lstrBody += "</body> ";
        lstrBody += "</html> ";

        return lstrBody;
    }
}
