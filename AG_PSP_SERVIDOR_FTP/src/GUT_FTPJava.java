import java.awt.image.DirectColorModel;
import java.io.*;
import java.net.SocketException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class GUT_FTPJava {

    //objeto de la clase FTPClient de Apache, con diversos métodos para
    //interactuar y recuperar un archivo de un servidor FTP
    private  FTPClient ftpcliente;
    //URL del servidor
//    private static String urlServidor = "ftp.rediris.es";
//    private  String urlServidor = "ftp://localhost:14148/";
    private  String urlServidor = "localhost";     // para filezilla server basta asi
    //ruta relativa (en Servidor FTP) de la carpeta que contiene
    //el fichero que vamos a descargar
    private  String rutaFichero = "debian/doc";
    //usuario
    private  String usuarioftp = "pepe";  // si se elige el constructor vacio, se usa este usuario
    //contraseña
    private  String passwordftp = "";// si se elige el constructor vacio, se usa este password
    private String actualDir = "/";

    public GUT_FTPJava() {
        super();
        ftpcliente = new FTPClient();
    }

    public GUT_FTPJava(String usuarioftp, String passwordftp) {
        super();
        this.usuarioftp = usuarioftp;
        this.passwordftp = passwordftp;
        ftpcliente = new FTPClient();
    }


    public int conectar() {
        try {
            ftpcliente.connect(urlServidor);
            System.out.println("Intendo de conexion, respuesta servidor: " + ftpcliente.getReplyString());
            System.out.println("Codigo de intento de conexion: " + ftpcliente.getReplyCode());
            return ftpcliente.getReplyCode();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getCodigoConexion() {
        return ftpcliente.getReplyCode();
    }

    public void desconectar() {
        try {
            ftpcliente.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean login() {
        try {
            boolean loginCorrecto = ftpcliente.login(usuarioftp, passwordftp);
            if (loginCorrecto) {
                ftpcliente.enterLocalPassiveMode(); //Para entrar desde una máquina virtual he tenido que hacerlo así
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void listaContenidoActual() {
        try {
            System.out.println("Contenido disponible en la carpeta "+ftpcliente.printWorkingDirectory() );
            System.out.println("......................................" );
            String[]  arrayElementos = ftpcliente.listNames();
            for (int i = 0; i < arrayElementos.length; i++) {
                System.out.println(arrayElementos[i]);
            }
            System.out.println("......................................" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cambiarDirectorio(String nuevodir) {
        try {
            boolean exito = ftpcliente.changeWorkingDirectory(actualDir+"/"+nuevodir);
            if(! exito){
                System.out.println("Directorio no existente");
            }else{
                actualDir = ftpcliente.printWorkingDirectory();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean subirFichero(String nombreEnEquipo, String nombreEnServidor) {
        BufferedInputStream bis = null;
        try {
            ftpcliente.setFileType(FTP.BINARY_FILE_TYPE);
            bis = new BufferedInputStream(new FileInputStream(nombreEnEquipo));
            if (ftpcliente.storeFile(nombreEnServidor, bis)) {
                System.out.println("-> Fichero subido correctamente");
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis!=null)  bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean bajarFichero(String nombreEnServidor, String nombreEnEquipo) {
        BufferedOutputStream bos = null;
        try {
            ftpcliente.setFileType(FTP.BINARY_FILE_TYPE);
            bos = new BufferedOutputStream(new FileOutputStream(nombreEnEquipo));
            if (ftpcliente.retrieveFile(nombreEnServidor, bos)) {
                System.out.println("-> Fichero bajado correctamente");
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bos!=null)  bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
