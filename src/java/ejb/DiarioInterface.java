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
import excepciones.UpdateException;

/**
 *
 * @author gaizka
 */
public interface DiarioInterface {
    
    public void createDiario(Diario diario) throws CreateException;
    
    public void readDiario(Diario diario) throws ReadException;
    
    public void updateDiario(Diario diario) throws UpdateException;
}
