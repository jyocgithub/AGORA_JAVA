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

public class HiloNoInterrumpidoDirectamente extends Thread {
  public void run() {
    System.out.println("Estamos currando y sumando...");
    for (int i = 0; i < 2000000000; i++) {
      if (this.isInterrupted()) { //   this.interrupted() no modifica el estado del "interrupt status", sigue "Apagado"

        System.out.println("Me han interrumpido cuando iba por " + i);
        System.out.println("Pero yo sigo currando !!!");
      }
    }
    System.out.println("Acabé !!");
  }
  public static void main(String args[]) throws InterruptedException {
    HiloNoInterrumpidoDirectamente hf1 = new HiloNoInterrumpidoDirectamente();
    hf1.start();
    Thread.sleep(100);  // espero un poco
    hf1.interrupt();
  }
}