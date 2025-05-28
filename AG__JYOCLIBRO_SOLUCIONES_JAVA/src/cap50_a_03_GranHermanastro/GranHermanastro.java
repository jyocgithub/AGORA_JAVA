package cap50_a_03_GranHermanastro;

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

public class GranHermanastro {
    static Administrador admin;

    public static void main(String[] args) {
        int opcion;
        admin = new Administrador(5);
        admin.inicializar();

        do {
            System.out.println("\n\n==============");
            System.out.println("MENU PRINCIPAL");
            System.out.println("==============");
            System.out.println("1.- Acceso como Administrador");
            System.out.println("2.- Acceso como Habitante");
            System.out.println("0.- Salir");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    accionesDeAdministrador();
                    break;
                case 2:
                    accionesDeHabitante();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion inválida. Pruebe otra vez");
            }
        } while (opcion != 0);
        System.out.println("FIN DE PROGRAMA");
    }


    public static void accionesDeAdministrador() {
        int opcion;
        do {
            System.out.println("\n\n==================");
            System.out.println("MENU ADMINISTRADOR");
            System.out.println("==================");
            System.out.println("1.- Estado de las nominaciones");
            System.out.println("2.- Inicializar nominaciones");
            System.out.println("3.- Cambiar el numero de nominaciones para expulsión (actualmente es " + admin.getLimiteNominaciones() + ")");
            System.out.println("0.- Volver al menu de identificación de perfil");
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    admin.estadoNominaciones();
                    break;
                case 2:
                    admin.inicializar();
                    break;
                case 3:
                    System.out.println("Indique nuevo limite (no puede ser menor que el anterior):");
                    int nuevolimite = new Scanner(System.in).nextInt();
                    if (nuevolimite <= admin.getLimiteNominaciones()) {
                        System.out.println("El limite nuevo ha de ser mayor que el anterior");
                    } else {
                        admin.setLimiteNominaciones(nuevolimite);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion inválida. Pruebe otra vez");
            }
        } while (opcion != 0);
    }


    public static void accionesDeHabitante() {
        int opcion;
        do {
            System.out.println("\n\n==============");
            System.out.println("MENU HABITANTE");
            System.out.println("==============");
            System.out.println("1.- Nominar para expulsión: 1 punto");
            System.out.println("2.- Nominar para expulsión: 2 punto");
            System.out.println("3.- Nominar para expulsión: 3 punto");
            System.out.println("0.- Volver al menu de identificación de perfil");
            opcion = new Scanner(System.in).nextInt();
            if (opcion > 0 && opcion < 4) {
                admin.votar(opcion);
            } else if (opcion != 0) {
                System.out.println("Opcion inválida. Pruebe otra vez");
            }
        } while (opcion != 0);


    }

}




