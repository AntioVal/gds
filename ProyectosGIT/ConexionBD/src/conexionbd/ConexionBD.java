/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Cell;
import modelo.Contrato;
import modelo.Movimiento;
import modelo.MovsMesResum;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Luis-Valerio
 */
public class ConexionBD {

    /**
     * @param args the command line arguments
     */
    static Map<String, Integer> mapa = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            System.out.print("Por favor ingrese el número de la opción deseada:\n");
            System.out.print("1. Verificar que los rfc de los contratos almacenados cumpla el estandar del SAT.\n");
            System.out.print("2. Verificar que los campos departamento y pueso de los movimientos cumplan "
                    + "el formato que el SAT solicita.\n");
            System.out.print("3. Corregir los rfc de los contratos almacenados quitandoles los caracteres(' ','-').\n");
            System.out.print("4. Corregir los campos departamento y puesto de los movimientos con fecha_liquidación desde Enero de 2017.\n");
            System.out.print("5. Escribe los RFC de los movimientos encontrados en un archivo .txt para validar en el portal del SAT.\n");
            System.out.print("6. Valida CURP.\n");
            System.out.print("7. Valida CLABE.\n");
            System.out.print("8. Obetener movimientos del mes indicado y comparar con archivo de excel que tiene el reporte de movimientos correctos.\n");
            System.out.print("q. Presiona la tecla 'q' para salir ...\n");
            String input = System.console().readLine();

