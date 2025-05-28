package cap03;

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
 *
 * @author Iñaki Martin
 */

/**
 *  Mostrar por pantalla todos los números primos que hay entre 1 y 200
 * <p>
 */
public class Jyoc_Ejercicio_3_b_10 {

    public static void main(String[] args) {


        // bucle 1: da 200 vueltas, con la variable i tomando valores de 1 a 200
        for (int i = 1; i < 201; i++) {

            // bucle 2:  va a comprobar si el numero i es primo
            // como i va a tomar valores de 1 a 100, este bucle se va a repetir 100 veces,
            // una para cada valor de i

            // antes de empezar el bucle, pongo un contador a 0
            // Este contador va a contar los divisores que tenga el numero i
            // incluidos el mismo y la unidad (1)
            int contadorDeDivisores = 0;

            // Este bucle va a ir dando a j los valores desde 1 hasta i
            // i mirando si cada valor de j es un divisor de i
            for (int j = 0; j < i; j++) {
                if (i % j == 0) {
                    // en este caso, j es divisor de i, aumento el contador
                    contadorDeDivisores++;
                }
            }

            // Al acabar de mirar todos los divisores, si es primo, debe haber
            // encontrado solo 2 divisores (1 y él mismo). Si hay mas, no es primo
            if (contadorDeDivisores == 2) {
                System.out.println(i + " es un numero primo");
            }
        }
    }


}
