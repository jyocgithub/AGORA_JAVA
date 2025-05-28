package mysql_jyoc_libros;

public class MainJyosLibros {

    public static void main(String[] args) {
        new MainJyosLibros();
    }

    public MainJyosLibros() {

        DAOMysqlJyocLibros daoMysqlJyocLibros = new DAOMysqlJyocLibros();
        Autor a = new Autor(0, "M WEST", 1900, 1967, "USA");
        Autor b = new Autor(0, "K FOLLET", 1930, -1, "UK");
        Autor c = new Autor(0, "C MOLA", -1, -1, "ESPAÑOLA");

        System.out.println(daoMysqlJyocLibros.altaAutor(a));
        System.out.println(daoMysqlJyocLibros.altaAutor(b));
        System.out.println(daoMysqlJyocLibros.altaAutor(c));


    }


}
