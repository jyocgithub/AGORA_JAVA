/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_conFactoryYSingleton;

/**
 *
 * @author maria
 */
public class DAOFactory {
    private static DAOFactory daoFactory;
    
    private DAOFactory (){
        
        
    }
    
    public static DAOFactory getInstance (){
        if(daoFactory==null){
            daoFactory = new DAOFactory();
        }
        
        return daoFactory;
    }
    
    private DAOUsuarios daoUsuarios;
    
    public DAOUsuarios getDAOUsuarios(){
        
          if(daoUsuarios==null){
            daoUsuarios = new DAOUsuariosSQL();
        }
        
        return daoUsuarios;
        
        
        
    }
    
}
