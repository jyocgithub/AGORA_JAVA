import com.opencsv.bean.CsvBindByName;

// la clase ha de ser PUBLICA
public class Arbol {
    @CsvBindByName(column="id")
    private int id;
    @CsvBindByName(column="familia")
    private String familia;
    @CsvBindByName(column="anio_plantacion")
    private int anio;

    public Arbol(int id, String familia, int anio) {
        this.id = id;
        this.familia = familia;
        this.anio = anio;
    }


    public Arbol( ) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "id=" + id +
                ", familia='" + familia + '\'' +
                ", anio=" + anio +
                '}';
    }
}