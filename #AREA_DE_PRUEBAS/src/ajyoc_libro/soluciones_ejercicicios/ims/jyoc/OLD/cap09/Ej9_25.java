//Crea una clase llamada Alumno con los atributos privados:
//• String nombre
//• double[] notas (guarda 3 valores, las notas de cada una de las tres evaluaciones)
// Implementa el siguiente constructor:
//• Alumno (String nombre). El constructor pone un -1 en cada elemento del array de notas, indicando asi que no hay nota asociada
//Implementa los siguientes métodos públicos:
//• Getter y setter para el atributo nombre.
//• boolean ponerNota(int evaluacion, double nota). Guardará la nota correspondiente a la evaluación
//indicada. Las notas van del 0 al 10 y las evaluaciones del 1 al 3. Devuelve false si los parámetros no
//son válidos.
//• boolean borrarNota(int evaluacion). Borra la nota de la evaluación indicada. Da false si los
//parámetros no son válidos.
//• double notaMaxima( ). Devuelve la nota máxima del alumno. -1 si no tiene notas.
//• boolean tieneNota(int evaluacion). Da true si el alumno tiene nota para la evaluación indicada. False
//si no, o número de evaluación no válida.
//• double getNota(int evaluacion). Devuelve la nota de la evaluación pasada como parámetro. -1 si la
//evaluación no es válida o no hay nota
//Crea una clase Prueba con un main y con un vector con varios alumnos para probar todas las
//funcionalidades de la clase Alumno a través de sus métodos.
package ej_capitulo_9;

public class Ej9_25 {

    public static void main(String[] args) {
        Alumno a = new Alumno("PEPE");
        System.out.println(a.tieneNota(0));
        System.out.println(a.ponerNota(1, 2));
        System.out.println(a.ponerNota(2, 5));
        System.out.println(a.ponerNota(3, 8));
        System.out.println(a.ponerNota(8, 2));
        System.out.println(a.borrarNota(2));
        System.out.println(a.notaMaxima());
    }
}

class Alumno {

    String nombre;
    double[] notas;

    public Alumno(String nombre) {
        this.nombre = nombre;
        notas = new double[3];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = -1;
        }
    }

    boolean ponerNota(int evaluacion, double nota) {
        if (nota >= 0 && nota <= 10 && evaluacion >= 1 && evaluacion <= 5) {
            notas[evaluacion - 1] = nota;
            return true;
        }
        return false;
    }

    boolean borrarNota(int evaluacion) {
        if (evaluacion >= 1 && evaluacion <= 5) {
            notas[evaluacion - 1] = 0;
            return true;
        }
        return false;
    }

    double notaMaxima() {
        double maxima = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > maxima) {
                maxima = notas[i];
            }
        }
        return maxima;
    }

    boolean tieneNota(int evaluacion) {
        if (evaluacion >= 1 && evaluacion <= 5) {
            if (notas[evaluacion - 1] != -1) {
                return true;
            }
        }
        return false;
    }

    double getNota(int evaluacion) {
        if (evaluacion >= 1 && evaluacion <= 5) {
            if (notas[evaluacion - 1] != -1) {
                return notas[evaluacion - 1];
            }
        }
        return -1;
    }
}
