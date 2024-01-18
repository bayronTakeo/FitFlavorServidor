/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Usuario;
import excepciones.ReadException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bayro
 */
@Stateless
public class UsuarioEJB implements UsuarioInterfaz {

    @PersistenceContext(unitName = "FitFlavorServidorPU")
    private EntityManager em;

    @Override
    public Usuario signIn(String email, String contrasenia) throws ReadException {
        Usuario usuario;

        try {
            usuario = (Usuario) em.createNamedQuery("iniciarSesion").setParameter("emailUsr", email).setParameter("contraseniaUsr", contrasenia).getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return usuario;
    }

}
