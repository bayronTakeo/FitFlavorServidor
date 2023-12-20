/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Esta clase guarda una lista de dias, ejercicios y recetas
 * @author gaizka
 */
@Entity
@Table(name = "diario", schema = "fitFlavor")

@XmlRootElement
public class Diario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    /**
     * Campo identificador para el Diario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Lista de Dias.
     */
    private List<Dia> listaDias;
    /**
     * Lista de Ejercicios.
     */
    private List<Ejercicio> listaEjercicios;
    /**
     * Lista de Recetas 
     */
    private List<Receta> listaRecetas;
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
     * @return the ListDia 
     */
    public List<Dia> getListaDias() {
        return listaDias;
    }
    /**
     * 
     * @param listaDias the listaDias to set
     */
    public void setListaDias(List<Dia> listaDias) {
        this.listaDias = listaDias;
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
    
    
    

    
    
}
