/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tpersona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tpersona.findAll", query = "SELECT t FROM Tpersona t"),
    @NamedQuery(name = "Tpersona.findByTpersonacedula", query = "SELECT t FROM Tpersona t WHERE t.tpersonacedula = :tpersonacedula"),
    @NamedQuery(name = "Tpersona.findByTpersonanombre", query = "SELECT t FROM Tpersona t WHERE t.tpersonanombre = :tpersonanombre"),
    @NamedQuery(name = "Tpersona.findByTpersonaapellido", query = "SELECT t FROM Tpersona t WHERE t.tpersonaapellido = :tpersonaapellido"),
    @NamedQuery(name = "Tpersona.findByTpersonaprovincia", query = "SELECT t FROM Tpersona t WHERE t.tpersonaprovincia = :tpersonaprovincia"),
    @NamedQuery(name = "Tpersona.findByTpersonaciudad", query = "SELECT t FROM Tpersona t WHERE t.tpersonaciudad = :tpersonaciudad"),
    @NamedQuery(name = "Tpersona.findByTpersonadireccion", query = "SELECT t FROM Tpersona t WHERE t.tpersonadireccion = :tpersonadireccion"),
    @NamedQuery(name = "Tpersona.findByTpersonatelefonofijo", query = "SELECT t FROM Tpersona t WHERE t.tpersonatelefonofijo = :tpersonatelefonofijo"),
    @NamedQuery(name = "Tpersona.findByTpersonatelefonomovil", query = "SELECT t FROM Tpersona t WHERE t.tpersonatelefonomovil = :tpersonatelefonomovil"),
    @NamedQuery(name = "Tpersona.findByTpersonaemail", query = "SELECT t FROM Tpersona t WHERE t.tpersonaemail = :tpersonaemail")})
public class Tpersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tpersonacedula")
    private String tpersonacedula;
    @Size(max = 20)
    @Column(name = "tpersonanombre")
    private String tpersonanombre;
    @Size(max = 20)
    @Column(name = "tpersonaapellido")
    private String tpersonaapellido;
    @Size(max = 20)
    @Column(name = "tpersonaprovincia")
    private String tpersonaprovincia;
    @Size(max = 20)
    @Column(name = "tpersonaciudad")
    private String tpersonaciudad;
    @Size(max = 20)
    @Column(name = "tpersonadireccion")
    private String tpersonadireccion;
    @Column(name = "tpersonatelefonofijo")
    private Integer tpersonatelefonofijo;
    @Column(name = "tpersonatelefonomovil")
    private Integer tpersonatelefonomovil;
    @Size(max = 20)
    @Column(name = "tpersonaemail")
    private String tpersonaemail;
    @JoinColumn(name = "tpersonacedula", referencedColumnName = "tusuariocedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tusuario tusuario;

    public Tpersona() {
    }

    public Tpersona(String tpersonacedula) {
        this.tpersonacedula = tpersonacedula;
    }

    public String getTpersonacedula() {
        return tpersonacedula;
    }

    public void setTpersonacedula(String tpersonacedula) {
        this.tpersonacedula = tpersonacedula;
    }

    public String getTpersonanombre() {
        return tpersonanombre;
    }

    public void setTpersonanombre(String tpersonanombre) {
        this.tpersonanombre = tpersonanombre;
    }

    public String getTpersonaapellido() {
        return tpersonaapellido;
    }

    public void setTpersonaapellido(String tpersonaapellido) {
        this.tpersonaapellido = tpersonaapellido;
    }

    public String getTpersonaprovincia() {
        return tpersonaprovincia;
    }

    public void setTpersonaprovincia(String tpersonaprovincia) {
        this.tpersonaprovincia = tpersonaprovincia;
    }

    public String getTpersonaciudad() {
        return tpersonaciudad;
    }

    public void setTpersonaciudad(String tpersonaciudad) {
        this.tpersonaciudad = tpersonaciudad;
    }

    public String getTpersonadireccion() {
        return tpersonadireccion;
    }

    public void setTpersonadireccion(String tpersonadireccion) {
        this.tpersonadireccion = tpersonadireccion;
    }

    public Integer getTpersonatelefonofijo() {
        return tpersonatelefonofijo;
    }

    public void setTpersonatelefonofijo(Integer tpersonatelefonofijo) {
        this.tpersonatelefonofijo = tpersonatelefonofijo;
    }

    public Integer getTpersonatelefonomovil() {
        return tpersonatelefonomovil;
    }

    public void setTpersonatelefonomovil(Integer tpersonatelefonomovil) {
        this.tpersonatelefonomovil = tpersonatelefonomovil;
    }

    public String getTpersonaemail() {
        return tpersonaemail;
    }

    public void setTpersonaemail(String tpersonaemail) {
        this.tpersonaemail = tpersonaemail;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpersonacedula != null ? tpersonacedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tpersona)) {
            return false;
        }
        Tpersona other = (Tpersona) object;
        if ((this.tpersonacedula == null && other.tpersonacedula != null) || (this.tpersonacedula != null && !this.tpersonacedula.equals(other.tpersonacedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tpersona[ tpersonacedula=" + tpersonacedula + " ]";
    }
    
}
