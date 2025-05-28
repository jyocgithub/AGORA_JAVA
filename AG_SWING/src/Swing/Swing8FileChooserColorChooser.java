package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Swing8FileChooserColorChooser {
    public static void main(String[] args) {
        JMiVentanaConChoosers miVentana = new JMiVentanaConChoosers("Mi Ventana", 300, 300, 300, 300);
    }
}

class JMiVentanaConChoosers extends JFrame {
    // Constructor
    @SuppressWarnings("unchecked")
    public JMiVentanaConChoosers(String titulo, int x, int y, int ancho, int alto) {
        super(titulo);
        this.setBounds(x, y, ancho, alto);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());


        JButton btCambiar = new JButton("Elegir Fichero");
        btCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selectorFicheros = new JFileChooser();
                selectorFicheros.setFileSelectionMode(JFileChooser.FILES_ONLY);
                selectorFicheros.setCurrentDirectory(new File("/Users/inaki/Downloads/"));

                int seleccion = selectorFicheros.showOpenDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    String nombreDelFicheroSolo = selectorFicheros.getSelectedFile().getName();
                    String nombreDelFicheroConPath = selectorFicheros.getSelectedFile().getAbsolutePath();
                    System.out.println(nombreDelFicheroConPath);

                    File f = selectorFicheros.getSelectedFile();
                    System.out.println(f.getName());

                }


                Color color = JColorChooser.showDialog(null, "Elige un color", Color.BLACK);
                if(color != null) {
                    System.out.println(color.toString());   // por mostrar el nombre del objeto color...
                }
            }
        });

        this.getContentPane().add(btCambiar);

        // Hacemos visible la ventana. No hace falta hacer visibles sus elementos
        this.setVisible(true);

    }
}