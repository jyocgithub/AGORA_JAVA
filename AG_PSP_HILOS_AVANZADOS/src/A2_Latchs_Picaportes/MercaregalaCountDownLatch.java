package A2_Latchs_Picaportes;
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

import java.util.Random;
import java.util.concurrent.CountDownLatch;


/*
Un objeto Latch permite que un primer grupo de hilos quede en espera hasta que otro segundo grupo de hilos les permita continuar.
Un ejemplo es la clase CountDownLatch
El objeto Latch se crea con un determinado número (contador),
que indica cuántos hilos del segundo grupo han de avisar para que el primer grupo pueda continuar
Todos los hilos de los dos grupos comparten el objeto Latch
Cada hilo del primer grupo ejecuta, sobre el objeto Latch,
el método await() en el punto que quieran quedarse en espera
Cada hilo del segundo grupo ejecuta, sobre el objeto Latch,
el método countDown(), que va contando cuantos hay que ya han dado paso al primer grupo
Cuando se efectuan tantos countDown() como indica el contador del Latch, los hilos del primer grupo pueden continuar.
No es  una barrera cíclicas, una vez acabada la "cuenta atras",
las nuevas llamadas a await() no tienen efecto
El número de hilos que componen el primer grupo y que quedan en espera es irrelevante, puede ser cualquiera
Ejemplo: clase CountDownLatch
 */

/*
Ejemplo de uso de CountDownLatch: los clientes van llegando a la tienda Mercaregala,
pero no pueden entrar hasta que los 3 empleados de la misma han llegado y se han vestido.
Mas tarde, nuevos clientes entran sin esperar

 */
public class MercaregalaCountDownLatch {

    public static void main(String[] args) throws InterruptedException  {
        // contador de empleados necesarios para abrir la tienda
        CountDownLatch cdl_Empleados = new CountDownLatch(3);

        // bucle que lanza los hilos de los clientes
        for (int i = 0; i < 5; i++) {
            HiloCliente hc = new HiloCliente(i, cdl_Empleados);
            hc.start();
        }

        // bucle que lanza los hilos de los empleados
        for (int i = 0; i < 3; i++) {
            HiloEmpleado he = new HiloEmpleado(i, cdl_Empleados);
            he.start();
        }
        Thread.sleep(3000);

        // se lanza un hilo mas de cliente, que NO va a tener que esperar
        HiloCliente hc = new HiloCliente(5, cdl_Empleados);
        hc.start();

    }


}
class HiloEmpleado extends Thread {
    private int num;
    private CountDownLatch cdl_Empleados;
    public HiloEmpleado(int num, CountDownLatch cdl_Empleados) {
        this.num = num;
        this.cdl_Empleados = cdl_Empleados;
    }
    public void run() {
        System.out.println("LLega el empleado " + num + " a Mercaregala. Se pone a verstirse");
        try {
            sleep(new Random().nextInt(2000) + 1000);
            System.out.print("Empleado " + num + " listo y en la tienda");
            cdl_Empleados.countDown(); // decrementa el contador de empleados pendientes de llegar
            if (cdl_Empleados.getCount() > 0) {
                System.out.println("... pero quedan " + cdl_Empleados.getCount() + " por aparecer!");
            } else {
                System.out.println(", vaya, soy el ultimo en llegar ");
            }
        } catch (InterruptedException ex) { }
    }
}

class HiloCliente extends Thread {
    private int num;
    private CountDownLatch cdl_Empleados;

    public HiloCliente(int num, CountDownLatch cdl_Empleados) {
        this.num = num;
        this.cdl_Empleados = cdl_Empleados;
    }

    public void run() {
        try {
            System.out.print("Cliente " + num + " en la puerta de la tienda");
            if (cdl_Empleados.getCount() > 0) {
                System.out.println(".. y me temo que me toca esperar, aun no han abierto");
            } else {
                System.out.println(".. PERO NO ME TOCA ESPERAR !");
            }
            cdl_Empleados.await(); // Espera a que todos los empleados esten en la tienda
        } catch (InterruptedException ex) { }
        System.out.println("Cliente " + num + " esta ya en la tienda");
    }


}