package cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 4 Ejercicio a_5
 * Dados estos arrays
 String [] nombreDeCadaAlumno = {"Luis","Jose","Carlos","Pedro","Juanjo"}
 int[] notasDeCadaAlumno = {8,2,5,4,9};
 Hacer un bucle que nos diga los nombres de los alumnos que han aprobado
 y su nota, esto es, debe dar como salida por pantalla:
 "Luis ha aprobado con un 8"
 "Carlos ha aprobado con un 5"
 "Juanjo ha aprobado con un 9”

 */
public class Jyoc_Ejercicio_4_a_05 {
    public static void main(String[] args) {
        String [] nombreDeCadaAlumno = {"Luis","Jose","Carlos","Pedro","Juanjo"};
        int[] notasDeCadaAlumno = {8,2,5,4,9};
        for (int i = 0; i < nombreDeCadaAlumno.length; i++) {
            if(notasDeCadaAlumno[i]>=5){
                System.out.println(nombreDeCadaAlumno[i]+" ha aprobado con un "+notasDeCadaAlumno[i]);
            }
        }
    }
}