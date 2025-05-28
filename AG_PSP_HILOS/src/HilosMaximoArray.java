import java.util.Random;

public class HilosMaximoArray {

    private static final int NUM = 172000000;
    static long mayor1, mayor2;


    public static void main(String[] args) {
        System.out.println("Rellenando aleatorios...");
        long[] numeros = new long[NUM];
        rellenaAleatorios(numeros);
        System.out.println("Array relleno. Empezando búsqueda sin hilos...");
        // Guardamos el tiempo de comienzo del proceso.
        long timeComienzo = System.currentTimeMillis();
        System.out.println("El número máximo es: " + numeroMaximo(numeros));
        System.out.println("Total milesegundos empleados SIN hilos: " + (System.currentTimeMillis() - timeComienzo));


        // opcion 1, subopcion 1
        long[] arra1 = new long[numeros.length / 2];
        long[] arra2 = new long[numeros.length / 2];
        for (int i = 0; i < numeros.length / 2; i++) {
            arra1[i] = numeros[i];
        }
        int a = 0;
        for (int i = numeros.length / 2 + 1; i < numeros.length; i++) {
            arra2[a] = numeros[i];
            a++;
        }

        // opcion 1, subopcion 2
        int b = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (i < numeros.length / 2) {
                arra1[i] = numeros[i];
            } else {
                arra2[b] = numeros[i];
                b++;
            }
        }
        // Guardamos el tiempo de comienzo del proceso y ahora buscamos CON DOS HILOS:.
        timeComienzo = System.currentTimeMillis();
        //        HiloMaximoNumero h1 = new HiloMaximoNumero(1, arra1);
        //        Thread t1 = new Thread(h1);
        //        HiloMaximoNumero h2 = new HiloMaximoNumero(2, arra2);
        //        Thread t2 = new Thread(h2);


        // opcion 2, llamo al hilo con todo el array
        HiloMaximoNumero h1 = new HiloMaximoNumero(1, numeros);
        Thread t1 = new Thread(h1);
        HiloMaximoNumero h2 = new HiloMaximoNumero(2, numeros);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long elmayor;
        if (mayor1 > mayor2) {
            elmayor = mayor1;
        } else {
            elmayor = mayor2;
        }

        System.out.println("El número máximo es: " + elmayor);
        System.out.println("Total milesegundos empleados usando 2 hilos: " + (System.currentTimeMillis() - timeComienzo));
    }

    private static void rellenaAleatorios(long[] num) {
        Random rand = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextLong();
        }
    }

    private static long numeroMaximo(long[] numeros) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        return max;
    }


    static class HiloMaximoNumero implements Runnable {
        int id;
        long[] num;

        public HiloMaximoNumero(int id, long[] num) {
            this.num = num;
            this.id = id;
        }

        public void run() {

            long max = Long.MIN_VALUE;

            //            // opcion 1
            //            for (int i = 0; i < num.length; i++) {
            //                if (num[i] > max) {
            //                    max = num[i];
            //                }
            //            }
            //            if (id == 1) {
            //                mayor1 = max;
            //            } else {
            //                mayor2 = max;
            //            }


            // opcion 2
            if (id == 1) {
                for (int i = 0; i < num.length / 2; i++) {
                    if (num[i] > max) {
                        max = num[i];
                    }
                }
                mayor1 = max;
            } else {
                for (int i = num.length / 2 + 1; i < num.length; i++) {
                    if (num[i] > max) {
                        max = num[i];
                    }
                }
                mayor2 = max;
            }
        }
    }

}


