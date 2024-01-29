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
import excepciones.UpdateException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    public Diario buscarPorFecha(String diaDiario, Integer idCliente) throws ReadException {
        Diario diario;
        try {
            LOGGER.info("Entrando a buscar");

            // Convertir String a LocalDate
            LocalDate localDate = LocalDate.parse(diaDiario);

            // Convertir LocalDate a Date
            Date fecha = java.sql.Date.valueOf(localDate);

            LOGGER.info(fecha.toString());
            diario = (Diario) em.createNamedQuery("buscarPorFecha")
                    .setParameter("diaDiario", fecha)
                    .setParameter("idCliente", idCliente)
                    .getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diario;
    }

    @Override
    public Diario buscarPorFecha(String diaDiario, Integer idCliente, Integer idEjercicio) throws ReadException {
        Diario diario;
        try {
            LOGGER.info("Entrando a buscar");

            // Convertir String a LocalDate
            LocalDate localDate = LocalDate.parse(diaDiario);

            // Convertir LocalDate a Date
            Date fecha = java.sql.Date.valueOf(localDate);

            LOGGER.info(fecha.toString());
            diario = (Diario) em.createNamedQuery("buscarEjercicio")
                    .setParameter("diaDiario", fecha)
                    .setParameter("idCliente", idCliente)
                    .setParameter("idEjercicio", idEjercicio)
                    .getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return diario;
    }

    @Override
    public void actualizarDiario(Diario diario) throws UpdateException {
        try {
            LOGGER.info("Actualizando");

            if (!em.contains(diario)) {
                em.merge(diario);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

}
