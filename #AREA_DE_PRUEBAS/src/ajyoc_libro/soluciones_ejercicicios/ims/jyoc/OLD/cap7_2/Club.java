package soluciones_ejercicicios.ims.jyoc.OLD.cap7_2;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 6
 * Ejercicio 6.2. (dif 1) Construir una clase llamada Semaforo que simule un semáforo; con
 * - un atributo color, y
 * - un metodo cambio() que debe hace cambiar el color entre verde, amarillo y rojo en ese orden.
 * Cuando un objeto luz se cree su color inicial debe ser rojo.
 *
 * @author Iñaki Martin
 */

public class Club {

    public static void main(String args[]) {

        Socio s1 = new Socio();
        Socio s2 = new Socio();
        Socio s3 = new Socio();

        // llamamos al metodo con version 1
        Socio elMasAnt = calcularElMasAntiguo(s1, s2, s3);
        System.out.println("El socio mas antiguo es " + elMasAnt.nombre);

        // llamamos al metodo con version 2
        Socio[] aSocios = new Socio[3];
        aSocios[0] = s1;
        aSocios[1] = s2;
        aSocios[2] = s3;

        Socio elMasAnt2 = calcularElMasAntiguo(aSocios);
        System.out.println("El socio mas antiguo segun version 2 es " + elMasAnt2.nombre);

    }

    // Metodo que devuelve un Socio, el de mayor antiguiedad de tres
    // socios que recibe por parametro
    public static Socio calcularElMasAntiguo(Socio soc1, Socio soc2, Socio soc3) {
        Socio elSocioMasAntiguo = null;

        if (soc1.antiguedad > soc2.antiguedad) {
            if (soc1.antiguedad > soc3.antiguedad) {
                elSocioMasAntiguo = soc1;
            } else {
                elSocioMasAntiguo = soc3;
            }
        } else {
            if (soc2.antiguedad > soc3.antiguedad) {
                elSocioMasAntiguo = soc2;
            } else {
                elSocioMasAntiguo = soc3;
            }
        }
        return elSocioMasAntiguo;
    }

    // Variante del método anterior
    // Este método devuelve tambien el Socio de mayor antiguiedad, pero recibe
    // como parámetro un array de socios, de tamaño no determinado
    // socios que recibe por parametro
    public static Socio calcularElMasAntiguo(Socio[] arrayDeSoc) {
        Socio elSocioMasAntiguo = arrayDeSoc[0];

        for (int i = 0; i < arrayDeSoc.length; i++) {
            if (arrayDeSoc[i].antiguedad > elSocioMasAntiguo.antiguedad) {
                elSocioMasAntiguo = arrayDeSoc[i];
            }
        }
        return elSocioMasAntiguo;
    }
}
