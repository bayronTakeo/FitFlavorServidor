/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.AdminInterfaz;
import entidades.Admin;
import excepciones.CreateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Bayron
 */
@Stateless
@Path("entidades.admin")
public class AdminFacadeREST {

    @EJB
    private AdminInterfaz ejb;

    private Logger LOGGER = Logger.getLogger(AdminFacadeREST.class.getName());

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Admin entity) {
        try {
            LOGGER.log(Level.INFO, "Creando admin", entity.getUser_id());
            ejb.crearAdmin(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
