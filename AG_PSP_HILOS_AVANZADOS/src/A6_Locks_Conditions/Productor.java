package A6_Locks_Conditions;

import java.util.Random;

public class Productor extends Thread {
    private String nombre;
    private Monitor pMonitor;
    private String pMensaje;

    public Productor(String nombre, Monitor pMonitor) {
        this.nombre = nombre;
        this.pMonitor = pMonitor;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] arrayMensajes = {"hola", "buenas", "adios", "claro!!", "Agur", "Vale", "Fin"};
       while(true){

            try {
                int numeromensaje = random.nextInt(7);
                pMensaje = arrayMensajes[numeromensaje];

                pMonitor.poner(pMensaje, nombre);


                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.err.println("ProductorMensajes; se ha interrumpido el hilo ");
            }
        }
    }
}


