/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author bayro
 */
@Entity
@IdClass(DiarioEjercicioId.class)
public class DiarioEjercicio implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(
            name = "diario_id",
            insertable = false, updatable = false
    )
    private Diario diario;

    @Id
    @ManyToOne
    @JoinColumn(
            name = "ejercicio_id",
            insertable = false, updatable = false
    )
    private Ejercicio ejercicio;

    private Date fecha;

    public DiarioEjercicio() {
    }

    public DiarioEjercicio(Diario diario, Ejercicio ejercicio, Date fecha) {
        this.diario = diario;
        this.ejercicio = ejercicio;
        this.fecha = fecha;
    }

    public Diario getDiario() {
        return diario;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
