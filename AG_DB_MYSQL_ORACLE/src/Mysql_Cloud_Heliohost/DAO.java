package Mysql_Cloud_Heliohost;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    //    private final String HOST = "johnny.heliohost.org";
    private final String HOST = "johnny.heliohost.org";
    private final String USUARIO = "jyoc_root";
    private final String PASSWORD = "12345";
    Connection miConexion;

    public void conectar() {
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://" + HOST + ":3306/jyoc_agenda", USUARIO, PASSWORD);

            System.out.println("Conectado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertar() {
        try {


            String sql = "INSERT INTO libros (Codigo_de_libro, Titulo, Autor, Editorial, Precio) VALUES" +
                    "('L01', 'Los pilares de la tierra', 'Ken Follett', 'Planeta', 5.4)," +
                    "('L02', 'Cien años de soledad', 'Gabriel García Márquez', 'Cátedra', 9)," +
                    "('L03', 'Las inquietudes de Santi Andia', 'Pío Baroja', 'Salvat', 9.65)," +
                    "('L04', 'Malena es un nombre de Tango', 'Almudena Grandes', 'Salvat', 10.8)," +
                    "('L05', 'Mas allá del Jardín', 'Antonio Gala', 'Planeta', 7.5);";
            Statement st = miConexion.createStatement();
            st.execute(sql);
            System.out.println("Insertado nuevo reg. de prueba");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crear() {
        try {

            String sql = "CREATE TABLE libros (" +
                    "Codigo_de_libro varchar(50) NOT NULL," +
                    "Titulo varchar(50) NOT NULL," +
                    "Autor varchar(50) NOT NULL," +
                    "Editorial varchar(50) NOT NULL," +
                    "Precio float NOT NULL )";
            Statement st = miConexion.createStatement();
            st.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
