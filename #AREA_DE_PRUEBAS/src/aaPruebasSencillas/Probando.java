package aaPruebasSencillas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


class Interfaz_Grafica {

    String usuarioActual = "";
    JFrame ventana;
    JTextArea cajaTexto;
    JLabel peticion;
    JTextField dato;
    JButton boton;

    public Interfaz_Grafica(String usuarioActual) {
        super();
        this.usuarioActual = usuarioActual;
        ventana = new JFrame(usuarioActual);
        crearVentana();
    }

    public void crearVentana() {
        ventana.setLayout(null);
        ventana.setBounds(0, 0, 600, 400);
        ventana.setBackground(Color.cyan);
        ventana.setLocationRelativeTo(null); // pone la ventana centrada en la panrtalla

        JPanel pane = new JPanel();
        pane.setBounds(0, 0, 600, 420);
        pane.setLayout(null);
        ventana.add(pane);

        cajaTexto = new JTextArea();
        JScrollPane marco = new JScrollPane(cajaTexto);
        marco.setBounds(10, 10, 580, 280);
        cajaTexto.setBounds(0, 0, 470, 370);
        pane.add(marco);

        peticion = new JLabel("Introduzca la informacion necesaria:");
        peticion.setBounds(15, 290, 400, 40);
        pane.add(peticion);

        dato = new JTextField();
        dato.setBounds(10, 320, 370, 40);
        pane.add(dato);

        boton = new JButton("Aceptar");
        boton.setBounds(380, 320, 80, 40);
        pane.add(boton);

        ventana.setVisible(true);
    }

    //Sustituye al sysout.
    public void escribirEnVentana(String mensaje) {
        String loquehabia = cajaTexto.getText();
        cajaTexto.setText(loquehabia + "\n" + mensaje);
    }

    //Sustituye al Scaner de numero al mensaje y al nextInt
    public int pedirNumero(String mensaje) {
        String respuesta = JOptionPane.showInputDialog(null, mensaje, "Petición", JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(respuesta);
    }

    //Sustituye al Scaner de numero al mensaje y al nextLine
    public String pedirTexto(String mensaje) {
        String respuesta = JOptionPane.showInputDialog(null, mensaje, "Petición", JOptionPane.QUESTION_MESSAGE);
        return respuesta;
    }
}

class GR_00_MI_INTERFAZ_GRAFICA {

    String usuarioActual = "";
    JFrame ventana;
    JTextArea cajaTexto;
    JLabel peticion;
    JTextField dato;
    JButton boton;

    public GR_00_MI_INTERFAZ_GRAFICA(String usuarioActual) {
        super();
        this.usuarioActual = usuarioActual;
        ventana = new JFrame(usuarioActual);
        crearVentana();
    }

    public void crearVentana() {
        ventana.setLayout(null);
        ventana.setBounds(0, 0, 600, 400);
        ventana.setBackground(Color.cyan);
        ventana.setLocationRelativeTo(null); // pone la ventana centrada en la panrtalla

        JPanel pane = new JPanel();
        pane.setBounds(0, 0, 600, 420);
        pane.setLayout(null);
        ventana.add(pane);

        cajaTexto = new JTextArea();
        JScrollPane marco = new JScrollPane(cajaTexto);
        marco.setBounds(10, 10, 580, 280);
        cajaTexto.setBounds(0, 0, 470, 370);
        pane.add(marco);

        peticion = new JLabel("Introduzca la informacion necesaria:");
        peticion.setBounds(15, 290, 400, 40);
        pane.add(peticion);

        dato = new JTextField();
        dato.setBounds(10, 320, 370, 40);
        pane.add(dato);

        boton = new JButton("Aceptar");
        boton.setBounds(380, 320, 80, 40);
        pane.add(boton);

        JButton salir = new JButton("Cerrar");
        salir.setBounds(510, 320, 80, 40);
        pane.add(salir);


        boton.setVisible(false);
        dato.setVisible(false);
        peticion.setVisible(false);


        ventana.setVisible(true);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
            }
        });




    }

    //Sustituye al sysout.
    public void escribirEnVentana(String mensaje) {
        String loquehabia = cajaTexto.getText();
        cajaTexto.setText(loquehabia + "\n" + mensaje);
    }

    //Sustituye al Scaner de numero al mensaje y al nextInt
    public int pedirNumero(String mensaje) {

        boton.setVisible(true);
        dato.setVisible(true);
        peticion.setVisible(true);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.dispose();
            }
        });


        boton.setVisible(true);
        dato.setVisible(true);
        peticion.setVisible(true);
//
        String respuesta = JOptionPane.showInputDialog(null, mensaje, "Petición", JOptionPane.QUESTION_MESSAGE);
        return Integer.parseInt(respuesta);

    }

    //Sustituye al Scaner de numero al mensaje y al nextLine
    public String pedirTexto(String mensaje) {
        String respuesta = JOptionPane.showInputDialog(null, mensaje, "Petición", JOptionPane.QUESTION_MESSAGE);
        return respuesta;
    }
}


public class Probando {


    public static void main(String[] args) throws IOException {

        GR_00_MI_INTERFAZ_GRAFICA c = new GR_00_MI_INTERFAZ_GRAFICA("pepe");

    }
    public static int listaContainsParteDe(List<String> lista, String textoBuscado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).contains(textoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public static int listaContainsParteDeMejorada(List<String> lista, String textoBuscado) {
        if (lista == null || textoBuscado == null) {
            return -1;
        }
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).contains(textoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public static String leeficheroMal(String nombrefich) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(nombrefich));
        String texto = "";
        String linea = br.readLine();
        while (linea != null) {
            texto = texto + linea;
            br.readLine();
        }
        return texto;
    }

    public static String leeficheroBien(String nombrefich) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(nombrefich));
        StringBuffer texto = new StringBuffer();
        String linea = br.readLine();
        while (linea != null) {
            texto.append(linea);
            br.readLine();
        }
        return texto.toString();
    }


    final static class Boli {
        String marca;

        public Boli(String marca) {
            this.marca = marca;
        }
    }


    class Figura {
        protected int coorx, coory;

        public Figura(int coorx, int coory) {
            setCoorx(coorx);
            setCoory(coory);
        }

        public void setCoorx(int coorx) {
            if (coorx >= 0 && coorx <= 100) {
                this.coorx = coorx;
            }
        }

        public void setCoory(int coory) {
            if (coory >= 0 && coory <= 100) {
                this.coory = coory;
            }
        }

        public int getCoory() {
            return coory;
        }

        public int getCoorx() {
            return coorx;
        }

    }

}
