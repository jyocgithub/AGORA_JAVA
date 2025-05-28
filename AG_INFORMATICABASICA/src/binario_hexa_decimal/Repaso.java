import java.util.Scanner;

public class Repaso {


    public static int convertirHexadecimalEnDecimal(String numerooriginal) {
        int resultado = 0, potencia = 0, digito;
        boolean vale = true;

        int valorreal=0;
        while (! numerooriginal.equals("")) {

            String ultimo = numerooriginal.substring(numerooriginal.length() - 1);
            switch (ultimo) {
                case "0":
                    valorreal = 0;
                    break;
                case "1":
                    valorreal = 1;
                    break;
                case "2":
                    valorreal = 2;
                    break;
                case "3":
                    valorreal = 3;
                    break;
                case "4":
                    valorreal = 4;
                    break;
                case "5":
                    valorreal = 5;
                    break;
                case "6":
                    valorreal = 6;
                    break;
                case "7":
                    valorreal = 7;
                    break;
                case "8":
                    valorreal = 8;
                    break;
                case "9":
                    valorreal = 9;
                    break;
                case "A":
                    valorreal = 10;
                    break;
                case "B":
                    valorreal = 11;
                    break;
                case "C":
                    valorreal = 12;
                    break;
                case "D":
                    valorreal = 13;
                    break;
                case "E":
                    valorreal = 14;
                    break;
                case "F":
                    valorreal = 15;
                    break;
                default:
                    vale = false;
                    break;
            }
            if(! vale){
                return -1;
            }

            resultado = resultado + valorreal * (int) Math.pow(16, potencia);
            potencia++;
            numerooriginal = numerooriginal.substring(0,numerooriginal.length()-1);


        }
        return resultado;
    }
    public static int convertirHexadecimalEnDecimalV2(String numerooriginal) {
        int resultado = 0, potencia = 0, digito;
        boolean vale = true;
        int valorreal=0;
        while (! numerooriginal.equals("")) {
            char ultimo = numerooriginal.charAt(numerooriginal.length() - 1);
            if(ultimo>='0' && ultimo <='9'){
                valorreal = ultimo - '0';
            }else{
                valorreal = ultimo - 'A' + 10;
            }
            resultado = resultado + valorreal * (int) Math.pow(16, potencia);
            potencia++;
            numerooriginal = numerooriginal.substring(0,numerooriginal.length()-1);
        }
        return resultado;
    }

    public static int convertirBinarioEnDecimal(int numerooriginal) {
        int resultado = 0, potencia = 0, digito;
        boolean vale = true;
        while (numerooriginal > 0) {
            digito = numerooriginal % 10;
            if (digito == 1 || digito == 0) {
                if (digito == 1) {
                    resultado = resultado + (int) Math.pow(2, potencia);
                }
            } else {
                vale = false;
            }
            potencia++;
            numerooriginal = numerooriginal / 10;
        }
        if (vale == true) {
            return resultado;
        } else {
            return -1;
        }
    }

    public static int convertirOctalEnDecimal(int numerooriginal) {
        int resultado = 0, potencia = 0, digito;
        boolean vale = true;
        while (numerooriginal > 0) {
            digito = numerooriginal % 10;
            if (digito >= 0 && digito < 8) {
                resultado = resultado + digito * (int) Math.pow(8, potencia);
            } else {
                vale = false;
            }
            potencia++;
            numerooriginal = numerooriginal / 10;
        }
        if (vale == true) {
            return resultado;
        } else {
            return -1;
        }
    }

    public static int convertirXXEnDecimal(int base, int numerooriginal) {
        int resultado = 0, potencia = 0, digito;
        boolean vale = true;
        while (numerooriginal > 0) {
            digito = numerooriginal % 10;
            if (digito >= 0 && digito < base) {
                resultado = resultado + digito * (int) Math.pow(base, potencia);
            } else {
                vale = false;
            }
            potencia++;
            numerooriginal = numerooriginal / 10;
        }
        if (vale == true) {
            return resultado;
        } else {
            return -1;
        }
    }

    public static String convertirDecimalEnBinario(int numerooriginal) {
        int resto;
        String solucion = "";

        while (numerooriginal > 0) {
            resto = numerooriginal % 2;
            solucion = resto + solucion;
            numerooriginal = numerooriginal / 2;
        }
        return solucion;
    }


    public static void main(String[] args) {


//        int edad = 23;
//        double peso = 45.5452354635656;
//        String nombre = "ANA";
//        System.out.println("me llamo " + nombre + " tengo " + edad + " años y peso " + peso);     // me llamo ANA tengo 23 años y peso 45.5452354635656
//        System.out.printf("me llamo %s y tengo %d años y peso %f \n", nombre,edad, peso);         // me llamo ANA y tengo 23 años y peso 45,545235
//        System.out.printf("me llamo %s y tengo %5d años y peso %f \n", nombre,edad, peso);        // me llamo ANA y tengo    23 años y peso 45,545235
//        System.out.printf("me llamo %20s y tengo %5d años y peso %6.3f \n", nombre,edad, peso);   // me llamo                  ANA y tengo    23 años y peso 45,545
//        System.out.printf("me llamo %20s y tengo %05d años y peso %16.3f \n", nombre,edad, peso); // me llamo                  ANA y tengo 00023 años y peso           45,545
//
//
//        Mesa m1 = new Mesa();
//        Mesa m2 = new Mesa();
//
//        if(m1.equals(m2)){
//            System.out.println("es igual m1 y m2");
//        }
//        if (m1.compareTo(m2)>0){
//            System.out.println("es mayor m1");
//        }
//        if (m1.compareTo(m2)<0){
//            System.out.println("es mayor m2");
//        }
//        if (m1.compareTo(m2)==0){
//            System.out.println("es igual m1 y m2");
//        }

        System.out.println("dame un numero binario");
        Scanner sc = new Scanner(System.in);
        int numerooriginal = sc.nextInt();
        int resultado = convertirBinarioEnDecimal(numerooriginal);
        if (resultado == -1) {
            System.out.println("Error, el numero no era binario");
        } else {
            System.out.println(resultado);
        }

        String vueltaenbinario = convertirDecimalEnBinario(resultado);
        System.out.println(vueltaenbinario);

        int resultado2 = convertirOctalEnDecimal(numerooriginal);
        System.out.println(resultado2);

        System.out.println("dame un numero hexa");
        Scanner sc2 = new Scanner(System.in);
        String  numerooriginalenstring = sc2.nextLine();
        int resultado3 = convertirHexadecimalEnDecimal(numerooriginalenstring);
        System.out.println(resultado3);
    }
}

