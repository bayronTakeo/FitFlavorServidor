/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.RecetaIngrediente;
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
 * @author Bayron
 */
@Stateless
public class RecetaIngredienteEJB implements RecetaIngredienteInterface {

    @PersistenceContext(unitName = "FitFlavorServidorPU")

    private EntityManager em;

    private Logger LOGGER = Logger.getLogger(RecetaIngredienteEJB.class.getName());

    @Override
    public void createRecetaIng(RecetaIngrediente recetaIng) throws CreateException {
        try {
            LOGGER.info("Creando RecetaIngrediente");
            // Persiste la entidad en el contexto actual
            em.persist(recetaIng);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void deleteRecetaIng(RecetaIngrediente recetaIng) throws DeleteException {
        try {
            LOGGER.info("Entrando a eliminar");

            em.remove(em.merge(recetaIng));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void editarRecetaIng(RecetaIngrediente recetaIng) throws UpdateException {
        try {
            if (!em.contains(recetaIng)) {
                em.merge(recetaIng);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public List<RecetaIngrediente> findAll() throws ReadException {
        List<RecetaIngrediente> recetaIngredientes;
        try {
            recetaIngredientes = em.createNamedQuery("sacarRecetaIng").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetaIngredientes;
    }

    @Override
    public RecetaIngrediente buscarPorId(Integer id) throws ReadException {
        RecetaIngrediente recetaIngre;
        try {
            recetaIngre = em.find(RecetaIngrediente.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return recetaIngre;
    }

}
