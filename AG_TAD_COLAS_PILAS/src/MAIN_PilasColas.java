import estructuras_jerarquicas.binary_search_trees.PintaTree;
import estructuras_jerarquicas.binary_search_trees.TAD_Arbol_busqueda_binaria;
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

public class MAIN_PilasColas {

    public static void main(String[] args) {

// ARBOLES BINARIOS
        TAD_Arbol_busqueda_binaria tree = new TAD_Arbol_busqueda_binaria();

        tree.insert(10,"10");
        tree.insert(20,"20");
        tree.insert(7 ,"7");
        tree.insert(22,"22");
        tree.insert(15,"15");
        tree.insert(61,"61");
        tree.insert(1,"1");
        tree.insert(82,"82");
        tree.insert(6,"6");
        tree.insert(12,"12");

        tree.showInOrder();
        PintaTree p = new PintaTree();
        p.printTree(tree.root, null, false);

        tree.remove(7);
        p.printTree(tree.root, null, false);

        tree.remove(22);
        p.printTree(tree.root, null, false);

        tree.remove(20);
        p.printTree(tree.root, null, false);



//        tree.print(tree.root);


//        // PILAS DINAMICAS
//        PilaDinamica<Integer> pilad = new PilaDinamica<>();
//        System.out.println(pilad.cuantosElementosHay());
//        System.out.println(pilad.esVacia());
//        pilad.push(11);
//        pilad.push(22);
//        pilad.push(33);
//        pilad.push(44);
//        pilad.push(55);
//        System.out.println(pilad.toString());
//        System.out.println(pilad.top());
//        pilad.pop();
//        System.out.println(pilad.toString());
//        System.out.println("------------------");
//        System.out.println(pilad.pop());
//        System.out.println("------------------");
//        System.out.println(pilad.toString());
//
//        pilad.vaciar();
//        System.out.println(pilad.toString());

//        // LISTAS SIMPLES
//        ListaSimple<Integer> listas = new ListaSimple<>();
//        System.out.println(listas.size());
//        listas.insertLast(11);
//        listas.insertLast(22);
//        listas.insertLast(33);
//        listas.insertLast(44);
//        listas.insertLast(55);
//        listas.toString();
//        listas.insertFirst(00);
//        listas.toString();
//        listas.insertPosition(2, 99);
//        listas.toString();
//
//        System.out.println(listas.size());
//
//        NodoLista n = listas.getLast();
//        System.out.println(n);
//        NodoLista ant = listas.getBefore(n);
//        System.out.println(ant);
//
//        listas.deleteFirst();
//        listas.toString();
//
//        listas.deleteLast();
//        listas.toString();
//
//        listas.deletePosition(2);
//        listas.toString();
//
//        listas.deleteValue(33);
//        listas.toString();
//
//        listas.mostrarListaInversa();
//
//        listas.deleteAll();
//        listas.toString();


//        // listas doblemente enlazadas
//        ListaDoblementeEnlazada ld = new ListaDoblementeEnlazada();
//
//        ld.addFirst(22);
//        ld.addFirst(11);
//        ld.insert(1,33);
//        ld.insert(4,44);
//        ld.insert(5,55);
//        ld.insert(8,55);
//        System.out.println(ld.toString());
//
//        ld.addLast(99);
//        System.out.println(ld.toString());
//
//        ld.delete(2);
//        System.out.println(ld.toString());
//
//        System.out.println(ld.extract(3));
//
//        ld.exchange(1,2);
//        System.out.println(ld.toString());

//        // listas doblemente enlazadas CON CENTINELAS
//        ListaDobleCentinelas lc = new ListaDobleCentinelas();
//
//        lc.addFirst(22);
//        lc.addFirst(11);
//        lc.addLast(33);
//        lc.addLast(44);
//        lc.addLast(55);
//        lc.addLast(66);
//        lc.addLast(77);
//        lc.addLast(88);
//        System.out.println(lc.toString());
//
//        lc.removeFirst();
//        lc.removeLast();
//        System.out.println(lc.toString());
//
//        System.out.println(lc.extractFirst());
//        System.out.println(lc.extractLast());
//        System.out.println(lc.toString());
//
//        System.out.println(lc.extract(1));
//        System.out.println(lc.toString());



    }

}
