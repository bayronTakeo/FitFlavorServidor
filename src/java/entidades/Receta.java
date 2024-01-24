/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Esta clase guarda los atributos de receta
 *
 * @author paula
 */
@NamedQueries({
    @NamedQuery(
            name = "lista", query = "SELECT r FROM Receta r"
    )
    ,
 //   @NamedQuery(
   //         name = "listaIngrediente", query = "SELECT r FROM Receta r JOIN r.ingredientes i WHERE i = :ingrediente"
    //),

    @NamedQuery(
            name = "esVegano", query = "SELECT r FROM Receta r WHERE r.esVegano = :esVegano"
    )
    ,
    @NamedQuery(
            name = "esVegetariano", query = "SELECT r FROM Receta r WHERE r.esVegetariano = :esVegetariano"
    )
    ,
    @NamedQuery(
            name = "precio", query = "SELECT r FROM Receta r WHERE r.precio = :precio"
    )
})

@Entity
@Table(name = "receta", schema = "fitFlavor")

@XmlRootElement
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Campo identificador para la receta.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Enumeracion de tipo receta.
     */
    @Enumerated(EnumType.ORDINAL)
    private TipoReceta tipoReceta;
    /**
     * Nombre de la receta.
     */
    private String nombre;
    /**
     * Duracion de la receta.
     */
    private float duracion;
    /**
     * Boolean que indica si es vegetariano o no.
     */
    private boolean esVegetariano;
    /**
     * Boolean que indica si es vegano o no.
     */
    private boolean esVegano;
    /**
     * Precio de la receta.
     */
    private float precio;
    /**
     * Lista de ingredientes que contiene la receta.
     */
    private String pasos;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<RecetaIngrediente> ingredientes;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(schema = "fitFlavor", name = "diarioReceta")
    private List<Diario> listaDiariosR;

    @ManyToOne
    private Cliente cliente;

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Receta(Integer id, TipoReceta tipoReceta, String nombre, float duracion, boolean esVegetariano, boolean esVegano, float precio, List<RecetaIngrediente> ingredientes, List<Diario> listaDiariosR) {
        this.id = id;
        this.tipoReceta = tipoReceta;
        this.nombre = nombre;
        this.duracion = duracion;
        this.esVegetariano = esVegetariano;
        this.esVegano = esVegano;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.listaDiariosR = listaDiariosR;
    }

    public Receta() {

    }

    @XmlTransient
    public List<Diario> getListaDiariosR() {
        return listaDiariosR;
    }

    public void setListaDiariosR(List<Diario> listaDiariosR) {
        this.listaDiariosR = listaDiariosR;
    }

    /**
     *
     * @param id the id to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    /**
     *
     * @return tipoReceta
     */
    public TipoReceta getTipoReceta() {
        return tipoReceta;
    }

    /**
     *
     * @param tipoReceta the type to be set
     */
    public void setTipoReceta(TipoReceta tipoReceta) {
        this.tipoReceta = tipoReceta;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre the name to be set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return duracion.
     */
    public float getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion the duration to be set
     */
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    /**
     *
     * @return esVegetariano
     */
    public boolean isEsVegetariano() {
        return esVegetariano;
    }

    /**
     *
     * @param esVegetariano
     */
    public void setEsVegetariano(boolean esVegetariano) {
        this.esVegetariano = esVegetariano;
    }

    /**
     *
     * @return esVegano
     */
    public boolean isEsVegano() {
        return esVegano;
    }

    /**
     *
     * @param esVegano
     */
    public void setEsVegano(boolean esVegano) {
        this.esVegano = esVegano;
    }

    /**
     *
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio the price to be set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     *
     * @return ingrediente
     */
    @XmlTransient
    public List<RecetaIngrediente> getIngredientes() {
        return ingredientes;
    }

    /**
     *
     * @param ingredientes the ingredients to set
     */
    public void setIngredientes(List<RecetaIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
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
