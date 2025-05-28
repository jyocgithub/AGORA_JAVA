
import java.util.Properties;
//para los siguiente import hay que descargarse el paquete JavaMail de Java:
//  http://www.oracle.com/technetwork/java/index-138643.html
//y agregar la biblioteca mail.jar
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * ****************************************************************************
 * programa para enviar correo desde una cuenta de gmail.com por el puerto 465
 * SMTP sobre el protocolo seguro SSL (tiene que ser seguro, porque ni Google
 * ni ningun otro proveedor dejan enviar hoy dia por el puerto 25)
 *
 * @author IMCG
 */

public class EnviarCorreoSSL {

    //cuenta de usuario en gmail.com
    private static final String cuentaUsuario = "ims.correo@gmail.com";
    //contraseña (puede ponerse sin miedo, ya que se enviara encriptada)
    private static final String password = "345345345";
    //direcci坦n de correo del destinatario
    private static final String mailDestinatario = "imartinsacristan@gmail.com";


    public void enviar(){

        //valora propiedades para construir la sesion con el servidor
        Properties props = new Properties();
        //servidor SMTP
        props.put("mail.smtp.host", "smtp.gmail.com");
        //puerto para el socket de sesion
        props.put("mail.smtp.socketFactory.port", "465");
        //tipo de socket
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //identificacion requerida
        props.put("mail.smtp.auth", "true");
        //puerto smtp
        props.put("mail.smtp.port", "465");

        //abre una nueva sesion contra el servidor basada en:
        //el usuario, la contraseña y las propiedades especificadas



        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(cuentaUsuario, password);
                    }
                });

        try {
            //compone el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(cuentaUsuario));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mailDestinatario));
            //asunto
            message.setSubject("Prueba de envio - Subject del correo");
            //cuerpo del mensaje
            message.setText("Mensaje de pruebas en el cuerpo del correo");
            //envia el mensaje, realizando conexion, transmision y desconexion
            Transport.send(message);
            //lo da por enviado
            System.out.println("Enviado...!!!!");
        } catch (MessagingException e) {
            //tramita la excepcion
            throw new RuntimeException(e);
        }
    }





}
