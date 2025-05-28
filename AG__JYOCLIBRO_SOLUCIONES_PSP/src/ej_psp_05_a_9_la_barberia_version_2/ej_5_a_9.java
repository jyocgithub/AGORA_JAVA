package ej_psp_5_a_9_la_barberia_version_2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ej_5_a_9 {

    public static void main(String[] args) {
        int total = 0;
        Cliente c2;
        Semaphore SillaDeEspera = new Semaphore(5);
        Semaphore SillaParaAfeitar = new Semaphore(1);
        Semaphore[] llaveroComunDeSemaforos = new Semaphore[2];

        llaveroComunDeSemaforos[0] = SillaDeEspera;
        llaveroComunDeSemaforos[1] = SillaParaAfeitar;

        String[] clientes = {"Alvaro", "Mario", "Iñaki", "Miguel", "Raul", "Juan"};

        Cliente[] arraydeclientes = new Cliente[clientes.length];

        for (int i = 0; i < clientes.length; i++) {
            c2 = new Cliente(clientes[i], llaveroComunDeSemaforos);
            c2.start();
            arraydeclientes[i] = c2;
        }

        for (int i = 0; i < arraydeclientes.length; i++) {
            try {
                arraydeclientes[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Después de la espera, tenemos que saber que cuánto ha ganado el barbero
        for (int i = 0; i < arraydeclientes.length; i++) {
            total = total + arraydeclientes[i].getPaga();
        }

        //Es el resultado total
        System.out.println("El barbero ha ganado " + total + " euros");

    }
}

class Cliente extends Thread {
    private String cliente;
    private int paga;
    private Semaphore[] llaveroComunDeSemaforos;

    public Cliente(String cliente, Semaphore[] llaveroComunDeSemaforos) {
        this.cliente = cliente;
        this.llaveroComunDeSemaforos = llaveroComunDeSemaforos;
    }

    public int getPaga() {
        return paga;
    }

    public void setPaga(int paga) {
        this.paga = paga;
    }

    public void run() {
        Random azar = new Random();
        int tiempoPaseando = azar.nextInt(1000 - 100 + 1) + 100;
        int tiempoDeAfeitar = azar.nextInt(1000 - 300 + 1) + 300;
        try {
            System.out.println(cliente + " está paseando");
            Thread.sleep(tiempoPaseando);
            llaveroComunDeSemaforos[0].acquire();
            System.out.println(cliente + " entra en la barberia y espera sentado el turno");
            llaveroComunDeSemaforos[1].acquire();
            System.out.println(cliente + " Tiene el turno para afeitar y se afeita");
            llaveroComunDeSemaforos[0].release();
            Thread.sleep(tiempoDeAfeitar);
            System.out.println(cliente + " ha terminado de afeitar");
            llaveroComunDeSemaforos[1].release();
        } catch (InterruptedException e) {
            System.err.println(e.getLocalizedMessage());
        }

        paga = (int) (Math.random() * 100) + 10; // numero al azar entre 10 y 100
        System.out.println(cliente + " ha pagado " + paga + " y se va de la barberia");
    }
}


