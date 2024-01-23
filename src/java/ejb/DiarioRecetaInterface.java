/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.DiarioReceta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bayro
 */
public interface DiarioRecetaInterface {

    public void crearDiarioE(DiarioReceta diarioEjercicio) throws CreateException;

    public void eliminarDiario(DiarioReceta diario) throws DeleteException;

    public List<DiarioReceta> findAll() throws ReadException;

    public List<DiarioReceta> buscarPorFecha(Date fecha) throws ReadException;

    public DiarioReceta buscarPorId(Integer id) throws ReadException;

}
