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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gaizka
 */
public interface DiarioInterface {

    public void createDiario(Diario diario) throws CreateException;

    public void deleteDiario(Diario diario) throws DeleteException;

    public void actualizarDiario(Diario diario) throws UpdateException;

    public List<Diario> findAll() throws ReadException;

    public Diario buscarPorId(Integer id) throws ReadException;

    public Diario buscarPorFecha(String diaDiario, Integer idCliente) throws ReadException;

    public Diario buscarPorFecha(String diaDiario, Integer idCliente, Integer idEjercicio) throws ReadException;

}
