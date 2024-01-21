/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Encriptacion.Hash;
import entidades.Usuario;
import excepciones.ReadException;
import files.Asymmetric;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author bayro
 */
@Stateless
public class UsuarioEJB implements UsuarioInterfaz {

    @PersistenceContext(unitName = "FitFlavorServidorPU")
    private EntityManager em;
    private Logger LOGGER = Logger.getLogger(UsuarioEJB.class.getName());

    @Override
    public Usuario signIn(String email, String contrasenia) throws ReadException {
        Usuario usuario;

        try {
            LOGGER.info("Contraseña que llega: " + contrasenia);
            byte[] passwordBytes = new Asymmetric().decrypt(DatatypeConverter.parseHexBinary(contrasenia));
            LOGGER.info(Hash.hashText(new String(passwordBytes)));
            usuario = (Usuario) em.createNamedQuery("iniciarSesion").setParameter("emailUsr", email).setParameter("contraseniaUsr", Hash.hashText(new String(passwordBytes))).getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return usuario;
    }

}
