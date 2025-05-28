package plantilla_matisse;

import com.matisse.MtDatabase;
import com.matisse.reflect.MtAttribute;
import com.matisse.reflect.MtClass;
import com.matisse.reflect.MtObject;

public class Libro   extends MtObject implements Obra{
    /** Class Libro cache ID */
    private static int CID = MtDatabase.allocCID(new MtClass.Loader("Libro"));

    public Libro(MtDatabase db) {
        super(getClass(db));
    }
    String titulo;
    String editorial;
    int paginas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

//        private static int titulo = MtDatabase.allocCID(new MtAttribute.Loader("titulo",CID));
//    private static int editorial = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("autor",CID));
//    private static int paginas = com.matisse.MtDatabase.allocCID(new com.matisse.reflect.MtAttribute.Loader("numpaginas",CID));


    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
