package clasesInternas;

public class ClaseInicio {

    public static void main(String[] args) {

        Principal p = new Principal();
        Principal.InternaStatic ist = new Principal.InternaStatic();      // SI VALE, es estatica
        //  Principal.InternaPublica ipu = Principal.new InternaPublica();    // ERROR, no es estatica

        Principal.InternaPublica ipu = p.new InternaPublica();            // Si vale, es publica
        //  Principal.InternaPrivada ipr = p.new InternaPrivada();            // ERROR; es privada


    }

}


class Principal {

    int idpricipal;


    public class InternaPublica {

        int idinternapublica;

    }

    private class InternaPrivada {

        int idinternaprivada;

    }

    public static class InternaStatic {

        int idinternaestatica;

    }


}