package comensales;

import java.util.Random;

/**
 * Mientras hay comida el comensal come y descansa
 *
 * @author amadeo
 */
public class Comensal extends Thread {

    /**
     * Identificador de comensal.
     */
    private String comensal;

    /**
     * Array de comida por plato.
     */
    private Plato[] platos;

    /**
     * Cantidades comidas
     */
    private int comido;

    /**
     * Constructor
     *
     * @param comensal String: identifica a cada comensal
     * @param platos   Plato[]: comida de cada plato
     */
    public Comensal(String comensal, Plato[] platos) {
        this.comensal = comensal;
        this.platos = platos;
        this.comido = 0;
    }

    /**
     * Mensaje de cada comensal
     *
     * @return String
     */
    public String toString() {
        return comensal;
    }

    /**
     * Cantidad comida
     *
     * @return comida
     */
    public int getComido() {
        return comido;
    }

    /**
     * El comensal intenta comer de un plato (probando desde el primero al último).
     *
     * @return true si ha conseguido comer.
     */
    private boolean comer() throws InterruptedException {
        for (Plato plato : platos) {
            if (plato.comer(this)) {
                return true;
            }
        }
        return false;
    }

    /**
     * El comensal descansa un rato antes de volver a intentar comer.
     */
    private void descansar() throws InterruptedException {
        Thread.sleep((new Random()).nextInt(1000) + 100);
    }

    /**
     * Devuelve si no queda comida en ningún plato
     *
     * @return true si no queda comida.
     */
    private boolean hayComida() {
        for (Plato plato : platos) {
            if (!plato.vacio()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mientras haya comida: descansa y come.
     */
    @Override
    public void run() {
        try {
            while (hayComida()) {
                descansar();
                if (comer()) {
                    comido++;
                }
            }
        } catch (InterruptedException e) {
        }
    }
}