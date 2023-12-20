/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase guarda los atributos de Ejercicios
 * @author gaizka
 */
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
    
    

}
