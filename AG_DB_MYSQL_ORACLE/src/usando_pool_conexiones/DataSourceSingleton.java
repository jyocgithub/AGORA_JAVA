package usando_pool_conexiones;

// BasicDataSource se encuenta en la libreria xxx de Apache Commons
import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceSingleton {

    // BasicDataSource se encuenta en la libreria xxx de Apache Commons
    private static BasicDataSource dataSource;

    private static String conexionDB = "jdbc:mysql://localhost:3306/";  // esto es para usar MySql
    private static String nombreBD = "PRUEBAS_PELICULAS";  // aqui viene el nombre de la base de datos
    private static String usuarioDB = "root";  // usuariode bbdd
    private static String passwordDB = "rootroot";   // pwd de la bbdd

    public static BasicDataSource getDataSource() {

        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(conexionDB+nombreBD);
            dataSource.setUsername(usuarioDB);
            dataSource.setPassword(passwordDB);

            dataSource.setMinIdle(5);
            dataSource.setMaxIdle(10);
            dataSource.setMaxOpenPreparedStatements(100);

        }
        return dataSource;
    }


}
