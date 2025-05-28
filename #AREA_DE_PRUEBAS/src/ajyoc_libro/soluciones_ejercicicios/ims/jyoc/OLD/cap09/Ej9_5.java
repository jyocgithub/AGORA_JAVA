//Crear una clase llamada Número, sin atributos y con los siguientes métodos públicos y estáticos:
//• boolean esPrimo(int a)
//• boolean esPerfecto(int a)
//• boolean esCapicua(int a)
//• boolean sonAmigos(int a,int b)
//• int[ ] extraeDivisores(int a): Devuelve un vector con los divisores del número pasado como
//parámetro, sin incluir el propio número.
//void duplica(int[ ] a): Duplica el valor de cada uno de los números de un vector de enteros
//pasado como parámetro.
//void ordena(int[ ] a ,int b): Ordena el contenido de un vector de enteros pasado como primer
//parámetro. El segundo parámetro indica el tipo de orden, siendo los valores posibles dos
//constantes de tipo int llamadas ASCENDENTE y DESCENDENTE.
//int[ ] eliminaPrimos(int[ ] a): Devuelve un vector con el contenido original del vector que entra como
//parámetro, pero sin los posibles números primos que pudiera tener, por tanto el vector devuelto puede
//tener una dimensión menor.
//Crear una clase aparte con el método main para probar todas las funcionalidades de la clase Numero
package ej_capitulo_9;

//import sun.nio.cs.StreamDecoder;

public class Ej9_5 {

    public static void main(String[] args) {
        Numero n = new Numero();
        System.out.println("Es primo el 23?");
        System.out.println(n.esPrimo(23));
        System.out.println("Es primo el 25?");
        System.out.println(n.esPrimo(25));

        System.out.println("Es perfecto el 6?");
        System.out.println(n.esPerfecto(6));
        System.out.println("Es perfecto el 25?");
        System.out.println(n.esPrimo(25));

        System.out.println("Son amigos el 220 y el 284?");
        System.out.println(n.sonAmigos(220, 284));
        System.out.println("Son amigos el 220 y el 123?");
        System.out.println(n.sonAmigos(220, 123));

        System.out.println("Es capicua el 252?");
        System.out.println(n.esCapicua(252));
        System.out.println("Es capicua el 2521?");
        System.out.println(n.esCapicua(2521));

        System.out.println("\nDivisores de 12");
        int[] solucion = n.extraeDivisores(12);
        pintaArray(solucion);

        System.out.println("\nDuplicar {2, 3, 54, 1, 5, 23, 7, 10} ");
        int[] entrada = {2, 3, 54, 1, 5, 23, 7, 10};
        n.duplica(entrada);
        pintaArray(entrada);

        final int ASCENDENTE = 0;
        final int DESCENDENTE = 1;

        System.out.println("\nOrdenar ascendentemente {2, 3, 54, 1, 5, 23, 7, 10} ");
        int[] entrada2 = {2, 3, 54, 1, 5, 23, 7, 10};
        n.ordena(entrada2, ASCENDENTE);
        pintaArray(entrada2);

        System.out.println("\nOrdenar descendentemente {2, 3, 54, 1, 5, 23, 7, 10} ");
        int[] entrada3 = {2, 3, 54, 1, 5, 23, 7, 10};
        n.ordena(entrada3, DESCENDENTE);
        pintaArray(entrada3);

        System.out.println("\nElimina primos de {2, 3, 54, 1, 5, 23, 7, 10} ");
        int[] entrada4 = {2, 3, 54, 1, 5, 23, 7, 10};
        int[] salida = n.eliminaPrimos(entrada4);
        pintaArray(salida);


    }

    public static void pintaArray(int[] h) {
        for (int i = 0; i < h.length; i++) {
            System.out.print(h[i] + "\t");
        }
        System.out.println("\n");
    }

}

class Numero {

    final int ASCENDENTE = 0;
    final int DESCENDENTE = 1;

    public boolean esPrimo(int a) {
        boolean res = true;
        for (int i = 2; i < a - 1 && res; i++) {
            if (a % i == 0) {
                res = false;
            }
        }
        return res;
    }

    public boolean esPerfecto(int a) {
        int suma = 0;
        for (int i = 1; i < a - 1; i++) {
            if (a % i == 0) {
                suma += i;
            }
        }
        if (suma == a) {
            return true;
        }
        return false;
    }

    public boolean esCapicua(int a) {
        boolean res = false;
        String snum = a + "";
        String alreves = "";
        for (int i = snum.length() - 1; i >= 0; i--) {
            alreves = alreves + snum.charAt(i);
        }
        return alreves.equals(snum);
    }

    public boolean sonAmigos(int a, int b) {

        // sumamos divisores de a
        int sumaDivisoresDeA = 0;
        for (int i = 1; i < a - 1; i++) {
            if (a % i == 0) {
                sumaDivisoresDeA += i;
            }
        }
        // sumamos divisores de n
        int sumaDivisoresDeB = 0;
        for (int i = 1; i < b - 1; i++) {
            if (a % i == 0) {
                sumaDivisoresDeB += i;
            }
        }

        if (sumaDivisoresDeA == b && sumaDivisoresDeB == a) {
            return true;
        }
        return false;
    }

    public int[] extraeDivisores(int a) {

        // creamos un primer vector de tamaño maximo y rellenamos con divisores
        int[] primervector = new int[a];
        int sumadivisores = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                primervector[sumadivisores] = i;
                sumadivisores++;
            }
        }
        // copiamos en un nuevo vector solo los elementos del primer vector que hemos rellenado antes
        int[] vectorfinal = new int[sumadivisores];
        for (int i = 0; i < vectorfinal.length; i++) {
            vectorfinal[i] = primervector[i];
        }
        return vectorfinal;
    }

    public void duplica(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * 2;
        }
    }

    void ordena(int[] a, int b) {
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a.length - 1; k++) {
                if (b == ASCENDENTE) {
                    if (a[k] > a[k + 1]) {
                        int aux = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = aux;
                    }
                }
                if (b == DESCENDENTE) {
                    if (a[k] < a[k + 1]) {
                        int aux = a[k];
                        a[k] = a[k + 1];
                        a[k + 1] = aux;
                    }
                }
            }
        }
    }

    int[] eliminaPrimos(int[] a) {

        // creamos un primer vector de tamaño maximo y rellenamos con solo los no primos
        int[] primervector = new int[a.length];

        int sumaprimos = 0;
        for (int i = 0; i < a.length; i++) {
            int j = a[i];
            if (esPrimo(j)) {
                primervector[sumaprimos] = j;
                sumaprimos++;
            }
        }
        // copiamos en un nuevo vector solo los elementos del primer vector que hemos rellenado antes
        int[] vectorfinal = new int[sumaprimos];
        for (int i = 0; i < vectorfinal.length; i++) {
            vectorfinal[i] = primervector[i];
        }
        return vectorfinal;
    }

}
