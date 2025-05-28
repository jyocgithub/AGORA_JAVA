/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsUDP_conSwing;

/**
 *
 * @author Elías
 */
public class DatosNoEncontradosException extends Exception {
    public DatosNoEncontradosException(){
        super("Datos no encontrador en la BBDD");
    }
  
}
