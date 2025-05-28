
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

public class SumaDigitos {

  public static void main(String[] args) {

    int numero = 123;

    System.out.println(sumaDigitos(numero));

  }

  public static int sumaDigitos(int numero){

    if(numero < 10){ //caso base
      return numero; //devuelvo el numero
    }else{
      return (numero % 10) + sumaDigitos(numero/10); //Cojo el digito y llamo a la funcion
    }

  }


}
