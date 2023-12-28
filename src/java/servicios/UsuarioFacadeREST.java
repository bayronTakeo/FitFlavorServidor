/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import ejb.UsuarioInterfaz;
import entidades.Usuario;
import excepciones.ReadException;
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
 * @author bayro
 */
@Stateless
@Path("entidades.usuario")
public class UsuarioFacadeREST {
     @EJB
     private UsuarioInterfaz usuInter;
    
     private Logger LOGGER = Logger.getLogger(UsuarioFacadeREST.class.getName());
      
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
       
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
       
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) {
         return null;
       
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
         return null;
       
    }
    
    /**
     * GET metodo para iniciar sesion
     *
     * @param emailUsr el correo del usuario
     * @param contraseniaUsr la contrasenia del usuario
     * @return un objeto usuario
     */
    @GET
    @Path("/{emailUsr}/{contraseniaUsr}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario signIn(@PathParam("emailUsr") String emailUsr, @PathParam("contraseniaUsr") String contraseniaUsr) {
        try {
            Usuario usuario = usuInter.signIn(emailUsr, contraseniaUsr);
            usuario.setContrasenia(null);
            return usuario;
        } catch (ReadException ex) {
            LOGGER.severe(ex.getMessage());
            throw new InternalServerErrorException(ex.getMessage());
        }
    }

    
}
