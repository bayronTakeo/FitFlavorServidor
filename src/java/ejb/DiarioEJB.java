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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gaizka
 */
@Stateless
public class DiarioEJB implements DiarioInterface{

    @PersistenceContext(unitName ="FitFlavorServidorPU")
    private EntityManager em;
    
    @Override
    public void createDiario(Diario diario) throws CreateException {
        try {
            em.persist(diario);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateDiario(Diario diario) throws UpdateException {
        try {
            if (!em.contains(diario)) {
                em.merge(diario);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }
    
    @Override
    public void readDiario(Diario diario) throws ReadException {
        try {
            if (!em.contains(diario)) {
                em.merge(diario);
            }
            em.flush();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }
}
