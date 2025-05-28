
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

public class RECUR_04_BuscarPosicionElementoEnArray {

  public static void main(String[] args) {

    int[] array={1,2,3,4,5};
    int elementoBuscar=3;
    int posElementoEncontrado=posicionElementoRecursivo(array, elementoBuscar,0);
    System.out.println(posElementoEncontrado);

  }

  public static int posicionElementoRecursivo(int[] array, int elementoBuscar ,int indice){

    if(indice==array.length || array[indice]==elementoBuscar){

      if(indice==array.length){
        return -1;
      }else{
        return indice;
      }

    }else{
      return posicionElementoRecursivo(array, elementoBuscar, indice+1);
    }

  }

}
