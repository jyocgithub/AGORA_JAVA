package cap50_a_02_fabricadetrajes.clases;


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

import cap50_a_02_fabricadetrajes.excepciones.*;
import cap50_a_02_fabricadetrajes.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * FabricaDeTrajes
 *
 */
public class FabricaDeTrajes {

    private HashMap<Integer, Traje> envio;
    private ArrayList<Traje> trajesEnAlmacen;
    private Map<Integer, Componente> componentesEnAlmacen;
    private Utilidades util = new Utilidades();

    public static void main(String[] args) {
        new FabricaDeTrajes().menu();
    }


    public void menu() {
        componentesEnAlmacen = new TreeMap<>();
        trajesEnAlmacen = new ArrayList<>();

        int opcion = -1;
        do {
            try {
                pintarMenu();
                opcion = util.leerIntTeclado("Opcion:");
                switch (opcion) {
                    case 1:
                        añadirComponenteAAlmacen();
                        break;
                    case 2:
                        añadirComponenteAAlmacen();
                        break;
                    case 3:
                        añadirTrajeAAlmacen();
                        break;
                    case 4:
                        añadirComponenteAAlmacen();
                        break;
                    case 5:
                        añadirComponenteAAlmacen();
                        break;
                    case 6:
                        añadirComponenteAAlmacen();
                        break;
                    case 7:
                        añadirComponenteAAlmacen();
                        break;
                    case 8:
                        añadirComponenteAAlmacen();
                        break;
                    case 9:
                        añadirComponenteAAlmacen();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opcion errónea");
                }
            } catch (MangasException | IdException | MuchoExtracomunitarioException | ComponenteInexistenteException e) {
                System.out.println(e.getMessage());
                ;
            } catch (Exception e) {
                System.out.println("error inesperado (" + e.getMessage() + "). Continue por favor.");
                ;
            }
        } while (opcion != 0);
    }


    void pintarMenu() {
        System.out.println("MENU FABRICA TRAJES");
        System.out.println("===================");
        System.out.println("1.- Añadir cap50_a_12_MundialBaloncesto.clases.Componente a almacen");
        System.out.println("2.- Listar Componentes del almacen");
        System.out.println("3.- Crear traje y añadir a almacen");
        System.out.println("4.- Listar trajes del almacen");
        System.out.println("5.- Guardar almancen en fichero");
        System.out.println("6.- Recuperar almancen de fichero");
        System.out.println("7.- Activar/Desactivar las rebajas");
        System.out.println("8.- Preparar un envio y guardarlo en fichero");
        System.out.println("9.- Consultar algun envio guardado en fichero");
        System.out.println("0.- Fin");
    }

    void añadirTrajeAAlmacen() throws ComponenteInexistenteException, TrajeYaExisteException {
        System.out.println("ELEGIR COMPONENTES PARA EL TRAJE");

        System.out.println("ELEGIR BLUSA");
        for (Componente c : componentesEnAlmacen.values()) {

            if (c instanceof Blusa) {
                System.out.println(c);
            }
        }
        int idb = util.leerIntTeclado("Indique numero de blusa para el traje:");
        Blusa blusa = (Blusa) componentesEnAlmacen.get(idb);
        if (blusa == null) {
            ComponenteInexistenteException mex = new ComponenteInexistenteException("Id de componente no existente, cancelada la creacion del traje");
            throw mex;
        }

        System.out.println("ELEGIR CHAQUETA");
        for (Componente c : componentesEnAlmacen.values()) {

            if (c instanceof Chaqueta) {
                System.out.println(c);
            }
        }
        int idc = util.leerIntTeclado("Indique numero de chaqueta para el traje:");
        Chaqueta chaqueta = (Chaqueta) componentesEnAlmacen.get(idc);
        if (chaqueta == null) {
            ComponenteInexistenteException mex = new ComponenteInexistenteException("Id de componente no existente, cancelada la creacion del traje");
            throw mex;
        }

        System.out.println("ELEGIR FALDA o PANTALON");
        for (Componente c : componentesEnAlmacen.values()) {

            if (c instanceof Falda || c instanceof Pantalon) {
                System.out.println(c);
            }
        }
        int idfp = util.leerIntTeclado("Indique numero de una falda o de un pantalon para el traje:");
        Componente com = componentesEnAlmacen.get(idfp);
        if (com == null) {
            ComponenteInexistenteException mex = new ComponenteInexistenteException("Id de componente no existente, cancelada la creacion del traje");
            throw mex;
        }
        String nombretraje = util.leerStringTeclado("¿Que nombre le va a dar al traje?");

        Traje traje = new Traje(nombretraje);
        traje.getPiezas().add(blusa);
        traje.getPiezas().add(chaqueta);
        traje.getPiezas().add(com);

        // comprobar que no exista ya el nombre en el almacen
        boolean nombretrajeyaexiste = false;
        for (Traje t : trajesEnAlmacen) {
            if (t.nombre.equals(nombretraje)) {
                nombretrajeyaexiste = true;
            }
        }
        if (nombretrajeyaexiste) {
            TrajeYaExisteException mex = new TrajeYaExisteException("Nombre del traje ya existe, cancelada la creacion del traje");
            throw mex;
        }
        trajesEnAlmacen.add(traje);
    }


