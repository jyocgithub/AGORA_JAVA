package comensales;

/**
 * Clase donde reside el método main() que inicia la aplicación
 *
 * @author amadeo
 */
public class Mesa {

    /**
     * Comida existente en cada plato
     */
    static Plato[] platos = {
            new Plato(2),
            new Plato(3),
            new Plato(5)
    };

    /**
     * Número de comensales
     */
    static Comensal[] comensales = {
            new Comensal("Ana", platos),
            new Comensal("Juan", platos),
            new Comensal("Luis", platos),
            new Comensal("Silvia", platos)
    };

    /**
     * Arranca la mesa.
     *
     * @param args the command line arguments
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        for (Comensal comensal : comensales) {
            comensal.start();
        }

        for (Comensal comensal : comensales) {
            comensal.join();
        }

        System.out.println("======= RECUENTO =======");
        for (Comensal comensal : comensales) {
            System.out.println(comensal + " ha comido " + comensal.getComido());
        }
    }
}