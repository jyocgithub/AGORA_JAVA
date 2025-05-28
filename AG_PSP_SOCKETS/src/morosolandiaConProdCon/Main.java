package morosolandiaConProdCon;
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

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Banco s = new Banco();
        s.start();
        Thread.sleep(200);
        for (int i = 0; i < 20; i++) {
           Camion c =new Camion();
           c.start();
        }
    }
}
