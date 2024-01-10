/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Diario;
import excepciones.CreateException;
import excepciones.ReadException;
import excepciones.UpdateException;

/**
 *
 * @author 2dam
 */
public class DiarioEJB implements DiarioInterface{

    @Override
    public void createDiario(Diario diario) throws CreateException {
        
    }

    @Override
    public void readDiario(Diario diario) throws ReadException {
        
    }

    @Override
    public void updateDiario(Diario diario) throws UpdateException {
        
    }
    
}
