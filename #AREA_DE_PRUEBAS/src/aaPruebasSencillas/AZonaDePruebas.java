package aaPruebasSencillas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


class Mamifero{

}

class Oveja extends Mamifero{

}

public class AZonaDePruebas {


    public static void main(String[] args) {












        
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				MiVentana miventana = new MiVentana();
//			}
//		});

    }

    public static void leerWeb() {
        // String sal = "http://www.google.com/search?q=jaja";
        // String res = readStringFromURL(sal);
        // System.out.println(res);

        //
        // String content = null;
        // URLConnection connection = null;
        // try {
        // connection = new URL("https://es.wikipedia.org/wiki/Zara").openConnection();
        //// connection = new
        // URL("http://www.google.com/search?q=jaja").openConnection();
        // connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE
        // 6.0; Windows NT 5.0)");
        // Scanner scanner = new Scanner(connection.getInputStream());
        // scanner.useDelimiter("\\Z");
        // scanner.useDelimiter("\\A");
        //
        // content = scanner.hasNext() ? scanner.next() : "";
        // scanner.close();
        // } catch (Exception ex) {
        // ex.printStackTrace();
        // }
        // System.out.println(content);
        // if (content.contains("Aprox")) {
        // System.out.println("120");
        // }

        // URL url = new URL("https://www.google.com/search?q=jaja");
        // url.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0;
        // Windows NT 5.0)");
        // try (BufferedReader br = new BufferedReader(new
        // InputStreamReader(url.openStream()))) {
        //
        // String line;
        //
        // StringBuilder sb = new StringBuilder();
        //
        // while ((line = br.readLine()) != null) {
        //
        // sb.append(line);
        // sb.append(System.lineSeparator());
        // }
        //
        // System.out.println(sb);
        // }

        // URLConnection connection = new
        // URL("https://www.google.com/search?q=jaja").openConnection();
        //
        //
        // connection.addRequestProperty("User-Agent",
        // "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(connection.getInputStream(), "UTF-8"));
        // StringBuilder stringBuilder = new StringBuilder();
        //
        //
        // String linea, solucion;
        // while ((linea = bufferedReader.readLine()) != null) {
        // stringBuilder.append(linea);
        // if (linea.contains("Aproximada")) {
        // int i = linea.indexOf("Aproximadamente");
        // // esta la palabra "aproximadamente"
        // linea = linea.substring(i);
        // String[] palabras = linea.split(" ");
        // solucion = palabras[1];
        // }
        // }
        // //return stringBuilder.toString();
        // bufferedReader.close();

    }

    public static int diferenciaEnMinutosEntreDates(Date fechaMayor, Date fechaMenor) {
        if (fechaMayor == null || fechaMenor == null || fechaMayor.getTime() < fechaMenor.getTime()) {
            return -1;
        }
        long diferenciaEnMilisegs = fechaMayor.getTime() - fechaMenor.getTime();
        long minutos = diferenciaEnMilisegs / (1000 * 60);
        return (int) minutos;
    }

}

class MiVentana extends JFrame {

    JPanel jp_principal;
    JLabel lb_nombre, lb_password;
    JTextField tf_nombre, tf_password;
    JButton bt_aceptar;

    public MiVentana() {

        // la propia ventana
        this.setBounds(250, 250, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Solicitud de password");

        // labels
        lb_password = new JLabel("Password");
        lb_password.setBounds(50, 30, 100, 30);
        this.getContentPane().add(lb_password);

        // textfields
        tf_password = new JTextField();
        tf_password.setBounds(120, 30, 100, 30);
        this.getContentPane().add(tf_password);

        // button
        bt_aceptar = new JButton("Aceptar");
        bt_aceptar.setBounds(120, 90, 100, 30);
        this.getContentPane().add(bt_aceptar);

        bt_aceptar.addActionListener(new EscuchadorBoton1());

        // finalmente, como ultimo acto, se hace visible la ventana
        this.setVisible(true);
    }

//    public void crearEscuchadores() {
//
//        bt_aceptar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String nombre = tf_nombre.getText();
//                String password = tf_password.getText();
//                if (nombre.equals("pepe") && password.equals("123")) {
//                    JOptionPane.showMessageDialog(null,
//                            "Acceso concedido",
//                            "Aviso",
//                            JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(null,
//                            "Datos erróneos !! ",
//                            "Aviso",
//                            JOptionPane.ERROR_MESSAGE);
//                }
//
//            }
//        });
//    }
}

class EscuchadorBoton1 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ev) {
        // AQUI VIENE EL CÓDIGO A EJECUTAR CUANDO SE PINCHE EN EL BOTON
        JOptionPane.showMessageDialog(null, "Ha pulsado un boton !", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
    }
}

