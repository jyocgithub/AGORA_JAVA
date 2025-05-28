//Crear una clase llamada Password que siga las siguientes condiciones:
//• Atributos longitud y contraseña . Por defecto, la longitud será de 8. Serán públicos.
//• Los métodos serán los siguiente:
//• Un constructor por defecto.
//• Un constructor con la longitud que nosotros le pasemos. Generara una contraseña aleatoria con
//esa longitud.
//• esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2
//mayúsculas, mas de 1 minúscula y algun número.
//• generarPassword(): genera la contraseña del objeto con la longitud que tenga. o Método get para
//contraseña y longitud.
//• Crear un clase Prueba donde
//• Añadir un vector de Password con el tamaño que se le indique por teclado.
//• Rellenar el vector con passwords aleatorias (el tamaño de todas las password es el mismo, se pide
//antes por teclado)
//• Crear otro vector de booleanos donde se almacene si cada password del vector de passwords es o
//no fuerte
package ej_capitulo_9;

import java.util.Scanner;

public class Ej9_8 {

    public static void main(String[] args) {
        Password[] lista;
        System.out.println("Cuantas contraseñas quiere guardar?");
        int numerocontrasenas = new Scanner(System.in).nextInt();
        System.out.println("Tamaño de las contraseñas?");
        int tamano = new Scanner(System.in).nextInt();
        lista = new Password[numerocontrasenas];

        for (int i = 0; i < lista.length; i++) {
            Password password = new Password(tamano);
            password.contrasena = password.generarPassword();
            lista[i] = password;
        }
        boolean[] sonfuertes = new boolean[numerocontrasenas];
        for (int i = 0; i < sonfuertes.length; i++) {
            sonfuertes[i] = lista[i].esFuerte();
            System.out.println(lista[i].contrasena);
            System.out.println(sonfuertes[i]);
        }

    }
}

class Password {

    public int longitud;
    public String contrasena;

    public Password(int longitud, String contrasena) {
        this.longitud = longitud;
        this.contrasena = contrasena;
    }

    public Password(int longitud) {
        this.longitud = longitud;
        this.contrasena = generarPassword();
    }

    public String generarPassword() {
        String contrasenaAConstruir = "";
        for (int i = 0; i < longitud; i++) {
            int n = (int) (Math.random() * 100 + 32);
            char ch = (char) n;
            contrasenaAConstruir = contrasenaAConstruir + ch;
        }
        return contrasenaAConstruir;
    }

    boolean esFuerte() {
        int contadorMayusculas = 0;
        int contadorMinusculas = 0;
        int contadorNumeros = 0;
        for (int i = 0; i < longitud; i++) {
            char cadaletra = contrasena.charAt(i);
            if (Character.isDigit(cadaletra)) {
                contadorNumeros++;
            }
            if (Character.isLetter(cadaletra) && Character.isLowerCase(cadaletra)) {
                contadorMinusculas++;
            }
            if (Character.isLetter(cadaletra) && Character.isUpperCase(cadaletra)) {
                contadorMayusculas++;
            }
        }
        if (contadorMayusculas > 2 && contadorMinusculas > 1 && contadorNumeros > 0) {
            return true;
        }
        return false;
    }

}
