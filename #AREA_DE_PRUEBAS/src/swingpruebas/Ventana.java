package swingpruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana miventana = new Ventana();
            }
        });
    }



    JPanel jp_principal;
    JLabel lb_nombre, lb_password;
    JTextField tf_nombre;
    JPasswordField tf_password;
    JButton bt_aceptar;

    public Ventana() {
        crearComponentes();
        crearEscuchadores();
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
                            "Acceso concedido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Datos erróneos !! ", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}



