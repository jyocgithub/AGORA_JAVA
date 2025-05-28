
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

public class RECUR_6_Factorial {

  public static void main(String[] args) {

    int n=5;
    //Guarda el resultado en una variable
    int resultado2=factorial(n);
    int resultado1=factorialRecursivo(n);

    //Muestra el resultado
    System.out.println(resultado2);

  }

  public static int factorialRecursivo(int numero){
    int res;
    if(numero==1){
      //Se termina la recursión
      return 1;
    }else{
      //Se llama asi misma la funcion, con el valor del numero menos 1
      res = numero * factorialRecursivo(numero-1);
    }
    //Devolvemos el valor
    return res;

  }
  public static int factorial( int num ) {
    if(num==1) {    //Se termina la recursión
      return 1;
    }
    return num * (factorial(num -1)) ;
  }
}