            if ("q".equals(input)) {
                System.out.println("¡Hasta pronto!");
                System.exit(0);
            } else {
                try {
                    Integer opcion = new Integer(input);
                    switch (opcion) {
                        case 1: {
                            //Veririfacion de RFC de contratos
                            List<Contrato> contratos = getContratos();
                            for (Contrato contrato : contratos) {
                                if (!validaRFC(contrato.getRfc())) {
                                    System.out.println("-->>>>>");
                                    System.out.println("(RFC)La cadena no pasa la validación del SAT:" + contrato.getRfc());
                                    System.out.println("Contrato:" + contrato.getClaveContrato());
                                    System.out.println("--<<<<<");
                                }
                            }
                            break;
                        }
                        case 2: {
                            //Verificacion de los campos departamento y puesto de todos los movimientos
                            List<Movimiento> movs = getMovs2017();
                            for (int i = 0; i < movs.size(); i++) {
                                verificaPtoDept(movs.get(i));
                            }
                            break;
                        }
                        case 3: {
                            //corrige RFC de todos los contratos(), quita espacios y guines medios
                            List<Contrato> contratos = getContratos();
                            for (int i = 0; i < contratos.size(); i++) {
                                if (!corrigeRFContrato(contratos.get(i))) {
                                    System.out.println("Error cambiando RFC de contrato ...");
                                }
                            }
                            break;
                        }
                        case 4: {
                            //corrige puesto y departamento de movimientos encontrados
                            List<Movimiento> movs = getMovs2017();
                            for (int i = 0; i < movs.size(); i++) {
                                if (!corrigeDeptoPuestoMov(movs.get(i))) {
                                    System.out.println("Error cambiando puesto o departamento de movimiento ...");
                                }
                                System.out.println("Movimiento " + i + " de " + movs.size() + " modificado.");
                            }
                            break;
                        }
                        case 5: {
                            //Crea archivo con los RFC de los movimientos indicados
                            List<Movimiento> movs = getMovs2017();
                            Writer writer = null;
                            try {
                                Double num_archivos = Double.parseDouble("" + movs.size());
                                num_archivos = Math.ceil(num_archivos / 5000);
                                System.out.println("# archivos:" + num_archivos);
                                System.out.println("Para " + movs.size() + " movimientos.");
                                for (int j = 0; j < num_archivos; j++) {
                                    writer = new OutputStreamWriter(new FileOutputStream("C:\\gp\\source\\rfc_movimientos_" + j + ".txt"), "UTF-8");
                                    int countFile = 1;
                                    for (int i = (j * 5000); i <= ((j + 1) * 5000) - 1; i++) {
                                        if (i >= movs.size()) {
                                            System.out.println("Saliendo de archivo.." + j);
                                            break;
                                        }
//                                        String n = movs.get(i).getNombreEmpleado() + " " + movs.get(i).getApellidoPEmpleado() + " " + movs.get(i).getApellidoMEmpleado();
//                                        writer.write(movs.get(i).getClaveContrato() + "|" + n + "|" + movs.get(i).getRfc() + "\r\n");
                                        writer.write(countFile + "|" + movs.get(i).getRfc() + "\r\n");
                                        countFile++;
                                    }
                                    System.out.println("Archivo generado ...");
                                    writer.close();

                                }
                            } catch (Exception e) {
                                System.out.println("Exception escribir RFC de movmientos:" + e.getMessage());
                            }
                            break;
                        }
                        case 6: {
                            System.out.println("Escribe la CURP a validar:");
                            String curp = System.console().readLine();
                            if (validaCURPCodes(curp)) {
                                System.out.println("La CURP:[" + curp + "] es válida.");
                            } else {
                                System.out.println("La CURP:[" + curp + "] es INCORRECTA.");
                            }
                            break;
                        }
                        case 7: {
                            System.out.println("Escribe la CLABE a validar:");
                            String clabe = System.console().readLine();
                            if (validaCLABE(clabe)) {
                                System.out.println("La CLABE:[" + clabe + "] es válida.");
                            } else {
                                System.out.println("La CLABE:[" + clabe + "] es INCORRECTA.");
                            }
                            break;
                        }
                        case 8: {
                            Map<String, Integer> rfcCorrectos = leerErroresCODES();
                            System.out.println("Se encontraron " + rfcCorrectos.size() + " movimientos procesados correctamente por CODES.");
                            for (String rfc : rfcCorrectos.keySet()) {
                                if(rfcCorrectos.get(rfc) > 1){
                                    System.out.println("El RFC " + rfc + " tiene " + rfcCorrectos.get(rfc) + " movimientos.");
                                }
                            }
                            Calendar c = Calendar.getInstance();
                            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                            System.out.println("Escribe la fecha del mes a ser analizado:");
                            String fecha = System.console().readLine();
                            Date date = formatoFecha.parse(fecha);
                            c.setTime(date);
                            //seteamos a la instancia de Calendar la fecha del ultimo dia de mes
                            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
                            Date ultimoDiaMes = c.getTime();
                            //seteamos al Calendar el primer dia del mes
                            c.set(Calendar.DAY_OF_MONTH, 1);
                            Date primerDiaMes = c.getTime();
                            List<MovsMesResum> movimientosMensuales = obtenGrupoMovsPorRFC(primerDiaMes, ultimoDiaMes);
                            System.out.println("Movimientos que deben de ser procesados:" + movimientosMensuales.size());
                            for (MovsMesResum mov : movimientosMensuales) {
                                if (!rfcCorrectos.containsKey(mov.getRfc())) {
                                    System.out.println(mov.getRfc());
                                }
                            }
//                            System.out.println("Movimientos encontrados:" + movimientosMensuales.size());
                            break;
                        }
                        default:
                            System.out.println("La opción que seleccionaste es incorrecta, por favor intenta otra vez.");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("La opción que seleccionaste es incorrecta, por favor intenta otra vez.");
                }
            }
        }
//        for (String clabe : mapa.keySet()) {
//            System.out.println("CURP:" + clabe);
//        }
    }

    static public List<Contrato> getContratos() {
        List<Contrato> contratos = new ArrayList<>();
        Conexion c = new Conexion();
        Connection conn = c.conectar();
        PreparedStatement declaracion = null;
        ResultSet rstSQLServer = null;
        String sql = "select * from contratos";
        try {
            declaracion = conn.prepareStatement(sql);
            rstSQLServer = declaracion.executeQuery();
            while (rstSQLServer.next()) {
                Contrato contrato = new Contrato();
                contrato.setClaveContrato(rstSQLServer.getString("clave_contrato"));
                contrato.setRfc(rstSQLServer.getString("rfc"));
                contratos.add(contrato);
            }
            rstSQLServer.close();
            declaracion.close();

            c.desconectar(rstSQLServer, declaracion, conn);
        } catch (Exception e) {
            System.out.println("Exception-validaUsuario" + e.getMessage());
        }
        return contratos;
    }

    static public List<Movimiento> getMovs2017() {
        List<Movimiento> movs = new ArrayList<>();
        Conexion c = new Conexion();
        Connection conn = c.conectar();
        PreparedStatement declaracion = null;
        ResultSet rstSQLServer = null;
        String sql = "select * from movimientos where fecha_liquidacion>='2017-04-01' order by clave_contrato";
        try {
            declaracion = conn.prepareStatement(sql);
            rstSQLServer = declaracion.executeQuery();
            while (rstSQLServer.next()) {
                Movimiento m = new Movimiento();
                m.setClaveContrato(rstSQLServer.getString("clave_contrato"));
                m.setCurp(rstSQLServer.getString("curp"));
                m.setRfc(rstSQLServer.getString("rfc"));
                m.setNombreArchivo(rstSQLServer.getString("nombre_archivo"));
                m.setPuestoEmpleado(rstSQLServer.getString("puesto_empleado"));
                m.setDeptoEmpleado(rstSQLServer.getString("depto_empleado"));
                m.setNombreEmpleado(rstSQLServer.getString("nombre_empleado"));
                m.setApellidoPEmpleado(rstSQLServer.getString("apellidoP_empleado"));
                m.setApellidoMEmpleado(rstSQLServer.getString("apellidoM_empleado"));
                movs.add(m);
            }
            rstSQLServer.close();
            declaracion.close();

            c.desconectar(rstSQLServer, declaracion, conn);
        } catch (Exception e) {
            System.out.println("Exception-validaUsuario" + e.getMessage());
        }
        return movs;
    }

    static public void verificaPtoDept(Movimiento m) {
        if (!validaCadenaSinNumerosSAT(m.getDeptoEmpleado())) {
            mapa.put(m.getCurp(), 0);
            System.out.println("-->>>>>>>>>");
            System.out.println("(DEPTO)La cadena no pasa la validación del SAT:" + m.getDeptoEmpleado());
            System.out.println("Contrato:" + m.getClaveContrato());
            System.out.println("CURP:" + m.getCurp());
            System.out.println("Archivo:" + m.getNombreArchivo());
            System.out.println("--<<<<<<<<<<");
        }
        if (!validaCadenaSinNumerosSAT(m.getPuestoEmpleado())) {
            mapa.put(m.getCurp(), 0);
            System.out.println("-->>>>>>>>>");
            System.out.println("(PUESTO)La cadena no pasa la validación del SAT:" + m.getPuestoEmpleado());
            System.out.println("Contrato:" + m.getClaveContrato());
            System.out.println("CURP:" + m.getCurp());
            System.out.println("Archivo:" + m.getNombreArchivo());
            System.out.println("--<<<<<<<<<<");
        }
    }

    public static List<MovsMesResum> obtenGrupoMovsPorRFC(Date primerDiaMes, Date ultimoDiaMes) {
        Connection connection;
        PreparedStatement statement;
        List<MovsMesResum> movimientos = new ArrayList<>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Conexion c = new Conexion();
            Connection conn = c.conectar();
            ResultSet rstSQLServer;
            String query = "   select lote.clave_contrato, rfc, sum(CAST(importe_liquidacion as float)) as importe_pagado"
                    //                    + " ,sum(CAST(importe_liquidacion_mxp as float)) as importe_pagado_mxp  "
                    + " from movimientos, movimientos_h as lote "
                    + " where movimientos.nombre_archivo = lote.nombre_archivo "
                    + " and lote.status ='T' "
                    + " and movimientos.rfc !='' "
                    + " and lote.fecha_usuario_autoriza IS NOT NULL "
                    + " and lote.fecha_usuario_autoriza>='" + formatoFecha.format(primerDiaMes) + " 00:00:00.000' "
                    + " and lote.fecha_usuario_autoriza<='" + formatoFecha.format(ultimoDiaMes) + " 23:59:59.999' "
                    + " group by rfc, lote.clave_contrato order by lote.clave_contrato;";
            statement = conn.prepareStatement(query);
            rstSQLServer = statement.executeQuery();
            while (rstSQLServer.next()) {
                MovsMesResum infoMov = new MovsMesResum();
                String rfc = rstSQLServer.getString("rfc");
                if (rfc != null && !rfc.isEmpty()) {
                    infoMov.setRfc(rfc);
                    infoMov.setContrato(rstSQLServer.getString("clave_contrato"));
//                    infoMov.setImporte(rstSQLServer.getDouble("importe_pagado"));
//                    infoMov.setImporte_mxp(rstSQLServer.getDouble("importe_pagado_mxp"));
                    movimientos.add(infoMov);
                }
            }
            c.desconectar(rstSQLServer, statement, conn);
//            time_end = System.currentTimeMillis();
        } catch (SQLException ex) {
            movimientos = null;
            System.out.println("Exception:ObtenInfoBD:obtenGrupoMovsPorRFC()" + ex.getMessage());
        }
        return movimientos;
    }

    static public Map<String, Integer> leerErroresCODES() throws FileNotFoundException, IOException {
        Map<String, Integer> listaRFC = new HashMap();
        FileInputStream file = new FileInputStream(new File("C:\\gp\\erroresCODES.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            HSSFCell celda = sheet.getRow(i).getCell(5, Row.CREATE_NULL_AS_BLANK);
            String valorCelda = celda.getStringCellValue();
            if (!valorCelda.isEmpty()) {
                if (listaRFC.containsKey(valorCelda)) {
                    listaRFC.put(valorCelda, listaRFC.get(valorCelda) + 1);
                } else {
                    listaRFC.put(valorCelda, 1);
                }
            }
//            Cell celda = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
//            String algo = celda.getStringCellValue();
        }

        workbook.close();
        return listaRFC;
    }

    static public boolean corrigeDeptoPuestoMov(Movimiento m) {
        boolean hay_cambios = false;
        Conexion c = new Conexion();
        Connection conn = c.conectar();
        PreparedStatement declaracion = null;
        ResultSet rstSQLServer = null;
        String tempPuesto, tempDepto;
        try {
            //"[\\.\\s\\w()#/\\*#$%&\\[\\]:;\\-áéíóúÁÉÍÓÚ]{2,}";
            String puesto = m.getPuestoEmpleado();
            tempPuesto = puesto.replaceAll("[\\.()#\\*$\\[\\]/]", " ");
            String depto = m.getDeptoEmpleado();
            tempDepto = depto.replaceAll("[\\.()#\\*$\\[\\]/]", " ");
            if (!tempDepto.equals(depto)) {
                hay_cambios = true;
//                System.out.println("Depto:" + m.getDeptoEmpleado() + " -> " + tempDepto);
            }
            if (!tempPuesto.equals(puesto)) {
                hay_cambios = true;
//                System.out.println("Puesto:" + m.getPuestoEmpleado() + " -> " + tempPuesto);
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            return false;
        }
        if (hay_cambios) {
            m.setDeptoEmpleado(tempDepto);
            m.setPuestoEmpleado(tempPuesto);
            String sql = "update movimientos "
                    + "set depto_empleado='" + m.getDeptoEmpleado() + "'"
                    + ",puesto_empleado='" + m.getPuestoEmpleado() + "' "
                    + "where clave_contrato='" + m.getClaveContrato() + "' "
                    + "and nombre_archivo='" + m.getNombreArchivo() + "' "
                    + "and curp='" + m.getCurp() + "' ";
            try {
                declaracion = conn.prepareStatement(sql);
                declaracion.executeUpdate();
                c.desconectar(rstSQLServer, declaracion, conn);
            } catch (Exception e) {
                System.out.println("Exception-corrigeDeptoPuestoMov" + e.getMessage());
                return false;
            }
        }
        return true;
    }

    static public boolean corrigeRFContrato(Contrato contrat) {
        boolean hay_cambios = false;
        Conexion c = new Conexion();
        Connection conn = c.conectar();
        PreparedStatement declaracion = null;
        ResultSet rstSQLServer = null;
        String tempRFC;
        try {
            String rfc = contrat.getRfc();
            tempRFC = rfc.replaceAll("[ -]", "");
            if (!tempRFC.equals(rfc)) {
                hay_cambios = true;
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            return false;
        }
        if (hay_cambios) {
            contrat.setRfc(tempRFC);
            String sql = "update contratos "
                    + " set RFC='" + contrat.getRfc() + "'"
                    + " where clave_contrato='" + contrat.getClaveContrato() + "' ";
            try {
                declaracion = conn.prepareStatement(sql);
                declaracion.executeUpdate();
                c.desconectar(rstSQLServer, declaracion, conn);
            } catch (Exception e) {
                System.out.println("Exception-corrigeDeptoPuestoMov" + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static boolean validaCadenaSinNumerosSAT(String campo) {
        boolean valido = false;
        try {
            campo = campo.trim();
            if (!campo.isEmpty()) {
                //valida que no sea un numero decimal
                try {
                    Float.parseFloat(campo);
                } catch (NumberFormatException nfe) {
                    //Quiere decir que no es un numero, por lo tanto es correcto
                    valido = true;
                }
                String patron;
                Pattern p;
                Matcher m;
                if (valido) {
                    valido = false;
                    //expresion regular para verificar que la cadena solo tenga (letras,-,_,.,(,),#)
                    patron = "([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'|´|-|:|;|<|=|>|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,100}";
                    p = Pattern.compile(patron);
                    m = p.matcher(campo);
                    if (m.matches()) {
                        if (campo.equals(m.group())) {
                            valido = true;
                        }
                    }
                }
                //expresion regular para verificar que no sea alguna de las palabaras
                //NA,NINGUN?,solo numeros                
                if (valido) {
                    patron = "(NA|N/A|N-A|N+A|N.A|^NINGUN(.?)|\\d*)";
                    p = Pattern.compile(patron);
                    m = p.matcher(campo);
                    if (m.matches()) {
                        if (campo.equals(m.group())) {
                            valido = false;
                        }
                    }
                }

            } else {
                valido = false;
            }
        } catch (Exception exc) {
            System.out.println("Exception:ModeloLayOut-validaCURP:" + exc.getMessage());
            valido = false;
        }

        return valido;
    }

    public static boolean validaRFC(String campo) {
        boolean valido = false;
        try {
            if (!campo.isEmpty()) {
                campo = campo.trim();
                campo = campo.toUpperCase();
                //verificamos si se trata de una persona fisica
                //expresion regular para verificacion de RFC-persona fisica
                String patron = "[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]{3}";
                Pattern p = Pattern.compile(patron);
                Matcher m = p.matcher(campo);
                if (m.matches()) {
                    if (campo.equals(m.group())) {
                        valido = true;
                    }
                }
                if (!valido) {
                    System.out.println("No pasa la validación de RFC válido:" + campo);
                }
            } else {
                System.out.println("Error:El campo está vacio.");
            }
        } catch (Exception exc) {
            System.out.println("Exception:ModeloLayOut-validaRFC:" + exc.getMessage());
            valido = false;
        }

        return valido;
    }

    public static boolean validaCURPCodes(String campo) {
        boolean valido = false;
        try {
            if (!campo.isEmpty()) {
                campo = campo.trim();
                campo = campo.toUpperCase();
                //verificamos si se trata de una persona fisica
                //expresion regular para verificacion de RFC-persona fisica
                String patron = "[A-Z][AEIOUX][A-Z]{2}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[MH]"
                        + "([ABCMTZ]S|[BCJMOT]C|[CNPST]L|[GNQ]T|[GQS]R|C[MH]|[MY]N|[DH]G|NE|VZ|DF|SP)"
                        + "[BCDFGHJ-NP-TV-Z]{3}[0-9A-Z][0-9]";
                Pattern p = Pattern.compile(patron);
                Matcher m = p.matcher(campo);
                if (m.matches()) {
                    if (campo.equals(m.group())) {
                        valido = true;
                    }
                }
                if (!valido) {
                    System.out.println("No pasa la validación de CURPCodes válido:" + campo);
                }
            } else {
                System.out.println("Error:El campo está vacio.");
            }
        } catch (Exception exc) {
            System.out.println("Exception:ModeloLayOut-validaCURPCodes:" + exc.getMessage());
            valido = false;
        }

        return valido;
    }

    public static boolean validaCLABE(String campo) {
        boolean valido = false;
        try {
            if (!campo.isEmpty()) {
                campo = campo.trim();
                campo = campo.toUpperCase();
                //verificamos si se trata de una persona fisica
                //expresion regular para verificacion de RFC-persona fisica
                String patron = "[0-9]{18}";
                Pattern p = Pattern.compile(patron);
                Matcher m = p.matcher(campo);
                if (m.matches()) {
                    if (campo.equals(m.group())) {
                        valido = true;
                    }
                }
                if (valido) {
                    Integer sumatoria = 0;
                    for (int pos = 0; pos < 18; pos += 3) {
                        Integer p1 = new Integer(campo.charAt(pos) + "");
                        Integer r1 = (p1 * 3);
                        sumatoria += r1 % 10;
                        Integer p2 = new Integer(campo.charAt(pos + 1) + "");
                        Integer r2 = (p2 * 7);
                        sumatoria += r2 % 10;
                        if (pos != 15) {
                            Integer p3 = new Integer(campo.charAt(pos + 2) + "");
                            Integer r3 = (p3 * 1);
                            sumatoria += r3 % 10;
                        }
                    }
                    sumatoria = sumatoria % 10;
                    sumatoria = 10 - sumatoria;
                    sumatoria = sumatoria % 10;
                    System.out.println("Número verificaro=" + sumatoria);
                    return (new Integer(campo.charAt(17) + "").equals(sumatoria));
                } else {
                    System.out.println("La CLABE debe de ser de 18 caracteres y sólo pueden ser números.");
                }
            } else {
                System.out.println("Error:El campo está vacio.");
            }
        } catch (Exception exc) {
            System.out.println("Exception:ModeloLayOut-validaCURPCodes:" + exc.getMessage());
            valido = false;
        }

        return valido;
    }

}
