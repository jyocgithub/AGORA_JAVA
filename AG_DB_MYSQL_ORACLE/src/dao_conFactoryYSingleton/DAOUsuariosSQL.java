/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao_conFactoryYSingleton;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author maria
 */
public class DAOUsuariosSQL implements DAOUsuarios {
    @Override 
    public List <Usuario> getUsuarios (){
        List<Usuario> usuarios = new ArrayList <Usuario>();
        try{
            Statement stmt = ConfiguracionBBDD.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT*FROM usuarios");
            while (rs.next()){
                
                Usuario usuario = new Usuario ();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuarios.add(usuario);
                
            }
            rs.close();
            stmt.close();
        }
        
        catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return usuarios;
        
    }
    
    
}
