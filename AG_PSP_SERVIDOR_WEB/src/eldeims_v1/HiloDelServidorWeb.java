package eldeims_v1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;


class HiloDelServidorWeb implements Runnable {
    OutputStream escritor;
    BufferedReader lector;
    Socket socket;
    ArrayList<String> peticiones;
    File f;

    public HiloDelServidorWeb(Socket socket) {
        super();
        this.socket = socket;
        peticiones = new ArrayList<>();
        try {
            escritor = socket.getOutputStream();
            lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String peticion = "";
        String peticion2 = "";
        System.out.println("En el hilo servidor");
        URL unaurl = null;
        String respuestaHttp = "";

        try {

            String linea = lector.readLine();
            while (!linea.isEmpty()) {
                peticiones.add(linea);
                linea = lector.readLine();
            }

            String linea1 = peticiones.get(0);

            if (linea1.toUpperCase().startsWith("GET")) {
                int pos1 = linea1.indexOf("/");
                int pos2 = linea1.indexOf(" ", pos1);
                String ficheropedido = linea1.substring(pos1 + 1, pos2);
                if(ficheropedido.length()==0){
                    ficheropedido="index.html";
                }
                System.out.println("He recibido la peticion: " + linea1);

                File f = new File(ServidorWebIMS.Directorioraizdepaginas, ficheropedido);
                if (!f.exists()) {
                    respuestaHttp = "HTTP/1.0 404 Not Found  \r\n\r\n FICHERO NO ENCONTRADO (404)";
                    escritor.write(respuestaHttp.getBytes("UTF-8"));
                } else {
                    respuestaHttp = "HTTP/1.1 200 OK\r\n"; // analizar antes si es o no OK
                    String tipocontenido = "";
                    if ((ficheropedido.toUpperCase().endsWith("HTML")) || (ficheropedido.toUpperCase().endsWith("HTM"))) {
                        tipocontenido = "HTML";
                    } else if (ficheropedido.toUpperCase().endsWith("CSS")) {
                        tipocontenido = "CSS";
                    } else if (ficheropedido.toUpperCase().endsWith("AVI")) {
                        tipocontenido = "AVI";
                    } else if (ficheropedido.toUpperCase().endsWith("JPG")) {
                        tipocontenido = "JPG";
                    } else if (ficheropedido.toUpperCase().endsWith("JS")) {
                        tipocontenido = "JS";
                    } else if (ficheropedido.toUpperCase().endsWith("MP4")) {
                        tipocontenido = "MP4";
                    } else if (ficheropedido.toUpperCase().endsWith("PNG")) {
                        tipocontenido = "PNG";
                    } else if (ficheropedido.toUpperCase().endsWith("GIF")) {
                        tipocontenido = "GIF";
                    } else {
                        respuestaHttp = "HTTP/1.0 415 Unsupported Media Type\r\n\r\n FORMATO NO SOPORTADO";
                        escritor.write(respuestaHttp.getBytes("UTF-8"));
                    }
                    if (tipocontenido.equals("HTML") || tipocontenido.equals("CSS") || tipocontenido.equals("JS")) {
                        respuestaHttp += "Content-type: text/" + tipocontenido.toLowerCase() + " charset=utf-8\r\n\r\n";
                        BufferedReader bfdefich = new BufferedReader(new FileReader(f));
                        String linfich = bfdefich.readLine();
                        while (linfich != null) {
                            respuestaHttp += linfich;
                            linfich = bfdefich.readLine();
                        }
                        bfdefich.close();
                        escritor.write(respuestaHttp.getBytes("UTF-8"));
                    } // if del envio de TEXTO
                    if (tipocontenido.equals("PNG") || tipocontenido.equals("JPG")) {
                        BufferedImage originalImage = ImageIO.read(f);
                        byte[] imagenInByte;
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(originalImage, "png", baos);
                        baos.flush();
                        imagenInByte = baos.toByteArray();
                        baos.close();
                        respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: image/" + tipocontenido.toLowerCase() + "\r\n\r\n";
                        escritor.write(respuestaHttp.getBytes("UTF-8"));
                        escritor.write(imagenInByte);
                    }// if del envio de IMAGEN
                    if (tipocontenido.equals("AVI")) {
                        byte[] array = new byte[(int) f.length()];
                        FileInputStream fis = new FileInputStream(f);
                        fis.read(array);
                        respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: video/x-msvideo\r\n\r\n";
                        escritor.write(respuestaHttp.getBytes("UTF-8"));
                        escritor.write(array);
                    } // if del envio de avi
                    if (tipocontenido.equals("MP4")) {
                        byte[] array = new byte[(int) f.length()];
                        FileInputStream fis = new FileInputStream(f);
                        fis.read(array);
                        respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: video/mp4\r\n\r\n";
                        escritor.write(respuestaHttp.getBytes("UTF-8"));
                        escritor.write(array);
                    } // if del envio de mp4
                }
            } // if del get
            System.out.println("__DEVUELVO: " + respuestaHttp);

        } catch (

                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (escritor != null) escritor.close();
                if (lector != null) lector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}




