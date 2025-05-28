package jdom;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


public class UsandoJDom {

    public static void main(String[] args) {

        try {
            SAXBuilder builder = new SAXBuilder();
            File xml = new File("libros.xml");

            Document document = builder.build(xml);
            Element root = document.getRootElement();
            List<Element> listaLibros = root.getChildren("libro");

            for (int i = 0; i < listaLibros.size(); i++) {
                System.out.println("LIBRO---------------------");

                Element unlibro = listaLibros.get(i);
                List<Element> valores_libros = unlibro.getChildren();

                for (int j = 0; j < valores_libros.size(); j++) {

                    Element campo = valores_libros.get(j);
                    String camponombre = campo.getName();

                    if (camponombre.equalsIgnoreCase("autor")) {
                        System.out.println("\t AUTOR");
                        List<Element> valores_autor = campo.getChildren();
                        for (int k = 0; k < valores_autor.size(); k++) {
                            campo = valores_autor.get(k);
                            String nombre = campo.getName();
                            String valor = campo.getText();
                            System.out.println("\t\t" + nombre + "\t" + valor);
                        }

                    } else {
                        String valor = campo.getText();
                        System.out.println(camponombre + "\t" + valor);
                    }
                }
            }
        } catch (JDOMException ex) {
            Logger.getLogger(UsandoJDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsandoJDom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}