
package ej_psp_05_a_16_clinica_perros_gatos;

import java.util.concurrent.Semaphore;

public class Clinica {

    //Semaforo
    Semaphore semaforoSala, semaforoPreoperatorio;

    public Clinica() {
        semaforoSala = new Semaphore(2);
        semaforoPreoperatorio = new Semaphore(5);
    }


}
