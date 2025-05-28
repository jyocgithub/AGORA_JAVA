package Mysql_Cloud_Heliohost;

public class Inicio {


    public static void main(String[] args) {


        DAO dao = new DAO();

        dao.conectar();
//        dao.crear();
        dao.insertar();


    }
}

