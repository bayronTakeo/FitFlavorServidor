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
import java.util.logging.Logger;
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

    private Logger LOGGER = Logger.getLogger(IngredienteEJB.class.getName());

    public void deleteIngrediente(Ingrediente ing) throws DeleteException {
        try {
            LOGGER.info("Entrando a eliminar");
            LOGGER.info(ing.toString());
            em.remove(em.merge(ing));
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

    public Ingrediente buscarPorId(Integer id) throws ReadException {
        Ingrediente ingrediente;
        try {
            ingrediente = em.find(Ingrediente.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return ingrediente;
    }

    @Override
    public List<Ingrediente> findAll() throws ReadException {
        List<Ingrediente> ingredientes;
        try {
            ingredientes = em.createNamedQuery("sacarTodosIngredientes").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return ingredientes;
    }

}
