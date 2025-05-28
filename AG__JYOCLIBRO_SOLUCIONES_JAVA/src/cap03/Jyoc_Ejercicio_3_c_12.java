package soluciones_ejercicicios.ims.jyoc.cap03;

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
 * @author Iñaki Martin
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Capitulo 3 Ejercicio c_9
 * Escribir en modo matriz la hoja de calendario del mes de mayo de 1992.
 * (ayuda: el 1 de mayo del 1992 fue viernes, y el
 *  1 de junio 2015 fue lunes, empezar por ahi)
 */
public class Jyoc_Ejercicio_3_c_12 {

     public static void main(String[] args) {
          int primerDiaDeSemana = 5; // 4 es viernes, pues se cuentan desde 0
          int diasEnBlanco = 0, diasPasadosPorMes = 0;
          int ultimoDiaDelMes = 31;
          int diaDelMes = 1;
          System.out.println ("\tCalendario de Mayo 1992");
          System.out.println ("\t---------------------------------------------------");
          System.out.println ("\tLUN\tMAR\tMIE\tJUE\tVIE\tSAB\tDOM");
          System.out.println ("\t---------------------------------------------------");
          while (diaDelMes <= ultimoDiaDelMes) {
               diasPasadosPorMes++;
               if (diasEnBlanco++ < primerDiaDeSemana) {
                    System.out.print ("\t");
                    continue;
               }
               System.out.print ("\t" + (diaDelMes++));
               if (diasPasadosPorMes == 7) {
                    diasPasadosPorMes = 0;
                    System.out.println ("");
               }
          }
     }

     // MEJORA 1 . El calendario en este caso se construye primero sobre una matriz

     public static void mejora1(){
          byte mes = 0;
          short año = 0;
          Scanner sc = new Scanner(System.in);

          System.out.println("Deme el mes");
          mes = (byte) sc.nextInt();
          System.out.println("Deme el año");
          año = (short) sc.nextInt();

          GregorianCalendar fecha = new GregorianCalendar(año, mes - 1, 1); // mes va de 0 a 11
          int numdiadelasemana = fecha.get(Calendar.DAY_OF_WEEK);  // cuidado!! el domingo es 1, lunes es 2, martes es 3

          System.out.println("Calendario " + mes + " de " + año);

          int ultimodiadelmes = 0;
          if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
               ultimodiadelmes = 31;
          } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
               ultimodiadelmes = 30;
          } else {
               // el mes es el 2
               ultimodiadelmes = 28;
               if (fecha.isLeapYear(año) == true) {
                    ultimodiadelmes = 29;
               }
          }

          int[][] matriz = new int[5][7];
          int diadelmesquepinto = 1;
          int numerodelasemana = 0;
          int columnaquetoca = 0;
          int filaquetoca = 0;
          // si el numdiadesemana es 1 DOMINGO, le corresponde la columna 6
          // si el numdiadesemana es 2 LUNES , le corresponde la columna 0
          // si el numdiadesemana es 3 MARTS , le corresponde la columna 1
          // si el numdiadesemana es 4, le corresponde la columna 2
          // si el numdiadesemana es 5, le corresponde la columna 3
          // si el numdiadesemana es 6, le corresponde la columna 4
          // si el numdiadesemana es 7, le corresponde la columna 5
          if (numdiadelasemana == 1) {
               columnaquetoca = 6;
          } else {
               columnaquetoca = numdiadelasemana - 2;
          }

          // rellenar la matriz
          do {
               matriz[filaquetoca][columnaquetoca] = diadelmesquepinto;
               diadelmesquepinto++;
               columnaquetoca++;
               if (columnaquetoca == 7) {
                    columnaquetoca = 0;
                    filaquetoca++;
               }
          } while (diadelmesquepinto <= ultimodiadelmes);

          // mostrar la matriz
          for (int fila = 0; fila <= 4; fila++) {
               String cadena = "";
               for (int columna = 0; columna <= 6; columna++) {
                    if (matriz[fila][columna] == 0) {
                         cadena = cadena +"\t";
                    } else {
                         cadena = cadena + matriz[fila][columna] + "\t";
                    }
               }
               System.out.println(cadena);
          }



     }





}
