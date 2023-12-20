/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Esta clase guarda los atributos de ingrediente
 * @author paula
 */
@Entity
@Table(name = "ingrediente", schema = "fitFlavor")
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

}
