/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bayron
 */
@NamedQueries({
    @NamedQuery(
            name = "sacarRecetaIng", query = "SELECT r from RecetaIngrediente r "
    ),})
@Entity
@XmlRootElement
public class RecetaIngrediente implements Serializable {

    @EmbeddedId
    private RecetaIngredienteId recetaIngredienteId;

    @MapsId("id")
    @ManyToOne
    private Receta receta;

    @MapsId("id")
    @ManyToOne
    private Ingrediente ingrediente;

    private Float cantidad;

    public RecetaIngrediente(RecetaIngredienteId recetaIngredienteId, Receta receta, Ingrediente ingrediente, Float cantidad) {
        this.recetaIngredienteId = recetaIngredienteId;
        this.receta = receta;
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    public RecetaIngrediente() {
    }

    public void setRecetaIngredienteId(RecetaIngredienteId recetaIngredienteId) {
        this.recetaIngredienteId = recetaIngredienteId;
    }

    public RecetaIngredienteId getRecetaIngredienteId() {
        return recetaIngredienteId;
    }

    public Receta getReceta() {
        return receta;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

}
