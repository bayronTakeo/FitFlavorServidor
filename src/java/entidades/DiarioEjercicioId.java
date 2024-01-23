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
public class DiarioEjercicioId implements Serializable {

    private int diario;
    private int ejercicio;

    public DiarioEjercicioId(int diario, int ejercicio) {
        this.diario = diario;
        this.ejercicio = ejercicio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.diario;
        hash = 53 * hash + this.ejercicio;
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
        final DiarioEjercicioId other = (DiarioEjercicioId) obj;
        if (this.diario != other.diario) {
            return false;
        }
        if (this.ejercicio != other.ejercicio) {
            return false;
        }
        return true;
    }

    public void setDiario(int diario) {
        this.diario = diario;
    }

    public void setEjercicio(int ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getDiario() {
        return diario;
    }

    public int getEjercicio() {
        return ejercicio;
    }

    public DiarioEjercicioId() {
    }
}
