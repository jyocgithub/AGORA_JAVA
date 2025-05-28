package ej_psp_02_a_05;

public class ej_psp_02_a_05 {


    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();

        Corredor c1 = new Corredor(1);
        Corredor c2 = new Corredor(2);
        Corredor c3 = new Corredor(3);
        Corredor c4 = new Corredor(4);

        try {
            c1.start();
            c1.join();

            c2.start();
            c2.join();

            c3.start();
            c3.join();

            c4.start();
            c4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fin = System.currentTimeMillis();
        System.out.println(" se tardaron " + (fin - inicio) + " milisegundos");
    }


}


class Corredor extends Thread {
    int numero;

    public Corredor(int numero) {
        this.numero = numero;
    }

    public void run() {


        System.out.println("-------> El corredor " + numero + " inicia su carrera ");
        for (int i = 0; i < 10; i++) {
            System.out.println("--> El corredor " + numero + " da el paso " + i);

            int milisegundos = (int) (Math.random() * 100);  // da un numero al azar entre 1000 y 10000

            try {
                Thread.sleep(milisegundos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-------> El corredor " + numero + " acaba su carrera ");


    }


}