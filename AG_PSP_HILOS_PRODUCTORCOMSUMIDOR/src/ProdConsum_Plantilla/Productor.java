package ProdConsum_Plantilla;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase ProductorMensajes
 * Extiende de Thread para comportarse como un hilo,
 * por lo que sobreescribira su metodo run()
 * donde esta el codigo a ejecutgar cuando se le permita por sincronizacion
 */
public class Productor extends Thread {
    private String nombre;
    private Monitor pMonitor;
    private String pMensaje;

    /**
     * Constructor ProductorMensajes. Recibe como parametros
     * - un nombre
     * - un objeto del Monitor que es quien esta controlando el trafico
     * El productor termina al enviar 10 mensajes
     */
    public Productor(String nombre , Monitor pMonitor) {
        this.nombre = nombre;
        // Mantiene una copia propia del objeto compartido
        this.pMonitor = pMonitor;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] arrayMensajes = {"hola", "buenas", "adios", "claro!!", "Agur", "Vale", "Fin"};
        // envianmos 10 mensajes
        for (int i = 0; i <10 ; i++) {

            int numeromensaje = random.nextInt(7);
            pMensaje = arrayMensajes[numeromensaje];

            // Se añade el atributo de clase pMensaje, que es el mensaje,
            // al buffer, con el metodo poner() del monitor
            pMonitor.poner(pMensaje);

            // mensaje por consola de confirmacion
            System.out.println("   Puesto en Monitor el mensaje " + pMensaje);

            // Espera un poco antes de añadir más letras
            // Este valor se puede cambiar para ver con que alternancia se efectuan
            // las lecturas y escrituras en el buffer, por bloqueos y esperas variables
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.err.println("ProductorMensajes; Error en poner: " + e.getMessage());
            }
        }

        System.out.println("FIN DE ENTRADAS DE MENSAJERIA");
        sc.close();
    }
}


