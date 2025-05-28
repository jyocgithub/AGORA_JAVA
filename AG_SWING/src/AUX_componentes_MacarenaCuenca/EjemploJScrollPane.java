package AUX_componentes_MacarenaCuenca;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author macarena
 * 
 * Este ejemplo est� picado en c�digo, no se usa la vista Design.
 *
 */
public class EjemploJScrollPane extends JFrame {

    private JTextArea area;
    private JScrollPane barra;

    public EjemploJScrollPane() {

        this.setTitle("Barra de desplazamiento");
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //colocamos una barra de desplazamiento vertical al area de texto
        area = new JTextArea();
        //indicamos que la barra es para el area de texto, e indicamos
        //cuando mostrar las barras vertical y horizonta.
        barra = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //añadimos la barra a la ventana (este ya contiene al area de texto)
        this.getContentPane().add(barra, BorderLayout.CENTER);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        EjemploJScrollPane ej = new EjemploJScrollPane();
    }
}
