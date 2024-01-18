/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.IngredienteInterface;
import entidades.Ingrediente;
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
 * @author paula
 */
@Stateless
@Path("entidades.ingrediente")
public class IngredienteFacadeREST {

    @EJB
    private IngredienteInterface ejb;

    private Logger LOGGER = Logger.getLogger(IngredienteFacadeREST.class.getName());

    @POST

    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Ingrediente entity) {
        try {
            LOGGER.log(Level.INFO, "Creando ingrediente{0}", entity.getId());
            ejb.createIngrediente(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Ingrediente entity) {
        try {
            LOGGER.log(Level.INFO, "modificando receta{0}", entity.getId());
            ejb.updateIngrediente(entity);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void remove(@PathParam("id") int id) {
        try {
            LOGGER.log(Level.INFO, "eliminando ingrediente: ", id);
            ejb.deleteIngrediente(ejb.buscarPorId(id));
        } catch (DeleteException | ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/buscarkCal/{kCal}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ingrediente> buscarKcal(@PathParam("kCal") int kCal) {
        try {
            List<Ingrediente> ingredientes = ejb.buscarkCal(kCal);
            return ingredientes;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/buscarPrecio/{precio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ingrediente> buscarPrecio(@PathParam("precio") float precio) {
        try {
            List<Ingrediente> ingredientes = ejb.buscarPrecio(precio);
            return ingredientes;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/buscarCarbohidratos/{carbohidratos}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ingrediente> buscarCarbohidratos(@PathParam("carbohidratos") float carbohidratos) {
        try {
            List<Ingrediente> ingredientes = ejb.buscarCarbohidratos(carbohidratos);
            return ingredientes;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/buscarGrasas/{grasas}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ingrediente> buscarGrasas(@PathParam("grasas") float grasas) {
        try {
            List<Ingrediente> ingredientes = ejb.buscarGrasas(grasas);
            return ingredientes;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/buscarNombre/{nombre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ingrediente> buscarNombre(@PathParam("nombre") String nombre) {
        try {
            List<Ingrediente> ingredientes = ejb.buscarNombre(nombre);
            return ingredientes;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ingrediente> tipoIngrediente(@PathParam("tipoIngrediente") String tipoIngrediente) {
        try {
            List<Ingrediente> ingredientes = ejb.tipoIngrediente(tipoIngrediente);
            return ingredientes;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Ingrediente buscarPorId(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "Buscando cliente por id:");
            Ingrediente ingrediente = ejb.buscarPorId(id);
            return ingrediente;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

}
