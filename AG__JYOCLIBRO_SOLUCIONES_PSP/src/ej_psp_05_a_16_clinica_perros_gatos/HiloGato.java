package ej_psp_05_a_16_clinica_perros_gatos;

import java.util.concurrent.CountDownLatch;

public class HiloGato extends Thread{
    private CountDownLatch latch;
    String nombre = "Gato";
    int numero;

    //Objeto clinica
    private Clinica clinica;

    public HiloGato(CountDownLatch l, int numero, Clinica clinica) {
        this.latch = l;
        this.numero = numero;
        this.clinica = clinica;
    }

    @Override
    public void run() {
        try {

            System.out.println("El gato " + numero + " llega e intenta entrar en el hospital");
            latch.countDown();
            latch.await();

            System.out.println("El gato " + numero + " ya en el hospital, intenta entrar en preoperatorio");

            clinica.semaforoPreoperatorio.acquire(); //entra un hilo
            System.out.println("El gato " + numero + " intenta entrar a operar");
            sleep(3000);

            clinica.semaforoSala.acquire(2);
            clinica.semaforoPreoperatorio.release();

            sleep(2000);
            System.out.println("------------------- El gato " + numero + " se opero y se pira");
            clinica.semaforoSala.release(2);

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
