package AUX_componentes_MacarenaCuenca;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


/**
 *
 * @author macarena
 * 
 * Este ejemplo est� picado en c�digo, no se usa la vista Design.
 *
 */
public class EjemploJSlider extends JFrame implements ChangeListener {

    private JLabel etiqueta;
    private JSlider barra;

    public EjemploJSlider() {

        this.setTitle("Barra de deslizamiento");
        this.setSize(400, 100);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        etiqueta = new JLabel("Valor: 0");
        etiqueta.setHorizontalAlignment(JLabel.HORIZONTAL);

        //creamos el deslizador indicando la orientacin, valor min, max y valor inicial
        barra = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        //barra.setValue(50);   //podemos ajustar el deslizador en un valor concreto

        //configuramos la apariencia del deslizador
        barra.putClientProperty("JSlider.isFilled", Boolean.TRUE);
        barra.setPaintLabels(true);
        barra.setPaintTicks(true);
        barra.setPaintTrack(true);
        barra.setMajorTickSpacing(25);
        barra.setMinorTickSpacing(5);
        //barra.setSnapToTicks(true);

        //controlamos el cambio de posicion del deslizados
        barra.addChangeListener(this);

        //añadimos los controles a la ventana
        this.getContentPane().add(barra, BorderLayout.NORTH);
        this.getContentPane().add(etiqueta, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        EjemploJSlider ej = new EjemploJSlider();
    }

    public void stateChanged(ChangeEvent e) {
        //obtenemos el valor actual del deslizador y los mostramos en la etiqueta
        etiqueta.setText("Valor: " + ((JSlider) e.getSource()).getValue());

    }
}
