package ejercicio_provincias_ainara;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScriptLoader {

    public static void main(String[] args) {

        Connection c = null;
        Statement statement = null;

        try {
            c = SQLiteConnectionShutdown.getSqliteConnection();
            c.setAutoCommit(false);  // Deshabilita el autocommit

            // llamamos a un metodo que nos lea el script sql y meta cada instruccion en una lista
            List<String> statementsList = createStatementsList("resources/autonomias-provincias.sql");

            statement = c.createStatement();

            // se leen todas las instrucciones de la lista y se menten delntro del statement en un BATCH
            // que puede contener varias insrtucciones
            for (String s : statementsList) {
                statement.addBatch(s);
            }

            // el BATCH se ejecuta de golpe con el executeBatch().
            statement.executeBatch();

            // Commit explícito para completar la transacción (no obligatorio)
            c.commit();

        } catch (SQLException e) {
            // En caso de error, hacer rollback  (no necesario si no hay commit)
            if (c != null) {
                try {
                    c.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static List<String> createStatementsList(String scriptFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(scriptFile));
        List<String> statementsList = new ArrayList<>();
        // en el fichero existen varias instrucciones sql, separadas por ;
        sc.useDelimiter(";");

        while (sc.hasNext()) {
            // cada instruccion que se lee del fichero se mete en una lista de String
            statementsList.add(sc.next());
        }
        return statementsList;
    }

}
