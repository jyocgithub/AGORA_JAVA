package estructuras_estaticas;

public class PruebasPilasColas {

    public static void main(String[] args) {

//        // 4 bloques 
//        // 2 portales 
//        // 10 plantas
//        // 5 puertas 
//        
        int[][][][] pisos = new int[4][2][10][5];
//        
//        piso[1][2[4][3]

        for (int bloque = 0; bloque < 3; bloque++) {
            for (int portal = 0; portal < 2; portal++) {
                for (int planta = 0; planta < 10; planta++) {
                    for (int puerta = 0; puerta < 5; puerta++) {
                        System.out.println(pisos[bloque][portal][planta][puerta]);
                    }
                }
            }
        }

        
        
        int lis[] = {4, 6, 7};

        int[][] mimatriz = new int[3][3];

        int[][] lis2 = {{4, 6, 7}, {2, 3, 4}, {4, 6, 2}, {9, 8, 7}, {1, 2, 2}};

// 4 6 7 
// 2 3 4 
// 4 6 2
// 9 8 7 
// 1 2 2 
        int[][] lis3 = {{4, 6, 7, 4, 2}, {2, 3, 4, 3, 1}, {4, 6, 2, 7, 8}};

// 4 , 6 , 7 , 4 , 2 
// 2 , 3 , 4 , 3 , 1 
// 4 , 6 , 2 , 1 , 8
        for (int fila = 0; fila < 3; fila++) {

            for (int columna = 0; columna < 5; columna++) {

                System.out.println(lis3[fila][columna]);

            }

        }

  
//        PilaEstatica<Integer> miPila = new PilaEstatica<>(5);
//
//        miPila.anadir(12);
//        miPila.anadir(542);
//        miPila.anadir(123);
//        miPila.anadir(464);
//        System.out.println("tamaño de la pila:" + miPila.tamanoDeLaPila());
//
//        miPila.anadir(63);
//        miPila.anadir(5632);
//
//        System.out.println("tamaño de la pila:" + miPila.tamanoDeLaPila());
    }

}
