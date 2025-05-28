package ej_psp_04_c_01;

public class Ej_4_c_1 {


    public static void main(String[] args) {

        Monitor m = new Monitor();

        Productor p = new Productor(m);
        Consumidor c = new Consumidor(m);
        p.start();
        c.start();

    }

}


class Productor extends Thread{
    Monitor monitor;
    public Productor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run(){
        while(true){
            monitor.llenarLitros();
        }
    }
}


class Consumidor extends Thread{
    Monitor monitor;
    public Consumidor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run(){
        while(true){
            monitor.vaciarLitros();
        }
    }
}