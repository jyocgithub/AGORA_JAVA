
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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpresions {

    public static void main(String[] args) {

        // ================================================================
        // COMO PROBAR UNA EXPRESION REGULAR Y VER CONCUERDA CON UN STRING
        // ================================================================
        // 1.- CASO 1    USANDO matches() de String:


        String cadena = "abc";
        if (cadena.matches("[a-z]*"))
            System.out.println("SI cumple patron");
        else
            System.out.println("NO cumple patron");


        // 2.- CASO 2    USANDO matches() de Pattern:
        if (Pattern.matches("[a-z]*", "abc"))
            System.out.println("SI cumple patron");
        else
            System.out.println("NO cumple patron");


        // 3.- CASO 3    COMPILANDO LA EXPRESION Y USANDO matches() de Matcher:
        System.out.println("Escribe un cadena:");
        cadena = new Scanner(System.in).nextLine();
        String expreReg = "[a-z]*";
        Pattern compilado = Pattern.compile(expreReg);
        Matcher mat = compilado.matcher(cadena);

        if (mat.matches())
            System.out.println("SI cumple patron");
        else
            System.out.println("NO cumple patron");




        // ============================================================================
        // COMO EXTRAER DE UN STRING TODAS LAS COINCIDENCIAS DE UNA EXPRESION REGULAR
        // ============================================================================

        int contador = 0;
        // String to be scanned to find the pattern.
//        String content = "aaa bb aaa asdfas aa asd aaa asdaaasad";
//        String string = "aaa";
        String content = "a53aa 3 34bb 23e3aaa asdfas aa asd aaa asdaaasad";
        String string = "[0-9]{3}(?![a-c])";

        // Create a Pattern object
        Pattern p = Pattern.compile(string);

        // get a matcher object
        Matcher m = p.matcher(content);

        while(m.find()) {
            System.out.println(m.group());
            contador++;
            System.out.println("Match numero:"+contador);
            System.out.println("Match obtenido:"+content.substring(m.start(),m.end()));
            System.out.println("Esta entre las posiciones : "+ m.start()+ " - " + m.end());
        }

        testRegexp("<.+>","Un texto con <H1>titulo</H1> en el texto");

        testRegexp("<.+?>","Un texto con <H1>titulo</H1> en el texto");

    }


    public static List<String> testRegexp(String regex, String origen){
        List<String> res = new ArrayList<>();
        // Create a Pattern object
        Pattern p = Pattern.compile(regex);

        // get a matcher object
        Matcher m = p.matcher(origen);
        int contador =0;
        while(m.find()) {
            contador++;
            System.out.println("Ocurrencia numero:"+contador);
            String ocurrencia  = origen.substring(m.start(),m.end());
            System.out.println("Ocurrencia obtenido:"+ocurrencia);
            System.out.println("Ocurrencia en las posiciones : "+ m.start()+ "-" + m.end());
            res.add(ocurrencia);
        }
        return res;
    }

}
