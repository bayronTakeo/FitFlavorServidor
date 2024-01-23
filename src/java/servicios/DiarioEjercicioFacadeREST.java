/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.DiarioEjercicioInterface;
import entidades.DiarioEjercicio;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bayro
 */
@Stateless
@Path("entidades.diarioejercicio")
public class DiarioEjercicioFacadeREST {

    @EJB
    private DiarioEjercicioInterface ejb;
    private Logger LOGGER = Logger.getLogger(DiarioEjercicioFacadeREST.class.getName());

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DiarioEjercicio entity) {
        try {
            LOGGER.log(Level.INFO, "Creando diario");
            ejb.crearDiarioE(entity);
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
            ejb.eliminarDiario(ejb.buscarPorId(id));
        } catch (DeleteException | ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DiarioEjercicio buscarPorId(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "Buscando diario por id:");
            DiarioEjercicio diario = ejb.buscarPorId(id);
            return diario;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiarioEjercicio> findAll() {
        try {
            List<DiarioEjercicio> diarios = ejb.findAll();

            return diarios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/buscarFecha/{fecha}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DiarioEjercicio> buscar(@PathParam("fecha") Date fecha) {
        try {
            List<DiarioEjercicio> diarioEjer = ejb.buscarPorFecha(fecha);
            return diarioEjer;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
