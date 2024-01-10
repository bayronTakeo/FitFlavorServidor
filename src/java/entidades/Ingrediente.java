/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Esta clase guarda los atributos de ingrediente
 *
 * @author paula
 */
@NamedQueries({
    @NamedQuery(
            name = "buscarkCal", query = "SELECT i FROM Ingrediente i WHERE i.kCal = :kCal"
    )
    ,
    @NamedQuery(
            name = "buscarPrecio", query = "SELECT i FROM Ingrediente i WHERE i.precio = :precio"
    )
    ,
    @NamedQuery(
            name = "buscarCarbohidratos", query = "SELECT i FROM Ingrediente i WHERE i.Carbohidratos = :Carbohidratos"
    )
    ,
    @NamedQuery(
            name = "buscarProteinas", query = "SELECT i FROM Ingrediente i WHERE i.Proteinas = :Proteinas"
    )
    ,
    @NamedQuery(
            name = "buscarGrasas", query = "SELECT i FROM Ingrediente i WHERE i.Grasas = :Grasas"
    )
    ,
    @NamedQuery(
            name = "buscarNombre", query = "SELECT i FROM Ingrediente i WHERE i.Nombre = :Nombre"
    )
    ,
    @NamedQuery(
            name = "tipoIngrediente", query = "SELECT i FROM Ingrediente i WHERE i.tipoIngrediente = :tipoIngrediente"
    )
})

@Entity
@Table(name = "ingrediente", schema = "fitFlavor")
@XmlRootElement
public class Ingrediente implements Serializable {

    /**
     * Campo identificador para el ingrediente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Enumeracion de tipo ingrediente.
     */
    @Enumerated(EnumType.ORDINAL)
    private TipoIngrediente tipoIngrediente;
    /**
     * Nombre del ingrediente.
     */
    private String nombre;
    /**
     * Precio del ingrediente.
     */
    private float precio;
    /**
     * kCal del ingrediente.
     */
    private float kCal;
    /**
     * Carbohidratos del ingredientet.
     */
    private float carbohidratos;
    /**
     * Proteinas del ingrediente.
     */
    private float proteinas;
    /**
     * Grasas del ingrediente.
     */
    private float grasas;

    @ManyToMany(mappedBy = "ingredientes", fetch = FetchType.EAGER, cascade = ALL)
    private List<Receta> listaRecetas;

    public Ingrediente(Integer id, TipoIngrediente tipoIngrediente, String nombre, float precio, float kCal, float carbohidratos, float proteinas, float grasas, List<Receta> listaRecetas) {
        this.id = id;
        this.tipoIngrediente = tipoIngrediente;
        this.nombre = nombre;
        this.precio = precio;
        this.kCal = kCal;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.listaRecetas = listaRecetas;
    }

    public Ingrediente() {

    }

    @XmlTransient
    public List<Receta> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(List<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    /**
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id to be set.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return tipoIngrediente
     */
    public TipoIngrediente getTipoIngrediente() {
        return tipoIngrediente;
    }

    /**
     *
     * @param tipoIngrediente the type to be set
     */
    public void setTipoIngrediente(TipoIngrediente tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
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
     * @return kCal
     */
    public float getkCal() {
        return kCal;
    }

    /**
     *
     * @param kCal the calories to be set
     */
    public void setkCal(float kCal) {
        this.kCal = kCal;
    }

    /**
     *
     * @return carbohidratos
     */
    public float getCarbohidratos() {
        return carbohidratos;
    }

    /**
     *
     * @param carbohidratos the carbohydrates to be set
     */
    public void setCarbohidratos(float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    /**
     *
     * @return proteinas
     */
    public float getProteinas() {
        return proteinas;
    }

    /**
     *
     * @param proteinas the proteins to be set
     */
    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    /**
     *
     * @return grasas
     */
    public float getGrasas() {
        return grasas;
    }

    /**
     *
     * @param grasas the fats to be set
     */
    public void setGrasas(float grasas) {
        this.grasas = grasas;
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
