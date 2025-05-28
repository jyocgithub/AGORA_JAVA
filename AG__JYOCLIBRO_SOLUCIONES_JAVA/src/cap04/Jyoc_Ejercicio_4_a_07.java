package cap04;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Programa que lee el nombre y edad en años de una serie de alumnos
 * hasta introducir como nombre de alumno “fin” o se llegue a 10.
 * En ese momento mostrará la edad media de los alumnos y el nombre
 * del alumno menor.
 */
public class Jyoc_Ejercicio_4_a_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));

        int numestudiantes;
        String nombres[] = new String[10];
        String elMenor ="";
        int edades[] = new int[10];
        int sumaEdades = 0, edadmenor = 0;
        boolean seguir = true;

        // primer bucle, que lee los nombres y notas de los estudiantes
        System.out.println("Escriba nombre y notas de cada estudiante, o FIN para acabar:");
        int i;
        for ( i = 0; i < 10 && (seguir); i++) {
            System.out.println("Nombre del estudiante : " + (i + 1));
            nombres[i] = entrada2.readLine();
            if(nombres[i].equalsIgnoreCase("FIN")){
                seguir = false;
            }else {
                System.out.println("Edad del estudiante : " + (i + 1));
                edades[i] = Integer.parseInt(entrada2.readLine());
            }
            sumaEdades += edades[i];
            if(edades[i]<edadmenor){
                edadmenor = edades[i];
                elMenor = nombres[i];
            }
        }

        // segundo bucle, muestra resultados
        System.out.println("Media de edades: "+ (sumaEdades/i));
        System.out.println("Nombre del de menor edad:"+ elMenor);

    }
}