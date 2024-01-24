/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.RecetaIngredienteInterface;
import entidades.RecetaIngrediente;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Bayron
 */
@Stateless
@Path("entidades.recetaingrediente")
public class RecetaIngredienteFacadeREST {

    @EJB
    private RecetaIngredienteInterface ejb;
    private Logger LOGGER = Logger.getLogger(RecetaIngredienteFacadeREST.class.getName());

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(RecetaIngrediente entity) {
        try {
            LOGGER.log(Level.INFO, "Creando diario");
            ejb.createRecetaIng(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(RecetaIngrediente entity) {
        try {
            LOGGER.log(Level.INFO, "modificando cliente{0}");
            ejb.editarRecetaIng(entity);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "eliminando diario: ", id);
            ejb.deleteRecetaIng(ejb.buscarPorId(id));
        } catch (DeleteException | ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RecetaIngrediente> findAll() {
        try {
            List<RecetaIngrediente> recetaIng = ejb.findAll();

            return recetaIng;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RecetaIngrediente buscarPorId(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "Buscando diario por id:");
            RecetaIngrediente recetaIng = ejb.buscarPorId(id);
            return recetaIng;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

}
