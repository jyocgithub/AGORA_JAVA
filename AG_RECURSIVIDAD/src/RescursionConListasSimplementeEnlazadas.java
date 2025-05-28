public class RescursionConListasSimplementeEnlazadas {
}


class SNode {
    int elem;
    SNode next;

    public SNode(int elem) {
        this.elem = elem;
    }

    public SNode(int elem, SNode next) {
        this.elem = elem;
        this.next = next;
    }
}


 class SList {
    public SNode first;

    // no usamos size ni last, por simplicidad de las soluciones
// ===================================================================
    public boolean contains(int n) {
        return contains(first, n);
    }

    public boolean contains(SNode sublist, int n) {
        if (sublist == null) {
            return false;
        } else if (sublist.elem == n) {
            return true;
        } else {
            return contains(sublist.next, n);
        }
    }

    // ===================================================================
    public int size() {
        return size(first);
    }

    public int size(SNode sublist) {
        if (sublist == null) {
            return 0;
        } else {
            return size(sublist.next) + 1;
        }
    }

    // ===================================================================
    public void insertAt(int pos, int n) {
// reemplaza la sublista "first" por la misma sublista, en la
// que se ha insertado el elemento en la posición “pos”
        first = insertAt(first, pos, n);
    }

    // Contrato del método "insertAt":
// - devuelve una sublista (representada por un SNode) consistente
// en la sublista que se pasó a la que se ha insertado un nodo en
// la posición "pos"
// - si pos = 0, va a devolver el nuevo nodo (y la sublista antigua, detrás)
// - si pos > 0, va a devolver el mismo nodo (pero el nuevo nodo va
// a estar intercalado después)
    private SNode insertAt(SNode sublist, int pos, int n) {
        if (pos == 0) {
            SNode newNode = new SNode(n);
            newNode.next = sublist;
            return newNode;
        } else {
// si entendemos "sublist.next" como la sublista después del
// nodo "sublist",
// reemplaza la sublista "sublist.next" por la misma sublista en la
// que se ha insertado el elemento en la posición pos - 1...
// ... que es justo lo que pone en el contrato de "insertAt"
            sublist.next = insertAt(sublist.next, pos - 1, n);
            return sublist;
        }
    }

    public String toString() {
        return "[ " + toString(first) + "]";
    }

    public String toString(SNode sublist) {
        if (sublist == null) {
            return "";
        } else {
            return sublist.elem + " " + toString(sublist.next);
        }
    }


    // ------------------------- metodos nuevos



     public boolean removeAt(int n) {
         return removeAt(first, n, 0);
     }

     public boolean removeAt(SNode sublist, int indexbuscado, int indexactual) {
        if(indexbuscado==0){
            if(first==null){
                return false;
            }
            first= first.next;
            return true;
        }
         if (sublist == null) {
             return false;
         } else if (indexactual==indexbuscado-1) {
             sublist.next = sublist.next.next;
             return true;
         } else {
             indexactual++;
             return removeAt(sublist.next, indexbuscado,  indexactual);
         }
     }


     public int indexOf(int n) {
         return indexOf(first, n, 0);
     }

     public int indexOf(SNode sublist, int valorbuscado, int indexactual) {
         if (sublist == null) {
             return -1;
         } else if (sublist.elem==valorbuscado) {
             return indexactual;
         } else {
             indexactual++;
             return indexOf(sublist.next, valorbuscado,  indexactual);
         }
     }
     public int numberOfOcurrences(int n) {
         return numberOfOcurrences(first, n, 0);
     }

     public int numberOfOcurrences(SNode sublist, int valorbuscado, int total) {
         if (sublist == null) {
             return total;
         } else if (sublist.elem==valorbuscado) {
             total++;
             return numberOfOcurrences(sublist.next, valorbuscado,  total);
         } else {
             return numberOfOcurrences(sublist.next, valorbuscado,  total);
         }
     }

     public void removeAll() {
        removeAll(first);
     }
     public void removeAll(SNode sublist) {
         if (sublist == null) {
             return ;
         } else if (sublist.next==null) {
             return ;
         } else {
             removeAll(sublist.next) ;
             sublist.next = null;
         }
     }









    // ===================================================================
    public static void main(String[] args) {
        SList list = new SList();
        list.first = new SNode(3, new SNode(2, new SNode(5)));
        System.out.println(list.toString());
        System.out.println(list.contains(2));
        System.out.println(list.contains(3));
        System.out.println(list.contains(5));
        System.out.println(list.contains(6));
        list.insertAt(0, 6);
        System.out.println(list.toString());
        System.out.println(list.contains(6));
        list.insertAt(3, 8);
        System.out.println(list.toString());
        System.out.println(list.contains(8));


        System.out.println(list.removeAt(0));
        System.out.println(list.toString());

        System.out.println(list.indexOf(5));

        list.insertAt(3, 6);
        list.insertAt(3, 6);
        System.out.println(list.toString());
        System.out.println(list.numberOfOcurrences(6));

        list.removeAll();
        System.out.println(list.toString());

    }
}
