package aed_lab5.diccionario_arboles;


import es.upm.aedlib.Pair;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import es.upm.aedlib.tree.GeneralTree;
import es.upm.aedlib.tree.LinkedGeneralTree;


public class DictImpl implements Dictionary {
    // A boolean because we need to know if a word ends in a node or not
    GeneralTree<Pair<Character, Boolean>> tree;

    public DictImpl() {
        tree = new LinkedGeneralTree<>();
        tree.addRoot(new Pair<Character, Boolean>(null, false));
    }

    public void add(String word) {
        if(word==null || word.isEmpty()){
            throw new IllegalArgumentException();
        }

        Position<Pair<Character, Boolean>> elementoActual = tree.root();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            elementoActual = posicionDelHijo(elementoActual,c);
        }
        elementoActual.element().setRight(true);
    }

    public Position<Pair<Character, Boolean>> tieneEseHijo(Position<Pair<Character, Boolean>> actual, char e) {
        for (Position<Pair<Character, Boolean>> cadahijo : tree.children(actual)) {
            if (cadahijo.element().getLeft() == e) {
                return cadahijo;
            }
        }
        return null;
    }

    // busca un char entre los hijos de un elemento
    // su lo encuentra, devuelve la posicion de dicho hijo
    // si no lo encuentra, crea un nodo en su sitio, mete el char y devuelve esa posicion nueva
    public Position<Pair<Character, Boolean>> posicionDelHijo(Position<Pair<Character, Boolean>> actual, char buscado) {
        if(tree.isExternal(actual)){
            Position<Pair<Character, Boolean>> nueva  =tree.addChildFirst(actual,new Pair<>(buscado,false));
            return nueva;
        }

        // busco en los hijos a ver si esta el char
        for (Position<Pair<Character, Boolean>> cadahijo : tree.children(actual)) {
            if (cadahijo.element().getLeft() == buscado) {
                return cadahijo;
            }
            if (cadahijo.element().getLeft() > buscado) {
                // hay que met4er ant4s de cadahijo
                Position<Pair<Character, Boolean>> nueva  =tree.insertSiblingBefore(cadahijo,new Pair<>(buscado,false));
                //actual = nueva;
                return nueva;
            }
        }
        Position<Pair<Character, Boolean>> nueva  =tree.addChildLast(actual,new Pair<>(buscado,false));
        //actual = nueva;

        return nueva;
    }


    public void delete(String word) {
        if(word==null || word.isEmpty()){
            throw new IllegalArgumentException();
        }
        Position<Pair<Character, Boolean>> actual = tree.root();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Position<Pair<Character, Boolean>> elquemiro = tieneEseHijo(actual, c);

            if (elquemiro == null) {
                return;
            }
            actual=elquemiro;
        }
        if(actual.element().getRight() == true){
            actual.element().setRight(false);
        }
    }

    public boolean isIncluded(String word) {
        if(word==null || word.isEmpty()){
            throw new IllegalArgumentException();
        }
        Position<Pair<Character, Boolean>> actual = tree.root();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Position<Pair<Character, Boolean>> elquemiro = tieneEseHijo(actual, c);

            if (elquemiro == null) {
                return false;
            }
            actual=elquemiro;
        }
        if(actual.element().getRight() == true){
            return true;
        }
        return false;
    }


    public PositionList<String> wordsBeginningWithPrefix(String prefix) {
//        if(prefix==null || prefix.isEmpty()){
//            throw new IllegalArgumentException();
//        }
        PositionList<String> lista = new NodePositionList<>();

        Position<Pair<Character, Boolean>> actual = tree.root();

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Position<Pair<Character, Boolean>> elquemiro = tieneEseHijo(actual, c);
            if (elquemiro == null) {
                return null;
            }
            actual=elquemiro;
        }
        // ya he encontrado el prefijo...
        String cadenaactual = prefix;
        if(actual.element().getRight()==true){
            // PALABRA PA DENTRO
            lista.addLast(prefix);
        }

        for (Position<Pair<Character, Boolean>> cadahijo : tree.children(actual)) {
            cadarama(cadahijo, cadenaactual, lista);
        }

        return lista;

    }

    public void cadarama(Position<Pair<Character, Boolean>> actual,  String cadenaActual,    PositionList<String> lista ){
        cadenaActual += actual.element().getLeft();
        if(actual.element().getRight()==true){
            // PALABRA PA DENTRO
            lista.addLast(cadenaActual);
        }
        // soy nodo final, no tengo hijos
        if(tree.isExternal(actual)){
            return;
        }

        // si tengo hijos, los recorro uno a uno
        for (Position<Pair<Character, Boolean>> cadahijo : tree.children(actual)) {
            cadarama(cadahijo,cadenaActual,lista);
        }

    }
}
