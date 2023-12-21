/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase Dia guarda los atributos de dias
 *
 * @author gaizka
 */
@Entity
@Table(name = "Diario", schema = "fitFlavor")

@XmlRootElement
class Dia implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Campo identificador para el Diario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Date de la fecha
     */
    private Date fecha;
    /**
     * La hora del dia
     */
    private Double hora;

    /**
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id the id to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha the fecha to be set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return the hota
     */
    public Double getHora() {
        return hora;
    }

    /**
     *
     * @param hora the hora to be set
     */
    public void setHora(Double hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getClass() != null ? getClass().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((super.getClass() == null && other.getClass() != null) || (super.getClass() != null && !super.getClass().equals(other.getClass()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
