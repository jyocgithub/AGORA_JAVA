package AUX_swing;
import javax.swing.*;
import java.awt.*;

public class ProbandoLayouts {

    public static void main(String[] args) {

       new JMiVentanaConBorderLayout();
       new JMiVentanaConGridLayout();
       new JMiVentanaConFlowLayout();

    }

    static class JMiVentanaConFlowLayout extends JFrame {

        // Constructor
        public JMiVentanaConFlowLayout () {

            // En este caso el titulo se añade con llamada a super()
            super ("Mi ventana con FLowLayout");
            this.setBounds(250, 250, 300, 200);
            this.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
            this.setLayout (new FlowLayout ());

            // Creo botones
            JButton miBoton1 = new JButton ("UNO");
            miBoton1.setPreferredSize (new Dimension (100, 40));
            JButton miBoton2 = new JButton ("DOS");
            miBoton2.setPreferredSize (new Dimension (100, 40));
            JButton miBoton3 = new JButton ("TRES");
            miBoton3.setPreferredSize (new Dimension (100, 40));
            JButton miBoton4 = new JButton ("CUATRO");
            miBoton4.setPreferredSize (new Dimension (100, 40));
            JButton miBoton5 = new JButton ("CINCO");
            miBoton5.setPreferredSize (new Dimension (100, 40));

            // Añadimos elementos
            this.getContentPane ().add (miBoton1);
            this.getContentPane ().add (miBoton2);
            this.getContentPane ().add (miBoton3);
            this.getContentPane ().add (miBoton4);
            this.getContentPane ().add (miBoton5);

            // Hacemos visible la ventana.
            // No hace falta hacer visibles sus elementos
            this.setVisible (true);
        }
    }

    static class JMiVentanaConGridLayout extends JFrame {
        // Constructor
        public JMiVentanaConGridLayout() {
            // En este caso el titulo se añade con llamada a super()
            super ("Mi ventana con GRIDLayout");
            this.setBounds(250, 250, 700, 400);
            this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            this.setLayout (new GridLayout (42,53));

            // Creo botones
            JButton miBoton1 = new JButton ("UNO");
            miBoton1.setPreferredSize (new Dimension (100, 40));
            JButton miBoton2 = new JButton ("DOS");
            miBoton2.setPreferredSize (new Dimension (100, 40));
            JButton miBoton3 = new JButton ("TRES");
            miBoton3.setPreferredSize (new Dimension (100, 40));
            JButton miBoton4 = new JButton ("CUATRO");
            miBoton4.setPreferredSize (new Dimension (100, 40));
            JButton miBoton5 = new JButton ("CINCO");
            miBoton5.setPreferredSize (new Dimension (100, 40));

            // Añadimos elementos
            this.getContentPane ().add (miBoton1);
            this.getContentPane ().add (miBoton2);
            this.getContentPane ().add (miBoton3);
            this.getContentPane ().add (miBoton4);
            this.getContentPane ().add (miBoton5);

            // Hacemos visible la ventana.
            // No hace falta hacer visibles sus elementos
            this.setVisible (true);
        }
    }

    static class JMiVentanaConBorderLayout extends JFrame {
        // Constructor
        public JMiVentanaConBorderLayout () {
            super ("Mi ventana con GRIDLayout");
            // la propia ventana
            this.setBounds(250, 250, 300, 200);
            this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

            // Creo botones
            JButton miBoton1 = new JButton ("UNO");
            miBoton1.setPreferredSize (new Dimension(100, 40));
            JButton miBoton2 = new JButton ("DOS");
            miBoton2.setPreferredSize (new Dimension (100, 40));
            JButton miBoton3 = new JButton ("TRES");
            miBoton3.setPreferredSize (new Dimension (100, 40));
            JButton miBoton4 = new JButton ("CUATRO");
            miBoton4.setPreferredSize (new Dimension (100, 40));
            JButton miBoton5 = new JButton ("CINCO");
            miBoton5.setPreferredSize (new Dimension (100, 40));

            // Añadimos elementos
            this.getContentPane ().add (miBoton1);
            this.getContentPane ().add (miBoton2);
            this.getContentPane ().add (miBoton3);
            this.getContentPane ().add (miBoton4);
            this.getContentPane ().add (miBoton5);

            // colocamos los elementos
            this.setLayout (new BorderLayout ());
            this.getContentPane ().add (miBoton1, BorderLayout.PAGE_START);
            this.getContentPane ().add (miBoton2, BorderLayout.LINE_START);
            this.getContentPane ().add (miBoton3, BorderLayout.CENTER);
            this.getContentPane ().add (miBoton4, BorderLayout.LINE_END);
            this.getContentPane ().add (miBoton5, BorderLayout.PAGE_END);

            // Hacemos visible la ventana.
            // No hace falta hacer visibles sus elementos
            this.setVisible (true);
        }

    }

}
