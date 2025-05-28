package patron_object_pool;
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

// Este es un patrón muy utilizado cuando se requiere trabajar con una gran
// cantidad de objetos, los cuales son computacionalmente caros de crear,
// este patrón tiene una gran ventaja en escenarios donde nuestro programa
// requiere dichos objetos por un tiempo muy corto y que luego de su uso son
// desechados. La ventaja que brinda este patrón es que nos permite reutilizar
// los objetos con el fin de evitar la tarea de crearlos cada vez que nuestra
// aplicación los requiere, manteniendo así un almacén de objetos creados
// previamente para ser utilizados.

// SI en El Señor de lso Anillos hubiera tantos trajes como Orcos aparecen, costarría trillones solo en vestuario. s
// Pero podemos pensar que los trajes de orcos se "reutilizan" cuando alguien no los usa...
import java.util.HashSet;
import java.util.Set;

public class MainPatronObjectPool {

    public static void main(String[] args) {
        PoolDeTrajeOrco pool = new PoolDeTrajeOrco();
        TrajeOrco trajeOrco1 = pool.obtener();
        TrajeOrco trajeOrco2 = pool.obtener();
        TrajeOrco trajeOrco3 = pool.obtener();
        pool.soltar(trajeOrco1);
        pool.soltar(trajeOrco2);
        TrajeOrco trajeOrco4 = pool.obtener();
        TrajeOrco trajeOrco5 = pool.obtener();

    }


}


class TrajeOrco {

    private int contador = 0;
    private int identificador;

    public TrajeOrco() {
        identificador = ++contador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String toString() {
        return "Traje id= " + identificador;
    }
}


class PoolDeTrajeOrco  {

    private  Set<TrajeOrco> disponibles = new HashSet<>();
    private  Set<TrajeOrco> enUso = new HashSet<>();

    public TrajeOrco obtener() {
        if (disponibles.isEmpty()) {
            disponibles.add(new TrajeOrco());
        }
        TrajeOrco instancia = disponibles.iterator().next();
        disponibles.remove(instancia);
        enUso.add(instancia);
        System.out.println(this);
        return instancia;
    }

    public  void soltar(TrajeOrco instance) {
        enUso.remove(instance);
        disponibles.add(instance);
        System.out.println(this);
    }

    public String toString() {
        return "Disponibles: " + disponibles.size() + " En uso: " + enUso.size();
    }

}
