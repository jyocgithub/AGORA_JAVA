package estructuras_jerarquicas.binary_search_trees;
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


public class NodoArbolB {
    Integer key;
    String elem;

    NodoArbolB parent;
    NodoArbolB left;
    NodoArbolB right;

    public NodoArbolB(Integer key, String elem) {
        this.key = key;
        this.elem = elem;
        right = null;
        left = null;
    }

    @Override
    public String toString() {
        String s = "[";
        s+=     " key   =" + key +
                ", elem  ='" + elem + '\'' ;
        if (parent != null){
            s+= ", parent=" + parent.elem ;
        }
        if (left != null){
            s+= ", left  =" + left.elem ;
        }
        if (right != null){
            s+= ", parent=" + right.elem ;
        }

        return s+"]";
    }



}
