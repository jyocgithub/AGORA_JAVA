package aed.recursion;

import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.indexedlist.IndexedList;
import es.upm.aedlib.positionlist.NodePositionList;


public class Utils {

    public static int multiply(int a, int b) {
        int signo = a < 0 ? -1 : 1;
        int suma = 0;
        int result = sumar(signo, suma, a, b);

        return result;
    }

    public static int sumar(int signo, int suma, int a, int b) {
        if (a == 0) {
            return suma * signo;
        }

        if (a % 2 != 0) {
            suma = suma + b;
        }
        a = a / 2;
        b = b * 2;

        return sumar(signo, suma, a, b);
    }


    public static <E extends Comparable<E>> int findBottom(IndexedList<E> l) {

        if (l.size() == 1) {
            return 0;
        }
        if (l.size() == 2) {
            if (l.get(0).compareTo(l.get(1)) >= 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int res = findBottom2(l, 0, l.size() - 1);
        return res;
    }

    public static <E extends Comparable<E>> boolean eshoyo(IndexedList<E> l, int position) {
        if (position == 0) {
                return (l.get(1).compareTo(l.get(0)) >= 0) ;
//            if (l.get(1).compareTo(l.get(0)) >= 0) {
//                return true;
//            }
        } else if (position == l.size() - 1) {
                return (l.get(position - 1).compareTo(l.get(position)) >= 0);
//            if (l.get(position - 1).compareTo(l.get(position)) >= 0) {
//                return true;
//            }
        } else if (l.get(position - 1).compareTo(l.get(position)) >= 0 && l.get(position + 1).compareTo(l.get(position)) >= 0) {
            return true;
        }
        return false;
    }

    public static <E extends Comparable<E>> int findBottom2(IndexedList<E> l, int starts, int ends) {
        int medio = (starts + ends) / 2;

//        if (eshoyo(l, medio)) {  // no es estrictamente necesaria y hace mucho mas trabajo
//            return medio;
//        }

        if (starts == ends - 1) {
            if (eshoyo(l, starts)) {
                return starts;
            } else if (eshoyo(l, ends)) {
                return ends;
            }
            return -1;
        }

        int res = findBottom2(l, starts, medio);
        if (res >= 0) {
            return res;
        }
        return findBottom2(l, medio, ends);
    }




    public static <E extends Comparable<E>> NodePositionList<Pair<E, Integer>>
    joinMultiSets(NodePositionList<Pair<E, Integer>> l1,
                  NodePositionList<Pair<E, Integer>> l2) {

        NodePositionList<Pair<E, Integer>> res = new NodePositionList<>();
        Position<Pair<E, Integer>> par1 = l1.first();
        Position<Pair<E, Integer>> par2 = l2.first();

        return join(l1, l2, par1, par2, res);
    }


    public static <E extends Comparable<E>> NodePositionList<Pair<E, Integer>>
    join(NodePositionList<Pair<E, Integer>> l1,
         NodePositionList<Pair<E, Integer>> l2,
         Position<Pair<E, Integer>> par1,
         Position<Pair<E, Integer>> par2,
         NodePositionList<Pair<E, Integer>> res) {

        if (par1 == null && par2 == null) {
            return res;
        }

        if (par1 == null) {
            res.addLast(par2.element());
            return join(l1, l2, par1, l2.next(par2), res);
        }

        if (par2 == null) {
            res.addLast(par1.element());
            return join(l1, l2, l1.next(par1), par2, res);
        }

        int right1 = par1.element().getRight();
        int right2 = par2.element().getRight();
        E left1 = par1.element().getLeft();
        E left2 = par2.element().getLeft();

        if (left1.compareTo(left2) == 0) {
            Pair<E, Integer> newpar = new Pair<E, Integer>(left1, right1 + right2);
            res.addLast(newpar);
            return join(l1, l2, l1.next(par1), l2.next(par2), res);

        } else if (left1.compareTo(left2) < 0) {
            res.addLast(par1.element());
            return join(l1, l2, l1.next(par1), par2, res);

        } else {
            res.addLast(par2.element());
            return join(l1, l2, par1, l2.next(par2), res);
        }
    }

}
