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
public class PatronCompositeConElipses {
  // ejemplo extraido de wikipedia
  public static void main(String[] args) {
    //Initialize four ellipses
    Ellipse ellipse1 = new Ellipse();
    Ellipse ellipse2 = new Ellipse();
    Ellipse ellipse3 = new Ellipse();
    Ellipse ellipse4 = new Ellipse();

    //Creates two composites containing the ellipses
    CompositeGraphic compositGraphic2 = new CompositeGraphic();
    compositGraphic2.add(ellipse1);
    compositGraphic2.add(ellipse2);
    compositGraphic2.add(ellipse3);

    CompositeGraphic compositGraphic3 = new CompositeGraphic();
    compositGraphic3.add(ellipse4);

    //Create another graphics that contains two graphics
    CompositeGraphic compositGraphic = new CompositeGraphic();
    compositGraphic.add(compositGraphic2);
    compositGraphic.add(compositGraphic3);

    //Prints the complete graphic (Four times the string "Ellipse").
    compositGraphic.print();
  }
}
/** "Componente" */
interface Graphic {
  //Prints the graphic.
  public void print();
}

/** "ComponenteCompuesto" */
class CompositeGraphic implements Graphic {
  //Collection of child graphics.
  private final List<Graphic> childGraphics = new ArrayList<>();

  //Adds the graphic to the composition.
  public void add(Graphic graphic) {
    childGraphics.add(graphic);
  }

  //Prints the graphic.
  @Override
  public void print() {
    for (Graphic graphic : childGraphics) {
      graphic.print();  //Delegation
    }
  }
}

/** "Componente Simple" */
class Ellipse implements Graphic {
  int nombre;

  //Prints the graphic.
  @Override
  public void print() {
    System.out.println("Ellipse");
  }
}
