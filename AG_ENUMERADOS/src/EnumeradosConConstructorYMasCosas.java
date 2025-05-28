
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

public class EnumeradosConConstructorYMasCosas {

    public static void main(String[] args) {
        System.out.println("este mensaje sale antes de construir los valores del enumerado");
        EProvinciasExtremadura pro1 = EProvinciasExtremadura.CACERES;
        EProvinciasExtremadura pro2 = EProvinciasExtremadura.BADAJOZ;

        System.out.println(pro1.nacion);                 // a este atributo accedo directo por que es publico

        pro1.setPrefijoPostal("887");                    // a los atributos privados se accede con un get y set normal
        pro2.setPrefijoPostal("998");
        System.out.println(pro1.getPrefijoPostal());
        System.out.println(pro2.getPrefijoPostal());

        pro1.poblacion = 300000;   // a los atributos y metodos publicos se accede directamente, claro
        pro2.poblacion = 400000;
        System.out.println(pro1.porcentajeEnComunidad());
        System.out.println(pro2.porcentajeEnComunidad());

        // podemos usar atributos estáticos normalmente
        EProvinciasExtremadura.codInternacional = 34;
        System.out.println(EProvinciasExtremadura.codInternacional);

        // podemos usar metodos estáticos normalmente
        EProvinciasExtremadura.esCodigoViejo();

    }
}


enum EProvinciasExtremadura {       // definicion de un enumerado con atributos, constructor y getter

    // Lo primero que ha de tener el enumerado siempre es la declaracion de sus miembros.
    // En este caso es una llamada al constructor que hay mas adelante,
    // pues asi se asigna valor a algunos de los atributos de cada elemento enumerado (no tiene por que ser todos)
    CACERES("10", 927),
    BADAJOZ("06", 924);

    // Aqui estan los atributos de cada enumerado, el orden no importa.
    // Pueden tener valores prefijados o constantes y ser public o private.... o protected
    public int prefijoTelefonico;
    private String prefijoPostal;
    public int poblacion;
    public String nacion = "España";
    public static int codInternacional = 34;

    // Este es el constructor que se usa para crear los elementos del enumerado
    // Es PRIVATE pues solo se puede usar dentro de la propia clase enum, de hecho no hace falta ni poner private
    // Se puede usar como un constructor normal, con más codigo que la asignacion de atributos.
    // Este constructor se ejecuta (y da valor a TODOS los miembros de la clase) la primera vez que se crea un objeto de la
    //   clase enum, no antes, y solo UNA VEZ PARA CADA OBJETO
    private EProvinciasExtremadura(String pp, int pt) {
        this.prefijoPostal = pp;
        this.prefijoTelefonico = pt;
    }

    // si hay atributos privados, necesito getters y setters para ellos
    public String getPrefijoPostal() {
        return prefijoPostal;
    }

    public void setPrefijoPostal(String prefijoPostal) {
        this.prefijoPostal = prefijoPostal;
    }

    // puedo tener métodos normales, y acceder a mis atributos con this...
    public double porcentajeEnComunidad() {
        int totalComunidad = CACERES.poblacion + BADAJOZ.poblacion;
        double porcen = this.poblacion * 100 / totalComunidad;
        return porcen;
    }

    public static void esCodigoViejo() {
        if (codInternacional > 999) {
            System.out.println("Es de los nuevos codigos universales");
        } else {
            System.out.println("Es de los viejos codigos terrestres");
        }
    }

}
