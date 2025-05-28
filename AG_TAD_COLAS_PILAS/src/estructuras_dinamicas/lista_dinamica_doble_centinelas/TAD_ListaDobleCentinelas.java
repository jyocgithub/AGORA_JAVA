package estructuras_dinamicas.lista_dinamica_doble_centinelas;

// una lista doblemente enlazada tiene dos nodos para apuntar
// a quien tiene delante y a quien tiene detras
// no es ni una estructura FIFO ni LIFO,
// se peuden meter elementos al inicio, al final o en medio
// y se pueden extraer elementos del inicio, del final o del medio


public class TAD_ListaDobleCentinelas<T> {
    private NodoListaCentinelas header;
    private NodoListaCentinelas trailer;

    public TAD_ListaDobleCentinelas() {
        header = new NodoListaCentinelas(null);
        trailer = new NodoListaCentinelas(null);
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public void addFirst(T x) {
        NodoListaCentinelas newnode = new NodoListaCentinelas(x);
        if (isEmpty()) {
            header.next = newnode;
            trailer.prev = newnode;
        } else {
            newnode.next = header.next;
            newnode.prev = header;
            header.next.prev = newnode;
            header.next = newnode;
        }
    }

    public void addLast(T x) {
        NodoListaCentinelas newnode = new NodoListaCentinelas(x);
        if (isEmpty()) {
            header.next = newnode;
            trailer.prev = newnode;
        } else {
            newnode.next = trailer;
            newnode.prev = trailer.prev;
            trailer.prev.next = newnode;
            trailer.prev = newnode;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        header.next = header.next.next;
        header.next.prev = header;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }
        header.next = header.next.next;
        header.next.prev = header;
    }

    public T extractFirst() {
        if (isEmpty()) {
            return null;
        }
        NodoListaCentinelas nodo = header.next;
        header.next = header.next.next;
        header.next.prev = header;
        return (T) nodo;
    }

    public T extractLast() {
        if (isEmpty()) {
            return null;
        }
        NodoListaCentinelas nodo = trailer.prev;
        header.next = header.next.next;
        header.next.prev = header;
        return (T) nodo;
    }

    public int size() {
        int cant = 0;
        NodoListaCentinelas reco = header;
        while (reco != null) {
            reco = reco.next;
            cant++;
        }
        return cant - 2;
    }


    // consideremos que las posiciones se numeran desde 1 en adelante
    void insert(int pos, T x) {
        if (isEmpty()) {
            addFirst(x);
        } else {
            if (pos <= size()) {
                NodoListaCentinelas nuevo = new NodoListaCentinelas(x);
                NodoListaCentinelas reco = header.next;
                int cant = 0;
                while (reco != null) {
                    reco = reco.next;
                    cant++;
                }

                reco.prev.next = nuevo;
                nuevo.prev = reco;
                reco.prev = nuevo;
                nuevo.next = reco;
            }
        }
    }

    public T extract(int pos) {
        if (pos <= size()) {

            NodoListaCentinelas reco = header.next;
            int cant = 0;
            while (cant<pos-1) {
                reco = reco.next;
                cant++;
            }
            NodoListaCentinelas tempnext = reco.next;
            T informacion = (T) reco.info;
            reco.prev.next = reco.next;
            reco.next.prev = reco.prev;
            return informacion;
        }
        return null;
    }


    public String toString() {
        String res = "[";
        NodoListaCentinelas reco = header.next;
        while (reco.next != null) {
            res = res + reco.info + ",";
            reco = reco.next;
        }
        return res+"]";
    }

}
