package aaPruebasSencillas;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * ,
 *
 * @author alvar
 */
public class VentanaPru extends JFrame implements ActionListener {

    JPanel panellogin;
    JButton botonIngresar;
    JTextField textoContraseña;
    JTextField nombreUsuario;
    JButton botonCancelar;

    public VentanaPru() {

        inicializarVentana();

        inicializarPanelLogin();

    }

    public void inicializarVentana() {

        setBounds(0, 0, 600, 400);  // x, y , ancho alto
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.yellow);

        this.setVisible(true);
    }

    public void inicializarPanelLogin() {

        panellogin = new JPanel();
        panellogin.setBounds(0, 0, 600, 400);
        panellogin.setBackground(Color.yellow);
        panellogin.setLayout(null);
        this.add(panellogin);

        JLabel labelusuario = new JLabel("Usuario:");
        labelusuario.setBounds(100, 50, 80, 40);
        panellogin.add(labelusuario);

        JLabel labelcontraseña = new JLabel("Contraseña:");
        labelcontraseña.setBounds(100, 100, 80, 40);
        panellogin.add(labelcontraseña);

        nombreUsuario = new JTextField();
        nombreUsuario.setBounds(300, 50, 200, 40);
        panellogin.add(nombreUsuario);

        textoContraseña = new JTextField();
        textoContraseña.setBounds(300, 100, 200, 40);
        panellogin.add(textoContraseña);

        botonIngresar = new JButton("Ingresar");
        botonIngresar.setBounds(200, 200, 150, 40);
        panellogin.add(botonIngresar);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(200, 250, 150, 40);
        panellogin.add(botonCancelar);

        panellogin.setVisible(true);

        // escuchadores
        botonIngresar.addActionListener(this);
        botonCancelar.addActionListener(this);

    }

    public void abrirPanelPrincipal() {

//        panellogin = new JPanel();
//        panellogin.setBounds(0, 0, 600, 400);
//        panellogin.setBackground(Color.yellow);
//        panellogin.setLayout(null);
//        this.add(panellogin);
//
//        JLabel labelusuario = new JLabel("Usuario:");
//        labelusuario.setBounds(100, 50, 80, 40);
//        panellogin.add(labelusuario);
//
//        JLabel labelcontraseña = new JLabel("Contraseña:");
//        labelcontraseña.setBounds(100, 100, 80, 40);
//        panellogin.add(labelcontraseña);
//
//        nombreUsuario = new JTextField();
//        nombreUsuario.setBounds(300, 50, 200, 40);
//        panellogin.add(nombreUsuario);
//
//        textoContraseña = new JTextField();
//        textoContraseña.setBounds(300, 100, 200, 40);
//        panellogin.add(textoContraseña);
//
//        botonIngresar = new JButton("Ingresar");
//        botonIngresar.setBounds(200, 200, 150, 40);
//        panellogin.add(botonIngresar);
//
//        JButton botonCancelar = new JButton("Cancelar");
//        botonCancelar.setBounds(200, 250, 150, 40);
//        panellogin.add(botonCancelar);
//
//        panellogin.setVisible(true);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 600, 400);

    }

    public static void main(String[] args) {
        VentanaPru j = new VentanaPru();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonIngresar) {
            String nombreusado = nombreUsuario.getText();
            String contrasenausada = textoContraseña.getText();
            if (nombreusado.equals("pepe") && contrasenausada.equals("123")) {

                abrirPanelPrincipal();

            } else {
                JOptionPane.showMessageDialog(null, "No has acertado, repite majete", "ERROR EL LOGIN", JOptionPane.ERROR_MESSAGE);

            }

        }
        if (e.getSource() == botonCancelar) {
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Quieres salir de verdad?" , "CUIDAD; SE CIERRA", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if(respuesta == JOptionPane.YES_OPTION){
                // cerrar la ventana y adios
                this.dispose();
            }

        }
    }

}
