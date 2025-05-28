package aed_lab2.polinomios;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

import java.util.Objects;
import java.util.TreeMap;


/**
 * Operaciones sobre polinomios de una variable con coeficientes enteros.
 */
public class Polinomio {


    // Una lista de monomios
    PositionList<Monomio> terms;

    public static final int OPERACION_SUMA = 0;
    public static final int OPERACION_RESTA = 1;

    /**
     * Crea el polinomio "0".
     */
    public Polinomio() {
        terms = new NodePositionList<>();
    }

    /**
     * Crea un polinomio definado por una lista con monomios.
     *
     * @param terms una lista de monomios
     */
    public Polinomio(PositionList<Monomio> terms) {
        this.terms = terms;
    }

    /**
     * Crea un polinomio definado por un String.
     * La representación del polinomio es una secuencia de monomios separados
     * por '+' (y posiblemente con caracteres blancos).
     * Un monomio esta compuesto por tres partes,
     * el coefficiente (un entero), el caracter 'x' (el variable), y el exponente
     * compuesto por un un caracter '^' seguido por un entero.
     * Se puede omitir multiples partes de un monomio,
     * ejemplos:
     * <pre>
     * {@code
     * new Polinomio("2x^3 + 9");
     * new Polinomio("2x^3 + -9");
     * new Polinomio("x");   // == 1x^1
     * new Polinomio("5");   // == 5x^0
     * new Polinomio("8x");  // == 8x^1
     * new Polinomio("0");   // == 0x^0
     * }
     * </pre>
     *
     * @param polinomio - una secuencia de monomios separados por '+'
     * @throws IllegalArgumentException si el argumento es malformado
     */
    public Polinomio(String polinomio) {
            terms = new NodePositionList<>();
        if (polinomio.trim().isEmpty() || polinomio.trim().equals("0")) {
            return;
        }
        String coef, expo;
        String[] trozos = polinomio.split("\\s|\\+");
        for (int i = 0; i < trozos.length; i++) {

            String trozo = trozos[i].toLowerCase().trim().replace("+","");
            if (!trozo.isEmpty()) {

                if (trozo.contains("x^")) {
                    coef = trozo.substring(0, trozo.indexOf("x"));
                    expo = trozo.substring(trozo.indexOf("x") + 2);
                } else  if (trozo.contains("x")) {
                    coef = trozo.substring(0, trozo.indexOf("x"));
                    expo = trozo.substring(trozo.indexOf("x") + 1);
                } else {
                    coef = trozo;
                    expo = "0";
                }
                if(coef.isEmpty()){
                    coef="1";
                }
                if(expo.isEmpty()){
                    expo="1";
                }
                Monomio m = new Monomio(Integer.parseInt(coef), Integer.parseInt(expo));
                terms.addLast(m);

            }
        }


    }

    /**
     *
     * @param p1
     * @return
     */
//  private static Polinomio imprimir(Polinomio p1){
//    PositionList<Monomio> nuevalista = new NodePositionList<>();
//    while(p1.terms.){
//
//    }
//    Polinomio resultado = new Polinomio(nuevalista);
//    return resultado;
//  }

    /**
     * Suma dos polinomios.
     *
     * @param p1 primer polinomio.
     * @param p2 segundo polinomio.
     * @return la suma de los polinomios.
     */


    public static Polinomio suma(Polinomio p1, Polinomio p2) {
        return sumaresta(p1, p2, OPERACION_SUMA);
    }


    public static void agregarAlFinal(PositionList<Monomio> lista, Monomio monomio, int operacion) {
        int nuevocoef = monomio.getCoeficiente();
        if (operacion == OPERACION_RESTA) {
            nuevocoef = nuevocoef * -1;
        }
        if (nuevocoef != 0) {

            Monomio nuevomono = new Monomio(nuevocoef, monomio.getExponente());
            lista.addLast(nuevomono);
        }
    }


