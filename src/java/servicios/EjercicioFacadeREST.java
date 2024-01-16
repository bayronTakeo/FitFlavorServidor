/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.EjercicioInterface;
import entidades.Ejercicio;
import entidades.TipoEjercicio;
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
import javax.ws.rs.DefaultValue;
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
 * @author gaizka
 */
@Stateless
@Path("entidades.ejercicio")
public class EjercicioFacadeREST {

    @EJB
    private EjercicioInterface ejb;
    private Logger LOGGER = Logger.getLogger(EjercicioFacadeREST.class.getName());

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Ejercicio entity) {
        try {
            LOGGER.log(Level.INFO, "Creando Ejercicio{0}", entity.getId());
            ejb.createEjercicio(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        };
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Ejercicio entity) {
        try {
            LOGGER.log(Level.INFO, "modificando ejercicio{0}", entity.getId());
            ejb.updateEjercicio(entity);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void remove(Ejercicio entity) {
        try {
            LOGGER.log(Level.INFO, "eliminando ejercicio{0}", entity.getId());
            ejb.deleteEjercicio(entity);
        } catch (DeleteException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> lista() {
        try {
            List<Ejercicio> ejercicios = ejb.listaEjercicios();
            return ejercicios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/listaPorTipo/{tipoEjercicio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> listaPorTipo(@PathParam("tipoEjercicio") TipoEjercicio brazo) {
        try {
            List<Ejercicio> ejercicios = ejb.listaPorTipo(brazo);
            return ejercicios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/listaPierna/{pierna}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> listaPierna(@PathParam("pierna") TipoEjercicio pierna) {
        try {
            List<Ejercicio> ejercicios = ejb.listaPierna(pierna);
            return ejercicios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/listaPecho/{pecho}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> listaPecho(@PathParam("pecho") TipoEjercicio pecho) {
        try {
            List<Ejercicio> ejercicios = ejb.listaPecho(pecho);
            return ejercicios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/listaEspalda/{espalda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> listaEspalda(@PathParam("espalda") TipoEjercicio espalda) {
        try {
            List<Ejercicio> ejercicios = ejb.listaEspalda(espalda);
            return ejercicios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/listaIntensidad/{intensidad}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Ejercicio> listaIntensidad(@PathParam("intensidad") @DefaultValue("DEFAULT_VALUE") String intensidad) {
        try {
            List<Ejercicio> ejercicios = ejb.listaIntensidad(intensidad);
            return ejercicios;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
