/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ejercicio;
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
 * @author gaizka
 */
@Stateless
public class EjercicioEJB implements EjercicioInterface{
    
    @PersistenceContext(unitName ="fitFlavor")
    private EntityManager em;

    @Override
    public void createEjercicio(Ejercicio ejercicio) throws CreateException {
        try {
            em.persist(ejercicio);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateEjercicio(Ejercicio ejercicio) throws UpdateException {
        try {
            if (!em.contains(ejercicio)) {
                em.merge(ejercicio);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteEjercicio(Ejercicio ejercicio) throws DeleteException {
        try {
            em.remove(em.merge(ejercicio));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }  
    }
    
    
    @Override
    public List<Ejercicio> listaBrazo() throws ReadException {
        try {
            return em.createNamedQuery("brazo").getResultList();
        }catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }
    
    @Override
    public List<Ejercicio> listaPierna() throws ReadException {
        try {
            return em.createNamedQuery("pierna").getResultList();
        }catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }
    
    @Override
    public List<Ejercicio> listaPecho() throws ReadException {
        try {
            return em.createNamedQuery("pecho").getResultList();
        }catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }
    
    @Override
    public List<Ejercicio> listaEspalda() throws ReadException {
        try {
            return em.createNamedQuery("espalda").getResultList();
        }catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }
    
    @Override
    public List<Ejercicio> listaIntensidad() throws ReadException {
        try {
            return em.createNamedQuery("intesidad").getResultList();
        }catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }
    
    
}
