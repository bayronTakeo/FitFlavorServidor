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

/**
 *
 * @author bayro
 */
public interface ClienteInterfaz {

    public void crearCliente(Cliente cli) throws CreateException;

    public void actualizarCliente(Cliente cli) throws UpdateException;

    public void eliminarCliente(Cliente cli) throws DeleteException;

    public List<Cliente> findAll() throws ReadException;

    public Cliente buscarCliente(String valor) throws ReadException;

    public Cliente buscarPorTelefono(int telefono) throws ReadException;

    public Cliente buscarPorId(Integer id) throws ReadException;
}
