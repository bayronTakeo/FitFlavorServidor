/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ingrediente;
import entidades.Receta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;

/**
 *
 * @author paula
 */
public interface IngredienteInterface {

    public void deleteIngrediente(Ingrediente ingrediente) throws DeleteException;

    public void createIngrediente(Ingrediente ingrediente) throws CreateException;

    public void updateIngrediente(Ingrediente ingrediente) throws UpdateException;

    public List<Ingrediente> buscarkCals() throws ReadException;

    public List<Ingrediente> buscarPrecio() throws ReadException;

    public List<Ingrediente> buscarCarbohidratos() throws ReadException;

    public List<Ingrediente> buscarProteinas() throws ReadException;

    public List<Ingrediente> buscarGrasas() throws ReadException;

    public List<Ingrediente> buscarNombre() throws ReadException;

    public List<Ingrediente> tipoIngrediente() throws ReadException;

}
