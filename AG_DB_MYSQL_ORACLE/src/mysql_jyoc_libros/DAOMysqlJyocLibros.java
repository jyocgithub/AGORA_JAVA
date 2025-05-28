package mysql_jyoc_libros;


import java.sql.*;

public class DAOMysqlJyocLibros {

    private static String conexionDB = "jdbc:mysql://localhost:3306/";  // esto es para usar MySql
    private static String nombreBD = "JYOC_LIBROS";  // aqui viene el nombre de la base de datos
    private static String usuarioDB = "root";  // usuariode bbdd
    private static String passwordDB = "root";   // pwd de la bbdd
    private static String opcionesBD = "?serverTimezone=UTC";  // opcional
    private static Connection miConexion;
    private static DatabaseMetaData dbmd;

    /****************************************************************************************************************
     * CONECTAR
     * Establece una conexion a la bbdd y la asigna al atributo conexion
     * Usa los atributos antes indicados para configurar correctamente la conexion
     */
    public void conectar() {
        try {
            miConexion = DriverManager.getConnection(conexionDB + nombreBD + opcionesBD, usuarioDB, passwordDB);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /****************************************************************************************************************
     * DESCONECTAR
     */
    public void desconectar() {
        try {
            miConexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /****************************************************************************************************************
     * getNuevoIdAutor
     * Devuelve el valor máximo de un campo de una tabla
     * Se puede usar para saber el valor maximo de una clave cuando NO ES AUTOINCREMENTAL
     * y se necesita saber la proximo clave a insertar
     * @return
     */
    public int getNuevoIdAutor() {
        int nuevo = 0;
        try {
            conectar();
            String sql = "SELECT max(idAutor) FROM autor";
            ResultSet rs = miConexion.createStatement().executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return nuevo;
    }


    /****************************************************************************************************************
     * ALTATABLAS
     */
    public void altaTablaAutor() {
        try {
            String sqlCrearTablaAutor = "CREATE TABLE IF NOT EXISTS AUTOR ( "
                    + "idautor int PRIMARY KEY NOT NULL AUTO_INCREMENT,  "
                    + "nombre varchar(20) , "
                    + "anonacim int ,"
                    + "anofallec int , "
                    + "nacionalidad varchar(20) ";
            conectar();
            Statement instruccion = miConexion.createStatement();
            instruccion.execute(sqlCrearTablaAutor);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
    }


    public int altaAutorGeneratedKeys(Autor autor) {
        try {
            conectar();
            int idcreado = -1;
            String sql = "INSERT INTO AUTOR VALUES (0,?,?,?,?)  ";
            PreparedStatement instruccion = miConexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            instruccion.setString(1, autor.getNombre());
            instruccion.setInt(2, autor.getAnonacim());
            instruccion.setInt(3, autor.getAnofallec());
            instruccion.setString(4, autor.getNacionalidad());
            instruccion.executeUpdate();

            // investigamos el ultimo id creado
            ResultSet clave = instruccion.getGeneratedKeys();
            if (clave.next()) {
                idcreado = clave.getInt(1);
            }

            return idcreado;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
        return -1;
    }

    public int altaAutor(Autor autor) {
        try {
            conectar();
            int idcreado = -1;
            String sql = "INSERT INTO AUTOR VALUES (0,?,?,?,?)  ";
            PreparedStatement instruccion = miConexion.prepareStatement(sql);
            instruccion.setString(1, autor.getNombre());
            instruccion.setInt(2, autor.getAnonacim());
            instruccion.setInt(3, autor.getAnofallec());
            instruccion.setString(4, autor.getNacionalidad());
            instruccion.executeUpdate();
            // investigamos el ultimo id creado
            ResultSet clave = instruccion.executeQuery("SELECT LAST_INSERT_ID()");
            if (clave.next()) {
                idcreado = clave.getInt(1);
            }
            return idcreado;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            desconectar();
        }
        return -1;
    }

}
