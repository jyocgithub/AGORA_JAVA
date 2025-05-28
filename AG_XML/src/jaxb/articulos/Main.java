package jaxb.articulos;
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



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void escribirXML(Almacen pGarage) throws JAXBException {
        JAXBContext contexto = JAXBContext.newInstance(Almacen.class);
        Marshaller miMarshaller = contexto.createMarshaller();
        miMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        miMarshaller.marshal(pGarage, new File("JAXBDeArticulos.xml"));
        miMarshaller.marshal(pGarage, System.out);
    }

    public static Almacen leerXML() throws JAXBException {
        JAXBContext contexto = JAXBContext.newInstance(Almacen.class);
        Unmarshaller miUnmarshaller = contexto.createUnmarshaller();
        Almacen almacen = (Almacen) miUnmarshaller.unmarshal(new File("JAXBDeArticulos.xml"));
        return almacen;
    }
    public static void main(String[] args) {

        try {
            Articulo a1 = new Articulo(12, "T12", "Tornillo de punta plana", 130, 12.23);
            Articulo a2 = new Articulo(13, "M5qq", "Martillo de cabeza de goma", 60, 13.77);
            Articulo a3 = new Articulo(15, "NB55E", "Lija de 5 gramos", 2000, 6.23);

            List<Articulo> lista = new ArrayList<>();
            lista.add(a1);
            lista.add(a2);
            lista.add(a3);

            Almacen almacen = new Almacen("zona sur", lista);

            escribirXML(almacen);

            Almacen almacen2 = leerXML();

            System.out.println("................................");
            System.out.println(almacen2);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
