package A4_ThreadPools.Ejemplo_callable_Medianotas;
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

import java.util.List;
import java.util.concurrent.Callable;

public class CalculaMediaGrupo implements Callable<String> {
    private final GrupoAlumnos grupo;

    public CalculaMediaGrupo(GrupoAlumnos grupo) {
        this.grupo = grupo;
    }

    @Override
    public String call() {
        long inicio = System.currentTimeMillis();

        List<Integer> notas = grupo.getCalificaciones();
        double suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        double media = notas.isEmpty() ? 0 : suma / notas.size();

        long fin = System.currentTimeMillis();

        return "Grupo: " + grupo.getNombre() +
                " - Media: " + String.format("%.2f", media) +
                " - Tiempo: " + (fin - inicio) + " ms";
    }
}
