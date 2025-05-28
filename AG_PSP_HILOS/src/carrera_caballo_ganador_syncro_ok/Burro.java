package carrera_caballo_ganador_syncro_ok;

import java.util.Random;
public class Burro extends Thread {
    int puntuacion;
    Random r = new Random();
    Monitor m;
    public Burro(String nombre, Monitor m) {
        super(nombre);
        this.m = m;
    }

    @Override
    public void run() {
        while (puntuacion < 100) {
            //Aleatorio de 1 a 15 (ambos inclusive)
            puntuacion +=  1;
            puntuacion += r.nextInt(15) + 1;
            System.out.println(getName() + " va por " + puntuacion);
            try {
                Thread.sleep(500); //Espera de medio segundo.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // SIIIIII  !! esto SI es una operacion atomica, FUNCIONA !!!!!!!!!!!!!!!!!!!!!!!
        m.avanza();
    }
}

class Monitor{
    int posicion; //static porque es posición común a todos.
    public synchronized void avanza(){
        posicion++;
        System.out.println(Thread.currentThread().getName() + " ha llegado a meta y queda en la posición " + posicion);
    }
}
