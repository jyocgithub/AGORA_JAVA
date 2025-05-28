package comunicacion_entre_procesos;

import java.io.*;

public class ComunicacionEntreProcesos_Padre {

    public static void main(String args[]) {
        try {
            // =================================================================================
            //           CREAR UN PROCESO NUEVO, un proceso hijo de este, en dos pasos:
            // =================================================================================
            // 1.- Creo un "ConstructorDeProcesos" (ProcessBuilder) con los argumentos del proceso
            // que quiero crear, En este caso, es el jar ejecutable que se ha debido de crear anteriormente
            ProcessBuilder proBuil = new ProcessBuilder("java", "-jar", "ComunicacionEntreProcesos_Hijo.jar");

            // 2.- Creo el proceso, arrancando el "ConstructorDeProcesos"
            Process procesoHijo = proBuil.start();

            // =================================================================================
            //              CREAR UN CANAL PARA LEER LO QUE ENVIE EL TECLADO
            // =================================================================================
            // Esto se hace normalmente en menos lineas, pero se va a hace en varias para compararlo despues
            // con el objeto que usaremos para leer, no de teclado, sino de un proceso. En dos pasos;
            // 1.- Creo un stream (canal) para que LEA DE LA ENTRADA ESTANDAR de mi programa,
            // al System.in, que es el teclado
            InputStream streamLeerDeTeclado = System.in;

            // 2.- Con el objeto stream, creo un iniciador y un filtro para usar sus metodos y leer datos.
            InputStreamReader canalLeerDeTeclado = new InputStreamReader(streamLeerDeTeclado);
            BufferedReader maquinaLeerDeTeclado = new BufferedReader(canalLeerDeTeclado);

            // =================================================================================
            //               CREAR UN CANAL PARA LEER LO QUE ENVIE EL PROCESO HIJO.
            // =================================================================================
            // 1.- Creo un stream (canal) para que LEA, NO DE MI ENTRADA ESTANDAR, SINO DE LA
            // SALIDA DEL PROCESO hijo, esto es, lo que éste escriba, SE ENVIA A ESTE PROGRAMA COMO SI LO
            // HUBIESE ENVIADO EL TECLADO.
            // En obISHijo creo el canal para leer datos del hijo (que apunta a su System.out)
            // getInputStream() nos decuelve precisamente la salida estandar del proceso (su System.out)
            InputStream streamLeerDeHijo = procesoHijo.getInputStream();

            // 2.- Con el objeto stream, para leer lo que emita el proceso,
            // creo un iniciador y un filtro para poder usar sus metodos y leer datos.
            // Normalmente, donde esta obInpStrRea, la "puerta" donde leer,
            // deberia ir System.in o el nombre de un fichero donde leer,
            // pero aqui colocamos la salida del proceso hijo.
            InputStreamReader canalLeerDeHijo = new InputStreamReader(streamLeerDeHijo);
            BufferedReader maquinaLeerDeHijo = new BufferedReader(canalLeerDeHijo);

            // =================================================================================
            //            CREAR UN CANAL PARA ENVIAR COSAS (ESCRIBIR) HACIA EL PROCESO HIJO
            // =================================================================================
            // 1.- Creo un stream para enviar datos al proceso hijo.
            // En obOSHijo creo el canal para enviar datos al hijo (que apunta a su System.in)
            // getOutputStream() nos decuelve precisamente la entrada estandar del proceso (su System.in)
            OutputStream streamEscribirEnHijo = procesoHijo.getOutputStream();

            // 2.- Con el objeto stream, para escribir hacia el proceso,
            // creo un objeto de PrintStream poder usar sus metodos y escribir datos
            // El segundo parametro dice que se active el autoflush.
            PrintStream maquinaEscribirEnHijo = new PrintStream(streamEscribirEnHijo, true);


            // =================================================================================
            //         LEEMOS DE TECLADO Y LO MANDAMOS AL PROCESO HIJO
            // =================================================================================

            // -------------------------- LEER POR TECLADO Y ENVIAR A PROCESO HIJO
            // Leo lineas de texto por teclado
            System.out.println("Introduce varias lineas de texto, y acaba con una linea que sea FIN");
            String lineaLeidaPorTeclado = maquinaLeerDeTeclado.readLine();

            // Mientras no se escriba la linea FIN se siguen leyendo lineas,
            while (!lineaLeidaPorTeclado.equals("FIN") && lineaLeidaPorTeclado != null) {

                // Se envia al proceso hijo la linea leida.
                // Se usa el objeto OBSHijo que ya apunta a su entrada estandar (como si fuera su teclado)
                // y se efecua un println para enviarle la linea
                maquinaEscribirEnHijo.println(lineaLeidaPorTeclado);

                // leemos una nueva linea
                lineaLeidaPorTeclado = maquinaLeerDeTeclado.readLine();
            }

            // Se ha escrito una linea con texto FIN, asi que se envia tambien esta al proceso hijo
            // Cuando éste reciba esta linea, escribira un mensaje
            maquinaEscribirEnHijo.println(lineaLeidaPorTeclado);

            // -------------------------- LEER DEL PROCESO HIJO Y ESCRIBIMOS EN CONSOLA
            // Leemos lo que envíe el proceso hijo. Para ello, uso un readLine() pero no del teclado,
            // sino del objeto que apunta a la salida estandar del proceso hijo, obBRHijo.
            String textoEnviadoPorElHijo = maquinaLeerDeHijo.readLine();

            // Muestro en mi consola el mensaje del proceso hijo.
            System.out.println(textoEnviadoPorElHijo);

        } catch (IOException e) {
            // En caso de IOException saco por pantalla el mensaje de la // excepción.
            System.out.println("Error : " + e.getMessage());
        }


    }
}

