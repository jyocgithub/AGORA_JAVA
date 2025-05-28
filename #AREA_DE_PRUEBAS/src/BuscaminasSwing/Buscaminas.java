package BuscaminasSwing;

/*
 * Buscaminas.java

 *
 * Created on 18 de junio de 2003, 19:20
 */

//package pri.AWT.Ejercicios1.Buscaminas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class Buscaminas {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new FileReader("Pruebas.txt"));
        while (br.ready()){
            System.out.println(br.readLine());
        }






//        Frame f = new Frame();
//        PanelBuscaminas panel = new PanelBuscaminas();
//        f.add(panel);
//        f.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent we) {
//                System.exit(0);
//            }
//        });
//        f.setSize(900, 540);
//        f.show();
    }
}

class PanelBuscaminas extends Panel {
    Casilla tablero[][];
    boolean minas[][];
    int maxMinas;

    PanelBuscaminas() {
        int f, c;
        setLayout(new GridLayout(30, 50));
        tablero = new Casilla[30][50];
        minas = new boolean[30][50];
        maxMinas = 250;
        // creamos los botones y vaciamos la matriz donde
        // colocaremos las minas
        for (f = 0; f < 30; f++)
            for (c = 0; c < 50; c++) {
                minas[f][c] = false;
                tablero[f][c] = new Casilla("");
                add(tablero[f][c]);
                tablero[f][c].addActionListener(new AccionBoton(this, f, c));
            }

        // colocamos minas
        for (int n = 0; n < maxMinas; n++) {
            do {
                f = (int) (Math.random() * 30);
                c = (int) (Math.random() * 50);
            } while (minas[f][c]);
            minas[f][c] = true;
        }
    }
}

class Casilla extends Button {
    boolean descubierta;

    Casilla(String t) {
        super.setLabel(t);
        setBackground(new Color(200, 200, 200));
        setFont(new Font("Comic Sans Ms", Font.BOLD, 20));
        descubierta = false;
    }
}

class AccionBoton implements ActionListener {
    PanelBuscaminas pb;
    int f, c;

    AccionBoton(PanelBuscaminas p, int ff, int cc) {
        pb = p;
        f = ff;
        c = cc;
    }

    public void actionPerformed(ActionEvent ae) {
        if (!pb.tablero[f][c].descubierta) {
            pb.tablero[f][c].descubierta = true;
            pb.tablero[f][c].setBackground(new Color(170, 255, 255));
            if (pb.minas[f][c]) {
                pb.tablero[f][c].setLabel("*");
                for (int x = 0; x < 30; x++)
                    for (int y = 0; y < 50; y++)
                        if (pb.minas[x][y]) {
                            pb.tablero[x][y].setBackground(new Color(255, 50, 100));
                            pb.tablero[x][y].setLabel("*");
                        }
                JOptionPane.showMessageDialog(pb.getParent(), "Lo siento, has perdido");
                System.exit(0);
            } else {
                int numMinas = CuentaMinas(f, c);
                switch (numMinas) {
                    case 0:
                        AutoDescubrir(f, c);
                        break;
                    default:
                        pb.tablero[f][c].setLabel(Integer.toString(numMinas));
                }
                ;
            }
            int nd = numDescubiertas();
            ((Frame) pb.getParent()).setTitle("Quedan " + Integer.toString(1500 - nd) + " casillas");
            if (1500 - nd == pb.maxMinas) {
                JOptionPane.showMessageDialog(pb.getParent(), "Muy bien, ya has terminado");
                System.exit(0);
            }
        }
    }

    int CuentaMinas(int ff, int cc) {
        int nm = 0;
        for (int x = ff - 1; x <= ff + 1; x++)
            for (int y = cc - 1; y <= cc + 1; y++)
                if (!(x == ff && y == cc) &&
                        x >= 0 && x < 30 &&
                        y >= 0 && y < 50)
                    if (pb.minas[x][y])
                        nm++;
        return nm;
    }

    void AutoDescubrir(int ff, int cc) {
        pb.tablero[ff][cc].setBackground(new Color(170, 255, 255));
        pb.tablero[ff][cc].descubierta = true;
        for (int x = ff - 1; x <= ff + 1; x++)
            for (int y = cc - 1; y <= cc + 1; y++) {
                if (x >= 0 && x < 30 && y >= 0 && y < 50 &&
                        !(x == ff && y == cc) &&
                        !pb.tablero[x][y].descubierta) {
                    int numMinas = CuentaMinas(x, y);
                    switch (numMinas) {
                        case 0:
                            AutoDescubrir(x, y);
                            break;
                        default:
                            pb.tablero[x][y].descubierta = true;
                            pb.tablero[x][y].setBackground(new Color(170, 255, 255));
                            pb.tablero[x][y].setLabel(Integer.toString(numMinas));
                    }
                    ;
                }
            }
    }

    int numDescubiertas() {
        int nd = 0;
        for (int x = 0; x < 30; x++)
            for (int y = 0; y < 50; y++)
                if (pb.tablero[x][y].descubierta)
                    nd++;
        return nd;
    }
}
