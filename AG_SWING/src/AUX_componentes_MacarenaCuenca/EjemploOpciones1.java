package AUX_componentes_MacarenaCuenca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author macarena
 * 
 * Este ejemplo est� picado en c�digo, no se usa la vista Design.
 *
 */

public class EjemploOpciones1 extends JFrame implements ItemListener {

    private JCheckBox trabaja;
    private JCheckBox estudia;
    private JLabel msg;
    //variables que controlan que opcion/es se han marcado
    private boolean estudiar = false;
    private boolean trabajar = false;

    public EjemploOpciones1() {
        this.setTitle("Opciones");
        this.setSize(250, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("?A que te dedicas?"));
        trabaja = new JCheckBox("Trabajo");
        estudia = new JCheckBox("Estudio");
        msg = new JLabel();

        trabaja.addItemListener(this);
        estudia.addItemListener(this);

        panel.add(estudia);
        panel.add(trabaja);
        this.getContentPane().add(panel);
        this.getContentPane().add(msg);

        this.setVisible(true);

    }

    public void centrarVentana() {

        this.setResizable(false);	//fijamos el marco de la ventana, ya no podra ser ampliada
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
    }

    public static void main(String[] args) {
        EjemploOpciones1 ej = new EjemploOpciones1();
    }

    public void itemStateChanged(ItemEvent arg0) {

        if (arg0.getItemSelectable() == trabaja) { //si ha provocado el evento la casilla "Trabajo"
            //miramos si se ha seleccionado
            if (arg0.getStateChange() == ItemEvent.SELECTED) {
                trabajar = true;
            } else {
                trabajar = false;
            }
        } else { //ha provocado el evento la casilla "Estudio"
            if (arg0.getStateChange() == ItemEvent.SELECTED) {
                estudiar = true;
            } else {
                estudiar = false;
            }
        }

        if (estudiar && trabajar) {
            msg.setText("Tu ocupacion es estudiar y trabajar");
        } else if (estudiar && !trabajar) {
            msg.setText("Tu ocupacion es estudiar");
        } else if (!estudiar && trabajar) {
            msg.setText("Tu ocupacion es trabajar");
        } else {
            msg.setText("Eres un vago!!");
        }

    }
}
