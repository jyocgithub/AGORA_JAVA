package estructuras_jerarquicas.binary_search_arrays;
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

public class BusquedaBinaria {

  /**
   * Busca un valor numerico dentro de un array numerico...
   * previamente ordenado usando el metodo de busqueda binaria
   */
  public static int busquedaBinaria(int  array[], int dato){
    int centro,inf=0,sup=array.length-1;
    while(inf<=sup){
      centro=(sup+inf)/2;
      if(array[centro]==dato) return centro;
      else if(dato < array [centro] ){
        sup=centro-1;
      }
      else {
        inf=centro+1;
      }
    }
    return -1;
  }

  public static void main(String []args){
//    int[]array ={1,4,7,8,9,14,23,47,56,60,61,63,65,66,68,69,70,73,76,77,79,80,82};
    int[]array ={2,14};
    int valorBuscado = 14;
    System.out.println(busquedaBinaria(array,valorBuscado));
  }


}
