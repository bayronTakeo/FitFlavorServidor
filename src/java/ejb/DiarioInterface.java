/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Diario;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import java.util.List;

/**
 *
 * @author gaizka
 */
public interface DiarioInterface {

    public void createDiario(Diario diario) throws CreateException;

    public void deleteDiario(Diario diario) throws DeleteException;

    public List<Diario> findAll() throws ReadException;

    public Diario buscarPorId(Integer id) throws ReadException;
}
