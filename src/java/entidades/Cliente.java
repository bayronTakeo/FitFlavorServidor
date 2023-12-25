package entidades;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * Esta clase contiene toda la informacion del cliente
 *
 * @author Bayron
 */
@Entity
@Table(name = "cliente", schema = "fitFlavor")
@DiscriminatorValue("1")
@XmlRootElement
public class Cliente extends Usuario {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.ORDINAL)
    private EnumSexo sexo;

    private float peso;

    @Enumerated(EnumType.ORDINAL)
    private EnumObjetivo objetivo;

    private int altura;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Receta> recetasUsu;

    public Cliente(EnumSexo sexo, float peso, EnumObjetivo objetivo, int altura, List<Receta> recetasUsu, Integer user_id, String email, String nombreCompleto, LocalDate fechaNacimiento, int telefono, String direccion, int codigoPostal, String contrasenia, EnumPrivilegios privilegio) {
        super(user_id, email, nombreCompleto, fechaNacimiento, telefono, direccion, codigoPostal, contrasenia, privilegio);
        this.sexo = sexo;
        this.peso = peso;
        this.objetivo = objetivo;
        this.altura = altura;
        this.recetasUsu = recetasUsu;
    }

    public void setRecetasUsu(List<Receta> recetasUsu) {
        this.recetasUsu = recetasUsu;
    }

    public List<Receta> getRecetasUsu() {
        return recetasUsu;
    }

    @XmlTransient
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public EnumSexo getSexo() {
        return sexo;
    }

    public float getPeso() {
        return peso;
    }

    public EnumObjetivo getObjetivo() {
        return objetivo;
    }

    public int getAltura() {
        return altura;
    }

    public void setSexo(EnumSexo sexo) {
        this.sexo = sexo;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setObjetivo(EnumObjetivo objetivo) {
        this.objetivo = objetivo;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getUser_id() != null ? getUser_id().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((super.getUser_id() == null && other.getUser_id() != null) || (super.getUser_id() != null && !super.getUser_id().equals(other.getUser_id()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