    public static Polinomio sumaresta(Polinomio p1, Polinomio p2, int operacion) {
        PositionList<Monomio> nuevalista = new NodePositionList<>();
        boolean seguir = true;
        int puntero1 = 0;
        int puntero2 = 0;
        int coef1, coef2;
        Position<Monomio> mono1, mono2, q1, q2, ultimoMonomioAgregado = null;

        mono1 = p1.terms.first();
        mono2 = p2.terms.first();

        while (seguir) {

            //si uno de los dos polinomios es 0
            if (p1.terms.isEmpty()) {
                while (mono2 != null) {
                    agregarAlFinal(nuevalista, mono2.element(), operacion);
                    mono2 = p2.terms.next(mono2);
                }
                seguir = false;
            } else if (p2.terms.isEmpty()) {
                while (mono1 != null) {
                    nuevalista.addLast(mono1.element());
                    mono1 = p1.terms.next(mono1);
                }
                seguir = false;
            } else {

                if (mono1.element().getExponente() == mono2.element().getExponente()) {
                    int resultado = 0;
                    if (operacion == OPERACION_SUMA) {
                        resultado = mono1.element().getCoeficiente() + mono2.element().getCoeficiente();
                    }
                    if (operacion == OPERACION_RESTA) {
                        resultado = mono1.element().getCoeficiente() - mono2.element().getCoeficiente();
                    }
                    Monomio m = new Monomio(resultado, mono1.element().getExponente());
                    agregarAlFinal(nuevalista, m, OPERACION_SUMA);
                    if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) != null && p2.terms.next(mono2) != null) {
                        mono1 = p1.terms.next(mono1);
                        mono2 = p2.terms.next(mono2);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) != null && p2.terms.next(mono2) == null) {
                        while (p1.terms.next(mono1) != null) {
                            agregarAlFinal(nuevalista, p1.terms.next(mono1).element(), OPERACION_SUMA);

                            mono1 = p1.terms.next(mono1);
                        }
                        seguir = false;

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) == null && p2.terms.next(mono2) != null) {
                        while (p2.terms.next(mono2) != null) {
                            agregarAlFinal(nuevalista, p2.terms.next(mono2).element(), operacion);
                            mono2 = p2.terms.next(mono2);
                        }
                        seguir = false;

                    } else if (mono1.element().getExponente() == 0 && mono2.element().getExponente() != 0 && p2.terms.next(mono2) != null) {
                        mono2 = p2.terms.next(mono2);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() == 0 && p1.terms.next(mono1) != null) {
                        mono1 = p1.terms.next(mono1);

                    } else if (p1.terms.next(mono1) == null && p2.terms.next(mono2) == null) {
                        seguir = false;
                    }

                } else if (mono1.element().getExponente() > mono2.element().getExponente()) {
                    nuevalista.addLast(mono1.element());

                    if (mono1.element().getExponente() != 0 && p1.terms.next(mono1) != null) {
                        mono1 = p1.terms.next(mono1);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) != null && p2.terms.next(mono2) == null) {
                        mono1 = p1.terms.next(mono1);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) == null && p2.terms.next(mono2) != null) {
                        mono2 = p2.terms.next(mono2);

                    } else if (mono1.element().getExponente() == 0 && mono2.element().getExponente() != 0 && p2.terms.next(mono2) != null) {
                        mono2 = p2.terms.next(mono2);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() == 0 && p1.terms.next(mono1) != null) {
                        mono1 = p1.terms.next(mono1);

                    } else if (p1.terms.next(mono1) == null && p2.terms.next(mono2) == null) {
                        agregarAlFinal(nuevalista, mono2.element(), operacion);
                        seguir = false;
                    }

                } else if (mono1.element().getExponente() < mono2.element().getExponente()) {
                    agregarAlFinal(nuevalista, mono2.element(), operacion);
                    if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) != null && p2.terms.next(mono2) != null) {
                        mono2 = p2.terms.next(mono2);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) != null && p2.terms.next(mono2) == null) {
                        mono1 = p1.terms.next(mono1);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() != 0 && p1.terms.next(mono1) == null && p2.terms.next(mono2) != null) {
                        mono2 = p2.terms.next(mono2);

                    } else if (mono1.element().getExponente() == 0 && mono2.element().getExponente() != 0 && p2.terms.next(mono2) != null) {
                        mono2 = p2.terms.next(mono2);

                    } else if (mono1.element().getExponente() != 0 && mono2.element().getExponente() == 0 && p1.terms.next(mono1) != null) {
                        mono1 = p1.terms.next(mono1);

                    } else if (p1.terms.next(mono1) == null && p2.terms.next(mono2) == null) {
                        nuevalista.addLast(mono1.element());
                        seguir = false;
                    }

                }
            }
        }

        Polinomio resultado = new Polinomio(nuevalista);
        return resultado;


    }

    /**
     * Substraccion de dos polinomios.
     *
     * @param p1 primer polinomio.
     * @param p2 segundo polinomio.
     * @return la resta de los polinomios.
     */
    public static Polinomio resta(Polinomio p1, Polinomio p2) {
        return sumaresta(p1, p2, OPERACION_RESTA);
    }

    public static TreeMap<Integer, Integer> conviertePoliMapa(Polinomio poliIntermedio) {
        Position<Monomio> mono = poliIntermedio.terms.first();
        TreeMap<Integer, Integer> mapa = new TreeMap<>();
        while (mono != null) {
            int coef = mono.element().getCoeficiente();
            int expo = mono.element().getExponente();
            mapa.put(expo, coef);
            mono = poliIntermedio.terms.next(mono);
        }
        return mapa;
    }

    /**
     * Calcula el producto de un monomio y un polinomio.
     *
     * @param p1 el monomio
     * @param p2 el polinomio
     * @return el producto del monomio y el polinomio
     */
    public static Polinomio multiplica(Polinomio p1, Polinomio p2) {

        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p2;
        }


        PositionList<Monomio> nuevalista = new NodePositionList<>();

        boolean seguir = true;
        int puntero1 = 0;
        int puntero2 = 0;
        int coef1, coef2;
        Position<Monomio> mono1, mono2, ultimoMonomioTratadoPrimerPoli = null;
        TreeMap<Integer, Integer> mapaMonomios = new TreeMap<>();

        ultimoMonomioTratadoPrimerPoli = p1.terms.first();
        if (ultimoMonomioTratadoPrimerPoli != null) {
            while (seguir) {

                Polinomio poliIntermedio = multiplica(ultimoMonomioTratadoPrimerPoli.element(), p2);
                TreeMap<Integer, Integer> mapapuntual = conviertePoliMapa(poliIntermedio);
                for (Integer clave : mapapuntual.keySet()) {
                    if (mapaMonomios.containsKey(clave)) {
                        mapaMonomios.put(clave, mapaMonomios.get(clave) + mapapuntual.get(clave));
                    } else {
                        mapaMonomios.put(clave, mapapuntual.get(clave));
                    }
                }

                ultimoMonomioTratadoPrimerPoli = p1.terms.next(ultimoMonomioTratadoPrimerPoli);
                if (ultimoMonomioTratadoPrimerPoli == null) {
                    seguir = false;
                }
            }

            // crear un nuevo polinomio desde el mapa final
            for (Integer clave : mapaMonomios.keySet()) {
                Monomio m = new Monomio(mapaMonomios.get(clave), clave);
                nuevalista.addFirst(m);
            }
        }
        Polinomio resultado = new Polinomio(nuevalista);
        return resultado;
    }

    /**
     * Calcula el producto de dos polinomios.
     *
     * @param t primer polinomio.
     * @param p segundo polinomio.
     * @return el producto de los polinomios.
     */
    public static Polinomio multiplica(Monomio t, Polinomio p) {

        PositionList<Monomio> nuevalista = new NodePositionList<>();

        boolean seguir = true;
        int puntero1 = 0;
        int puntero2 = 0;
        int coef1, coef2;
        Position<Monomio> mono1, mono2, ultimoMonomioTratado = null;

        ultimoMonomioTratado = p.terms.first();
        if (ultimoMonomioTratado != null) {
            while (seguir) {
                int nuevocoef = t.getCoeficiente() * ultimoMonomioTratado.element().getCoeficiente();
                int nuevoexpo = t.getExponente() + ultimoMonomioTratado.element().getExponente();
                Monomio nuevo = new Monomio(nuevocoef, nuevoexpo);
                nuevalista.addLast(nuevo);

                ultimoMonomioTratado = p.terms.next(ultimoMonomioTratado);
                if (ultimoMonomioTratado == null) {
                    seguir = false;
                }
            }
        }

        Polinomio resultado = new Polinomio(nuevalista);
        return resultado;

    }

    /**
     * Devuelve el valor del polinomio cuando su variable es sustiuida por un valor concreto.
     * Si el polinomio es vacio (la representacion del polinomio "0") entonces
     * el valor devuelto debe ser 0.
     *
     * @param valor el valor asignado a la variable del polinomio
     * @return el valor del polinomio para ese valor de la variable.
     */
    public long evaluar(int valor) {
        if (terms.size() == 0) {
            return 0;
        }
        long resultado = 0;

        Position<Monomio> ultimoMonomioTratado = null;

        ultimoMonomioTratado = terms.first();
        while (ultimoMonomioTratado != null) {
            int coef = ultimoMonomioTratado.element().getCoeficiente();
            int expo = ultimoMonomioTratado.element().getExponente();
            double parcial = Math.pow(valor, expo);
            resultado += parcial * coef;
            ultimoMonomioTratado = terms.next(ultimoMonomioTratado);
        }

        return resultado;
    }

    /**
     * Devuelve el exponente (grado) del monomio con el mayor grado
     * dentro del polinomio
     *
     * @return el grado del polinomio
     */
    public int grado() {
        if (terms.size() > 0) {
            return terms.first().element().getExponente();
        }

        return -1;
    }

    @Override
    public String toString() {
        if (terms.isEmpty()) return "0";
        else {
            StringBuffer buf = new StringBuffer();
            Position<Monomio> cursor = terms.first();
            while (cursor != null) {
                Monomio p = cursor.element();
                int coef = p.getCoeficiente();
                int exp = p.getExponente();
                buf.append(Integer.toString(coef));
                if (exp > 0) {
                    buf.append("x");
                    buf.append("^");
                    buf.append(Integer.toString(exp));
                }
                cursor = terms.next(cursor);
                if (cursor != null) buf.append(" + ");
            }

            return buf.toString();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Polinomio otro = (Polinomio) o;
        if (otro.terms.size() != this.terms.size()) {
            return false;
        }
        Position<Monomio> m1 = terms.first();
        Position<Monomio> m2 = otro.terms.first();
        while (m1 != null) {
            if (m1.element().getExponente() != m2.element().getExponente() || m1.element().getCoeficiente() != m2.element().getCoeficiente()) {
                return false;
            }
            m1 = terms.next(m1);
            m2 = otro.terms.next(m2);
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(terms);
    }
}
