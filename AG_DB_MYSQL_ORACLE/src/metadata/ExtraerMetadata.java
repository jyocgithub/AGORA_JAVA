package metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.sql.Statement;

public class ExtraerMetadata {

    private static String protocoloDB = "jdbc:mysql://"; // protocolo de la bbdd que usemos
    private static String urlservidor = "localhost:3306/"; // url donde esta la bbdd
    private static String nombrebbdd = "almacen"; // nombre de la bbdd
    private static String opcionesbbdd = "?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String urlconexion = protocoloDB + urlservidor + nombrebbdd + opcionesbbdd; // todo junto
    private static String usuarioDB = "root";
    private static String passwordDB = "root";
    public static Statement instruccion;
    public static Connection miConexion;
    public static ResultSet result;
    private static DatabaseMetaData dbmd;

    public void main(String[] args) {
        if (existeLaBBDD()) {
            conectar();
            informacionDeLaBBDD();
            informacionDeLasTablas();
            desconectar();
        }
    }

    public static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            miConexion = DriverManager.getConnection(urlconexion, usuarioDB, passwordDB);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Se ha conectado");
    }

    public static void desconectar() {
        try {
            miConexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Se ha desconectado");
    }

    public boolean existeLaBBDD() {
        try {
            miConexion = DriverManager.getConnection(urlconexion, usuarioDB, passwordDB);
            instruccion = miConexion.createStatement();
            String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '" + nombrebbdd + "'";
            result = instruccion.executeQuery(sql);
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());
        } finally {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void informacionDeLaBBDD() {
        System.out.println("\nINFORMACIÓN SOBRE LA BASE DE DATOS");
        System.out.println("==================================");
        try {
            dbmd = miConexion.getMetaData();
            String nombre = dbmd.getDatabaseProductName();// Información sobre el servidor de la BD
            String driver = dbmd.getDriverName(); // Nombre del controldor/Driver de la BD
            String url = dbmd.getURL(); // URL donde se aloja la BD actual
            String usuario = dbmd.getUserName(); // Nombre del usuario actual de la BD
            System.out.println(
                    "Nombre : " + nombre + "\nDriver : " + driver + "\nURL    : " + url + "\nUsuario:" + usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void informacionDeLasTablas() {

        System.out.println("\n\nINFORMACIÓN SOBRE LAS TABLAS");
        System.out.println("============================");
        String esnulo = null, esautoincremental = null;
        try {
            dbmd = miConexion.getMetaData();
            ResultSet todaslastablas = dbmd.getTables(nombrebbdd, null, "%", null);    // obtenemos un conjunto con todas las tablas
            while (todaslastablas.next()) {                                            // vemos una a una la informacion de CADA tabla
                String catalogo = todaslastablas.getString("TABLE_CAT");               // indica el nombre del catalogo( bbdd)
                String nombreElemento = todaslastablas.getString("TABLE_NAME");        // indica el nombre del elemento (tabla)
                String tipoElemento = todaslastablas.getString("TABLE_TYPE");          // indica el tipo del elemento (que es una TABLE)
                String schema = todaslastablas.getString("TABLE_SCHEM");               // indica el schema del elemento (si lo tiene)
                System.out.println("\n\n---- BBDD   = " + catalogo);
                System.out.println("---- SCHEMA = " + schema + "\n---- TIPO   = " + tipoElemento + "\n---- NOMBRE = " + nombreElemento);
                instruccion = miConexion.createStatement();                               // vamos a ver el CONTENIDO DE ESTA TABLA
                result = instruccion.executeQuery("SELECT * FROM " + nombreElemento);
                ResultSetMetaData rsmd = result.getMetaData();
                int numeroColumnas = rsmd.getColumnCount();                            // indica cuantas columnas (campos) tiene la tabla
                System.out.println("Numero de columnas : " + numeroColumnas);
                for (int i = 1; i <= numeroColumnas; i++) {
                    System.out.println("Columna :" + i);                               // ordinal del campo
                    System.out.println("\tNombre :" + rsmd.getColumnName(i) + "\n\tTipo " + rsmd.getColumnTypeName(i));   // nombre y tipo del campo
                    if (rsmd.isNullable(i) == 0) {                                     // indica si el campo es null
                        esnulo = "NO";
                    } else {
                        esnulo = "SI";
                    }
                    if (rsmd.isAutoIncrement(i) == true) {                              // indica si el campo es autoincremental
                        esautoincremental = "SI";
                    } else {
                        esautoincremental = "NO";
                    }
                    System.out.println("\tPuede ser nula? " + esnulo);
                    System.out.println("\tMáximo ancho de columna " + rsmd.getColumnDisplaySize(i));    // indica el tamaño del campo
                    System.out.println("\tEste campo es autoincremental?: " + esautoincremental);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void informacionDeLosProcedimientos() {
        System.out.println("\n\nINFORMACIÓN SOBRE LOS PROCEDIMIENTOS");
        System.out.println("====================================");
        try {
            boolean hayProcedimientos = false;
            ResultSet verLosProcedimientos = null;
            verLosProcedimientos = dbmd.getProcedures(nombrebbdd, null, null);
            while (verLosProcedimientos.next()) {
                hayProcedimientos = true;
                String catalogo = verLosProcedimientos.getString("PROCEDURE_CAT");//Nombre de la base de datos en la que reside el procedimiento almacenado
                String procedimiento = verLosProcedimientos.getString("PROCEDURE_NAME");//Nombre del procedimiento almacenado
                String tipoProcedimiento = verLosProcedimientos.getString("PROCEDURE_TYPE");//Tipo de procedimiento
                if (tipoProcedimiento.equals("1")) {
                    tipoProcedimiento = "PROCEDURE";
                } else if (tipoProcedimiento.equals("2")) {
                    tipoProcedimiento = "FUNCTION";
                } else {
                    tipoProcedimiento = "DESCONOCIDO";
                }
                System.out.println("Nombre de la base de datos: " + catalogo + "\nNombre de procedimiento : " + procedimiento + "\nTipo de procedimiento : " + tipoProcedimiento);
                hayProcedimientos = true;
            }
            if (hayProcedimientos == false) {
                System.out.println("No hay ningún procedimiento de base de datos de '" + nombrebbdd + "'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
