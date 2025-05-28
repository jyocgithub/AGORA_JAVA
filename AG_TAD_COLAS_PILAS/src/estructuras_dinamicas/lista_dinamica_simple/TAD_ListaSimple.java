package estructuras_dinamicas.lista_dinamica_simple;


// una lista simple tiene nodos que solo conocen quien viene detras
// no es ni una estructura FIFO ni LIFO,
// se peuden meter elementos al inicio, al final o en medio
// y se pueden extraer elementos del inicio, del final o del medio


public class TAD_ListaSimple<T> {
    private NodoLista nodoPrimero;

    public TAD_ListaSimple() {
        nodoPrimero = null;
    }

    public int size() {

        NodoLista aux = nodoPrimero;
        int i = 0;
        while (aux != null) {
            aux = aux.nodoSiguiente;
            i++;
        }
        return i;
    }

    public void insertFirst(T x) {
        NodoLista aux = new NodoLista(x);
        if (nodoPrimero == null) {
            nodoPrimero = aux;
        } else {
            aux.nodoSiguiente = nodoPrimero;
            nodoPrimero = aux;
        }
    }

    public void insertLast(T x) {
        NodoLista nuevo = new NodoLista(x);
        if (nodoPrimero == null) {
            nodoPrimero = nuevo;
        } else {
            NodoLista aux = nodoPrimero;
            for (int i = 1; i < size(); i++) {
                aux = aux.nodoSiguiente;
            }
            aux.nodoSiguiente = nuevo;
        }
    }

    public void insertPosition(int pos, T n) {
        if ((pos > 0) && (pos <= (size() + 1))) {
            if (pos == 1) {
                insertFirst(n);
            } else {
                if (pos < (size() + 1)) {
                    NodoLista nuevo = new NodoLista(n);
                    NodoLista aux = nodoPrimero;
                    for (int i = 2; i < pos; i++) {
                        aux = aux.nodoSiguiente;
                    }
                    nuevo.nodoSiguiente = aux.nodoSiguiente;
                    aux.nodoSiguiente = nuevo;
                }
                if (pos == (size() + 1)) {
                    insertLast(n);
                }
            }
        } else {
        }
    }



    public void deleteAll() {
        nodoPrimero = null;
    }

    public void deleteFirst() {
        NodoLista prim = nodoPrimero;
        if (nodoPrimero != null) {
            if (nodoPrimero.nodoSiguiente == null)
                nodoPrimero = null;
            else {
                nodoPrimero = prim.nodoSiguiente;
                prim.nodoSiguiente = prim.nodoSiguiente.nodoSiguiente;
            }
        }
    }

    public void deleteLast() {
        if (nodoPrimero != null) {
            if (nodoPrimero.nodoSiguiente == null)
                nodoPrimero = null;
            else {
                NodoLista aux = nodoPrimero;
                while (aux.nodoSiguiente.nodoSiguiente != null)
                    aux = aux.nodoSiguiente;
                aux.nodoSiguiente = null;
            }
        }
    }


    public void deletePosition(int pos) {
        NodoLista nodoAEliminar = getPosition(pos);
        NodoLista nodoPrevioAlQueHayQueEliminar = getPosition(pos - 1);

        // si el nodo no existe
        if (nodoAEliminar == null) {
            System.out.println("Posicion no existente");
            return;
        }
        // si pos es el primer nodo
        if (pos == 1) {
            nodoPrimero = nodoPrimero.nodoSiguiente;
            return;
        }
        // si pos no es el primer nodo
        nodoPrevioAlQueHayQueEliminar.nodoSiguiente = nodoAEliminar.nodoSiguiente;
    }
    public void deleteValue(T valorbuscado) {
        NodoLista elim = nodoPrimero;

        if (elim == null)
            System.out.println("Lista Vacia");
        else if (nodoPrimero.valor.equals(valorbuscado)) {
            nodoPrimero = nodoPrimero.nodoSiguiente;
        } else {
            while ((( ! valorbuscado.equals(elim.nodoSiguiente.valor)) && (elim != null)))
                elim = elim.nodoSiguiente;
            if (elim.nodoSiguiente != null)
                elim.nodoSiguiente = elim.nodoSiguiente.nodoSiguiente;
            else
                System.out.println("Nodo no Existe");
        }
    }
    public NodoLista getPosition(int pos) {
        if (pos <= 0 || pos > size() || nodoPrimero == null) {
            return null;
        }
        NodoLista aux = nodoPrimero;
        for (int i = 1; i < pos; i++) {
            aux = aux.nodoSiguiente;
        }
        return aux;
    }

