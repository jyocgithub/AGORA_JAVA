package patron_iterator;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainPatronIterator {

    public static void main(String[] args) {
        List<Integer> ll = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 3,4,5,6}));
        MiIterator<Integer> mit = new MiIterator<Integer>(ll);

        while (mit.hasNext()) {
            Integer algo = mit.next();
            System.out.println(algo);
        }

    }


}

interface IMiIterator<T> {
    boolean hasNext();
    T next();
}

class MiIterator<T> implements IMiIterator<T> {
    List<T> elementos;
    int index = 0;

    public MiIterator(List<T> lista) {
        this.elementos = lista;
    }

    @Override
    public boolean hasNext() {
        return (index <= elementos.size() -1);
    }

    @Override
    public T next() {
        if (index < elementos.size() ) {
            return elementos.get(index++);
        }
        return null;
    }
}