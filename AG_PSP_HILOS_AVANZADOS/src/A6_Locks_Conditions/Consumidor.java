package A6_Locks_Conditions;


public class Consumidor extends Thread {
    private String nombre;
    private Monitor pMonitor;

    public Consumidor(String nombre, Monitor pMonitor) {
        this.nombre = nombre;
        this.pMonitor = pMonitor;
    }

    @Override
    public void run() {
        String mensajeSacado;
        while (true) {
            try {
                mensajeSacado = (String) pMonitor.sacar(nombre);
                System.out.println("-- Saco del Monitor el mensaje " + mensajeSacado);
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println("ConsumidorMensajes; se ha interrumpido el hilo ");
            }
        }
    }
}
