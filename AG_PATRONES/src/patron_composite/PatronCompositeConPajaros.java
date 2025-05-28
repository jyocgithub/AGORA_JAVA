package patron_composite;
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
import java.util.ArrayList;
import java.util.List;

/** Client */
public class PatronCompositeConPajaros {
  public static void main(String[] args) {
    Pajaro pajaro1 = new Loro("Lorina");
    Pajaro pajaro2 = new Loro("Loreto");
    Pajaro pajaro3 = new Canario("Canarinha");
    Pajaro pajaro4 = new Canario("Canariofagus");
    Pajaro pajaro5 = new Loro("Lorenzo");

    //Creamos los composites que tendran dentro los pajaros
    PajaroComposicion compuestoRaiz = new PajaroComposicion();
    PajaroComposicion compuestoH1 = new PajaroComposicion();
    PajaroComposicion compuestoH2 = new PajaroComposicion();

    compuestoH1.add(pajaro1);
    compuestoH1.add(pajaro2);
    compuestoH1.add(pajaro3);

    compuestoH2.add(pajaro4);

    compuestoRaiz.add(compuestoH1);
    compuestoRaiz.add(compuestoH2);
    compuestoRaiz.add(pajaro5);

    //Prints the complete graphic (Four times the string "Ellipse").
    compuestoRaiz.print();
  }
}

/** "Interfaz de componentes" */
interface Pajaro {
  //Prints the graphic.
  public void print();
}

/** "ComponenteCompuesto" */
class PajaroComposicion implements Pajaro {
  // Coleccion de pajaros.
  private final List<Pajaro> listapajaros = new ArrayList<>();

  // Mete el pajaro en la composicion
  public void add(Pajaro pajaro) {
    listapajaros.add(pajaro);
  }

  // Escribe el pajaro.
  @Override
  public void print() {
    for (Pajaro pajaro : listapajaros) {
      pajaro.print();  // Delegacion
    }
  }
}

/** "Componente Simple" */
class Loro implements Pajaro {
  String nombre;

  public Loro(String nombre) {
    this.nombre = nombre;
  }

  //Prints the graphic.
  @Override
  public void print() {
    System.out.println(nombre + " dice : Ron ron ron");
  }
}
class Canario implements Pajaro {
  String nombre;

  public Canario(String nombre) {
    this.nombre = nombre;
  }

  //Prints the graphic.
  @Override
  public void print() {
    System.out.println(nombre + " dice : Pipipiripipi");
  }
}
