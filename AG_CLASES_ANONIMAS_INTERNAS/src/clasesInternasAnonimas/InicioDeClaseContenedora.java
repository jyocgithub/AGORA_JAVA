package clasesInternasAnonimas;


public class InicioDeClaseContenedora {

    public void hacerCosas() {
        ClaseContenedora extObj = new ClaseContenedora();
        ClaseContenedora.Interna intObj = extObj.new Interna();
    }

    public static void main(String args[]) {
        ClaseContenedora cc = new ClaseContenedora();
        new InicioDeClaseContenedora().hacerCosas();
    }
}

class ClaseContenedora {
    String IdCC;
    Interna intEnExt;
    public ClaseContenedora(String IdCC) {
        this.IdCC = IdCC;
        intEnExt = new Interna("Int1");
    }
    public ClaseContenedora() {
    }
    public class Interna {
        String nom;
        public Interna() {
        }
        public Interna(String nom) {
            this.nom = nom;
        }
    }
}


class Juguetear {
    Juguetear() {
        ClaseContenedora s = new ClaseContenedora("lj");
        ClaseContenedora.Interna mci = s.new Interna("Luis");

    }

}