    public NodoLista getFirst() {
        if (nodoPrimero != null) {
            return nodoPrimero;
        }
        return null;
    }
    public NodoLista getLast() {
        if (nodoPrimero != null) {
            NodoLista aux = nodoPrimero;
            while (aux.nodoSiguiente != null)
                aux = aux.nodoSiguiente;
            return aux;
        }
        return null;
    }

    public NodoLista getBefore(NodoLista p) {
        if (nodoPrimero == p)
            return null;
        else {
            NodoLista aux = nodoPrimero;
            while (aux.nodoSiguiente != p)
                aux = aux.nodoSiguiente;
            return aux;
        }
    }


    public String toString() {
        String res ="";
        NodoLista aux = nodoPrimero;
        int i = 1;
        res = "- Lista de nodos -\n";
        while (aux != null) {
            res =  res + "Nodo Nº " + i + ": " + aux.valor.toString()+"\n";
            aux = aux.nodoSiguiente;
            i++;
        }
        return res;
    }

    public void mostrarListaInversa() {
        NodoLista mov = nodoPrimero;
        int i, j;
        //La idea fundamental es que siempre se muestre el ultimo Nodo
        //Decrementando el limite en cada ciclo.
        System.out.println("- Lista inversa de nodos -");
        for (i = size(); i > 0; i--) {
            for (j = 1; j < i; j++) {
                mov = mov.nodoSiguiente;
            }
            System.out.println("Nodo Nº " + i + ": " + mov.valor.toString());
            mov = nodoPrimero;
        }
    }


//    public void reemplazarNodo(int pos, int n) {
//        int i;
//        if ((pos0)) {
//            Nodo aux = nodoPrimero;
//            for (i = 1; (aux != null) && (i < pos); i++)
//                aux = aux.nodoSiguiente;
//            aux.numero = n;
//        } else
//            System.out.println("[Reemplazar]>Nodo no Existe");
//    }

//    public void mostrarInvertidoR(Nodo f) {
//        if (f.nodoSiguiente != null) {
//            oAsc(f.nodoSiguiente);
//        }
//        System.out.println(f.valor);
//    }


//    public void insertarNumListaOrd(int n) {    // Considerando que una lista esta ordenada
//        Nodo num = new Nodo(n);                // en forma ASC agregue un Nodo manteniendo el orden
//        Nodo i = nodoPrimero;
//        while ((n > i.valor) && (i.nodoSiguiente != null))
//            i = i.nodoSiguiente;
//        if (n <= nodoPrimero.valor) {
//            num.nodoSiguiente = nodoPrimero;
//            nodoPrimero = num;
//        } else if (n <= i.valor) {
//            num.nodoSiguiente = i;
//            mostrarNodoAnterior(i).nodoSiguiente = num;
//        } else {
//            i.nodoSiguiente = num;
//        }
//
//    }
//
//    public void eliminarNodosR() {    // Eliminar los nodos que tengan numeros repetidos
//        Nodo i, j;
//        for (i = nodoPrimero; i != null; i = i.nodoSiguiente) {
//            for (j = i.nodoSiguiente; j != null; j = j.nodoSiguiente) {
//                if (i.valor == j.valor) {
//                    mostrarNodoAnterior(j).nodoSiguiente = j.nodoSiguiente;
//                }
//            }
//        }
//    }


}
