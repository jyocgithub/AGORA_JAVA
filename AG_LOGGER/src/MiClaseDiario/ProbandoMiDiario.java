package MiClaseDiario;
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

public class ProbandoMiDiario {

        public static void main(String[] args) {
            MiDiario.crearLog(ProbandoMiDiario.class.getName(), true);

            MiDiario.logInfo("Vamos a empezar");

            System.out.println("haciendo cosa 1 ");
            MiDiario.logWarning("Hemos hecho cosa 1");

            int x = 5;
            if (x>2){
                x=0;
            MiDiario.logError("CUIDADO hemos cambiado el valor de x !!");

            }

        }


}

