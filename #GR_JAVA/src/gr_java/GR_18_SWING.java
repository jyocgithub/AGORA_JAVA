package gr_java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GR_18_SWING {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MiVentana miventana = new MiVentana();
            }
        });
    }
}



class MiVentana extends JFrame {
    JPanel jp_principal;
    JLabel lb_nombre, lb_password;
    JTextField tf_nombre;
    JPasswordField tf_password;
    JButton bt_aceptar;

    public MiVentana() {
        crearComponentes();
        crearEscuchadores();
        // finalmente, como ultimo acto, se hace visible la ventana
        this.setVisible(true);
    }

    public void crearComponentes() {
        this.setBounds(250, 250, 300, 150);    // la propia ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Solicitud de usuario y password");
        
        jp_principal = new JPanel();           // panel de fondo
        jp_principal.setBounds(0, 0, 300, 150);
        jp_principal.setLayout(null);
        this.getContentPane().add(jp_principal);

        lb_nombre = new JLabel("Nombre");      // labels
        lb_nombre.setBounds(50, 10, 100, 30);
        lb_nombre.setForeground(Color.BLUE);
        jp_principal.add(lb_nombre);

        lb_password = new JLabel("Password");
        lb_password.setBounds(50, 50, 100, 30);
        lb_nombre.setForeground(Color.BLUE);
        jp_principal.add(lb_password);

        tf_nombre = new JTextField();         // textfields y passwordfields
        tf_nombre.setBounds(120, 10, 100, 30);
        jp_principal.add(tf_nombre);
        tf_password = new JPasswordField();
        tf_password.setBounds(120, 50, 100, 30);
        jp_principal.add(tf_password);

        bt_aceptar = new JButton("Aceptar");   // button
        bt_aceptar.setBounds(120, 90, 100, 30);
        jp_principal.add(bt_aceptar);
   }

   public void crearEscuchadores() {
        bt_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = tf_nombre.getText();
                String password = tf_password.getText();
                if (nombre.equals("pepe") && password.equals("123")) {
                    JOptionPane.showMessageDialog(null,
                                "Acceso concedido" ,"Aviso",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,  
                                "Datos erróneos !! ","Aviso",   JOptionPane.ERROR_MESSAGE);
                }
           }
        });
    }


    public void JOptionPane_showMessageDialog(){
        JOptionPane.showMessageDialog( null,
                "Datos guardados correctamente",
                "Aviso",
                JOptionPane.WARNING_MESSAGE  );
    }


    public void JOptionPane_showInputDialog(){

        // 1 .- Version donde se pide un simple texto
        String respuesta = JOptionPane.showInputDialog( null,
                "Indique su contraseña",
                "Confirmación",
                JOptionPane.INFORMATION_MESSAGE);

        // 2 .- También se puede mostrar un desplegable para elegir uno de sus valores
        String[] opciones = {"MANZANA", "PERA", "SANDIA"};
        String elegido  = (String) JOptionPane.showInputDialog(  null,
                "TITULO",
                "ELIGE UNA FRUTA",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);
    }


    public void JOptionPane_showConfirmDialog(){
        int respuesta = JOptionPane.showConfirmDialog( null,
                "¿Continuar?",
                "Aviso",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE  );

        if (respuesta== JOptionPane.YES_OPTION){
            // hacer lo que se quiera cuando el usuario contesta SI
        }else{
            // hacer lo que se quiera cuando el usuario contesta SI
        }
    }


    public void JOptionPane_showOptionDialog(){
        String[] colores = {"Rojo", "Verde", "Azul", "Rosa"};

        int respuesta = JOptionPane.showOptionDialog( null,
                "Elija un color",
                "Elegir color",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                colores,
                colores[0]
        );

        if (respuesta == -1) {
            System.out.println("No se eligió ningún color");
        } else {
            System.out.println("Se eligió el color " + colores[respuesta]);
        }
    }

    public void JFileChooser(){
        JFileChooser selectorFicheros = new JFileChooser();
        selectorFicheros.setFileSelectionMode(JFileChooser.FILES_ONLY); // asi no elige los directorios
        selectorFicheros.setCurrentDirectory(new File("/Users/PacoPorras/"));

        int seleccion = selectorFicheros.showOpenDialog(null);
//        JFileChooser.CANCEL_OPTION                        Si el usuario le ha dado al botón cancelar.
//        JFileChooser.APPROVE_OPTION                     Si el usuario le ha dado al botón aceptar
//        JFileCHooser.ERROR_OPTION                         Si ha ocurrido algún error.
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String nombreDelFicheroSolo = selectorFicheros.getSelectedFile().getName();
            String nombreDelFicheroConPath = selectorFicheros.getSelectedFile().getAbsolutePath();
            System.out.println(nombreDelFicheroConPath);
        }
    }
    public void JColorChooser(){
        Color color = JColorChooser.showDialog(null, "Elige un color", Color.BLACK);
        if(color != null) {
            System.out.println(color.toString());
        }
    }




}