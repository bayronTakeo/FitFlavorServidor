/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ejercicio;
import entidades.TipoEjercicio;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gaizka
 */
@Stateless
public class EjercicioEJB implements EjercicioInterface {

    @PersistenceContext(unitName = "FitFlavorServidorPU")
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

    public List<Ejercicio> listaBrazo() throws ReadException {
        try {
            return em.createNamedQuery("brazo").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ejercicio> listaPierna(TipoEjercicio pierna) throws ReadException {
        List<Ejercicio> ejercicios;
        try {
            ejercicios = em.createNamedQuery("pierna").setParameter("pierna", pierna).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return ejercicios;
    }

    public List<Ejercicio> listaPecho(TipoEjercicio pecho) throws ReadException {
        try {
            return em.createNamedQuery("pecho").setParameter("pecho", pecho).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ejercicio> listaEspalda(TipoEjercicio espalda) throws ReadException {
        try {
            return em.createNamedQuery("espalda").setParameter("espalda", espalda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public List<Ejercicio> listaIntensidad(String intensidad) throws ReadException {
        try {
            return em.createNamedQuery("buscarIntensidad").setParameter("intensidad", intensidad).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public List<Ejercicio> listaEjercicios() throws ReadException {
        try {
            return em.createNamedQuery("todosEjercicios").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

}
