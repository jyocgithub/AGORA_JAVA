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

public class PatronMementoSimple {

    public static void main(String[] args) {
        MiEditorSimple textEditor = new MiEditorSimple();
        textEditor.write("Una primera linea para mi editor\n");
        textEditor.write("Y ahi va la segunda linea\n");
        System.out.println(textEditor.print());
        textEditor.save();  // guardamos estado

        textEditor.write("Por aqui cae la tercera linea\n");
        System.out.println(textEditor.print());

        textEditor.undo();  // recuperamos lo guardado
        System.out.println(textEditor.print());

    }

}


class MiEditorSimple {

    private Contenido contenido;
    private CopiaPrevia copPrevia;

    public MiEditorSimple() {
        this.contenido = new Contenido();
    }

    public void save() {
        copPrevia = contenido.save();
    }

    public void undo() {
        contenido.restore(copPrevia);
    }


    public void write(String texto) {
        contenido.addText(texto);
    }

    public String print() {
        return contenido.print();
    }


    class Contenido {

        private StringBuilder textoAlmacenado;

        public Contenido() {
            this.textoAlmacenado = new StringBuilder();
        }

        public void addText(String text) {
            textoAlmacenado.append(text);
        }

        public CopiaPrevia save() {
            return new CopiaPrevia(textoAlmacenado.toString());
        }

        public void restore(CopiaPrevia save) {
            textoAlmacenado = new StringBuilder(save.getText());
        }

        public String print() {
            return textoAlmacenado.toString();
        }

    }

    //-- clase que hace de Memento
    class CopiaPrevia {

        private String text;

        public CopiaPrevia(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