    void añadirComponenteAAlmacen() throws MangasException, MuchoExtracomunitarioException, IdException {
        int opcion = 0;
        String talla;
        int numbotones = 0;
        boolean mangalarga = false, concremallera = false;
        boolean guardar = true;
        boolean seguir = true;
        Componente compo;
        int sumComunitarios = 0;
        String colorBlusa = "";

        do {
            opcion = util.leerIntTeclado("¿Que componente desea añadir al almacen? \n 1.-Chaqueta\n2.-Blusa\n3.-Falda\n4.-Pantalon");
        } while (opcion < 1 || opcion > 4);

        int idNuevo = util.leerIntTeclado("Indique el id:");
        String nombre = util.leerStringTeclado("Indique el nombre de la pieza:");
        do {
            talla = util.leerStringTeclado("Indique la talla (M,S,L,XL) de la pieza:").toUpperCase().trim();
            if (talla.equals("S") || talla.equals("M") || talla.equals("L") || talla.equals("XL")) {
                seguir = false;
            }
        } while (seguir);
        String color = util.leerStringTeclado("Indique el color de la pieza:");
        boolean escomunitario = util.leerBooleanTeclado("Indique si es comunitaria:");
        double precio = util.leerDoubleTeclado("Indique el precio de la pieza:");

        if (opcion == 1) { // chaqueta
            numbotones = util.leerIntTeclado("Indique el numero de botones:");
            compo = new Chaqueta(numbotones, idNuevo, nombre, talla, color, escomunitario, precio);
        } else if (opcion == 2) { // blusa
            mangalarga = util.leerBooleanTeclado("Indique si tiene manga larga:");
            compo = new Blusa(mangalarga, idNuevo, nombre, talla, color, escomunitario, precio);
            //            if (mangalarga) {
            //                colorBlusa = color;
            //            }
        } else if (opcion == 3) { // falda
            concremallera = util.leerBooleanTeclado("Indique si tiene cremallera:");
            compo = new Falda(concremallera, idNuevo, nombre, talla, color, escomunitario, precio);
        } else { // pantalon
            concremallera = util.leerBooleanTeclado("Indique si tiene cremallera:");
            compo = new Pantalon(concremallera, idNuevo, nombre, talla, color, escomunitario, precio);
        }

        // VALIDAR si añadir el componente
        // validar que el id del componente no exista anteriormente, si es asi, no se crea el componente
        // y se da un IdException
        boolean existeId = false;
        for (int i = 0; i < componentesEnAlmacen.size() && !existeId; i++) {
            if (componentesEnAlmacen.get(i).id == idNuevo) {
                existeId = true;
            }
        }
        if (existeId) {
            IdException mex = new IdException("Id de componente ya existente, no se puede añadir la prenda");
            throw mex;
        }


        // no se puede añadir un componente extracomunitario si ya hay mas del 50% de componentes
        // extracomunitarios en el almacen.Si se da esta circunstancia, se produce
        // una excepcion MuchoExtracomunitarioException
        for (Componente com : componentesEnAlmacen.values()) {
            if (!com.isEscomunitario()) {
                sumComunitarios++;
            }
        }
        if (sumComunitarios > (componentesEnAlmacen.size() / 2)) {
            MuchoExtracomunitarioException mex = new MuchoExtracomunitarioException("No se pueden añadir mas componentes extracomunitarios");
            throw mex;

        }
        // no se puede añadir una bluda de manga larga al almacen si no existe ya en el almacen
        // una blusa de manga corta del mismo color, y viceversa. Si se da esta circunstancia, se produce
        // una excepcion MangaException
        boolean existeConMangaCorta = false;
        if (!color.equals("")) {
            for (Componente com : componentesEnAlmacen.values()) {
                if ((com instanceof Blusa)) {
                    Blusa bl = (Blusa) com;
                    if (!bl.isMangaLarga() && bl.getColor().equals(colorBlusa)) {
                        existeConMangaCorta = true;
                        MangasException mex = new MangasException("No hay blusas con manga corta suficientes");
                        throw mex;
                    }
                }
            }
            guardar = existeConMangaCorta;
        }
        // Hay que AJUSTAR el precio del componente antes de añadirlo al almacen
        // Cada chaqueta debe añadir 2 euros mas al precio por cada boton que tenga
        if (compo instanceof Chaqueta) {
            compo.precio += (numbotones * 2);
        }
        // Cada pantalon o falda debe añadir 1 euros mas al precio si tiene cremallera
        if (compo instanceof Pantalon || compo instanceof Falda) {
            if (concremallera) {
                compo.precio += 1;
            }
        }
        //Finalmente se añade el componente al almacen
        componentesEnAlmacen.put(compo.id, compo);
    }


}