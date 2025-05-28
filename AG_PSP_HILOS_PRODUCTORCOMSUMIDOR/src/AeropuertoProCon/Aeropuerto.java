package AeropuertoProCon;

import java.util.Random;
// A un Aeropuerto le llegan tres camiones con maletas y las coloca en una cinta transportadora. 
// Otro camion recoge las maletas de la cinta.
// En la cinta puede haber un maximo de 10 maletas.        
// Los camiones productores colocan maletas en la cinta, y el camion consumidor recoge, todos sin parar


// El camion productor coloca maletas en la cinta y el c amion consumidor las recoge de la cinta.
public class Aeropuerto {
    public static void main(String[] args) {
        Cinta c = new Cinta();
        Thread prod1 = new Thread(new CamionProductor(1, c));
        Thread prod2 = new Thread(new CamionProductor(2, c));
        Thread prod3 = new Thread(new CamionProductor(3, c));
        Thread con = new Thread(new CamionConsumidor(1, c));
        prod1.start();
        prod2.start();
        prod3.start();
        con.start();
    }
}


class Cinta {

    int numMaletas;

    public Cinta() {
        numMaletas = 0;
    }

    public synchronized void meterMaleta(int idcon) {

        // SI NO PUEDO SEGUIR, ME ESPERO
        while (numMaletas >= 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // SI PUEDO SEGUIR, ACTUO CON LO QUE TENGA QUE HACER 
        numMaletas++;
        System.out.println("soy " + idcon + " y  hay" + numMaletas);

        // AL FINAL, SIEMPRE NOTIFICO A LOS QUE ESTEN ESPERANDO
        notifyAll();
    }

    public synchronized void sacarMaleta() {

        // SI NO PUEDO SEGUIR, ME ESPERO
        while (numMaletas == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // SI PUEDO SEGUIR, ACTUO CON LO QUE TENGA QUE HACER 
        numMaletas--;
        System.out.println("soy consunmidor y  hay" + numMaletas);

        // AL FINAL, SIEMPRE NOTIFICO A LOS QUE ESTEN ESPERANDO
        notifyAll();
    }

}


class CamionProductor implements Runnable {

    int idconsumikdor;
    Cinta cc;

    public CamionProductor(int id, Cinta cc) {
        this.idconsumikdor = id;
        this.cc = cc;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cc.meterMaleta(idconsumikdor);
        }
    }
}

class CamionConsumidor implements Runnable {

    int id;
    Cinta cc;

    public CamionConsumidor(int id, Cinta cc) {
        this.id = id;
        this.cc = cc;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cc.sacarMaleta();
        }
    }
}
