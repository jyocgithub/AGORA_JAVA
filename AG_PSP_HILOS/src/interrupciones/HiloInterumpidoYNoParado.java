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

public class HiloInterumpidoYNoParado extends Thread {
  public void run() {
    while (true) {
      try {
        System.out.println("Estamos currando...");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("¡¡ Me han interrumpido !!");
        System.out.println("... Mensaje recibido: " + e.getMessage());
        System.out.println("Pero yo sigo currando !!!");;
      }
    }
  }
  public static void main(String args[]) {
    HiloInterumpidoYNoParado hf1 = new HiloInterumpidoYNoParado();
    hf1.start();
    hf1.interrupt();
  }
}
