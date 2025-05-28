package interrupciones;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

public class HiloInterumpidoYParado extends Thread {
  public void run() {
    while (true) {
      try {
        System.out.println("Estamos currando...");
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        System.out.println("¡¡ Me han interrumpido !!");
        System.out.println("...Mensaje recibido: "+e.getMessage());
        return;
      }
    }
  }
  public static void main(String args[]) {
    HiloInterumpidoYParado hf1 = new HiloInterumpidoYParado();
    hf1.start();
    hf1.interrupt();
  }
}