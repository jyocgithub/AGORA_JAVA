
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

import java.util.Scanner;


enum EFichas {
    PEON, TORRE, CABALLO, ALFIL, DAMA, REY;

    public static boolean validar(String unafichaEnString) {
        for (EFichas cadaficha : EFichas.values()) {
            if (cadaficha.toString().equals(unafichaEnString)) {
                return true;
            }
        }
        return false;
    }
}


public class EnumeradosConAtributosMetodos {

    public static void main(String[] args) {
        // podemos pedir el valor de una ficha por scanner, y ver si existe como tal
        System.out.println("Dime un tipo de ficha del ajedrez:");
        String ficha = new Scanner(System.in).nextLine();
        if (EFichas.validar(ficha.toUpperCase())) {
            System.out.println("Esa ficha si existe en el ajedrez !!!!!!!");
        } else {
            System.out.println("Esa ficha NO existe en el ajedrez...");
        }
    }

}
