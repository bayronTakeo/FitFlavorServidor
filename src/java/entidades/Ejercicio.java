/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.Cliente;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Esta clase guarda los atributos de Ejercicios
 *
 * @author gaizka
 */
@NamedQueries({
    @NamedQuery(
            name = "todosEjercicios", query = "SELECT e from Ejercicio e "
    )
    ,
    @NamedQuery(
            name = "brazo", query = "SELECT e FROM Ejercicio e WHERE e.tipoEjercicio = 'Brazo'"
    )
    ,@NamedQuery(
            name = "pierna", query = "SELECT e FROM Ejercicio e WHERE tipoEjercicio = :pierna"
    )
    ,@NamedQuery(
            name = "pecho", query = "SELECT e FROM Ejercicio e WHERE tipoEjercicio = :pecho"
    )
    ,@NamedQuery(
            name = "espalda", query = "SELECT e FROM Ejercicio e WHERE tipoEjercicio = :espalda"
    )
    ,@NamedQuery(
            name = "buscarIntensidad", query = "SELECT e FROM Ejercicio e Where intensidad = :intensidad"
    )})

@Entity
@Table(name = "ejercicio", schema = "fitFlavor")

@XmlRootElement
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Campo identificador para el Diario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Nombre del Ejercicio
     */
    private String nombre;
    /**
     * Tipo Ejercicio
     */
    @Enumerated(EnumType.STRING)
    private TipoEjercicio tipoEjercicio;
    /**
     * Descripcion del Ejercicio
     */
    private String descripcion;
    /**
     * Duracion del Ejercicio
     */
    private float duracion;
    /**
     * Kcal quemadas con el Ejercicio
     */
    private int kcalQuemadas;
    /**
     * Intensidad del Ejercicio
     */
    private String intensidad;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(schema = "fitFlavor", name = "diarioEjercicio")
    private List<Diario> listaDiariosE;

    public Ejercicio(Integer id, String nombre, TipoEjercicio tipoEjercicio, String descripcion, float duracion, int kcalQuemadas, String intensidad, List<Diario> listaDiariosE) {
        this.id = id;
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.kcalQuemadas = kcalQuemadas;
        this.intensidad = intensidad;
        this.listaDiariosE = listaDiariosE;
    }

    public Ejercicio() {

    }

    public void setListaDiarios(List<Diario> ListaDiarios) {
        this.listaDiariosE = ListaDiarios;
    }

    public List<Diario> getListaDiarios() {
        return listaDiariosE;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre the nombre to be set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return the tipoEjercicio
     */
    public TipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;
    }

    /**
     *
     * @param tipoEjercicio the tipoEjercicio to be set
     */
    public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    /**
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion the descripcion to be set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return the duracion
     */
    public float getDuracion() {
        return duracion;
    }

    /**
     *
     * @param duracion the duracion to be set
     */
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    /**
     *
     * @return the KcalQuemadas
     */
    public int getKcalQuemadas() {
        return kcalQuemadas;
    }

    /**
     *
     * @param kcalQuemadas the kcalQuemadas to be set
     */
    public void setKcalQuemadas(int kcalQuemadas) {
        this.kcalQuemadas = kcalQuemadas;
    }

    /**
     *
     * @return the intensidad
     */
    public String getIntensidad() {
        return intensidad;
    }

    /**
     *
     * @param intensidad the intensidad to be set
     */
    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    /**
     *
     * @return the listaDiariosE
     */
    public List<Diario> getListaDiariosE() {
        return listaDiariosE;
    }

    /**
     *
     * @param listaDiariosE the listaDiariosE to be set
     */
    public void setListaDiariosE(List<Diario> ListaDiariosE) {
        this.listaDiariosE = listaDiariosE;
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
