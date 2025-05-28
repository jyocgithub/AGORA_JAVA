package inyeccion_sql;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

import java.sql.*;

public class SimuladorServidor {

    public static void main(String[] args) {

//        simuladorPeticionAccesoDesdeNavegador();

    }


    public static void simuladorPeticionAccesoDesdeNavegador() throws SQLException {
        String usuario, password;
        usuario = "pepe";
        password = "123";

        simuladorMetodoDeAccesoEnElServidor(usuario, password);

        // salida por pantalla:
        // Select resultante: SELECT * FROM USUARIOS WHERE NOMBRE = 'pepe' AND PASSWORD='123'

        usuario = "pepe";
        password = "qwerty' OR '1'='1";

        simuladorMetodoDeAccesoEnElServidor(usuario, password);

        // salida por pantalla:
        // Select resultante: SELECT * FROM USUARIOS WHERE NOMBRE = 'pepe' AND PASSWORD='qwerty' OR '1'='1'
    }


    public static void simuladorMetodoDeAccesoEnElServidor(String user, String password) throws SQLException {
        // los valoes de user y pwd se reciben en este ejemplo por parámetro, pero deberian recibirse
        // como si esto fuera un servlet esto es, como una peticion get o post, en el contexto de una request

        Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");

        // CONSTRUIMOS UNA SELECT SIN USAR CONSULTAS PREPARADAS......
        String select = "SELECT * FROM USUARIOS WHERE NOMBRE = '" + user + "' AND PASSWORD='" + password + "'";

        System.out.println("Select resultante: "+ select);

        Statement sentencia = miConexion.createStatement();
        ResultSet res = sentencia.executeQuery(select);
        if (res.next()){;    // comprobamos si hay elementos en la respuesta
           System.out.println("ACCESO CONCEDIDO");
        }else{
           System.out.println("Acceso denegado");
        }

    }


}
