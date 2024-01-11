/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
public interface RecetaInterface {

    public void deleteReceta(Receta receta) throws DeleteException;

    public void createReceta(Receta receta) throws CreateException;

    public void updateReceta(Receta receta) throws UpdateException;

    public List<Receta> listaRecetas() throws ReadException;

  //  public List<Receta> listaIngredientes() throws ReadException;

    public List<Receta> vegano(boolean esVegano) throws ReadException;

    public List<Receta> vegetariano(boolean esVegano) throws ReadException;

    public List<Receta> precio(float precio) throws ReadException;

}
