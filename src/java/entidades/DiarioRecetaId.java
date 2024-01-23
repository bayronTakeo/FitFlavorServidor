/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author bayro
 */
public class DiarioRecetaId implements Serializable {

    private int diario;
    private int receta;

    public DiarioRecetaId(int diario, int receta) {
        this.diario = diario;
        this.receta = receta;
    }

    public DiarioRecetaId() {
    }

    public int getDiario() {
        return diario;
    }

    public int getReceta() {
        return receta;
    }

    public void setDiario(int diario) {
        this.diario = diario;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.diario;
        hash = 47 * hash + this.receta;
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
        final DiarioRecetaId other = (DiarioRecetaId) obj;
        if (this.diario != other.diario) {
            return false;
        }
        if (this.receta != other.receta) {
            return false;
        }
        return true;
    }

}
