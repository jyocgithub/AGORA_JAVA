package hilosAdivinarNumero;

import java.util.Random;

public class HilosAdivinarNumero {


    public static void main(String[] args) {

        int x  = 3;
        int f;
        if (x==3){
            f=x;
        }else{
            f=x+2;
        }

        f = x==3 ? x : x+2;

        Random r = new Random();
        int numero = r.nextInt(500) + 1;
        System.out.println("Numero a adivinar :" + numero);
        int quienempieza = r.nextInt(2)+1;
        System.out.println("Empieza :" + quienempieza);

        Monitor monitor = new Monitor(numero);

        Jugador j1 = new Jugador(1, monitor  ,quienempieza);
        Jugador j2 = new Jugador(2, monitor,quienempieza);
        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);
        t1.start();
        t2.start();

    }


    static class Jugador implements Runnable {
        int id;
        Monitor monitor;
        int quienempieza;

        public Jugador(int id, Monitor monitor,    int quienempieza) {
            this.id = id;
            this.monitor = monitor;
            this.quienempieza = quienempieza;
        }

        public void run() {
            boolean acerto = false;

            while (!acerto) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                if(quienempieza==id || monitor.yasehaempezado ){
                   monitor.yasehaempezado=true;
                   acerto = monitor.elegir(id);
                }
            }
        }
    }


    static class Monitor {
        int numero;
        boolean yasehaempezado=false;

        Random r = new Random();
        boolean fin = false;

        public Monitor(int numero) {
            this.numero = numero;
        }

        public synchronized boolean elegir(int id) {
            if(fin==true){
                return true;
            }
            int numeroelegido = r.nextInt(500) + 1;
            System.out.println("Soy " + id + " y mi numero elegido: " + numeroelegido);
            if (numeroelegido == numero) {
                notify();
                fin = true;
                return true;
            } else {
                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

}




