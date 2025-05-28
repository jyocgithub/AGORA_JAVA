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

public class GrupoAlumnos {
    private final String nombre;
    private final List<Integer> calificaciones;

    public GrupoAlumnos(String nombre, List<Integer> calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }
}
