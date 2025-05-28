package patron_memento;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PatronMementoAvanzado {
    public static void main(String[] args) {
        MiEditorAvanzado textEditor = new MiEditorAvanzado();
        textEditor.write("Una primera linea para mi editor\n"); // en vez de bajo demanda, se hace el SAVE ahora automaticamente con cada escritura...)
        textEditor.write("Y ahi va la segunda linea\n");
        System.out.println(textEditor.print());

        textEditor.write("Por aqui cae la tercera linea\n");
        System.out.println(textEditor.print());

        textEditor.undo();  // recuperamos lo guardado
        System.out.println(textEditor.print());

        textEditor.undo();  // recuperamos lo guardado
        System.out.println(textEditor.print());

    }

}


class MiEditorAvanzado {

    private Contenido contenido;
    private List<CopiaPrevia> copiasprevias;

    public MiEditorAvanzado() {
        this.contenido = new Contenido();
        this.copiasprevias = new ArrayList<>();
    }

    private void save() {
        CopiaPrevia copPrevia = contenido.save();
        copiasprevias.add(copPrevia);
    }

    public void undo() {
        if (copiasprevias.size() > 0) {
            copiasprevias.remove(copiasprevias.size() - 1);
            if (copiasprevias.size() > 0) {
                CopiaPrevia copPrevia = copiasprevias.get(copiasprevias.size() - 1);
                contenido.restore(copPrevia);
            }
        }
    }

    public void write(String texto) {
        contenido.addText(texto);
        save();
    }

    public String print() {
        return contenido.print();
    }

    public Date ahora() {
        return Calendar.getInstance().getTime();
    }

    class Contenido {

        private StringBuilder textoAlmacenado;

        public Contenido() {
            this.textoAlmacenado = new StringBuilder();
        }

        public void addText(String text) {
            textoAlmacenado.append(text);
            save();
        }

        public CopiaPrevia save() {
            return new CopiaPrevia(textoAlmacenado.toString(), ahora());
        }

        public void restore(CopiaPrevia save) {

            textoAlmacenado = new StringBuilder(save.getText());
        }

        public String print() {
            return textoAlmacenado.toString();
        }

    }

    //-- clase que hace de Memento
    // Se guarda siempe una copia de esta clase,
    // que define todos los atributos que se han de guardar (el estado) en cada momento;
    // Hay que entender que no solo se guarda un Sting, sino un objeto complejo con todos los
    // atributos del estado de cada momento
    // Para no poner solo un String de contenido guardamos tb la fecha del instante de la copia
    class CopiaPrevia {

        private String text;
        private Date fechaactual;

        public CopiaPrevia(String text, Date fechaactual) {
            this.text = text;
            this.fechaactual = fechaactual;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return "Fecha:" + fechaactual + "\nTexto=\n'" + text + "\'\n";
        }
    }
}
