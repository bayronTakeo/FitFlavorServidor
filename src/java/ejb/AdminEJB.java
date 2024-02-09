/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Encriptacion.Hash;
import entidades.Admin;
import excepciones.CreateException;
import files.Asymmetric;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Bayron
 */
public class AdminEJB implements AdminInterfaz {

    @PersistenceContext(unitName = "FitFlavorServidorPU")

    private EntityManager em;

    private Logger LOGGER = Logger.getLogger(ClienteEJB.class.getName());

    @Override
    public void crearAdmin(Admin admin) throws CreateException {
        try {
            LOGGER.info("contrasenia" + admin.getContrasenia());

            byte[] passwordBytes = new Asymmetric().decrypt(DatatypeConverter.parseHexBinary(admin.getContrasenia()));
            admin.setContrasenia(Hash.hashText(new String(passwordBytes)));
            admin.setUser_id(null);
            // Persiste la entidad en el contexto actual
            em.persist(admin);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

}
