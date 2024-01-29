/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    ,
    @NamedQuery(
            name = "sacarDiarios", query = "SELECT d from Diario d "
    )
    ,
    @NamedQuery(
            name = "buscarPorFecha", query = "SELECT d from Diario d WHERE dia LIKE :diaDiario and d.cliente.user_id = :idCliente"
    )
    ,
  @NamedQuery(
            name = "buscarEjercicio",
            query = "SELECT d FROM Diario d JOIN d.listaEjercicios e WHERE d.dia LIKE :diaDiario AND d.cliente.user_id = :idCliente AND e.id = :idEjercicio"
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
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Ejercicio> listaEjercicios;
    /**
     * Lista de Recetas
     */
    @ManyToMany(mappedBy = "listaDiariosR", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Receta> listaRecetas;

    @ManyToOne
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private Date dia;

    private String comentarios;

    public Diario(Integer id, List<Ejercicio> listaEjercicios, List<Receta> listaRecetas, Cliente cliente, Date dia, String comentarios) {
        this.id = id;
        this.listaEjercicios = listaEjercicios;
        this.listaRecetas = listaRecetas;
        this.cliente = cliente;
        this.dia = dia;
        this.comentarios = comentarios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDia() {
        return dia;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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
    public List<Ejercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    /**
     *
     * @param listaEjercicios the listaEjercicios to set
     */
    public void setListaEjercicios(List<Ejercicio> listaEjercicios) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Diario)) {
            return false;
        }
        Diario other = (Diario) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return "Diario{"
                + "id=" + id
                + ", cliente=" + (cliente != null ? cliente.getUser_id() : "null")
                + ", dia=" + dia
                + ", comentarios='" + comentarios + '\''
                + ", listaEjercicios=" + listaEjercicios
                + ", listaRecetas=" + listaRecetas
                + '}';
    }

}
