package estructuras_dinamicas.lista_dinamica_doblementeenlazada;

// una lista doblemente enlazada tiene dos nodos para apuntar
// a quien tiene delante y a quien tiene detras
// no es ni una estructura FIFO ni LIFO,
// se peuden meter elementos al inicio, al final o en medio
// y se pueden extraer elementos del inicio, del final o del medio

public class TAD_ListaDoblementeEnlazada<T> {
    private NodoListaDoble root;

    public TAD_ListaDoblementeEnlazada() {
        root = null;
    }

    public void addFirst(T x) {
        // tambien se podria hacer poniendo solo: insert(1,x)
        NodoListaDoble newnode = new NodoListaDoble(x);
        if (root == null) {
            root = newnode;
        } else {
            root.ant = newnode;
            newnode.sig = root;
            root = newnode;
        }
    }

    public void addLast(T x) {
        if (root == null) {
           insert(1,x);
        } else {
           insert( size()+1,x);
        }
    }

    public void insert(int pos, T x) {
        if (pos <= size() + 1) {
            NodoListaDoble nuevo = new NodoListaDoble(x);
            if (pos == 1) {
                nuevo.sig = root;
                if (root != null)
                    root.ant = nuevo;
                root = nuevo;
            } else if (pos == size() + 1) {
                NodoListaDoble reco = root;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = null;
            } else {
                NodoListaDoble reco = root;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                NodoListaDoble siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = siguiente;
                siguiente.ant = nuevo;
            }
        }
    }

    public T extract(int pos) {
        if (pos <= size()) {
            T informacion;
            if (pos == 1) {
                informacion = (T) root.info;
                root = root.sig;
                if (root != null)
                    root.ant = null;
            } else {
                NodoListaDoble reco;
                reco = root;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                NodoListaDoble prox = reco.sig;
                reco.sig = prox.sig;
                NodoListaDoble siguiente = prox.sig;
                if (siguiente != null)
                    siguiente.ant = reco;
                informacion = (T) prox.info;
            }
            return informacion;
        }

        return null;
    }

    public void delete(int pos) {
        if (pos <= size()) {
            if (pos == 1) {
                root = root.sig;
                if (root != null)
                    root.ant = null;
            } else {
                NodoListaDoble reco;
                reco = root;
                for (int f = 1; f <= pos - 2; f++)
                    reco = reco.sig;
                NodoListaDoble prox = reco.sig;
                prox = prox.sig;
                reco.sig = prox;
                if (prox != null)
                    prox.ant = reco;
            }
        }
    }

    public void exchange(int pos1, int pos2) {
        if (pos1 <= size() && pos2 <= size()) {
            NodoListaDoble reco1 = root;
            for (int f = 1; f < pos1; f++)
                reco1 = reco1.sig;
            NodoListaDoble reco2 = root;
            for (int f = 1; f < pos2; f++)
                reco2 = reco2.sig;
            T aux = (T) reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }


    public int size() {
        int cant = 0;
        NodoListaDoble reco = root;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }


    public boolean contains(T x) {
        NodoListaDoble reco = root;
        while (reco != null) {
            if (reco.info.equals(x))
                return true;
            reco = reco.sig;
        }
        return false;
    }

    public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }

    public String toString() {
        NodoListaDoble reco = root;
        String res = "";
        while (reco != null) {
            res = res + reco.info + "-";
            reco = reco.sig;
        }
        return res;
    }


}
