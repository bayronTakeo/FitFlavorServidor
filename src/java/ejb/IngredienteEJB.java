/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ingrediente;
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
public class IngredienteEJB implements IngredienteInterface {

    @PersistenceContext(unitName = "fitFlavor")
    private EntityManager em;

    @Override
    public void deleteIngrediente(Ingrediente ingrediente) throws DeleteException {
        try {
            em.remove(em.merge(ingrediente));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void createIngrediente(Ingrediente ingrediente) throws CreateException {
        try {
            em.persist(ingrediente);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void updateIngrediente(Ingrediente ingrediente) throws UpdateException {
        try {
            if (!em.contains(ingrediente)) {
                em.merge(ingrediente);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarkCals() throws ReadException {
        try {
            return em.createNamedQuery("buscarkCals").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarPrecio() throws ReadException {
        try {
            return em.createNamedQuery("buscarPrecio").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }


    public List<Ingrediente> buscarCarbohidratos() throws ReadException {
        try {
            return em.createNamedQuery("buscarCarbohidratos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarProteinas() throws ReadException {
        try {
            return em.createNamedQuery("buscarProteinas").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarGrasas() throws ReadException {
        try {
            return em.createNamedQuery("buscarGrasas").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarNombre() throws ReadException {
        try {
            return em.createNamedQuery("buscarNombre").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public List<Ingrediente> tipoIngrediente() throws ReadException {
        try {
            return em.createNamedQuery("tipoIngrediente").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

}
