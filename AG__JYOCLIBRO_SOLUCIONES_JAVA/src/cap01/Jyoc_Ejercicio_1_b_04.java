package cap01;

import java.util.Scanner;

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


/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 * @author Iñaki Martin
 */

/**
 Vamos a simular un cajero de un super.
 Para hacerlo fácil, vamos a trabajar solo con billetes de 50€, 20€, 10€, 5€, sin monedas.
 Por tanto, el importe será siempre múltiplo de 5.
 Solicitamos el importe de la venta (múltiplo de 5), y con cuanto me paga (igual o mayor al importe de la venta (múltiplo de 5).
 El programa informa, cuantos billetes le tengo que devolver.
 Por ejemplo:
 Importe venta 15, pagado 50. La salida será: 1 de 20, 1 de 10 y 1 de 5.
 Importe venta 25, pagado 200: 3 de 50, 1 de 20  y 1 de 5.
 Suponemos que siempre tengo suficientes billetes de 50, de 20, de 10 y de 5 euros
 * <p>
 */
public class Jyoc_Ejercicio_1_b_04 {

     public static void main(String[] args) {
          Scanner objetoScanner8 = new Scanner(System.in);
          System.out.println("Indíque el importe: ");
          int importe = objetoScanner8.nextInt();
          System.out.println("Indíque el precio pagado: ");
          int pagado = objetoScanner8.nextInt();

          int vuelta = pagado - importe;
          int bil50 = vuelta/50;
          vuelta  =vuelta - bil50*50;
          int bil20 = vuelta/20;
          vuelta  =vuelta - bil20*20;
          int bil10 = vuelta/10;
          vuelta  =vuelta - bil10*10;
          int bil5 = vuelta/5;
          vuelta  =vuelta - bil5;

          System.out.println(" Billetes de 50  "+ bil50);
          System.out.println(" Billetes de 20  "+ bil20);
          System.out.println(" Billetes de 10  "+ bil10);
          System.out.println(" Billetes de 5  "+ bil5);
          System.out.println(" Monedas  "+ vuelta);

     }

}
