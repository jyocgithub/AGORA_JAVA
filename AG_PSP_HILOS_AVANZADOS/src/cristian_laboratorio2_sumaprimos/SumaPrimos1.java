package cristian_laboratorio2_sumaprimos;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class SumaPrimos1 {

     public static void main(String[] x) {
          
          new Random().nextInt(23);
          
          Scanner teclado = new Scanner(System.in);
          int numero = teclado.nextInt();
                 
                  
          
          int numero2 = new Scanner(System.in).nextInt();
          
           
          

          // CREAR OBJETOS DE FECHA DE HOY
          Date d1 = new Date();
          Calendar cc = Calendar.getInstance();
          Date d2 = cc.getTime();
          Calendar c2 = new GregorianCalendar();

          System.out.println(d1);
          System.out.println(d2.getTime()); // 1499094652787
          System.out.println(d2.getTime() + 1000); // 1499094653787

          // IDENTIFICAR ELEMENTOS DE UNA FECHA:
          int año = cc.get(Calendar.YEAR);
          int mes = cc.get(Calendar.MONTH);
          int dia = cc.get(Calendar.DAY_OF_MONTH);
          int hora = cc.get(Calendar.HOUR_OF_DAY);
          int minuto = cc.get(Calendar.MINUTE);
          int segundo = cc.get(Calendar.SECOND);

          // CREAR UNA FECHA NUEVA O CAMBIAR ALGUN ELEMENTO
          cc.set(2013, 5, 1); // asigna año, mes, día
          cc.set(2013, 5, 1, 3, 45, 12); // asigna año, mes, día, hora, minuto, segundo
          cc.set(Calendar.YEAR, 2015); // cambiar solo el año, a 2015

          // SUMAR Y RESTAR ELEMENTOS A FECHAS
          cc.add(Calendar.DAY_OF_MONTH, 10); //sumar 10 días a la fecha actual
          cc.add(Calendar.MINUTE, 10); //sumar 10 minutos a la hora actual
          cc.add(Calendar.YEAR, -2); //restar 2 años a la fecha actual

          Resultado suma = new Resultado();
          long t0 = (new Date()).getTime(); //t0=instante de inicio de los cálculos
          Calculador p1 = new Calculador(1, 10000000, suma);
          p1.start();
          try {
               p1.join();
          } catch (InterruptedException e) {
          }
          long t1 = (new Date()).getTime(); //t1=instante de final de los cálculos
          System.out.println("La suma de los números primos hasta 10000000 es: " + suma.getSuma() + " calculado en " + (t1 - t0) + " miliseg.");
     }
}


class Calculador extends Thread {

     int desde, hasta;
     Resultado r;

     public Calculador(int x, int y, Resultado r) {
          desde = x;
          hasta = y;
          this.r = r;
     }

     public void run() {
          for (int i = desde; i <= hasta; i++) {
               if (esPrimo(i)) {
                    r.sumar(i);
               }
          }
     }

     private boolean esPrimo(int n) {
          int raiz = (int) Math.sqrt((double) n);
          boolean primo = true;
          int i = 2;
          while (primo && i <= raiz) {
               if (n % i == 0)
                    primo = false;
               i++;
          }
          return primo;
     }
}


class Resultado {

     private BigInteger suma = new BigInteger("0");

     public BigInteger getSuma() {
          return suma;
     }

     public void sumar(int n) {
          BigInteger bn = new BigInteger(String.valueOf(n));
          BigInteger bn2 = new BigInteger("1");
          suma = suma.add(bn);
          //System.out.println("sumar " + String.valueOf(n) +" = "+ suma.toString());
     }
}
