import java.io.*;
import java.util.Scanner;

public class GUTFicheros {

    public static void main(String[] args) {

//        escribirFicheroTextoConPrintWriter("prueba_pw.txt");
//        escribirFicheroTextoConOutputStreamReader("prueba_osr.txt");
//        leerFicheroTextoConInputStreamReader( "prueba_osr.txt");
//        escribirFicheroTextoConFileWriter("prueba_fw.txt");
//        leerFicheroTextoConFileReader("prueba_fw.txt");
//        escribirFicheroBinarioConFileOutputStream("prueba_fos.bin");
//        escribirFicheroBinarioConDataOutputStream("prueba_dos.bin");
//        escribirFicheroBinarioConObjectOutputStream("prueba_oos.bin");
//        leerFicheroBinarioConFileInputStream("prueba_fos.bin");
//        leerFicheroBinarioConDataInputStream("prueba_dos.bin");
//        leerFicheroBinarioConObjectInputStream("prueba_oos.bin");
        leerTokensDiversosConScanner("data/tokensmixtos.txt");

    }


    //**************************************************************************************************
    //**************************************************************************************************
    //*****************************      TEXTO      ****************************************************
    //**************************************************************************************************
    //**************************************************************************************************

    // +-----------------------------------------------------------+
    // |                                                           |
    // |                     PRINT WRITER                          |
    // |                                                           |
    // +-----------------------------------------------------------+

    public static void escribirFicheroTextoConPrintWriter(String nombrefichero) {
        // Declarar el objeto de PrintWriter, la clase que usamos para escribir, e iniciallizarla a null
        PrintWriter pw = null;

        try {
            // Instanciar el objeto con el nombre del fichero donde vamos a escribir
            pw = new PrintWriter(new FileWriter(nombrefichero));

            // usar los métodos de PrintWriter para escribir USAR LOS METODOS DEL OBJETO INSTANCIADO PARA ESCRIBIR (write, newline, println...)
            // podemos escribir lineas enteras de strings, con o sin salto de linea
            pw.println("Eva");
            pw.println("Paco");
            pw.print("Luis");

        } catch (IOException e) {
            // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
            System.out.println(e.getMessage());
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase PrintWriter, y lo hacemos en el FINALLY
            // Por si acaso, preguntamos si el objeto de PrinWriter no es null...
            if (pw != null) {
                pw.close();
            }
        }
    }


