/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tcalculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcalculo.findAll", query = "SELECT t FROM Tcalculo t"),
    @NamedQuery(name = "Tcalculo.findByTcalculocodigo", query = "SELECT t FROM Tcalculo t WHERE t.tcalculocodigo = :tcalculocodigo"),
    @NamedQuery(name = "Tcalculo.findByTcalculonombre", query = "SELECT t FROM Tcalculo t WHERE t.tcalculonombre = :tcalculonombre"),
    @NamedQuery(name = "Tcalculo.findByTcalculodescripcion", query = "SELECT t FROM Tcalculo t WHERE t.tcalculodescripcion = :tcalculodescripcion")})
public class Tcalculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcalculocodigo")
    private Long tcalculocodigo;
    @Size(max = 20)
    @Column(name = "tcalculonombre")
    private String tcalculonombre;
    @Size(max = 500)
    @Column(name = "tcalculodescripcion")
    private String tcalculodescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tcalculocodigo")
    private List<Tcalificacion> tcalificacionList;

    public Tcalculo() {
    }

    public Tcalculo(Long tcalculocodigo) {
        this.tcalculocodigo = tcalculocodigo;
    }

    public Long getTcalculocodigo() {
        return tcalculocodigo;
    }

    public void setTcalculocodigo(Long tcalculocodigo) {
        this.tcalculocodigo = tcalculocodigo;
    }

    public String getTcalculonombre() {
        return tcalculonombre;
    }

    public void setTcalculonombre(String tcalculonombre) {
        this.tcalculonombre = tcalculonombre;
    }

    public String getTcalculodescripcion() {
        return tcalculodescripcion;
    }

    public void setTcalculodescripcion(String tcalculodescripcion) {
        this.tcalculodescripcion = tcalculodescripcion;
    }

    @XmlTransient
    public List<Tcalificacion> getTcalificacionList() {
        return tcalificacionList;
    }

    public void setTcalificacionList(List<Tcalificacion> tcalificacionList) {
        this.tcalificacionList = tcalificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcalculocodigo != null ? tcalculocodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcalculo)) {
            return false;
        }
        Tcalculo other = (Tcalculo) object;
        if ((this.tcalculocodigo == null && other.tcalculocodigo != null) || (this.tcalculocodigo != null && !this.tcalculocodigo.equals(other.tcalculocodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tcalculo[ tcalculocodigo=" + tcalculocodigo + " ]";
    }
    
}
