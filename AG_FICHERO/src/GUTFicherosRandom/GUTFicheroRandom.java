package GUTFicherosRandom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// vamos a almacenar varios objetos de la clase Pieza, con sus atributos

public class GUTFicheroRandom {

    private File fichero;
    private RandomAccessFile raf;
    private int numRegistros;

    // ===== TAMAÑO DEL REGISTRO
    // vamos a guardar cada string con un tamaño definido
    private final int TAM_CODIGO = 10;
    private final int TAM_NOMBRE = 20;
    // vamos a usar WriteUTF y readUTF con los strings, por lo que el tamaño de un registro entero es:
    // 10 + 2 + 20 + 2 + 4  = 36   (10 + 2 del codigo,  20 + 2 del nombre y 4 del precio)
    // el tamaño no es un int, es long, que es lo que devuelve .length()
    private final long TAM_REGISTRO = 38;

    public GUTFicheroRandom(String nombrefichero) {
        this.fichero = new File(nombrefichero);
        try {
            raf = new RandomAccessFile(fichero, "rw"); //en modo lectura/escritura
            long numBytes = raf.length();
            numRegistros = (int) Math.ceil((double) numBytes / (double) TAM_REGISTRO);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }


    public Pieza leerRegistroPorPosicion(int posicion) {

        if (posicion >= 0 && posicion < numRegistros) {

            try {
                //nos situamos en la posicion:
                raf.seek(posicion * TAM_REGISTRO);

                //devuelve lo q hay en el registro (como son 3 atributos necesitamos 3 read)
                String codigo = raf.readUTF().trim();
                String nombre = raf.readUTF().trim();
                int precio = raf.readInt();
                Pieza pieza = new Pieza(codigo, nombre, precio);
                return pieza;
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
        return null;
    }

    private boolean escribirRegistroPorPosicion(int posicion, Pieza nuevaPieza) {

        // este metodo es llamado solo por anadirRegistro y modificarRegistro

        if (posicion >= 0 && posicion <= numRegistros) {
            try {
                raf.seek(posicion * TAM_REGISTRO);
                //escribimos, pero cada String lo ampliamos hasta su tamaño
                String ccodigo = ampliaTamano(nuevaPieza.getCodigo(), TAM_CODIGO);
                raf.writeUTF(ccodigo);
                raf.writeUTF(ampliaTamano(nuevaPieza.getNombre(), TAM_NOMBRE));
                raf.writeInt(nuevaPieza.getPrecio());

                return true;
            } catch (IOException error) {
                System.out.println(error.getMessage());
            }
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean anadirRegistro(Pieza nuevo) {

        if (escribirRegistroPorPosicion(numRegistros, nuevo)) { //xa q anada al final
            numRegistros++;
            return true;
        }
        return false;
    }

    public boolean modificarRegistroPorPosicion(int posicion, Pieza nuevo) {
        if (posicion >= 0 && posicion <= numRegistros) {
            if (escribirRegistroPorPosicion(posicion, nuevo)) {
                return true;
            }
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public Pieza leerRegistroPorCodigo(String codigo) {

        //recorremos los registros:
        for (int i = 0; i < numRegistros; i++) {
            //creamos objeto de tipo Registro y lo leemos con el m�todo leer
            Pieza pieza = leerRegistroPorPosicion(i);
            //comparamos el codigo q le hemos pasado como par�metro con el codigo del objeto registro:
            if (codigo.equals(pieza.getCodigo()))
                return pieza;
        }
        return null;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public void eliminarPorPosicion(int posicion) {
        File ficherotemp = new File("temp.bin");
        int nuevoindice = 0;
        // para borrar un registro,
        // creamos un fichero temp, recorremos el original y copiamos del original lo q vale
        try {
            RandomAccessFile raftemp = new RandomAccessFile(ficherotemp, "rw"); //en modo lectura/escritura
            for (int i = 0; i < numRegistros; i++) {
                if (posicion != i) {
                    Pieza pp = leerRegistroPorPosicion(i);
                    raftemp.seek(nuevoindice * TAM_REGISTRO);
                    //escribimos, pero cada String lo ampliamos hasta su tamaño
                    raftemp.writeUTF(ampliaTamano(pp.getCodigo(), TAM_CODIGO));
                    raftemp.writeUTF(ampliaTamano(pp.getNombre(), TAM_NOMBRE));
                    raftemp.writeInt(pp.getPrecio());
                    nuevoindice++;
                }
            }

            raf.close();
            this.fichero.delete();
            ficherotemp.renameTo(fichero);
            ficherotemp.delete();
            raf = new RandomAccessFile(fichero, "rw"); //en modo lectura/escritura
            long numBytes = raf.length();
            numRegistros = (int) Math.ceil((double) numBytes / (double) TAM_REGISTRO);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String ampliaTamano(String cadenaoriginal, int tamano) {
        if (cadenaoriginal.length() >= tamano) {
            return cadenaoriginal;
        }
        int cuantosBlancosDeboSumar = tamano - cadenaoriginal.length();
        StringBuilder sb = new StringBuilder(cadenaoriginal);
        for (int i = 1; i <= cuantosBlancosDeboSumar; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public int getNumRegistros() {
        return numRegistros;
    }

    public void cerrarFichero() {
        try {
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class Pieza {
    private String codigo;
    private String nombre;
    private int precio;

    public Pieza(String codigo, String nombre, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}