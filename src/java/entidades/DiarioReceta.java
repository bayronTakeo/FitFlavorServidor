/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bayro
 */
@NamedQueries({
    @NamedQuery(
            name = "sacarFechaR", query = "SELECT d from DiarioReceta d WHERE fecha = :fecha"
    )
    ,
     @NamedQuery(
            name = "sacarDiarioR", query = "SELECT d from DiarioReceta "
    ),})
@Entity
@IdClass(DiarioRecetaId.class)
@XmlRootElement
public class DiarioReceta implements Serializable {

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
            name = "receta_id",
            insertable = false, updatable = false
    )
    private Receta receta;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    public DiarioReceta(Diario diario, Receta receta, Date fecha) {
        this.diario = diario;
        this.receta = receta;
        this.fecha = fecha;
    }

    public DiarioReceta() {
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Receta getReceta() {
        return receta;
    }

    public Diario getDiario() {
        return diario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDiario(Diario diario) {
        this.diario = diario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.diario);
        hash = 61 * hash + Objects.hashCode(this.receta);
        hash = 61 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiarioReceta other = (DiarioReceta) obj;
        if (!Objects.equals(this.diario, other.diario)) {
            return false;
        }
        if (!Objects.equals(this.receta, other.receta)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

}
