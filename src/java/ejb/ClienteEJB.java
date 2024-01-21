/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Encriptacion.Hash;
import entidades.Cliente;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import files.Asymmetric;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author bayro
 */
@Stateless
public class ClienteEJB implements ClienteInterfaz {

    @PersistenceContext(unitName = "FitFlavorServidorPU")

    private EntityManager em;

    private Logger LOGGER = Logger.getLogger(ClienteEJB.class.getName());

    @Override
    public void crearCliente(Cliente cli) throws CreateException {
        try {
            LOGGER.info("contrasenia" + cli.getContrasenia());

            byte[] passwordBytes = new Asymmetric().decrypt(DatatypeConverter.parseHexBinary(cli.getContrasenia()));
            cli.setContrasenia(Hash.hashText(new String(passwordBytes)));
            cli.setUser_id(null);
            // Persiste la entidad en el contexto actual
            em.persist(cli);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cli) throws UpdateException {
        try {
            if (!em.contains(cli)) {
                em.merge(cli);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void eliminarCliente(Cliente cli) throws DeleteException {
        try {
            LOGGER.info("Entrando a eliminar");
            LOGGER.info(cli.toString());
            em.remove(em.merge(cli));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> findAll() throws ReadException {
        List<Cliente> clientes;
        try {
            clientes = em.createNamedQuery("sacarTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> buscarCliente(String valor) throws ReadException {
        List<Cliente> cliente;
        try {
            cliente = em.createNamedQuery("buscarCliente").setParameter("usrValor", "%" + valor + "%").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return cliente;
    }

    @Override
    public Cliente buscarPorTelefono(int telefono) throws ReadException {
        Cliente cliente;
        try {
            cliente = (Cliente) em.createNamedQuery("buscarPorTelefono").setParameter("usrTelefono", telefono).getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return cliente;
    }

    @Override
    public Cliente buscarPorId(Integer id) throws ReadException {
        Cliente cliente;
        try {
            cliente = em.find(Cliente.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return cliente;
    }
}
