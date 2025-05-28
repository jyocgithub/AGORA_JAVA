package usando_pool_conexiones;


import org.apache.commons.dbcp2.BasicDataSource;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class GestorBBDDConPoolConexiones {


    private static Connection miConexion;


    /****************************************************************************************************************
     * CONECTAR
     * Establece una conexion a la bbdd y la asigna al atributo conexion
     * Usa los atributos antes indicados para configurar correctamente la conexion
     */
    public void conectar() {
        try {
            BasicDataSource basicds = DataSourceSingleton.getDataSource();
            miConexion = basicds.getConnection();
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

    // EL RESTO DE METODOS DE ACCESO A LA BBDD SON LOS MISMOS QUE LA PLANTILLA_DAO
    // PUES EL POOL SOLO AFECTA A COMO SE OBTIENE EL OBJETO CONNECTION

}
