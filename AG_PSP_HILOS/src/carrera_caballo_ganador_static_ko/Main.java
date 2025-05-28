package carrera_caballo_ganador_static_ko;

public class Main {
    public static void main(String[] args) {

//        Thread caballo1 = new Thread(new Caballo());
//        Thread caballo2 = new Thread(new Caballo());
//        Thread caballo3 = new Thread(new Caballo());
//        Thread caballo4 = new Thread(new Caballo());
//        caballo1.setName("Babieca");
//        caballo2.setName("Rocinante");
//        caballo3.setName("Bucéfalo");
//        caballo4.setName("Marengo");
//        caballo1.start();
//        caballo2.start();
//        caballo3.start();
//        caballo4.start();

        Burro b1 = new Burro("Rucio");
        Burro b2 = new Burro("Lucero");
        Burro b3 = new Burro("Platero");
        Burro b4 = new Burro("Hipócrates");

        b1.start();
        b2.start();
        b3.start();
        b4.start();

    }
}
