/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.ClienteInterfaz;
import ejb.RecetaInterface;
import entidades.Cliente;
import entidades.Ingrediente;
import entidades.Receta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author paula
 */
@Stateless
@Path("entidades.receta")
public class RecetaFacadeREST {

    @EJB
    private RecetaInterface ejb;

    private Logger LOGGER = Logger.getLogger(RecetaFacadeREST.class.getName());

    @POST

    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Receta entity) {
        try {
            LOGGER.log(Level.INFO, "Creando receta{0}", entity.getId());
            ejb.createReceta(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Receta entity) {
        try {
            LOGGER.log(Level.INFO, "modificando receta{0}", entity.getId());
            ejb.updateReceta(entity);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "eliminando receta: ", id);
            ejb.deleteReceta(ejb.buscarPorId(id));
        } catch (DeleteException | ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Receta> listaRecetas() {
        try {
            LOGGER.info("Aqui entra");
            List<Receta> recetas = ejb.listaRecetas();
            LOGGER.info(recetas.toString());
            return recetas;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Receta buscarPorId(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "Buscando receta por id:");
            Receta receta = ejb.buscarPorId(id);
            return receta;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }
    
    @GET
    @Path("/vegano/{esVegano}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Receta> vegano(@PathParam("esVegano") boolean esVegano) {
        try {
            List<Receta> recetas = ejb.vegano(esVegano);
            return recetas;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/vegetariano/{esVegetariano}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Receta> vegetariano(@PathParam("esVegetariano") boolean esVegetariano) {
        try {
            List<Receta> recetas = ejb.vegetariano(esVegetariano);
            return recetas;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/precio/{precio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Receta> precio(@PathParam("precio") float precio) {
        try {
            List<Receta> recetas = ejb.precio(precio);
            return recetas;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
