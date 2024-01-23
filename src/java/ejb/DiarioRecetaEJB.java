/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.DiarioReceta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bayro
 */
public class DiarioRecetaEJB implements DiarioRecetaInterface {

    @PersistenceContext(unitName = "FitFlavorServidorPU")

    private EntityManager em;

    private Logger LOGGER = Logger.getLogger(DiarioRecetaEJB.class.getName());

    @Override
    public void crearDiarioE(DiarioReceta diarioReceta) throws CreateException {
        try {
            LOGGER.info("Creando diarioEjercicio");
            // Persiste la entidad en el contexto actual
            em.persist(diarioReceta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void eliminarDiario(DiarioReceta diario) throws DeleteException {
        try {
            LOGGER.info("Entrando a eliminar");
            LOGGER.info(diario.toString());
            em.remove(em.merge(diario));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<DiarioReceta> findAll() throws ReadException {
        List<DiarioReceta> diarioEjercicios;
        try {
            diarioEjercicios = em.createNamedQuery("sacarDiarioR").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diarioEjercicios;
    }

    @Override
    public List<DiarioReceta> buscarPorFecha(Date fecha) throws ReadException {
        List<DiarioReceta> diarioEjercicios;
        try {
            diarioEjercicios = em.createNamedQuery("sacarFechaR").setParameter("fecha", fecha).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diarioEjercicios;
    }

    @Override
    public DiarioReceta buscarPorId(Integer id) throws ReadException {
        DiarioReceta diarioReceta;
        try {
            diarioReceta = em.find(DiarioReceta.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diarioReceta;
    }

}
