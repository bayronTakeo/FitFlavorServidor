/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Encriptacion.Hash;
import entidades.Cliente;
import entidades.Diario;
import entidades.DiarioEjercicio;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import files.Asymmetric;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author bayro
 */
public class DiarioEjercicioEJB implements DiarioEjercicioInterface {

    @PersistenceContext(unitName = "FitFlavorServidorPU")

    private EntityManager em;

    private Logger LOGGER = Logger.getLogger(DiarioEjercicioEJB.class.getName());

    @Override
    public void crearDiarioE(DiarioEjercicio diarioEjercicio) throws CreateException {
        try {
            LOGGER.info("Creando diarioEjercicio");
            // Persiste la entidad en el contexto actual
            em.persist(diarioEjercicio);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void eliminarDiario(DiarioEjercicio diario) throws DeleteException {
        try {
            LOGGER.info("Entrando a eliminar");
            LOGGER.info(diario.toString());
            em.remove(em.merge(diario));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<DiarioEjercicio> findAll() throws ReadException {
        List<DiarioEjercicio> diarioEjercicios;
        try {
            diarioEjercicios = em.createNamedQuery("sacarDiarioE").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diarioEjercicios;
    }

    @Override
    public List<DiarioEjercicio> buscarPorFecha(Date fecha) throws ReadException {
        List<DiarioEjercicio> diarioEjercicios;
        try {
            diarioEjercicios = em.createNamedQuery("sacarDiarioE").setParameter("fecha", fecha).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diarioEjercicios;
    }

    @Override
    public DiarioEjercicio buscarPorId(Integer id) throws ReadException {
        DiarioEjercicio diarioEjercicio;
        try {
            diarioEjercicio = em.find(DiarioEjercicio.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diarioEjercicio;
    }

}
