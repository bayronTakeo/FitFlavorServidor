/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
            name = "sacarTodosIngredientes", query = "SELECT i from Ingrediente i"
    )
    ,
    @NamedQuery(
            name = "buscarkCal", query = "SELECT i FROM Ingrediente i WHERE i.kcal = :kcal"
    )
    ,
    @NamedQuery(
            name = "buscarPrecio", query = "SELECT i FROM Ingrediente i WHERE i.precio = :precio"
    )
    ,
    @NamedQuery(
            name = "buscarCarbohidratos", query = "SELECT i FROM Ingrediente i WHERE i.carbohidratos = :carbohidratos"
    )
    ,
    @NamedQuery(
            name = "buscarProteinas", query = "SELECT i FROM Ingrediente i WHERE i.proteinas = :proteinas"
    )
    ,
    @NamedQuery(
            name = "buscarGrasas", query = "SELECT i FROM Ingrediente i WHERE i.grasas = :grasas"
    )
    ,
    @NamedQuery(
            name = "buscarNombre", query = "SELECT i FROM Ingrediente i WHERE i.nombre = :nombre"
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
    private Float precio;
    /**
     * kcal del ingrediente.
     */
    private Float kcal;
    /**
     * Carbohidratos del ingredientet.
     */
    private Float carbohidratos;
    /**
     * Proteinas del ingrediente.
     */
    private Float proteinas;
    /**
     * Grasas del ingrediente.
     */
    private Float grasas;

    @OneToMany(mappedBy = "ingrediente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RecetaIngrediente> listaRecetas;

    @ManyToOne
    private Cliente cliente;

    public Ingrediente(Integer id, TipoIngrediente tipoIngrediente, String nombre, Float precio, Float kcal, Float carbohidratos, Float proteinas, Float grasas, List<RecetaIngrediente> listaRecetas) {
        this.id = id;
        this.tipoIngrediente = tipoIngrediente;
        this.nombre = nombre;
        this.precio = precio;
        this.kcal = kcal;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.listaRecetas = listaRecetas;

    }

    public Ingrediente() {

    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    @XmlTransient
    public List<RecetaIngrediente> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(List<RecetaIngrediente> listaRecetas) {
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
     * @return kcal
     */
    public Float getKcal() {
        return kcal;
    }

    /**
     *
     * @param kcal the calories to be set
     */
    public void setKcal(Float kcal) {
        this.kcal = kcal;
    }

    /**
     *
     * @return carbohidratos
     */
    public Float getCarbohidratos() {
        return carbohidratos;
    }

    /**
     *
     * @param carbohidratos the carbohydrates to be set
     */
    public void setCarbohidratos(Float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    /**
     *
     * @return proteinas
     */
    public Float getProteinas() {
        return proteinas;
    }

    /**
     *
     * @param proteinas the proteins to be set
     */
    public void setProteinas(Float proteinas) {
        this.proteinas = proteinas;
    }

    /**
     *
     * @return grasas
     */
    public Float getGrasas() {
        return grasas;
    }

    /**
     *
     * @param grasas the fats to be set
     */
    public void setGrasas(Float grasas) {
        this.grasas = grasas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Ingrediente other = (Ingrediente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingrediente{"
                + "id=" + id
                + ", tipoIngrediente=" + tipoIngrediente
                + ", nombre='" + nombre + '\''
                + ", precio=" + precio
                + ", kcal=" + kcal
                + ", carbohidratos=" + carbohidratos
                + ", proteinas=" + proteinas
                + ", grasas=" + grasas
                + ", listaRecetas=" + listaRecetas
                + ", cliente=" + cliente
                + '}';
    }

}
