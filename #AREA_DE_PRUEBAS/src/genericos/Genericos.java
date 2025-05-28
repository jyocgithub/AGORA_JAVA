package genericos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Mamifero{

}
class Oveja extends Mamifero{

}
class MiClassAcotada< T extends Number> {
    String nombre;
    T peso;

    public MiClassAcotada(String nombre, T peso) {
        this.nombre = nombre;
        this.peso = peso;
    }
    public <T extends Number> boolean esInt(T algo){
        return algo instanceof Integer;
    }
}

public class Genericos {


    public void mira1(List<? extends Number> lista) {

    }

    public void mira2(List<? super Oveja> lista) {

    }
    public void mira3(List<?> lista) {

    }

    public List<? extends Number> mira4(int num) {
        return null;
    }

    public List<? super Number> mira5(int num ){
        return null;
    }

    public List<?> mira6(int num ){
        return null;
    }



    public static void main(String[] args) {

        MiClassAcotada<Integer> obj1 = new MiClassAcotada<>("Blas",56);
        MiClassAcotada<Double> obj2 = new MiClassAcotada<>("Blas",56.33);

        MiClaseGen<String>  objetoconstring = new MiClaseGen<String>("un texto");
        objetoconstring.setInfo( "alguna cosa");

        MiClaseChula <Double, Integer, Character> miobjeto2 = new MiClaseChula<>("ana",12.1,32,'s',3);
        MiClaseChula <Integer, Double, String> miobjeto1 = new MiClaseChula<>("luis", 1, 1.1, "SAA", 12);

        String[]  cadenas = { "uno", "dos", "tres", "cuatro"};
        Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8 };
        boolean solucion1 = existe(cadenas, "seis");
        boolean solucion2 = existe(numeros, 3);
        System.out.println(solucion1);
        System.out.println(solucion2);

        // comodines en declaracion de objetos de clases genericas
        List<Integer> listaInt = Arrays.asList(numeros);



        ArrayList<? extends Number> unobjeto = new ArrayList<>();
//        unobjeto.add(23): // no se puede añadir !!!!!!
//        ArrayList<? extends Number> unobjeto2 = listaInt;  // no se puede, no es lo mismo !!!



    }

    public static <T> boolean existe(T[] elementos, T elemento) {
        boolean res = false;
        for (int i = 0; i < elementos.length && (!res); i++) {
            if (elementos[i] == elemento) res = true;
        }
        return res;
    }
}


class MiClaseGen<T> { 	// Esta T indica que luego al crear objetos se dirà qué tipo de dato es T
    private T informacion;  // Ese tipo de dato T será el que tendrá mi atributo “info”

    public MiClaseGen (T informacion) {   // El parámetro del constructor sera, claro, de tipo T
        this.informacion = informacion;
    }
    public T getInfo () {                     // igual que el parámetro de devuelve el getter
        return this.informacion;
    }
    public void setInfo (T informacion) {     // o el parámetro que necesita el setter
        this.informacion = informacion;
    }

}


class MiClaseChula <T, Q, F> {
    String nombre;
    T peso;
    Q altura;
    F estado;
    int edad;

    public MiClaseChula(String nombre, T peso, Q altura, F estado, int edad) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
        this.estado = estado;
        this.edad = edad;
    }

//    public void crecer(){
//        this.altura = this.altura + 5; // Da ERROR, pues el tipo de altura es Q, y no sabemos que va a ser en el futuro... ni si a ese futuro tipo se le va a poder sumar una cantidad
//    }
}

