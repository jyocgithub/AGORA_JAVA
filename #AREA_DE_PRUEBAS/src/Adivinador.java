import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Random;

public class Adivinador {
    public static char turno;
    public static boolean acabado = false;
    int edad = 45;

    private static BufferedImage cambiaColorImagen(BufferedImage image, Color micolor) {
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = micolor.getRed();
                pixels[1] = micolor.getGreen();
                pixels[2] = micolor.getBlue();
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }


    public static void main(String[] args) {



//
//
//
//
//        Random azar = new Random();
//        int numero = azar.nextInt(499) + 1;
//        System.out.println("Arbitro: Numero escrito. Comienza la partida");
//        int quienesprimero = azar.nextInt(2);
//        if (quienesprimero == 1) {
//            turno = 'B';
//        } else {
//            turno = 'A';
//        }
//        System.out.println("Empieza " + turno);
//        System.out.println("Deben adivinar el numero " + numero);
//        Compartida compartida = new Compartida();
//        Jugador j1 = new Jugador('A', numero, compartida);
//        Jugador j2 = new Jugador('B', numero, compartida);
//        Thread t1 = new Thread(j1);
//        Thread t2 = new Thread(j2);
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

class Jugador implements Runnable {

    char nombre;
    int numero;
    Compartida compartida;

    public Jugador(char nombre, int numero, Compartida compartida) {
        this.nombre = nombre;
        this.numero = numero;
        this.compartida = compartida;

    }

    @Override
    public void run() {
        int n;
        do {
            n = compartida.adivinar(nombre);
            if (numero == n) Adivinador.acabado = true;
        } while (!Adivinador.acabado);
    }

}

class Compartida {
    public synchronized int adivinar(char nombre) {
        try {
            while (nombre != Adivinador.turno) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int n;
        Random azar = new Random();
        n = azar.nextInt(499) + 1;
        if (!Adivinador.acabado) {
            System.out.println("Jugador " + nombre + ": " + n);
            if (Adivinador.turno == 'A') {
                Adivinador.turno = 'B';
            } else {
                Adivinador.turno = 'A';
            }
        }
        notifyAll();
        return n;
    }
}


