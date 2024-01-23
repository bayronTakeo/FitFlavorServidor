/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Esta clase guarda una lista de dias, ejercicios y recetas
 *
 * @author gaizka
 */
@Entity
@Table(name = "diario", schema = "fitFlavor")
@NamedQueries({
    @NamedQuery(
            name = "ejercicio", query = "SELECT e FROM Diario d JOIN d.listaEjercicios e"
    )
    ,
    @NamedQuery(
            name = "receta", query = "SELECT r FROM Diario d JOIN d.listaRecetas r"
    )

})

@XmlRootElement
public class Diario implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Campo identificador para el Diario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Lista de Ejercicios.
     */
    @OneToMany(mappedBy = "diario", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<diarioEjercicio> listaEjercicios;
    /**
     * Lista de Recetas
     */
    @ManyToMany(mappedBy = "listaDiariosR", fetch = FetchType.EAGER, cascade = ALL)
    private List<Receta> listaRecetas;

    public Diario(Integer id, List<diarioEjercicio> listaEjercicios, List<Receta> listaRecetas) {
        this.id = id;
        this.listaEjercicios = listaEjercicios;
        this.listaRecetas = listaRecetas;

    }

    public Diario() {
    }

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
     * @return the ListaEjercicios
     */
    @XmlTransient
    public List<diarioEjercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    /**
     *
     * @param listaEjercicios the listaEjercicios to set
     */
    public void setListaEjercicios(List<diarioEjercicio> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }

    /**
     *
     * @return the ListaRecetas
     */
    @XmlTransient
    public List<Receta> getListaRecetas() {
        return listaRecetas;
    }

    /**
     *
     * @param listaRecetas the listaEjercicios to set
     */
    public void setListaRecetas(List<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
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
