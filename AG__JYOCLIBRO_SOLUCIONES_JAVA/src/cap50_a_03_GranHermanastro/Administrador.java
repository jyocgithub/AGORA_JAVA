package cap50_a_03_GranHermanastro;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {
    private ArrayList<Habitante> listaHabitantes;
    private int limiteNominaciones;

    public Administrador(int limiteNominaciones) {
        this.limiteNominaciones = limiteNominaciones;

    }

    public ArrayList<Habitante> getListaHabitantes() {
        return listaHabitantes;
    }

    public int getLimiteNominaciones() {
        return limiteNominaciones;
    }

    public void setLimiteNominaciones(int limiteNominaciones) {
        this.limiteNominaciones = limiteNominaciones;
    }

    public ArrayList<Habitante> inicializar() {
        listaHabitantes = new ArrayList<>();
        Habitante h1 = new Habitante("Pepote Ganapasta", 0);
        Habitante h2 = new Habitante("Juanita Muchasbroncas", 0);
        Habitante h3 = new Habitante("Chimo Chistoso", 0);
        Habitante h4 = new Habitante("Anita Lenguaraz ", 0);
        Habitante h5 = new Habitante("Cuqui Pinocha", 0);
        listaHabitantes.add(h1);
        listaHabitantes.add(h2);
        listaHabitantes.add(h3);
        listaHabitantes.add(h4);
        listaHabitantes.add(h5);
        return listaHabitantes;
    }

    public void estadoNominaciones() {
        System.out.println("ESTADO DE LAS NOMINACIONES");
        System.out.println("==========================");
        for (Habitante h : listaHabitantes) {
            System.out.println(h.getNombre() + " tiene actualmente " + h.getPuntos() + " nominaciones.");
        }
    }

    public void votar(int puntos) {
        System.out.println("VOTACION");
        System.out.println("========");
        System.out.println("ELIGE EL NUMERO DEL HABITANTE AL QUE LE OTORGAS " + puntos + " PUNTOS:");
        for (int j = 0; j < listaHabitantes.size(); j++) {
            Habitante h = listaHabitantes.get(j);
            System.out.println((j + 1) + ".- " + h.getNombre() + " (" + h.getPuntos() + " puntos hasta el momento)");
        }
        Scanner sc = new Scanner(System.in);
        int voto = sc.nextInt();
        if (voto < 0 || voto > listaHabitantes.size()) {
            System.out.println("Voto inválido, no hay habitante con tal numero");
        } else {
            voto = voto - 1; // por que el habitante 1 tiene el indice 0, y sucesivamente
            Habitante hab =  listaHabitantes.get(voto);
            int puntosHastaAhora =hab.getPuntos();
            hab.setPuntos(puntosHastaAhora + puntos);
            System.out.println("Voto otorgado, " + puntos + " punto/s añadido/s a " + hab.getNombre());

            // comprobar si ha llegado al limite y ehcarlo en tal caso
            if ( hab.getPuntos()>limiteNominaciones){
                System.out.println("HABITANTE EXPULSADO !!!");
                System.out.println(hab.getNombre() +" ha llegado al limite de nominaciones!!");
                listaHabitantes.remove(hab);
                if(listaHabitantes.size()==1){
                    System.out.println("YA HAY GANADOR !!");
                    System.out.println("GANA "+listaHabitantes.get(0).getNombre()+" QUE ES EL UNICO QUE QUEDA EN LA CASA !!");
                    System.exit(0);   // finaliza el programa
                }
            }
        }

    }


}