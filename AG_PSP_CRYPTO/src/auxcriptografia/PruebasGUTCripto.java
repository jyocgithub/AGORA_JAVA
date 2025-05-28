package auxcriptografia;


import java.util.Arrays;

public class PruebasGUTCripto {


    public static void main(String[] args) {

       GUTCripto_Utilidades.mostrarAlgoritmosDisponibles();
       GUTCripto_Utilidades.mostrarProveedoresDisponibles();

//         pruebaUtilCriptoSimetricos();
        pruebaUtilCriptoAsimetricos();

//        pruebaDES_FicheroTexto();
//        pruebaHASH();
//        pruebaHASH2();
//        pruebaRSA_FicheroTexto();
//        prueba_firmadigital();


    }



    public static void pruebaUtilCriptoSimetricos() {
        GUTCriptoSimetricos utades = new GUTCriptoSimetricos("Rijndael/ECB/PKCS5Padding");
        byte[] encriptado = utades.encriptarString("Mensaje de un \npar de lineas");
        String desencriptado = utades.desencriptarString(encriptado);
        byte[] encriptado2 = utades.encriptarString("Segundo mensaje de un \npar de lineas");
        String desencriptado2 = utades.desencriptarString(encriptado2);
        System.out.println(desencriptado);
        System.out.println(desencriptado2);


        GUTCriptoSimetricos utadesfile = new GUTCriptoSimetricos("Rijndael/ECB/PKCS5Padding");
        byte[] encriptado6 = utadesfile.encriptarString("Mensaje de un \npar de lineas");
        String desencriptado6 = utadesfile.desencriptarString(encriptado6);
        byte[] encriptado7 = utadesfile.encriptarString("Segundo mensaje de un \npar de lineas");
        String desencriptado7 = utadesfile.desencriptarString(encriptado7);

        System.out.println(desencriptado6);
        System.out.println(desencriptado7);
    }

    public static void pruebaUtilCriptoAsimetricos() {
        GUTCriptoAsimetricos utarsa = new GUTCriptoAsimetricos("RSA");
        byte[] encriptado = utarsa.encriptarString("Mensaje de un \npar de lineas");
        String desencriptado = utarsa.desencriptarString(encriptado);
        byte[] encriptado2 = utarsa.encriptarString("Segundo mensaje de un \npar de lineas");
        String desencriptado2 = utarsa.desencriptarString(encriptado2);
        System.out.println(desencriptado);
        System.out.println(desencriptado2);
    }

    public static void pruebaHASH() {
        // primera vez que se crea el texto
        GUTCriptoHash utilCifradosHash = new GUTCriptoHash("MD5");
        byte[] res = utilCifradosHash.encriptarString("paco en la luna", "resumenHashCreado.bin");
        System.out.println(res);

        // segunda vez que se crea el texto
        byte[] res2 = utilCifradosHash.encriptarString("paco en la luna", "resumenHashCreado.bin");
        System.out.println(res2);

        if (Arrays.equals(res, res2)) {
            System.out.println("son iguales !!");
        } else {
            System.out.println("Upps, algo ha ido mal");
        }

        utilCifradosHash.encriptarFicheroTexto("sinencriptarHASH.txt", "yaencriptadoHASH.bin");
    }


    public static void prueba_firmadigital() {
        GUTCriptoFirmaDigital utilFirmaDigital = new GUTCriptoFirmaDigital();
        utilFirmaDigital.firmarDigitalmente_UnTexto("ejemplo.txt", "firmadigitalejemplotxt");
        utilFirmaDigital.verificarDigitalmente_UnTexto("ejemplo.txt", "firmadigitalejemplotxt");
        utilFirmaDigital.firmarDigitalmente_UnFichero("ejemplo.txt", "firmadigitalejemplotxt");
        utilFirmaDigital.verificarDigitalmente_UnFichero("ejemplo.txt", "firmadigitalejemplotxt");
    }

}

