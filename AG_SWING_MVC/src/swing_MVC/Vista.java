package swing_MVC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    JPanel jp_principal;
    JLabel lb_nombre, lb_password;
    JTextField tf_nombre;
    JPasswordField tf_password;
    JButton bt_aceptar;
    Controlador controlador;

    public Vista(Controlador controlador) {
        this.controlador = controlador;

        crearComponentes();
        crearEscuchadores();

        // finalmente, como ultimo acto, se hace visible la ventana
        this.setVisible(true);
    }

    public void crearComponentes() {
        this.setBounds(250, 250, 600, 600);    // la propia ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Ejercicio SWING");

        jp_principal = new JPanel();           // panel de fondo
        jp_principal.setBounds(10, 10, 600, 600);
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


        crearTabla();


    }

    public void crearTabla() {

        // CREAR ARRAY DE CABECERAS
        String[] cabeceras = controlador.crearCabeceraTabla();
        String[][] mat = controlador.crearDatosTabla();

        // CREAR TABLEMODEL Y JTABLE
        DefaultTableModel modelo = new DefaultTableModel(mat, cabeceras);
        JTable tablaPersonas = new JTable(modelo);

        // CONFIGURAMOS SOLORES Y LINEAS
        tablaPersonas.setShowGrid(true);    // hace que se muestren lineas entre celdas
        tablaPersonas.setGridColor(Color.BLACK);  // pone color a las lineas
        tablaPersonas.getTableHeader().setOpaque(false);     // cabecera opaca
        tablaPersonas.getTableHeader().setBackground(Color.LIGHT_GRAY); // color de cabecera
        tablaPersonas.setRowHeight(30);


        // CREAMOS EL JSCROLLPANE QUE ENCIERRE LA TABLA
        // SIN EL, PUEDE QUE NO SE MUESTREN LAS CABECERAS
        JScrollPane scrollPane = new JScrollPane(tablaPersonas);
        scrollPane.setBounds(200, 200, 300, 80);  // es el jscrollpane quien toma tamaño y posicion

        // AÑADIMOS EL JSCFROLLPANE AL JPANEL PRINCIPAL
        jp_principal.add(scrollPane);


        // PARA SABER QUE FILA ESTA SELECCIONADA......
        int seleccionado = tablaPersonas.getSelectedRow();

    }

    public void crearEscuchadores() {
        bt_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = tf_nombre.getText();
                String password = tf_password.getText();
                Empleado emp = new Empleado(nombre, password);
                if (controlador.accesocorrecto(emp)) {
                    JOptionPane.showMessageDialog(null,
                            "Acceso concedido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Datos erróneos !! ", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Controlador controlador = new Controlador();
                Vista miventana = new Vista(controlador);
            }
        });
    }


}


