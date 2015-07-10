/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ramiro
 */
@Entity
@Table(name = "tcalificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcalificacion.findAll", query = "SELECT t FROM Tcalificacion t"),
    @NamedQuery(name = "Tcalificacion.findByTcalificacioncodigo", query = "SELECT t FROM Tcalificacion t WHERE t.tcalificacioncodigo = :tcalificacioncodigo"),
    @NamedQuery(name = "Tcalificacion.findByTcalificacionnombre", query = "SELECT t FROM Tcalificacion t WHERE t.tcalificacionnombre = :tcalificacionnombre")})
public class Tcalificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tcalificacioncodigo")
    private Long tcalificacioncodigo;
    @Size(max = 50)
    @Column(name = "tcalificacionnombre")
    private String tcalificacionnombre;
    @OneToMany(mappedBy = "tcalificacioncodigo")
    private List<Tevidencia> tevidenciaList;
    @JoinColumn(name = "tusuariocedula", referencedColumnName = "tusuariocedula")
    @ManyToOne
    private Tusuario tusuariocedula;
    @JoinColumn(name = "tindicadorcodigo", referencedColumnName = "tindicadorcodigo")
    @ManyToOne
    private Tindicador tindicadorcodigo;
    @JoinColumn(name = "tcalculocodigo", referencedColumnName = "tcalculocodigo")
    @ManyToOne(optional = false)
    private Tcalculo tcalculocodigo;

    public Tcalificacion() {
    }

    public Tcalificacion(Long tcalificacioncodigo) {
        this.tcalificacioncodigo = tcalificacioncodigo;
    }

    public Long getTcalificacioncodigo() {
        return tcalificacioncodigo;
    }

    public void setTcalificacioncodigo(Long tcalificacioncodigo) {
        this.tcalificacioncodigo = tcalificacioncodigo;
    }

    public String getTcalificacionnombre() {
        return tcalificacionnombre;
    }

    public void setTcalificacionnombre(String tcalificacionnombre) {
        this.tcalificacionnombre = tcalificacionnombre;
    }

    @XmlTransient
    public List<Tevidencia> getTevidenciaList() {
        return tevidenciaList;
    }

    public void setTevidenciaList(List<Tevidencia> tevidenciaList) {
        this.tevidenciaList = tevidenciaList;
    }

    public Tusuario getTusuariocedula() {
        return tusuariocedula;
    }

    public void setTusuariocedula(Tusuario tusuariocedula) {
        this.tusuariocedula = tusuariocedula;
    }

    public Tindicador getTindicadorcodigo() {
        return tindicadorcodigo;
    }

    public void setTindicadorcodigo(Tindicador tindicadorcodigo) {
        this.tindicadorcodigo = tindicadorcodigo;
    }

    public Tcalculo getTcalculocodigo() {
        return tcalculocodigo;
    }

    public void setTcalculocodigo(Tcalculo tcalculocodigo) {
        this.tcalculocodigo = tcalculocodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcalificacioncodigo != null ? tcalificacioncodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcalificacion)) {
            return false;
        }
        Tcalificacion other = (Tcalificacion) object;
        if ((this.tcalificacioncodigo == null && other.tcalificacioncodigo != null) || (this.tcalificacioncodigo != null && !this.tcalificacioncodigo.equals(other.tcalificacioncodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tcalificacion[ tcalificacioncodigo=" + tcalificacioncodigo + " ]";
    }
    
}
