package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@NamedQueries({
    @NamedQuery(
            name = "sacarTodos", query = "SELECT u from Cliente u "
    )
    ,
    @NamedQuery(
            name = "buscarCliente", query = "SELECT u from Cliente u WHERE email = :usrValor "
    )
    ,
    @NamedQuery(
            name = "buscarPorTelefono", query = "SELECT u from Cliente u  WHERE telefono = :usrTelefono"
    ),})
@Entity

@DiscriminatorValue("USUARIO")
@XmlRootElement
public class Cliente extends Usuario {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.ORDINAL)
    private EnumSexo sexo;

    private float peso;

    @Enumerated(EnumType.ORDINAL)
    private EnumObjetivo objetivo;

    private Integer altura;

    @XmlTransient
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Receta> recetasUsu;

    @XmlTransient
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Diario> diario;

    public Cliente(EnumSexo sexo, float peso, EnumObjetivo objetivo, Integer altura, List<Receta> recetasUsu, List<Ingrediente> ingredientes, List<Ejercicio> ejercicios, List<Diario> diario, Integer user_id, String email, String nombreCompleto, Date fechaNacimiento, int telefono, String direccion, int codigoPostal, String contrasenia, EnumPrivilegios privilegio) {
        super(user_id, email, nombreCompleto, fechaNacimiento, telefono, direccion, codigoPostal, contrasenia, privilegio);
        this.sexo = sexo;
        this.peso = peso;
        this.objetivo = objetivo;
        this.altura = altura;
        this.recetasUsu = recetasUsu;

        this.diario = diario;
    }

    // Constructor por defecto sin argumentos
    public Cliente() {
        super();
    }

    public void setDiario(List<Diario> diario) {
        this.diario = diario;
    }

    @XmlTransient
    public List<Diario> getDiario() {
        return diario;
    }

    public void setRecetasUsu(List<Receta> recetasUsu) {
        this.recetasUsu = recetasUsu;
    }

    @XmlTransient
    public List<Receta> getRecetasUsu() {
        return recetasUsu;
    }

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

    public Integer getAltura() {
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

    public void setAltura(Integer altura) {
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
