package ejercicio_provincias_ainara;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SpanishZipCode {

    public static void main(String[] args) {

        System.out.println("Please Complete Code");

        Scanner cs  = new Scanner(System.in);

        String zipCode = cs.nextLine();

        System.out.println(isValidSpanishZipCode(zipCode));

    }

    private static boolean isValidSpanishZipCode(String input) {
        // https://es.stackoverflow.com/questions/110569/validaci%C3%B3n-de-c%C3%B3digo-postal-espa%C3%B1ol-con-expresiones-regulares
        Pattern pattern = Pattern.compile("^(?:0?[1-9]|[1-4]\\d|5[0-2])\\d{3}$");
        return pattern.matcher(input).matches();
    }
}

