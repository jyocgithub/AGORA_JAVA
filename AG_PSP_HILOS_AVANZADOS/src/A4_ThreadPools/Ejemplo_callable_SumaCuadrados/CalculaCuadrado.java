package A4_ThreadPools.Ejemplo_callable_SumaCuadrados;
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

import java.util.concurrent.Callable;

public class CalculaCuadrado implements Callable<Integer> {
    private final int numero;

    public CalculaCuadrado(int numero) {
        this.numero = numero;
    }

    @Override
    public Integer call() {
        System.out.println("Calculando el cuadrado de " + numero + " en " + Thread.currentThread().getName());
        return numero * numero;
    }
}
