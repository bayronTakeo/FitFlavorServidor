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
    @Enumerated(EnumType.STRING)
    private TipoReceta tipoReceta;
    /**
     * Nombre de la receta.
     */
    private String nombre;
    /**
     * Duracion de la receta.
     */
    private Float duracion;
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
    private Float precio;
    /**
     * Lista de ingredientes que contiene la receta.
     */
    private String pasos;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RecetaIngrediente> ingredientes;

//    @ManyToOne
//    private Cliente cliente;
    public Receta(Integer id, TipoReceta tipoReceta, String nombre, Float duracion, boolean esVegetariano, boolean esVegano, Float precio, List<RecetaIngrediente> ingredientes) {
        this.id = id;
        this.tipoReceta = tipoReceta;
        this.nombre = nombre;
        this.duracion = duracion;
        this.esVegetariano = esVegetariano;
        this.esVegano = esVegano;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public Receta() {

    }
//
//    @XmlTransient
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

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
    public Float getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion the duration to be set
     */
    public void setDuracion(Float duracion) {
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
    public Float getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio the price to be set
     */
    public void setPrecio(Float precio) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
