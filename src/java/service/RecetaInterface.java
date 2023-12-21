/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidades.Receta;
import excepciones.DeleteException;

/**
 *
 * @author paula
 */
public interface RecetaInterface {
    
    public void deleteReceta(Receta receta) throws DeleteException;
    
}
