package Individual4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;

//
//public class NIterator<E> implements Iterator<E> {
//  // Esta permitido anadir atributos nuevos
//  private int pasos ;
// // private PositionList<E> list;
//  private Iterator<E> iterator;
//  int puntero = 1;
//
//
//  private E elementoactual;
//  public NIterator(PositionList<E> list, int n) {
//
//    iterator = list.iterator();
//    this.pasos = n;
//   // this.list = list;
//    elementoactual = null;
//  }
//
//  @Override
//  public boolean hasNext() {
//
//    if(iterator.hasNext()){
//      return true;
//    }
//    return false;
//  }
//
//  @Override
//  public E next() {
//
//    if( ! hasNext()){
//       throw  new NoSuchElementException() ;
//    }
//
//    if(puntero==1) {
//      elementoactual = iterator.next();
//      puntero++;
//    }else {
//      int i = 0;
//      while (i < pasos) {
//
//        if(iterator.hasNext()) {
//
////        if (puntero == 1) {
////          elementoactual = list.first();
////        } else {
////
//          elementoactual = iterator.next();
////        }
//
//          puntero++;
//          i++;
//          // cuidado que nos podemos salir
//        }
//        else{
//          throw new NoSuchElementException();
//        }
//      }
//    }
//
//    while(elementoactual==null){
//      if(iterator.hasNext()) {
//        elementoactual = iterator.next();
//        puntero++;
//        // cuidado que nos podemos salir
//      }else{
//        throw  new NoSuchElementException() ;
//      }
//    }
//
//
//    return elementoactual;
//
//
//  }
//
//}




public class NIterator<E> implements Iterator<E> {
    // Esta permitido anadir atributos nuevos
    private int pasos ;
    // private PositionList<E> list;
    private Iterator<E> iterator;
    int puntero = 1;
    int listsize ;

    private E elementoactual;
    public NIterator(PositionList<E> list, int n) {

        iterator = list.iterator();
        this.pasos = n;
        // this.list = list;
        elementoactual = null;
        listsize = list.size();

    }

    @Override
    public boolean hasNext() {
        if(puntero==1 && listsize>0){
            return true;
        }
        if ( puntero+pasos-1<= listsize){
            return true;
        }
        return false;
    }

    @Override
    public E next() {

        if( ! hasNext()){
            throw  new NoSuchElementException() ;
        }

        if(puntero==1) {
            elementoactual = iterator.next();
            puntero++;
        }else {
            int i = 0;
            while (i < pasos) {

                if(iterator.hasNext()) {

//        if (puntero == 1) {
//          elementoactual = list.first();
//        } else {
//
                    elementoactual = iterator.next();
//        }

                    puntero++;
                    i++;
                    // cuidado que nos podemos salir
                }
                else{
                    throw new NoSuchElementException();
                }
            }
        }

        while(elementoactual==null){
            if(iterator.hasNext()) {
                elementoactual = iterator.next();
                puntero++;
                // cuidado que nos podemos salir
            }else{
                throw  new NoSuchElementException() ;
            }
        }


        return elementoactual;


    }

}
