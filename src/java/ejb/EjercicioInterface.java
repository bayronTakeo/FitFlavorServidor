/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ejercicio;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.List;


/**
 *
 * @author gaizka
 */
public interface EjercicioInterface {
    
    public void createEjercicio(Ejercicio ejercicio) throws CreateException;
    
    public List<Ejercicio> listaBrazo() throws ReadException;
    
    public List<Ejercicio> listaPierna() throws ReadException;
    
    public List<Ejercicio> listaPecho() throws ReadException;
    
    public List<Ejercicio> listaEspalda() throws ReadException;
    
    public List<Ejercicio> listaIntensidad() throws ReadException;
    
    public void updateEjercicio(Ejercicio ejercicio) throws UpdateException;
    
    public void deleteEjercicio(Ejercicio ejercicio) throws DeleteException;
            
}
