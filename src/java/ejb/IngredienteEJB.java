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

    @PersistenceContext(unitName = "FitFlavorServidorPU")
    private EntityManager em;

    @Override
    public void deleteIngrediente(int id) throws DeleteException {
        try {
            em.remove(em.merge(id));
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

    public List<Ingrediente> buscarPrecio(float precio) throws ReadException {
        try {
            return (List<Ingrediente>) em.createNamedQuery("buscarPrecio").setParameter("precio", precio).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarCarbohidratos(float carbohidratos) throws ReadException {
        try {
            return (List<Ingrediente>) em.createNamedQuery("buscarCarbohidratos").setParameter("carbohidratos", carbohidratos).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarProteinas(float proteinas) throws ReadException {
        try {
            return (List<Ingrediente>) em.createNamedQuery("buscarProteinas").setParameter("proteinas", proteinas).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarGrasas(float grasas) throws ReadException {
        try {
            return (List<Ingrediente>) em.createNamedQuery("buscarGrasas").setParameter("grasas", grasas).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    public List<Ingrediente> buscarNombre(String nombre) throws ReadException {
        try {
            return (List<Ingrediente>) em.createNamedQuery("buscarNombre").setParameter("nombre", nombre).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public List<Ingrediente> tipoIngrediente(String tipoIngrediente) throws ReadException {
        try {
            return (List<Ingrediente>) em.createNamedQuery("tipoIngrediente").setParameter("tipoIngrediente", tipoIngrediente).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

    @Override
    public List<Ingrediente> buscarkCal(float kCal) throws ReadException {
        try {
            return em.createNamedQuery("buscarkCal").setParameter("kCal", kCal).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

}
