import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiVentanaSwing extends JFrame {

    JPanel jpanel_principal;
    JLabel lb_nombre, lb_password;
    JTextField tf_nombre, tf_password;
    JButton bt_aceptar;

    public MiVentanaSwing() throws SQLException {

        this.setBounds(250, 250, 300, 150);    // la propia ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Solicitud de usuario y password");

        jpanel_principal = new JPanel();           // panel de fondo
        jpanel_principal.setBounds(0, 0, 300, 150);
        jpanel_principal.setLayout(null);
        this.getContentPane().add(jpanel_principal);

        lb_nombre = new JLabel("Nombre");      // Jlabel
        lb_nombre.setBounds(50, 10, 100, 30);
        lb_nombre.setForeground(Color.BLUE);
        jpanel_principal.add(lb_nombre);

        lb_password = new JLabel("Password");
        lb_password.setBounds(50, 50, 100, 30);
        lb_nombre.setForeground(Color.BLUE);
        jpanel_principal.add(lb_password);

        tf_nombre = new JTextField();
        tf_nombre.setBounds(120, 10, 100, 30);
        jpanel_principal.add(tf_nombre);


        tf_password = new JPasswordField();
        tf_password.setBounds(120, 50, 100, 30);
        jpanel_principal.add(tf_password);
        String texto = tf_password.getText();    // consultar su contenido
        tf_password.setText("Nuevo contenido");  // cambiar el contenido


        bt_aceptar = new JButton("Aceptar");   // button
        bt_aceptar.setBounds(120, 90, 100, 30);

        jpanel_principal.add(bt_aceptar);


        JCheckBox check = new JCheckBox();
        check.setBounds(120, 50, 100, 30);
        jpanel_principal.add(check);
        check.setText("Nuevo contenido");     // cambiar el contenido
//        boolean esta = check.isSelected();    // consultar si esta marcado


        ButtonGroup grupo = new ButtonGroup();              // constructor del grupo
        JRadioButton boton1 = new JRadioButton("Comunitario");      // constructor un boton
        JRadioButton boton2 = new JRadioButton("NO Comunitario");      // constructor otro boton
        grupo.add(boton1);  // añadimos el boton al grupo
        grupo.add(boton2);   // añadimos el boton al grupo
        boolean esta = boton2.isSelected();    // consultar si esta marcado


        // Connection.getConnection(String urlconexion)
// Connection.getConnection(String urlconexion, String usuario, String password)

        // conexion normal con MYSQL
        String urlconexionDB = "jdbc:mysql://localhost:3306/";
        String nombreBD      = "agenda";
        String usuarioDB     = "root";
        String passwordDB    = "";
        String opcionesBD    = "";
        Connection miConexion = DriverManager.getConnection(urlconexionDB+nombreBD+opcionesBD,usuarioDB,passwordDB);
        // algo mas directo, pero mucho menos comprensible
//        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
//
//        // OTRAS CONFIGURACIONES PARA OTRAS BBDD
//        String urlconexionDB = "jdbc:odbc:";             // DRIVER JavaDataBase ODBC
//        String urlconexionDB = "jdbc:oracle:thin:@miservidor:1521:";  // DRIVER JavaDataBase ORACLE
//        String urlconexionDB = "jdbc:sqlite:";             // DRIVER JavaDataBase ODBC
//
//        // OTRAS CONFIGURACIONES PARA OTRAS BBDD
//        String opcionalesBD  = "?autoReconnect=true&useSSL=false";  // si hay problemas por SSL desactivado
//        // si hay problemas de tipo  "The server time zone value 'xxx' is unrecognized ...
//        String opcionalesBD  = "?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
//        String opcionalesBD  = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//

    }

}
