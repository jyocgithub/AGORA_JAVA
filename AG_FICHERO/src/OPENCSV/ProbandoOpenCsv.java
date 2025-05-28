import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProbandoOpenCsv {

    static CSVParser parser = new CSVParserBuilder()
            .withSeparator(',')
            .withIgnoreQuotations(true)
            .build();

    public static void main(String[] args) throws IOException {

        Reader reader;

        reader = new FileReader("data/arboles.csv");
        BufferedReader br = new BufferedReader(reader);

        List<String[]> lista = leerTodo(reader);
        for (String[] s : lista) {
            System.out.println(s[0]);
            System.out.println(s[1]);
            System.out.println(s[2]);
            System.out.println("--");
        }

//        System.out.println(".........................");
//        reader.close();
//        reader = new FileReader("data/arboles.csv");
//
//
//        List<String[]> lista2 = leerPocoAPoco(reader);
//        for (String[] s : lista2) {
//            System.out.println(s[0]);
//            System.out.println(s[1]);
//            System.out.println(s[2]);
//            System.out.println("--");
//        }
//
//        System.out.println(".........................");
//        reader.close();
//        reader = new FileReader("data/arboles.csv");
//
//
//        leerComoObjetoso(br);

        BufferedWriter writer = new BufferedWriter( new FileWriter("data/arbolescopia.csv"));
//        escribirTodo(lista,writer);
        escribirUnoAUno(lista,writer);

    }


    public static List<String[]> leerPocoAPoco(Reader reader) {

        List<String[]> lista = new ArrayList<>();
        String[] algo;

        try (CSVReader lector = new CSVReader(reader)) {
            while ((algo = lector.readNext()) != null) {
                lista.add(algo);
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<String[]> leerTodoSimple(Reader reader) {

        List<String[]> lista = new ArrayList<>();
        String[] algo;

        try (CSVReader lector = new CSVReader(reader)) {
            lista = lector.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<String[]> leerTodo(Reader reader) {

        List<String[]> lista = new ArrayList<>();
        String[] algo;

        try (CSVReader lector = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build()) {
            lista = lector.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<Arbol> leerComoObjetoso(BufferedReader br) {
        CsvToBean<Arbol> csvtobean = new CsvToBeanBuilder(br)
                .withType(Arbol.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        for (Arbol arbol : (Iterable<Arbol>) csvtobean) {
            System.out.println(arbol);
        }
        return null;
    }



    public static void escribirTodo(List<String[]> lista, Writer writer) {
        try (ICSVWriter escritor = new CSVWriterBuilder(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .build() ){

              escritor.writeAll(lista);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void escribirUnoAUno(List<String[]> lista, Writer writer) {
        try (ICSVWriter escritor = new CSVWriter(writer)){

            for(  String[] linea  : lista)
              escritor.writeNext(linea);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}


