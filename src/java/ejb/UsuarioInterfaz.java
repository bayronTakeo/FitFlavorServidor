/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Usuario;
import excepciones.ReadException;

/**
 *
 * @author bayro
 */
public interface UsuarioInterfaz {
    
    public Usuario signIn(String email, String contrasenia) throws ReadException;
}
