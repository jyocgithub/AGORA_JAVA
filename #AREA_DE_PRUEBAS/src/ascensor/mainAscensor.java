package ascensor;


public class mainAscensor {


    public static void main(String[] args) {

        int i = 65;
        char c = (char)i;
        System.out.println(c);

        char g = 'B';
        int k = g;
        System.out.println(k);




    }

}


class ThreadGroupTest {
    public static void main(String[] args) {
            // Cramos tres threads primero
            // Los hilos son objetos anñónimos, para que se vea que no se guarda su nombre
            // y que sabemos unicamente que se relacionan por quién los ha arrancado
        new HiloSimple("Paco").start();
        new HiloSimple("Eva").start();
        new HiloSimple("Ana").start();
            // Obtiene un ThreadGroup a partir del hilo actual, esto es,
            // el grupo se creará con los hilos LANZADOS desde este mismo hilo
        ThreadGroup grupoHilos = Thread.currentThread().getThreadGroup();
            // Mostramos cuantos hilos hay en el grupo
        System.out.println("Numero de threads activos del grupo: " +  grupoHilos.activeCount());
            // ¿Como podemos tratar individualmente cada hilo del grupo?
            // Pues el método enumerate del grupo devuelve un array con todos los hilos del propio grupo...
            // El array que devuelve es de tipo Thread, claro, y hay que crearlo antes...:
            // El problema es el TAMAÑO del array, hay que ponerlo fijo y asefurar que caben tiodos los hilos
            // CUIDADO que aunque parezca que habra 3 hilos, habra mas..... ponermo 8 para no pillarnos
        Thread[] arrayHilos = new Thread[8];
            // y llamamos a enumerate pasandole el array y asi lo rellena
            // para saber cuantos hils hay realmente en el grupo, el metoido enumerate devuelve los que haya añadido
        int cuantoshilos = grupoHilos.enumerate(arrayHilos);
            // vamos ahora a tratar individualmente cada hilo, y pada cada uno, por ejemplo,
            // ver su nombre "interno" y el nombre que le pusimos
            System.out.println("Vemos los hilos del grupo llamado " + grupoHilos.getName());

        for (int i = 0; i < cuantoshilos; i++) {
            System.out.println("El hilo " + i + " se llama " +  arrayHilos[i].getName() );
        }
    }
}


class HiloSimple extends Thread {
    String nombreDeHilo;

    public HiloSimple(String pNombreDeHilo) {
        this.nombreDeHilo = pNombreDeHilo;
    }

    public void run() {
        System.out.println(nombreDeHilo + "  acaba de empezar.");
        Thread t = Thread.currentThread();
        ThreadGroup grupomio = t.getThreadGroup();
        System.out.println("Pertenezco al grupo "+ grupomio.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(nombreDeHilo + "  ha terminado.");
    }

    public String getNombreDeHilo() {        return nombreDeHilo;    }

}