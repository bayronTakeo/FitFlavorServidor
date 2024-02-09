/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Admin;
import excepciones.CreateException;

/**
 *
 * @author Bayron
 */
public interface AdminInterfaz {

    /**
     *
     * @param admin
     * @throws CreateException
     */
    public void crearAdmin(Admin admin) throws CreateException;
}
