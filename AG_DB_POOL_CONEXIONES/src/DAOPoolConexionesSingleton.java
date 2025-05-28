import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;


/*
    OBTENER UNA CONEXION CON BBDD USANDO:
    Connection conexion =  DBPoolConexionesSingleton.getDataSource().getConnection();
 */

public class DAOPoolConexionesSingleton {
    private static BasicDataSource basicDataSource;
    private static String conexionDB = "jdbc:mysql://localhost:3306/";  // esto es para usar MySql
    private static String nombreBD = "PRUEBAS_PELICULAS";  // aqui viene el nombre de la base de datos
    private static String usuarioDB = "root";  // usuariode bbdd
    private static String passwordDB = "";   // pwd de la bbdd

    public static BasicDataSource getDataSource()
    {
        if (basicDataSource == null)
        {
            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            basicDataSource.setUrl(conexionDB+nombreBD);
            basicDataSource.setUsername(usuarioDB);
            basicDataSource.setPassword(passwordDB);

            basicDataSource.setMaxTotal(10); // maximo de conexiones que se gestionan en el pool
            basicDataSource.setMinIdle(2);   // número mínimo de conexiones inactivas que deben mantenerse
            basicDataSource.setMaxIdle(10);  // número máximo de conexiones inactivas que deben mantenerse
            basicDataSource.setMaxOpenPreparedStatements(100);

            // Opcional. Sentencia SQL que sirve para comprobar que la conexion es correcta.
            basicDataSource.setValidationQuery("select 1");
        }
        return basicDataSource;
    }
}
