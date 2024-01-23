/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Cliente;
import entidades.Diario;
import entidades.DiarioEjercicio;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bayro
 */
public interface DiarioEjercicioInterface {

    public void crearDiarioE(DiarioEjercicio diarioEjercicio) throws CreateException;

    public void eliminarDiario(DiarioEjercicio diario) throws DeleteException;

    public List<DiarioEjercicio> findAll() throws ReadException;

    public List<DiarioEjercicio> buscarPorFecha(Date fecha) throws ReadException;

    public DiarioEjercicio buscarPorId(Integer id) throws ReadException;

}
