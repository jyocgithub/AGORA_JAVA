package ej_psp_05_a_16_clinica_perros_gatos;

import java.util.concurrent.CountDownLatch;

public class HiloPerro  extends Thread{
    private CountDownLatch latch;
    String nombre = "Perro";
    int numero;

    //Objeto clinica
    private Clinica clinica;

    public HiloPerro(CountDownLatch l, int numero, Clinica clinica) {
        this.latch = l;
        this.numero = numero;
        this.clinica = clinica;
    }

    @Override
    public void run() {
        try {

            System.out.println("El perro " + numero + " llega e intenta entrar en el hospital");
            latch.countDown();
            latch.await();

            System.out.println("El perro " + numero + " ya en el hospital, intenta entrar en preoperatorio");

            clinica.semaforoPreoperatorio.acquire(); //entra un hilo
            System.out.println("El perro " + numero + " intenta entrar a operar");
            sleep(2000);

            clinica.semaforoSala.acquire();
            clinica.semaforoPreoperatorio.release();

            sleep(3000);
            System.out.println("------------------- El perro " + numero + " se opero y se pira");
            clinica.semaforoSala.release();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
