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
 * @author bayron
 */
@Stateless
@Path("entidades.cliente")
public class ClienteFacadeREST {

    @EJB
    private ClienteInterfaz ejb;
    
     private Logger LOGGER = Logger.getLogger(ClienteFacadeREST.class.getName());
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente entity) {
        try {
            ejb.crearCliente(entity);
        } catch (CreateException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit( Cliente entity) {
        try {
            ejb.actualizarCliente(entity);
        } catch (UpdateException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @DELETE
    @Path("{cliente}")
    public void remove(@PathParam("cliente") Cliente cliente) {
        try {
         ejb.eliminarCliente(cliente);
        } catch (DeleteException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/busqueda/{usrValor}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente buscar(@PathParam("valor") String valor) {
        try {
            Cliente cliente = ejb.buscarCliente(valor);
            return cliente;
        } catch (ReadException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("/busquedaTelefono/{telefono}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente buscar(@PathParam("telefono") int telefono) {
        try {
            Cliente cliente = ejb.buscarPorTelefono(telefono);
            return cliente;
        } catch (ReadException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() {
        try {
            List<Cliente> clientes = ejb.findAll();
            return clientes;
        } catch (ReadException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

  
   

   
}
