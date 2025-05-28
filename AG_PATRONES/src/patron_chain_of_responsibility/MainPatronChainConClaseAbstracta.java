package patron_chain_of_responsibility;
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

/*
Permite establecer una cadena de objetos receptores a través de los
cuales se pasa una petición formulada por un objeto emisor.
La idea es que cualquiera de los receptores pueden responder a la
petición en función de un criterio establecido.
Encadena los objetos receptores y pasa la petición a través
de la cadena hasta que es procesada por algún objeto.

Ejemplo
Estamos realizando el software para un banco y hay que saber quién puede aprobar un crédito.
Por lo tanto el banco define las siguientes reglas de negocio:
Si la cantidad no supera los 10.000 entonces el Director de Oficina pueda aprobar el préstamo.
Si la cantidad esta entre los 10.000 y 50.000 entonces lo puede aprobar el Gestor de Zona.
Si la cantidad  se encuentra entre 50.000 y 100.000 entonces es el Gerente Provincial quien puede aprobar
Por cantidades superiores a los 100.000 entonces la aprobación la realizará el Analista de Riesgos.

 */
public class MainPatronChainConClaseAbstracta {
    public static void main(String[] args) {
        Banco2 banco = new Banco2();
        banco.pedirUnPrestamo(423001);
    }
}

//-------------------------------------------------
abstract class Aprobador {
    Aprobador siguienteEnLaCadena;

    public void setNext(Aprobador aprobador) {
        siguienteEnLaCadena = aprobador;
    }

    public Aprobador getNext() {
        return siguienteEnLaCadena;
    }

    abstract void solicitarPrestamo(int cantidad);
}

//-------------------------------------------------
class Director_Oficina extends Aprobador {

    @Override
    public void solicitarPrestamo(int cantidad) {
        if (cantidad <= 10_000) {
            System.out.println("Yo me quedo con el trámite, soy el Director de Oficina");
        } else {
            siguienteEnLaCadena.solicitarPrestamo(cantidad);
        }
    }
}

//-------------------------------------------------
class Gestor_de_Zona extends Aprobador {
    @Override
    public void solicitarPrestamo(int cantidad) {
        if (cantidad <= 50_000) {
            System.out.println("Yo me quedo con el trámite, soy el Gestor de Zona");
        } else {
            siguienteEnLaCadena.solicitarPrestamo(cantidad);
        }
    }
}

//-------------------------------------------------
class Gerente_Provincial extends Aprobador {
    @Override
    public void solicitarPrestamo(int cantidad) {
        if (cantidad <= 100_000) {
            System.out.println("Yo me quedo con el trámite, soy el  Gerente Provincial");
        } else {
            siguienteEnLaCadena.solicitarPrestamo(cantidad);
        }
    }
}

//-------------------------------------------------
class Analista_Riesgos extends Aprobador {
    @Override
    public void solicitarPrestamo(int cantidad) {
        System.out.println("Yo me quedo con el trámite, soy el Analista de Riesgos");
    }
}

//-------------------------------------------------
class Banco2 {
    Director_Oficina dire = new Director_Oficina();
    Gestor_de_Zona gestor = new Gestor_de_Zona();
    Gerente_Provincial gerente = new Gerente_Provincial();
    Analista_Riesgos analista = new Analista_Riesgos();

    public Banco2() {
        dire.setNext(gestor);
        gestor.setNext(gerente);
        gerente.setNext(analista);
    }

    public void pedirUnPrestamo(int cantidad) {
        dire.solicitarPrestamo(cantidad);
    }
}
