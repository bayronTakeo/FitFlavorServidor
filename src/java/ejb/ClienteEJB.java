/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Cliente;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bayro
 */
@Stateless
public class ClienteEJB implements ClienteInterfaz{
    @PersistenceContext(unitName = "FitFlavorServidorPU")

    private EntityManager em;
    @Override
    public void crearCliente(Cliente cli) throws CreateException {
        try {
            em.persist(cli);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cli) throws UpdateException {
       
        try {
             if(!em.contains(cli)) { 
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
            em.remove(cli);
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
    public Cliente buscarCliente(String valor) throws ReadException {
        Cliente cliente;
        try {
            cliente = (Cliente) em.createNamedQuery("buscarCliente").setParameter("usrValor", "%" + valor + "%").getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return cliente;
    }

    @Override
    public Cliente buscarPorTelefono(int telefono) throws ReadException {
        Cliente cliente;
        try {
            cliente = (Cliente) em.createNamedQuery("buscarPorTelefono").setParameter("telefono", telefono).getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return cliente;
    }
    
}
