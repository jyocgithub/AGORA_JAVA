package carrera_caballo_ganador_syncro_ok;

public class Main {
    public static void main(String[] args) {


Monitor m = new Monitor();
        Burro b1 = new Burro("Rucio",m);
        Burro b2 = new Burro("Lucero",m);
        Burro b3 = new Burro("Platero",m);
        Burro b4 = new Burro("Hipócrates",m);

        b1.start();
        b2.start();
        b3.start();
        b4.start();

    }
}
