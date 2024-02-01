/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import entidades.Receta;
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
 * @author paula
 */
@Stateless
public class RecetaEJB implements RecetaInterface {

    @PersistenceContext(unitName = "FitFlavorServidorPU")
    private EntityManager em;

    @Override
    public void deleteReceta(Receta rec) throws DeleteException {
        try {
            LOGGER.info("Entrando a eliminar");
            LOGGER.info(rec.toString());
            em.remove(em.merge(rec));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void createReceta(Receta receta) throws CreateException {
        try {
            em.persist(receta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateReceta(Receta receta) throws UpdateException {
        try {
            if (!em.contains(receta)) {
                em.merge(em.merge(receta));
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public List<Receta> listaRecetas() throws ReadException {
        try {
            return em.createNamedQuery("listaRecetas").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Receta> vegano(boolean esVegano) throws ReadException {
        try {
            return em.createNamedQuery("esVegano").setParameter("esVegano", esVegano).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Receta> vegetariano(boolean esVegetariano) throws ReadException {
        try {
            return em.createNamedQuery("esVegetariano").setParameter("esVegetariano", esVegetariano).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public List<Receta> precio(float precio) throws ReadException {
        try {
            return em.createNamedQuery("precio").setParameter("precio", precio).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public Receta buscarPorId(Integer id) throws ReadException {
        Receta receta;
        try {
            receta = em.find(Receta.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return receta;
    }

}
