package aaPruebasSencillas;

import java.io.*;

public class PruebasCLasesInternas {

    public static void main(String[] args) throws IOException {
        new PruebasCLasesInternas().hacerCosas();
    }

    public void hacerCosas() {
        ClaseContenedora extObj = new ClaseContenedora();
        ClaseContenedora.Interna intObj = extObj.new Interna("UnNombre");
        extObj.algo();
        intObj.algo();
    }
}

class ClaseContenedora {
    String IdCC;
    int intEnLaContenedora;
    Interna objIntEnExt;

    public ClaseContenedora(String IdCC) {
        objIntEnExt = new Interna("OtroNombre");
    }

    public ClaseContenedora() {
    }

    public void algo() {
        IdCC = "fuera";
        System.out.println(IdCC);
    }
    public void algofuera() {
        IdCC = "algofuera";
        System.out.println(IdCC);
    }

    public class Interna {
        String nom;
        String IdCC;

        public Interna(String nom) {
            this.nom = nom;
        }

        public void algo() {
            intEnLaContenedora =23;
            IdCC = "dentro";
            System.out.println(IdCC);
            algofuera();
            ClaseContenedora.this.algofuera();
        }

    }
}













