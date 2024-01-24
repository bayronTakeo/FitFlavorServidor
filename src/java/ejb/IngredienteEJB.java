/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ingrediente;
import entidades.TipoIngrediente;
import entidades.TipoReceta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
            ingrediente.setId(null);
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
            return em.createNamedQuery("buscarkCal").setParameter("kcal", kCal).getResultList();
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
            LOGGER.info("Entrando a find all de ingredientes: ");
            ingredientes = em.createNamedQuery("sacarTodosIngredientes").getResultList();
            for (Ingrediente ing : ingredientes) {
                LOGGER.info(ing.toString());
            }
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return ingredientes;
    }

    @Override
    public List<Ingrediente> buscarFiltros(TipoIngrediente tipoIngrediente, String nombre, Float precio, Float kcal, Float carb, Float proteina, Float grasas) throws ReadException {
        try {
            // Construcción de la consulta JPQL
            StringBuilder jpql = new StringBuilder("SELECT i FROM Ingrediente i");

            // Utilizar WHERE solo si hay al menos un filtro
            if (tipoIngrediente != null || nombre != null || precio != null || kcal != null || carb != null || proteina != null || grasas != null) {
                jpql.append(" WHERE");
            }

            // Añadir condiciones al JPQL según los filtros proporcionados
            if (tipoIngrediente != null) {
                jpql.append(" i.tipoIngrediente = :tipoIngrediente");
            }

            if (nombre != null) {
                if (tipoIngrediente != null) {
                    jpql.append(" AND");
                }
                jpql.append(" i.nombre LIKE :nombre");
            }

            if (precio != null) {
                if (tipoIngrediente != null || nombre != null) {
                    jpql.append(" AND");
                }
                jpql.append(" i.precio <= :precio");
            }

            if (kcal != null) {
                if (tipoIngrediente != null || nombre != null || precio != null) {
                    jpql.append(" AND");
                }
                jpql.append(" i.kcal <= :kcal");
            }

            if (carb != null) {
                if (tipoIngrediente != null || nombre != null || precio != null || kcal != null) {
                    jpql.append(" AND");
                }
                jpql.append(" i.carbohidratos <= :carb");
            }

            if (proteina != null) {
                if (tipoIngrediente != null || nombre != null || precio != null || kcal != null || carb != null) {
                    jpql.append(" AND");
                }
                jpql.append(" i.proteinas <= :proteina");
            }

            if (grasas != null) {
                if (tipoIngrediente != null || nombre != null || precio != null || kcal != null || carb != null || proteina != null) {
                    jpql.append(" AND");
                }
                jpql.append(" i.grasas <= :grasas");
            }
            LOGGER.info(jpql.toString());

            // Creación de la consulta
            Query query = em.createQuery(jpql.toString());

            // Configuración de los parámetros de la consulta
            if (tipoIngrediente != null) {
                query.setParameter("tipoIngrediente", tipoIngrediente);
            }

            if (nombre != null) {
                query.setParameter("nombre", "%" + nombre + "%");
            }

            if (precio != null) {
                query.setParameter("precio", precio);
            }

            if (kcal != null) {
                query.setParameter("kcal", kcal);
            }

            if (carb != null) {
                query.setParameter("carb", carb);
            }

            if (proteina != null) {
                query.setParameter("proteina", proteina);
            }

            if (grasas != null) {
                query.setParameter("grasas", grasas);
            }

            // Ejecución de la consulta
            return query.getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
    }

}
