/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Cliente;
import entidades.Diario;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gaizka
 */
@Stateless
public class DiarioEJB implements DiarioInterface {

    @PersistenceContext(unitName = "FitFlavorServidorPU")

    private EntityManager em;

    private Logger LOGGER = Logger.getLogger(DiarioEJB.class.getName());

    @Override
    public void createDiario(Diario diario) throws CreateException {
        try {
            LOGGER.info("Creando diario");
            // Persiste la entidad en el contexto actual
            em.persist(diario);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void deleteDiario(Diario diario) throws DeleteException {
        try {
            LOGGER.info("Entrando a eliminar");
            LOGGER.info(diario.toString());
            em.remove(em.merge(diario));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<Diario> findAll() throws ReadException {
        List<Diario> diarios;
        try {
            diarios = em.createNamedQuery("sacarDiarios").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diarios;
    }

    @Override
    public Diario buscarPorId(Integer id) throws ReadException {
        Diario diario;
        try {
            diario = em.find(Diario.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diario;
    }

    @Override
    public Diario buscarPorFecha(Date diarioFecha, Cliente clienteDiario) throws ReadException {
        Diario diario;
        try {
            LOGGER.info("Entrando a buscar");
            diario = (Diario) em.createNamedQuery("buscarDiarioFecha")
                    .setParameter("diaDiario", diarioFecha)
                    .setParameter("clienteDiario", clienteDiario)
                    .getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diario;
    }

}
