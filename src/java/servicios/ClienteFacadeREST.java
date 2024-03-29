/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import ejb.ClienteInterfaz;
import entidades.Cliente;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
 * @author bayron
 */
@Path("entidades.cliente")
public class ClienteFacadeREST {

    @EJB
    private ClienteInterfaz ejb;

    private Logger LOGGER = Logger.getLogger(ClienteFacadeREST.class.getName());

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        try {
            LOGGER.log(Level.INFO, "Creando cliente", entity.getUser_id());
            ejb.crearCliente(entity);
        } catch (CreateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(Cliente entity) {
        try {
            LOGGER.log(Level.INFO, "modificando cliente{0}", entity.getUser_id());
            ejb.actualizarCliente(entity);
        } catch (UpdateException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Path("editPassword")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void editPassword(Cliente entity) {
        try {
            LOGGER.log(Level.INFO, "cliente", entity.getUser_id());
            ejb.actualizarContraseña(entity);
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @PUT
    @Path("recoverPassword")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void recoverPassword(Cliente entity) {
        try {
            LOGGER.log(Level.INFO, "Updating client {0}", entity.getUser_id());
            ejb.recuperarContrasenia(entity);
        } catch (UpdateException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "eliminando cliente: ", id);
            ejb.eliminarCliente(ejb.buscarPorId(id));
        } catch (DeleteException | ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente buscarPorId(@PathParam("id") Integer id) {
        try {
            LOGGER.log(Level.INFO, "Buscando cliente por id:");
            Cliente cliente = ejb.buscarPorId(id);
            cliente.setContrasenia(null);
            return cliente;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    @GET
    @Path("/busqueda/{usrValor}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente buscar(@PathParam("usrValor") String valor) {
        try {
            LOGGER.info("entrando a buscar " + valor);
            Cliente cliente = ejb.buscarCliente(valor);
            return cliente;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/busquedaNombre/{usr}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente buscarNombre(@PathParam("usr") String usr) {
        try {
            LOGGER.info("entrando a buscar " + usr);
            Cliente cliente = ejb.buscarPorNombre(usr);
            return cliente;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("busquedaTelefono/{usrTelefono}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente buscarTelefono(@PathParam("usrTelefono") int telefono) {
        try {
            Cliente cliente = ejb.buscarPorTelefono(telefono);
            return cliente;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        try {
            List<Cliente> clientes = ejb.findAll();
            for (Cliente client : clientes) {
                client.setContrasenia(null);
            }
            return clientes;
        } catch (ReadException e) {
            LOGGER.severe(e.getMessage());
            throw new InternalServerErrorException(e.getMessage());
        }
    }

}
