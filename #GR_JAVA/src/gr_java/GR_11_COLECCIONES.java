package gr_java;
import java.util.*;

public class GR_11_COLECCIONES {


    public static void main(String[] args) {

        // ===================================================================
        //   LISTAS          ( ARRAYLIST)     Otras listas: Vector, LinkedList
        // ===================================================================

        ArrayList<String> lista = new ArrayList<>();        // CREAR UN ARRAYLIST VACIO
        ArrayList<Integer> lista2 = new ArrayList<>();

        lista.add("Pepe");             // AÑADIR A ARRAYLIST : la primera posicion es la 0.....
        lista.add("Ana");
        lista.add("Paco");
        lista.add("Luis");
        lista.add("Anastasia ");

        lista.add(3, "Ana");            // INSERTAR EN ARRAYLIST

        lista.set(2, "Eva");           // SUSTITUIR EN ARRAYLIST

        int tam = lista.size();              // TAMAÑO DE ARRAYLIST

        String cc = lista.get(3);               // RECUPERAR UN ELEMENTO DE UN ARRAYLIST

        lista.remove(3);                   //  BORRAR EN UN ARRAYLIST : borra la posicion 3
        lista.remove("Pepe");               //  BORRAR EN UN ARRAYLIST : borra SOLO LA PRIMERA ocurrencia de Pepe

        if (lista.contains("Ana")) {              // CONSULTAR SI EXIST UN ELEMENTO EN UN ARRAYLIT
            // ....
        }

        lista.clear();                              // VACIAR UN ARRAYLIST

        for (int i = 0; i < lista.size(); i++) {  // RECORRER UN ARRAYLIST
            String ss = lista.get(i);
            System.out.println(ss);
        }

        for (String s : lista) {                  // RECORRER UN ARRAYLIST FOR EACH
            System.out.println(s);
        }




        // ==============================================================================
        //   SETS           ( TREESET )         Otros conjuntos: HashSet, LinkedHashSet
        // ==============================================================================

        TreeSet<String> conj = new TreeSet<>(); // CREAR UN ARRAYLIST VACIO
        HashSet<Avion> conj2 = new HashSet<>(); // objeto piso

        conj.add("Pepe");                       // AÑADIR A UN TREESET . No hay posicion
        conj.add("Ana");
        conj.add("Luis");
        conj.add("Juan");
        conj.add("Lola");
        conj.add("Carlos");

        int tam2 = conj.size();             // TAMAÑO DE TREESET

        conj.remove("Pepe");                  //  BORRAR EN UN TREESET : borra la única ocurrencia de Pepe

        for (String s : conj) {                // RECORRER UN TREESET FOR EACH
            System.out.println(s);             // Al recorrer con for each, SOLO SI ES un treeset, SALEN ORDENADOS
        }                                      // pero NO VALE PARA CLASES PROPIAS si no tienen un comparador


        if (conj.contains("Ana")) {              // CONSULTAR SI EXIST UN ELEMENTO EN UN TREESET
            // ....
        }

        conj.clear();     // VACIAR UN TREESET


        // ==============================================================================
        //   MAPAS           ( HASHMAP )         Otros conjuntos: TreeMap, HashTable
        // ==============================================================================

        // MAPAS  - almacenan DOS COLECCIONES; la clave de un elemento y el valor del elemento
        // ejemplo - guardo el nombre de un jugador y como clave su numero de dorsal
        TreeMap<Integer, String> mapa = new TreeMap<>();

        mapa.put(12, "JUANILLO");           // AÑADIR A UN TREESET . No hay posicion
        mapa.put(34, "PAQUITO");

        int tama = mapa.size();             // TAMAÑO DE TREESET

        String nom = mapa.get(34);           // RECUPERAR UN ELEMENTO DE UN ARRAYLIST

        mapa.remove(12);                 //  BORRAR EN UN TREESET : borra la única ocurrencia de Pepe

        mapa.clear();                      // VACIAR UN TREESET

        if (mapa.containsKey(33)) {               // CONSULTAR SI EXIST UNA CLAVE EN UN TREESET
            // ....
        }
        if (mapa.containsValue("PACO")) {           // CONSULTAR SI EXIST UN VALOR EN UN TREESET
            // ....
        }

        for (Integer clave : mapa.keySet()) {    // RECORRER UN MAPA: RECORRER LAS CLAVES
            String valor = mapa.get(clave);
        }
        for (String valor : mapa.values()) {    // RECORRER UN MAPA: RECORRER LOS VALORES

        }

        // ==============================================================================
        //   ITERATOR
        // ==============================================================================

        ArrayList<Avion> aviones = new ArrayList<>();    // ITERATOR con un ARRAYLIST
        Iterator<Avion> it = aviones.iterator();
        while (it.hasNext()) {
            Avion a = it.next();
            if (a.getNummotores() > 3) {
                it.remove();
            }
        }

        TreeSet<Avion> avioncillos = new TreeSet<>(); // ITERATOR con un ARRAYLIST
        Iterator<Avion> iter = avioncillos.iterator();
        while (iter.hasNext()) {
            Avion a = iter.next();
            if (a.getNummotores() > 3) {
                iter.remove();
            }
        }

        TreeMap<Integer, String> mimapa = new TreeMap<>();
        Iterator<Integer> it3 = mimapa.keySet().iterator(); // ITERATOR con un MAPAS: recorrer las CLAVES
        while (it3.hasNext()) {
            int clave = it3.next();
            // ....
        }
        Iterator<String> it4 = mimapa.values().iterator();  // ITERATOR con un MAPAS: recorrer los VALORES
        while (it4.hasNext()) {
            String valor = it4.next();
            // ....
        }


        // ==============================================================================
        //   ENTRY.SET
        // ==============================================================================
        HashMap<String, Avion> mapaaviones = new HashMap<>();
        mapaaviones.put("1", new Avion("U776", 2));

        for (Map.Entry<String, Avion> cosa : mapaaviones.entrySet()) {
            System.out.println(" la clave es " + cosa.getKey());
            System.out.println(" el valor es  " + cosa.getValue().toString());
        }



        // ==============================================================================
        //   ORDENANDO : ARRAYS
        // ==============================================================================
        System.out.println("-- Ordenando ARRAYS tipos PRIMITIVOS o de JAVA");
        String[] p = new String[3];
        p[0] = "Luis";
        p[1] = "Pablo";
        p[2] = "Alberto";
        // usando el metodo Arrays.sort(array)
        Arrays.sort(p);
        for (String mm : p) {
            System.out.println(mm);
        }

        System.out.println("-- Ordenando ARRAYS tipos PROPIOS");
        Avion[] q = new Avion[3];
        q[0] = new Avion("B123", 2);
        q[1] = new Avion("H77", 4);
        q[2] = new Avion("H889", 6);
        // Para objetos de clases propias, LA CLASE AVION
        // 1.- IMPLEMENTAR COMPARABLE<AVION> y tras sobrescribir compareTo()
        // uasr el metodo Arrays.sort(array)
        Arrays.sort(q);
        for (Avion mm : q) {
            System.out.println(mm);
        }
        // 2.- CREAR CLASE QUE IMPLEMENTE COMPARATOR<AVION> y tras sobrescribir compare(Avion o1, Avion o2)
        // usar el metodo Arrays.sort(array , objetocomparator)
        Arrays.sort(q, new ModeloComparador());
        for (Avion mm : q) {
            System.out.println(mm);
        }




        // ==============================================================================
        //   ORDENANDO : LISTAS
        // ==============================================================================
        System.out.println("-- Ordenando LISTAS tipos PRIMITIVOS o de JAVA");
        List<String> p1 = new ArrayList<>();
        p1.add ("Luis");
        p1.add ("Pablo");
        p1.add ("Alberto");

        // usando el metodo Collections.sort(arraylist)
        Collections.sort (p1);  // usando  Collections.sort() 
        Collections.sort (p1, Collections.reverseOrder() );  // usando  Collections.sort() EN REVERSED
        for (String aa : p1){
            System.out.println (aa);
        }

        System.out.println("-- Ordenando LISTAS tipos PROPIOS");
        List<Avion> p2 = new ArrayList<>();
        p2.add(new Avion("B123", 2));
        p2.add(new Avion("H77", 4));
        p2.add(new Avion("H889", 6));
        // Para objetos de clases propias, LA CLASE AVION
        // 1- IMPLEMENTAR COMPARABLE<AVION> y tras sobrescribir compareTo()
        // uasr el metodo Collections.sort(arraylist)
        Collections.sort (p2);
        for (Avion aa : p2){
            System.out.println (aa);
        }

        // 2.- CREAR CLASE QUE IMPLEMENTE COMPARATOR<AVION> y tras sobrescribir compare(Avion o1, Avion o2)
        // usar el metodo Arrays.sort(array , objetocomparator)
        Collections.sort (p2, new ModeloComparador());
        for (Avion aa : p2){
            System.out.println (aa);
        }

        //  Tambien se puede usafr el moderno metodo comparign() SIN CREAR CLASE PROPIA COMPARATOR
        Comparator<Avion> pormotor = Comparator.comparing(a -> a.getNummotores());
        // o si se tiene getter
        Comparator<Avion> pormotor2 = Comparator.comparing(Avion::getNummotores);

        // 3.- INVERTIR EL ORDEN QUE TUVIERAN, NO ORDENA, PERO INVIERTE LA POSICION DE LOS ELEMENTOS
        // Evidentemente, si estaban ya oredandos, esto provoca una ordenadion invesa a la existente 
        // usar el metodo Arrays.reverse(array)
        Collections.reverse (p2);
    

        // ==============================================================================
        //   ORDENANDO : CONJUNTOS
        // ==============================================================================
        System.out.println("-- Ordenando CONJUNTOS tipos PRIMITIVOS o de JAVA");
        Set<String> s1 = new TreeSet<>();
        s1.add ("Luis");
        s1.add ("Pablo");
        s1.add ("Alberto");
        // CON TREESET ESTAN ORDENADOS AUTOMATICAMENTE LOS PRIMITIVOS O DE JAVA
        // SIN TREESET NO SE PUEDEN ORDENAR
        for (String aa : p1){
            System.out.println (aa);
        }


        System.out.println("-- Ordenando CONJUNTOS tipos PROPIOS");
        Set<Avion> s2 = new TreeSet<>();
        s2.add(new Avion("B123", 2));
        s2.add(new Avion("H77", 4));
        s2.add(new Avion("H889", 6));
        // CON TREESET Para objetos de clases propias, LA CLASE AVION
        // 1- IMPLEMENTAR COMPARABLE<AVION> y tras sobrescribir compareTo()
        // NO HACER NADA MAS
        for (Avion aa : p2){
            System.out.println (aa);
        }

        // 2.- CREAR CLASE QUE IMPLEMENTE COMPARATOR<AVION> y tras sobrescribir compare(Avion o1, Avion o2)
        // usar un objeto de nuestra clase en el constructor del TreeSet:
        Set<Avion> s3 = new TreeSet<>( new ModeloComparador());
        s3.add(new Avion("B123", 2));
        s3.add(new Avion("H77", 4));
        s3.add(new Avion("H889", 6));
        // NO HACER NADA MAS
        for (Avion aa : p2){
            System.out.println (aa);
        }




        // ==============================================================================
        //   ORDENANDO : MAPAS
        // ==============================================================================

        // Solo pueden ordenarse las claves, y solo con TreeMap
        // Se hace igual que con los conjuntos


    }

}

//Clases auxiliares para los ejemplos
class Avion implements Comparable<Avion>{

    private String nombre;
    private int nummotores;

    public Avion(String nombre, int nummotores) {
        this.nombre = nombre;
        this.nummotores = nummotores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNummotores() {
        return nummotores;
    }

    public void setNummotores(int nummotores) {
        this.nummotores = nummotores;
    }

    @Override
    public String toString() {
        return "guias_java.Avion{" +
                "nombre='" + nombre + '\'' +
                ", nummotores=" + nummotores +
                '}';
    }

    @Override
    public int compareTo(Avion o) {
        return this.nombre.compareTo(o.nombre);
    }
}


class ModeloComparador implements Comparator<Avion>{
    @Override
    public int compare(Avion o1, Avion o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}