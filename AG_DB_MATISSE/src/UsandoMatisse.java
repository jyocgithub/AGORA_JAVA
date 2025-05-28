import com.matisse.MtDatabase;
import com.matisse.MtException;

import java.sql.Connection;
import java.sql.*;


// NO FUNCIONA EN MAC

public class UsandoMatisse {

    public static void main(String[] args) {
        String hostname = "localhost";
        String dbname = "biblioteca";

        conexionJDBCEstandar(hostname, dbname);

        // Build a JDBC connection from a MtDatabase connection
        conexionConMtDatabase(hostname, dbname);
    }

    public static void conexionJDBCEstandar(String host, String dbname) {

        System.out.println("=========== conexionJDBCEstandar ==========\n");
        try {
            Class.forName("com.matisse.sql.MtDriver");
            String url = "jdbc:mt://" + host + "/" + dbname;
            System.out.println("Conectando con: " + url);
            Connection jcon = DriverManager.getConnection(url);

            Statement stmt = jcon.createStatement();
            String query = "SELECT * FROM Libro";
            ResultSet rs = stmt.executeQuery(query);
                System.out.println("Resultado: " + query);

            while (rs.next()) {
                System.out.println(rs.getString("Autor"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Matisse JDBC Driver class not found, check your CLASSPATH");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

    }

    static MtDatabase db;
    public static void conexionConMtDatabase(String host, String dbname) {

        System.out.println("=========== conexionConMtDatabase ==========\n");

        try {
            db = new MtDatabase(host, dbname);

            db.open();
            System.out.println("Conectando con un objeto MtDatabase");
            Connection jcon = db.getJDBCConnection();
            try { // Regular JDBC acces
                Statement stmt = jcon.createStatement();
                String query = "SELECT * FROM Libro";
                ResultSet rs = stmt.executeQuery(query);
                System.out.println("Resultado: " + query);

                while (rs.next()) {
                    System.out.println(rs.getString("autor"));
                }
                jcon.close();
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        } catch (MtException mte) {
            System.out.println("MtException: " + mte.getMessage());
        }

    }
    public void anadir(){



    }
}
