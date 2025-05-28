package ej_psp_04_c_01;

public class Monitor {


    private  int capacidadLitros =0;
    private int cuantometer  = 10;
    private int cuantosacar = 5;
    private int limiteDelQueMete = 1000;
    private int limiteDelQueSaca = 900;

    public synchronized void llenarLitros() {
        // EL QUE METE SE PARA CUANDO EL DEPOSITO LLEGA A UN LIMITE QUE PRIMERO ES 1000
        // PERO SUANDO LLEGA A 1000, EL LIMITE PASA A 100, Y SE PARA SI HAY MAS DE 100

        while (capacidadLitros>limiteDelQueMete-cuantometer) {
            try {
                System.out.println("...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Llenamos el depósito
        capacidadLitros=capacidadLitros + cuantometer;


        if(capacidadLitros >=995){    // ponemos 995 por que a 1000 puede que no llegue nunca
            limiteDelQueMete = 100;
            cuantometer = 5;
            cuantosacar = 10;
        }else{
            if(capacidadLitros <= 100){
                limiteDelQueMete = 1000;
                cuantometer = 10;
            }
        }

        System.out.println("llenando " + capacidadLitros + " litros" + " LIMITE METER " + limiteDelQueMete + " CUANTO METO " + cuantometer);

        notifyAll();
    }

    public synchronized void vaciarLitros() {
        // Mientras que el depósito está lleno
        while (capacidadLitros < limiteDelQueSaca+cuantosacar) {
            try {
                System.out.println("...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        capacidadLitros=capacidadLitros - cuantosacar;

        if(capacidadLitros >=900){
            limiteDelQueSaca = 0;
            cuantosacar = 10;
        }else{
            if(capacidadLitros <= 5){   // ponemos 5 por que a 0 puede que no llegue nunca
                limiteDelQueSaca = 900;
                cuantosacar = 5;
                cuantometer = 10;
            }
        }

        System.out.println("vaciando " + capacidadLitros + " litros" + " LIMITE SACAR " + limiteDelQueSaca + " CUANTO SACA " + cuantosacar);

        notifyAll();
    }
}
