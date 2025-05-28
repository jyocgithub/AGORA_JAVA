package estructuras_jerarquicas.binary_search_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TAD_Arbol_busqueda_binaria {
    public NodoArbolB root;

    public TAD_Arbol_busqueda_binaria() {
    }

    // el tamaño de un nodo es el tamaño del arbol que cuelga de el como si fuera el raiz
    public int getSize() {
        return getSize(root);
    }

    public int getSize(NodoArbolB node) {
        if (node == null) return 0;
        else return 1 + getSize(node.left) + getSize(node.right);
    }

    // la altura de un nodo es la longitud de la rama mas larga,
    // incluido el propio nodo raiz usado como referencia
    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(NodoArbolB node) {
        if (node == null) return 0;
        else return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // la profundidad es el numero de predecesores que tiene un nodo, incluyendo la raiz del arbol
    public int getDepth() {
        return getDepth(root);
    }

    public int getDepth(NodoArbolB node) {
        int depth = 0;
        NodoArbolB nodeaux = node.parent;
        while (nodeaux != null) {
            depth++;
            nodeaux = nodeaux.parent;
        }
        return depth;
    }

    // mostrar IN-ORDER significa mostrar rama-izda + nodo-actual + rama-dcha
    public void showInOrder() {
        showInOrder(root);
        System.out.println();
    }

    public void showInOrder(NodoArbolB node) {
        if (node != null) {
            showInOrder(node.left);
            System.out.println(node);
//            System.out.println(node.key + "." + node.elem);
            showInOrder(node.right);
        }
    }

    // mostrar PRE-ORDER significa mostrar  nodo-actual + rama-izda + rama-dcha
    public void showPreOrder() {
        showInOrder(root);
        System.out.println();
    }

    public void showPreOrder(NodoArbolB node) {
        if (node != null) {
            System.out.println(node.key + "." + node.elem);
            showPreOrder(node.left);
            showPreOrder(node.right);
        }
    }

    // mostrar POST-ORDER significa mostrar  rama-izda + rama-dcha +  nodo-actual
    public void showPostOrder() {
        showPostOrder(root);
        System.out.println();
    }

    public void showPostOrder(NodoArbolB node) {
        if (node != null) {
            showPostOrder(node.left);
            showPostOrder(node.right);
            System.out.println(node.key + "." + node.elem);
        }
    }

    // buscar el contenido de un nodo sabiendo su clave
    public String find(Integer key) {
        return find(root, key);
    }

    public String find(NodoArbolB node, Integer key) {
        String res = null;
        if (node != null) {
            int comparacion = key.compareTo(node.key);
            if (comparacion == 0) {
                return node.elem;
            } else if (comparacion < 0) {
                find(node.left, key);
            } else {
                find(node.right, key);
            }
        }
        return res;
    }


    // insert hace una insercion binario en el arbol
    public void insert(Integer key, String elem) {
        NodoArbolB newnode = new NodoArbolB(key, elem);
        if (root == null) {
            root = newnode;
        } else {
            insert(newnode, root);
        }
    }

    public void insert(NodoArbolB newnode, NodoArbolB currentNode) {
        if (newnode.key == currentNode.key) {
            System.out.println("La clave ya existe, no se inserta nada");
            return;
        } else if (newnode.key < currentNode.key) {
            if (currentNode.left == null) {
                currentNode.left = newnode;
                newnode.parent = currentNode;
            } else {
                insert(newnode, currentNode.left);
            }
        } else {
            if (currentNode.right == null) {
                currentNode.right = newnode;
                newnode.parent = currentNode;
            } else {
                insert(newnode, currentNode.right);
            }
        }
    }

    public void remove(int key) {
        if (root == null) {
            System.out.println("No se puede borrar nada pues el arbol esta vacio");
        } else {
            // borrar el raiz.  Es un caso especial que se trata aqui
            if (root.key == key) {
                // si la raiz no tiene hijos, para borrarla, simplemente la ponemos a null
                if (root.left == null && root.right == null) {
                    root = null;
                    // si la raiz no tiene rama izquierda pero si derecha
                } else if (root.left == null && root.right != null) {
                    root = root.right;
                    root.parent = null;
                    // si la raiz no tiene rama derecha pero si izquierda
                } else if (root.left != null && root.right == null) {
                    root = root.left;
                    root.parent = null;
                } else {
                    removeInnerNode(key, root);
                }
            } else {
                // borrar un nodo no raiz.
                removeInnerNode(key, root);
            }
        }
    }

    public boolean removeInnerNode(int key, NodoArbolB currentNode) {
        // Primero buscamos el nodo a borrar con llamadas recursivas a este metodo remove
        // Si encontramos un nodo null es que la clave buscada no existe
        if (currentNode == null) {
            System.out.println("La clave buscada no existe");
            return false;
        } else if (key < currentNode.key) {
            return removeInnerNode(key, currentNode.left);
        } else if (key > currentNode.key) {
            return removeInnerNode(key, currentNode.right);
        }

        // Si se llega hasta aqui es que se ha encontrado el nodo......
        // 3 casos a probar

        // caso 1; el nodo a borrar es un nodo hoja (sin descendientes)
        // se ha de decir al padre que su hijo no existe, pero cuidado, el padre tiene dos hijos, hay que eliminar solo el que conviene
        if (currentNode.left == null && currentNode.right == null) {
            NodoArbolB father = currentNode.parent;
            if (father.left == currentNode) { // el nodo a eliminar es un hijo izdo
                father.left = null;
            } else {                          // el nodo a eliminar es un hijo dcho
                father.right = null;
            }
            return true;
        }

        // caso 2; el nodo a borrar tiene un unico hijo
        // se conecta el hijo del nodo a borrar al padre del nodo a borrar
        if (currentNode.left == null || currentNode.right == null) {  // no pueden ser los dos null, eso ya se trato antes
            NodoArbolB sonOfCurrentNode;
            if (currentNode.right == null) {                // solo tiene hijo izdo
                sonOfCurrentNode = currentNode.left;
            } else {                                        // solo tiene hijo dcho
                sonOfCurrentNode = currentNode.right;

            }
            // ponemos al hjo del nodo actual como hijo del padre del nodo actual
            NodoArbolB father = currentNode.parent;
            if (father.left == currentNode) { // el nodo a eliminar es un hijo izdo
                father.left = sonOfCurrentNode;
            } else {                                           // el nodo a eliminar es un hijo dcho
                father.right = sonOfCurrentNode;
            }
            return true;


        }
        // caso 3; el nodo a borrar tiene dos hijos
        // hay que buscar, en la rama de su hijo derecho,  el nodo con la key mas pequeña (llamemosle candidato)
        NodoArbolB candidateNode = currentNode.right;  // elegimos la rama derecha del nodo actual
        while (candidateNode.left != null) {            // buscamos el valor minimo, que es ir "cayendo" hacia la izda hasta un nodo hoja
            candidateNode = candidateNode.left;
        }
        // y luego se sustituyen los valores del nodo a borrar por los del candidato, y se borra el candidado de su padre
        // como no movemos nada, solo cambiamos los valores de currentNode, el padre del currentNode no hay que tocarlo
        currentNode.elem = candidateNode.elem;
        currentNode.key = candidateNode.key;

        removeInnerNode(candidateNode.key, currentNode.right);
//        candidateNode.parent.left=null;    // otra version del remove de la linea anterior
        return true;
    }


    /**
     * Print a tree
     *
     * @param root tree root node
     */
    public void print(NodoArbolB root) {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<NodoArbolB> level = new ArrayList<NodoArbolB>();
        List<NodoArbolB> next = new ArrayList<NodoArbolB>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (NodoArbolB n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.elem;
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<NodoArbolB> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
//                        if (line.get(j - 1) != null) {
//                            c = (line.get(j) != null) ? '┴' : '┘';
//                        } else {
//                            if (j < line.size() && line.get(j) != null) c = '└';
//                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }


    public List<List<String>> printTree(NodoArbolB root) {
        List<List<String>> res = new LinkedList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, columns = (int) (Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) row.add("");
        for (int i = 0; i < rows; i++) res.add(new ArrayList<>(row));
        populateRes(root, res, 0, rows, 0, columns - 1);
        return res;
    }

    public void populateRes(NodoArbolB root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null) return;
        res.get(row).set((i + j) / 2, root.elem);
        populateRes(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
        populateRes(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
    }

}






