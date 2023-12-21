/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.DiscriminatorFormula;

/**
 * Esta clase contiene toda la informacion del usuario
 *
 * @author Bayron
 */
@NamedQueries({
    @NamedQuery(
            name = "signIn", query = "SELECT u FROM User u WHERE login = :email AND password = :contrasenia"
    ),})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula("privilegio")
@DiscriminatorValue("0")
@Table(name = "usuario", schema = "fitFlavor")
@XmlRootElement
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    private String email;

    private String nombreCompleto;

    private LocalDate fechaNacimiento;

    private int telefono;

    private String direccion;

    private int codigoPostal;

    private String contrasenia;

    @Enumerated(EnumType.ORDINAL)
    private EnumPrivilegios privilegio;

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setPrivilegio(EnumPrivilegios privilegio) {
        this.privilegio = privilegio;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public EnumPrivilegios getPrivilegio() {
        return privilegio;
    }

    public Usuario(Integer user_id, String email, String nombreCompleto, LocalDate fechaNacimiento, int telefono, String direccion, int codigoPostal, String contrasenia, EnumPrivilegios privilegio) {
        this.user_id = user_id;
        this.email = email;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.contrasenia = contrasenia;
        this.privilegio = privilegio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user_id != null ? user_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.user_id == null && other.user_id != null) || (this.user_id != null && !this.user_id.equals(other.user_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
