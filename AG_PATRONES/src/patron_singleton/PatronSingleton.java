
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron_singleton;

public class PatronSingleton {

    public static void main(String[] args) {
        ClaseUnica c1 = ClaseUnica.crearInstancia();
        ClaseUnica c2 = ClaseUnica.crearInstancia();
        if (c1 == c2) {
            System.out.println("Son iguales");
        } else {
            System.out.println("Son diferentes");          
        }
    }
}

//***************************************************+
class ClaseUnica {

    static ClaseUnica objetoUnico;

    private ClaseUnica() {
    }

    public static ClaseUnica crearInstancia() {
        if (objetoUnico == null) {
            objetoUnico = new ClaseUnica();
        }
        return objetoUnico;
    }
}
