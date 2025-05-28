package GUT_Sockets_UDP_Objetos;

public class PruebasPlantillaUDPReceptor {
    public static void main(String[] args) {

        Object o = ProcesarUDP.recibirObjectUDP("localhost", 22001);
        Alumno alumno = (Alumno) o;
        System.err.println(alumno.nombre);

    }
}