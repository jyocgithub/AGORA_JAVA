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
public class MainPatronChain {
    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.pedirUnPrestamo(733001);
    }
}

//-------------------------------------------------
interface IAprobador{
  void setNext(IAprobador aprobador);
  IAprobador getNext();
  void solicitarPrestamo(int cantidad);
}

//-------------------------------------------------
class DirectorOficina implements IAprobador{
  IAprobador siguienteEnLaCadena;

  @Override
  public void setNext(IAprobador aprobador) {
     siguienteEnLaCadena = aprobador;
  }

  @Override
  public IAprobador getNext() {
    return siguienteEnLaCadena;
  }

  @Override
  public void solicitarPrestamo(int cantidad) {
    if (cantidad <=10_000){
        System.out.println("Yo me quedo con el trámite, soy el Director de Oficina");
    }else{
        siguienteEnLaCadena.solicitarPrestamo(cantidad);
    }
  }
}
//-------------------------------------------------
class GestorDeZona implements IAprobador{
  IAprobador siguienteEnLaCadena;

  @Override
  public void setNext(IAprobador aprobador) {
     siguienteEnLaCadena = aprobador;
  }

  @Override
  public IAprobador getNext() {
    return siguienteEnLaCadena;
  }

  @Override
  public void solicitarPrestamo(int cantidad) {
    if (cantidad <=50_000){
        System.out.println("Yo me quedo con el trámite, soy el Gestor de Zona");
    }else{
        siguienteEnLaCadena.solicitarPrestamo(cantidad);
    }
  }
}
//-------------------------------------------------
class GerenteProvincial implements IAprobador{
  IAprobador siguienteEnLaCadena;

  @Override
  public void setNext(IAprobador aprobador) {
     siguienteEnLaCadena = aprobador;
  }

  @Override
  public IAprobador getNext() {
    return siguienteEnLaCadena;
  }

  @Override
  public void solicitarPrestamo(int cantidad) {
    if (cantidad <=100_000){
        System.out.println("Yo me quedo con el trámite, soy el  Gerente Provincial");
    }else{
        siguienteEnLaCadena.solicitarPrestamo(cantidad);
    }
  }
}
//-------------------------------------------------
class AnalistaRiesgos implements IAprobador{
  IAprobador siguienteEnLaCadena;

  @Override
  public void setNext(IAprobador aprobador) {
     siguienteEnLaCadena = aprobador;
  }

  @Override
  public IAprobador getNext() {
    return siguienteEnLaCadena;
  }

  @Override
  public void solicitarPrestamo(int cantidad) {
        System.out.println("Yo me quedo con el trámite, soy el Analista de Riesgos");
  }
}

//-------------------------------------------------
class Banco  {
    DirectorOficina directorOficina = new DirectorOficina();
    GestorDeZona gestorDeZona = new GestorDeZona();
    GerenteProvincial gerenteProvincial = new GerenteProvincial();
    AnalistaRiesgos analistaRiesgos = new AnalistaRiesgos();

    public Banco() {
        directorOficina.setNext(gestorDeZona);
        gestorDeZona.setNext(gerenteProvincial);
        gerenteProvincial.setNext(analistaRiesgos);
    }

    public void pedirUnPrestamo(int cantidad){
        directorOficina.solicitarPrestamo(cantidad);
    }
}
