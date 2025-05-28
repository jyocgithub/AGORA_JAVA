package mail;

// necesita las librerias javax y  mail.jar


public class OtraFormaEnvio {

//    static String nombreFichero = "social-contract.txt";
//    static Scanner leer = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        String nfichero = "";
//        String email;
//        String password;
//
//        //cuenta de usuario en gmail.com
//        String cuentaUsuario = "javayotrascosas@gmail.com";
//        //contraseña (puede ponerse sin miedo, ya que se enviará encriptada)
//        String pswd = "ssssssssssssssssssssssssssss";
//        //dirección de correo del destinatario
//        String mailDestinatario = "ims.correo@gmail.com";
//
//        //valora propiedades para construir la sesión con el servidor
//        Properties props = new Properties();
//        //servidor SMTP
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        //puerto para el socket de sesión
//        props.put("mail.smtp.socketFactory.port", "465");
//        //tipo de socket
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        //identificación requerida
//        props.put("mail.smtp.auth", "true");
//        //puerto smtp
//        props.put("mail.smtp.port", "465");
//
//        Session session = Session.getDefaultInstance(props, new Authenticator() {
//
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(cuentaUsuario, pswd);
//            }
//        });
//
//        try {
//            //compone el mensaje
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(cuentaUsuario));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailDestinatario));
//            //asunto
//            message.setSubject("Asunto de mi mensaje");
//
//            // cuerpo
//            BodyPart adjunto = new MimeBodyPart();
//            adjunto.setDataHandler(new DataHandler(new FileDataSource("futbol.gif")));
//
//            BodyPart texto = new MimeBodyPart();
//            texto.setText("Texto del mensaje");
//
//            MimeMultipart multiParte = new MimeMultipart();
//            multiParte.addBodyPart(texto);
//            multiParte.addBodyPart(adjunto);
//
//            message.setContent(multiParte);
//
//            //envía el mensaje, realizando conexión, transmisión y desconexión
//            Transport.send(message);
//            //lo da por enviado
//            System.out.println("Enviado!");
//        } catch (MessagingException e) {
//            //tramita la excepción
//            throw new RuntimeException(e);
//        }

//    }

}
