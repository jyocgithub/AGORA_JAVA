package cristian_laboratorio4_cuadrodedecolores;


import javax.swing.*;
import java.awt.*;
// Pintor es un hilo que hace que el botón cambie de color siguiendo la secuencia:
// 1. Se pinta de negro durante un tiempo aleatorio que varía entre un mínimo de 0 y un máximo de 0.2 segundos.
// 2. Obtiene el primer color que le corresponde y pinta con ese color
// 3. Espera entre 0 y 0.05 segundos
// 4. Toma el segundo color, lo mezcla con el primero y pinta con la mezcla
// 5. Espera entre 0 y 0.1 seg. y vuelve a empezar el ciclo.

public class Pintor extends Thread {

     private JButton b;
     private Paleta p;
     private int numPintor;
     private Color negro = Color.black;

     public Pintor(JButton b, Paleta p, int numPintor) {
          this.b = b;
          this.p = p;
          this.numPintor = numPintor;
     }

     public void run() {
          while (true) {
               b.setBackground(negro); //Pinta el botón de negro
               try {
                    sleep((int) (200 * Math.random())); //Espera entre 0 y 0.2 seg.
               } catch (InterruptedException e) {
               }
               if (numPintor == 1) {
                    Color uno = p.tomaColor(numPintor + 1); //Toma de la paleta el primercolor
                    b.setBackground(uno); //y pinta el botón
                    try {
                         sleep((int) (50 * Math.random())); //Espera entre 0 y 0.05 seg.
                    } catch (InterruptedException e) {
                    }
                    Color dos = p.tomaColor(numPintor); //Toma de la paleta el segundocolor
                    Color mezcla = p.mezclaColores(uno, dos); //los mezcla
                    b.setBackground(mezcla); //y pinta el botón
                    try {
                         sleep((int) (100 * Math.random())); //Espera entre 0 y 0.1 seg.
                    } catch (InterruptedException e) {
                    }
                    p.dejaColor(numPintor);
                    p.dejaColor(numPintor + 1);
               } else {
                    Color uno = p.tomaColor(numPintor); //Toma de la paleta el primercolor
                    b.setBackground(uno); //y pinta el botón
                    try {
                         sleep((int) (50 * Math.random())); //Espera entre 0 y 0.05 seg.
                    } catch (InterruptedException e) {
                    }
                    Color dos = p.tomaColor(numPintor + 1); //Toma de la paleta el segundocolor
                    Color mezcla = p.mezclaColores(uno, dos); //los mezcla
                    b.setBackground(mezcla); //y pinta el botón
                    try {
                         sleep((int) (100 * Math.random())); //Espera entre 0 y 0.1 seg.
                    } catch (InterruptedException e) {
                    }
                    p.dejaColor(numPintor);
                    p.dejaColor(numPintor + 1);
               }
          }
     }
}
