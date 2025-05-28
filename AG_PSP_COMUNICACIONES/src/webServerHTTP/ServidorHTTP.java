package webServerHTTP;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * *****************************************************************************
 * Servidor HTTP que atiende peticiones de tipo 'GET' recibidas por el puerto
 * 8066
 * <p>
 * NOTA: para probar este código, comprueba primero de que no tienes ningún otro
 * servicio por el puerto 8066
 */
class ServidorHTTP {

    /**
     * **************************************************************************
     * procedimiento principal que asigna a cada petición entrante un socket
     * cliente, por donde se enviará la respuesta una vez procesada
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {

        //Asociamos al servidor el puerto 8066
        ServerSocket socServidor = new ServerSocket(58000);
        imprimeDisponible();
        Socket socCliente;

        //ante una petición entrante, procesa la petición por el socket cliente
        //por donde la recibe
        while (true) {
            //a la espera de peticiones
            socCliente = socServidor.accept();
            //atiendo un cliente
            System.out.println("Atendiendo al cliente ");
            procesaPeticion(socCliente);
            //cierra la conexión entrante
//            new Scanner(System.in).nextLine();
//            socCliente.close();
            System.out.println("cliente atendido");
        }
    }

    /**
     * ****************************************************************************
     * procesa la petición recibida
     *
     * @throws IOException
     */
    private static void procesaPeticion(Socket socketCliente) throws IOException {
        //variables locales
        String peticion;
        String html;

        //Flujos del socket
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
//        PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);
        InputStream in;
        DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

        //leer petición cliente
        peticion = entrada.readLine();

        //para compactar la petición y facilitar así su análisis, suprimimos todos los espacios en blanco que contenga
        peticion = peticion.replaceAll(" ", ""); // peticion puede ser algo asi: "GET /quijote HTTP/1.1"

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String respuesta="";
    
        //si realmente se trata de una petición 'GET' (que es la única que vamos a implementar en nuestro Servidor)
        if (peticion.startsWith("GET")) {

            //extrae la subcadena entre 'GET' y 'HTTP/1.1'
            peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));


            //si corresponde a la página de inicio
            if (peticion.length() == 0 || peticion.equals("/")) {
                //sirve la página
                html = Paginas.html_index;
                respuesta += Mensajes.lineaInicial_OK;
                respuesta +=Paginas.primeraCabecera;
                respuesta +="Content-Length: " + html.length() + 1;
                respuesta +="\n";
                respuesta += html;
//                salida.println(respuesta);
                salida.writeUTF(respuesta);

//                salida.println(Mensajes.lineaInicial_OK);
//                salida.println(Paginas.primeraCabecera);
//                salida.println("Content-Length: " + html.length() + 1);
//                salida.println("\n");
//                salida.println(html);
            } //si corresponde a la página del Quijote
            else if (peticion.equals("/quijote")) {
                //sirve la página
                html = Paginas.html_quijote;
                respuesta += Mensajes.lineaInicial_OK;
                respuesta +=Paginas.primeraCabecera;
                respuesta +="Content-Length: " + html.length() + 1;
                respuesta +="\n";
                respuesta += html;
//                salida.println(respuesta);
                salida.writeUTF(respuesta);

//                salida.println(Mensajes.lineaInicial_OK);
//                salida.println(Paginas.primeraCabecera);
//                salida.println("Content-Length: " + html.length() + 1);
//                salida.println("\n");
//                salida.println(html);
            } //en cualquier otro caso
            else {
                //sirve la página
                html = Paginas.html_noEncontrado;
//                printWriter.println(Mensajes.lineaInicial_NotFound);
//                printWriter.println(Paginas.primeraCabecera);
//                printWriter.println("Content-Length: " + html.length() + 1);
//                printWriter.println("\n");
//                printWriter.println(html);
            }

//            salida.close();
//            entrada.close();
        }
    }

    /**
     * **************************************************************************
     * muestra un mensaje en la Salida que confirma el arranque, y da algunas
     * indicaciones posteriores
     */
    private static void imprimeDisponible() {

        System.out.println("El Servidor WEB se está ejecutando y permanece a la "
                + "escucha por el puerto 58000.\nEscribe en la barra de direcciones "
                + "de tu explorador preferido:\n\nhttp://localhost:8066\npara "
                + "solicitar la página de bienvenida\n\nhttp://localhost:8066/"
                + "quijote\n para solicitar una página del Quijote,\n\nhttp://"
                + "localhost:8066/q\n para simular un error");
    }
}
