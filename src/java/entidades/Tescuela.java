/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tescuela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tescuela.findAll", query = "SELECT t FROM Tescuela t"),
    @NamedQuery(name = "Tescuela.findByTescuelacodigo", query = "SELECT t FROM Tescuela t WHERE t.tescuelacodigo = :tescuelacodigo"),
    @NamedQuery(name = "Tescuela.findByTescuelanombre", query = "SELECT t FROM Tescuela t WHERE t.tescuelanombre = :tescuelanombre"),
    @NamedQuery(name = "Tescuela.findByTfacultadcodigo", query = "SELECT t FROM Tescuela t WHERE t.tfacultadcodigo = :tfacultadcodigo")})
public class Tescuela implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tescuelacodigo")
    private Long tescuelacodigo;
    @Size(max = 50)
    @Column(name = "tescuelanombre")
    private String tescuelanombre;
    @Column(name = "tfacultadcodigo")
    private BigInteger tfacultadcodigo;
    @OneToMany(mappedBy = "tescuelacodigo")
    private List<Tcarrera> tcarreraList;
    @JoinColumn(name = "tescueladirector", referencedColumnName = "tusuariocedula")
    @ManyToOne
    private Tusuario tescueladirector;
    @JoinColumn(name = "tescuelacodigo", referencedColumnName = "tfacultadcodigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Tfacultad tfacultad;

    public Tescuela() {
    }

    public Tescuela(Long tescuelacodigo) {
        this.tescuelacodigo = tescuelacodigo;
    }

    public Long getTescuelacodigo() {
        return tescuelacodigo;
    }

    public void setTescuelacodigo(Long tescuelacodigo) {
        this.tescuelacodigo = tescuelacodigo;
    }

    public String getTescuelanombre() {
        return tescuelanombre;
    }

    public void setTescuelanombre(String tescuelanombre) {
        this.tescuelanombre = tescuelanombre;
    }

    public BigInteger getTfacultadcodigo() {
        return tfacultadcodigo;
    }

    public void setTfacultadcodigo(BigInteger tfacultadcodigo) {
        this.tfacultadcodigo = tfacultadcodigo;
    }

    @XmlTransient
    public List<Tcarrera> getTcarreraList() {
        return tcarreraList;
    }

    public void setTcarreraList(List<Tcarrera> tcarreraList) {
        this.tcarreraList = tcarreraList;
    }

    public Tusuario getTescueladirector() {
        return tescueladirector;
    }

    public void setTescueladirector(Tusuario tescueladirector) {
        this.tescueladirector = tescueladirector;
    }

    public Tfacultad getTfacultad() {
        return tfacultad;
    }

    public void setTfacultad(Tfacultad tfacultad) {
        this.tfacultad = tfacultad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tescuelacodigo != null ? tescuelacodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tescuela)) {
            return false;
        }
        Tescuela other = (Tescuela) object;
        if ((this.tescuelacodigo == null && other.tescuelacodigo != null) || (this.tescuelacodigo != null && !this.tescuelacodigo.equals(other.tescuelacodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tescuela[ tescuelacodigo=" + tescuelacodigo + " ]";
    }
    
}
