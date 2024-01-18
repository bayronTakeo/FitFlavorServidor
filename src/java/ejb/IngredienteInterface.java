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

    public void deleteIngrediente(Ingrediente ing) throws DeleteException;

    public void createIngrediente(Ingrediente ingrediente) throws CreateException;

    public void updateIngrediente(Ingrediente ingrediente) throws UpdateException;

    public List<Ingrediente> buscarkCal(float kCal) throws ReadException;

    public List<Ingrediente> buscarPrecio(float precio) throws ReadException;

    public List<Ingrediente> buscarCarbohidratos(float carbohidratos) throws ReadException;

    public List<Ingrediente> buscarProteinas(float proteinas) throws ReadException;

    public List<Ingrediente> buscarGrasas(float grasas) throws ReadException;

    public List<Ingrediente> buscarNombre(String nombre) throws ReadException;

    public List<Ingrediente> tipoIngrediente(String tipoIngrediente) throws ReadException;

    public Ingrediente buscarPorId(Integer id) throws ReadException;

}
