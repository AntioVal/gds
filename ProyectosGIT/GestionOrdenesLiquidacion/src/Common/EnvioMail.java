/*
 *    Creado por:                   Hernández Paredes Denis Alin
 *    Fecha:                        28/07/2011
 *    Descripción:                  Controlador : "EnvioMail.java" Clase para el enviar correo electrónico.
 *    Responsable:                  Carlos Altamirano
 */
package Common;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.BodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;

public class EnvioMail {

    /**
     * Método que envia correo electrónico con los datos que se le pasan como
     * parámetro.
     *
     * @param correoOrigen : Correo emisor.
     * @param correoDestino : Correos destino.
     * @param asunto : Asunto del correo electrónico.
     * @param texto : Mensaje del Correo.
     * @param urlArchivo : URL del archivo a Adjuntar.
     * @param nombreAdjunto : Nombre del Archivo Adjunto.
     * @return boolean: True si la transacción se realizó satisfactoriamente ese
     * en otro caso.
     */
    public static boolean enviaCorreo(String correoOrigen, String correoDestino, String asunto, String texto, String urlArchivo, String nombreAdjunto) {

        boolean envio = false;
        Transport t = null;
        Properties props = null;
        String[] scorreoDestino = null;

        try {
            props = new Properties();
            // Nombre del host de correo.
            props.put("mail.smtp.host", "mail.abugaber.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            // Puerto para envio de correos.
            props.setProperty("mail.smtp.port", "587");
            // Nombre del usuario que envia el correo.
            props.setProperty("mail.smtp.user", correoOrigen);
            // Si requiere o no usuario y password para conectarse.
            props.setProperty("mail.smtp.auth", "true");
            // Preparamos la sesion
            Session session = Session.getInstance(props);
            // Obtenemos mas información del proceso en pantalla.
            //session.setDebug(true);

            //Obtenemos las direcciones electronicas de los receptores.
            if (correoDestino.indexOf(",") != 1) {
                scorreoDestino = correoDestino.split(",");
            } else {
                scorreoDestino = new String[1];
                scorreoDestino[0] = correoDestino;
            }
            //Generamos un inetAdress para cada dirección electrónica obtenida.
            InternetAddress address[] = new InternetAddress[scorreoDestino.length];
            for (int i = 0; i < scorreoDestino.length; i++) {
                address[i] = new InternetAddress(scorreoDestino[i]);
            }
            // Construimos el mensaje a enviar.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoOrigen));
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(asunto);
            message.setText(texto);

            //Procedemos a Adjuntar un archivo en el mensaje.
            //Definimos el texto del mensaje.
            BodyPart xtexto = new MimeBodyPart();
            // Texto del mensaje
            xtexto.setText(texto);
            // Cargamos el archivo al mensaje.
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(urlArchivo + nombreAdjunto)));
            //Asignamos el nombre original del archivo.
            adjunto.setFileName(nombreAdjunto);
            //Unimos texto y mensaje en una sola parte.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(xtexto);
            multiParte.addBodyPart(adjunto);

            //Añadimos al mensaje.
            message.setContent(multiParte);

            // Finalmente enviamos el mensaje.
            t = session.getTransport("smtp");
            //Autentificamos usuario y password del emisor.
//            t.connect(correoOrigen, "liquidaciones");
            t.connect(correoOrigen, "Liqui16*");
            t.sendMessage(message, message.getAllRecipients());

            // Cerramos las conexiones.
            if (t != null) {
                t.close();
            }
            envio = true;
        } catch (Exception e) {
            envio = false;
//            System.out.println("enviaCorreo:" + e.getMessage());
            // Cerramos las conexiones.
            try {
                if (t != null) {
                    t.close();
                }
            } catch (Exception ex) {
//                System.out.println("enviaCorreo:" + ex.getMessage());
            }
        }
        return envio;
    }

    /**
     * Método que envia correo electrónico con los datos que se le pasan como
     * parámetro.
     *
     * @param correoOrigen : Correo emisor.
     * @param correoDestino : Correos destino.
     * @param asunto : Asunto del correo electrónico.
     * @param texto : Mensaje del Correo.
     * @return boolean: True si la transacción se realizó satisfactoriamente ese
     * en otro caso.
     */
    public static boolean enviaCorreo(String correoOrigen, String correoDestino, String asunto, String texto) {

        boolean envio = false;
        Transport t = null;
        Properties props = null;

        try {
            props = new Properties();
            // Nombre del host de correo.
            props.put("mail.smtp.host", "mail.abugaber.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            // Puerto para envio de correos.
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", correoOrigen);
            // Si requiere o no usuario y password para conectarse.
            props.setProperty("mail.smtp.auth", "true");
            // Preparamos la sesion
            Session session = Session.getInstance(props);

            InternetAddress address[] = new InternetAddress[1];
            address[0] = new InternetAddress(correoDestino);

            // Construimos el mensaje a enviar.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoOrigen));
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(asunto);
            message.setText(texto, "ISO-8859-1", "html");

            // Enviamos el mensaje.
            t = session.getTransport("smtp");
            //Autentificamos usuario y password del emisor.
            t.connect(correoOrigen, "Liqui16*");
            t.sendMessage(message, message.getAllRecipients());

            // Cerramos las conexiones.
            if (t != null) {
                t.close();
            }
            envio = true;
        } catch (Exception e) {
            envio = false;
//            System.out.println("enviaSoloCorreo:" + e.getMessage());
            // Cerramos las conexiones.
            try {
                if (t != null) {
                    t.close();
                }
            } catch (Exception ex) {
//                System.out.println("enviaSoloCorreo:" + ex.getMessage());
            }
        }
        return envio;
    }
}
