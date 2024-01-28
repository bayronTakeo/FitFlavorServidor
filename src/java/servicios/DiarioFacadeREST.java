/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.DiarioInterface;
import entidades.Cliente;
import entidades.Diario;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import java.util.Date;
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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bayro
 */
@Stateless
@Path("entidades.diario")
public class DiarioFacadeREST {

    @EJB
    private DiarioInterface ejb;

    private Logger LOGGER = Logger.getLogger(DiarioFacadeREST.class.getName());

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Diario entity) {
        try {
            LOGGER.log(Level.INFO, "Creando diario");
            ejb.createDiario(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "eliminando diario: ", id);
            ejb.deleteDiario(ejb.buscarPorId(id));
        } catch (DeleteException | ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Diario buscarPorId(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "Buscando diario por id:");
            Diario diario = ejb.buscarPorId(id);
            return diario;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Path("/buscarFecha")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Diario buscarPorFecha(
            @QueryParam("diaDiario") Date diaDiario,
            @QueryParam("clienteDiario") Cliente clienteDiario) {
        try {
            LOGGER.log(Level.INFO, "Buscando diario por id:");
            Diario diario = ejb.buscarPorFecha(diaDiario, clienteDiario);
            return diario;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Diario> findAll() {
        try {
            List<Diario> diarios = ejb.findAll();
            LOGGER.info(diarios.toString());
            return diarios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
