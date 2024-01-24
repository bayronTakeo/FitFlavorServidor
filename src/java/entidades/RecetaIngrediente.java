/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@IdClass(RecetaIngredienteId.class)
@XmlRootElement
public class RecetaIngrediente implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(
            name = "receta_id",
            insertable = false, updatable = false
    )
    private Receta receta;

    @Id
    @ManyToOne
    @JoinColumn(
            name = "ingrediente_id",
            insertable = false, updatable = false
    )
    private Ingrediente ingrediente;

    private Float cantidad;

    public RecetaIngrediente(Receta receta, Ingrediente ingrediente, Float cantidad) {
        this.receta = receta;
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }

    public RecetaIngrediente() {
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