    // +-----------------------------------------------------------+
    // |                                                           |
    // |        OutputStreamWriter InputStreamReader               |
    // |                                                           |
    // +-----------------------------------------------------------+
    public static void escribirFicheroTextoConOutputStreamReader(String nombrefichero) {

        // Declarar los objetos de OutputStreamWriter y FileOutputStream,
        // las clases que usamos para escribir, e inicializarlas a null
        FileOutputStream fos = null;
        OutputStreamWriter osr = null;
        try {
            // Instanciar los objetos con el nombre del fichero donde vamos a escribir
            fos = new FileOutputStream(nombrefichero);
            osr = new OutputStreamWriter(fos);

            // usar los métodos de OutputStreamWriter para escribir, pero SOLO PUEDE ESCRIBIR CHARS
            // bien uno a uno....
            osr.write('$');
            // bien como un array de chars
            char[] chars = convertirStringEnCharArray("esto es el mensaje");
            osr.write(chars);
            osr.flush();                // No olvidar el flush(), aseguramos que se escriba

        } catch (IOException e) {
            // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
            System.out.println(e.getMessage());
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase OutputStreamWriter, y lo hacemos en el FINALLY
            // Por si acaso, preguntamos si el objeto de OutputStreamWriter no es null...
            // SOLO necesitamos cerrar OutputStreamWriter, pues este cierra de paso FileOutputStream
            if (osr != null) {
                // desgraciadamente, el propio close exige tener su propio try-catch
                try {
                    osr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void leerFicheroTextoConInputStreamReader(String nombrefichero) {
        // comprobamos que el fichero existe, si no, nos dara error
        File fi = new File(nombrefichero);
        if (fi.exists()) {
            // Declarar los objetos de InputStreamReader y FileInputStream,
            // las clases que usamos para escribir, e inicializarlas a null
            FileInputStream fis = null;
            InputStreamReader isr = null;
            try {
                // Instanciar los objetos con el nombre del fichero donde vamos a leer
                fis = new FileInputStream(nombrefichero);
                isr = new InputStreamReader(fis);

                // usar los métodos de InputStreamReader para leer, pero SOLO PUEDE LEER CHARS
                // bien uno a uno....PERO CUIDADO QUE NECESITAN CASTING
                char c = (char) isr.read();
                // bien como un array de chars, QUE SE LE PASA AL METODO COMO PARAMETRO
                char[] chars = new char[19];
                int cuantos = isr.read(chars, 0, 18);  // se indica ademas desde done y hasta donde leer en el array
                System.out.println(c);
                System.out.println(chars);
                System.out.println(cuantos);  // el metodo decuelve cuantos chars ha leido
            } catch (IOException e) {
                // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
                System.out.println(e.getMessage());
            } finally {
                // Es FUNDAMENTAL CERRAR el objeto de la clase OutputStreamWriter, y lo hacemos en el FINALLY
                // Por si acaso, preguntamos si el objeto de OutputStreamWriter no es null...
                // SOLO necesitamos cerrar OutputStreamWriter, pues este cierra de paso FileInputStream
                if (isr != null) {
                    // desgraciadamente, el propio close exige tener su propio try-catch
                    try {
                        isr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    // +-----------------------------------------------------------+
    // |                                                           |
    // |                FILEWRITER   FILEREADER                    |
    // |                                                           |
    // +-----------------------------------------------------------+
    public static void escribirFicheroTextoConFileWriter(String nombrefichero) {

        // Declarar el objetos de FileWriter,
        // la clase que usamos para escribir, e inicializarla a null
        FileWriter fw = null;
        try {
            // Instanciar el objeto con el nombre del fichero donde vamos a escribir
            fw = new FileWriter(nombrefichero);

            // usar los métodos de FileWriter para escribir, pero SOLO PUEDE ESCRIBIR CHARS
            // bien uno a uno....
            fw.write('$');
            // bien como un array de chars
            char[] chars = convertirStringEnCharArray("esto es el mensaje");
            fw.write(chars);
            fw.flush();                // No olvidar el flush(), aseguramos que se escriba

        } catch (IOException e) {
            // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
            System.out.println(e.getMessage());
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase FileWriter, y lo hacemos en el FINALLY
            // Por si acaso, preguntamos si el objeto de FileWriter no es null...
            if (fw != null) {
                // desgraciadamente, el propio close exige tener su propio try-catch
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void leerFicheroTextoConFileReader(String nombrefichero) {
        // comprobamos que el fichero existe, si no, nos dara error
        File fi = new File(nombrefichero);
        if (fi.exists()) {
            // Declarar el objetos de FileReader,
            // la clase que usamos para escribir, e inicializarla a null
            FileReader fr = null;
            try {
                // Instanciar los objetos con el nombre del fichero donde vamos a leer
                fr = new FileReader(nombrefichero);

                // usar los métodos de FileReader para leer, pero SOLO PUEDE LEER CHARS
                // bien uno a uno....PERO CUIDADO QUE NECESITAN CASTING
                char c = (char) fr.read();
                // bien como un array de chars, QUE SE LE PASA AL METODO COMO PARAMETRO
                char[] chars = new char[19];
                int cuantos = fr.read(chars, 0, 18);  // se indica ademas desde done y hasta donde leer en el array

                System.out.println(c);
                System.out.println(chars);
                System.out.println(cuantos);  // el metodo decuelve cuantos chars ha leido

            } catch (IOException e) {
                // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
                System.out.println(e.getMessage());
            } finally {
                // Es FUNDAMENTAL CERRAR el objeto de la clase FileReader, y lo hacemos en el FINALLY
                // Por si acaso, preguntamos si el objeto de FileReader no es null...
                if (fr != null) {
                    // desgraciadamente, el propio close exige tener su propio try-catch
                    try {
                        fr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    // +-----------------------------------------------------------+
    // |                                                           |
    // |        BUFFEREDWRITER         BUFFEREDREADER              |
    // |                                                           |
    // +-----------------------------------------------------------+
    public static void escribirFicheroTextoConBufferedReader(String nombrefichero) {

        // Declarar los objetos de FileWriter y BufferedWriter,
        // las clases que usamos para escribir, e inicializarlas a null
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            // Instanciar los objetos con el nombre del fichero donde vamos a escribir
            fw = new FileWriter(nombrefichero);
            bw = new BufferedWriter(fw);

            // usar los métodos de BufferedWriter para escribir, que son los MISMOS DE FILEWRITER
            bw.write('$');
            // ... Y ADEMAS PUEDE ESCRIBIR STRINGS ENTEROS
            bw.write("LINEA DE TEXTO");
            // ... Y ADEMAS PUEDE ESCRIBIR SALTOS DE LINEA
            bw.newLine();


        } catch (IOException e) {
            // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
            System.out.println(e.getMessage());
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase BufferedWriter, y lo hacemos en el FINALLY
            // Por si acaso, preguntamos si el objeto de BufferedWriter no es null...
            // SOLO necesitamos cerrar OutputStreamWriter, pues este cierra de paso FileWriter
            if (bw != null) {
                // desgraciadamente, el propio close exige tener su propio try-catch
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void leerFicheroTextoConBufferedReader(String nombrefichero) {

        // comprobamos que el fichero existe, si no, nos dara error
        File fi = new File(nombrefichero);
        if (fi.exists()) {
            // Declarar los objetos de FileReader y BufferedReader,
            // las clases que usamos para escribir, e inicializarlas a null
            FileReader fr = null;
            BufferedReader br = null;
            try {
                // Instanciar los objetos con el nombre del fichero donde vamos a leer
                fr = new FileReader(nombrefichero);
                br = new BufferedReader(fr);

                // leemos linea al linea todos los contenidos escritos en el fichero
                String linea = br.readLine();
                while (linea != null) {
                    System.out.println(linea);

                    br.readLine();
                }
            } catch (IOException e) {
                // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
                System.out.println(e.getMessage());
            } finally {
                // Es FUNDAMENTAL CERRAR el objeto de la clase BufferedReader, y lo hacemos en el FINALLY
                // Por si acaso, preguntamos si el objeto de BufferedReader no es null...
                // SOLO necesitamos cerrar OutputStreamWriter, pues este cierra de paso FileReader
                if (br != null) {
                    // desgraciadamente, el propio close exige tener su propio try-catch
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    //**************************************************************************************************
    //**************************************************************************************************
    //*****************************      BINARIOS   ****************************************************
    //**************************************************************************************************
    //**************************************************************************************************

    // +-----------------------------------------------------------+
    // |                                                           |
    // |        FILEINPUTSTREAM         FILEOUTPUTSTREAM           |
    // |                                                           |
    // +-----------------------------------------------------------+
    public static void escribirFicheroBinarioConFileOutputStream(String nombrefichero) {

        // Declarar los objetos de FileOutputStream,
        // la clase que usamos para escribir, e inicializarla a null
        FileOutputStream fos = null;
        try {
            // Instanciar los objetos con el nombre del fichero donde vamos a escribir
            fos = new FileOutputStream(nombrefichero);

            // usar los métodos de FileOutputStream para escribir. Puede escribir un byte, o array de bytes
            String mensaje = "buenas que tal";
            byte[] bytes = mensaje.getBytes();
            fos.write(bytes);

        } catch (IOException e) {
            // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
            System.out.println(e.getMessage());
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase FileOutputStream, y lo hacemos en el FINALLY
            // Por si acaso, preguntamos si el objeto de FileOutputStream no es null...
            if (fos != null) {
                // desgraciadamente, el propio close exige tener su propio try-catch
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void leerFicheroBinarioConFileInputStream(String nombrefichero) {

        // comprobamos que el fichero existe, si no, nos dara error
        File fi = new File(nombrefichero);
        if (fi.exists()) {
            // Declarar los objetos de FileInputStream
            // las clases que usamos para escribir, e inicializarlas a null
            FileInputStream fis = null;
            try {
                // Instanciar los objetos con el nombre del fichero donde vamos a leer
                fis = new FileInputStream(nombrefichero);

                // leemos bytes o arrays de bytes
                byte[] bytes = new byte[100];
                int cuantos = fis.read(bytes);
                System.out.println(new String(bytes).trim());

            } catch (IOException e) {
                // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
                System.out.println(e.getMessage());
            } finally {
                // Es FUNDAMENTAL CERRAR el objeto de la clase FileInputStream, y lo hacemos en el FINALLY
                // Por si acaso, preguntamos si el objeto de FileInputStream no es null...
                if (fis != null) {
                    // desgraciadamente, el propio close exige tener su propio try-catch
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    // +-----------------------------------------------------------+
    // |                                                           |
    // |        DATAINPUTSTREAM         DATAOUTPUTSTREAM           |
    // |                                                           |
    // +-----------------------------------------------------------+
    public static void escribirFicheroBinarioConDataOutputStream(String nombrefichero) {

        // Declarar los objetos de FileOutputStream y DataOutputStream,
        // las clases que usamos para escribir, e inicializarlas a null
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            // Instanciar los objetos con el nombre del fichero donde vamos a escribir
            fos = new FileOutputStream(nombrefichero);
            dos = new DataOutputStream(fos);

            // usar los métodos de DataOutputStream para escribir, que son los MISMOS DE FileOutputStream
            dos.writeInt(345);

            // ... Y ADEMAS PUEDE ESCRIBIR STRINGS ENTEROS
            dos.writeUTF("LINEA 1 DE TEXTO");
            dos.writeUTF("LINEA 2 DE TEXTO");
            dos.writeUTF("LINEA ULTIMA DE TEXTO");

        } catch (IOException e) {
            // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
            System.out.println(e.getMessage());
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase DataOutputStream, y lo hacemos en el FINALLY
            // Por si acaso, preguntamos si el objeto de DataOutputStream no es null...
            // SOLO necesitamos cerrar DataOutputStream, pues este cierra de paso FileOutputStream
            if (dos != null) {
                // desgraciadamente, el propio close exige tener su propio try-catch
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void leerFicheroBinarioConDataInputStream(String nombrefichero) {

        // comprobamos que el fichero existe, si no, nos dara error
        File fi = new File(nombrefichero);
        if (fi.exists()) {
            // Declarar los objetos de FileInputStream y DataInputStream,
            // las clases que usamos para escribir, e inicializarlas a null
            FileInputStream fis = null;
            DataInputStream dis = null;
            try {
                // Instanciar los objetos con el nombre del fichero donde vamos a leer
                fis = new FileInputStream(nombrefichero);
                dis = new DataInputStream(fis);

                // leemos valore sueltos si sabemos donde estan
                int b = dis.readInt();
                System.out.println(b);
                // leemos hasta fin de fichero.... forzando a que termine y controlando la excepcion EOFException
                while (true) {
                    String algo = dis.readUTF();
                    System.out.println(algo);
                }
            } catch (EOFException e) {
                System.out.println("se llega al fin de fichero"); // Si se llega al final de fichero, no hacemos nada
            } catch (IOException e) {
                // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
                System.out.println(e.getMessage());
            } finally {
                // Es FUNDAMENTAL CERRAR el objeto de la clase DataInputStream, y lo hacemos en el FINALLY
                // Por si acaso, preguntamos si el objeto de DataInputStream no es null...
                // SOLO necesitamos cerrar DataInputStream, pues este cierra de paso FileInputStream
                if (dis != null) {
                    // desgraciadamente, el propio close exige tener su propio try-catch
                    try {
                        dis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // +-----------------------------------------------------------+
    // |                                                           |
    // |        OBJECTINPUTSTREAM         OBJECTOUTPUTSTREAM       |
    // |                                                           |
    // +-----------------------------------------------------------+
    public static void escribirFicheroBinarioConObjectOutputStream(String nombrefichero) {

        // Declarar los objetos de FileOutputStream y ObjectOutputStream,
        // las clases que usamos para escribir, e inicializarlas a null
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // Instanciar los objetos con el nombre del fichero donde vamos a escribir
            fos = new FileOutputStream(nombrefichero);
            oos = new ObjectOutputStream(fos);

            // usar los métodos de DataOutputStream para escribir, que son los MISMOS DE FileOutputStream
            oos.writeInt(721);
            // ... Y ADEMAS PUEDE ESCRIBIR OBJETOS ENTEROS. EN ESTE CASO DE LA CLASE BLUSA
            Blusa b1 = new Blusa("Terra", 123);
            Blusa b2 = new Blusa("Supra", 456);

            oos.writeObject(b1);
            oos.writeObject(b2);

        } catch (IOException e) {
            // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
            System.out.println(e.getMessage());
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase ObjectOutputStream, y lo hacemos en el FINALLY
            // Por si acaso, preguntamos si el objeto de ObjectOutputStream no es null...
            // SOLO necesitamos cerrar DataOutputStream, pues este cierra de paso FileOutputStream
            if (oos != null) {
                // desgraciadamente, el propio close exige tener su propio try-catch
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void leerFicheroBinarioConObjectInputStream(String nombrefichero) {

        // comprobamos que el fichero existe, si no, nos dara error
        File fi = new File(nombrefichero);
        if (fi.exists()) {
            // Declarar los objetos de FileInputStream y DataInputStream,
            // las clases que usamos para escribir, e inicializarlas a null
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                // Instanciar los objetos con el nombre del fichero donde vamos a leer
                fis = new FileInputStream(nombrefichero);
                ois = new ObjectInputStream(fis);

                // leemos valore sueltos si sabemos donde estan
                int b = ois.readInt();
                System.out.println(b);
                // leemos hasta fin de fichero.... forzando a que termine y controlando la excepcion EOFException
                while (true) {
                    Blusa blu = (Blusa) ois.readObject(); // CUIDADO; NECSITA SIEMPRE UN CASTING
                    System.out.println(blu);
                }
            } catch (EOFException e) {
                System.out.println("se llega al fin de fichero"); // Si se llega al final de fichero, no hacemos nada
            } catch (IOException e) {
                // Se necesita un catch que controle errores, con IOEXception vale para todos los errores
                e.printStackTrace();
            } catch (ClassNotFoundException e) { // NECSITAMOS UN CATCH MAS que en otros casos
                e.printStackTrace();
            } finally {
                // Es FUNDAMENTAL CERRAR el objeto de la clase DataInputStream, y lo hacemos en el FINALLY
                // Por si acaso, preguntamos si el objeto de DataInputStream no es null...
                // SOLO necesitamos cerrar DataInputStream, pues este cierra de paso FileInputStream
                if (ois != null) {
                    // desgraciadamente, el propio close exige tener su propio try-catch
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    //**************************************************************************************************
    //**************************************************************************************************
    //*****************************  TEXTO Y BINARIO JUNTOS  *******************************************
    //**************************************************************************************************
    //**************************************************************************************************


    // +-----------------------------------------------------------+
    // |                                                           |
    // |               SCANNER LEYENDO LINEAS                      |
    // |                                                           |
    // +-----------------------------------------------------------+

    public static void leerFicheroTextoConScanner(String nombrefichero) {
        // Declarar el objeto de Scanner, la clase que usamos para leer, e iniciallizarla a null
        Scanner sc = null;
        File file = new File(nombrefichero);
        try {
            // Instanciar el objeto con el nombre del fichero donde vamos a escribir
            sc = new Scanner(file);

            // leemos linea al linea todos los contenidos escritos en el fichero
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            // Se necesita un catch que controle errores, a qui solo controla el FileNotFoudException
            System.out.println("no se encuentra el fichero " + nombrefichero);
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase Scanner, y lo hacemos en el FINALLY
            sc.close();
        }
    }

    // +-----------------------------------------------------------+
    // |                                                           |
    // |               SCANNER LEYENDO TOKENS IDENTICOS            |
    // |                                                           |
    // +-----------------------------------------------------------+

    public static void leerTokensIdenticosConScanner(String nombrefichero) {
        // Declarar el objeto de Scanner, la clase que usamos para leer, e iniciallizarla a null
        Scanner sc = null;
        File file = new File(nombrefichero);
        try {
            // Instanciar el objeto con el nombre del fichero donde vamos a escribir
            sc = new Scanner(file);

            // leemos linea al linea todos los contenidos escritos en el fichero
            while (sc.hasNext()) {
                String palabra = sc.next();
                System.out.println(palabra);
            }
        } catch (FileNotFoundException e) {
            // Se necesita un catch que controle errores, a qui solo controla el FileNotFoudException
            System.out.println("no se encuentra el fichero " + nombrefichero);
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase Scanner, y lo hacemos en el FINALLY
            sc.close();
        }
    }

    // +-----------------------------------------------------------+
    // |                                                           |
    // |               SCANNER LEYENDO TOKENS DIVERSOS             |
    // |                                                           |
    // +-----------------------------------------------------------+

    public static void leerTokensDiversosConScanner(String nombrefichero) {
        // Declarar el objeto de Scanner, la clase que usamos para leer, e iniciallizarla a null
        Scanner scanner = null;
        File file = new File(nombrefichero);
        try {
            // Instanciar el objeto con el nombre del fichero donde vamos a escribir
            scanner = new Scanner(file);

            // vemos si hay algo mas, del tipo que sea
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int valor = scanner.nextInt();
                    System.out.println("Entero: " + valor);
                } else if (scanner.hasNextDouble()) {
                    double valor = scanner.nextDouble();
                    System.out.println("Double: " + valor);
                } else {
                    String valor = scanner.next();
                    System.out.println("String: " + valor);
                }
            }
        } catch (FileNotFoundException e) {
            // Se necesita un catch que controle errores, a qui solo controla el FileNotFoudException
            System.out.println("no se encuentra el fichero " + nombrefichero);
        } finally {
            // Es FUNDAMENTAL CERRAR el objeto de la clase Scanner, y lo hacemos en el FINALLY
            scanner.close();
        }
    }


    //**************************************************************************************************
    //**************************************************************************************************
    //*****************************      UTILIDADES   ****************************************************
    //**************************************************************************************************
    //**************************************************************************************************


    public static char[] convertirStringEnCharArray(String texto) {
        char[] charray = new char[texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            charray[i] = texto.charAt(i);
        }
        return charray;
    }


}


class Blusa implements Serializable {
    private String marca;
    private int precio;

    public Blusa(String marca, int precio) {
        this.marca = marca;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "marca='" + marca + " - precio=" + precio;
    }
}