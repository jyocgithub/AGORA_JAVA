/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_conFactoryYSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author maria
 */
public class ConfiguracionBBDD {

    private final String user, password, database;
    private static ConfiguracionBBDD configuracion;
    private Connection connection = null;
    
    private ConfiguracionBBDD() throws SQLException {
        this.user="root";
        this.password="";
        this.database="Netflix";
        
        connection= DriverManager.getConnection("jdbc:mysql://localhost/"
                +database+"?"
                +"user="+user+"&"
                +"password="+password+"&"
                +"serverTimezone=UTC",user,password);
        
    }

    public static ConfiguracionBBDD getInstance() throws SQLException {
        
        if (configuracion==null){
            configuracion = new ConfiguracionBBDD();
        }
        return configuracion;
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeConnection() throws SQLException{
        this.connection.close();
    }
    
    
    
    
}
