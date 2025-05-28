package Individual3.aed.filter.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;


public class Utils {

  public static <E> Iterable<E> filter(Iterable<E> d, Predicate<E> pred) {

    ArrayList<E> list = new ArrayList<>();

    Iterator<E>iterator = d.iterator();
    while(iterator.hasNext()){
      E elemen = iterator.next();
      if(elemen !=null) {
        if(pred.test(elemen)){
          list.add(elemen);
        }
      }

    }

    return list;
  }
}

