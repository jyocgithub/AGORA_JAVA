package pdf_usando_itextpdf_jar;

import com.itextpdf.text.Font;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/*
   USANDO LIBRERIA itextpdf
   API: https://api.itextpdf.com/iText5/java/5.5.9/
 */


public class EscribirPDF {

    public static void main(String[] args) {

        PdfWriter writer = null;
        Document documento = new Document(PageSize.A4, 20, 20, 70, 50);

        try {

            // ========================= CREAR FICHERO BASE =====================

            // -- Obtenemos la instancia del archivo a utilizar. Se debe hacer antes de hacer open en el documento
            writer = PdfWriter.getInstance(documento, new FileOutputStream("./ficheros/salida.pdf"));

            // -- Para insertar cabeceras/pies en todas las paginas
            writer.setPageEvent(new PDFHeaderFooter());

            // -- Abrimos el documento para poder editarlo
            documento.open();

            // ========================= CREAR TEXTO (PARRAFOS) =====================
            Paragraph paragraph = new Paragraph();
            paragraph.setSpacingBefore(300);
            paragraph.add("esto es el texto de un parrafo\n\n\n");
            paragraph.add("esto es el texto de un segundo parrafo\n\n\n");

            // -- damos formato al parrafo
            String font = "Sans";
            float tamano = 11;
            int style = Font.BOLD;
            BaseColor color = BaseColor.BLACK;
            float spacBefore = 100;
            float spacAfter = 100;

            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setFont(new Font(FontFactory.getFont(font, tamano, style, color)));
            paragraph.setSpacingBefore(spacBefore);
            paragraph.setSpacingAfter(spacAfter);

            documento.add(paragraph);

            // ========================= CREAR TABLAS =====================

            // -- Instanciamos una tabla de 2 columnas
            PdfPTable tabla = new PdfPTable(2);

            // -- Ancho de cada columna
            int[] values = new int[]{20, 20};
            tabla.setWidths(values);
            //tabla.setWidthPercentage(new Float(100));


            // -- usamos Phrase para crear un texo. Es una variante de Paragraph
            // -- aunque se podria añadir directamente un String
            Phrase textoCabecera1 = new Phrase("cabecera1");
            textoCabecera1.setFont(new Font(FontFactory.getFont("Sans", 9, Font.BOLD, BaseColor.BLACK)));
            // -- o todojunto
            // Phrase textoCabecera = new Phrase("cabecera1", new Font(FontFactory.getFont("Sans", 9, Font.BOLD, BaseColor.BLACK)));

            // -- a cada celda se le puede añadir directamente un numero o un string,
            // -- pero tambien se puede añadir un objeto PdfCell, que puede formatearse mejor
            PdfPCell cabecera1 = new PdfPCell(textoCabecera1);
            cabecera1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cabecera1.setBorderWidth(1);
            cabecera1.setBorderColor(BaseColor.BLUE);
            cabecera1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            cabecera1.setVerticalAlignment(PdfPCell.ALIGN_TOP);
            cabecera1.setPaddingBottom(3);

            // -- añadimos el objeto pdfcell o strings.. se van añadiendo y van llenando la tabla, en orden de llegada
            tabla.addCell(cabecera1);
            tabla.addCell(cabecera1);  //ponemos dos veces la misma cabecera... por no hacer otra jeje
            tabla.addCell("fila 1 col 1");
            tabla.addCell("fila 1 col 2");
            tabla.addCell("fila 2 col 1");
            tabla.addCell("fila 2 col 2");

            // -- metemos la tabla en el documento
            documento.add(tabla);


            // -- otro ejemplo de tabla,
		    PdfPTable tabla2 = new PdfPTable(4);
		    tabla2.addCell(cabecera1);
		    tabla2.addCell(cabecera1);
		    tabla2.addCell(cabecera1);

		    tabla2.addCell(cabecera1);

		    tabla2.addCell(new PdfPCell(new Phrase("1")));
		    tabla2.addCell(new PdfPCell(new Phrase("2")));
		    tabla2.addCell(new PdfPCell(new Phrase("3")));
		    tabla2.addCell(new PdfPCell(new Phrase("4")));

		    tabla2.addCell(new PdfPCell(new Phrase("mas contenido")));
            // si queremos completar el resto de columnas sin poner contenido, usar completeRow()
            // es muy util, puesto que si no se rellenan todas las columnas de una fila, esta no se añade
		    tabla2.completeRow();
		    tabla2.addCell(new PdfPCell(new Phrase("y esto deberia ser otra fila")));
		    tabla2.completeRow();

		    documento.add(tabla2);

            documento.close(); // Cerramos el documento, sin esto, NO SE CREA EL PDF
            writer.close();    // Cerramos writer,

            // ========================= ABRIR EL PDF =====================

            // Abrir automaticamente el fichero creado con la app por defecto del sistema
            // Ver su uso en:    http://docs.oracle.com/javase/6/docs/api/java/awt/Desktop.html
            try {
                File path = new File("./ficheros/salida.pdf");
                Desktop.getDesktop().open(path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
