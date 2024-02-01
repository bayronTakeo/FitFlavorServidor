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

/**
 *
 * @author Bayron
 */
public interface RecetaIngredienteInterface {

    public void createRecetaIng(RecetaIngrediente recetaIng) throws CreateException;

    public void deleteRecetaIng(RecetaIngrediente recetaIng) throws DeleteException;

    public void editarRecetaIng(RecetaIngrediente recetaIng) throws UpdateException;

    public List<RecetaIngrediente> findAll() throws ReadException;

    public RecetaIngrediente buscarPorId(Integer id) throws ReadException;
}
