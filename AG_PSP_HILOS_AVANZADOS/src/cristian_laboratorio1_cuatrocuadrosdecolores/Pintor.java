package cristian_laboratorio1_cuatrocuadrosdecolores;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Pintor extends Thread {
 
    JButton b;
    Color paleta[] = new Color[5];
    public Pintor(JButton b){
        this.b=b;
        paleta[0]=Color.BLACK;
        paleta[1]=Color.RED;
        paleta[2]=Color.GREEN;
        paleta[3]=Color.BLUE;
        paleta[4]=Color.YELLOW;
    }
    public void run(){
          while (true){
            int i = (int)(5. * Math.random());
            b.setBackground(paleta[i]);
            b.setText(i+"");
               try {
                    Thread.sleep(100);
               } catch (InterruptedException ex) {
                    Logger.getLogger(Pintor.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
    }
}