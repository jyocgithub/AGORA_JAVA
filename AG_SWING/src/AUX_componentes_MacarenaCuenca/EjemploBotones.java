package AUX_componentes_MacarenaCuenca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author macarena
 * 
 * Este ejemplo est� picado en c�digo, no se usa la vista Design.
 * Para que no de Excepci�n, hay que crear una carpeta 'Recursos' (relativa al proyecto) con las imagenes indicadas.
 * Estas im�genes son de un bot�n con distintos aspectos.
 */

public class EjemploBotones  extends JFrame implements ActionListener {

    private JButton botonSalir;
    private JButton botonAceptar;
    private JButton botonCancelar;

    public EjemploBotones() {        
        crearBotones();    
        
        this.setTitle("Ejemplo botones");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(300, 200));
        this.pack();
        this.setLocationRelativeTo(null);            
    }

    private void crearBotones(){
        botonSalir = new JButton(new ImageIcon("Recursos/boton_salir.jpg"));
        botonAceptar = new JButton(new ImageIcon("Recursos/boton_aceptar_normal.gif"));
        //icono a mostrar cuando se arrima el raton al boton
        botonAceptar.setRolloverIcon(new ImageIcon("Recursos/boton_aceptar_selected.gif"));
        //icono a mostrar cuando se hace clic sobre el boton
        botonAceptar.setPressedIcon(new ImageIcon("Recursos/boton_aceptar_pressed.gif"));
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setMnemonic('C');

        botonSalir.setActionCommand("Salir");
        botonAceptar.setActionCommand("Aceptar");
        botonCancelar.setActionCommand("Cancelar");

        botonSalir.addActionListener(this);
        botonAceptar.addActionListener(this);
        botonCancelar.addActionListener(this);

        this.getContentPane().add(botonSalir);
        this.getContentPane().add(botonAceptar);
        this.getContentPane().add(botonCancelar);
    }
    
    public static void main(String[] args) {
        EjemploBotones ej = new EjemploBotones();
        ej.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Salir")) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Deseas realmente salir?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Aceptar")) {
            mostrarMsg("Has pulsado el boton Aceptar");
        } else {
            mostrarMsg("Has pulsado el boton Cancelar");
        }
    }

    private void mostrarMsg(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
}
