package AUX_componentes_MacarenaCuenca;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author macarena
 * 
 * Este ejemplo est� picado todo el c�digo, no se usa la vista Design.
 * Para que no de Excepci�n, hay que crear una carpeta 'imagenes' (relativa al proyecto) con las imagenes indicadas.
 */

public class EjemploEtiquetas extends JFrame {

    public EjemploEtiquetas() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();

        JLabel textoHTML = new JLabel("<html>"
                + "<font color='Red' size='7' face='Arial,Helvetica,"
                + "sans-serif'>Este es el texto</font>");
        JLabel grafica1 = new JLabel(new ImageIcon("imagenes/logo_java.jpg"));
        JLabel grafica2 = new JLabel(new ImageIcon("imagenes/logo_java.jpg"));
        panel.add(textoHTML);
        panel.add(grafica1);
        panel.add(grafica2);
        
        this.getContentPane().add(panel);
        this.setPreferredSize(new Dimension(300, 300));
        this.pack();        
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EjemploEtiquetas ej=new EjemploEtiquetas();
        ej.setVisible(true);
    }
}
