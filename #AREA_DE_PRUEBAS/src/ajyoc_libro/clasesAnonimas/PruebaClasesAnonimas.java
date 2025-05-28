/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesAnonimas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author iniaski
 */
public class PruebaClasesAnonimas {

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

        Espia e = new Espia("Mata-Hari", 33, "Andorra");

        int numero_a_buscar = 12;

        int[] array = {2, 4, 6, 7, 8, 9, 11, 12, 14};

        int posicion = -1;
        int indice_inicio = 0;
        int indice_final = array.length - 1;

        while (posicion == -1 && indice_inicio != indice_final) {
            int indice_medio = indice_inicio + (indice_final - indice_inicio / 2);

            if (numero_a_buscar == array[indice_medio]) {
                posicion = indice_medio;
            } else if (numero_a_buscar > array[indice_medio]) {
                indice_inicio = indice_medio;
            } else {
                indice_final = indice_medio;
            }
        }


    }

    void activarAgente(Espia unespia) {
        if (unespia.codigoCIA != "Activado") {
            unespia.codigoCIA = "Activado";
        }

    }

}

class Persona {

    String nombre;
    int edad;
    String nacionalidad;

    public Persona(String nombre, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

}

class Espia extends Persona {

    String codigoCIA;

    public Espia(String nombre, int edad, String nacionalidad) {
        super(nombre, edad, nacionalidad);
    }

}
